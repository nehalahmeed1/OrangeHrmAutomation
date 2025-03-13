package com.opencart.tests;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.opencart.pages.CartRegistration;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CartRegistrationTestPage extends BaseAutomationTest {

	private static final Logger logger = Logger.getLogger(CartRegistrationTestPage.class.getName());

	@BeforeClass
	@Parameters({ "siteURL", "browser" })
	public void initOpenCartRegister(String siteURL, String browser) throws Exception {
		logger.info("Starting of initOpenCartRegister method in LoginTest");

		this.driver = this.getWebDriver(browser, WEB_DRIVER.OPENCART_DRIVER);

		this.goToSite(siteURL, driver);

		this.opencartregistration = new CartRegistration(this.driver);

		logger.info("Ending of initVamaLogin method in LoginTest");

	}

	@Test(priority = 1, description = " Test Case #1, verify Invalid user details ")
	@Description("Test Case #1, verify Invalid user details")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, verify Invalid user details Page ")
	public void verifregister() throws InterruptedException {
		logger.info("Starting of Invalid user details ");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		opencartregistration.setUserName(testDataProp.getProperty("username"));
		opencartregistration.setPassword(testDataProp.getProperty("password"));
		opencartregistration.clickOnLoginButton();
		Assert.assertEquals(opencartregistration.inavlidAlertMsg(),
				expectedAssertionsProp.getProperty("text.invailduser"));
		Assert.assertTrue(opencartregistration.inavlidAlertMsg1());
		opencartregistration.clickOnLoginButton();
		ArrayList<String> errormessages = this.opencartregistration.getErrorMessages();
		Assert.assertEquals(errormessages.get(0), "Required");
		Assert.assertEquals(errormessages.get(1), "Required");

		logger.info("Ending of Invalid user details method");
	}

	@Test(priority = 2, description = " Test Case #2, verify Valid User details")
	@Description("Test Case #2, verify Valid user details")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, Verify Valid user deatils")

	public void validUser() throws InterruptedException {
		logger.info("Starting of Valid User Details");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		opencartregistration.setUserName(testDataProp.getProperty("Validusername"));
		opencartregistration.setPassword(testDataProp.getProperty("Validpassword"));
		opencartregistration.clickOnLoginButton();

		logger.info("Starting of Valid User Details");

	}

}