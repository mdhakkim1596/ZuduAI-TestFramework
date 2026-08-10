package ai.zudu.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    // 1. Common Constructor
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
}
