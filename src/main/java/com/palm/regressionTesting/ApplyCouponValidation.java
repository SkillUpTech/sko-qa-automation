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

public class ApplyCouponValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	ApplyCouponLocator applyCouponLocator;
	RegressionGenericValidator regressionGenericValidator;
	String sheetStatus = "Pass";
	WebDriver driver;
	
	public ApplyCouponValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		
	}
	
	
	public void launchCourse(ArrayList<String> data)
	{
		ArrayList<String> status = applyCouponLocator.launchCourse(data);
		if(status.contains("fail"))
		{
			for(int i = 0; i < status.size(); i++)
			{
				sheetStatus = "Fail";
				int position = data.indexOf(status.get(i));
				String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ApplyCoupon").get(0).get(position); 
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ApplyCoupon").get(0).set(position, (cellValue + " - failed"));
			}
		}
	}
	
	public void ApplyCoupon(ArrayList<String> data)
	{

		ArrayList<String> checkCoupon = applyCouponLocator.ApplyCoupon(data);
		if(checkCoupon.contains("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ApplyCoupon").get(1).set(0, "ApplyCoupon - failed");
		}
	}
	
	public void ResultForAppliedcoupon()
	{
		ArrayList<String> checkCouponResult = applyCouponLocator.couponResult();
		for(int i = 0; i < checkCouponResult.size(); i++)
		{
			if(checkCouponResult.size()>0)
			{
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ApplyCoupon").get(2).add(i+1, (checkCouponResult.get(i) + "ResultForAppliedcoupon"));
			}
		}
	}

	/*
	 * public WebDriver openDriver(String browserName) { return
	 * DriverManager.getDriver(browserName); }
	 */
	@Override
	public String call() throws Exception
	{
		System.out.println("Coupon validation started");

		try
		{
		//	driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		this.applyCouponLocator = new ApplyCouponLocator(driver);
		//this.regressionGenericValidator = new RegressionGenericValidator(sheetName, SheetData);

		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "launchCourse": 
					launchCourse(row); 
					  break;
					  
				case "ApplyCoupon": 
					ApplyCoupon(row); 
					  break;
				case "ResultForAppliedcoupon": 
					ResultForAppliedcoupon(); 
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
