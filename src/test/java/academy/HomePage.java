package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPass;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	 WebDriver d;
	@BeforeTest
	public void initialize() throws IOException
	{
		 d=initializeDriver();

	}

	@Test(dataProvider="data")
	public void basePageNavigation(String u,String p,String t) throws Exception {
		
		
		 d.get("http://qaclickacademy.com");
		 Thread.sleep(3000);
		 LandingPage h=new LandingPage(d);
		 LoginPage l=h.getLogin();	 
		 l.getEmail().sendKeys(u);
		 l.getPass().sendKeys(p);
		 log.info(t);
		 l.Login().click();
		 ForgotPass fp=l.Forgot();
		fp.getEmail().sendKeys("Kohli");
		fp.sme().click();
		 
	
	}
		 
	@DataProvider
	public Object[][] data()
	{
		return new Object[][] {{"karthik.sachin","karthi1234","Restricted user"}};
	}
	

}
