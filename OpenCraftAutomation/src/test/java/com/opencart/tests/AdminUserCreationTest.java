package com.opencart.tests;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.opencart.pages.AdminUserCreation;
import com.opencart.pages.CartRegistration;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class AdminUserCreationTest extends BaseAutomationTest {

	private static final Logger logger = Logger.getLogger(AdminUserCreationTest.class.getName());

	@BeforeTest
	@Parameters({ "siteURL", "browser" })
	public void AdminUserCreation(String siteURL, String browser) throws Exception {
		logger.info("Starting of AdminUserCreation ");

		this.driver = this.getWebDriver(browser, WEB_DRIVER.OPENCART_DRIVER);

		this.goToSite(siteURL, driver);

		this.opencartregistration = new CartRegistration(this.driver);
		this.adminusercreation = new AdminUserCreation(this.driver);
		logger.info("Ending of AdminUserCreation ");

	}

	@Test(priority = 1, description = " Test Case #1, verify  AdminUserCreation  ")
	@Description("Test Case #1, verify AdminUserCreation")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #1, verify AdminUserCreation ")
	public void verifregister() throws InterruptedException {
		logger.info("Starting of  AdminUserCreations ");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		adminusercreation.dashBoardIsDisplayed();

		String[] tittle = this.adminusercreation.addUser();
		String addTittle = tittle[0];
		String pageTittle = tittle[1];
		Assert.assertEquals(addTittle, expectedAssertionsProp.getProperty("text.addBtn"));
		Assert.assertEquals(pageTittle, expectedAssertionsProp.getProperty("text.tittle"));
		// adminusercreation.addNewUser();

		/* String[] tittle1 = this.adminusercreation.addUser(); */
		String addUserTit = tittle[2];
		Assert.assertEquals(addUserTit, expectedAssertionsProp.getProperty("txt.add"));

		logger.info("Ending of AdminUserCreations");

	}

	@Test(priority = 2, description = " Test Case #2, verify to Add a New User")
	@Description("Test Case #2, verify to Add a New User")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3, Verify to Add a New User")
	public void addNewUser() throws InterruptedException {
		logger.info("Starting of  AdminUserCreations ");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		adminusercreation.userRole();
		adminusercreation.setEmployeName(testDataProp.getProperty("employeename"));
		adminusercreation.statusDropDown();

		adminusercreation.btnSave();

		ArrayList<String> errormessages = this.adminusercreation.getErrorMessages();
		Assert.assertEquals(errormessages.get(0), "Required");
		Assert.assertEquals(errormessages.get(1), "Required");
		Assert.assertEquals(errormessages.get(2), "Passwords do not match");

		// adminusercreation.setAddUser(testDataProp.getProperty("adduser"));
		adminusercreation.setAddUser();
		// adminusercreation.setPassword(testDataProp.getProperty("addpassword"));
		adminusercreation.setPassword();
		// adminusercreation.setConfirmPassword(testDataProp.getProperty("confirmpasswd"));
		adminusercreation.setConfirmPassword();
		adminusercreation.btnSave();
		logger.info("Ending of  AdminUserCreations ");
	}

	@Test(priority = 3, description = " Test Case #3, verify to searchUser a New User")
	@Description("Test Case #3, verify to searchUser a New User")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2, Verify to Add a New User")
	public void searchUser() throws InterruptedException {
		logger.info("Starting of  searchUser ");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// driver.manage().deleteAllCookies();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
		adminusercreation.btnSearch();

		driver.navigate().refresh();
		adminusercreation.setSystemmUserName();
		adminusercreation.selectUserRole();
		adminusercreation.srchEmployeeName(testDataProp.getProperty("employeename"));
		adminusercreation.selectStatus();
		adminusercreation.btnSearch();
		// adminusercreation.table();
		// adminusercreation.handleTable();
		// adminusercreation.jobTittleHeader();
		logger.info("Ending  of  AdminUserCreations ");
	}
}