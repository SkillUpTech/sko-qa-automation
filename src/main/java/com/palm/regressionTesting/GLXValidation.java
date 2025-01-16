package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class GLXValidation implements Callable<String>
{

	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	GLXLocator glxLocator;
	String sheetStatus = "Pass";
	
	public GLXValidation(ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		
	}
	
	
	public void facebook()
	{
		String status = glxLocator.facebookProcess();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("GLX").get(0).set(0, "facebook - failed");
		}
	}
	public void instagram()
	{
		String status = glxLocator.instagramProcess();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("GLX").get(1).set(0, "instagram - failed");
		}
	}
	public void twitter()
	{
		String status = glxLocator.twitterProcess();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("GLX").get(2).set(0, "twitter - failed");
		}
	}
	public void CTADownloadDetails()
	{
		String status = glxLocator.CTADownloadingProcess();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("GLX").get(0).set(0, "CTADownloadDetails - failed");
		}
	}
	public void programs(ArrayList<String> data)
	{
		if(!data.contains("NA"))
		{
			ArrayList<String> getStatus = glxLocator.verifyGLXProgram();
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("GLX").get(1).add(i+1, (getStatus.get(i) + "programs - failed"));
				}
			}
		}
	}
	public void ExploreCourse(ArrayList<String> data) throws InterruptedException
	{
		if(!data.contains("NA"))
		{
			String status = glxLocator.ExploreCourseProcess();
			if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("GLX").get(2).set(0, "ExploreCourse - failed");
			}
		}
	}
	public WebDriver openDriver(String browserName)
	{
        return DriverManager.getDriver(browserName);
    }
	@Override
	public String call() throws Exception {
		System.out.println("GLX process started");

		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			this.glxLocator = new GLXLocator(driver);
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
