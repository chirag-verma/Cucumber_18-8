package MeerQATS_Cucumber.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "Feature//MeerQATS_Login.feature", },
        glue = "MeerQATS_Cucumber.StepDefinitions",

		monochrome = true, 
		plugin = { "pretty", "html:Reports" },
		
		tags={"@Second"},
		strict=true
		

)

public class TestRunner {

}
