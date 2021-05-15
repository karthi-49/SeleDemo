package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
public WebDriver d;
	


	By email=By.id("user_email");
	By pass=By.id("user_password");
	By login=By.cssSelector("[value='Log In']");
	By forgot=By.cssSelector("a[href*='pass']");
	
	
	public LoginPage(WebDriver d2) {
		this.d=d2;
	}

	public WebElement getEmail()
	{
		return d.findElement(email);
	}

	public WebElement getPass()
	{
		return d.findElement(pass);
	}
	
	public WebElement Login()
	{
		return d.findElement(login);
		
	}

	public ForgotPass Forgot()
	{
		d.findElement(forgot).click();
		return new ForgotPass(d); 
	}

}

