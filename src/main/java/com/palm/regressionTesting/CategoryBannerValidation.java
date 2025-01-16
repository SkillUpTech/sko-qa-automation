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

public class CategoryBannerValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	CategoryBannerLocator categoryBannerLocator;
	String sheetStatus = "Pass";
	
	public CategoryBannerValidation(ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
		
	}
	
	public void checkBanner(ArrayList<String> data)
	{
		ArrayList<String> status = categoryBannerLocator.verifyBanner(data);
		if(status.contains("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CategoryBanner").get(0).set(0, "Banner - failed");

		}
	}
	 public WebDriver openDriver(String browserName) {
	        return DriverManager.getDriver(browserName);
	    }
	@Override
	public String call() throws Exception 
	{
		System.out.println("category banner validation Process started");

		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		this.categoryBannerLocator = new CategoryBannerLocator(driver);
		
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "Banner":
					checkBanner(row);
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
