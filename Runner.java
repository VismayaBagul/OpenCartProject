package Registration;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//Features/Registration.feature/",
		plugin = {"pretty","html:target/Report/Registration.html"}
		)
public class Runner extends AbstractTestNGCucumberTests {

}
