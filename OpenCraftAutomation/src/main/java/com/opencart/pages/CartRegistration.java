package com.opencart.pages;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartRegistration extends BaseAutomationPage {
	private static final Logger logger = Logger.getLogger(CartRegistration.class.getName());

	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active'] [@ name='username']")
	private WebElement txtusername;

	@FindBy(xpath = "//input[@class='oxd-input oxd-input--active'] [@ name='password']")
	private WebElement txtpassword;

	@FindBy(xpath = "//button[@class=\'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\']")
	private WebElement btnlogin;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	private WebElement txtAlertMsg;

	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]")
	private WebElement userNameRequiredAlert;

	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[2]")
	private WebElement passNameRequiredAlert;

	
	
	
	
	
	public CartRegistration(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String username) {
		logger.info("Starting of setUserName method");
		//this.txtusername.click();
		this.implicitWait();
		this.txtusername.sendKeys(username);

		logger.info("Ending of setUserName method");
	}

	public void setPassword(String password) {
		logger.info("Starting of setPassword method");
		this.implicitWait();
		//this.txtpassword.click();
		this.txtpassword.sendKeys(password);
		logger.info("Ending of setPassword method");
	}

	public void clickOnLoginButton() {
		logger.info("Starting of clickOnLoginButton method");
		this.implicitWait();

		this.btnlogin.click();
		logger.info("Ending of clickOnLoginButton method");
	}

	public String inavlidAlertMsg() {
		logger.info("Starting of inavlidAlertMsg method");
		explicitWait(txtAlertMsg);
		logger.info("Ending of inavlidAlertMsg method");

		return txtAlertMsg.getText();
	}

	public boolean inavlidAlertMsg1() {
		logger.info("Starting of inavlidAlertMsg method");
		explicitWait(txtAlertMsg);
		logger.info("Ending of inavlidAlertMsg method");

		return txtAlertMsg.isDisplayed();
	}

	public ArrayList<String> getErrorMessages() {
		logger.info("Starting of getErrorMessages method");

		ArrayList<String> errorMessages = new ArrayList<>();

		String userName = userNameRequiredAlert.getText();
		String passWord = passNameRequiredAlert.getText();

		errorMessages.add(userName);
		errorMessages.add(passWord);

		logger.info("Ending of getErrorMessages method");

		return errorMessages;

	}
	
	
			
	
	
	}


