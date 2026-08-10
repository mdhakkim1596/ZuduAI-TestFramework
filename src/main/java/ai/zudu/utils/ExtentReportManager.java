package ai.zudu.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentSparkReporter sparkReporter;
    private static ExtentReports extent;

    static String repName;
    public static ExtentReports getInstance(){

        if(extent == null) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            repName = "Test-Report - " + timeStamp + ".html";
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + repName);
            sparkReporter.config().setDocumentTitle("Automation Test Reports");
            sparkReporter.config().setReportName("Functional Testing");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Application", "Zudu.ai");
            extent.setSystemInfo("Environment", "UAT");
            extent.setSystemInfo("Team", "QA Team");
            extent.setSystemInfo("Tester Name", "Mohamed Hakkim");
            extent.setSystemInfo("Browser", "Chrome, Edge, FireFox");
        }
        return extent;

    }

}
