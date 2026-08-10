package ai.zudu;

import ai.zudu.driver.DriverFactory;
import ai.zudu.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static Logger log = LogManager.getLogger(TestListener.class);
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentReportManager.getInstance();
        log.info("Test Suite Started: "+context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        extentTest.set(test);
        log.info("Test Started: "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");
        log.info("Test Passed: "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String base64Source = takesScreenshot.getScreenshotAs(OutputType.BASE64);
        String errorMessage = result.getThrowable().getMessage().split("\n")[0];
        extentTest.get().fail(errorMessage,
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Source).build());
        try {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String destination = System.getProperty("user.dir")
                    + "/reports/screenshots/" + result.getName() + " - " + timeStamp + ".png";
            FileUtils.copyFile(source, new File(destination));
//            extentTest.get().addScreenCaptureFromBase64String(base64Source);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.error("Test Failed: "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test Skipped");
        log.warn("Test Skipped: "+result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        log.info("Test Finished: "+context.getName());
    }
}
