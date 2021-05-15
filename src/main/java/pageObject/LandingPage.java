package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver d;

	By login=By.xpath("//*[text()='Login']");
	By title=By.xpath("//h2[contains(text(),'Feature')]");
	By nav=By.xpath("//nav/ul/li[8]/a");
	
	public LandingPage(WebDriver d) {
		this.d=d;
	}

	public LoginPage getLogin()
	{
		 d.findElement(login).click();
		 return new LoginPage(d);
	}
	public WebElement getTitle()
	{
		return d.findElement(title);
	}
	public WebElement getNav()
	{
		return d.findElement(nav);
	}
}
