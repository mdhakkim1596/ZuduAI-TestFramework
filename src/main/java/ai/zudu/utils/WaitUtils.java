package ai.zudu.utils;

import ai.zudu.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
//    private static WebDriverWait wait = new WebDriverWait(driver, ConfigReader.getProperty("timeout"));

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("timeout"))));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForVisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("timeout"))));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForInvisible(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("timeout"))));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
