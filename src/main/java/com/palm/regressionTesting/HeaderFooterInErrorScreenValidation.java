package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

public class HeaderFooterInErrorScreenValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	HeaderFooterInErrorScreenLocator headerFooterInErrorScreenLocator;
	String sheetStatus = "Pass";
	public HeaderFooterInErrorScreenValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	
	
	public void LoginIcon()
	{
			String status = headerFooterInErrorScreenLocator.loginProcess();
			if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(2).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(2).add(1, ("locator issue" + " - failed"));
			}
	}
	public void signUpIcon()
	{
			String status = headerFooterInErrorScreenLocator.signUpIconProcess();
			if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(3).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(3).add(1, ("locator issue" + " - failed"));
			}
	}
	public void skillupIconOnTop()
	{
			String status = headerFooterInErrorScreenLocator.skillupIconOnTopProcess();
			if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(1).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(1).add(1, ("locator issue" + " - failed"));
			}
	}
	  
	  
	  public void AboutSkillupOnline()
	  {
		  String status =
				  headerFooterInErrorScreenLocator.AboutSkillupOnlineProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(4).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(4).add(1, ("locator issue" + " - failed"));
			}
	  }
	  
	  public void ContactUs() 
	  { 
		  String status =
	  headerFooterInErrorScreenLocator.ContactUsProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(5).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(5).add(1, ("locator issue" + " - failed"));
			}
	  } 
	  
	  public void Blog()
	  { 
		  String status =
	  headerFooterInErrorScreenLocator.BlogProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(6).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(6).add(1, ("locator issue" + " - failed"));
			}
	  } 
	  
	  public void twitter() throws InterruptedException
     { 
		  String status =
	  headerFooterInErrorScreenLocator.twitterProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(14).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(14).add(1, ("locator issue" + " - failed"));
			}
	  
	  } 
	  
	  public void facebook()
	  { String status =
	  headerFooterInErrorScreenLocator.facebookProcess();
	  if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(15).add(1, ("url issue" + " - failed"));
		}
		else if (status.equalsIgnoreCase("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(15).add(1, ("locator issue" + " - failed"));
		}
	  } 
	  public void linkedIn() 
	  { String status =
	  headerFooterInErrorScreenLocator.linkedInProcess();
	  if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(16).add(1, ("url issue" + " - failed"));
		}
		else if (status.equalsIgnoreCase("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(16).add(1, ("locator issue" + " - failed"));
		}
	  }
	  public void instagram() 
	  { String status =
	  headerFooterInErrorScreenLocator.instagramProcess();
	  if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(17).add(1, ("url issue" + " - failed"));
		}
		else if (status.equalsIgnoreCase("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(17).add(1, ("locator issue" + " - failed"));
		}
	  } 
	  public void youtube()
	  { String status =
	  headerFooterInErrorScreenLocator.youtubeProcess();
	  if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(18).add(1, ("url issue" + " - failed"));
		}
		else if (status.equalsIgnoreCase("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(18).add(1, ("locator issue" + " - failed"));
		}
	  } 
	  
	  public void skillupLogoFooter() 
	  { 
		  String status =
	  headerFooterInErrorScreenLocator.skillupLogoFooterProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(20).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(20).add(1, ("locator issue" + " - failed"));
			}
	  }
	  public void contactUSFooter() { String status =
			  headerFooterInErrorScreenLocator.contactUSProcess();
	  if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(19).add(1, ("url issue" + " - failed"));
		}
		else if (status.equalsIgnoreCase("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(19).add(1, ("locator issue" + " - failed"));
		}
			  }
	  public void AboutSkillupOnFooter()
	  {
		  String status =
	  headerFooterInErrorScreenLocator.AboutSkillupOnFooterProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(21).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(21).add(1, ("locator issue" + " - failed"));
			}
	  }
 public void SkillupOnlineForBusiness() 
 { String status =
	  headerFooterInErrorScreenLocator.SkillupOnlineForBusinessProcess();
 if(status.equalsIgnoreCase("fail"))
	{
		sheetStatus="Fail";
		RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(22).add(1, ("url issue" + " - failed"));
	}
	else if (status.equalsIgnoreCase("exception"))
	{
		sheetStatus = "Fail";
		RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(22).add(1, ("locator issue" + " - failed"));
	}
	  } 
	  public void Placement() { String status =
	  headerFooterInErrorScreenLocator.PlacementProcess();
	  if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(23).add(1, ("url issue" + " - failed"));
		}
		else if (status.equalsIgnoreCase("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(23).add(1, ("locator issue" + " - failed"));
		} }
	  public void FAQ() { String status =
	  headerFooterInErrorScreenLocator.FAQProcess();
	  if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(24).add(1, ("url issue" + " - failed"));
		}
		else if (status.equalsIgnoreCase("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(24).add(1, ("locator issue" + " - failed"));
		}} 
	  public void PrivacyPolicy() { String status =
	  headerFooterInErrorScreenLocator.PrivacyPolicyProcess();
	  if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(25).add(1, ("url issue" + " - failed"));
		}
		else if (status.equalsIgnoreCase("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(25).add(1, ("locator issue" + " - failed"));
		} }
	  public void TermsOfService() { String status =
	  headerFooterInErrorScreenLocator.TermsOfServiceProcess();
	  if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(26).add(1, ("url issue" + " - failed"));
		}
		else if (status.equalsIgnoreCase("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(26).add(1, ("locator issue" + " - failed"));
		} 
	  }
	  
	  public void BlogFooter()
	  { 
			  String status =
		  headerFooterInErrorScreenLocator.BlogFooterProcess();
			  if(status.equalsIgnoreCase("fail"))
				{
					sheetStatus="Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(27).add(1, ("url issue" + " - failed"));
				}
				else if (status.equalsIgnoreCase("exception"))
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(27).add(1, ("locator issue" + " - failed"));
				}
	 } 
	  
	  public void Categories()
	  {
		  String status =  headerFooterInErrorScreenLocator.categoryProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(8).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(8).add(1, ("locator issue" + " - failed"));
			}
	  }
	  
	  public void PartnerPage() 
	  {
		  String status =  headerFooterInErrorScreenLocator.partnerProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(9).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(9).add(1, ("locator issue" + " - failed"));
			}
	  } 
	  public void PopularCourses()
	  {
		  String status =  headerFooterInErrorScreenLocator.PopularCoursesProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(10).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(10).add(1, ("locator issue" + " - failed"));
			} 
	  } 
	  
	  public void Services()
	  {
		  String status =  headerFooterInErrorScreenLocator.ServicesProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(11).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(11).add(1, ("locator issue" + " - failed"));
			}
	  }
	  
	  public void ExploreAll()
	  {
		  String status =  headerFooterInErrorScreenLocator.ExploreAllProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(12).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(12).add(1, ("locator issue" + " - failed"));
			}
	  }
	  
	  public void pressRelease()
	  {
		  String status =  headerFooterInErrorScreenLocator.pressReleaseProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(28).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(28).add(1, ("locator issue" + " - failed"));
			}
	  }
	  public void events()
	  {
		  String status =  headerFooterInErrorScreenLocator.eventsProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(29).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(29).add(1, ("locator issue" + " - failed"));
			} 
	  }
	  public void newsLetter()
	  {
		  String status =  headerFooterInErrorScreenLocator.newsLetterProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(30).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(30).add(1, ("locator issue" + " - failed"));
			} 
	  }
	  public void PopularCategoriesOnFooter()
	  {
		  String status =  headerFooterInErrorScreenLocator.PopularCategoriesOnFooterProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(31).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(31).add(1, ("locator issue" + " - failed"));
			} 
	  }
	  public void PopularCoursesOnFooter()
	  {
		  String status =  headerFooterInErrorScreenLocator.PopularCoursesOnFooterProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(32).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(32).add(1, ("locator issue" + " - failed"));
			}
	  }
	  public void LatestBlogsOnFooter()
	  {
		  String status =  headerFooterInErrorScreenLocator.LatestBlogsOnFooterProcess();
		  if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus="Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(33).add(1, ("url issue" + " - failed"));
			}
			else if (status.equalsIgnoreCase("exception"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("HeaderFooterErrorScreen").get(33).add(1, ("locator issue" + " - failed"));
			}
	  }

		/*
		 * public WebDriver openDriver(String browserName) { return
		 * DriverManager.getDriver(browserName); }
		 */
	@Override
	public String call() throws Exception
	{
		try
		{
			
			/*
			 * System.out.println("Header and Footer error page validation"); driver =
			 * this.openDriver(RegressionTesting.nameOfBrowser);
			 * OpenWebsite.openSite(driver);
			 */
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		this.headerFooterInErrorScreenLocator = new HeaderFooterInErrorScreenLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
			case "skillupIconOnTop": 
				skillupIconOnTop();
				break; 
			  case "LoginIcon": 
				  LoginIcon(); 
				  break; 
				  
			  case "signUpIcon": 
				  signUpIcon(); 
				  break;
				  
			  case "AboutSkillupOnline": 
				  AboutSkillupOnline(); 
				  break;  
			  case "ContactUs": 
				  ContactUs(); 
			      break; 
			      
			  case "Blog":
				  Blog();
				  break; 
				  
				/*
				 * case "Categories": Categories(); break;
				 * 
				 * case "PartnerPage": PartnerPage(); break;
				 * 
				 * case "PopularCourses": PopularCourses(); break;
				 * 
				 * case "ExploreAll": ExploreAll(); break;
				 */
				  
			   case "twitter": 
				   twitter(); 
				   break;
			   
			   case "facebook":
				  facebook(); 
				  break; 
				  
			   case "linkedIn": 
				   linkedIn(); 
				   break; 
			   
			   case "instagram":
				  instagram();
				  break; 
				  
			   case "youtube": 
				   youtube(); 
				   break;
			   
			   case "contactUSFooter":
				   contactUSFooter();
				   break;
				   
			   case "skillupLogoFooter":
				   skillupLogoFooter();
				   break;
				   
				  
			   case "SkillupOnlineForBusiness":
					  SkillupOnlineForBusiness(); 
					  break; 
				  
					/*
					 * case "Placement": Placement(); break;
					 */
			   
			   case "FAQ": 
				   FAQ();
				   break;
			   
			   case "PrivacyPolicy": 
					PrivacyPolicy();
					break;
			   
			   case "TermsOfService":
				   TermsOfService();
				   break; 
			   case "BlogFooter":
				   BlogFooter();
				   break;
			   case "pressRelease":
				   pressRelease();
				   break;
			   case "events":
				   events();
				   break;
			   case "newsLetter":
				   newsLetter();
				   break;
			   case "PopularCategoriesOnFooter":
				   PopularCategoriesOnFooter();
				   break;
			   case "PopularCoursesOnFooter":
				   PopularCoursesOnFooter();
				   break;
			   case "LatestBlogsOnFooter":
				   LatestBlogsOnFooter();
				   break;
			}
		}
		 //DriverManager.quitDriver();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	}
	 
}
