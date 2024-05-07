package com.seo.regression.testing;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class OnboardingLocator
{
WebDriver driver;
	
	public OnboardingLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String checkLogin(String email, String pwd)
	{
		try
		{
			WebElement loginPage = driver.findElement(By.cssSelector("li[class*='Header_loginBtn']>a"));
			String loginURL = loginPage.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(loginURL);
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("login?"))
				{
					driver.switchTo().window(window);
					
					WebElement enterEmail = driver.findElement(By.cssSelector("input#email"));
					WebElement enterPwd = driver.findElement(By.cssSelector("input#password"));
					WebElement submit = driver.findElement(By.cssSelector("input#login_in"));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public String checkPersonalPage()
	{
		
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public String checkInterestedPage()
	{
		
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public String checkWorkstatusPage()
	{
		
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public String checkAboutYouPage()
	{
		
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public String checkEducationPage()
	{
		
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public String checkJobOpportunites()
	{
		
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
