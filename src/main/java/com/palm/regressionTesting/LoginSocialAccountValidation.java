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

public class LoginSocialAccountValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	LoginSocialAccountLocator loginSocialAccountLocator;
	String sheetStatus = "Pass";
	WebDriver driver;
	OpenWebsite openWebsite;
	
	public LoginSocialAccountValidation(ArrayList<ArrayList<String>> sheetData) throws InterruptedException
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
	public String call() throws Exception {
		System.out.println("PLU process started");

		try
		{
		driver = this.openDriver(RegressionTesting.nameOfBrowser);
		OpenWebsite.openSite(driver);
		this.loginSocialAccountLocator = new LoginSocialAccountLocator(driver);
		String BaseWindow = driver.getWindowHandle();
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "facebook":
					facebook(row.get(1), row.get(2));
					break;
				case "google":
					google(row.get(1), row.get(2));
					break;
				case "linkedIn":
					linkedIn(row.get(1), row.get(2));
					break;
				case "Microsoft":
					Microsoft(row.get(1), row.get(2));
					break;
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
				else if(driver.getCurrentUrl().contains("courses"))
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
		driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	}
	
	public void facebook(String user, String pwd)
	{
		ArrayList<String> Status = loginSocialAccountLocator.verifyFacebook(user, pwd);
		if(Status.size()>0)
		{
			for(int i = 0; i < Status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("PLU").get(0).add(Status.size()+i,(Status.get(i)+ " - failed"));
			}
		}
	}
	
	public void google(String user, String pwd)
	{
		ArrayList<String> Status = loginSocialAccountLocator.verifyGoogle(user, pwd);
		if(Status.size()>0)
		{
			for(int i = 0; i < Status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("PLU").get(1).add(Status.size()+i,(Status.get(i)+ " - failed"));
			}
		}
	}
	
	public void linkedIn(String user, String pwd)
	{
		ArrayList<String> Status = loginSocialAccountLocator.verifyLinkedIn(user, pwd);
		if(Status.size()>0)
		{
			for(int i = 0; i < Status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("PLU").get(2).add(Status.size()+i,(Status.get(i)+ " - failed"));
			}
		}
	}
	
	public void Microsoft(String user, String pwd)
	{
		ArrayList<String> Status = loginSocialAccountLocator.verifyMicrosoft(user, pwd);
		if(Status.size()>0)
		{
			for(int i = 0; i < Status.size(); i++)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("PLU").get(3).add(Status.size()+i,(Status.get(i)+ " - failed"));
			}
		}
	}
}
