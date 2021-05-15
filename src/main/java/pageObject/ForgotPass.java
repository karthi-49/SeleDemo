package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPass {
	
public WebDriver d;
	


	By email=By.id("user_email");
	By sme=By.cssSelector("input[name='commit']");
	
	
	public ForgotPass(WebDriver d2) {
		this.d=d2;
	}

	
	public WebElement getEmail()
	{
		return d.findElement(email);
	}

	
	public WebElement sme()
	{
		 return d.findElement(sme);
	
	}
	
}
