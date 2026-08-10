package ai.zudu;

import ai.zudu.config.ConfigReader;
import ai.zudu.driver.DriverFactory;
import ai.zudu.pages.LandingPage;
import ai.zudu.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(groups = {"smoke"}, priority = 1)
    public void verifyLoginPageNavigation(){

        // 1. Landing Page Object
        LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
        landingPage.clickLoginButton();

        // 2. Login Page Object
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(ConfigReader.getProperty("email"));
    }
}
