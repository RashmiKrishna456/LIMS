package com.SDET43.GenricLibraries;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
* its contains WebDriver specific reusable actions
* @author Admin
*/
public class WebDriverUtility 
{
		/**
		* wait for page to load before identifying any synchronized element in DOM [HTML-Document]
		* @param driver
		*/
	public void waitForPageToLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		/**
		* wait for page to load before identifying any asynchronized[java scripts actions] element in DOM [HTML-Docuent]
		* @param driver
		*/
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	/**
	 * This method is used until element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		/**
		* used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
		* @param driver
		* @param element
		*/
	public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		/**
		* used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
		* @param driver
		* @param element
		* @param pollingTime in the form second
		* @throws Throwable
		*/
	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	/**
	 * This method will switch between windows
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
		//step1: use getWindowHandes to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		
		//step2: iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//step3: check whether there is next window
		while(it.hasNext())
		{
			//step4: capture current window id
			String winId = it.next();
			
			//step5: switch to current window and capture title 
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6: check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
		}
		/**
		* used to Switch to Alert Window & click on OK button
		* @param driver
		*/
	public void swithToAlertWindowAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
		}
		/**
		* used to Switch to Alert Window & click on Cancel button
		* @param driver
		*/
	public void swithToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		}
		/**
		* used to Switch to Frame Window based on index
		* @param driver
		* @param index
		*/
	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
		}
		/**
		* used to Switch to Frame Window based on id or name attribute
		* @param driver
		* @param id_name_attribute
		*/
	public void swithToFrame(String nameOrID, WebDriver driver) {
		driver.switchTo().frame(nameOrID);
		}
	/**
	 * This method will switch the frame based on address
	 * @param driver
	 * @param address
	 */
	public void swithToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
		}
	/**
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
		}
		/**
		* used to select the value from the dropDwon based on index
		* @param driver
		* @param index
		*/
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
		}
		/**
		* used to select the value from the dropDwon based on value / option available in GUI
		* @param element
		* @param value
		*/
	public void select(WebElement element , String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
		}
	/**
	 * used to select the value from the dropDwon based on Visible Text
	 * @param value
	 * @param element
	 */
	public void select(String value, WebElement element)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
	}
		/**
		* used to place mouse cursor on specified element
		* @param driver
		* @param elemnet
		*/
	public void mouseOverOnElemnet(WebDriver driver , WebElement elemnet)
		{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
		}
	 /** This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dst) 
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(src,dst).perform();
	}
	/**
	 * This method will perform right click on WebPage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
		/**
		* used to right click on specified element
		* @param driver
		* @param elemnet
		*/
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
		{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
		}
	/**
	 * This method will press Enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to Enter the Key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to release the key
	 * @throws Throwable 
	 */
	
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will double click on WebPage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
		/**
		*
		* @param driver
		* @param javaScript
		*/
	public void executeJavaScript(WebDriver driver , String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
		}
	public void waitAndClick(WebElement element) throws InterruptedException
		{
		int count = 0;
		while(count<20) {
		try {
		element.click();
		break;
		}catch(Throwable e){
		Thread.sleep(1000);
		count++;
		}
		}
		}
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenshotName+".PNG");
		FileUtils.copyFile(src, dest);
		}
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,800)","");
	}
	/**
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		//jse.executeScript("argument[0].scrollIntoView()", element);
	}
	/**
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
}
