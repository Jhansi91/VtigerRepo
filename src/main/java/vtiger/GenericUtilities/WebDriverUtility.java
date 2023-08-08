package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all reusable methods related to web driver actions
 * @author jhans
 *
 */
public class WebDriverUtility
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) //update driver reference
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/** This method will wait for all the findElement and findElements
	 * operations to be performed
	 * @param driver
	 */
	public void waitForElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait until the specified element is visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
	Select sel=new Select(element);
	sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
	Select sel=new Select(element);
	sel.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown using visible text
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hover action on a target element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform double click action anywhere on webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();;
	}
	
	/**
	 * This method will perform double click action on particular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();;
	}
	
	/**
	 * This method will perform right click action anywhere on webpage
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}

	/**
	 * This method will perform right click action on particular webelement
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcelement
	 * @param targetelement
	 */
	public void dragAndDrop(WebDriver driver,WebElement srcelement,WebElement targetelement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcelement, targetelement).perform();
		
	}
	
	/**
	 * This method is used to move cursor anywhere on the webpage based on offset values 
	 * @param driver
	 * @param xOffset
	 * @param yOffset
	 */
	public void moveAcrossWebPage(WebDriver driver,int xOffset,int yOffset)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(xOffset, yOffset).click().perform();
	}
	
	/**
	 * This method will scroll vertically for 500 pixels
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);","");
	}
	
	/**
	 * This method will scroll vertically until the element  reference
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+");",element);
		
		//js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 * @param element
	 */
	public void acceptAlert(WebDriver driver,WebElement element)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the confirmation pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will enter text in prompt pop up
	 * @param driver
	 * @param text
	 */
	public void sendTextToAlert(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	/**
	 * This method will capture the alert message and return to the  caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle frame based on frame index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on value of name or Id attributes
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame on web element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will help to switch the control back to immediate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will help to switch control back to current page
	 * @param driver
	 */
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will switch the selenium Webdriver control from parent to child 
	 * or child to parent based on partial window Title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//step1: capture all the window Ids
		Set<String> allWindowIds = driver.getWindowHandles();
		
		//step2:iterate through individual Ids
		for(String winId:allWindowIds)
		{
			//step3:switch to each Id and capture the title
			String currenttitle = driver.switchTo().window(winId).getTitle();
			
			//step4: compare the title with required reference
			if(currenttitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * This method will take screen shot and return the absolute path of it
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\ScreenShots\\"+screenShotName+".png");
		Files.copy(src, dst); //this class is from commons IO tool
		
		return dst.getAbsolutePath(); // to attach the screenshot to extent report
		
		
	}
 }
