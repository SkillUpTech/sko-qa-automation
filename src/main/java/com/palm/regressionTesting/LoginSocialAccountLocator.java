package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSocialAccountLocator
{
	WebDriver driver;
	
	public LoginSocialAccountLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	public void openLoginPage()
	{
		driver.get(OpenWebsite.setHost+"/login");
		
	}
	public ArrayList<String> verifyFacebook(String user, String pwd)
	{
		ArrayList<String> data = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement clickFacebook = driver.findElement(By.xpath("//a[contains(@onClick,'facebook')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickFacebook);
			if(clickFacebook.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickFacebook);
				if(driver.getCurrentUrl().contains("facebook"))
				{
					System.out.println("facebook page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
					driver.navigate().back();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
					driver.navigate().refresh();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
				}
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			data.add("error in this function");
		}
		return data;
	}
	public ArrayList<String> verifyGoogle(String user, String pwd)
	{
		ArrayList<String> data = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement clickGoogle = driver.findElement(By.xpath("//a[contains(@onClick,'facebook')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickGoogle);
			if(clickGoogle.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickGoogle);
				if(driver.getCurrentUrl().contains("google"))
				{
					System.out.println("google page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
					driver.navigate().back();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
					driver.navigate().refresh();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
				}
				
			}
			
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			data.add("error in this function");
		}
		return data;
	}
	public ArrayList<String> verifyLinkedIn(String user, String pwd)
	{
		ArrayList<String> data = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement clickLinkedIn = driver.findElement(By.xpath("//a[contains(@onClick,'facebook')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickLinkedIn);
			if(clickLinkedIn.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickLinkedIn);
				if(driver.getCurrentUrl().contains("linked"))
				{
					System.out.println("linked In page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
					driver.navigate().back();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
					driver.navigate().refresh();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
				}
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			data.add("error in this function");
		}
		return data;
	}
	public ArrayList<String> verifyMicrosoft(String user, String pwd)
	{
		ArrayList<String> data = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement clickMicrosoft = driver.findElement(By.xpath("//a[contains(@onClick,'facebook')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickMicrosoft);
			if(clickMicrosoft.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickMicrosoft);
				if(driver.getCurrentUrl().contains("microsoftonline"))
				{
					System.out.println("Microosft page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
					driver.navigate().back();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
					driver.navigate().refresh();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			data.add("error in this function");
		}
		return data;
	}
}
