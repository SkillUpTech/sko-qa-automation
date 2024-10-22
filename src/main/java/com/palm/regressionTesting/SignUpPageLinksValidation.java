package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class SignUpPageLinksValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	SignUpPageLinksLocator signUpPageLinksLocator;
	String sheetStatus = "Pass";
	
	public SignUpPageLinksValidation(ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		
	}
	
	public void signup()
	{
		String status = signUpPageLinksLocator.checkSignupLink();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUpPageLinks").get(0).set(0, "signup - failed");
		}
	}
	public void facebook()
	{
		String status = signUpPageLinksLocator.checkFacebookLink();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUpPageLinks").get(1).set(0, "facebook - failed");
		}
	}
	
	public void google()
	{
		String status = signUpPageLinksLocator.checkGoogleLink();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUpPageLinks").get(2).set(0, "google - failed");
		}
	}
	
	public void linkedIn()
	{
		String status = signUpPageLinksLocator.checkLinkedInLink();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUpPageLinks").get(3).set(0, "linkedIn - failed");
		}
	}
	
	public void microsoft()
	{
		String status = signUpPageLinksLocator.checkMicrosoftLink();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUpPageLinks").get(4).set(0, "microsoft - failed");
		}
	}
	
	public void LogInLink()
	{
		String status = signUpPageLinksLocator.checkLogInLink();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUpPageLinks").get(5).set(0, "LogInLink - failed");
		}
	}
	
	public void TermsOfService()
	{
		String status = signUpPageLinksLocator.checkTermsOfServiceLink();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUpPageLinks").get(6).set(0, "TermsOfService - failed");
		}
	}
	
	public void PrivacyPolicy()
	{
		String status = signUpPageLinksLocator.checkPrivacyPolicyLink();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUpPageLinks").get(7).set(0, "PrivacyPolicy - failed");
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
		System.out.println("Sign up Page links process started");

		try
		{
		driver = this.openDriver(RegressionTesting.nameOfBrowser);
		this.signUpPageLinksLocator = new SignUpPageLinksLocator(driver);
		OpenWebsite.openSite(driver);
		String BaseWindow = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		OpenWebsite.openSite(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "signup":
					signup();
					break;
				case "facebook":
					facebook();
					break;
				case "google":
					google();
					break;
				case "linkedIn":
					linkedIn();
					break;
				case "microsoft":
					microsoft();
					break;
				case "LogInLink":
					LogInLink();
					break;
				case "TermsOfService":
					TermsOfService();
					break;
				case "PrivacyPolicy":
					PrivacyPolicy();
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
	
	
}
