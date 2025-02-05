package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.palm.regressionTesting.GLXLocator;
import com.palm.regressionTesting.OpenWebsite;
import com.palm.regressionTesting.RegressionTesting;
import com.regression.utility.TestUtil;

public class TechMasterValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	TechMasterLocator techMasterLocator;
	String sheetStatus = "Pass";

	public TechMasterValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData)
	{
		
		this.sheetData = sheetData;
		this.driver = driver;
	}

	
	public void launchSite(String url)
	{
		String status = techMasterLocator.launchSite(url);
		if(status.contains("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FutureSkill").get(0).set(0, "url - failed");
		}
	}
	public void findOutMore_Button()
	{
		String status = techMasterLocator.findOutMore_Button();
		if(status.contains("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FutureSkill").get(1).set(0, "findOutMore_Button - failed");
		}
	}
	public void learnmore_Button()
	{
		String status = techMasterLocator.learnmore_Button();
		if(status.contains("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FutureSkill").get(2).set(0, "findOutMore_Button - failed");
		}
	}
	/*
	 * public void Cards() { ArrayList<String> status = techMasterLocator.Cards();
	 * if(status.size()>0) { for(int i = 0; i < status.size(); i++) { sheetStatus =
	 * "Fail";
	 * RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TechMaster").
	 * get(1).add(i+1, (status.get(i) + "Cards - failed")); } } }
	 */
	public void Cards() 
	{
	    if (techMasterLocator != null) 
	    {
	        ArrayList<String> status = techMasterLocator.Cards();
	        if (status != null && status.size() > 0)
	        {
	            for (int i = 0; i < status.size(); i++)
	            {
	                sheetStatus = "Fail";
	    			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FutureSkill").get(3).add(i+1, (status.get(i) + " failed"));

	            }
	        }
	    }
	}
	public void focusFAQ()
	{
		String status = techMasterLocator.CheckFAQFocus();
		if(status.contains("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FutureSkill").get(3).set(0, "findOutMore_Button - failed");
		}
	}
	@Override
	public String call() throws Exception {
		System.out.println("Techmaster Process started");

		try
		{
		this.techMasterLocator = new TechMasterLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "url":
					launchSite(row.get(1));
					break;
				case "findOutMore_Button":
					findOutMore_Button();
					break;
				case "learnmore_Button":
					learnmore_Button();
					break;
				case "Cards":
					Cards();
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
