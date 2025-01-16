package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;
import com.regression.utility.Utils;

public class PageLinksValidation implements Callable<String>
{
	WebDriver driver;
	String jiraProcess ="";
	ArrayList<ArrayList<String>> sheetData = null;
	PageLinksLocator pageLinksLocator;
	String sheetStatus = "Pass";
	public PageLinksValidation(ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
	}
	
	public WebDriver openDriver(String browserName)
	{
        return DriverManager.getDriver(browserName);
    }
	
	@Override
	public String call() throws Exception
	{
		System.out.println("ProgramURL and SLUG verification started");

		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		this.pageLinksLocator = new PageLinksLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "URL":
					checkURL(row, i);
					break;
			}
		}
		
		
		DriverManager.quitDriver();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.quit();
		return sheetStatus;
	
	}
	
	
	public void checkURL(ArrayList<String> data, int rowindex) 
	{
	    ArrayList<String> status = pageLinksLocator.verifyURL(data, rowindex);
        for (int i = 0; i < status.size(); i++) 
        {
            if (status.get(i).contains("fail")) 
            {
	                sheetStatus = "Fail";
	                RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("PageLinks").get(62).add(i, (status.get(i) + "verifyIBMCourse - failed"));
	          } 
	     }
	}

}
