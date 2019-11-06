package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SecurePayGlueCode {
public WebDriver driver;
	
	@Given ("^Launch google page$")
	public void GoogleSearch() throws Exception
	{
	//Change the path of Chrome Driver before executing
	System.setProperty("webdriver.chrome.driver", "C:/Users/Mallik/Downloads/Selenium/Workspace/SecurePay1/chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com.au/");
	Thread.sleep(2000);
	}
	@And ("^Search for SecurePay$")
	public void SearchPage () throws Exception 
	{
		driver.findElement(By.name("q")).sendKeys("Secure Pay", Keys.ENTER);
		Thread.sleep(2000);
	}
	@When ("^Open SecurePay page$")
	public void OpenPage ()throws Exception
	{
		driver.findElement (By.partialLinkText("SecurePay online payment and eCommerce solutions")).click();
	}
	
	@Then ("^Verify Securepay home page$")
	public void VerifyPage () throws Exception
	{
		String x = driver.getCurrentUrl();
		if(x.contains("https://www.securepay.com.au")){System.out.println("SecurePage loaded: Test Passed");}
		else{System.out.println("SecurePay Home page :Test Failed");}
		
	}
	
	@When ("^On home page click on Support and Contact us page$")
	public void OpenContactPage () throws Exception
	{
		WebElement s= driver.findElement(By.linkText("Support"));
		WebElement c=driver.findElement(By.xpath("//li[@id='menu-item-179']//a[contains(text(),'Contact Us')]"));
		Actions a= new Actions (driver);
		a.moveToElement(s).perform();
		c.click();
		Thread.sleep(2000);	
		
	}
	@Then ("^Contact us page is displayed$")
	public void VerifyContactPage () throws Exception
	{
		String x = driver.getCurrentUrl();
		if(x.contains("contact-us")){System.out.println("Contact us loaded: Test Passed");}
		else{System.out.println("Contact Us: Test Failed");}
		Thread.sleep(3000);
	}
	@And ("^Fill Contact us form$")
	public void FillForm () throws Exception
	{
		// Generating random data using Faker
		Faker faker = new Faker();
		String FN = faker.name().firstName();
		System.out.println("First name:"+FN);
		String LN = faker.name().lastName();
		System.out.println("LastName:"+LN);
		String EM= faker.internet().emailAddress();
		System.out.println("Email:"+EM);
		String PN= faker.phoneNumber().cellPhone();
		System.out.println("Phone:"+PN);
		String URL=faker.internet().url();
		System.out.println("URL:"+URL);
		String Company = faker.name().fullName();
		System.out.println("Company:"+Company);
//Filling Contact us form
		driver.findElement (By.xpath("//input[@placeholder='First Name']")).sendKeys(FN);
		driver.findElement (By.xpath("//input[@placeholder='Last Name']")).sendKeys(LN);
		driver.findElement (By.xpath("//input[@placeholder='Email Address']")).sendKeys(EM);
		driver.findElement (By.xpath("//input[@placeholder='Phone Number']")).sendKeys(PN);
		driver.findElement (By.xpath("//input[@placeholder='https://']")).sendKeys(URL);
		driver.findElement (By.xpath("//input[@placeholder='Company']")).sendKeys(Company);
		Select reason = new Select(driver.findElement (By.xpath("//select[@name='reason-for-enquiry']"))); 
		reason.selectByIndex(1);
		driver.findElement (By.xpath("//textarea[@name='message']")).sendKeys("Mallik Reddy Mora, 0433072244");
		Thread.sleep(6000);
		driver.quit();
		
	}
  	
}
