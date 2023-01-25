package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to all the methods in ITestListener
 * interface of TestNG
 * 
 * @author sharu
 *
 */
public class ListenersImplentationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(result.getMethod().getAttributes());
		test = report.createTest(methodName);
		test.log(Status.INFO, "Test Execution started: " + methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "Test Script Passed- " + methodName);
	}

	public void onTestFailure(ITestResult result) {
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String environment = null;
		try {
			environment = pUtil.readDataFromPropertyFile("server");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "Test Script failed - " + methodName);
		test.log(Status.FAIL, result.getThrowable());

		String screenshotName = methodName + "-" + jUtil.getSystemDateInFormat();
		try {

			if (environment.equalsIgnoreCase("local")) {
				/*
				 * Captures screenshot in 'Screenshots' folder and attaches it to extent report
				 * when executed on local system
				 */
				String path = wUtil.takeScreenshot(BaseClass.sdriver, screenshotName);
				test.addScreenCaptureFromPath(path);
			} else if (environment.equalsIgnoreCase("remote")) {

				/* Creates screenshot in 'Screenshots' folder of project */
				wUtil.takeScreenshot(BaseClass.sdriver, screenshotName);

				/*
				 * Extracts name of jenkins job since System.getProperty("user.dir") when
				 * executing from Jenkins returns local directory path like
				 * 'C:\ProgramData\Jenkins\.jenkins\workspace\WCSM23-SmokeSuite'
				 */
				String jenkinsJobName = System.getProperty("user.dir")
						.substring(System.getProperty("user.dir").lastIndexOf("\\") + 1);

				/* Creates path to captured screenshot in current jenkins job's workspace */
				String pathToScreenshotInJob = "/job/" + jenkinsJobName + "/ws/Screenshots/" + screenshotName + ".png";

				/* Attaches screenshot captured from Jenkins job's workspace to the extent report*/
				test.addScreenCaptureFromPath(pathToScreenshotInJob);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "Test Script skipped- " + methodName);
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("====== Suite Execution Started =====");

		ExtentSparkReporter htmlReport = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new JavaUtility().getSystemDateInFormat() + ".html");
		htmlReport.config().setDocumentTitle("VTiger Execution Report");
		htmlReport.config().setReportName("VTiger Suite Execution");
		htmlReport.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "http://localhost:8888/");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Reporter Name", "Sharun");
	}

	public void onFinish(ITestContext context) {
		System.out.println("====== Suite Execution Finished =====");
		report.flush();
	}

}
