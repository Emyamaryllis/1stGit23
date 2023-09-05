package variousConcepts;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class TestNG {

	WebDriver driver;
	String browser;
	String url;
	String USER_NAME;
	String PASSWORD;

	@Before

	public void readConfig() {

		// FileReader //BufferedReader //InputStream //Scanner

		try {

			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");

			Properties prop = new Properties();
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("browser used: " + browser);
			url = prop.getProperty("url");
			USER_NAME = prop.getProperty("userName");
			PASSWORD = prop.getProperty("password");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	// Element List
	By userNameField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//*[@id=\"password\"]");
	By signinButtonField = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By dashboardHeaderField = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By customerMenuField = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
	By addCustomerMenuField = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
	By addCustomerHeaderField = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5");
	By fullNameField = By.xpath("//*[@id=\"account\"]");
	By companyDropdownField = By.xpath("//select[@id='cid']");
	By emailField = By.xpath("//*[@id=\"email\"]");
	By phoneField = By.xpath("//*[@id=\"phone\"]");
	By countryField = By.xpath("//select[@id=\"country\"]");

	// testdata or mockdata
	String DASHBOARD_HEADER_TEXT = "Dashboard";
	String ADDCUSTOMER_HEADER_TEXT = "Add Contact";
	String FULL_NAME = "Selenium Feb2023";
	String COMPANY = "Techfios";
	String EMAIL = "demoFeb23@techfios.com";
	String PHONE = "1234567";
	String COUNTRY = "USA";

	@Before
	public void init() {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\tifra\\selenium\\ClassesFeb23\\driver\\chrome_pwa_launcher.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\tifra\\selenium\\practice\\edge\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("select proper browser!!");
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

//		@Test(priority = 1)
	public void login() {

		driver.findElement(userNameField).sendKeys(USER_NAME);
		driver.findElement(passwordField).sendKeys(PASSWORD);
		driver.findElement(signinButtonField).click();
		Assert.assertEquals(driver.findElement(dashboardHeaderField).getText(), DASHBOARD_HEADER_TEXT,
				"Dashboard page not found");
	}

	@Test
	public void addCustomer() throws InterruptedException {

		login();

		Thread.sleep(2000);
		driver.findElement(customerMenuField).click();
		driver.findElement(addCustomerMenuField).click();
		waitForElement(driver, 5, addCustomerHeaderField);
		Assert.assertEquals(driver.findElement(addCustomerHeaderField).getText(), ADDCUSTOMER_HEADER_TEXT,
				"Add Customer Page is not available");

		driver.findElement(fullNameField).sendKeys(FULL_NAME + randomNumGenerator(999));
		selectFromDropdown(driver.findElement(companyDropdownField), COMPANY);
		driver.findElement(emailField).sendKeys(randomNumGenerator(9999) + EMAIL);
		driver.findElement(phoneField).sendKeys(PHONE + randomNumGenerator(99));
		selectFromDropdown(driver.findElement(countryField), COUNTRY);

	}

	private void waitForElement(WebDriver driver, int waitTime, By elementToBeLocated) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elementToBeLocated));
	}

	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	private int randomNumGenerator(int bound) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(bound);
		return generatedNum;
	}

//		 @AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
