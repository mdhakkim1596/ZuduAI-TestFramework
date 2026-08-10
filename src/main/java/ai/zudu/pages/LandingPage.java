package ai.zudu.pages;

import ai.zudu.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{

    // 1. Create Constructor
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    // 2. Locators
    private final By loginButtonLocator = By.xpath("//button[contains(text(),'Log in')]");

    // 3. Action methods
    public void clickLoginButton(){
        WaitUtils.waitForClickable(driver, loginButtonLocator).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
//        driver.findElement(loginButtonLocator).click();
    }
}
