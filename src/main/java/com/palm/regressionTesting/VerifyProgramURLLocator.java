package com.palm.regressionTesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
public class VerifyProgramURLLocator
{
	WebDriver driver;
	String parentWindow = "";
	public VerifyProgramURLLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public ArrayList<String> verifyProgramURL(ArrayList<String> data)
	{
		parentWindow = driver.getWindowHandle();//base window
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			String url = driver.getCurrentUrl()+data.get(1);
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(url);
			String coursePage = driver.getWindowHandle();
			
			List<WebElement> programURL = driver.findElements(By.xpath("//div[contains(@class,'CourseDescription_infoBoxText')]//ul/li/a"));
			for(WebElement getURL : programURL)
            {
				js.executeScript("arguments[0].scrollIntoView();", getURL);
				String programURLText = getURL.getAttribute("href");
				String getProgramName = getURL.getText();
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(programURLText);
				WebElement getProgramPageName = driver.findElement(By.xpath("//div[contains(@class,'CourseDescription_courseText')]/h1"));
				String programPageName = getProgramPageName.getText();
				if(getProgramName.equalsIgnoreCase(programPageName))
				{
					System.out.println("Program URL is matching with the program name");
				} else
				{
					System.out.println("Program URL is not matching with the program name");
					status.add("Program URL is not matching with the program name");
				}
				driver.close();
				driver.switchTo().window(coursePage);
            }
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
