package utils;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
    @BeforeMethod
    public void setUp(){
        String url = ConfigurationReader.getProperty("url2");
        //old version was WebDriver driver = BrowserFactory.getDriver("....") then we called by that obj.
        Driver.get().get(url);
        Driver.get().findElement(By.linkText("Registration Form")).click();
        Wait.seconds(3);
    }

    @AfterMethod
    public void tearDown(){
        Wait.seconds(3);
        Driver.close();
    }
}
