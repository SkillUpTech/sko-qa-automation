package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Callable;

import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.Utils;
import com.seo.utility.TestUtil;

public class RegressionTestLogin implements Callable<String>
{
	WebDriver driver;
	String result = "failed";
	String jiraProcess ="";
	ArrayList<ArrayList<String>> sheetData = null;
	ProcessLogin processLogin;
	String sheetStatus = "Pass";
	String browser = "";
	RegressionTesting regressionTesting;
	ArrayList<String> row = new ArrayList<String>();
	ArrayList<String> ticketStatus = new ArrayList<String>();
	
	public RegressionTestLogin(ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus) throws Exception
	{		
		 	this.sheetData = sheetData;
		 	this.jiraProcess = jiraProcessStatus;
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
	
	public void InvalidUsername() throws InterruptedException
	{
		ArrayList<String> credsRow = sheetData.get(0);
		String userName = credsRow.get(1);
		String passWord = credsRow.get(2);
		ArrayList<String> status = this.processLogin.checkInvalidUsername(userName, passWord);
		if(status.contains("success"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(0).set(0, "InvalidUsername - failed");
		}
	}
	
	public void InvalidPassword() throws InterruptedException
	{
		ArrayList<String> credsRow = sheetData.get(1);
		String userName = credsRow.get(1);
		String passWord = credsRow.get(2);
		ArrayList<String> status = this.processLogin.checkInvalidPassword(userName, passWord);
		if(status.contains("Success"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(1).set(0, "InvalidPassword - failed");
		}
	}
	
	public void InvalidUserNameAndPassword() throws InterruptedException
	{
		ArrayList<String> credsRow = sheetData.get(2);
		String userName = credsRow.get(1);
		String passWord = credsRow.get(2);
		ArrayList<String> status = this.processLogin.checkInvalidUserNameAndPassword(userName, passWord);
		if(status.contains("Success"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(2).set(0, "InvalidUserNameAndPassword - failed");
		}
	}
	
	public void ValidCredentials() throws InterruptedException
	{
		ArrayList<String> credsRow = sheetData.get(3);
		String userName = credsRow.get(1);
		String passWord = credsRow.get(2);
		ArrayList<String> status = this.processLogin.checkValidCredentials(userName, passWord);
		
		if(status.contains("Failed"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(3).set(0, "ValidCredentials - failed");
		}
	}
	
	private void checkLogout()throws InterruptedException
	{
		this.processLogin.logOutFunction();
	}

	@Override
	public String call() throws Exception
	{
		System.out.println("login process started");
		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			com.palm.regressionTesting.OpenWebsite.openSite(driver);
			this.processLogin = new ProcessLogin(driver);
			String BaseWindow = driver.getWindowHandle();
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
					case "InvalidUsername":
						InvalidUsername();
						break;
					
					  case "InvalidPassword": InvalidPassword(); break; case
					  "InvalidUserNameAndPassword": InvalidUserNameAndPassword(); break; case
					  "ValidCredentials": ValidCredentials(); break;
					 
				}
			}
			Set<String> windows = driver.getWindowHandles();
			for(String win : windows)
			{
				driver.switchTo().window(win);
				if(!BaseWindow.equals(win))
				{
					driver.switchTo().window(win);
					if(driver.getCurrentUrl().equalsIgnoreCase(OpenWebsite.setURL+"/"))
					{
						driver.switchTo().window(win);
						driver.close();
						driver.switchTo().window(BaseWindow);
					}
					else if(!driver.getCurrentUrl().equalsIgnoreCase(OpenWebsite.setURL+"/"))
					{
						driver.switchTo().window(win);
						driver.close();
						driver.switchTo().window(BaseWindow);
					}
				}
				
			}
			
			if(jiraProcess.contains("Yes"))
			{
				HashMap<String, String> resultStatus = new HashMap<String, String>();
				ArrayList<String> sheetRow = sheetData.get(4);
				String getExecutionStatus = "";
				String getprocessStatus = "";
				JiraTicketStatusUpdate jiraTicketStatusUpdate = new JiraTicketStatusUpdate();
				
				if(sheetStatus == "fail")
				{
					getExecutionStatus = "FAIL";
					resultStatus.put(sheetRow.get(1), getExecutionStatus);
					getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
					System.out.println(getprocessStatus);
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ProgramURLandSlug").get(4).add(2, (getExecutionStatus + "failed"));
				}
				else
				{
					getExecutionStatus = "PASS";
					resultStatus.put(sheetRow.get(1), getExecutionStatus);
					getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
					System.out.println(getprocessStatus);
					
				}
				/*
				 * RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get(
				 * "ProgramURLandSlug").get(4).add(2, (getExecutionStatus)+ Utils.DELIMITTER +
				 * "bold" + Utils.DELIMITTER + "color" +
				 * (getExecutionStatus.equalsIgnoreCase("Pass") ? "Green" : "Red"));
				 */			}
			driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return sheetStatus;
	}
}
