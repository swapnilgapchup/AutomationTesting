package pere.DateToString;


import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.testng.annotations.BeforeMethod;
//import com.pere.OverviewTestNG.NewTest;
import com.pere.datareader.ReaOds;

public class LoginGmailCheck {
	public String mailId = "swapnil.gapchup+2018430175926ca@perennialsys.com";
	public String subject = "Registration Completed";
	static Properties pro = ReaOds
			.returnProperty("/home/perennial/Desktop/OverviewTestNG/TestData/login.properties");
	//String baseUrl = pro.getProperty("baseUrl1");
	static String driverPath = pro.getProperty("driverPath1");
	static WebElement element;
	public static void main(String[] args) {
		mailCheck();
	}
	public static void mailCheck(/*String mailId,String Subject*/){
		String mailidp = "swapnil.gapchup@perennialsys.com";
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", driverPath);
			WebDriver driver = new ChromeDriver();
			driver.get("https://mail.google.com/mail/u/0/#inbox");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    element = driver.findElement(By.xpath("//input[1]"));
		    element.clear();
		    element.sendKeys(mailidp);
		    element.sendKeys(Keys.ENTER);
		    driver.manage().window().maximize();
		    /*element = driver.findElement(By.xpath("(//div[1]/div/content/span)[2]"));
			element.click();*/
			//click(driver.findElement(By.xpath("//div[2]/div/content/form/div[1]/div/div[1]")));
			 WebDriverWait wait = new WebDriverWait(driver,30);
			    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div/div/div/input)[@type='password']")));
			element = driver.findElement(By.xpath("(//div/div/div/input)[@type='password']"));
			Actions xAct = new Actions(driver);
			xAct.moveToElement(element);// used actions to handel the exception element not visible
			xAct.click();
			xAct.perform();
		    element.sendKeys("swapnil"+"@0766");
		    element.sendKeys(Keys.ENTER);//tbody/tr/td/div/input
		    
		    WebDriverWait wait1 = new WebDriverWait(driver,30);
		    wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
		    element = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		    Actions xAct1 = new Actions(driver);
			xAct1.moveToElement(element);
			xAct1.click();
			xAct1.perform();
		    element.sendKeys("Registration Completed");
		    element = driver.findElement(By.xpath("(//button/span)"));
		    element.click();
		    //element.sendKeys(Keys.ENTER);
		    /*WebDriverWait wait2 = new WebDriverWait(driver,30);
		    wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div/span[2])[@class='y2'][1]")));
		    element.findElement(By.xpath("(//div/span[2])[@class='y2'][1]"));//mail div//td/div/div/div/span[1]
		    element.click();	*/
		    
		    List<WebElement> a = driver.findElements(By.xpath("(//div/span[2])[@class='y2'][1]"));
		    System.out.println(a.size());//div[@role='link'])[3]//div[@role='link'])[3]
		                try{
		                for(int i=0;i<2;i++){
		                    System.out.println(a.get(i).getText());
		                    if(a.get(i).getText().contains("Welcome")){  // if u want to click on the specific mail then here u can pass it
		                        a.get(i).click();
		                    }
		                }
		                }catch(IndexOutOfBoundsException e){
		                	System.out.println(e);
		                }
		                element=driver.findElement(By.linkText("Verify Email Now"));
		                element.click();
		                element=driver.findElement(By.tagName("h2"));
		                if(element.getText().equalsIgnoreCase("Thank You!!!")){
		                	System.out.println("email verification success");
		                }else if (element.getText().equalsIgnoreCase("Opps!!!")){
		                	System.out.println("Link expired confirmed");
		                }
		    
	}
}
