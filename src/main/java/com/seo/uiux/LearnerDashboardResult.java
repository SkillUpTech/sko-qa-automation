package com.seo.uiux;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

import com.palm.regressionTesting.IBMSkillBuildPageLocator;
import com.palm.regressionTesting.JiraTicketStatusUpdate;
import com.palm.regressionTesting.RegressionTesting;
import com.regression.utility.Utils;

public class LearnerDashboardResult implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	String jiraProcess ="";
	LearnerDashboardPage learnerDashboardPage;
	String sheetStatus = "Pass";
	WebDriver driver;
	
	public LearnerDashboardResult(WebDriver driver, ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus)
	{
		this.sheetData = sheetData;
		this.jiraProcess = jiraProcessStatus;
		this.driver = driver;
	}
	@Override
	public String call() throws Exception {
		System.out.println("IBM Skills build page validation Process started");

		try
		{
		this.learnerDashboardPage = new LearnerDashboardPage(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "image":
					image(row);
					break;
				case "programIcon":
					programIcon(row);
					break;
				case "programLabel":
					programLabel(row);
					break;
				case "ProgramName":
					ProgramName(row);
					break;
				case "ProgramPartner":
					ProgramPartner(row);
					break;
				case "level":
					level(row);
					break;
				case "StartNowButton":
					StartNowButton(row);
					break;
				case "shareIcon":
					shareIcon(row);
					break;
				case "IncludeCourses":
					IncludeCourses(row);
					break;
				case "CourseNameGoHere":
					CourseNameGoHere(row);
					break;
				case "GoToCourse":
					GoToCourse(row);
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
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ProgramURLandSlug").get(1).add(2, (getExecutionStatus + "failed"));
			}
			else
			{
				getExecutionStatus = "PASS";
				resultStatus.put(sheetRow.get(1), getExecutionStatus);
				getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
				System.out.println(getprocessStatus);
				
			}
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ProgramURLandSlug").get(1).add(2, 
					(getExecutionStatus)+ Utils.DELIMITTER + "bold" + Utils.DELIMITTER + "color" + (getExecutionStatus.equalsIgnoreCase("Pass") ? "Green" : "Red"));
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	
	}

	public void image(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkImage(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(1).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void programIcon(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkImage(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(2).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void programLabel(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkImage(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(3).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void ProgramName(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkProgramName(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(4).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void ProgramPartner(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkProgramPartner(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(5).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void level(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkProgramLevel(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(6).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void StartNowButton(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkStartNowButton(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(7).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void shareIcon(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkShareIcon(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(8).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void IncludeCourses(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkIncludeCourses(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(9).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void CourseNameGoHere(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkLinkedCourses(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(10).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
	public void GoToCourse(ArrayList<String> data)
	{
		ArrayList<String> status = learnerDashboardPage.checkGoToCourse(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LearnerDashboard").get(11).add(status.size()+i, (status.get(i) + " - failed"));
			}
		}
	}
}
