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

public class HeaderFooterInStagecoursesValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	HeaderFooterInStagecoursesLocator headerFooterInStagecoursesLocator;
	String sheetStatus = "Pass";
	public HeaderFooterInStagecoursesValidation(ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		
	}
	
	public void AboutSkillupOnline(String data)
	{
		String status = headerFooterInStagecoursesLocator.AboutSkillupOnlineProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{

			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(2).add(2, (status + " - failed"));
		
		}
	}
	public void ContactUs(String data)
	{
		String status = headerFooterInStagecoursesLocator.ContactUsProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{

			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(3).add(2, (status + " - failed"));
		
		}
	}
	public void Blog(ArrayList<String> data)
	{
		if(!data.contains("NA"))
		{
			String status = headerFooterInStagecoursesLocator.BlogProcess(data);
			if(!status.equalsIgnoreCase("pass"))
			{
				
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(4).add(2, (status + " - failed"));
				
			}
		}
	}
	public void twitter(String data)
	{
		String status = headerFooterInStagecoursesLocator.twitterProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(6).add(2, (status + " - failed"));

		}
		
	}
	public void facebook(String data)
	{
		String status = headerFooterInStagecoursesLocator.facebookProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(7).add(2, (status + " - failed"));

		}
	}
	public void linkedIn(String data)
	{
		String status = headerFooterInStagecoursesLocator.linkedInProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(8).add(2, (status + " - failed"));

		}
	}
	public void instagram(String data)
	{
		String status = headerFooterInStagecoursesLocator.instagramProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(9).add(2, (status + " - failed"));

		}
	}
	public void youtube(String data)
	{
		String status = headerFooterInStagecoursesLocator.youtubeProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(10).add(2, (status + " - failed"));

		}
	}
	
	public void contactUSFooter(String data)
	{
		String status = headerFooterInStagecoursesLocator.contactUSProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(11).add(2, (status + " - failed"));

		}
	}
	public void AboutSkillupOnlineFooter(String data)
	{
		String status = headerFooterInStagecoursesLocator.AboutSkillupOnlineFooterProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(12).add(2, (status + " - failed"));

		}
	}
	public void SkillupOnlineForBusiness(String data)
	{
		String status = headerFooterInStagecoursesLocator.SkillupOnlineForBusinessProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(13).add(2, (status + " - failed"));

		}
	}

	public void FAQ(String data)
	{
		String status = headerFooterInStagecoursesLocator.FAQProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(14).add(2, (status + " - failed"));

		}
	}
	public void PrivacyPolicy(String data)
	{
		String status = headerFooterInStagecoursesLocator.PrivacyPolicyProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(15).add(2, (status + " - failed"));

		}
	}
	public void TermsOfService(String data)
	{
		String status = headerFooterInStagecoursesLocator.TermsOfServiceProcess(data);
		if(!status.equalsIgnoreCase("pass"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(16).add(2, (status + " - failed"));

		}
	}
	public void BlogFooter(String data)
	{
		if(!data.contains("NA"))
		{
			
			String status = headerFooterInStagecoursesLocator.BlogFooterProcess(data);
			if(!status.equalsIgnoreCase("pass"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(17).add(2, (status + " - failed"));
				
			}
		}
	}
	
	public void pressRelease(String data)
	{
		if(!data.contains("NA"))
		{
			
			String status = headerFooterInStagecoursesLocator.pressReleaseProcess(data);
			if(!status.equalsIgnoreCase("pass"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(18).add(2, (status + " - failed"));
				
			}
		}
	}
	public void events(String data)
	{
		if(!data.contains("NA"))
		{
			
			String status = headerFooterInStagecoursesLocator.eventsProcess(data);
			if(!status.equalsIgnoreCase("pass"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(19).add(2, (status + " - failed"));
				
			}
		}
	}
	public void newsLetter(String data)
	{
		if(!data.contains("NA"))
		{
			
			String status = headerFooterInStagecoursesLocator.newsLetterProcess(data);
			if(!status.equalsIgnoreCase("pass"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(20).add(2, (status + " - failed"));
				
			}
		}
	}
	public void placement(String data)
	{
		if(!data.contains("NA"))
		{
			
			String status = headerFooterInStagecoursesLocator.placementProcess(data);
			if(!status.equalsIgnoreCase("pass"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("LinkInStagecourseAndHomepage").get(21).add(2, (status + " - failed"));
				
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
		System.out.println("HeaderFooterInStagecoursesValidation process started");

		try
		{
		driver = this.openDriver(RegressionTesting.nameOfBrowser);
		this.headerFooterInStagecoursesLocator = new HeaderFooterInStagecoursesLocator(driver);
		OpenWebsite.openSite(driver);
		String BaseWindow = driver.getWindowHandle();
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
			  case "AboutSkillupOnline": 
				  AboutSkillupOnline(row.get(1)); 
				  break; 
			  case "ContactUs": 
				  ContactUs(row.get(1)); 
				  break; 
			  case "Blog": 
				  Blog(row); 
				  break; 
			  case "twitter": 
				  twitter(row.get(1)); 
				  break; 
			  case "facebook": 
				  facebook(row.get(1)); 
				  break; 
			  case "linkedIn": 
				  linkedIn(row.get(1)); 
				  break; 
			  case "instagram": 
				  instagram(row.get(1)); 
				  break; 
			  case "youtube": 
				  youtube(row.get(1)); 
				  break; 
			  case "contactUSFooter": 
				  contactUSFooter(row.get(1)); 
				  break; 
			  case "AboutSkillupOnlineFooter": 
				  AboutSkillupOnlineFooter(row.get(1)); 
				  break; 
			  case "SkillupOnlineForBusiness": 
				  SkillupOnlineForBusiness(row.get(1)); 
				  break; 
			  case "FAQ": 
				  FAQ(row.get(1)); 
				  break; 
			  case "PrivacyPolicy": 
				  PrivacyPolicy(row.get(1)); 
				  break; 
			  case "TermsOfService": 
				  TermsOfService(row.get(1)); 
				  break; 					 
			  case "BlogFooter": 
				  BlogFooter(row.get(1)); 
				  break; 		 
			  case "pressRelease": 
				  pressRelease(row.get(1)); 
				  break; 
			  case "events": 
				  events(row.get(1)); 
				  break; 
			  case "newsLetter": 
				  newsLetter(row.get(1)); 
				  break; 
			  case "placement": 
				  placement(row.get(1)); 
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
	
	
}
