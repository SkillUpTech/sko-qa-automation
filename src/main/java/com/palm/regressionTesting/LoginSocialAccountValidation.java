package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class LoginSocialAccountValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	LoginSocialAccountLocator loginSocialAccountLocator;
	String sheetStatus = "Pass";
	WebDriver driver;
	OpenWebsite openWebsite;
	
	public LoginSocialAccountValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	@Override
	public String call() throws Exception {
		System.out.println("PLU process started");

		try
		{
		this.loginSocialAccountLocator = new LoginSocialAccountLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "facebook":
					facebook(row.get(1), row.get(2));
					break;
				case "google":
					google(row.get(1), row.get(2));
					break;
				case "linkedIn":
					linkedIn(row.get(1), row.get(2));
					break;
				case "Microsoft":
					Microsoft(row.get(1), row.get(2));
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
	
	public void facebook(String user, String pwd)
	{
		ArrayList<String> Status = loginSocialAccountLocator.verifyFacebook(user, pwd);
		if(Status.size()>0)
		{
			for(int i = 0; i < Status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("PLU").get(0).add(Status.size()+i,(Status.get(i)+ " - failed"));
			}
		}
	}
	
	public void google(String user, String pwd)
	{
		ArrayList<String> Status = loginSocialAccountLocator.verifyGoogle(user, pwd);
		if(Status.size()>0)
		{
			for(int i = 0; i < Status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("PLU").get(1).add(Status.size()+i,(Status.get(i)+ " - failed"));
			}
		}
	}
	
	public void linkedIn(String user, String pwd)
	{
		ArrayList<String> Status = loginSocialAccountLocator.verifyLinkedIn(user, pwd);
		if(Status.size()>0)
		{
			for(int i = 0; i < Status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("PLU").get(2).add(Status.size()+i,(Status.get(i)+ " - failed"));
			}
		}
	}
	
	public void Microsoft(String user, String pwd)
	{
		ArrayList<String> Status = loginSocialAccountLocator.verifyMicrosoft(user, pwd);
		if(Status.size()>0)
		{
			for(int i = 0; i < Status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("PLU").get(3).add(Status.size()+i,(Status.get(i)+ " - failed"));
			}
		}
	}
}
