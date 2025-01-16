package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class MicrosoftCourseValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	MicrosoftCourseLocator microsoftCourseLocator;
	String sheetStatus = "Pass";
	String checkMicrosoftPage = "";
	
	public MicrosoftCourseValidation(ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
	}
	
	public void MicrosftPage()
	{
		ArrayList<String> getStatus = microsoftCourseLocator.verifyMicrosftPage();
		if(getStatus.contains("fail"))
		{
			checkMicrosoftPage = "fail";
			if(getStatus.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("MicrosoftPage").get(0).set(0, "MicrosftPage - failed");
			}
		}
	}
	
	public void MicrosoftScourses()
	{
		if (!checkMicrosoftPage.equals("fail")) 
		{
			ArrayList<String> getStatus = microsoftCourseLocator.verifyMicrosoftScourses();
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("MicrosoftPage").get(1).add(i+1, (getStatus.get(i) + " -failed"));
				}
			}
		}
	}
	public WebDriver openDriver(String browserName)
	{
        return DriverManager.getDriver(browserName);
    }
	@Override
	public String call() throws Exception
	{
		System.out.println("Microsoft validation Process started");

		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			this.microsoftCourseLocator = new MicrosoftCourseLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "MicrosftPage":
					MicrosftPage();
					break;
				case "MicrosoftScourses":
					MicrosoftScourses();
					break;
			}
		}
		 DriverManager.quitDriver();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	
	}
}
