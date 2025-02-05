package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.openqa.selenium.WebDriver;


public class CourseLevelValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	CourseLevelLocators courseLevelLocators;
	String sheetStatus = "Pass";
	
	public CourseLevelValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	
	public void checkHomePage()
	{
		ArrayList<String> status = courseLevelLocators.checkSelfPacedVILTOnHomePage();
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CheckVILTSelfPacedCourse").get(0).add(i+1, (status.get(i) + "HomePage - failed"));
			}
		}
	}
	
	public void checkCategoryPagesForProgramCards()
	{
		ArrayList<String> status = courseLevelLocators.checkSelfPacedVILTForProgramCardsOnCategory();
		if(status.size()>0 || status.contains("fail"))
		{
			for(int i = 0; i < status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CheckVILTSelfPacedCourse").get(1).add(i+1, (status.get(i) + " - failed"));
			}
		}
	}
	
	public void checkCategoryPagesForCourseCards() 
	{
		ArrayList<String> status = courseLevelLocators.checkCourseCardOnCategory();
		if (status.size() > 0 || status.contains("fail"))
		{
			for (int i = 0; i < status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CheckVILTSelfPacedCourse").get(2)
						.add(i + 1, (status.get(i) + " - failed"));
			}
		}
	}
	
	
	@Override
	public String call() throws Exception
	{
		System.out.println("Course Level validation process started");

		try
		{
			this.courseLevelLocators = new CourseLevelLocators(driver);
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				ArrayList<String> row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
				
				
				 
				
				
				  case "categoryPagesProgramCards": checkCategoryPagesForProgramCards(); break;
				 
				 
					
					  case "categoryPagesCourseCards": checkCategoryPagesForCourseCards(); break;
					 
				}
			}
			DriverManager.quitDriver();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			driver.quit();
		}
		return sheetStatus;
	
	}
}
