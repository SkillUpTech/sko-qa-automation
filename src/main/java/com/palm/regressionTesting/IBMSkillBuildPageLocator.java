package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class IBMSkillBuildPageLocator 
{
	WebDriver driver;
	int respCode = 200;
	
	public IBMSkillBuildPageLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	String parentWindow = "";
	String IBMPage = "";
	public ArrayList<String> headerFeatureOnCategory(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{	
			parentWindow = driver.getWindowHandle();
			String getURL = driver.getCurrentUrl();
			for (int i = 1; i < data.size(); i++)
			{
				String url = getURL+data.get(i);
				
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
				IBMPage = driver.getWindowHandle();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				if(driver.findElements(By.xpath("//header[@id='headerBody']")).size()>0)
				{
					System.out.println("header present on " +data.get(i));
					status.add("header present on  " +data.get(i));
				}
				else
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					System.out.println("header not present");
					
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				if(driver.findElements(By.xpath("//*[contains(text(),'Testimonials')]")).size()>0)
				{
					System.out.println("Testimonials present on " + data.get(i));
				}
				else
				{
					System.out.println("Testimonials not present");
					status.add("Testimonials not present on " + data.get(i));
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				if(driver.findElements(By.xpath("//footer[@id='newsletter']")).size()>0)
				{
					System.out.println("footer not present");
				}
				else
				{
					System.out.println("footer present");
					status.add("footer present on "+data.get(i));
				}
				
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
