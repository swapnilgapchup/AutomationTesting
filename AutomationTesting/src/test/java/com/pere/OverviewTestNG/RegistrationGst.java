package com.pere.OverviewTestNG;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pere.DateToString.DateToNumbers;

public class RegistrationGst extends NewTest {
	// a[@title="Register"]
	WebElement element1;
	WebElement business;
	WebElement Taxpayer;
	WebDriverWait wait;
	Actions action;
	DateToNumbers dtn = new DateToNumbers();
	String counter = dtn.returnDateAsNumber();	 

	@Test
	public void registrationForBusiness() {
		String emailBo  = pro.getProperty("namePart") + "+" + counter + "bo"
				+ pro.getProperty("domainPart");
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By
				.xpath("//a[@title='Register']")); // Click on Registration
		System.out.println("Text on the Dropdown of registration is :"
				+ element.getText());
		Actions actionove = new Actions(driver);
		// element.click();//Click on Registration
		actionove.moveToElement(element).click().perform();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		business = driver.findElement(By
				.xpath("(//ul[@role='menu'])[2]/li[1]/a[@title='Business']"));
		action.moveToElement(element).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(business)); // list
		business.click();// click on business
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_firstname")));
		element1.clear();
		element1.sendKeys(pro.getProperty("firstname"));
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_lastname")));
		element1.clear();
		element1.sendKeys(pro.getProperty("lastname"));
		element1 = driver.findElement(By.xpath(pro.getProperty("input_email")));
		element1.clear();
		element1.sendKeys(emailBo);// runtime created mail using String value
		element1 = driver
				.findElement(By.xpath(pro.getProperty("input_mobile")));
		element1.clear();
		element1.sendKeys(pro.getProperty("phone"));
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_password")));
		element1.clear();
		element1.sendKeys(pro.getProperty("password"));
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_confirmpassword")));
		element1.clear();
		element1.sendKeys(pro.getProperty("confirmpassword"));
		element1 = driver.findElement(By.xpath(pro
				.getProperty("business_page_submit")));
		element1.click();
	}

	@Test
	public void registrationForCa() {
		String emailCa = pro.getProperty("namePart") + "+" + counter + "ca"
				+ pro.getProperty("domainPart");
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By
				.xpath("//a[@title='Register']")); // Click on Registration
		System.out.println("Text on the Dropdown of registration is :"
				+ element.getText());
		Actions actionove = new Actions(driver);
		// element.click();//Click on Registration
		actionove.moveToElement(element).click().perform();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		Taxpayer = driver.findElement(By.xpath("(//ul/li[2]/a)[3]"));
		action.moveToElement(element).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(Taxpayer)); // list
		Taxpayer.click();// click on taxpayer	
	
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_firstname_CA")));
		element1.clear();
		element1.sendKeys(pro.getProperty("firstname"));
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_lastname_CA")));
		element1.clear();
		element1.sendKeys(pro.getProperty("lastname"));
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_email_CA")));
		element1.clear();
		element1.sendKeys(emailCa);// runtime created mail using String value
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_mobile_CA")));
		element1.clear();
		element1.sendKeys(pro.getProperty("phone"));
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_password_CA")));
		element1.clear();
		element1.sendKeys(pro.getProperty("password"));
		element1 = driver.findElement(By.xpath(pro
				.getProperty("input_confirmpassword_CA")));
		element1.clear();
		element1.sendKeys(pro.getProperty("confirmpassword"));
		element1 = driver.findElement(By.xpath(pro
				.getProperty("Taxpayer_page_submit_CA")));
		element1.click();

	}

}
