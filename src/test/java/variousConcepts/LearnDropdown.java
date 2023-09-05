package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class LearnDropdown {

	WebDriver driver;

	By USER_NAME_FIELD = By.xpath("//input[@id='username']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGN_IN_BUTTON_FIELD = By.xpath("//button[@name='login']");
	By DASHBOARD_HEADER_FIELD = By.xpath("//h2[text()=' Dashboard ']");
	By CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(), 'Customers')]");
	By ADD_CUSTOMER_MENU_FIELD = By.xpath("//a[contains(text(), 'Add Customer')]");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"account\"]");
	By COUNTRY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");

	@Before

	public void init() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tifra\\selenium\\ClassesFeb23\\driver\\chrome_pwa_launcher.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

//				@Test
	public void LoginTest() {

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGN_IN_BUTTON_FIELD).click();

		@SuppressWarnings("unused")
		String dashboard_header_text = driver.findElement(DASHBOARD_HEADER_FIELD).getText();

		// Assert.assertTrue("Dashboard page not found!!",
		// driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
		// Assert.assertEquals("Dashboard page not found!!", "Dashboard",
		// dashboard_header_text);
		Assert.assertEquals("Dashboard page not found!!", "Dashboard- iBilling", driver.getTitle());

	}

	@Test
	public void addCustomer() {

		LoginTest();
		driver.findElement(CUSTOMER_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		driver.findElement(FULL_NAME_FIELD).sendKeys("Selenium");

		Select sel = new Select(driver.findElement(COUNTRY_DROPDOWN_FIELD));
//					sel.selectByVisibleText("Techfios");
		sel.selectByValue("1");
		// to get all options
//					sel.getOptions();

	}

	public class LearnAlert {

		WebDriver driver;

		@Before
		public void init() {

			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		@Test
		public void testAlert() throws InterruptedException {

			driver.findElement(
					By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]"))
					.click();
			Thread.sleep(2000);

			String alert_msg = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();

			System.out.println(alert_msg);

		}

	}

	public class LearnIFrame {

		WebDriver driver;

		@Before
		public void init() {

			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get("https://docs.oracle.com/javase/8/docs/api/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

		@Test
		public void testIFame() throws InterruptedException {

			driver.switchTo().frame("packageListFrame");
			driver.findElement(By.linkText("java.awt")).click();

			driver.switchTo().parentFrame();
			driver.switchTo().frame("packageFrame");
			driver.findElement(By.linkText("Adjustable")).click();

//					driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			driver.switchTo().frame("classFrame");

			Assert.assertEquals("Wrong page!!", "Interface Adjustable",
					driver.findElement(By.xpath("//h2[contains(text(), 'Interface Adjustable')]")).getText());

		}

		public class LearnKeyboardEvent {

			WebDriver driver;

			By USER_NAME_FIELD = By.xpath("//input[@id='username']");
			By PASSWORD_FIELD = By.xpath("//input[@id='password']");
			By SIGN_IN_BUTTON_FIELD = By.xpath("//button[@name='login']");

			@Before
			public void init() {

				System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.get("https://www.techfios.com/billing/?ng=login/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			}

			@Test
			public void LoginTest() {

				driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
				driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
//					driver.findElement(SIGN_IN_BUTTON_FIELD).click();

				Actions action = new Actions(driver);
//					action.sendKeys(Keys.ENTER).build().perform();
				action.sendKeys(Keys.RETURN).build().perform();

			}

			public class LearnMouseHover {

				WebDriver driver;

				@Before
				public void init() {

					System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().deleteAllCookies();
					driver.get("https://www.dell.com/en-us");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				}

				@Test
				public void testMouseHover() {

					By Computers_Acc = By.xpath("//span[text()='Computers & Accessories']");
					By Monitors = By.xpath("//button[text()='Monitors']");
					By ViewAllMonitors = By.xpath("//a[contains(text(), 'View All Monitors')]");

					Actions action = new Actions(driver);
					action.moveToElement(driver.findElement(Computers_Acc)).build().perform();
					action.moveToElement(driver.findElement(Monitors)).build().perform();
					driver.findElement(ViewAllMonitors).click();

				}

				public class LearnScroll {

					WebDriver driver;

					@Before
					public void init() {

						System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
						driver = new ChromeDriver();
						driver.manage().deleteAllCookies();
						driver.get("https://www.dell.com/en-us");
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					}
				}
			}

			@Test
			public void testScroll() throws InterruptedException {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("scroll(0,7000)");
				Thread.sleep(2000);

			}
		}
	}
}