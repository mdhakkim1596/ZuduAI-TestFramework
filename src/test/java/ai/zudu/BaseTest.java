package ai.zudu;

import ai.zudu.config.ConfigReader;
import ai.zudu.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
