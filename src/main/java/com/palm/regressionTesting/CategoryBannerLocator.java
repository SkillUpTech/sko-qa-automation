package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class CategoryBannerLocator
{
	WebDriver driver;
	String parentWindow = "";
	String categoryBannerPage = "";
	public CategoryBannerLocator(WebDriver driver)
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
            if (data != null && !data.isEmpty())
            {
                connection = (HttpURLConnection) (new URL(data).openConnection());
                connection.setRequestMethod("GET");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                connection.connect();
                responseCode = connection.getResponseCode();
                System.out.println("Status code: " + responseCode + " URL: " + data);
                if (responseCode >= 400 && responseCode <= 405 || responseCode == 410 || responseCode == 429 || responseCode >= 500 && responseCode <= 505) {
                    System.out.println("Broken link: " + data);
                    status = "fail: " + responseCode;
                } else {
                    System.out.println("Unbroken link: " + data + " " + responseCode);
                    status = "success";
                }
            } 
            else 
            {
                System.out.println("Invalid URL: " + data);
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
	
	public ArrayList<String> verifyBanner(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean checkStatus = false;
		
		parentWindow = driver.getWindowHandle();
		String getURL = driver.getCurrentUrl();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(getURL);
		categoryBannerPage = driver.getWindowHandle();
		try
		{
			for(int i = 1; i < data.size(); i++)
			{
				String urlLink = driver.getCurrentUrl()+data.get(i);
				String urlStatus = this.checkURLStatus(urlLink);
				
				if(!urlStatus.contains("fail"))
				{
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(urlLink);
					
					List<WebElement> banners = driver.findElements(By.xpath("//ul[@class='slick-dots']/li/button"));
					
					for(int j = 1; j <= banners.size(); j++)
					{
						
						if(driver.findElements(By.xpath("//ul[@class='slick-dots']/li["+(j)+"]/button")).size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							
							WebElement checkActiveBanner = driver.findElement(By.xpath("//ul[@class='slick-dots']/li["+j+"]/button"));
							
							js.executeScript("arguments[0].scrollIntoView();", checkActiveBanner);
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							
							js.executeScript("arguments[0].click()", checkActiveBanner);
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							
								
							if(driver.findElements(By.xpath("//div[@class='slick-slide slick-active slick-current']//button[contains(text(),'Download Whitepaper')]")).size()>0)
							{
								checkStatus = true;
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
								WebElement clickWhitepaper = driver.findElement(By.xpath("//div[@class='slick-slide slick-active slick-current']//button[contains(text(),'Download Whitepaper')]"));
								js.executeScript("arguments[0].scrollIntoView();", clickWhitepaper);
								js.executeScript("arguments[0].click()", clickWhitepaper);
								String parent = driver.getWindowHandle();
								Set<String> windows = driver.getWindowHandles();
								for(String window : windows)
								{
									driver.switchTo().window(window);
									
									if(driver.getCurrentUrl().contains("whitepaper"))
									{
										driver.switchTo().window(window);
										
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
										System.out.println("whitepaper page : "+driver.getCurrentUrl());
										status.add("pass");
										driver.navigate().back();
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
										Thread.sleep(1000);
										driver.switchTo().window(parent);
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
									}
								}
									driver.switchTo().window(parent);
							}
							else if(driver.findElements(By.xpath("//div[@class='slick-slide slick-active slick-current']//button[contains(text(),'Download Brochure')]")).size()>0)
							{
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
								WebElement clickBrochureButton = driver.findElement(By.xpath("//div[@class='slick-slide slick-active slick-current']//button[contains(text(),'Download Brochure')]"));
								js.executeScript("arguments[0].scrollIntoView();", clickBrochureButton);
								js.executeScript("arguments[0].click()", clickBrochureButton);
								String parent = driver.getWindowHandle();
								Set<String> windows = driver.getWindowHandles();
								for(String window : windows)
								{
									driver.switchTo().window(window);
									
									if(driver.getCurrentUrl().contains("techmaster"))
									{
										driver.switchTo().window(window);
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
										System.out.println("Broucher page : "+driver.getCurrentUrl());
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
										status.add("pass");
										driver.navigate().back();
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
										Thread.sleep(1000);
										driver.switchTo().window(parent);
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
									}
								}
								driver.switchTo().window(parent);
							}
						}
					}	
				}
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
}
