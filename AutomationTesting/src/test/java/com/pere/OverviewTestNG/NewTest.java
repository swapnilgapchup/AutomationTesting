package com.pere.OverviewTestNG;

import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.pere.datareader.ReaOds;

public class NewTest {
	ReaOds Rs = new ReaOds();
	static Properties pro = ReaOds
			.returnProperty("/home/perennial/Desktop/OverviewTestNG/TestData/login.properties");
	String baseUrl = pro.getProperty("baseUrl1");
	String driverPath = pro.getProperty("driverPath1");
	WebDriver driver;

	@BeforeMethod
	public void initDriver() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}

	@Test
	public void AssertTitleGST() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = pro.getProperty("expectedTitle1");

		if (actualTitle.equals(expectedTitle)) {
			System.out
					.println("Title of the page is accurate thus testcase pass");
		}
	}

	
	  @Test public void loginUserInvalidPass() { // open Base URl
	  driver.get(baseUrl);
	 
	 // click on login
	    WebElement element = driver.findElement(By.xpath(pro.getProperty("loginButton"))); element.click();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // input box for Email 
	  element =
	  driver.findElement(By.xpath(pro.getProperty("EmailTextBox")));
	  element.clear(); element.sendKeys(pro.getProperty("InvalidEmail"));
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // inputbox for password 
	  element = driver.findElement(By.xpath(pro
	  .getProperty("passwordTextbox"))); element.clear();
	  element.sendKeys(pro.getProperty("InvalidPass")); // Login Button/Sign inButton 
	  element = driver.findElement(By.xpath(pro
	  .getProperty("logiorSigninButton"))); element.click();
	  driver.navigate().refresh(); }
	  
	/*  @Test public void loginUserInvalidEmail() { 
		  // open BaseURl 
		  driver.get(baseUrl);
		  // Login Element 
		  WebElement element = driver.findElement(By.xpath(pro.getProperty("loginButton"))); 
		  element.click();
	      // to wait after login 
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  
	  // to find email input field element =
	  driver.findElement(By.xpath(pro.getProperty("EmailTextBox")));
	  element.clear(); element.sendKeys(pro.getProperty("InvalidEmail"));
	  element.sendKeys(Keys.TAB);
	  
	  // To insert password 
	  element = driver.findElement(By.xpath(pro
	  .getProperty("passwordTextbox"))); element.clear();
	  element.sendKeys(pro.getProperty("ValidPass"));
	  
	  // To click on submit 
	  element = driver.findElement(By.xpath(pro
	  .getProperty("logiorSigninButton"))); element.click();
	  
	  // to check error message 
	  element = driver.findElement(By.xpath((pro
	  .getProperty("ErrorMessageAlert"))));
	  System.out.println(element.getText()); String errorMessageReceived =
	  element.getText(); String errorMessageExpected =
	  pro.getProperty("errorMessageExpected");
	  
	  if (errorMessageExpected.equals(errorMessageReceived)) { System.out
	  .println("Invalid email and valid password alert message test passed"); }
	  
	  driver.navigate().refresh(); }*/
	 
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {

		return new Object[][] { { pro.getProperty("ValidEmail"),
				pro.getProperty("ValidPass") } };

	}

	@Test( dataProvider = "Authentication")
	public void loginUser(String sUsername, String sPassword) {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.xpath("//li[6]/a"));
		element.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		element = driver.findElement(By.xpath("//*[@id='email']"));
		element.clear();
		element.sendKeys(sUsername);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		element = driver.findElement(By.xpath("//*[@id='password']"));
		element.clear();
		element.sendKeys(sPassword);
		element = driver.findElement(By.xpath("//div[6]/input"));
		element.click();
		//element = driver.findElement(By.xpath("(//span)[9]"));
		//element.click();
		/*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		element = driver.findElement(By.xpath("(//a)[24]"));
		element.click();*/
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void killDriver() {
		driver.close();
		driver.quit();
	}
}
