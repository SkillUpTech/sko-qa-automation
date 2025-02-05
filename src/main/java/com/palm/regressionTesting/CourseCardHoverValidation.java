package com.palm.regressionTesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import com.regression.utility.Utils;

public class CourseCardHoverValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	String jiraProcess ="";
	CourseCardHoverLocator courseCardHoverLocator;
	String sheetStatus = "Pass";
	
	public CourseCardHoverValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus)
	{
		this.sheetData = sheetData;
		this.jiraProcess = jiraProcessStatus;
		System.out.println("course card view validation Process started");
		this.driver = driver;
	}
	
	
	
	public void CourseCard(ArrayList<String> data)
	{
		ArrayList<String> status = courseCardHoverLocator.checkCourseCard(data);
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CategoryBanner").get(0).add(i+1, (status.get(i) + " - failed"));
			}
		}

	}
	 
	@Override
	public String call() throws Exception {
		System.out.println("category banner validation Process started");

		try
		{
		this.courseCardHoverLocator = new CourseCardHoverLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "Card":
					CourseCard(row);
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
