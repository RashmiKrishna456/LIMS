package com.LIMS.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Declaration
	@FindBy(linkText = "CLIENTS")
	private WebElement clientBtn;
	
	@FindBy(linkText = "AGENTS")
	private WebElement agentsBtn;
	
	@FindBy (linkText = "POLICY")
	private WebElement policyBtn;
	
	@FindBy (linkText = "NOMINEE")
	private WebElement nomineeBtn;
	
	@FindBy (linkText = "PAYMENTS")
	private WebElement paymentsBtn;	
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getClientBtn() {
		return clientBtn;
	}
	public WebElement getAgentsBtn() {
		return agentsBtn;
	}
	public WebElement getPolicyBtn() {
		return policyBtn;
	}
	public WebElement getNomineeBtn() {
		return nomineeBtn;
	}
	public WebElement getPaymentsBtn() {
		return paymentsBtn;
	}
	
	//Business Libraries
	
	public void clientModule()
	{
		clientBtn.click();
	}
	public void agentModule()
	{
		agentsBtn.click();
	}
	public void nomineeModule()
	{
		nomineeBtn.click();
	}
	public void paymentsModule()
	{
		paymentsBtn.click();
	}
	
}
