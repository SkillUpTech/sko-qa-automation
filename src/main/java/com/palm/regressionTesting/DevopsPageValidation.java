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
	
	public DevopsPageValidation(ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.jiraProcess = jiraProcessStatus;
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
	public WebDriver openDriver(String browserName)
	{
        return DriverManager.getDriver(browserName);
    }
	@Override
	public String call() throws Exception {
		System.out.println("Devops Engg page process started");
		WebDriver driver = null;
		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
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
		
		
		if(jiraProcess.contains("Yes"))
		{
			HashMap<String, String> resultStatus = new HashMap<String, String>();
			ArrayList<String> sheetRow = sheetData.get(2);
			String getExecutionStatus = "";
			String getprocessStatus = "";
			JiraTicketStatusUpdate jiraTicketStatusUpdate = new JiraTicketStatusUpdate();
			
			if(sheetStatus == "fail")
			{
				getExecutionStatus = "FAIL";
				resultStatus.put(sheetRow.get(1), getExecutionStatus);
				getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
				System.out.println(getprocessStatus);
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ProgramURLandSlug").get(2).add(2, (getExecutionStatus + "failed"));
			}
			else
			{
				getExecutionStatus = "PASS";
				resultStatus.put(sheetRow.get(1), getExecutionStatus);
				getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
				System.out.println(getprocessStatus);
				
			}
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ProgramURLandSlug").get(2).add(2, 
					(getExecutionStatus)+ Utils.DELIMITTER + "bold" + Utils.DELIMITTER + "color" + (getExecutionStatus.equalsIgnoreCase("Pass") ? "Green" : "Red"));
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
