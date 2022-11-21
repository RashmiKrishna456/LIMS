package com.LIMS.ObjectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNominee {

	//Declaration
	@FindBy (name = "client_id")
	private WebElement clientIDTB;
	
	@FindBy (name = "name")
	private WebElement nameTB;
	
	@FindBy (name = "sex")
	private WebElement genderTB;
	
	@FindBy (name = "birth_date")
	private WebElement birtDateTB;
	
	@FindBy (name = "nid")
	private WebElement nidTB;
	
	@FindBy (name = "relationship")
	private WebElement relationshipTB;
	
	@FindBy (name = "priority")
	private WebElement priorityTB;
	
	@FindBy (name = "phone")
	private WebElement phoneTB;
	
	@FindBy (xpath = "//input[@type ='submit']")
	private WebElement submitTB;
	
	//Initialization
	public AddNominee(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getClientIDTB() {
		return clientIDTB;
	}

	public WebElement getNameTB() {
		return nameTB;
	}

	public WebElement getGenderTB() {
		return genderTB;
	}

	public WebElement getBirtDateTB() {
		return birtDateTB;
	}

	public WebElement getNidTB() {
		return nidTB;
	}

	public WebElement getRelationshipTB() {
		return relationshipTB;
	}

	public WebElement getPriorityTB() {
		return priorityTB;
	}

	public WebElement getPhoneTB() {
		return phoneTB;
	}

	public WebElement getSubmitTB() {
		return submitTB;
	}
	
	//Business Libraries
	
	public void addNomineePage(Map<String, String> map, WebDriver driver) 
	{
		for (Entry<String, String> set : map.entrySet()) 
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}
	
	public void clickonSubmitBtn()
	{
		submitTB.click();
	}
	
//	public void AddNomineeInfo(String clientID, String Name, String Gender, String birtDate, 
//			String NID, String Relationship, String priority, String phone)
//	{
//		clientIDTB.sendKeys(clientID);
//		nameTB.sendKeys(Name);
//		genderTB.sendKeys(Gender);
//		birtDateTB.sendKeys(birtDate);
//		nidTB.sendKeys(NID);
//		relationshipTB.sendKeys(Relationship);
//		priorityTB.sendKeys(priority);
//		phoneTB.sendKeys(phone);
//		submitTB.click();
//	}
}
