package com.opencart.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentTestManager {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();

	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

	public static synchronized void failTest(ExtentTest test, String testName) {

		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		String testResult = "<a href=\"http://www.github.com\\?testName=" + test + "\"> Log Bug for test :" + testName
				+ "</a>";
		test.error(MarkupHelper.createLabel(testResult, ExtentColor.RED));
		try {
			test.addScreenCaptureFromPath(
					"C:\\crcautomation\\crcresources\\screenshots\\courtchecker\\OnePlus Nord\\ALREADY_MEMBER.png");
			test.addScreenCaptureFromPath(
					"C:\\crcautomation\\crcresources\\screenshots\\courtchecker\\OnePlus Nord\\ALREADY_MEMBER_COMP.png");
			test.addScreenCaptureFromPath(
					"C:\\crcautomation\\crcresources\\screenshots\\courtchecker\\OnePlus Nord\\ALREADY_MEMBER_RESULT.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
