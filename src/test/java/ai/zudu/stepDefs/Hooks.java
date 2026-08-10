package ai.zudu.stepDefs;

import ai.zudu.config.ConfigReader;
import ai.zudu.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown(){
        DriverFactory.quitDriver();
    }

}
