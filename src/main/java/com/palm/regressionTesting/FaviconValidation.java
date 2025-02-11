package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.openqa.selenium.WebDriver;

public class FaviconValidation implements Callable<String>
{
	WebDriver driver;
	String jiraProcess ="";
	ArrayList<ArrayList<String>> sheetData = null;
	FaviconLocator faviconLocator;
	String sheetStatus = "Pass";
	
	public FaviconValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	
	
	@Override
	public String call() throws Exception 
	{
		System.out.println("Course Purchase Activation Handler Validation");
		try
		{
			this.faviconLocator = new FaviconLocator(driver);
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				ArrayList<String> row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
				
				  case "HomePage": checkHomePage(); break; 
				  case "SliderLink":
				  checkSliderLink(); break; 
				  case "CoursesFromHomepage":
				  checkCoursesFromHomepage(); break; 
				  case "partnerPage": checkpartnerPage();
				  break; case "categoryPage": checkCategoryPage(); break; 
				  case "Header":
				  checkHeader(); break; 
				  case "Footer": checkFooter(); break; 
				  case "popularCourses": verifyPopularCourses(); break; 
				  case "latestBlogs":
				  verifyLatestBlogs(); break;
				 
				
				/*
				 * case "CourseFromCategoryPage": verifyCourseFromCategoryPage(); break;
				 * 
				 * 
				 * case "ProgramFromCategoryPage": verifyProgramFromCategoryPage(); break;
				 */
				 
						
						
						  case "CourseFromPartnerPage": verifyCourseFromPartnerPage(); break; 
							
							  case "ProgramFromPartnerPage": verifyProgramFromPartnerPage(); break;
							 
						 
						 
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	
	}
	
	public void checkHomePage()
	{
		ArrayList<String> status = faviconLocator.checkHomePage();
		if(status.size()>0)
		{
			for (int i = 0; i < status.size(); i++) 
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(0).add(i+1, (status.get(i) + " - failed"));;
			}
		}
	}
	public void checkSliderLink() throws InterruptedException
	{
		ArrayList<String> status = faviconLocator.checkSliderLink();
		if(status.size()>0)
		{
			for (int i = 0; i < status.size(); i++) 
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(1).add(i+1, (status.get(i) + " - failed"));
			}
		}
	}
	public void checkCoursesFromHomepage()
	{
		ArrayList<String> status = faviconLocator.checkHumanSkills();
		if(status.size()>0)
		{
			for (int i = 0; i < status.size(); i++) 
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(3).add(i+1, (status.get(i) + " - failed"));
			}
		}
	}
	public void checkpartnerPage()
	{
		ArrayList<String> status = faviconLocator.checkLearningPartners();
		if(status.size()>0)
		{
			for (int i = 0; i < status.size(); i++) 
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(4).add(i+1, (status.get(i) + " - failed"));
			}
		}
	}
	public void checkCategoryPage()
	{
		ArrayList<String> status = faviconLocator.checkCategoryPage();
		if(status.size()>0)
		{
			for (int i = 0; i < status.size(); i++) 
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(2).add(i+1, (status.get(i) + " - failed"));
			}
		}
	}
	
	public void checkHeader()
	{
		ArrayList<String> status = faviconLocator.checkHeader();
		if(status.size()>0)
		{
			for (int i = 0; i < status.size(); i++) 
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(5).add(i+1, (status.get(i) + " - failed"));
			}
		}
	}
	
	public void checkFooter() 
	{
		ArrayList<String> status = faviconLocator.checkFooter();
		if(status.size()>0)
		{
			for (int i = 0; i < status.size(); i++) 
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(6).add(i+1, (status.get(i) + " - failed"));
			}
		}
	}
	
	
	
	public void verifyPopularCourses() throws InterruptedException
	{
		ArrayList<String> popularCoursesStatus = faviconLocator.verifyPopularCourses();
		for(int i = 0; i < popularCoursesStatus.size(); i++)
		{
			if(popularCoursesStatus.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(7).add(i+1, (popularCoursesStatus.get(i) + " -failed"));
			}
		}
	}
	
	public void verifyLatestBlogs() throws InterruptedException
	{
		ArrayList<String> latestBlogsStatus = faviconLocator.verifyLatestBlogs();
		for(int i = 0; i < latestBlogsStatus.size(); i++)
		{
			if(latestBlogsStatus.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(8).add(i+1, (latestBlogsStatus.get(i) + " -failed"));
			}
		}
	}

	public void verifyCourseFromCategoryPage() throws InterruptedException
	{
		ArrayList<String> latestBlogsStatus = faviconLocator.verifyCourseFromCategoryPage();
		for(int i = 0; i < latestBlogsStatus.size(); i++)
		{
			if(latestBlogsStatus.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(9).add(i+1, (latestBlogsStatus.get(i) + " -failed"));
			}
		}
	}
	public void verifyProgramFromCategoryPage() throws InterruptedException
	{
		ArrayList<String> latestBlogsStatus = faviconLocator.verifyProgramFromCategoryPage();
		for(int i = 0; i < latestBlogsStatus.size(); i++)
		{
			if(latestBlogsStatus.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(10).add(i+1, (latestBlogsStatus.get(i) + " -failed"));
			}
		}
	}
	public void verifyCourseFromPartnerPage() throws InterruptedException
	{
		ArrayList<String> latestBlogsStatus = faviconLocator.verifyCourseFromPartnerPage();
		for(int i = 0; i < latestBlogsStatus.size(); i++)
		{
			if(latestBlogsStatus.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(11).add(i+1, (latestBlogsStatus.get(i) + " -failed"));
			}
		}
	}
	public void verifyProgramFromPartnerPage() throws InterruptedException
	{
		ArrayList<String> latestBlogsStatus = faviconLocator.verifyProgramFromPartnerPage();
		for(int i = 0; i < latestBlogsStatus.size(); i++)
		{
			if(latestBlogsStatus.size()>0)
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("FaviconVerification").get(12).add(i+1, (latestBlogsStatus.get(i) + " -failed"));
			}
		}
	}

}
