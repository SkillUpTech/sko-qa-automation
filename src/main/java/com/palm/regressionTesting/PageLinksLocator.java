package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class PageLinksLocator
{
	WebDriver driver;
	
	public PageLinksLocator(WebDriver driver)
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
		            if (responseCode >= 400) {
		                System.out.println("Broken link: " + data);
		                status = "fail: " + responseCode;
		            } else {
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
	
	public ArrayList<String> verifyURL(ArrayList<String> data, int rowNumber)
	{
		ArrayList<String> status = new ArrayList<String>();
		String getURL = "";
		try
		{
			String currentEnv = driver.getCurrentUrl();
			String parentWindow = driver.getWindowHandle();
			for (int i = 1; i < data.size(); i++) 
			{
				if(i == 1)
				{
					
					String eachRow = data.get(i);
					if(eachRow.contains("https"))
					{
						getURL = data.get(i);
					}
					else if(eachRow.contains("enterprise"))
					{
						if(currentEnv.contains("qa-in"))
							getURL = "https://qacourses-in.skillup.online"+eachRow;
						else if (currentEnv.contains("qa.skillup"))
							getURL = "https://qacourses.skillup.online" + eachRow;
						else if (currentEnv.contains("dev.skillup"))
							getURL = "https://devcourses.skillup.online" + eachRow;
						else if (currentEnv.contains("dev-in.skillup"))
							getURL = "https://devcourses-in.skillup.online" + eachRow;
						else if (currentEnv.equalsIgnoreCase("https://skillup.online"))
							getURL = "https://courses.skillup.online"+eachRow;
						else if (currentEnv.equalsIgnoreCase("https://in.skillup.online"))
							getURL = "https://courses-in.skillup.online"+eachRow;
						System.out.println(getURL);
					}
					else if(eachRow.contains("password"))
					{
						if(currentEnv.contains("qa-in"))
							getURL = "https://qacourses-in.skillup.online"+eachRow;
						else if (currentEnv.contains("dev-in"))
							getURL = "https://devcourses-in.skillup.online/"+eachRow;
						else if (currentEnv.contains("https://in.skillup.online"))
							getURL = "https://courses-in.skillup.online"+eachRow;
						else if (currentEnv.contains("https://skillup.online"))
							getURL = "https://courses.skillup.online" + eachRow;
						else if (currentEnv.contains("qa.skillup"))
							getURL = "https://qacourses.skillup.online" + eachRow;
						else if (currentEnv.contains("dev.skillup"))
							getURL = "https://devcourses.skillup.online" + eachRow;
						System.out.println(getURL);
					}
					else if(eachRow.equalsIgnoreCase("/blog/"))
					{
						if (currentEnv.contains("https://qa-in.skillup.online") || currentEnv.contains("https://qa.skillup.online"))
							getURL = "https://dev.skillup.online" + eachRow;
						else if (currentEnv.contains("https://dev-in.skillup.online") || currentEnv.contains("https://dev.skillup.online"))
							getURL = "https://dev.skillup.online" + eachRow;
						else if (currentEnv.contains("https://in.skillup.online") || currentEnv.contains("https://skillup.online"))
							getURL = "https://skillup.online" + eachRow;
						System.out.println(getURL);
					}
					else if(eachRow.equalsIgnoreCase("/blog/prpage/"))
					{
						if (currentEnv.contains("qa-in") || currentEnv.contains("https://qa.skillup.online"))
							getURL = "https://dev.skillup.online" + eachRow;
						else if (currentEnv.contains("dev-in") || currentEnv.contains("https://dev.skillup.online"))
							getURL = "https://dev.skillup.online" + eachRow;
						else if (currentEnv.contains("https://in") || currentEnv.contains("https://skillup.online"))
							getURL = "https://skillup.online" + eachRow;
						System.out.println(getURL);
					}
					else if(eachRow.equalsIgnoreCase("/blog/events/"))
					{
						if (currentEnv.contains("qa-in")|| currentEnv.contains("https://qa.skillup.online"))
							getURL = "https://dev.skillup.online" + eachRow;
						else if (currentEnv.contains("dev-in") || currentEnv.contains("https://dev.skillup.online"))
							getURL = "https://dev.skillup.online" + eachRow;
						else if (currentEnv.contains("https://in") || currentEnv.contains("https://skillup.online"))
							getURL = "https://skillup.online" + eachRow;
						System.out.println(getURL);
					}
					else if(eachRow.equalsIgnoreCase("/blog/newsletterpage/"))
					{
						if (currentEnv.contains("qa-in")|| currentEnv.contains("https://qa.skillup.online"))
							getURL = "https://dev.skillup.online" + eachRow;
						else if (currentEnv.contains("dev-in")|| currentEnv.contains("https://dev.skillup.online"))
							getURL = "https://dev.skillup.online" + eachRow;
						else if (currentEnv.contains("https://in") || currentEnv.contains("https://skillup.online"))
							getURL = "https://skillup.online/" + eachRow;
						System.out.println(getURL);
					}
					else if(eachRow.contains("/blog/")&& eachRow.contains("?utm"))
					{
						if (currentEnv.contains("https://qa-in.skillup.online") || currentEnv.contains("https://qa.skillup.online"))
							getURL = "https://skillup.online" + eachRow;
						else if (currentEnv.contains("https://dev-in.skillup.online") || currentEnv.contains("https://dev.skillup.online"))
							getURL = "https://skillup.online" + eachRow;
						else if (currentEnv.contains("https://in.skillup.online") || currentEnv.contains("https://skillup.online"))
							getURL = "https://skillup.online" + eachRow;
						System.out.println(getURL);
					}
					else
					{
						getURL =  OpenWebsite.setHost+eachRow;
						System.out.println(getURL);
					}
					
					  String checkURLStatus = this.checkURLStatus(getURL); 
					  if(checkURLStatus.contains("fail"))
					  { 
						  status.add(checkURLStatus); 
					  } 
					  else 
					  {
					  status.add(checkURLStatus);
					  }
					 
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
}
