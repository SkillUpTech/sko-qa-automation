package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;


public class HomePageValidator implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData;
	WebDriver driver;
	HomepageLocator homepageLocator;
	String sheetStatus;
	
	public HomePageValidator(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
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

	
	public void verifyBanner() throws InterruptedException
	{
		ArrayList<String> status = homepageLocator.checkSliderLink();
		{
			if(status.size()>0)
			{
				for(int i = 0; i < status.size(); i++)
				{
				
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(0).add(i+1, (status.get(i) + " - failed"));

				}
			}
		}
	}
	public void verifyLearningPartners()
	{
		ArrayList<String> statusOfLearningPartners = homepageLocator.checkLearningPartners();
		if(statusOfLearningPartners.size()>0)
		{
			for(int i = 0; i < statusOfLearningPartners.size(); i++)
			{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(1).add(i + 1,
							(statusOfLearningPartners.get(i) + " - failed"));
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
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(1).set(0, "  - failed");
			}
		}
	}
	public void verifyHumanSkills()
	{
			ArrayList<String> statusOfHumanSkills = homepageLocator.checkHumanSkills();
			for(int i = 0; i < statusOfHumanSkills.size(); i++)
			{
				if(statusOfHumanSkills.size()>0)
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(2).add(i+1, (statusOfHumanSkills.get(i) + " - failed"));
				}
			}
	}
	
	public void verifyTopTechCategories()
	{
			ArrayList<String> statusOfTopTechCategories = homepageLocator.checkTopTechCategories();
			for(int i = 0; i < statusOfTopTechCategories.size(); i++)
			{
				if(statusOfTopTechCategories.size()>0)
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(3).add(i+1, (statusOfTopTechCategories.get(i) + " - failed"));
				}
			}
	}
	
	public void checkCategoryPageTitle()
	{
		ArrayList<String> statusOfTopTechCategories = homepageLocator.verifyPageTitleCategories();
		for(int i = 0; i < statusOfTopTechCategories.size(); i++)
		{
			if(statusOfTopTechCategories.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(5).add(i+1, (statusOfTopTechCategories.get(i) + " - failed"));
			}
		}
	}
	
	public void checkpartnerPageTitle()
	{
		ArrayList<String> statusOfTopTechCategories = homepageLocator.verifyPageTitlePartner();
		for(int i = 0; i < statusOfTopTechCategories.size(); i++)
		{
			if(statusOfTopTechCategories.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HomePage").get(4).add(i+1, (statusOfTopTechCategories.get(i) + " - failed"));
			}
		}
	}

	@Override
	public String call() throws Exception
	{
		System.out.println("Homepage process started");
		sheetStatus = "Pass";

		try
		{
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			this.homepageLocator = new HomepageLocator(this.driver);
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				ArrayList<String> row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
				
				  case "Banner": 
					  verifyBanner();
					  break; 
				  case"learningPartners":
					  verifyLearningPartners(); 
					  break; 
				  case"humanSkills": 
					  verifyHumanSkills();
					  break; 
				  case"topTechCategories": 
					  verifyTopTechCategories();
					  break; 
				  case "categoryPageTitle": 
					  checkCategoryPageTitle();
					  break;
				  case "partnerPageTitle":
					checkpartnerPageTitle();
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
