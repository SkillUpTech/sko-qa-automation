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

public class AccountPageValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	AccountPageLocator accountPageLocator;
	String sheetStatus = "Pass";
	
	public AccountPageValidation(ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
	
	}
	
	
	public void checkInitial(ArrayList<String> data) 
	{
		ArrayList<String> status = accountPageLocator.checkInitial(data);
		
		for(int i = 0; i < status.size(); i++)
		{
			if(data.contains(status.get(i)))
			{
				sheetStatus = "Fail";
				int position = data.indexOf(status.get(i));
				String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("AccountPage").get(0).get(position);
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("AccountPage").get(0).set(position, (cellValue + " - failed"));
			}
		}
	}
	
	public void checkAccount() 
	{
		String status = accountPageLocator.checkAccount();
		
		if(status.contains("fail"))
		{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("AccountPage").get(1).set(0, "checkAccount - failed");

		}	
	}
	@Override
	public String call() throws Exception {
		System.out.println("Account page process started");

		try
		{
			this.accountPageLocator = new AccountPageLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "checkInitial":
					checkInitial(row);
					break;
				case "checkAccount":
					checkAccount();
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
