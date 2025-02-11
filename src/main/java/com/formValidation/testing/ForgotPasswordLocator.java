package com.formValidation.testing;

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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordLocator
{
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@class,'Header_loginBtn')]/a")  
    WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(@class,'forgotpass')]")  
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//input[@id='email']")  
	WebElement emailField;
	
	@FindBy(xpath = "//input[@id='reset_password']")  
	WebElement sendEmailButton;
	
	//a[contains(text(),'Go to Homepage ')]
	
	@FindBy(xpath = "//a[contains(text(),'Go to Homepage ')]")  
	WebElement GoToHomepageButton;
	
	
	@FindBy(xpath = "//div[@currentmail='']//div[contains(text(),'Password')]/parent::button")  
	WebElement locateCurrentPasswordResetMailFromYopmail;
	
	@FindBy(xpath = "//div[@currentmail='']//div[contains(text(),'Activate')]/parent::button")  
	WebElement locateActivateMailFromYopmail;
	
	
	@FindBy(xpath = "//a[contains(@href,'activate')]")  
	WebElement clickActivateLinkFromMail;
	
	
	String parentWindow = "";
	
	public ForgotPasswordLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String openLoginSite()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "fail";
		try
		{
			parentWindow = driver.getWindowHandle();
			js.executeScript("arguments[0].scrollIntoView();", loginButton);
			if (loginButton.isDisplayed()) 
			{
				String getLoginURL = loginButton.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getLoginURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				js.executeScript("arguments[0].scrollIntoView();", forgotPasswordLink);
				if (forgotPasswordLink.isDisplayed())
				{
					String getForgotPasswordURL = forgotPasswordLink.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(getForgotPasswordURL);
					status = "pass";
				} 
				else
				{
					status = "fail";
				}
			} 
		}
		catch (Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String forgotPasswordProcess(ArrayList<String> data) throws InterruptedException
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", emailField);
			if (emailField.isDisplayed())
			{
				emailField.sendKeys(data.get(1));
				js.executeScript("arguments[0].scrollIntoView();", sendEmailButton);
				js.executeScript("arguments[0].click();", sendEmailButton);
				Set<String> windows = driver.getWindowHandles();
				for(String allWindows : windows)
				{
					driver.switchTo().window(allWindows);
					if(driver.getCurrentUrl().contains("/password_reset/"))
					{
						driver.switchTo().window(allWindows);
						status = "pass";
						
					}
				}
			} 
			
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("forget password process done");
		return status;
	}

	public ArrayList<String> checkYopmailForResetPasswor()
	{
		ArrayList<String> data = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://yopmail.com/wm");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			js.executeScript("arguments[0].scrollIntoView();", locateCurrentPasswordResetMailFromYopmail);
			if(locateCurrentPasswordResetMailFromYopmail.isDisplayed())
			{
				js.executeScript("arguments[0].click();", locateCurrentPasswordResetMailFromYopmail);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
				for (WebElement iframe : iframes)
				{
					driver.switchTo().frame(iframe);
					js.executeScript("arguments[0].scrollIntoView();", clickActivateLinkFromMail);
					if (clickActivateLinkFromMail.isDisplayed())
					{
						js.executeScript("arguments[0].click();", clickActivateLinkFromMail);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						data.add("Success");
						break;
					}
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public ArrayList<String> checkYopmailForActivateNewMail()
	{
		ArrayList<String> data = new ArrayList<String>();
		try
		{
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://yopmail.com/wm");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	public ArrayList<String> verifyRegisteredEmail(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}

	public ArrayList<String> verifyRegisteredNonEmail(ArrayList<String> data)
	{
		return null;
		
	}
	
	public ArrayList<String> verifyNonActivatedEmail(ArrayList<String> data)
	{
		return null;
		
	}
}
