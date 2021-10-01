package com.base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalLib {
	public static  WebDriver driver;
	public WebDriver getDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid Browser Name:"+browser);
			break;
		}
		driver.manage().window().maximize();
		return driver;

	}
	public WebDriverWait webDriverWait() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait;

	}

	public void launchUrl(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}
	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}
	public String getcurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public WebElement findLocator(String locatorType, String locatorValue) {

		WebElement element = null;
		switch (locatorType) {
		case "id":
			element = driver.findElement(By.id(locatorValue));
			break;
		case "name":
			element = driver.findElement(By.name(locatorValue));
			break;
		case "className":
			element = driver.findElement(By.className(locatorValue));
			break;
		case "tagName":
			element = driver.findElement(By.tagName(locatorValue));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locatorValue));
			break;
		default:
			System.out.println("Invalid Locator Type:"+locatorType);
			break;
		}
		return element;

	}
	public List<WebElement> findLocators(String locatorType, String locatorValue) {
		List<WebElement> elements = null;
		switch (locatorType) {
		case "id":
			elements = driver.findElements(By.id(locatorValue));
			break;
		case "name":
			elements = driver.findElements(By.name(locatorValue));
			break;
		case "className":
			elements = driver.findElements(By.className(locatorValue));
			break;
		case "tagName":
			elements = driver.findElements(By.tagName(locatorValue));
			break;
		case "xpath":
			elements = driver.findElements(By.xpath(locatorValue));
			break;
		default:
			System.out.println("Invalid Locator Type:"+locatorType);
			break;
		}
		return elements;

	}
	public void sendText(WebElement element, String value) {
		element.sendKeys(value);
	}
	public void click(WebElement element) {
		element.click();

	}
	public String getAttribute(WebElement element, String Attribute) {
		String text = element.getAttribute(Attribute);
		return text;

	}
	public String getText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public void moveMouseToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void dragAndDrop(WebElement source , WebElement destination) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).perform();

	}
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}
	public void doubleClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void typewithJavaScript(WebElement element , String value ) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','"+value+"')", element);

	}
	public void clickBtnWithJavaScript(WebElement element ) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);

	}

	public void scrollDown(WebElement element) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollInToView(true)", element);
	}
	public void scrollUp(String scrollDirection , WebElement element) {
		JavascriptExecutor executor =(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollInToView(false)", element);
	}
	public void switchToAlert(String options) {
		webDriverWait().until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		switch (options) {
		case "ok":
			alert.accept();
			break;
		case "cancel":
			alert.dismiss();
		default:
			System.out.println("Enter ok or cancel only");
			break;
		}
	}
	public void switchToAlert(String text , String options) {
		webDriverWait().until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
		switch (options) {
		case "ok":
			alert.accept();
			break;
		case "cancel":
			alert.dismiss();
		default:
			System.out.println("Enter ok or cancel only");
			break;
		}
	}
	public String getTextFromAlert() {
		webDriverWait().until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}
	public void takeScreenShot(String folderName, String fileName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\pcs\\Desktop\\screenshot\\"+folderName+"\\"+fileName+".png");
		FileUtils.copyFile(screenshotAs, file);
	}
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(String idOrName) {
		webDriverWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
		driver.switchTo().frame(idOrName);
	}
	public void switchToFrame(WebElement element) {
		webDriverWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		driver.switchTo().frame(element);
	}
	public void switchToParrentFrame() {
		driver.switchTo().parentFrame();
	}
	public void switchTodefaultWindow() {
		driver.switchTo().defaultContent();

	}

	public void selectOptionsFromDropDown(WebElement element, String option ,String value ) {
		Select select = new Select(element);
		switch (option) {
		case "visibleText":
			select.selectByVisibleText(value);
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(value));
		default:
			System.out.println("Invalid Option type:"+option);
			break;
		}

	}
	public void deselectOptionsFromDropDown(WebElement element, String option ,String value) {
		Select select = new Select(element);
		switch (option) {
		case "visibleText":
			select.deselectByVisibleText(value);
			break;
		case "value":
			select.deselectByValue(value);
			break;
		case "index":
			select.deselectByIndex(Integer.parseInt(value));
		default:
			System.out.println("Invalid Option type:"+option);
			break;
		}

	}
	public void deselectAllOptionsFromDropDown(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}
	public List<String> getAllOptionsFromDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		List<String> list = new ArrayList<String>();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			list.add(text);
		}
		return list;
	}
	public List<String> getAllSelectedOptionsFromDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getAllSelectedOptions();
		List<String> list = new ArrayList<String>();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			list.add(text);
		}
		return list;
	}
	public void closeCurrentFocusingBrowser() {
		driver.close();
	}
	public void closeAllBrowsers() {
		driver.quit();
	}
	public void goBackToPreviousPage() {
		driver.navigate().back();
	}
	public void goForwardToNextPage() {
		driver.navigate().forward();
	}
	public void refreshThePage() {
		driver.navigate().refresh();
	}
	public void clearTextFromTextBox(WebElement element) {
		element.clear();
	}
	public WebElement findLocatorUsingWebElement(WebElement element, String locatorType, String value) {
		WebElement element2=null;
		switch (locatorType) {
		case "id":
			element2 = element.findElement(By.id(value));
			break;
		case "name":
			element2 = element.findElement(By.name(value));
			break;
		case "className":
			element2 = element.findElement(By.className(value));
			break;
		case "tagName":
			element2 = element.findElement(By.tagName(value));
			break;
		case "xpath":
			element2 = element.findElement(By.xpath(value));
			break;
		default:
			System.out.println("Invalid Locator Type: "+locatorType);
			break;
		}
		return element2;
	}
	public List<WebElement> findLocatorsUsingWebElement(WebElement element, String locatorType, String value) {
		List<WebElement> element2=null;
		switch (locatorType) {
		case "id":
			element2 = element.findElements(By.id(value));
			break;
		case "name":
			element2 = element.findElements(By.name(value));
			break;
		case "className":
			element2 = element.findElements(By.className(value));
			break;
		case "tagName":
			element2 = element.findElements(By.tagName(value));
			break;
		case "xpath":
			element2 = element.findElements(By.xpath(value));
			break;
		default:
			System.out.println("Invalid Locator Type: "+locatorType);
			break;
		}
		return element2;
	}
	public String getParentWindowId() {
		String parentWindow = driver.getWindowHandle();
		return parentWindow;
	}
	public Set<String> getAllWindowsId() {
		Set<String> allWindows = driver.getWindowHandles();
		return allWindows;
	}

}
