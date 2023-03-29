package utility;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener,ISuiteListener{

	public void onStart(ISuite suite) {
		System.out.println("---------Suite Started"+suite.getName());
	}

	public void onFinish(ISuite suite) {
		System.out.println("---------Suite finished"+suite.getName());
	}

	public void onTestStart(ITestResult result) {
		
		System.out.println("******TestStarted"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("******TestSuccess"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("******TestFailure"+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("******TestSkipped"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("******TestFailedButWithinSuccessPercentage"+result.getName());
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		System.out.println("******TestFailedWithTimeout"+result.getName());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("******TestFinished"+context.getName());
	}
	
	

}
