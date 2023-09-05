package variousConcepts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class variousConcepts {

	WebDriver driver;

//	@BeforeClass	
	public static void beforeMethod() {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void afterMethod() {
		System.out.println("After Class");
	}

	@Before
	public void launchBrowser() {
		System.out.println("Before");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tifra\\selenium\\ClassesFeb23\\driver\\chrome_pwa_launcher.exe");
		// Chrome Object
		driver = new ChromeDriver();
		// delete cookies
		driver.manage().deleteAllCookies();
		// mazimize window
		driver.manage().window().maximize();
		// go to website
		driver.get("https://techfios.com/billing/?ng=login");
	}

	@Test
	public void loginTest() throws InterruptedException {
		System.out.println("Test 1");
		// insert username
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		// insert password
		driver.findElement(By.id("password")).sendKeys("abc123");
		// click sign in button
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
	}

	@Test
	public void negLoginTest() throws InterruptedException {
		System.out.println("Test 2");
		// insert username
		driver.findElement(By.id("username")).sendKeys("demo@techfios1.com");
		// insert password
		driver.findElement(By.id("password")).sendKeys("558566");
		// click sign in button
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
	}

 @Test
	public void negLoginTest1() throws InterruptedException {
		// insert username
		driver.findElement(By.id("username1")).sendKeys("demo@techfios.com");
		// insert password
		driver.findElement(By.id("password")).sendKeys("55856dfhg");
		// click sign in button
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
	}

	@After
	public void tearDown() {
		System.out.println("After");
		// close browser
		driver.close();
	}

}
