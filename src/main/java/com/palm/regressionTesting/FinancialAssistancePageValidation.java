package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

public class FinancialAssistancePageValidation implements Callable<String>
{
	WebDriver driver;
	String jiraProcess ="";
	ArrayList<ArrayList<String>> sheetData = null;
	FinancialAssistancePageLocator financialAssistancePageLocator;
	String sheetStatus = "Pass";
		
		public FinancialAssistancePageValidation(ArrayList<ArrayList<String>> sheetData) throws InterruptedException
		{
			this.sheetData = sheetData;
		}
		
		public WebDriver openDriver(String browserName)
		{
	        return DriverManager.getDriver(browserName);
	    }
		
		@Override
		public String call() throws Exception
		{
			System.out.println("ProgramURL and SLUG verification started");

			try
			{
				driver = this.openDriver(RegressionTesting.nameOfBrowser);
				OpenWebsite.openSite(driver);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
				this.financialAssistancePageLocator = new FinancialAssistancePageLocator(driver);
				for(int i = 0; i < this.sheetData.size(); i++)
				{
					ArrayList<String> row = this.sheetData.get(i);
					String firstColumn = row.get(0);
					switch(firstColumn)
					{
					
					  case "URL": 
					  checkURL(row.get(1)); 
					  break;
					  
					  case "check":
					  
					  
					 
					}
				}
			
			
			DriverManager.quitDriver();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {
			    DriverManager.quitDriver();
			}
			return sheetStatus;
		
		}
		
		public void checkURL(String url)
		{
			String status = financialAssistancePageLocator.checkLink(url);
			if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FinancialAssistance").get(0).set(0, " - failed");
				driver.quit();
			}
		}
}
