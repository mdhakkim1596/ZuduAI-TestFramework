package ai.zudu.pages;

import ai.zudu.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    // 1. Create Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // 2. Locators
    private final By emailInputLocator = By.xpath("//input[contains(@placeholder,'Email')]");
    private final By continueButtonLocator = By.xpath("//button[contains(@type,'submit')]");

    // 3. Action methods
    public void enterEmail(String emailId){
        WaitUtils.waitForClickable(driver, emailInputLocator).sendKeys(emailId);
    }

    public void clickContinueButton(){
        WaitUtils.waitForClickable(driver, continueButtonLocator).click();
    }

    public void login(String emailId){
        enterEmail(emailId);
        clickContinueButton();
    }
}
