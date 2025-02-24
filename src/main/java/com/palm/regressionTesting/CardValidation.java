package com.palm.regressionTesting;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

public class CardValidation implements Callable<String>
{

	WebDriver driver;
	String jiraProcess ="";
	ArrayList<ArrayList<String>> sheetData = null;
	CardLocators cardLocators;
	String sheetStatus = "Pass";
	
	public CardValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	
	@Override
	public String call() throws Exception 
	{
		System.out.println("Course Purchase Activation Handler Validation");
		try
		{
			this.cardLocators = new CardLocators(driver);
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				ArrayList<String> row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
							
				case "category_HS": 
					verifyCategoryURL(); 
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
	
	public void verifyCategoryURL()
	{
		
	}

}
