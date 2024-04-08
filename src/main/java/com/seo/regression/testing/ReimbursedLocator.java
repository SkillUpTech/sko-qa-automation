package com.seo.regression.testing;

import java.net.HttpURLConnection;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;


public class ReimbursedLocator
{
	WebDriver driver;
	int respCode = 200;
	HttpURLConnection huc = null;
	MicrosoftCourseLocator microsoftCourseLocator;
	
	public ReimbursedLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String checkLaunchCourse(String data)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			String url = OpenWebsite.setURL+data;
			String urlStatus = microsoftCourseLocator.checkCourseCode(url);
			if(!urlStatus.contains("fail"))
			{
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String checkReimbursedLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String checkLinkFromReimbursedPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
