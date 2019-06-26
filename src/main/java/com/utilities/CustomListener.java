package com.utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import generic.TestBase;

public class CustomListener implements ITestListener {

	public void onTestFailure(ITestResult tr) {
		File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scrFile, new File("D:\\Amit\\" + tr.getName() + ".png"));
			Reporter.log("take screen shot");
		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("Fail to take screen shot");
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);

		try {
			FileHandler.copy(scrFile, new File("D:\\Amit\\" + result.getName() + ".png"));
			Reporter.log("take screen shot");
		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("Fail to take screen shot");
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scrFile, new File("D:\\Amit\\" + context.getName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("Fail to take screen shot");
		}
	}

	public void onFinish(ITestContext context) {
		File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scrFile, new File("D:\\Amit\\" + context.getName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("Fail to take screen shot");
		}

	}
}
