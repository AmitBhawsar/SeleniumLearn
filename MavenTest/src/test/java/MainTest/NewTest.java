package MainTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

	public String baseurl = "http://www.facebook.com";
	public WebDriver driver;
	
	@BeforeTest
	public void homepage()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void titlecompare()
	{
		String expectedtitle = "Facebook – log in or sign up";
		String actualtitle =driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("Homepage title is " +actualtitle);
	}

	@Test(priority=1)
	public void username()
	{
		
		driver.findElement(By.name("email")).sendKeys("amitbhaw");
		driver.findElement(By.name("pass")).sendKeys("ablove");
	}
	
	@Test(priority=2)
	public void login()
	{
		driver.findElement(By.id("loginbutton")).click();
		String test = driver.getCurrentUrl();
		System.out.println("Current url is " + test );
		
		
	}
	
	@AfterTest
	public void quit()
	{
		driver.quit();
	}
}

