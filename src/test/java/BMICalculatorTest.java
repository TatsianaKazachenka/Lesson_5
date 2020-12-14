import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BMICalculatorTest {
    @Test
    public void calculateKgCmsUnderweight(){
        calculateKgCms("31", "131", Constants.MESSAGE_UNDERWEIGHT);
    }

    @Test
    public void calculateKgCmsStarvation(){
        calculateKgCms("31", "151", Constants.MESSAGE_STARVATION);
    }

    @Test
    public void calculateKgCmsNormal(){
        calculateKgCms("31", "121", Constants.MESSAGE_NORMAL);
    }

    @Test
    public void calculateKgCmsOverweight(){
        calculateKgCms("31", "111", Constants.MESSAGE_OVERWEIGHT);
    }

    @Test
    public void calculateKgCmsObese(){
        calculateKgCms("31", "101", Constants.MESSAGE_OBESE);
    }

    private void calculateKgCms(String weightValue, String heightValue,
                                String expectedCategoryText){

        Utils utils = new Utils();
        utils.setPropertyDriver();
        WebDriver driver = new ChromeDriver();
        //1. open site https://healthunify.com/bmicalculator/
        utils.openSite(driver, Constants.SITE);
        //2. enter 80 in weight field
        utils.setValueByElementName(driver, Constants.WEIGHT_NAME, weightValue);
        //3. enter 180 in height field
        utils.setValueByElementName(driver, Constants.HEIGHT_NAME, heightValue);
        //4. click calculate btn
        utils.clickByElementName(driver, Constants.BTN_NAME);
        //5. check text "Your category is Normal" is displayed
        String actualCategoryText = driver.findElement(By.name(Constants.DESC_NAME)).getAttribute("value");
        String messageFull = Constants.MESSAGE + actualCategoryText;
        //5. check text "Your category is Normal" is displayed
        utils.checkResult(actualCategoryText, expectedCategoryText, messageFull);

        utils.closeDriver(driver);
    }

}

