package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features", glue = { "Steps" }, monochrome = true,  plugin = { "pretty" })

public class RunCucumberTest {
}
