package ai.zudu.stepDefs;

import ai.zudu.driver.DriverFactory;
import ai.zudu.pages.LandingPage;
import ai.zudu.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LandingPage landingPage;
    LoginPage loginPage;

    @Given("I am on the Zudu AI Landing Page")
    public void iAmOnTheZuduAiLandingPage(){
        landingPage = new LandingPage(DriverFactory.getDriver());
    }

    @When("I click the Login button")
    public void iClickTheLoginButton(){
        landingPage.clickLoginButton();
    }

    @And("I enter email {string}")
    public void iEnterEmail(String email){
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.enterEmail(email);
    }

    @And("I click the Continue button")
    public void iClickTheContinueButton(){
        loginPage.clickContinueButton();
    }

    @Then("I should be navigate to the password page")
    public void iShouldBeNavigateToThePasswordPage(){
        System.out.println("Navigated to password page successfully");
    }

}
