package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

public class FooterSectionValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	FooterSectionLocator footerSectionLocator;
	String sheetStatus = "Pass";
	
	public FooterSectionValidation(ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
		
	}
	public WebDriver openDriver(String browserName)
	{
        return DriverManager.getDriver(browserName);
    }
	String footerSectionURL ="success";
	
	public void checkSkillupLogo() throws InterruptedException
	{
		String skillupLogoProcess = footerSectionLocator.verifySkillupLogo();
		if(skillupLogoProcess.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(0).set(0, "skillupLogo - failed");
		}
	}
	
	public void twitter() throws InterruptedException
	{
		String twitterProcess = footerSectionLocator.verifyTwitter();
		if(twitterProcess.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(1).set(0, "twitter - failed");
		}
	}
	public void facebook() throws InterruptedException
	{
		String facebookProcess = footerSectionLocator.verifyFacebook();
		if(facebookProcess.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(2).set(0, "facebook - failed");

		}
	}
	public void instagram() throws InterruptedException
	{
		String instagramProcess = footerSectionLocator.verifyInstagram();
		if(instagramProcess.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(3).set(0, "instagram - failed");

		}
	}
	public void linkedIn() throws InterruptedException
	{
		String skillupLogoProcess = footerSectionLocator.verifyLinkedIn();
		if(skillupLogoProcess.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(4).set(0, "linkedIn - failed");

		}
	}
	
	public void contactUs() throws InterruptedException
	{
		String skillupLogoProcess = footerSectionLocator.verifyContactUs();
		if(skillupLogoProcess.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(5).set(0, "contactUs - failed");

		}
	}
	public void aboutSkillupOnline() throws InterruptedException
	{
		String skillupLogoProcess = footerSectionLocator.verifyAboutSkillupOnline();
		if(skillupLogoProcess.equalsIgnoreCase("fail"))
		{
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(6).set(0, "aboutSkillupOnline - failed");

		}
	}
	public void business() throws InterruptedException
	{
		String skillupLogoProcess = footerSectionLocator.verifyBusiness();
		if(skillupLogoProcess.equalsIgnoreCase("fail"))
		{
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(7).set(0, "business - failed");

		}
	}
	public void faq() throws InterruptedException
	{
		String skillupLogoProcess = footerSectionLocator.verifyFaq();
		if(skillupLogoProcess.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(8).set(0, "faq - failed");

		}
	}
	public void privacyPolicy() throws InterruptedException
	{
		String skillupLogoProcess = footerSectionLocator.verifyPrivacyPolicy();
		if(skillupLogoProcess.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(9).set(0, "privacyPolicy - failed");

		}
	}
	public void verifyTermsofService() throws InterruptedException
	{
		String skillupLogoProcess = footerSectionLocator.verifyTermsofService();
		if(skillupLogoProcess.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(10).set(0, "termsOfservice - failed");
		}
	}
	public void verifyBlog(ArrayList<String> checkURL) throws InterruptedException
	{
		if(!checkURL.contains("NA"))
		{
			String skillupLogoProcess = footerSectionLocator.verifyBlog();
			if(skillupLogoProcess.equalsIgnoreCase("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(11).set(0, "blog - failed");
			}
		}
	}
	public void verifyPopularCategories() throws InterruptedException
	{
		ArrayList<String> categories = footerSectionLocator.verifyPopularCategories();
		for(int i = 0; i < categories.size(); i++)
		{
			if(categories.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(12).add(i+1, (categories.get(i) + " -failed"));
			}
		}
	}
	
	public void verifyPopularCourses() throws InterruptedException
	{
		ArrayList<String> popularCoursesStatus = footerSectionLocator.verifyPopularCourses();
		for(int i = 0; i < popularCoursesStatus.size(); i++)
		{
			if(popularCoursesStatus.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(13).add(i+1, (popularCoursesStatus.get(i) + " -failed"));
			}
		}
	}
	
	public void verifyLatestBlogs() throws InterruptedException
	{
		ArrayList<String> latestBlogsStatus = footerSectionLocator.verifyLatestBlogs();
		for(int i = 0; i < latestBlogsStatus.size(); i++)
		{
			if(latestBlogsStatus.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FooterSection").get(14).add(i+1, (latestBlogsStatus.get(i) + " -failed"));
			}
		}
	}
	
	@Override
	public String call() throws Exception {
		System.out.println("footer section process started");	
		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		this.footerSectionLocator = new FooterSectionLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				  case "skillupLogo":
					checkSkillupLogo();
					break;
				
				  case "twitter": twitter(); break; 
				  case "facebook": facebook(); break;
				  case  "linkedIn": linkedIn(); break; 
				  case "instagram": instagram(); break;
				  case  "contactUs": contactUs(); break; 
				  case "aboutSkillupOnline": aboutSkillupOnline(); break; 
				  case "business": business(); break; 
				  case "faq": faq(); break; 
				  case "privacyPolicy": privacyPolicy(); break; 
				  case "termsOfservice": verifyTermsofService(); break; 
				  case "blog": verifyBlog(row); break;
				 
				case "popularCategories":
					verifyPopularCategories();
					break;
				case "popularCourses":
					verifyPopularCourses();
					break;
				case "latestBlogs":
					verifyLatestBlogs();
					break;
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


}
