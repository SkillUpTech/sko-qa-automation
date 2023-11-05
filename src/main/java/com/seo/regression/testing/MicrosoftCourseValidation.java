package com.seo.regression.testing;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class MicrosoftCourseValidation
{
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	MicrosoftCourseLocator microsoftCourseLocator;
	String sheetStatus = "Pass";
	
	public MicrosoftCourseValidation(ArrayList<ArrayList<String>> sheetData, WebDriver driver)
	{
		OpenWebsite.openSite(driver);
		this.sheetData = sheetData;
		this.driver = driver;
		this.microsoftCourseLocator = new MicrosoftCourseLocator(driver);
		System.out.println("Microsoft validation Process started");
		//this.start();
	}
	
	public String start()
	{
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "MicrosftPage":
					MicrosftPage();
					break;
				case "MicrosoftScourses":
<<<<<<< HEAD
					MicrosoftScourses(row);
=======
					MicrosoftScourses();
>>>>>>> bdd0f2cec4ad56528210943314c35d5174841808
					break;
			}
		}
		return sheetStatus;
	}
	
	public void MicrosftPage()
	{
		ArrayList<String> getStatus = microsoftCourseLocator.verifyMicrosftPage();
		if(getStatus.contains("fail"))
		{
			if(getStatus.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("MicrosoftPage").get(0).set(0, "MicrosftPage - failed");
			}
		}
	}
	
<<<<<<< HEAD
	public void MicrosoftScourses(ArrayList<String> courses)
	{
		ArrayList<String> getStatus = microsoftCourseLocator.verifyMicrosoftScourses(courses);
=======
	public void MicrosoftScourses()
	{
		ArrayList<String> getStatus = microsoftCourseLocator.verifyMicrosoftScourses();
>>>>>>> bdd0f2cec4ad56528210943314c35d5174841808
		if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				sheetStatus = "Fail";
<<<<<<< HEAD
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("MicrosoftPage").get(1).add(i+1, (getStatus.get(i) + " - failed"));
=======
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("MicrosoftPage").get(1).add(i+1, (getStatus.get(i) + "MicrosoftScourses - failed"));
>>>>>>> bdd0f2cec4ad56528210943314c35d5174841808
			}
		}
	}
}
