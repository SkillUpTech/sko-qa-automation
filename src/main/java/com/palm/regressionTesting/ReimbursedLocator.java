package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;


public class ReimbursedLocator
{
	WebDriver driver;
	int respCode = 200;
	HttpURLConnection huc = null;
	String url = "";
	String courseTitle = "";
	String coursePage = "";
	public ReimbursedLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	String parentWindow = "";
	
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
	public String checkLaunchCourse(String data)
	{
		String status = "";
		try
		{
			parentWindow = driver.getWindowHandle();
			url = driver.getCurrentUrl()+data;
			String urlStatus = this.checkURLStatus(url);
			if(!urlStatus.contains("fail"))
			{
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(80));
				coursePage = driver.getWindowHandle();
				System.out.println("course opened : "+url);
				courseTitle = driver.findElement(By.xpath("//h1")).getText();
				status = "pass";
			}
			else
			{
				status = "fail";
				System.out.println("course not opened : "+url);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String checkReimbursedLink()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			 WebElement reimbursedLink = driver.findElement(By.cssSelector("div[class*='CourseDescription_getreimbursed']>a"));
			 js.executeScript("arguments[0].scrollIntoView();", reimbursedLink);
			 if(reimbursedLink.isDisplayed())
			 {
				 String url = reimbursedLink.getAttribute("href");
				 driver.switchTo().newWindow(WindowType.TAB);
				 driver.get(url);
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
	
	public String checkLinkFromReimbursedPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
					System.out.println("reimbursed page");
					List<WebElement> linkFromReimbursed = driver.findElements(By.cssSelector("div#email-body>p>a"));
					js.executeScript("arguments[0].scrollIntoView();", linkFromReimbursed.get(0));
					if(linkFromReimbursed.get(0).isDisplayed())
					{
						String url = linkFromReimbursed.get(0).getAttribute("href");
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(url);
						 String checkTitleFromReimbursedPagelink = driver.findElement(By.xpath("//h1")).getText();
						 if(checkTitleFromReimbursedPagelink.equals(courseTitle))
						 {
							 System.out.println("course url and reimbursed page url are same");
							 status = "pass";
						 }
						 else
						 {
							 status = "fail";
						 }
					}
			driver.close();
			driver.switchTo().window(coursePage);
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			 status = "fail";
		}
		return status;
	}
}
