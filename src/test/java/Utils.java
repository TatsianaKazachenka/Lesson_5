import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Utils {
    public void setPropertyDriver(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    public void setSite(WebDriver driver, String site){
        driver.get(site);
    }

    public void setValueByElementName(WebDriver driver, String name, String value){
        driver.findElement(By.name(name)).sendKeys(value);
    }

    public void clickByElementName(WebDriver driver, String name){
        driver.findElement(By.name(name)).click();
    }

    public void checkResult(String actualCategoryText, String expectedCategoryText, String message){
        Assert.assertEquals(actualCategoryText, expectedCategoryText, message);
    }

    public void closeDriver(WebDriver driver){
        driver.close();
    }
}
