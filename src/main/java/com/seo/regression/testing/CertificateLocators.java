package com.seo.regression.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class CertificateLocators
{
	WebDriver driver;
	public CertificateLocators(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public ArrayList<String> LoginStaffUser(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement clickLogin = driver.findElement(By.cssSelector("ul[class*='Header_navButtons']>li:nth-child(2)>a"));
			js.executeScript("arguments[0].scrollIntoView();", clickLogin);
			if(clickLogin.isDisplayed())
			{
				clickLogin.click();
			}
			String baseWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("login?"))
				{
					driver.switchTo().window(window);
					WebElement email = driver.findElement(By.cssSelector("input#email"));
					js.executeScript("arguments[0].scrollIntoView();", email);
					if(email.isDisplayed())
					{
						email.sendKeys(data.get(1));
					}
					WebElement password = driver.findElement(By.cssSelector("input#password"));
					js.executeScript("arguments[0].scrollIntoView();", password);
					if(password.isDisplayed())
					{
						password.sendKeys(data.get(2));
					}
					WebElement submit = driver.findElement(By.cssSelector("input#login_in"));
					js.executeScript("arguments[0].scrollIntoView();", submit);
					if(submit.isDisplayed())
					{
						js.executeScript("arguments[0].click()", submit);
					}
					
					driver.switchTo().window(window);
					
					if(driver.getCurrentUrl().contains("dashboard"))
					{
						driver.switchTo().window(window);
						
						System.out.println("Dashboard page");
					}
					driver.switchTo().window(baseWindow);
				}
				driver.switchTo().window(baseWindow);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	
	public ArrayList<String> checkCertificate(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			List<WebElement> activeCertificates = driver.findElements(By.cssSelector("section[class*='dashboardCourseCards_containerBottom']>div[class*='dashboardCourseCards_bottomActions']>a[class*='dashboardCourseCards_actionViewCertificateActive']"));
			for(int i = 0; i < activeCertificates.size(); i++)
			{
				Thread.sleep(500);
				js.executeScript("arguments[0].scrollIntoView();", activeCertificates.get(i));
				Thread.sleep(500);
				String baseWindow = driver.getWindowHandle();
				String certificateViewURL = activeCertificates.get(i).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(certificateViewURL);
				Set<String> windows = driver.getWindowHandles();
				for(String win : windows)
				{
					driver.switchTo().window(win);
					
					if(driver.getCurrentUrl().contains("certificates"))
					{
						driver.switchTo().window(win);
						
						WebElement facebook = driver.findElement(By.cssSelector("ul[class='social']>li:nth-child(2)>a"));
						js.executeScript("arguments[0].scrollIntoView();", facebook);
						if(facebook.isDisplayed())
						{
							js.executeScript("arguments[0].click()", facebook);
							String certificateScreen = driver.getWindowHandle();
							Set<String> nextWindow = driver.getWindowHandles();
							for(String screen : nextWindow)
							{
								driver.switchTo().window(screen);
								if(driver.getCurrentUrl().contains("facebook"))
								{
									driver.switchTo().window(screen);
									System.out.println("facebook screen");
									driver.close();
									driver.switchTo().window(certificateScreen);
									break;
								}
								driver.switchTo().window(certificateScreen);
							}
							driver.switchTo().window(certificateScreen);
						}
						
						WebElement twitter =  driver.findElement(By.cssSelector("ul[class='social']>li:nth-child(3)>a"));
						js.executeScript("arguments[0].scrollIntoView();", twitter);
						if(facebook.isDisplayed())
						{
							js.executeScript("arguments[0].click()", twitter);
							String certificateScreen = driver.getWindowHandle();
							Set<String> nextWindow = driver.getWindowHandles();
							for(String screen : nextWindow)
							{
								driver.switchTo().window(screen);
								if(driver.getCurrentUrl().contains("twitter"))
								{
									driver.switchTo().window(screen);
									System.out.println("twitter screen");
									driver.close();
									driver.switchTo().window(certificateScreen);
									break;
								}
								driver.switchTo().window(certificateScreen);
							}
							driver.switchTo().window(certificateScreen);
						}
						
						WebElement LinkedIn	= driver.findElement(By.cssSelector("ul[class='social']>li:nth-child(4)>a"));
						js.executeScript("arguments[0].scrollIntoView();", LinkedIn);
						if(facebook.isDisplayed())
						{
							js.executeScript("arguments[0].click()", LinkedIn);
							String certificateScreen = driver.getWindowHandle();
							Set<String> nextWindow = driver.getWindowHandles();
							for(String screen : nextWindow)
							{
								driver.switchTo().window(screen);
								if(driver.getCurrentUrl().contains("linkedin"))
								{
									driver.switchTo().window(screen);
									System.out.println("linkedin screen");
									driver.close();
									driver.switchTo().window(certificateScreen);
									break;
								}
								driver.switchTo().window(certificateScreen);
							}
							driver.switchTo().window(certificateScreen);
						}
						driver.close();
						driver.switchTo().window(baseWindow);
					}
					driver.switchTo().window(baseWindow);
				}
				driver.switchTo().window(baseWindow);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
		
	}
}
