package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursePurchaseActivationHandlerLocator
{
	WebDriver driver;
	String parentWindow;
	SignUpLocator signUpLocator;
	RegressionGenericLocator regressionGenericLocator;
	ProcessLogin processLogin;
	
	public CoursePurchaseActivationHandlerLocator(WebDriver driver)
	{
		this.driver = driver;
		this.signUpLocator = new SignUpLocator(driver);
		this.regressionGenericLocator = new RegressionGenericLocator(driver);
		this.processLogin = new ProcessLogin(driver);
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
	
	public String checkLanuchUrl(String data)
	{
		String status = "fail";
		parentWindow = driver.getWindowHandle();
		try
		{
			String url = OpenWebsite.setURL+data;
			String checkURL = this.checkURLStatus(url);
			if (checkURL.contains("fail"))
			{
				status = "fail";
			} 
			else
			{
				status = "pass";
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
				System.out.println("URL launched successfully");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			}
		} 
		catch (Exception e) 
		{
			System.out.println("URL not launched");
			status = "fail";
		}
		return status;
	}

	public ArrayList<String> enroll(ArrayList<String> data)
	{
		ArrayList<String> statusOfProcess = new ArrayList<String>();
		try
		{
			statusOfProcess.add(regressionGenericLocator.checkOutRazorpay(data.get(1)));
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			statusOfProcess.addAll(regressionGenericLocator.indiaPaymentProcess(data.get(2), data.get(3)));
			Thread.sleep(1000);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return statusOfProcess;
	}
	
	public String verifyEnrollButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String enrollLocator = "button[class*='CourseDescription_enrollNowBtn']";
		String statusOfEnroll = "fail";
		try
		{
			WebElement checkEnrollButton = driver.findElement(By.cssSelector(enrollLocator));
			wait.until(ExpectedConditions.visibilityOf(checkEnrollButton));
			js.executeScript("arguments[0].scrollIntoView()", checkEnrollButton);
			wait.until(ExpectedConditions.elementToBeClickable(checkEnrollButton));
			if(checkEnrollButton.isDisplayed())
			{
				js.executeScript("arguments[0].click()", checkEnrollButton);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
				statusOfEnroll = "pass";
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			statusOfEnroll = "fail";
		}
		return statusOfEnroll;
	}
	
	public ArrayList<Integer> verifySignupProcess(ArrayList<String> data)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		String signupLocator = "//li[@id='signuplink']/a[contains(@href,'register')]";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for (String window : allWindows) 
			{
				driver.switchTo().window(window);
				if (driver.getCurrentUrl().contains("login")) 
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
					WebElement signupIcon = driver.findElement(By.xpath(signupLocator));
					js.executeScript("arguments[0].scrollIntoView()",signupIcon);
					if(signupIcon.isDisplayed())
					{
						js.executeScript("arguments[0].click()", signupIcon);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						break;
					}
				}
			}
			statusOfTestCase.addAll(signUpLocator.signUpFunction(data));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return statusOfTestCase;
	}
	
	public String verifyDashboard()
	{
		String status = "fail";
		String continueDashboardButton = "//a[contains(text(),'Continue to your Dashboard')]";
		String dropdownFromDashboardPage = "//li[contains(@class,'Header_SigNUP')]/a";
		String signOutFromDashboardPage = "//ul[contains(@class,'dropdown-menu Header')]/li[5]/a";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			
			if(driver.findElements(By.xpath(continueDashboardButton)).size()>0)
			{
				WebElement clickContinueDashboard = driver.findElement(By.xpath(continueDashboardButton));
				js.executeScript("arguments[0].scrollIntoView()",clickContinueDashboard);
				if (clickContinueDashboard.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickContinueDashboard);
					status = "pass";
				}
			}
			
				
			Set<String> windows = driver.getWindowHandles();
			for(String window : windows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("dashboard"))
				{
					driver.switchTo().window(window);
					System.out.println("dashboard page");
					status = "pass";
				}
			}
			
			if(driver.findElements(By.xpath(dropdownFromDashboardPage)).size()>0)
			{
				WebElement clickDropdownFromDashboard = driver.findElement(By.xpath(dropdownFromDashboardPage));
				js.executeScript("arguments[0].scrollIntoView()",clickDropdownFromDashboard);
				if (clickDropdownFromDashboard.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickDropdownFromDashboard);
					status = "pass";
					
					if(driver.findElements(By.xpath(signOutFromDashboardPage)).size()>0)
					{
						WebElement clickSignout = driver.findElement(By.xpath(signOutFromDashboardPage));
						js.executeScript("arguments[0].scrollIntoView()",clickSignout);
						if (clickSignout.isDisplayed())
						{
							js.executeScript("arguments[0].click()", clickSignout);
							status = "pass";
						}
					}
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String verifyLoginProcess(String username, String password)
	{
		String status = "fail";
		try
		{
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			status = processLogin.loginFunction(username, password);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			 status = "fail";
		}
		return status;
	}
	
}
