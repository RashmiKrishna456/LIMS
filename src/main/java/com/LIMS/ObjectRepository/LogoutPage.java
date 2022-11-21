package com.LIMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	//declaration
	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement LogoutBtn;
	
	//Initialization
	public LogoutPage(WebDriver driver)
	{
			PageFactory.initElements(driver, this);
		}
	//Utilization

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	
	//Business Libraries
	public void logout()
	{
		LogoutBtn.click();
	}
}
