package TestRunner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(
		features = {".//Features/LoginFeature.feature"},
		glue = "StepDefinition",
		dryRun = false,
		monochrome = true,
		tags = "@Sanity",//scenarios under sanity will execute
	  //plugin = {"pretty","html:target/cucumber-reports/reports_html.html","json:target/cucumber-reports/report_json.json"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

//plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}

public class Run extends AbstractTestNGCucumberTests {
/*this class will be empty*/
	//monochrome=true it will remove unwanted character from console
	//we take dryRun=true or checking all steps from feature file implemented correctly in stefdefinition or not
}
// {"pretty","json:target/cucumber-reports/report_json.json","html:target/cucumber-reports/reports_html.html","junit:target/cucumber-reports/reports_xml.xml"}
/*we have run all feature that time just use features = ".//Features/"
 * */
 