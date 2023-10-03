package com.seo.regression.testing;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class FAQValidation 
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	FAQLocator faqLocator;
	String sheetStatus = "Pass";
	
	public FAQValidation(ArrayList<ArrayList<String>> sheetData, WebDriver driver) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
		OpenWebsite.openSite(driver);
		this.faqLocator = new FAQLocator(driver);
		System.out.println("FAQ process started");
		//this.start();
	}
	
	public String start() throws InterruptedException
	{
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "login":
					login(row.get(1), row.get(2));
					break;
				case "verifyFAQ":
					verifyFAQ();
					break;
				case "invalidfullname":
					invalidfullname();
					break;
				case "EmptyFullname":
					EmptyFullname();
					break;
				case "validFullname":
					validFullname();
					break;
				case "invalidEmail":
					invalidEmail(); 
					  break;
				case "EmptyEmail":
					EmptyEmail(); 
					  break;
				case "validEmail":
					validEmail(); 
					  break;
				case "InvalidContact":
					InvalidContact(); 
					  break;
				case "EmptyContact":
					EmptyContact(); 
					  break;
				case "validContact":
					validContact(); 
					  break;
				case "EmptyQuery":
					EmptyQuery(); 
					  break;
			}
		}
		return sheetStatus;
	}
	public void login(String email, String pwd)
	{
		String status = faqLocator.loginProcess(email, pwd);
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(0).set(0, "login - failed");
		}
	}
	public void verifyFAQ()
	{
		ArrayList<String> status = faqLocator.FAQProcess();
		if(status.size()>0)
		{
			for(int i = 0; i < status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(1).add(i+1, (status.get(i) + "verifyFAQ - failed"));
			}
		}
	}
	public void invalidfullname()
	{
		String status = faqLocator.verifyInvalidFullname();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(3).set(0, "invalidfullname - failed");
		}
	}
	public void EmptyFullname()
	{
		String status = faqLocator.EmptyFullname();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(4).set(0, "EmptyFullname - failed");
		}
	}
	public void validFullname()
	{
		String status = faqLocator.validFullname();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(5).set(0, "validFullname - failed");
		}
	}
	public void invalidEmail()
	{
		String status = faqLocator.invalidEmail();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(6).set(0, "invalidEmail - failed");
		}
	}
	public void EmptyEmail()
	{
		String status = faqLocator.EmptyEmail();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(7).set(0, "EmptyEmail - failed");
		}
	}
	public void validEmail()
	{
		String status = faqLocator.validEmail();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(8).set(0, "validEmail - failed");
		}
	}
	public void EmptyContact()
	{
		String status = faqLocator.InvalidContact();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(9).set(0, "InvalidContact - failed");
		}
	}
	public void validContact()
	{
		String status = faqLocator.EmptyContact();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(10).set(0, "EmptyContact - failed");
		}
	}
	public void InvalidContact()
	{
		String status = faqLocator.validContact();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(11).set(0, "validContact - failed");
		}
	}
	public void EmptyQuery()
	{
		String status = faqLocator.EmptyQuery();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FAQ").get(12).set(0, "EmptyQuery - failed");
		}
	}
}
