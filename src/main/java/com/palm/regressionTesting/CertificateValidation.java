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

public class CertificateValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	CertificateLocators certificateLocators;
	String sheetStatus = "Pass";
	
	public CertificateValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	
	
	public void LoginStaffUser(ArrayList<String> data)
	{
		String status = "fail";
		ArrayList<String> twitterProcess = certificateLocators.LoginStaffUser(data);
		if(twitterProcess.contains(status))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ViewCertificate").get(0).set(0, "LoginStaffUser - failed");
		}
	}
	
	public void checkCertificate(ArrayList<String> data)
	{
		String status = "fail";
		ArrayList<String> twitterProcess = certificateLocators.checkCertificate(data);
		if(twitterProcess.contains(status))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ViewCertificate").get(1).set(0, "checkCertificate - failed");
		}
	}
	@Override
	public String call() throws Exception {

		System.out.println("certificate process started");
		try
		{
		this.certificateLocators = new CertificateLocators(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "LoginStaffUser":
					LoginStaffUser(row);
					break;
				case "checkCertificate":
					checkCertificate(row);
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
