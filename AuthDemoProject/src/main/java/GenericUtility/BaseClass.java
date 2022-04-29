package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public JavaUtility jLib = new JavaUtility();
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUTiltiy fLib = new FileUTiltiy();
	public WebdriverUtility wLib = new WebdriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite
	public void dbConnection() {
		dLib.connectToDB();
		System.out.println("====Database connection successful====");
	}

	
	@BeforeClass
	public void launchBrowser() throws Throwable 
	{
		
		String BROWSER = fLib.getPropertyKeyValue("browser"); 
		String URL = fLib.getPropertyKeyValue("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser");
		}
		sdriver = driver;
		wLib.WaitForPageToLoad(driver);
		wLib.maximiseWindow(driver);
		driver.get(URL);
		System.out.println("====Browser Launched");
	}

	@BeforeMethod
	public void loginToApp() throws Throwable {
		

		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("=====Login Successful====");
	}

	@AfterMethod
	public void logoutofApp() {
		HomePage hp = new HomePage(driver);
		hp.logout(driver);
		System.out.println("===Logout Successful");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("===Browser Closed");
	}

	@AfterSuite
	public void closeDbConnection() {
		dLib.closeDB();
		System.out.println("===Data Base Connection Closed===");
	}
}
