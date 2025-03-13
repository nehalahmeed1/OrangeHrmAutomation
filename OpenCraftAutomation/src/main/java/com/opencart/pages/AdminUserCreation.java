package com.opencart.pages;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import jdk.internal.joptsimple.internal.Rows;

public class AdminUserCreation extends BaseAutomationPage {
	private static final Logger logger = Logger.getLogger(AdminUserCreation.class.getName());

	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement dashboard;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement btnText;

	@FindBy(xpath = " //h6[text() ='User Management']")
	private WebElement txtTittle;

	@FindBy(xpath = "//h6[text()='Add User']")
	private WebElement addUserTittle;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employeeName;

	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
	private WebElement statusdropdown;

	@FindBy(xpath = "//div[text()='Enabled']")
	private WebElement enabledstatus;

	@FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
	private WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement setUserpassword;

	@FindBy(xpath = "//label[text() = 'Confirm Password']//following::input[@type='password']")
	private WebElement setConfirmpassword;

	@FindBy(xpath = "//label[text()='Username']//following::span")
	private WebElement userNameRequiredAlert;

	@FindBy(xpath = "//label[text()='Password']//following::span")
	private WebElement passwordRequiredAlert;

	@FindBy(xpath = "//label[text()='Confirm Password']//following::span")
	private WebElement confirmPasswordRequiredAlert;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement btnSave;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]") ///// label//following::input[@class='oxd-input
																																			///// oxd-input--active']
	private WebElement systemUserName;

	@FindBy(xpath = " //i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'] ")
	private WebElement userRole;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement srchemployeeName;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	private WebElement statusDropDown;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'] ")
	private WebElement btnSearch;

	@FindBy(xpath = "//div[@class='orangehrm-container']")
	private WebElement tableContainer;

	@FindBy(xpath = "(//div[@class=\"oxd-table-row oxd-table-row--with-border\"])[2]")
	private WebElement tableRowUserName;

	@FindBy(xpath = "//span[contains(text(),'Job')] ")
	private WebElement jobHeader;
	
	@FindBy(xpath = "//a[text()='Job Titles']" )
	private WebElement jobTitles;

	String addusername = null;
	String password = null;

	public AdminUserCreation(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void dashBoardIsDisplayed() throws InterruptedException {

		logger.info("Starting To Check Dashboard is visible");
		this.implicitWait();
		this.dashboard.click();

		logger.info("Starting To Check Dashboard is visible");

	}

	public String[] addUser() {

		logger.info("Starting of getErrorMessages method");

		String addTittle = btnText.getText();
		String pageTittle = txtTittle.getText();
		this.btnText.click();
		String addUserTit = addUserTittle.getText();
		logger.info("Starting of getErrorMessages method");
		return new String[] { addTittle, pageTittle, addUserTit };

	}

	public void userRole() {
		logger.info("Starting of Userrole in AddUser");
		this.implicitWait();
		this.userRole.click();
		Actions at = new Actions(driver);
		at.moveToElement(userRole).click().sendKeys("Admin").build().perform();

		logger.info("Ending of Userrole in AddUser");

	}

	public void setEmployeName(String employee) throws InterruptedException {
		logger.info(" Starting of EmployeeName in AddUser ");
		this.implicitWait();

		Actions at = new Actions(driver);
		at.moveToElement(employeeName).click().sendKeys(employee).build().perform();
		Thread.sleep(4000);
		at.moveToElement(employeeName).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		logger.info(" Ending of EmployeeName in AddUser ");

	}

	public void statusDropDown() {
		logger.info("Starting of Status  in statusDropDown");
		this.implicitWait();
		// this.statusdropdown.click();
		Actions at = new Actions(driver);
		at.moveToElement(statusdropdown).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		logger.info("Ending of Status  in statusDropDown");
	}

	public void setAddUser() throws InterruptedException {/// public void setAddUser(String user)

		logger.info("Starting of userName  in AddUser");
		this.implicitWait();
		// this.userName.sendKeys(user);

		addusername = generateRandomText(10);

		this.userName.sendKeys(addusername);

		logger.info(" Ending of userName in AddUser ");
	}

	public void setPassword() throws InterruptedException { /// public void setPassword(String password)

		logger.info("Starting of setPassword  in setPassword");
		this.implicitWait();
		// this.setUserpassword.sendKeys(password);

		password = generateRandomText(10);
		this.setUserpassword.sendKeys(password);
		logger.info(" Ending of setPassword in setPassword ");

	}

	public void setConfirmPassword() { // public void setConfirmPassword(String confrm)

		logger.info("Starting of setPassword  in setConfirmPassword");
		this.implicitWait();
		this.setConfirmpassword.sendKeys(password);
		logger.info(" Ending of setPassword in setConfirmPassword ");

	}

	public ArrayList<String> getErrorMessages() {
		logger.info("Starting of getErrorMessages method");

		ArrayList<String> errorMessages = new ArrayList<>();

		String userName = userNameRequiredAlert.getText();
		String passWord = passwordRequiredAlert.getText();
		String confPassword = confirmPasswordRequiredAlert.getText();

		errorMessages.add(userName);
		errorMessages.add(passWord);
		errorMessages.add(confPassword);
		logger.info("Ending of getErrorMessages method");

		return errorMessages;

	}

	public void btnSave() {
		logger.info("Starting of getErrorMessages method");

		this.implicitWait();
		this.btnSave.click();
		logger.info("Starting of getErrorMessages method");
	}

	public void setSystemmUserName() throws InterruptedException {
		logger.info("Starting of setSystemmUserName ");

		this.implicitWait();
		// this.systemUserName.sendKeys(username);
		Thread.sleep(3000);
		this.systemUserName.sendKeys(addusername);

		logger.info("Starting of setSystemmUserName ");

	}

	public void selectUserRole() {
		logger.info("Starting of setSystemmUserNameTable method");

		this.implicitWait();
		Actions at = new Actions(driver);
		at.moveToElement(userRole).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		logger.info("Starting of setSystemmUserNameTable method");

	}

	public void srchEmployeeName(String employee) throws InterruptedException {
		logger.info("Starting of srchEmployeeName ");

		this.implicitWait();

		Actions at = new Actions(driver);
		at.moveToElement(srchemployeeName).click().sendKeys(employee).build().perform();
		Thread.sleep(4000);
		at.moveToElement(srchemployeeName).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		logger.info("Starting of srchEmployeeName ");

	}

	public void selectStatus() {

		logger.info("Starting of selectStatus ");

		this.implicitWait();

		Actions at = new Actions(driver);
		at.moveToElement(statusDropDown).click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

		logger.info("Starting of selectStatus ");
	}

	public void btnSearch() throws InterruptedException {

		logger.info(" Starting of btnSearch ");
		this.implicitWait();
	Thread.sleep(5000);
		this.btnSearch.click();
		logger.info(" Starting of btnSearch ");
	}

	public void handleTable() {

		logger.info("Starting of handleTable ");
		this.implicitWait();
		String element = this.tableRowUserName.getText();

		System.out.println("Print value : " + element);

		/*
		 * if(element.equals(addusername)) {
		 * System.out.println(" Getting expeted user name ");
		 * 
		 * }else { System.out.println(" Failed "); }
		 */

		logger.info(" Starting of handleTable ");
		addusername.compareTo(element);
	}

	public void jobTittleHeader() {

		logger.info(" Starting of btnSearch ");
		
		this.implicitWait();
		
		Actions act = new Actions(driver);
		act.moveToElement(jobHeader).sendKeys(Keys.ENTER).click().build().perform();
		
		/* this.jobHeader.click(); */

		logger.info(" Starting of btnSearch ");
	}
	
	/**
	 * 
	 */
	public  void dropDownJobElements() {
		logger.info("Starting of dropDownJobElements method");

	this.implicitWait();
Actions at = new Actions(driver);
at.moveToElement(jobTitles).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).click().build().perform();
	
		logger.info("Ending of dropDownJobElements method");

		

	}

}
