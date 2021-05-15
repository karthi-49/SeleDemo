package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.Extentreport;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports e=Extentreport.getReportObject();
	public void onTestStart(ITestResult result) {
		
		
		test=e.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS,"Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		WebDriver d= null;
		String mname=result.getMethod().getMethodName();
		
		try {
			d=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("d").get(result.getInstance());
		} catch (Exception e1) {
		
		}
		try {			
			
			test.addScreenCaptureFromPath(getscreenshotpath(mname,d),mname);
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		e.flush();
	}

	
}
