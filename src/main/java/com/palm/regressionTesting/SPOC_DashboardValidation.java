package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class SPOC_DashboardValidation implements Callable<String>
{
	
		WebDriver driver;
		ArrayList<ArrayList<String>> sheetData = null;
		SPOC_DashboardLocator sPOC_DashboardLocator;
		String sheetStatus = "Pass";

		public SPOC_DashboardValidation(ArrayList<ArrayList<String>> sheetData)
		{
			this.sheetData = sheetData;
		}

		public WebDriver openDriver(String browserName)
		{
			WebDriver driver = null;
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", RegressionTesting.driverPath);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--disable notifications");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\Hemamalini\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
			}
			return driver;
		}

		@Override
		public String call() throws Exception 
		{
			System.out.println("TNSDC phase 2 verification");

			try
			{
				driver = this.openDriver(RegressionTesting.nameOfBrowser);
				OpenWebsite.openSite(driver);
				this.sPOC_DashboardLocator = new SPOC_DashboardLocator(driver);
				for (int i = 0; i < this.sheetData.size(); i++) {
					ArrayList<String> row = this.sheetData.get(i);
					String firstColumn = row.get(0);
					switch (firstColumn)
					{
					
					case "login":
						verifylogin(row.get(1), row.get(2));
						break;
					case "SPOCMentorDashoardPage":
						verifySPOCMentorDashoardPage(row.get(1));
						break;
					/*
					 * case "AddMentor": verifyMentorCreation(row); break;
					 */
					case "UpdateMentor":
						verifyUpdateMentor(row);
						break;
					case "DeleteMentor":
						verifyDeleteMentor(row);
						break;
					case "AddEvaluator":
						verifyEvaluatorCreation(row);
						break;
					case "UpdateEvaluator":
						verifyUpdateEvaluator(row);
						break;
						
					}
				}

				driver.quit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return sheetStatus;
		}
		
		public void verifylogin(String username, String password) {
			String status = sPOC_DashboardLocator.verifyloginPage(username, password);
			if (status.contains("fail")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SPOC").get(0).set(0, "SPOC - failed");
			}

		}

		public void verifySPOCMentorDashoardPage(String url) {
			String status = sPOC_DashboardLocator.verifyURL(url);
			if (status.contains("fail")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SPOC").get(1).set(0, "SPOC - failed");
			}
		}
		
		public void verifyMentorCreation(ArrayList<String> data)
		{
			ArrayList<String> status = sPOC_DashboardLocator.checkMentorCreation(data);
			if(status.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SPOC").get(2).set(0, "SPOC - failed");
	
			}
		}
		
		public void verifyUpdateMentor(ArrayList<String> data)
		{
			ArrayList<String> status = sPOC_DashboardLocator.checkUpdateMentor(data);
			if(status.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SPOC").get(3).set(0, "SPOC - failed");
	
			}
		}
		
		public void verifyDeleteMentor(ArrayList<String> data)
		{
			//span[contains(@class,'tableContent_itemDelete')]
			ArrayList<String> status = sPOC_DashboardLocator.checkDeleteMentor(data);
			if(status.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SPOC").get(4).set(0, "SPOC - failed");
	
			}
		}
		public void verifyEvaluatorCreation(ArrayList<String> data)
		{
			ArrayList<String> status = sPOC_DashboardLocator.checkEvaluatorCreation(data);
			if(status.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SPOC").get(5).set(0, "SPOC - failed");
	
			}
		}
		public void verifyUpdateEvaluator(ArrayList<String> data)
		{
			ArrayList<String> status = sPOC_DashboardLocator.checkUpdateEvaluator(data);
			if(status.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SPOC").get(6).set(0, "SPOC - failed");
	
			}
		}
		public void verifyDeleteEvaluator(ArrayList<String> data)
		{
			ArrayList<String> status = sPOC_DashboardLocator.checkDeleteEvaluator(data);
			if(status.contains("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SPOC").get(7).set(0, "SPOC - failed");
	
			}
		}
}
