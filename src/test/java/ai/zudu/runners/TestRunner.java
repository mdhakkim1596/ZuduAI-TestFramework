package ai.zudu.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ai.zudu.stepDefs",
        plugin = {"pretty"},
        tags = "@smoke"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
