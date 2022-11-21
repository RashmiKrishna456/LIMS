package com.LIMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NomineeInfoPage {

	//Declaration
	@FindBy (xpath = "//a[text()='Add Nominee']")
	private WebElement addNomineeBtn;
	
	//Initialization
	public NomineeInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getAddNomineeBtn() {
		return addNomineeBtn;
	}
	
	//Business Libraries
	public void NomineeInformation()
	{
		addNomineeBtn.click();
	}
}
