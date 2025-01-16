package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessLogin
{
	WebDriver driver;
	String url = "";
	String parentWindow = "";
	public ProcessLogin(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	public String loginFunction(String userName, String passWord) throws InterruptedException
	{
		String loginStatus="success";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try
		{
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			if(driver.findElements(By.cssSelector("ul[class*='list-unstyled navbar-nav nav Header_navButtons'] li[class*='Header_loginBtn'] a")).size()>0)
			{
				
				WebElement clickLogin = driver.findElement(By.cssSelector("ul[class='list-unstyled navbar-nav nav Header_navButtons__3h4Rp'] li[class='Header_loginBtn__3Xv3A'] a"));
				js.executeScript("arguments[0].scrollIntoView();", clickLogin);
				wait.until(ExpectedConditions.elementToBeClickable(clickLogin));
				if(clickLogin.isDisplayed())
				{
					String loginURL = clickLogin.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(loginURL);
					  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
					  js.executeScript("window.scrollBy(0, 200)", ""); WebElement userNameElement =
					  driver.findElement(By.cssSelector("input#email"));
					  js.executeScript("arguments[0].scrollIntoView();", userNameElement);
					  userNameElement.clear(); userNameElement.sendKeys(userName); WebElement
					  passwordElement = driver.findElement(By.cssSelector("input#password"));
					  js.executeScript("arguments[0].scrollIntoView();", passwordElement);
					  passwordElement.clear(); passwordElement.sendKeys(passWord);
					  js.executeScript("window.scrollBy(0, 100)", ""); WebElement clickSubmit =
					  driver.findElement(By.cssSelector("input[value='Log In']"));
					  js.executeScript("arguments[0].scrollIntoView();", clickSubmit);
					  if(clickSubmit.isDisplayed())
					  { 
						  js.executeScript("arguments[0].click()", clickSubmit); 
					  } 
					  loginStatus = this.ErrorMessage();
					  if(loginStatus.equalsIgnoreCase("fail"))
					  {
						  loginStatus = "Failed"; 
					  } 
					  else 
					  {
					  loginStatus= this.checkUserAfterLoggedIn();
					  } 
					  } 
					 
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			loginStatus="failed";
		}
		return loginStatus;
	}
	public String ErrorMessage()
	{
		String loginStatus = null;
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			if(driver.findElements(By.xpath("//div[contains(text(),'Email or password is incorrect.')]")).size()>0)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				loginStatus = "fail";
				System.out.println("error message displayed");
			}
			else
			{
				System.out.println("no error message");
				loginStatus = "Success";
			}
			
		}
		catch(Exception e)
		{
			System.out.println("no error message");
			e.printStackTrace();
		}
		
		return loginStatus;
	}
	
	public String checkUserAfterLoggedIn()
	{
		String loginStatus=null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
			try
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				Thread.sleep(2000);
				Set<String> listOfWindow = driver.getWindowHandles();
				for(String windows : listOfWindow)
				{
					Thread.sleep(1000);
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("personalized/"))
					{
						driver.switchTo().window(windows);
						System.out.println("onboarding journey page");
						loginStatus = "Success";
						break;
					 }
					else if(driver.getCurrentUrl().contains("dashboard"))
					{
						Thread.sleep(1000);
						driver.switchTo().window(windows);
						WebElement clickDropDown = driver.findElement(By.cssSelector("li[class*='SigNUP'] img[alt='icon']"));
						js.executeScript("arguments[0].scrollIntoView();", clickDropDown);
						if(clickDropDown.isDisplayed())
						{
							js.executeScript("arguments[0].click()", clickDropDown);
						}
						Thread.sleep(1000);
						WebElement checkLoggedName = driver.findElement(By.cssSelector("li[class*='SigNUP'] ul[class*='dropdown-menu'] li:nth-child(1) a"));
						js.executeScript("arguments[0].scrollIntoView();", checkLoggedName);
						String checkText = checkLoggedName.getText();
						if(checkText.contains("Hello"))
						{
							loginStatus = "Success";
							System.out.println("logged in successfully");
							Thread.sleep(2000);
							WebElement clickSignOut = driver.findElement(By.cssSelector("div[class='headerRight']>ul:nth-child(4) ul[class*='dropdown-menu']>li:nth-child(5)>a"));
							js.executeScript("arguments[0].scrollIntoView();", clickSignOut);
							if(clickSignOut.isDisplayed())
							{
								js.executeScript("arguments[0].click()", clickSignOut);
							}
							System.out.println("log out successfully");
							Thread.sleep(1000);
							
						}
						else
						{
							loginStatus = "Failed";
							System.out.println("not logged in ");
						}
					}
				}
			}
		catch(Exception e)
		{
			e.printStackTrace();
			loginStatus = "Failed";
		}
		return loginStatus;
	}
	public void logOutFunction() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			WebElement clickDropdown = driver.findElement(By.cssSelector("li[class*='SigNUP'] img[class='dPaRoW']"));
			js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickDropdown);
			}
			wait.until(ExpectedConditions.elementToBeClickable(clickDropdown));
			WebElement clickSignOut = driver.findElement(By.cssSelector("ul[class*='dropdown-menu Header_Primary'] li:nth-child(5) a"));
			js.executeScript("arguments[0].scrollIntoView();", clickSignOut);
			if(clickSignOut.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickSignOut);
			}
			wait.until(ExpectedConditions.elementToBeClickable(clickSignOut));
			System.out.println("logout successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> checkInvalidUsername(String uName, String pwd) throws InterruptedException
	{
		ArrayList<String> InvalidUsername = new ArrayList<String>();
		System.out.println("Invalid Email Process started");
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			parentWindow = driver.getWindowHandle();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			InvalidUsername.add(this.loginFunction(uName, pwd));
			driver.close();
			//driver.switchTo().window(driver.getWindowHandles().iterator().next());
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			InvalidUsername.add("exception");
		}
		return InvalidUsername;
	}
	public ArrayList<String> checkInvalidPassword(String uName, String pwd) throws InterruptedException
	{
		ArrayList<String> InvalidPassword = new ArrayList<String>();
		try
		{
			System.out.println("Invalid password Process started");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(OpenWebsite.setURL+"/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			InvalidPassword.add(this.loginFunction(uName, pwd));
			driver.close();
			//driver.switchTo().window(driver.getWindowHandles().iterator().next());
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			InvalidPassword.add("exception");
		}
		return InvalidPassword;
	}
	public ArrayList<String> checkInvalidUserNameAndPassword(String uName, String pwd) throws InterruptedException
	{
		ArrayList<String> InvalidUserNameAndPassword = new ArrayList<String>();
		try
		{
			System.out.println("InvalidEmail and Password process started");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(OpenWebsite.setURL+"/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			InvalidUserNameAndPassword.add(this.loginFunction(uName, pwd));
			driver.close();
		//	driver.switchTo().window(driver.getWindowHandles().iterator().next());
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			InvalidUserNameAndPassword.add("exception");
		}
		return InvalidUserNameAndPassword;
	}
	public ArrayList<String> checkValidCredentials(String uName, String pwd) throws InterruptedException
	{
		ArrayList<String> ValidCredentials = new ArrayList<String>();
		try
		{
			System.out.println("valid data process started");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(OpenWebsite.setURL+"/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			ValidCredentials.add(this.loginFunction(uName, pwd));
			driver.close();
			//driver.switchTo().window(driver.getWindowHandles().iterator().next());
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			ValidCredentials.add("exception");
		}
		System.out.println("login process done");
		return ValidCredentials;
	}
}
