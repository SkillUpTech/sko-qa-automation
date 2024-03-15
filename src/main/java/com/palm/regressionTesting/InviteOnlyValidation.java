package com.palm.regressionTesting;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class InviteOnlyValidation 
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	InviteOnlyLocator inviteOnlyLocator;
	String sheetStatus = "Pass";
	
	public InviteOnlyValidation(ArrayList<ArrayList<String>> sheetData, WebDriver driver) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
		OpenWebsite.openSite(driver);
		this.inviteOnlyLocator = new InviteOnlyLocator(driver);
		System.out.println("Invite only process started");
		//this.start();
	}
	public String start() throws InterruptedException
	{
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "checkStatusCode_inviteOnlyCourse":
					checkStatusCode_inviteOnlyCourse(row);
					break;
				case "checkDate_inviteOnlyCourse":
					checkDate_inviteOnlyCourse(row);
					break;
				case "checkProgram_Courses":
					checkProgram_Courses(row);
					break;
				case "checkInviteOnly_Courses":
					checkInviteOnly_Courses(row);
					break;
				case "checkEnrollmentDateIsExpired_Courses":
					checkEnrollmentDateIsExpiredFuturedCurrent_Courses(row);
					break;
			}
		}
		return sheetStatus;
	}
	
	public void checkStatusCode_inviteOnlyCourse(ArrayList<String> data)
	{
		if(!data.contains("NA"))
		{
			ArrayList<String> getStatus = inviteOnlyLocator.checkStatusCode_inviteOnlyCourse(data);
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					if(data.contains(getStatus.get(i)))
					{
						sheetStatus = "Fail";
						int position = data.indexOf(getStatus.get(i));
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(0).get(position);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(0).set(position, (cellValue + " - failed"));

					}
				}
			}
		}
	}
	
	public void checkDate_inviteOnlyCourse(ArrayList<String> data)
	{
		if(!data.contains("NA"))
		{
			ArrayList<String> getStatus = inviteOnlyLocator.checkDate_inviteOnlyCourse(data);
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					if(data.contains(getStatus.get(i)))
					{
						sheetStatus = "Fail";
						int position = data.indexOf(getStatus.get(i));
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(1).get(position);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(1).set(position, (cellValue + " - failed"));

					}
				}
			}
		}
	}
	
	public void checkProgram_Courses(ArrayList<String> data)
	{
		if(!data.contains("NA"))
		{
			ArrayList<String> getStatus = inviteOnlyLocator.checkProgram_Courses(data);
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					if(data.contains(getStatus.get(i)))
					{
						sheetStatus = "Fail";
						int position = data.indexOf(getStatus.get(i));
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(2).get(position);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(2).set(position, (cellValue + " - failed"));

					}
				}
			}
		}
	}
	
	public void checkInviteOnly_Courses(ArrayList<String> data)
	{
		if(!data.contains("NA"))
		{
			ArrayList<String> getStatus = inviteOnlyLocator.checkInviteOnly_Courses(data);
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					if(data.contains(getStatus.get(i)))
					{
						sheetStatus = "Fail";
						int position = data.indexOf(getStatus.get(i));
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(3).get(position);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(3).set(position, (cellValue + " - failed"));

					}
				}
			}
		}
	
		
	}
	
	public void checkEnrollmentDateIsExpiredFuturedCurrent_Courses(ArrayList<String> data)
	{
		if(!data.contains("NA"))
		{
			ArrayList<String> getStatus = inviteOnlyLocator.checkEnrollmentDateIsExpiredFuturedCurrent_Courses(data);
			if(getStatus.size()>0)
			{
				for(int i = 0; i < getStatus.size(); i++)
				{
					if(data.contains(getStatus.get(i)))
					{
						sheetStatus = "Fail";
						int position = data.indexOf(getStatus.get(i));
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(4).get(position);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("InviteOnlyCourse").get(4).set(position, (cellValue + " - failed"));

					}
				}
			}
		}
	
		
	
		
	}
	
	
}
