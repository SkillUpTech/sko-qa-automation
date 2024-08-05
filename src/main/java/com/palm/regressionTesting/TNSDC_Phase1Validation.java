package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class TNSDC_Phase1Validation implements Callable<String>
{ 
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	TNSDC_Phase1Locator checkTNSDC_Phase1Locator;
	String sheetStatus = "Pass";

public TNSDC_Phase1Validation(ArrayList<ArrayList<String>> sheetData)
{
	this.sheetData = sheetData;
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
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Hemamalini\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
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
	System.out.println("TNSDC phase 1 verification");

	try
	{
	driver = this.openDriver(RegressionTesting.nameOfBrowser);
	OpenWebsite.openSite(driver);
	this.checkTNSDC_Phase1Locator = new TNSDC_Phase1Locator(driver);
	String BaseWindow = driver.getWindowHandle();
	for(int i = 0; i < this.sheetData.size(); i++)
	{
		ArrayList<String> row = this.sheetData.get(i);
		String firstColumn = row.get(0);
		switch(firstColumn)
		{
			case "login":
				verifylogin(row.get(1), row.get(2));
				break;
			case "MentorDashoardPage":
				verifyMentorDashoardPage(row.get(1));
				break;
			case"MentorDashboardValidation":
				verifyMentorDashboardPage(row);
			break;
		}
	}
	
	driver.quit();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return sheetStatus;
}


public void verifylogin(String username, String password)
{
	String status = checkTNSDC_Phase1Locator.verifyloginPage(username, password);
	if(status.contains("fail"))
	{
		sheetStatus = "Fail";
		RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(0).set(0, "TNSDC_1 - failed");
	}

}

public void verifyMentorDashoardPage(String url)
{
	String status = checkTNSDC_Phase1Locator.verifyURL(url);
	if(status.contains("fail"))
	{
		sheetStatus = "Fail";
		RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(1).set(0, "TNSDC_1 - failed");
	}

}
public void verifyMentorDashboardPage(ArrayList<String> data)
{
	ArrayList<String> status = checkTNSDC_Phase1Locator.MentorDashboardProcess(data);
	if(status.contains("fail"))
	{
		if(status.contains("collegeNameFail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(1, "TNSDC_1 - failed");
		}
		else if(status.contains("issue in collegeName"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("MicrosoftPage").get(2).add(1, ("issue in collegeName" + "failed"));

		}
		else if(status.contains("courseNameFail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(2, "TNSDC_1 - failed");

		}
		else if(status.contains("projectName"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(3, "TNSDC_1 - failed");

		}
		else if(status.contains("viewTeamFail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(4, "TNSDC_1 - failed");

		}
		else if(status.contains("createTeamFail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(5, "TNSDC_1 - failed");

		}
		else if(status.contains("selectUserFail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(6, "TNSDC_1 - failed");

		}			
		else if(status.contains("unSelectUserFail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(7, "TNSDC_1 - failed");

		}
		else if(status.contains("saveButtonFail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(8, "TNSDC_1 - failed");

		}
		else if(status.contains("backButtonFail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(9, "TNSDC_1 - failed");

		}
		
	}
	else if(status.contains("issue"))
	{
		sheetStatus = "Fail";
		RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(2).set(0, "TNSDC_1 - failed");

	}
	
}
}
