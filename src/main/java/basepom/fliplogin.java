package basepom;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class fliplogin extends BaseClass {
	public fliplogin()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[text()='✕']")
	private WebElement close;
	@FindBy(xpath="//a[text()='Login']")
	private WebElement login;
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	private WebElement txtemail;
	@FindBy(xpath="//input[@type='password']")
	private WebElement txtpassword;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement lgn;
	//getter
	public WebElement getClose() {
		return close;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getTxtemail() {
		return txtemail;
	}
	public WebElement getTxtpassword() {
		return txtpassword;
	}
	public WebElement getLgn() {
		return lgn;
	}
	
}
