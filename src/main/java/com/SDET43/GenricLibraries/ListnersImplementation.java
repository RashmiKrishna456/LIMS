package com.SDET43.GenricLibraries;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"------->Testscript executed succesfully");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName);
		Reporter.log(methodName+"------->Script executed succesfully");
	}
	
	public void onTestFailure(ITestResult result){
		String FailedTestScript = result.getMethod().getMethodName();
		String Fscript = FailedTestScript + new JavaUtility().getSystemDateInFormat();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+Fscript+".png");
		try {
			FileUtils.copyFileToDirectory(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"------->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(methodName+"------>Script Execution Skipped");
	}
	
	public void onStart(ITestContext context){
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReport\\report.html");
		htmlReport.config().setDocumentTitle("SDET.43 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("LIMS Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base_Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base_url", "http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		report.setSystemInfo("Reporter_Name", "Rashmi.M");
	}
	
	public void onFinish(ITestContext context) {
		//Consolidate all parameters and generate report
		report.flush();
	}
}
