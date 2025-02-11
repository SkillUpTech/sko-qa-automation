package com.palm.regressionTesting;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class SignUpPageLinksLocator 
{
	WebDriver driver;
	String parentWindow = "";
	String signUpPage = "";
	public SignUpPageLinksLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String checkSignupLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		parentWindow = driver.getWindowHandle();
		try
		{
			WebElement topElement = driver.findElement(By.tagName("body")); // Or any top element
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", topElement);
			
			WebElement clickSignup = driver.findElement(By.cssSelector("div[class*='Header_signupBtn']>a"));
			js.executeScript("arguments[0].scrollIntoView();", clickSignup);
			if(clickSignup.isDisplayed())
			{
					String signupURL = clickSignup.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(signupURL);
					signUpPage = driver.getWindowHandle();
					status = "pass";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	
		
	}
	public String checkFacebookLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			WebElement facebook = driver.findElement(By.cssSelector("div[class='social-section']>a:nth-child(1)"));
			js.executeScript("arguments[0].scrollIntoView();", facebook);
			if(facebook.isDisplayed())
			{
				String fbURL = facebook.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(fbURL);
				System.out.println("facebook page");
				driver.close();
				driver.switchTo().window(signUpPage);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String checkGoogleLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			WebElement google = driver.findElement(By.cssSelector("div[class='social-section']>a:nth-child(2)"));
			js.executeScript("arguments[0].scrollIntoView();", google);
			if(google.isDisplayed())
			{
				String googleURL = google.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(googleURL);
				System.out.println("google page");
				driver.close();
				driver.switchTo().window(signUpPage);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String checkLinkedInLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			WebElement linkedIn = driver.findElement(By.cssSelector("div[class='social-section']>a:nth-child(3)"));
			js.executeScript("arguments[0].scrollIntoView();", linkedIn);
			if(linkedIn.isDisplayed())
			{
				String linkedInURL = linkedIn.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(linkedInURL);
				System.out.println("linkedIn page");
				driver.close();
				driver.switchTo().window(signUpPage);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String checkMicrosoftLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			WebElement microsoftLink = driver.findElement(By.cssSelector("div[class='social-section']>a:nth-child(4)"));
			js.executeScript("arguments[0].scrollIntoView();", microsoftLink);
			if(microsoftLink.isDisplayed())
			{
				String microsoftURL = microsoftLink.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(microsoftURL);
				System.out.println("microsoft page");
				driver.close();
				driver.switchTo().window(signUpPage);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String checkLogInLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			WebElement clickLoginLink = driver.findElement(By.xpath("//a[contains(@href,'login') and contains(@class,'underline')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickLoginLink);
			if(clickLoginLink.isDisplayed())
			{
				String loginURL = clickLoginLink.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(loginURL);
				System.out.println("login page");
				driver.close();
				driver.switchTo().window(signUpPage);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String checkTermsOfServiceLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			WebElement clickTermOfServiceLink = driver.findElement(By.xpath("//a[contains(@href,'tos') and contains(@class,'underline')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickTermOfServiceLink);
			if(clickTermOfServiceLink.isDisplayed())
			{
				String TOSURL = clickTermOfServiceLink.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(TOSURL);
				System.out.println("TOS page");
				driver.close();
				driver.switchTo().window(signUpPage);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String checkPrivacyPolicyLink()
	{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String status = "";
			try
			{
				WebElement clickPrivacyPolicyLink = driver.findElement(By.xpath("//a[contains(@href,'privacy') and contains(@class,'underline')]"));
				js.executeScript("arguments[0].scrollIntoView();", clickPrivacyPolicyLink);
				if(clickPrivacyPolicyLink.isDisplayed())
				{
					String privacyPolicyURL = clickPrivacyPolicyLink.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(privacyPolicyURL);
					System.out.println("Privacy Policy page");
					driver.close();
					driver.switchTo().window(signUpPage);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;
	}
}
