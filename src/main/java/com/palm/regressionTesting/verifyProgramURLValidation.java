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

import com.palm.regressionTesting.IBMViewCourseLocator;
import com.palm.regressionTesting.OpenWebsite;
import com.palm.regressionTesting.RegressionTesting;
import com.regression.utility.TestUtil;
import com.regression.utility.Utils;

public class verifyProgramURLValidation implements Callable<String>
{

	WebDriver driver;
	String jiraProcess ="";
	ArrayList<ArrayList<String>> sheetData = null;
	VerifyProgramURLLocator verifyProgramURLLocator;
	String sheetStatus = "Pass";
	
	public verifyProgramURLValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.jiraProcess = jiraProcessStatus;
		this.driver = driver;
	}
	
	
	public void checkProgramURL(ArrayList<String> data)
	{
		ArrayList<String> status = verifyProgramURLLocator.verifyProgramURL(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("IBM").get(0).add(((status.size())+1), (status.get(i) + "IBMcourses - failed"));
			}
		}
	}
	@Override
	public String call() throws Exception {
		System.out.println("ProgramURL and SLUG verification started");

		try
		{
		this.verifyProgramURLLocator = new VerifyProgramURLLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "courseURL":
					checkProgramURL(row);
					break;
			}
		}
		
		if(jiraProcess.contains("Yes"))
		{
			HashMap<String, String> resultStatus = new HashMap<String, String>();
			ArrayList<String> sheetRow = sheetData.get(1);
			String getExecutionStatus = "";
			String getprocessStatus = "";
			JiraTicketStatusUpdate jiraTicketStatusUpdate = new JiraTicketStatusUpdate();
			
			if(sheetStatus == "fail")
			{
				getExecutionStatus = "FAIL";
				resultStatus.put(sheetRow.get(1), getExecutionStatus);
				getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
				System.out.println(getprocessStatus);
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(1).add(2, (getExecutionStatus + "failed"));
			}
			else
			{
				getExecutionStatus = "PASS";
				resultStatus.put(sheetRow.get(1), getExecutionStatus);
				getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
				System.out.println(getprocessStatus);
				
			}
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(1).add(2, 
					(getExecutionStatus)+ Utils.DELIMITTER + "bold" + Utils.DELIMITTER + "color" + (getExecutionStatus.equalsIgnoreCase("Pass") ? "Green" : "Red"));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	
	}
}
