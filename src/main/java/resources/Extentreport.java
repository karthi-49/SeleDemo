package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {
	
	static ExtentReports extent;

	public static ExtentReports getReportObject(){
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter e=new ExtentSparkReporter(path);
		e.config().setReportName("Web Automation Results");
		e.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(e);
		extent.setSystemInfo("Tester", "Karthik");
		
		return extent;
	}
}
