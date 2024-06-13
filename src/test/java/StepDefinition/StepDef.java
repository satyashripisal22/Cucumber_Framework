package StepDefinition;

import java.io.File;

import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends BaseClass {
	
	//implementaion of .feature file-->stepDef
	@Before("@Sanity") //(order=1)we can use multiple before annotation with using order
	public void setup1() {
		
		Log = LogManager.getLogger(StepDef.class);
		
		readConfig = new ReadConfig();
		
		System.out.println("Setup1-sanity method executed");
		
		String browser = readConfig.getBrowser();
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;	
		case "msedge":
			driver = new EdgeDriver();
			break;	
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		
		/*System.setProperty("webdriver.chrome.driver", "C:/New folder/WorkSpace/New folder/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("114");
		//driver= new ChromeDriver(options);*/
		//driver = new ChromeDriver();
		Log.info("Setup1 executed...");
	}
	@Before("@regression")//(order=0)lower value first execute
	public void setup2() {
		/*System.setProperty("webdriver.chrome.driver", "C:/New folder/WorkSpace/New folder/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("114");
		driver= new ChromeDriver(options);*/
		Log = LogManager.getLogger("StefDef");
		
		System.out.println("Set Up2 method executed");
		
		driver = new ChromeDriver();
		
		Log.info("Set Up2 executed...");
	}
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
		/*System.setProperty("webdriver.chrome.driver", "C:/New folder/WorkSpace/New folder/chromedriver.exe/");
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("114");
		
		//WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(options);
		//driver = new ChromeDriver();*/
	    
	    loginpg = new LoginPage(driver);
	    
	    addnewcustpg = new AddNewCustomerPage(driver);
	    
	    SearchCustPg = new SearchCustomerPage(driver);
	    
	    Log.info("User launch Chrome Browser successfully");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
	    driver.get(URL);
	    Log.info("Url Opened");
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) {
	  loginpg.enterEmail(emailadd);
	  loginpg.enterPassword(password);
	  Log.info("EmailID and password entered");
	}

	@And("Click on Login")
	public void click_on_login() throws InterruptedException {
		Thread.sleep(2000);
	    loginpg.clickOnLoginButton();
	    Log.info("login button clicked");
	}
/////////****Login Feature****/////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	    String actualTitle = driver.getTitle();
	    //String expectedTitle = "Your store. Login";
	    if(actualTitle.equals(expectedTitle)) 
	    {
	    	
	    	Log.info("Test passed:Login feature : page title matched");
	    	
	    	Assert.assertTrue(true);
	    
	    }else {
	    	
	    	Assert.assertTrue(false);
	    	
	    	Log.warn("Test failed:Login feature : page title not matched");
	    }
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	
		Thread.sleep(2000);
		loginpg.clickOnLogoutButton();
		
		Log.info("user clicked on logout link");
	}

	/*@Then("close browser")
	public void close_browser() {
	   
		driver.close();
		Log.info("Browser closed");
		//driver.quit();
	}*/

	/////////////****AddNewCustomer****///////////////////
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	   String actualTitle = addnewcustpg.getPageTitle();
	   String expectedTitle = "Dashboard / nopCommerce administration";
	   
	   if(actualTitle.equals(expectedTitle))
	   {
		   Log.info("user can view dashboard: Test passed");
		   Assert.assertTrue(true);
	   }
	   else {
		   Assert.assertTrue(false);
		   
		   Log.warn("user can not view dashboard: Test failed");
	   }
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
	   addnewcustpg.clickOnCustomerLink_menu();
	   Log.info("Customer Menu clicked");
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
	    
		addnewcustpg.clickOnCustomerMenuItem();
	    
	    Log.info("Customer Menu Item clicked");
	   
	    Thread.sleep(2000);
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
	    addnewcustpg.clickOnAddnew();
	    
	    Log.info("clicked on Add new button");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    String actualTitle = addnewcustpg.getPageTitle();
	    String expectedTitle = "Add a new customer / nopCommerce administration";
	   
	    if(actualTitle.equals(expectedTitle)) 
	    {
	    	
	    	Log.info("User can view Add new customer page:Test passed");
			  
	    	Assert.assertTrue(true);//pass
		   }
		   else {
			   Assert.assertTrue(false);//fail
			   
			   Log.warn("User can not view Add new customer page:Test failed");
		   }
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	   // addnewcustpg.enterEmail("ds1@gmail.com");
		addnewcustpg.enterEmail(generateEmailId()+"@gmail.com");
	    addnewcustpg.enterPassword("test1");
	    addnewcustpg.enterFirstName("Prachi");
	    addnewcustpg.enterLastName("Gupta");
	    addnewcustpg.enterGender("Female");
	    addnewcustpg.enterDob("5/21/2023");
	    addnewcustpg.enterCompanyName("CodeStudio");
	    addnewcustpg.enterAdminContent("Admincontent");
	    addnewcustpg.enterManagerOfVendor("Vendor 2");
	    
	    Log.info("customer information entered");
	}

	@When("click on Save button")
	public void click_on_save_button() {
	    
		addnewcustpg.clickOnSave();
	    
		Log.info("click on save button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMessage) {
	    
		String bodyTag = driver.findElement(By.tagName("Body")).getText(); 
	
	    if(bodyTag.contains(expectedConfirmationMessage))
	    {
		
		Log.info("User can view confirmation message:Passed");
		
		Assert.assertTrue(true);
	
	    }else {
		
	    	Assert.assertTrue(false);
		
	    	Log.warn("User can view confirmation message:Failed");
	}
	    
	}
	
	///////////////Search Customer/////////////
	@When("Enter Customer Email")
	public void enter_customer_email() {
	    SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
	    Log.info("Email Address entered");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		
		SearchCustPg.clickOnSearchButton();
		
		Log.info("Clicked on search button");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		
		String expectedEmail = "victoria_victoria@nopCommerce.com";
		
		//Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail)==true);
		if(SearchCustPg.searchCustomerByEmail(expectedEmail))
			{
			Assert.assertTrue(true);
			Log.info("User should found Email in the Search table:Passed");
			}else {
				Assert.assertTrue(false);
				Log.warn("User should not found Email in the Search table:Failed");
				
			}
	}
	@When("Enter Customer FirstName")
	public void enter_customer_first_name() {
	    SearchCustPg.enterFirstName("Victoria");
	}

	@When("Enter Customer LastName")
	public void enter_customer_last_name() {
		SearchCustPg.enterLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Victoria Terces";
		Assert.assertTrue(SearchCustPg.searchCustomerByName(expectedName)==true);
	}
	//@After//(order=1)lower value last execute
	public void teardown(Scenario sc) throws IOException {
		
		System.out.println("Tear Down method executed");
		
		if(sc.isFailed()==true) {
			String fileWithPath = "G:\\Workspace\\Hybrid\\CucumberFramework\\Screenshot\\failedSS.png";
			TakesScreenshot scrShot = (TakesScreenshot)driver;
			
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			
			File destFile = new File(fileWithPath);
			
			FileUtils.copyFile(srcFile,destFile);
		}
		driver.quit();
	}
	@AfterStep
    public void addScreenshot(Scenario scenario)
    {
		if(scenario.isFailed()) {
     final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
      //attach image file report(data, media type, name  of the attachment)
      scenario.attach(screenshot, "image/png", scenario.getName());
     }
    }

	/*@After//(order=2)higher value first execute
	public void teardown2() {
		
		System.out.println("Tear Down2 method executed");
		driver.quit();
	}
	/*@BeforeStep
	public void beforeStepMethodDemo() {
		System.out.println("This is before step...");
	}
	@AfterStep
	public void afterStepMethodDemo() {
		System.out.println("This is after step...");
	}*/


}
