package com.SDET43.GenricLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.LIMS.ObjectRepository.LoginPage;
import com.LIMS.ObjectRepository.LogoutPage;

public class BaseClass {

	public DataBaseUtility dLib = new DataBaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite
	public void connectToDB() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("Connect to DataBase");
	}
	
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		String BROWSER = fLib.ReadDataFromPropertyFIle("browser");
		
//		if(BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//			driver = new FirefoxDriver();
//		else
//			System.out.println("invalid Browser");
		
		sdriver = driver;
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		
		String URL = fLib.ReadDataFromPropertyFIle("url");
		driver.get(URL);
	}
	
	@BeforeMethod
	public void loginToApp() throws Throwable
	{		
		String USERNAME = fLib.ReadDataFromPropertyFIle("username");
		String PASSWORD = fLib.ReadDataFromPropertyFIle("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void signout()
	{
		LogoutPage out = new LogoutPage(driver);
		out.logout();
		System.out.println("Logout from the App");
	}
	
	@AfterClass
	public void CloseBroser()
	{
		driver.quit();
	}
	@AfterSuite
	public void CloseDB() throws Throwable
	{
		dLib.close();
		System.out.println("close DataBase Connection");
	}
}
