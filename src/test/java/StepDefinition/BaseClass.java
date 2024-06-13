package StepDefinition;



import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

/*parent class*/
public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginpg;
	public SearchCustomerPage  SearchCustPg;
	public AddNewCustomerPage addnewcustpg;
	public static Logger Log;
	public ReadConfig readConfig;
	
	//generate unique emailId
	public String generateEmailId() {
		return(RandomStringUtils.randomAlphabetic(5));
	}
}
