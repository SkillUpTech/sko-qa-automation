package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

public class FluidEducationValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	FluidEducationLocator fluidEducationLocator;
	String sheetStatus = "Pass";
	
	public FluidEducationValidation(ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		
	}
	
	
	public void facebook()
	{
		String status = fluidEducationLocator.facebookProcess();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Fluideducation").get(0).set(0, "facebook - failed");
		}
	}
	public void instagram()
	{
		String status = fluidEducationLocator.instagramProcess();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Fluideducation").get(1).set(0, "instagram - failed");
		}
	}
	public void twitter()
	{
		String status = fluidEducationLocator.twitterProcess();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Fluideducation").get(2).set(0, "twitter - failed");
		}
	}
	public void CTADownloadDetails()
	{
		String status = fluidEducationLocator.CTADownloadingProcess();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Fluideducation").get(3).set(0, "CTADownloadDetails - failed");
		}
	}
	public void programs(ArrayList<String> data)
	{
		if(!data.contains("NA"))
		{
			ArrayList<String> getStatus = fluidEducationLocator.verifyFluidEducationProgram();
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Fluideducation").get(4).add(i+1, (getStatus.get(i) + "programs - failed"));
				}
			}
		}
	}
	public void ExploreCourse(ArrayList<String> data) throws InterruptedException
	{
		if(!data.contains("NA"))
		{
			String status = fluidEducationLocator.ExploreCourseProcess();
			if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Fluideducation").get(5).set(0, "ExploreCourse - failed");
			}
		}
	}
	public WebDriver openDriver(String browserName)
	{
        return DriverManager.getDriver(browserName);
    }
	@Override
	public String call() throws Exception {
		System.out.println("fluidEducation process started");
		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			this.fluidEducationLocator = new FluidEducationLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "facebook":
					facebook();
					break;
				case "instagram":
					instagram();
					break;
				case "twitter":
					twitter();
					break;
				case "CTADownloadDetails":
					CTADownloadDetails();
					break;
				case "programs":
					programs(row);
					break;
				case "ExploreCourse":
					  ExploreCourse(row); 
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
