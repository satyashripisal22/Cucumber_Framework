package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

WebDriver driver;
	
	public SearchCustomerPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="SearchEmail")
	WebElement emailAdd;
	
	@FindBy(id="search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@width='100%']")
	WebElement searchResult;
	
	@FindBy(xpath = "//table[@id='customers-grid']/tbody/tr")
	List<WebElement> tableRows;
	
	/*@FindBy(xpath = "//table[@id='customers-grid']/tbody/tr[1]/td")
	List<WebElement> tableColumns;*/
	
	@FindBy(id="SearchFirstName")
	WebElement firstName;
	
	@FindBy(id="SearchLastName")
	WebElement lastName;
	
	public void enterEmailAdd(String email) {
		emailAdd.sendKeys(email);
	}
	
	public void clickOnSearchButton() {
		searchBtn.click();
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean found = false;
		
		//total no. of rows in grid
		int ttlRows = tableRows.size();
		System.out.println(ttlRows);
		
		//total no of columns
		//int ttlColumns = tableColumns.size();//table[@width='100%']/tbody/tr/td[2]//table[@width='100%']/tbody/tr[9]/td[2]
		
		for(int i=1;i<=ttlRows;i++) //iterate all the rows //table[@id='customers-grid']/tbody/tr[1]/td[2]
		{
			WebElement webElementEmail = driver.findElement(By.xpath("//table[@width='100%']/tbody/tr[" + i + "]/td[2]"));
			String actualEmailAdd =webElementEmail.getText();
			
			if(actualEmailAdd.equals(email))
			{
				found = true;
			}
			
			
		}
		return found;
		
	}
	
public boolean searchCustomerByName(String name) {
		
		boolean found = false;
		
		//total no. of rows in grid
		int ttlRows = tableRows.size();
		
		//total no of columns
		//int ttlColumns = tableColumns.size();
		
		for(int i=1;i<=ttlRows;i++) //iterate all the rows //table[@id='customers-grid']/tbody/tr[1]/td[2]
		{
			WebElement webElementName = driver.findElement(By.xpath("//table[@width='100%']/tbody/tr[" + i + "]/td[3]"));
			String actualName =webElementName.getText();
			
			if(actualName.equals(name))
			{
				found = true;
				break;
			}
			
			
		}
		return found;
	}
	
	//Search Customer by firstName and lastName
	
	
	public void enterFirstName(String firstNameText) 
	{
		firstName.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText)
	{
		lastName.sendKeys(lastNameText);
	}
	
}
