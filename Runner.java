package OpenCartProject;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//Features/",

		plugin = {"pretty","html:target/Report/OpenCartDemoProjectReport.html"}
		)
public class Runner extends AbstractTestNGCucumberTests {

}
 
