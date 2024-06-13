package StepDefinition;

import io.cucumber.java.en.Then;

public class CloseStef extends BaseClass {

	@Then("close browser")
	public void close_browser() {
	   
		driver.close();
		Log.info("Browser closed");
		//driver.quit();
	}
}
