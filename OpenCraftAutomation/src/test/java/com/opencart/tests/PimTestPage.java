package com.opencart.tests;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencart.pages.AdminUserCreation;
import com.opencart.pages.CartRegistration;
import com.opencart.pages.PimPage;
import com.opencart.tests.BaseAutomationTest.WEB_DRIVER;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class PimTestPage extends BaseAutomationTest {

	private static final Logger logger = Logger.getLogger(PimTestPage.class.getName());

	@BeforeClass
	@Parameters({ "siteURL", "browser" })
	public void AdminUserCreation(String siteURL, String browser) throws Exception {
		logger.info("Starting of AdminUserCreation ");

		this.driver = this.getWebDriver(browser, WEB_DRIVER.OPENCART_DRIVER);

		this.goToSite(siteURL, driver);
		this.pimPage = new PimPage(this.driver);
		this.opencartregistration = new CartRegistration(this.driver);
		this.adminusercreation = new AdminUserCreation(this.driver);

		logger.info("Ending of AdminUserCreation ");

	}

	@Test(priority = 1, description = " Test Case #1, verify  PIM  ")
	@Description("Test Case #1, verify PIM")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, verify PIM ")
	public void PimEployyee() throws InterruptedException {
		logger.info("Starting of  PIM LINK ");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		pimPage.linkPim();
		
		System.out.println(driver.getTitle());
		Assert.assertTrue(pimPage.header());
		pimPage.addBtn();
		pimPage.saveBtn();
		ArrayList<String> errorMessages = this.pimPage.getErrorMessages();
		Assert.assertEquals(errorMessages.get(0), "Required");
		Assert.assertEquals(errorMessages.get(1), "Required");
		//Assert.assertEquals(errorMessages.get(2), "Employee Id already exists");
		driver.navigate().refresh();
		//pimPage.employeeImage();
		pimPage.imageUpload();
		pimPage.setFirstName();
		pimPage.setMiddleName();
		pimPage.setLastName();
		pimPage.saveBtn();
		pimPage.setDriverLicence(testDataProp.getProperty("license"));
		pimPage.setDriverLicence(testDataProp.getProperty("expire"));
		//pimPage.nationality();
      // pimPage.setDob(testDataProp.getProperty("DOB"));
       pimPage.setGender();
       pimPage.saveBtn();
       pimPage.selectBloodType();
       pimPage.btnSave();
       Assert.assertEquals(this.pimPage.toastMessage(), "Successfully Saved");
       System.out.println(this.pimPage.toastMessage());
	}

}
