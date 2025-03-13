package com.opencart.pages;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.grpc.netty.shaded.io.netty.handler.timeout.TimeoutException;

public class PimPage extends BaseAutomationPage {

	private static final Logger logger = Logger.getLogger(PimPage.class.getName());

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]")
	private WebElement linkPim;

	@FindBy(xpath = "//h6[text()='PIM']")
	private WebElement header;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement btnadd;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement setfirstName;

	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement setmiddleName;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement setlastName;

	@FindBy(xpath = " //div[@class='oxd-input-group oxd-input-field-bottom-space']//child::div[2]//input[@class='oxd-input oxd-input--active']")
	private WebElement employeeId;

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement requiredAlert;

	@FindBy(xpath = "(//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"])[2]")
	private WebElement requiredAlert1;

	@FindBy(xpath = "//button[text()=' Save ']")
	private WebElement btnSave;

	@FindBy(xpath = "//div[@class='employee-image-wrapper']//img[@alt='profile picture']")
	private WebElement empImage;

	@FindBy(xpath = "//div[@class='oxd-input-group__label-wrapper']//following::span")
	private WebElement employyeIdAlert;

	@FindBy(xpath = "(//label[contains(text(),'Driver')]//following::div//input[@class='oxd-input oxd-input--active'])[1]")
	private WebElement driverLicence;

	@FindBy(xpath = "//i[@class=\"oxd-icon bi-calendar oxd-date-input-icon\"]")
	private WebElement calender;

	@FindBy(xpath = "//div[@class='oxd-select-wrapper']//div") ///// label[text()='Nationality']//following::i[@class='oxd-icon
																///// bi-caret-down-fill oxd-select-text--arrow']
	private WebElement nationality;

	@FindBy(xpath = "//label[text()='Marital Status']//following::i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	private WebElement maritalStatus;
	
	@FindBy(xpath = "(//div[@class=\"oxd-input-group__label-wrapper\"]//following-sibling::div//div//child::input[@class=\"oxd-input oxd-input--active\"])[2]")
	private WebElement DOB;
	
	@FindBy(xpath = "//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']")
	private WebElement gender;
	
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement btnSave1;
	
	@FindBy(xpath = "//label[text()='Blood Type']//following::div//div//div//div[@class='oxd-select-text-input']")
	private WebElement bloodType;
	
	@FindBy(xpath = "//label[text()='Blood Type']//following::div//div//div//div[text()='B+']")
	private WebElement bloodGroup;
	
	@FindBy(xpath ="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]")
	private WebElement savebtn;
	
	@FindBy(xpath ="//p[text()='Successfully Saved']")
	private WebElement toastMessage;
	
	String firstName = null;
	String middleName = null;
	String lastName = null;

	public PimPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	public void linkPim() {
		logger.info(" Starting of linkPIM ");
		this.implicitWait();
		this.linkPim.click();
		logger.info(" Ending  of linkPIM ");
	}

	public boolean header() {
		logger.info(" Starting of linkPIM ");

		this.implicitWait();
		explicitWait(header);

		logger.info(" Starting of linkPIM ");

		return header.isDisplayed();
	}

	public void addBtn() {
		logger.info("Starting of Add Employee Button");
		this.implicitWait();
		this.btnadd.click();
		logger.info("Ending of Add Employee Button");
	}

	public void setFirstName() {
		logger.info("Starting of FirtName");

		this.implicitWait();
		firstName = generateRandomText(9);
		this.setfirstName.sendKeys(firstName);

		logger.info("Ending of FirtName");

	}

	public void setMiddleName() {
		logger.info("Starting of FirtName");

		this.implicitWait();
		middleName = generateRandomText(9);
		this.setmiddleName.sendKeys(middleName);

		logger.info("Ending of FirtName");

	}

	public void setLastName() {
		logger.info("Starting of FirtName");

		this.implicitWait();
		lastName = generateRandomText(9);
		this.setlastName.sendKeys(lastName);

		logger.info("Ending of FirtName");

	}

	public void getEmployeeId() {
		logger.info("Starting of FirtName");

		this.implicitWait();

		String id = this.employeeId.getText();

		logger.info("Ending of FirtName");

	}

	public ArrayList<String> getErrorMessages() {
		logger.info("Starting of errorMessage");

		ArrayList<String> errorMessages = new ArrayList<>();

		String firstname = requiredAlert.getText();
		String lastname = requiredAlert1.getText();
		// String emplyeeid= employyeIdAlert.getText();

		errorMessages.add(firstname);
		errorMessages.add(lastname);
		// errorMessages.add(emplyeeid);

		logger.info("Ending of errorMessage");
		return errorMessages;

	}

	public void employeeImage() throws InterruptedException {

		logger.info("Starting of employeeImage");
		this.implicitWait();
		Thread.sleep(5000);
		this.empImage.click();
		try {
			WebElement uploadElement = this.empImage;
			String filePath = Paths.get("C:\\Users\\NEHAL\\Documents\\OrangeHrmImage").toAbsolutePath().toString();

			// Upload the file by sending the file path to the file input element
			uploadElement.sendKeys(filePath);

		} catch (Exception e) {
			e.printStackTrace(); // Handle the exception
		} finally {

		}

		logger.info("Ending of employeeImage");
	}

	public void imageUpload() {

		// WebElement file=
		// driver.findElement(By.xpath("//div[@class='employee-image-wrapper']//img[@alt='profile
		// picture']"));
		WebElement file = driver.findElement(By.xpath("//input[@type='file']"));/// following-sibling::div/button

		String imagePath = /* System.getProperty("user.dir") + */ "C:\\Users\\NEHAL\\Downloads\\OpenCraftAutomation\\OpenCraftAutomation\\src\\test\\resources\\image.gif";

		file.sendKeys(imagePath);

	}

	public void saveBtn() throws InterruptedException {
		logger.info("Starting of saveBtn");
		this.implicitWait();

		this.btnSave.click();
		Thread.sleep(5000);
		logger.info("Ending of saveBtn");
	}

	public void setDriverLicence(String num) throws InterruptedException {
		logger.info("Starting of setDriverLicence");
		this.implicitWait();
		Thread.sleep(5000);
		driverLicence.sendKeys(num);

		logger.info("Ending of setDriverLicence");
	}

	public void setCalender(String exp) {
		logger.info("Starting of setCalender");
		this.implicitWait();

		Actions an = new Actions(driver);
		an.moveToElement(calender).sendKeys(exp).build().perform();
		logger.info("Starting of setCalender");

	}

	public void nationality() throws InterruptedException {
		logger.info("Starting of nationality");
		// try {
		// scrollIntoView(nationality);
		Thread.sleep(3000);
		nationality.click();
		
WebElement element = driver.findElement(By.xpath("//div[@class='oxd-select-option --selected']//span[text()='Indian']"));
 String elementText = element.getText();
 String expectedText = "India";
 if (elementText.equalsIgnoreCase(expectedText)) {
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
     Thread.sleep(500);
	 Actions at = new Actions(driver);
	 at.moveToElement(element).click().build().perform();
     
 } else {
     System.out.println("Text does not match (case-insensitive).");
 }
    

		logger.info("Ending of nationality");
	}

	public void maritalStatus() {
		logger.info("Starting of saveBtn");
		this.implicitWait();
		Actions an = new Actions(driver);
		an.moveToElement(maritalStatus).click().sendKeys("India").sendKeys(Keys.ARROW_DOWN).build().perform();
		// this.nationality.click();

		logger.info("Ending of saveBtn");
	}
	
	public void setDob(String dob) throws InterruptedException {
		logger.info("Starting of setDob");
		this.implicitWait();
		scrollDown(10);
	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DOB);
		DOB.sendKeys(dob);

		logger.info("Ending of setDob");
	}
	
	public void setGender()  {
		logger.info("Starting of setGender");
		this.implicitWait();
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gender);

         gender.click();
		logger.info("Ending of setGender");
	}

	public void saveButton()  {
		logger.info("Starting of setGender");
		this.implicitWait();
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gender);

         btnSave1.click();
		logger.info("Ending of setGender");
	}
	
	public void selectBloodType()  {
		logger.info("Starting of setGender");
		this.implicitWait();
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bloodType);

       //  bloodType.click();
       //  Actions at = new Actions(driver);
       //  at.moveToElement(bloodGroup).click().build().perform();
         
         Actions at = new Actions(driver);
         at.moveToElement(bloodType).click().build().perform();
         try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
         for(int i=0;i<3;i++) {
        	 at.moveToElement(bloodType).sendKeys(Keys.ARROW_DOWN).build().perform();
         }  
         
      //   bloodGroup.click();
		logger.info("Ending of setGender");
	}
	
	public void btnSave() {
		
		logger.info("Starting of btnSave");
		this.implicitWait();
		
		

		savebtn.click();
		logger.info("Ending of btnSave");
	}
	
public String toastMessage() {
		
		logger.info("Starting of btnSave");
		this.implicitWait();
		
	String toast=	this.toastMessage.getText();
		logger.info("Ending of btnSave");
		return toast;
	}
	
}
