package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.ConfigReader;
import page.LoginPage;
import page.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginPageObj;

	@BeforeMethod
	public void setUp() {
		initDriver();
		driver.get(ConfigReader.getProperty("base.url"));
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test
	public void loginTest() {
		loginPageObj.enterUserName(ConfigReader.getProperty("username"));		
		System.out.println("Username entered!");
		loginPageObj.enterPassword(ConfigReader.getProperty("password"));
		System.out.println("Password entered!");
		loginPageObj.clickSignInButton();
		System.out.println("Sign in button clicked!");
		takeScreenshot(driver);
	}

	@Test
	public void pageTitleTest()  {
		loginPageObj.enterUserName(ConfigReader.getProperty("username"));
		loginPageObj.enterPassword(ConfigReader.getProperty("password"));
		loginPageObj.clickSignInButton();
		takeScreenshot(driver);
		String expectedTitle = "Codefios";
		String actualTitle = loginPageObj.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
