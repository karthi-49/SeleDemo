package academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class ValidateTitle extends Base{

	WebDriver d;
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize()throws IOException
	{
		 d=initializeDriver();
		 log.info("Driver is initialized");
		 d.get(prop.getProperty("URL"));
		 log.info("Navigated to home page");
	}
	@Test
	public void basePageNavigation() 
	{

		 LandingPage h=new LandingPage(d);
         Assert.assertEquals(h.getTitle().getText(),"FEATUREd COURSES");
         Assert.assertTrue(h.getNav().isDisplayed());
         log.info("Successfully validated text message");
	
	}
	
	@AfterTest
	
	public void Breakdown()
	{
		d.close();
	}
}
