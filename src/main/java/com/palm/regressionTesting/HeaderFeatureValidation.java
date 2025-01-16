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

public class HeaderFeatureValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	String jiraProcess ="";
	HeaderFeatureLocators headerFeatureLocators;
	String sheetStatus = "Pass";
	
	public HeaderFeatureValidation(ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus)
	{
		this.sheetData = sheetData;
		this.jiraProcess = jiraProcessStatus;
	}
	
	
	public void headerFeatureOnCategory(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnCategory(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(0).add(i+2, (getStatus.get(i) + "headerFeatureOnCategory - failed"));
			}
		}
	}
	
	public void headerFeatureOncourse(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOncourse(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(1).add(i+2, (getStatus.get(i) + "headerFeatureOncourse - failed"));
			}
		}
	}
	
	public void headerFeatureOnprogram(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnprogram(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(2).add(i+2, (getStatus.get(i) + "headerFeatureOnprogram - failed"));
			}
		}
	}
	
	public void headerFeatureOnpartner(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnpartner(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(3).add(i+2, (getStatus.get(i) + "headerFeatureOnpartner - failed"));
			}
		}
	}
	
	public void headerFeatureOnAnyPage(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnplacement(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(4).add(i+2, (getStatus.get(i) + "headerFeatureOnplacement - failed"));
			}
		}
	}
	
	public void headerFeatureOnLoginPage(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnLoginPage(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(5).add(i+2, (getStatus.get(i) + "headerFeatureOnLoginPage - failed"));
			}
		}
	}
	
	public void headerFeatureOnSignupPage(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnSignupPage(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(6).add(i+2, (getStatus.get(i) + "headerFeatureOnSignupPage - failed"));
			}
		}
	}
	
	public void headerFeatureOnBlog(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnBlog(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(7).add(i+2, (getStatus.get(i) + "failed"));
			}
		}
	}
	public void headerFeatureOnCourseAsProgram(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnCourseAsProgram(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(8).add(i+2, (getStatus.get(i) + "failed"));
			}
		}
	}
	public void headerFeatureOnceLogin(ArrayList<String> data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnceLogin(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(9).add(i+3, (getStatus.get(i) + "failed"));
			}
		}
	}
	public void headerFeatureOnceSignup(String data)
	{
		ArrayList<String> getStatus = headerFeatureLocators.headerFeatureOnceSignup(data);
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFeature").get(10).add(i+2, (getStatus.get(i) + "failed"));
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
		System.out.println("HeaderFeature  validation Process started");

		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		this.headerFeatureLocators = new HeaderFeatureLocators(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
			
			
			  case "headerFeatureOnCategory": headerFeatureOnCategory(row.get(1)); break;
			  case "headerFeatureOncourse": headerFeatureOncourse(row.get(1)); break; case
			  "headerFeatureOnprogram": headerFeatureOnprogram(row.get(1)); break; case
			  "headerFeatureOnpartner": headerFeatureOnpartner(row.get(1)); break;
			  
			  case "headerFeatureOnAnyPage": headerFeatureOnAnyPage(row.get(1)); break;
			  
			  
			  case "headerFeatureOnLoginPage": headerFeatureOnLoginPage(row.get(1)); break;
			  
			  case "headerFeatureOnBlog": headerFeatureOnBlog(row.get(1)); break; case
			  "headerFeatureOnCourseAsProgram": headerFeatureOnCourseAsProgram(row.get(1));
			  break;
			 
				  case "headerFeatureOnceLogin": 
					  headerFeatureOnceLogin(row);
				  break;
			}
		}
		if(jiraProcess.contains("Yes"))
		{
			HashMap<String, String> resultStatus = new HashMap<String, String>();
			ArrayList<String> sheetRow = sheetData.get(7);
			String getExecutionStatus = "";
			String getprocessStatus = "";
			JiraTicketStatusUpdate jiraTicketStatusUpdate = new JiraTicketStatusUpdate();
			
			
			if(sheetStatus == "fail")
			{
				getExecutionStatus = "FAIL";
				resultStatus.put(sheetRow.get(1), getExecutionStatus);
				getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
				System.out.println(getprocessStatus);
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ProgramURLandSlug").get(7).add(2, (getExecutionStatus + "failed"));
			}
			else
			{
				getExecutionStatus = "PASS";
				resultStatus.put(sheetRow.get(1), getExecutionStatus);
				getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
				System.out.println(getprocessStatus);
				
			}
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ProgramURLandSlug").get(7).add(2, 
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
