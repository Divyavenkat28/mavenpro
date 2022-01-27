package basepom;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	// chrome browser launch 1 way
public static WebDriver Chromelaunch()
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	return driver;
}
//2 way
public static void ChromeLaunch() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
}
//edge browser launch
public static void EdgeLaunch()
{
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
}
//browser launch
public static void browserLaunch(String browserName)
{
	switch(browserName)
	{
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "edge":
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		break;
	}
}
//browser launch 2
public static void browserName(String browserName) {
	if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
}
//time out
public static void implicitWait(int sec)
{
	driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
	
}
//url
public static void urlLaunch(String url)
{
	driver.get(url);
	driver.manage().window().maximize();
}
//close
public static void close() {
	driver.close();
}
//get title
public static String getTitle()
{
	String title = driver.getTitle();
	return title;
}
//get current url
public static String getCurrentUrl()
{
	String curl = driver.getCurrentUrl();
	return curl;
}
//navigate 
//to
public static void navigateTo(String link)
{
	driver.navigate().to(link);
}
//back
public static void Back()
{
	driver.navigate().back();
}
//forward
public static void Forward()
{
	driver.navigate().forward();
}
//refresh
public static void refresh()
{
	driver.navigate().refresh();
}
//find element
//public static WebElement findElement(String id)
//{
//	WebElement e = driver.findElement(By.id(id));
//	return e;
//	
//}
//sendkeys
public static void sendkeys(WebElement e,String data) {
	e.sendKeys(data);
}
//click
public static void btnclick(WebElement e)
{
	e.click();
}
//get text
public static String getText(WebElement e){
	String text = e.getText();
	return text;
}
//get attribute
public static String getAttribute(WebElement e,String value)
{
	String att = e.getAttribute("value");
	return att;
}
//get attribute(inner text)
public static String getAttributeInnertext(WebElement e,String innertext)
{
	String inner = e.getAttribute("inner text");
	return inner;
}

//Action drag and drop
public static void dragAndDrop(WebElement from, WebElement to)
{
	Actions a=new Actions(driver);
	a.dragAndDrop(from,to).perform();
}
//action click
public static void actClick(WebElement e) {
	Actions a=new Actions(driver);
	a.click(e).perform();
}
//Action movetoelement
public static void moveToElement(WebElement e) {
	Actions a=new Actions(driver);
	a.moveToElement(e).perform();
}
//Action click and hold
public static void clickAndHold(WebElement from,WebElement to)
{
	Actions a=new Actions(driver);
	a.clickAndHold(from).release(to).perform();
}
//Actions double click
public static void doubleClick(WebElement e)
{
	Actions a=new Actions(driver);
	a.doubleClick(e).perform();
}
//Actions Context click
public static void contextClick(WebElement e)
{
	Actions a =new Actions(driver);
	a.contextClick(e).perform();
}
//Alert
public static void accept()
{
	Alert alert = driver.switchTo().alert();
	alert.accept();
}
//Alert
public static void dismiss()
{
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
}
//select
//select by index
public static void selectByIndex(WebElement drp,int index) {
	Select s=new Select(drp);
	s.selectByIndex(index);
}
//select by value
public static void selectByValue(WebElement drp,String value)
{
	Select s=new Select(drp);
	s.selectByValue(value);
}
//select by visible text
public static void selectByVisibleText(WebElement drp,String a)
{
	Select s=new Select(drp);
	s.selectByVisibleText(a);
}
// is multiple
public static boolean isMultiple(WebElement drp) 
{
	Select s=new Select(drp);
	boolean multiple = s.isMultiple();
	return multiple;
}
//get options
public static String getOptions(WebElement drp)
{
	Select s=new Select(drp);
	List<WebElement> options = s.getOptions();
	for(WebElement x:options)
	{
		String text = x.getText();
		return text;
	}
	return null;
}
//get all selected options
public static List<WebElement> getAllSelectedOptions(WebElement drp)
{
	Select s=new Select(drp);
	List<WebElement> options = s.getAllSelectedOptions();
	return options;
}
//get first selected options
public static WebElement getFirstSelectedOptions(WebElement drp)
{
	Select s=new Select(drp);
	 WebElement first = s.getFirstSelectedOption();
	return first;
}
//deselect by index
public static void deSelectByIndex(WebElement drp,int index)
{
	Select s=new Select(drp);
	s.deselectByIndex(index);
}
//deselect by value
public static void deSelectByValue(WebElement drp,String value)
{
	Select s=new Select(drp);
	s.deselectByValue(value);
}
//deselect by visibletext
public static void deSelectByVisibleText(WebElement drp,String value)
{
	Select s=new Select(drp);
	s.deselectByVisibleText(value);
}
//deselect all
public static void deSelectAll(WebElement drp)
{
	Select s=new Select(drp);
	s.deselectAll();
}
//Screenshot
public static void takeScreenShot(String Filename) throws IOException
{
	TakesScreenshot tk=(TakesScreenshot)driver;
	File from = tk.getScreenshotAs(OutputType.FILE);
	File to=new File("C:\\Users\\Rajagopalan Kannan\\eclipse-workspace\\Selenium\\Screenshot\\"+Filename+".png");
	FileUtils.copyFile(from,to);
	
}
//Javascript executor
//set attribute
public static void jsSetAttribute(WebElement e,String data)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('value','"+data+"')",e);
}
//click
public static void jsClick(WebElement e)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click()",e);
}
//Scroll down
public static void jsScrolldown(WebElement e)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",e);
}
//Scroll up
public static void jsScrollup(WebElement e)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(false)",e);
}
//get attribute
public static String jsGetAttribute(WebElement e)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	Object text = js.executeScript("return arguments[0].getAttribute('value')",e);
	return text.toString();
	
}
//window handling
//parent id
public static String getWindowHandle()
{
	String id = driver.getWindowHandle();
	return id;
}
//all windows id
public static Set<String> getWindowHandles()
{
	Set<String> allid = driver.getWindowHandles();
	return allid;
}
//quit
public static void quit() {
	driver.quit();
}
//framesswitch
public static void framesSwitch(int index)
{
	driver.switchTo().frame(index);
}

}
