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
	
	public CategoryBannerValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
		this.driver = driver;
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
	@Override
	public String call() throws Exception 
	{
		System.out.println("category banner validation Process started");

		try
		{
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
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	
	}
}
