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
	
	public ExploreCourseByNewUserValidation(ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		
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
	
	public void CheckExploreCourse()
	{
		String status = exploreCourseByNewUserLocator.CheckExploreCourse();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreCourseByNewUser").get(1).set(0, "CheckExploreCourse - failed");
		}
	}
	public WebDriver openDriver(String browserName)
	{
        return DriverManager.getDriver(browserName);
    }
	@Override
	public String call() throws Exception {
		System.out.println("Sign up Page links process started");

		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
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
				case "CheckExploreCourse":
					CheckExploreCourse();
					break;
			}
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
