package com.palm.regressionTesting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InviteOnlyLocator {
	MicrosoftCourseLocator microsoftCourseLocator;
	WebDriver driver;
	public InviteOnlyLocator(WebDriver driver)
	{
		this.driver = driver;
		this.microsoftCourseLocator = new MicrosoftCourseLocator(this.driver);
	}
	
	public String checkCourseCode(String codeFromExcel)
	{
		String statusOfURL = "";
		try
		{
			String url="";
			int respCode = 200;
			HttpURLConnection huc = null;
			String addHosturl = "";
				String endURL = codeFromExcel;
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

						// get redirect url from "location" header field
						String newUrl = conn.getHeaderField("Location");

						// get the cookie if need, for login
						String cookies = conn.getHeaderField("Set-Cookie");

						conn = (HttpURLConnection) new URL(newUrl).openConnection();
						conn.setRequestProperty("Cookie", cookies);
						conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
						conn.addRequestProperty("User-Agent", "Mozilla");
						conn.addRequestProperty("Referer", "google.com");
												
						System.out.println("Redirect to URL : " + newUrl);

					}

					BufferedReader in = new BufferedReader(
				                              new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer html = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						html.append(inputLine);
					}
					in.close();

					System.out.println("Done");
					if(status==200 || status==308)
					{
						statusOfURL=Integer.toString(status);
					}
					else
					{
						statusOfURL=Integer.toString(status);
					}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return statusOfURL;
	}
	public ArrayList<String> checkStatusCode_inviteOnlyCourse(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			for(int i = 1; i < data.size(); i++)
			{
				
				String urlStatus=this.checkCourseCode(data.get(i));
				if(!urlStatus.equalsIgnoreCase("200")||urlStatus.equalsIgnoreCase("308"))
				{
					System.out.println("status code for "+data.get(i)+"  : " + urlStatus);
				}
				else
				{
					status.add(data.get(i));
					System.out.println("status code for "+data.get(i)+"  : " + urlStatus);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> checkDate_inviteOnlyCourse(ArrayList<String> data)
	{

		ArrayList<String> status = new ArrayList<String>();
		try
		{
			for(int i = 1; i < data.size(); i++)
			{
				
					 String originalHandle = driver.getWindowHandle();

				     ((JavascriptExecutor)driver).executeScript("window.open()");

				        for (String handle : driver.getWindowHandles())
				        {
				                driver.switchTo().window(handle);
				                if(!handle.equals(originalHandle))
				                {
				                	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
				                	driver.switchTo().window(handle);
				                	driver.get(OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE));
				                	driver.get(driver.getCurrentUrl()+data.get(i));
				                	String newTabTitle = driver.getTitle();
				                	System.out.println("Title of the new tab: " + newTabTitle+ " url of the course : "+driver.getCurrentUrl());
				                	WebElement checkSelfpaced = driver.findElement(By.cssSelector("div[class*='CourseDescription_levelSection'] h2"));
				                	if(checkSelfpaced.isDisplayed())
				                	{
				                		System.out.println("It is selfpaced course");
				                		if(driver.getCurrentUrl().contains("/courses/"))
				                		{
				                			driver.switchTo().window(handle);
				                			if(newTabTitle.contains("null"))
					                		{
					                			System.out.println("tab ststus is : "+newTabTitle);
					                			status.add(data.get(i));
					                		}
					                		if(newTabTitle.contains("undefined"))
					                		{
					                			System.out.println("tab ststus is : "+newTabTitle);
					                			status.add(data.get(i));
					                		}
				                			driver.close();
				                			break;
				                		}
				                	}
				                	else
				                	{
				                		System.out.println("It is not self paced course");
				                		status.add(data.get(i));
				                	}
				                }
				        }
				        driver.switchTo().window(originalHandle);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

public ArrayList<String> checkProgram_Courses(ArrayList<String> data)
{
	ArrayList<String> status = new ArrayList<String>();
	try
	{
		for(int k = 1; k < data.size(); k++)
		{
			String URLStatus = this.checkCourseCode(data.get(k));
			if(URLStatus.contains("200") || URLStatus.contains("308"))
			{
				String originalHandle = driver.getWindowHandle();
				
				((JavascriptExecutor)driver).executeScript("window.open()");
				
				for (String handle : driver.getWindowHandles())
				{
					driver.switchTo().window(handle);
					if(!handle.equals(originalHandle))
					{
						driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
						driver.switchTo().window(handle);
						driver.get(OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE));
						driver.get(driver.getCurrentUrl()+data.get(k));
						String newTabTitle = driver.getTitle();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
						if(driver.findElements(By.cssSelector("div[class='PageNotFound_textSection__3ecIh']")).size()>0)
						{
							System.out.println("404 error : "+data.get(k));
							status.add(data.get(k));
							driver.close();
							break;
						}
						else
						{
							WebElement progrmaOnCourse = driver.findElement(By.cssSelector("div[class*='CourseDescription_warningBox'] div[class*='CourseDescription_warningBoxText']"));
							List<WebElement> listOfPrograms = progrmaOnCourse.findElements(By.cssSelector(" ul>li>a"));
							if(listOfPrograms.size()>0)
							{
								
								for(int i = 0; i < listOfPrograms.size(); i++)
								{
									String programLinkonCourse = listOfPrograms.get(i).getAttribute("href");
									System.out.println("Progrma link is : "+programLinkonCourse);
									String replace[] = programLinkonCourse.split("online", 2);
									System.out.println(replace[1]);
									String statusOfURL = this.checkCourseCode(replace[1]);
									
									if(statusOfURL.equalsIgnoreCase("200")||statusOfURL.equalsIgnoreCase("200"))
									{
										System.out.println("Program link status from courses : "+statusOfURL);
									}
									else
									{
										System.out.println("Program link status from courses : "+statusOfURL);
										status.add(data.get(k));
										driver.close();
										break;
									}
									if(newTabTitle.equalsIgnoreCase("null"))
									{
										System.out.println("tab ststus is : "+newTabTitle);
										status.add(data.get(k));
										driver.close();
									}
									if(newTabTitle.equalsIgnoreCase("undefined"))
									{
										System.out.println("tab ststus is : "+newTabTitle);
										status.add(data.get(k));
										driver.close();
									}
								}
							}
							else
							{
								System.out.println("program not available on this link : "+data.get(k));
							}
							break;
						}
					}
				}
				driver.switchTo().window(originalHandle);
			}
			else
			{
				System.out.println(" url status : "+URLStatus);
				status.add(data.get(k));
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return status;
}

public ArrayList<String> checkInviteOnly_Courses(ArrayList<String> data)
{
	ArrayList<String> status = new ArrayList<String>();
	try
	{
		for(int k = 1; k < data.size(); k++)
		{
			String originalHandle = driver.getWindowHandle();
			
			((JavascriptExecutor)driver).executeScript("window.open()");
			
			for (String handle : driver.getWindowHandles())
			{
				driver.switchTo().window(handle);
				if(!handle.equals(originalHandle))
				{
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
					driver.switchTo().window(handle);
					driver.get(OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE));
					driver.get(driver.getCurrentUrl()+data.get(k));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
					if(driver.findElements(By.cssSelector("div[class='PageNotFound_textSection__3ecIh']")).size()>0)
					{
						System.out.println("404 error : "+data.get(k));
						status.add(data.get(k));
						break;
					}
					else
					{
                		if(driver.getCurrentUrl().contains("/courses/"))
                		{
                			driver.switchTo().window(handle);
                			WebElement checkSelfpaced = driver.findElement(By.cssSelector("div[class*='CourseDescription_levelSection']>h2"));
    	                	if(checkSelfpaced.getText().contains("Self-Paced")||checkSelfpaced.getText().contains("vILT"))
    	                	{
	                			System.out.println("It is selfpaced of vILT course");
	                			driver.close();
    	                	}
	                	}
	                	else
	                	{
	                		status.add(data.get(k));
	                		break;
	                	}
					}
				}
			}
			driver.switchTo().window(originalHandle);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return status;
}

public ArrayList<String> checkEnrollmentDateIsExpiredFuturedCurrent_Courses(ArrayList<String> data)
{
	ArrayList<String> status = new ArrayList<String>();
	try
	{

		for(int k = 1; k < data.size(); k++)
		{
			String originalHandle = driver.getWindowHandle();
			
			((JavascriptExecutor)driver).executeScript("window.open()");
			
			for (String handle : driver.getWindowHandles())
			{
				driver.switchTo().window(handle);
				if(!handle.equals(originalHandle))
				{
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
					driver.switchTo().window(handle);
					driver.get(OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE));
					driver.get(driver.getCurrentUrl()+data.get(k));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
					if(driver.findElements(By.cssSelector("div[class='PageNotFound_textSection__3ecIh']")).size()>0)
					{
						System.out.println("404 error : "+data.get(k));
						status.add(data.get(k));
						break;
					}
					else
					{
                		if(driver.getCurrentUrl().contains("/courses/"))
                		{
                			driver.switchTo().window(handle);
                			WebElement checkEnrollmentStatus = driver.findElement(By.cssSelector("div[class*='CourseDescription_buttonsContent']>h6"));
        					if(checkEnrollmentStatus.isDisplayed())
        					{
        						if(checkEnrollmentStatus.getText().contains("Enrollment is Closed"))
        						{
        							System.out.println("enrollment closed");
        							driver.close();
        						}
        						else if(driver.findElement(By.cssSelector("button[class*='CourseDescription_enrollNowBtn']")).getText().contains("Enroll Now"))
        						{
        							System.out.println("enrollment currently open");
        							driver.close();
        						}
        						else if(driver.findElement(By.cssSelector("button[class*='CourseDescription_enrollNowBtn']")).getText().contains("Start Now"))
        						{
        							System.out.println("enrollment is on Startnow status");
        							driver.close();
        						}
    	                	}
	                	}
					}
				}
			}
			driver.switchTo().window(originalHandle);
		}
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return status;
}

}
