package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver d;
	public Properties prop;
	public  WebDriver initializeDriver()throws IOException
	{
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\karth\\Selenium Test Cases\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String bName = prop.getProperty("browser");
		if(bName.equals("Chrome"))
		{
			  WebDriverManager.chromedriver().setup();
			  d=new ChromeDriver();
		}
		else if(bName.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			  d=new EdgeDriver();
		}
		else if(bName.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			d=new InternetExplorerDriver();
		}
		
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		return d;
	}
	
	public String getscreenshotpath(String s,WebDriver d) throws IOException
	{
		TakesScreenshot tks=(TakesScreenshot)d;
		File src=tks.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\reports\\"+s+".png";
		FileUtils.copyFile(src,new File(dest));
		return dest;
	}

}
