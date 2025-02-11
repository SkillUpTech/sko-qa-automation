package com.formValidation.testing;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

public class ForgotPasswordValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	ForgotPasswordLocator forgotPasswordLocator;
	String sheetStatus = "Pass";
	WebDriver driver;
	
	public ForgotPasswordValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	public void checkForgotPasswordLink()
	{
		String status = forgotPasswordLocator.openLoginSite();
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ForgotPassword").get(0).set(0, "forgotPwd - failed");
		}
	}
	
	public void checkRegisteredEmail(ArrayList<String> emailFromExcel) throws InterruptedException
	{
		ArrayList<String> status = forgotPasswordLocator.verifyRegisteredEmail(emailFromExcel);
		if(!status.contains("Success"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ForgotPassword").get(1).set(0, "forgotPwd - failed");
		}
	}
	public void checkRegisteredNonEmail(ArrayList<String> emailFromExcel) throws InterruptedException
	{
		ArrayList<String> status = forgotPasswordLocator.verifyRegisteredNonEmail(emailFromExcel);
		if(!status.contains("Success"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ForgotPassword").get(2).set(0, "forgotPwd - failed");
		}
	}
	public void checkNonActivatedEmail(ArrayList<String> emailFromExcel) throws InterruptedException
	{
		ArrayList<String> status = forgotPasswordLocator.verifyNonActivatedEmail(emailFromExcel);
		if(!status.contains("Success"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ForgotPassword").get(3).set(0, "forgotPwd - failed");
		}
	}
	@Override
	public String call() throws Exception 
	{
		try
		{
			this.forgotPasswordLocator = new ForgotPasswordLocator(driver);
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				ArrayList<String> row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
					case "ForgotPwdTC001":
						checkForgotPasswordLink();
						break;
					case "ForgotPwdTC002":
						checkRegisteredEmail(row);
						break;
					case "ForgotPwdTC003":
						checkRegisteredNonEmail(row);
						break;
					case "ForgotPwdTC004":
						checkNonActivatedEmail(row);
						break;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return sheetStatus;
	}
}
