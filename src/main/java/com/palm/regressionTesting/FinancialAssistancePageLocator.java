package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinancialAssistancePageLocator
{
	WebDriver driver;
	
	public FinancialAssistancePageLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String checkURLStatus(String data)
	{
		  String status = "fail";
	        HttpURLConnection connection = null;
	        int responseCode = 200;
			 try 
			 {
		            connection = (HttpURLConnection) (new URL(data).openConnection());
		            connection.setRequestMethod("GET");
		            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		            connection.connect();
		            responseCode = connection.getResponseCode();
		            System.out.println("Status code: " + responseCode + " URL: " + data);
		            if (responseCode >= 400 && responseCode <= 405 || responseCode == 410 || responseCode == 429 || responseCode >=500 && responseCode <= 505) 
		            {
		                System.out.println("Broken link: " + data);
		                status = "fail: " + responseCode;
		            } 
		            else 
		            {
		                System.out.println("Unbroken link: " + data + " " + responseCode);
		                status = "success";
		            }
		        } 
			 catch (Exception e) 
			 {
		            e.printStackTrace();
		     }
			 finally
			 {
		            if (connection != null)
		            {
		                connection.disconnect();
		            }
			 }
			return status;
	}
	
	
	public String checkLink(String data)
	{
		
		String status = "fail";
		try
		{
			String urlStatus = this.checkURLStatus(data);
			if (urlStatus.contains("fail")) 
			{
				status = "fail";
			} 
			else
			{
				status = "success";
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String checkFinanceLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			if(driver.findElements(By.xpath("//div[contains(@class,'CourseDescription_noEMICost')]/a")).size()>0)
			{
				WebElement element = driver.findElement(By.xpath("//div[contains(@class,'CourseDescription_noEMICost')]/a"));
				js.executeScript("arguments[0].scrollIntoView();", element);
				if (element.isDisplayed()) 
				{
					js.executeScript("arguments[0].click();", element);
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
