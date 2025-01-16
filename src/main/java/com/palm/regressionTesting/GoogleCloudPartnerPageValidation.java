package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.openqa.selenium.WebDriver;

public class GoogleCloudPartnerPageValidation implements Callable<String>
{
	WebDriver driver;
	String jiraProcess ="";
	ArrayList<ArrayList<String>> sheetData = null;
	GoogleCloudPartnerPageLocator googleCloudPartnerPageLocator;
	String sheetStatus = "Pass";
	String checkGoogleCloudPage = "";
	
	public GoogleCloudPartnerPageValidation(ArrayList<ArrayList<String>> sheetData)
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
		System.out.println("Course Purchase Activation Handler Validation");
		
		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			
			this.googleCloudPartnerPageLocator = new GoogleCloudPartnerPageLocator(driver);
			
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				ArrayList<String> row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
				  case "GoogleCloudPage":
					  GoogleCloudPage();
					  break;
					
					  case "programCards": checkprogramCards(); break;
					  
				  case "courseCards":
					  	checkcourseCards(); 
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
	
	public void GoogleCloudPage()
	{
		ArrayList<String> getStatus = googleCloudPartnerPageLocator.verifyGoogleCouldPage();
		if(getStatus.contains("fail"))
		{
			checkGoogleCloudPage = "fail";
			if(getStatus.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("GoogleCloudPartnerPage").get(0).set(0, " - failed");
			}
		}
	}
	
	public void checkprogramCards()
	{
		if (!checkGoogleCloudPage.equals("fail")) 
		{
			ArrayList<String> getStatus = googleCloudPartnerPageLocator.verifyGoogleCloudProgramcards();
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("GoogleCloudPartnerPage").get(1).add(i+1, (getStatus.get(i) + " - failed"));
				}
			}
		}
	}
	
	public void checkcourseCards()
	{
		if (!checkGoogleCloudPage.equals("fail")) 
		{
			ArrayList<String> getStatus = googleCloudPartnerPageLocator.verifyGoogleCloudCourseCards();
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("GoogleCloudPartnerPage").get(2).add(i+1, (getStatus.get(i) + " -failed"));
				}
			}
		}
	}
}
