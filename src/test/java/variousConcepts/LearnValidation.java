package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class LearnValidation {

	// CNN

	// h2[@class='container__title_url-text
	// container_lead-package__title_url-text']/parent::a/parent::div/following-sibling::div/descendant::span

	// div[@data-uri='cms.cnn.com/_components/stack/instances/clg34olox006s47no6ifv61fs@published']/descendant::span[1]

	// CRM

	// input[@id='username']
	// html/body/div/div/div/form/div[1]/input
	// div[@class='wrapper no-navigation preload']/descendant::input[1]

	// ul[@id='side-menu']/descendant::span[6]
	// div[@id= 'wrapper']/descendant::span[6]

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tifra\\selenium\\ClassesFeb23\\driver\\chrome_pwa_launcher.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() {

		// Type name = Value
		// Element List
		// storing in WebElement
		WebElement userNameElemnt = driver.findElement(By.xpath("//input[@id='username']"));
		@SuppressWarnings("unused")
		WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		@SuppressWarnings("unused")
		WebElement signinButtonElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));

		// storing in By class
		By userNameField = By.xpath("//input[@id='username']");
		By passwordField = By.xpath("//*[@id=\"password\"]");
		By signinButtonField = By.xpath("/html/body/div/div/div/form/div[3]/button");
		@SuppressWarnings("unused")
		By dashboardHeaderField = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");

		/*
		 * driver.findElement(By.xpath("//input[@id='username']")).clear();
		 * driver.findElement(By.xpath("//input[@id='username']")).sendKeys(
		 * "demo@techfios.com");
		 */

		userNameElemnt.clear();
//			userNameElemnt.sendKeys("demo@techfios.com");
		driver.findElement(userNameField).sendKeys("demo@techfios.com");
		driver.findElement(passwordField).sendKeys("abc12312123");
		driver.findElement(signinButtonField).click();

		boolean dashboardPageIsDisplayed;

		try {
			dashboardPageIsDisplayed = true;
		} catch (Exception e) {
			dashboardPageIsDisplayed = false;
			e.printStackTrace();
		}

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 9);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeaderField
		 * ));
		 */

		Assert.assertTrue("Dashboard page not available.", dashboardPageIsDisplayed);

	}

}
