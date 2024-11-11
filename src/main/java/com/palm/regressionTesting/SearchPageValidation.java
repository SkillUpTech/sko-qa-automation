package com.palm.regressionTesting;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;
import org.openqa.selenium.WebDriver;


public class SearchPageValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	SearchPageLocator searchPageLocator;
	String sheetStatus = "Pass";
	
	
	public SearchPageValidation(ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
		
	}
	
	public WebDriver openDriver(String browserName)
	{
        return DriverManager.getDriver(browserName);
    }
	
	public void validDataSearch(ArrayList<String> dataFromExcel)
	{
		if(!dataFromExcel.contains("NA"))
		{
			ArrayList<String> getStatus = searchPageLocator.validDataSearchProcess(dataFromExcel);
			for(int i = 0; i < getStatus.size(); i++)
			{
				if(getStatus.contains("fail"))
				{
					sheetStatus="Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(0).set(0, "validDataSearch - failed");
				}
				else if(getStatus.contains("not"))
				{
					sheetStatus="Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(0).add(i+2, (getStatus.get(i) + " - failed"));
				}
			}
		}
	}
	
	public void invalidDataSearch(ArrayList<String> dataFromExcel)
	{
		if(!dataFromExcel.contains("NA"))
		{
			ArrayList<String> getStatus = searchPageLocator.invalidDataSearchProcess(dataFromExcel);
			for(int i = 0; i < getStatus.size(); i++)
			{
				if(getStatus.contains("fail"))
				{sheetStatus="Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(1).set(0, "invalidDataSearch - failed");
				}
				else if(getStatus.contains("not"))
				{
					sheetStatus="Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(1).add(i+2, (getStatus.get(i) + " - failed"));
				}
			}
		}
	}
	
	public void emptySeach(ArrayList<String> dataFromExcel)
	{
		if(!dataFromExcel.contains("NA"))
		{
			ArrayList<String> getStatus = searchPageLocator.emptySearchProcess(dataFromExcel);
			for(int i = 0; i < getStatus.size(); i++)
			{
				if(getStatus.contains(""))
				{sheetStatus="Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(2).set(0, "emptySeach - failed");
				}
				else if(getStatus.contains("not"))
				{
					sheetStatus="Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(2).add(i+2, (getStatus.get(i) + " - failed"));
				}
			}
		}
	}

	



	@Override
	public String call() throws Exception
	{
		System.out.println("Search  process started");
		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			this.searchPageLocator = new SearchPageLocator(driver);
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				ArrayList<String> row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
				case "searchCategory":
					searchCategory(row);
					break;
				case "searchCourse":
					searchCourse(row);
					break;
				case "searchProgram":
					searchProgram(row);
					break;
				case "searchInvalidData":
					searchInvalidData(row);
					break;
				/*
				 * case "validDataSearch": validDataSearch(row); break; case
				 * "invalidDataSearch": invalidDataSearch(row); break; case "emptySeach":
				 * emptySeach(row); break;
				 */
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
	
	public void searchCategory(ArrayList<String> dataFromExcel) 
	{
		if (!dataFromExcel.contains("NA")) 
		{
			ArrayList<String> getStatus = searchPageLocator.searchCategoryProcess(dataFromExcel);
			for (int i = 0; i < getStatus.size(); i++)
			{
				if (getStatus.contains("exception"))
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(3).set(0,	"searchCategory - failed");
				}
				else if (getStatus.contains("fail")) 
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(3).add((getStatus.size() + 1),	(getStatus.get(i) + " - failed"));
				}
			}
		}
	}
	
	public void searchCourse(ArrayList<String> dataFromExcel) 
	{
		if (!dataFromExcel.contains("NA")) {
			ArrayList<String> getStatus = searchPageLocator.searchCourseProcess(dataFromExcel);
			for (int i = 0; i < getStatus.size(); i++) {
				if (getStatus.contains("exception")) {
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(4).set(0,	"searchCourse - failed");
				} else if (getStatus.contains("fail")) {
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(4).add((getStatus.size() + 1),	(getStatus.get(i) + " - failed"));
				}
			}
		}
	}

	public void searchProgram(ArrayList<String> dataFromExcel) {
		if (!dataFromExcel.contains("NA")) {
			ArrayList<String> getStatus = searchPageLocator.searchProgramProcess(dataFromExcel);
			for (int i = 0; i < getStatus.size(); i++) {
				if (getStatus.contains("exception")) {
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(5).set(0, "searchProgram - failed");
				} else if (getStatus.contains("fail")) {
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(5).add((getStatus.size() + 1),	(getStatus.get(i) + " - failed"));
				}
			}
		}
	}
	
	public void searchInvalidData(ArrayList<String> dataFromExcel) {
		if (!dataFromExcel.contains("NA")) {
			ArrayList<String> getStatus = searchPageLocator.searchInvalidDataProcess(dataFromExcel);
			for (int i = 0; i < getStatus.size(); i++) {
				if (getStatus.contains("exception")) {
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(6).set(0,	"searchInvalidData - failed");
				} else if (getStatus.contains("fail")) {
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SearchProcess").get(6).add((getStatus.size() + 1),	(getStatus.get(i) + " - failed"));
				}
			}
		}
	}
}
