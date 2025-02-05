package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;
import com.regression.utility.Utils;

public class DevopsPageValidation implements Callable<String>
{
	WebDriver driver;
	String jiraProcess ="";
	ArrayList<ArrayList<String>> sheetData = null;
	DevopsPageLocator devopsPageLocator;
	String sheetStatus = "Pass";
	
	public DevopsPageValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.jiraProcess = jiraProcessStatus;
		this.driver = driver;
	}
	
	
	
	public void checkDownloadForm()
	{
		String status = devopsPageLocator.checkDownloadForm();
		
		if(status.contains("fail"))
		{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("DevopsPage").get(0).set(0, "checkDownloadForm  - failed");

		}
	}
	
	public void checkContent(String data)
	{
		String status = devopsPageLocator.checkContent(data);
		
		if(status.contains("fail"))
		{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("DevopsPage").get(1).set(0, "checkContent - failed");

		}
	}
	@Override
	public String call() throws Exception 
	{
		System.out.println("Devops Engg page process started");
		try
		{
		this.devopsPageLocator = new DevopsPageLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "checkDownloadForm":
					checkDownloadForm();
					break;
				case "checkContent":
					checkContent(row.get(1));
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
