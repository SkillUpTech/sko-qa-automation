package com.seo.regression.testing;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class HomePageValidator 
{
	private String SHEET_NAME;
	ArrayList<ArrayList<String>> sheetData;
	WebDriver driver;
	HomepageLocator homepageLocator;
	String sheetStatus;
	
	public HomePageValidator(WebDriver driver, String sheetName, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.driver = driver;
		OpenWebsite.openSite(this.driver);
		this.SHEET_NAME = sheetName; 
		this.sheetData = sheetData;
		this.homepageLocator = new HomepageLocator(this.driver);
		System.out.println("Homepage process started");
		sheetStatus = "Pass";
	}

	public void homePage(WebDriver driver)
	{
		if(!driver.getCurrentUrl().equalsIgnoreCase(OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE)))
		{
			String url = OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE);
			driver.get(url);
		}
		else
		{
			System.out.println("you already in home page");
		}
	}
	public String start() throws InterruptedException
	{
		this.homePage(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
			case "Banner":
				verifyBanner(row);
				break;
			case"learningPartners":
				verifyLearningPartners(row);
				break;
			case"coursesCatalog":
				verifyLearningCatalog(row.get(1));
				break;
			case"humanSkills":
				verifyHumanSkills(row);
				break;
			case"topTechCategories":
				verifyTopTechCategories(row);
				break;
			}
		}
		return sheetStatus;
	}

	/*
	 * public String openSite() throws InterruptedException { String HomePageURL =
	 * OpenWebsite.openSite(driver); return HomePageURL; }
	 */
	//String getHomePageURL = OpenWebsite.setHost;
	
	public void verifyBanner(ArrayList<String> dataFromExcel) throws InterruptedException
	{
		ArrayList<String> status = homepageLocator.checkSliderLink(dataFromExcel);
		{
			for(int i = 0; i < status.size(); i++)
			{
				if(dataFromExcel.contains(status.get(i)))
				{
					sheetStatus = "Fail";
					int position = dataFromExcel.indexOf(status.get(i));
					String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(0).get(position);
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(0).set(position, (cellValue + " - failed"));

				}
			}
		}
	}
	public void verifyLearningPartners(ArrayList<String> dataFromExcel)
	{
		if(!dataFromExcel.contains("NA"))
		{
			ArrayList<String> statusOfLearningPartners = homepageLocator.checkLearningPartners(dataFromExcel);
			for(int i = 0; i < statusOfLearningPartners.size(); i++)
			{
				if(dataFromExcel.contains(statusOfLearningPartners.get(i)))
				{
					sheetStatus = "Fail";
					int position = dataFromExcel.indexOf(statusOfLearningPartners.get(i));
					String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(1).get(position);
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(1).set(position, (cellValue + " - failed"));

				}
			}
		}
	}
	public void verifyLearningCatalog(String dataFromExcel) throws InterruptedException
	{
		if(!dataFromExcel.contains("NA"))
		{
			ArrayList<String> statusOfLearningPartners = homepageLocator.checkLearningCatalog();
			if(statusOfLearningPartners.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(2).set(0, "learningCatalog - failed");
			}
		}
	}
	public void verifyHumanSkills(ArrayList<String> dataFromExcel)
	{
		if(!dataFromExcel.contains("NA"))
		{
			ArrayList<String> statusOfHumanSkills = homepageLocator.checkHumanSkills(dataFromExcel);
			for(int i = 0; i < statusOfHumanSkills.size(); i++)
			{
				if(dataFromExcel.contains(statusOfHumanSkills.get(i)))
				{
					sheetStatus = "Fail";
					int position = dataFromExcel.indexOf(statusOfHumanSkills.get(i));
					String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(2).get(position);
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(2).set(position, (cellValue + " - failed"));

				}
			}
		}
	}
	
	public void verifyTopTechCategories(ArrayList<String> dataFromExcel)
	{
		if(!dataFromExcel.contains("NA"))
		{
			ArrayList<String> statusOfTopTechCategories = homepageLocator.checkTopTechCategories(dataFromExcel);
			for(int i = 0; i < statusOfTopTechCategories.size(); i++)
			{
				if(dataFromExcel.contains(statusOfTopTechCategories.get(i)))
				{
					sheetStatus = "Fail";
					int position = dataFromExcel.indexOf(statusOfTopTechCategories.get(i));
					String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(3).get(position);
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(3).set(position, (cellValue + " - failed"));

				}
			}
		}
	}
}
