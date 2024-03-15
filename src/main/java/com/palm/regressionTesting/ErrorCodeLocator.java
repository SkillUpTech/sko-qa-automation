package com.palm.regressionTesting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class ErrorCodeLocator
{
	WebDriver driver;
	public ErrorCodeLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public ArrayList<String> checkCourseCode(ArrayList<String> codeFromExcel)
	{
		ArrayList<String> statusOfErrorCode = new ArrayList<String>();
		
		String url="";
		int respCode = 200;
		HttpURLConnection huc = null;
		String addHosturl = "";
		for(int i = 1; i < codeFromExcel.size(); i++)
		{
			String endURL = codeFromExcel.get(i);
			if(endURL.contains("enterprise"))
			{	
				if(OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE).contains("stage"))
				{
					url = "https://stagecourses-in.skillup.online"+endURL;
					addHosturl = url;
				}
			}
			else
			{
				url = OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE)+endURL;
				addHosturl = url;
			}
			try
			{

				URL obj = new URL(url);
				HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
				conn.setReadTimeout(5000);
				conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
				conn.addRequestProperty("User-Agent", "Mozilla");
				conn.addRequestProperty("Referer", "google.com");

				System.out.println("Request URL ... " + addHosturl);

				boolean redirect = false;

				// normally, 3xx is redirect
				int status = conn.getResponseCode();
				if (status != HttpURLConnection.HTTP_OK) {
					if (status == HttpURLConnection.HTTP_MOVED_TEMP
						|| status == HttpURLConnection.HTTP_MOVED_PERM
							|| status == HttpURLConnection.HTTP_SEE_OTHER)
					redirect = true;
				}

				System.out.println("Response Code ... " + status);

				if (redirect) {

					String newUrl = conn.getHeaderField("Location");

					String cookies = conn.getHeaderField("Set-Cookie");

					conn = (HttpURLConnection) new URL(newUrl).openConnection();
					conn.setRequestProperty("Cookie", cookies);
					conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
					conn.addRequestProperty("User-Agent", "Mozilla");
					conn.addRequestProperty("Referer", "google.com");
											
					System.out.println("Redirect to URL : " + newUrl);

				}

				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer html = new StringBuffer();

				while ((inputLine = in.readLine()) != null)
				{
					html.append(inputLine);
				}
				in.close();

				System.out.println("Done");
				if(status>200)
				{
					statusOfErrorCode.add(addHosturl + " : status code :  "+status);
				}
			    } 
			catch (Exception e) 
			{
				e.printStackTrace();
				statusOfErrorCode.add(addHosturl+" : error");
			}

			  }
			
		return statusOfErrorCode;
	}

	public ArrayList<String> checkURLRedirection(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String redirectedURL = "";
		
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows)
		{
			driver.switchTo().window(window);
			if(driver.getCurrentUrl().equalsIgnoreCase(OpenWebsite.setURL+"/"))
			{
				try
				{
					String currentTabHandle = driver.getWindowHandle();
					for(int i = 1; i < data.size(); i++)
					{
						if(i == 1)
						{
							((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE)+data.get(i));	
							Set<String> windowHandles = driver.getWindowHandles();
							for (String handle : windowHandles)
							{
								driver.switchTo().window(handle);
									if (driver.getCurrentUrl().contains(data.get(i+1)))
									{
										driver.switchTo().window(handle);
										redirectedURL = driver.getCurrentUrl();
										URL url = new URL(redirectedURL);

							            // Remove the hostname
							            String path = url.getPath();
							            String modifiedUrl = path;
										System.out.println("Redirected URL : "+redirectedURL);
										if(data.get(i+1).equals(modifiedUrl))
										{
											System.out.println("redirected is equal");
											driver.close();
											break;
										}
										else
										{
											status.add(modifiedUrl);
											driver.close();
											break;
										}
									}
									
							}  
							driver.switchTo().window(currentTabHandle);
						}
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			driver.switchTo().window(parent);
		}
		
		
		return status;
	}

}
