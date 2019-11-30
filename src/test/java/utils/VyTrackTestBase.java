package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class VyTrackTestBase {
    @BeforeMethod
    public void setUp(){
        String url = ConfigurationReader.getProperty("vytrack");
        String userName = ConfigurationReader.getProperty("user_name");
        String password = ConfigurationReader.getProperty("password");
        //old version was WebDriver driver = BrowserFactory.getDriver("....") then we called by that obj.
        Driver.get().get(url);
        Driver.get().findElement(By.name("_username")).sendKeys(userName);
        Driver.get().findElement(By.name("_password")).sendKeys(password + Keys.ENTER);
    }

    @AfterMethod
    public void tearDown(){
        Wait.seconds(3);
        Driver.close();
    }
}
