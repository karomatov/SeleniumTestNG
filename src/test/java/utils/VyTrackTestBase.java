package utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class VyTrackTestBase {
    @BeforeMethod
    public void setUp(){
        String url = ConfigurationReader.getProperty("url");
        //old version was WebDriver driver = BrowserFactory.getDriver("....") then we called by that obj.
        Driver.get().get(url);
    }

    @AfterMethod
    public void tearDown(){
        Wait.seconds(3);
        Driver.close();
    }
}
