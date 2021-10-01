package run;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features/Car.feature",glue="steps")
public class RunTest extends AbstractTestNGCucumberTests {

}
