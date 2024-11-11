package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.regression.utility.TestUtil;

public class ExploreAllValidator implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	ExploreAllLocator exploreAllLocator;
	String sheetStatus = "Pass";
	
	public ExploreAllValidator(ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
		
	}
	
	
	
	public void verifyExploreAllIcons()
	{
		ArrayList<String> getStatus = exploreAllLocator.checkExploreAllLinks();
		for(int i = 0; i < getStatus.size(); i++)
		{
			if(getStatus.get(0).contains("megaMenu_Fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(0).set(1, "verifyExploreAll - failed");
			}
			if(getStatus.get(1).contains("HomePage_Fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(0).set(2, "verifyExploreAll - failed");
			}
			if(getStatus.get(1).contains("mouseHover_Fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(0).set(3, "verifyExploreAll - failed");
			}
		}
	}
	public void verifyActiveCategory_HomePage()
	{
		String getStatus = exploreAllLocator.verifyActiveCategoriesOnHomePage();
		if(getStatus.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(1).set(1, "checkActiveCategoryFromHomePage - failed");

		}
	}
	
	public void verify_clearAll()
	{
		ArrayList<String> getStatus = exploreAllLocator.verifyClearAllAtExploreAllPage();
		if(getStatus.contains("clearAllFail"))
		{
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(2).set(0, "clearAll - failed");
		}
		else if(getStatus.size()>0)
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				if(getStatus.get(0).contains("ResultsFail"))
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(2).set(1, "clearAll - failed");
				}
				if(getStatus.get(1).contains("ContentFail"))
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(2).set(2, "clearAll - failed");
				}
			}
		}
	}
	
	public void verify_Categories()
	{
		ArrayList<String> getStatus = exploreAllLocator.verify_CategoriesFromExploreAllPage();
		if(getStatus.contains("Fail"))
		{
			for(int i = 0; i < getStatus.size(); i++)
			{
				if(getStatus.get(i).contains("courseFail"))
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(3).set(2, "Categories - failed");
				}
				else if(getStatus.get(i).contains("CategoryFail"))
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(3).set(1, "Categories - failed");
				}
			}
		}
	}
	
	public void verify_Level()
	{
		ArrayList<String> getStatus = exploreAllLocator.verify_LevelFromExploreAll();
		for(int i = 0; i < getStatus.size(); i++)
		{
			if(getStatus.get(i).contains("levelsFail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(4).set(1, "levels - failed");
			}
			if(getStatus.get(i).contains("courseFail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(4).set(2, "levels - failed");
			}
		}
	}
	public void verify_learningPartners()
	{
		ArrayList<String> getStatus = exploreAllLocator.verify_learningPartnersFromExploreAll();
		for(int i = 0; i < getStatus.size(); i++)
		{
			if(getStatus.get(i).contains("partnerFail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(5).set(1, "learningPartners - failed");
			}
			if(getStatus.get(i).contains("courseFail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(5).set(2, "learningPartners - failed");
			}
		}
	}
	public void verify_learningStyles()
	{
		ArrayList<String> getStatus = exploreAllLocator.verify_learningStylesFromExploreAll();
		for(int i = 0; i < getStatus.size(); i++)
		{
			if(getStatus.get(i).contains("styleFail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(6).set(1, "learningStyles - failed");
			}
			if(getStatus.get(i).contains("courseFail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ExploreAll").get(6).set(2, "learningStyles - failed");
			}
		}
	}
	public WebDriver openDriver(String browserName)
	{
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", RegressionTesting.driverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.35.0-win64\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			 options.setAcceptInsecureCerts(true);
		        driver = new FirefoxDriver(options);
		        driver.manage().window().maximize();
		        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		}
		return driver;
	}
	@Override
	public String call() throws Exception {
		System.out.println("Explore All validation Process started");

		String[] browsers = { "Firefox", "Chrome"};
	    for (String browser : browsers) {
	        try {
	            driver = this.openDriver(browser);
	            OpenWebsite.openSite(driver);
	            this.exploreAllLocator = new ExploreAllLocator(driver);
	            String BaseWindow = driver.getWindowHandle();
	            for (int i = 0; i < this.sheetData.size(); i++) {
	                ArrayList<String> row = this.sheetData.get(i);
	                String firstColumn = row.get(0);
	                switch (firstColumn) {
	                    case "verifyExporeAll":
	                        verifyExploreAllIcons();
	                        break;
	                    case "checkActiveCategoryFromHomePage":
	                        verifyActiveCategory_HomePage();
	                        break;
	                    case "clearAll":
	                        verify_clearAll();
	                        break;
	                    case "Categories":
	                        verify_Categories();
	                        break;
	                    case "levels":
	                        verify_Level();
	                        break;
	                    case "learningPartners":
	                        verify_learningPartners();
	                        break;
	                    case "learningStyles":
	                        verify_learningStyles();
	                        break;
	                }
	            }
	            Set<String> windows = driver.getWindowHandles();
	            for (String win : windows) {
	                driver.switchTo().window(win);
	                if (!BaseWindow.equals(win)) {
	                    driver.switchTo().window(win);
	                    if (driver.getCurrentUrl().equalsIgnoreCase(OpenWebsite.setURL + "/")) {
	                        driver.switchTo().window(win);
	                        driver.close();
	                        driver.switchTo().window(BaseWindow);
	                    } else if (driver.getCurrentUrl().contains("courses")) {
	                        driver.switchTo().window(win);
	                        driver.close();
	                        driver.switchTo().window(BaseWindow);
	                    } else if (!driver.getCurrentUrl().equalsIgnoreCase(OpenWebsite.setURL + "/")) {
	                        driver.switchTo().window(win);
	                        driver.close();
	                        driver.switchTo().window(BaseWindow);
	                    }
	                }
	            }
	            driver.quit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return sheetStatus;
	}
}
