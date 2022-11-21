package com.LIMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//declaration
	@FindBy (name = "username")
	private WebElement userNameEdit;
	
	@FindBy(name = "password")
	private WebElement passwordEdit;
	
	@FindBy (xpath = "//button[text()='login']")
	private WebElement LoginBtn;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}
	public WebElement getPasswordEdit() {
		return passwordEdit;
	}
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	//Business Libraries
	
	public void login(String un, String pwd)
	{
		userNameEdit.sendKeys(un);
		passwordEdit.sendKeys(pwd);
		LoginBtn.click();
	}
}

