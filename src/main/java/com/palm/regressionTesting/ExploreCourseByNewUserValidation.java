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

public class ExploreCourseByNewUserValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	ExploreCourseByNewUserLocator exploreCourseByNewUserLocator;
	String sheetStatus = "Pass";
	
	public ExploreCourseByNewUserValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	public void Signup(ArrayList<String> data)
	{
		ArrayList<String> status = exploreCourseByNewUserLocator.checkSignup(data);
		if(status.contains("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreCourseByNewUser").get(0).set(0, "Signup - failed");
		}
	}
	
	@Override
	public String call() throws Exception {
		System.out.println("Sign up Page links process started");

		try
		{
		this.exploreCourseByNewUserLocator = new ExploreCourseByNewUserLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "Signup":
					Signup(row);
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
