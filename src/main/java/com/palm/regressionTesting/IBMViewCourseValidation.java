package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class IBMViewCourseValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	IBMViewCourseLocator ibmViewCourseLocator;
	String sheetStatus = "Pass";
	
	public IBMViewCourseValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	
	
	public void checkLogin(String user, String password)
	{
		String status = ibmViewCourseLocator.checkLogin(user, password);
		if(status.contains("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("login").get(0).set(0, "login  - failed");

		}
	}
	
	public void verifyIBMCourse()
	{
		ArrayList<String> status = ibmViewCourseLocator.verifyIBMCourse();
		if(status.contains("fail"))
		{
			for(int i = 0; i < status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("login").get(1).add(i+1, (status.get(i) + "verifyIBMCourse - failed"));
			}

		}
	}
	@Override
	public String call() throws Exception {

		System.out.println("Ibm View Course Url verification process started");
		try
		{
			this.ibmViewCourseLocator = new IBMViewCourseLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "login":
					checkLogin(row.get(1), row.get(2));
					break;
				case "checkIBMCourse":
					verifyIBMCourse();
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
