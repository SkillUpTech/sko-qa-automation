package com.palm.regressionTesting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderFooterInErrorScreenLocator
{
	//https://qa-in.skillup.online/courses/
	WebDriver driver;
	String parentWindow = "";
	@FindBy(xpath = "//a[contains(text(),'LOGIN')]")
	private WebElement clickLoginIcon;
	
	@FindBy(xpath = "//a[contains(text(),'SIGNUP ')]") //Find out more
	private WebElement clickSignUpIcon;
	
	@FindBy(xpath = "//div[@class='navbar-brand']/a|//div[contains(@class,'Header_headerLeft')]") //skillup icon
	private WebElement clickSkillupIcon;
	
	@FindBy(xpath = "//a[contains(text(),'About SkillUp')]")
	private List<WebElement> clickAboutSkillupIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Contact us')]")
	private WebElement clickContactUSIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Blog')]")
	private List<WebElement> clickBlogIcon;
	
	@FindBy(xpath = "//ul[contains(@class,'socialIconsSection')]//a[contains(@href,'twitter')]")
	private WebElement clickTwitter;
	
	@FindBy(xpath = "//ul[contains(@class,'socialIconsSection')]//a[contains(@href,'facebook')]")
	private WebElement clickFacebook;
	
	@FindBy(xpath = "//ul[contains(@class,'socialIconsSection')]//a[contains(@href,'linked')]")
	private WebElement clickLinkedIn;
	
	@FindBy(xpath = "//ul[contains(@class,'socialIconsSection')]//a[contains(@href,'instagram')]")
	private WebElement clickInstagram;
	
	@FindBy(xpath = "//ul[contains(@class,'socialIconsSection')]//a[contains(@href,'youtube')]")
	private WebElement clickYoutube;
	
	@FindBy(xpath = "//div[contains(@class,'FootLoGo')]/a")
	private WebElement clickSkillupLogoOnFooter;
	
	@FindBy(xpath = "//div[@class='ContActUs']/a[contains(@href,'contact?')]")
	private WebElement clickContactUSFooter;
	
	@FindBy(xpath = "//div[@class='FootMenu']//li/a[contains(text(),'About SkillUp')]")
	private WebElement clickAboutSkillupOnlineFooter;
	
	@FindBy(xpath = "//div[contains(@class,'FootMenu')]//li/a[contains(text(),'SkillUp for Business')]")
	private WebElement clickSkillupOnlineForBusiness;
	
	@FindBy(xpath = "//div[contains(@class,'FootMenu')]//li/a[contains(@href,'placement?')]")
	private WebElement clickPlacement;
	
	@FindBy(xpath = "//div[contains(@class,'FootMenu')]//li/a[contains(text(),'FAQ')]")
	private WebElement clickFAQ;
	
	@FindBy(xpath = "//div[contains(@class,'FootMenu')]//li/a[contains(text(),'Privacy Policy')]")
	private WebElement clickPrivacyPolicy;
	
	@FindBy(xpath = "//div[contains(@class,'FootMenu')]//li/a[contains(text(),'Terms of Service')]")
	private WebElement clickTermsOfService;
	
	@FindBy(xpath = "//div[contains(@class,'FootMenu')]//li/a[contains(@href,'blog')]")
	private WebElement clickBlogFooter;
	
	@FindBy(xpath = "//div[contains(@class,'FootMenu')]//li/a[contains(@href,'newsletterpage')]")
	private WebElement clickNewsLetter;
	
	@FindBy(xpath = "//div[contains(@class,'FootMenu')]//li/a[contains(@href,'prpage')]")
	private WebElement clickPressRelease;
	
	@FindBy(xpath = "//div[contains(@class,'FootMenu')]//li/a[contains(@href,'events')]")
	private WebElement clickEvents;
	
	@FindBy(xpath = "//li[contains(@class,'nav-item dropdown Header_dropdown')]//img[@alt='icon']")
	private WebElement clickDropdown;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//ul[@class='categorylist customscroll dropdown-submenu']/li/a")
	private List<WebElement> checkCategoryFromMegamenu;//Categories
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//div[@class='CatMENUInR']/div[3]/div[2]//li[@class='exploreAll']/a")
	private WebElement checkExploreAll;//Explore All
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//ul[@class='learning-Partners']//a")
	private List<WebElement> checkCoursesByFromMegamenu;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//ul[@class='categorylist dropdown-submenu']//a")
	private WebElement checkServicesFromMegamenu;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//ul[@class='MegaMenu_PopularCourse']//a")
	private List<WebElement> checkPopularCoursesFromMegamenu;//Popular Courses
	
	
	@FindBy(xpath = "//div[contains(@class,'Footer_PopularCategories')]//ul/li/a")
	private List<WebElement> checkPopularCategoriesOnFooter;//Popular Categories
	
	@FindBy(xpath = "//div[contains(@class,'Footer_PopularCourses')]//ul/li/a")
	private List<WebElement> checkPopularCoursesOnFooter;//Popular Courses
	
	@FindBy(xpath = "//div[contains(@class,'Footer_LatestBlogs')]//a")
	private List<WebElement> checkLatestBlogsOnFooter;//Latest Blogs
	
	public HeaderFooterInErrorScreenLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String checkURLStatus(String data)
	{
		  String status = "fail";
	        HttpURLConnection connection = null;
	        int responseCode = 200;
			 try 
			 {
		            connection = (HttpURLConnection) (new URL(data).openConnection());
		            connection.setRequestMethod("GET");
		            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		            connection.connect();
		            responseCode = connection.getResponseCode();
		            System.out.println("Status code: " + responseCode + " URL: " + data);
		            if (responseCode >= 400 && responseCode <= 405 || responseCode == 410 || responseCode == 429 || responseCode >=500 && responseCode <= 505) 
		            {
		                System.out.println("Broken link: " + data);
		                status = "fail: " + responseCode;
		            } 
		            else 
		            {
		                System.out.println("Unbroken link: " + data + " " + responseCode);
		                status = "success";
		            }
		        } 
			 catch (Exception e) 
			 {
		            e.printStackTrace();
		     }
			 finally
			 {
		            if (connection != null)
		            {
		                connection.disconnect();
		            }
			 }
			return status;
	}
	public String loginProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickLoginIcon);
			String statusURL = this.checkURLStatus(clickLoginIcon.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("Login Process completed "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String signUpIconProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickSignUpIcon);
			String statusURL = this.checkURLStatus(clickSignUpIcon.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("signup Process completed "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String skillupIconOnTopProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		parentWindow = driver.getWindowHandle();
		try
		{
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://qa-in.skillup.online/courses/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickSkillupIcon);
			String statusURL = this.checkURLStatus(clickSkillupIcon.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("skillup icon on Top of page Process completed "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		
		return status;
	}
	
	public String AboutSkillupOnlineProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickAboutSkillupIcon.get(0));
			String statusURL = this.checkURLStatus(clickAboutSkillupIcon.get(0).getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("About skillup online on Top of page Process completed "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String ContactUsProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickContactUSIcon);
			String statusURL = this.checkURLStatus(clickContactUSIcon.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("contact Us on top of page Process completed "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String BlogProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickBlogIcon.get(0));
			String statusURL = this.checkURLStatus(clickBlogIcon.get(0).getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("blog on top of page Process completed "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String categoryProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click();", clickDropdown);
				if(checkCategoryFromMegamenu.size()>0)
                {
                    for (WebElement eachCategory : checkCategoryFromMegamenu) 
                    {
                        js.executeScript("arguments[0].scrollIntoView();", eachCategory);
                        String url = eachCategory.getAttribute("href");
                        String statusURL = this.checkURLStatus(url);
                        if (statusURL.contains("fail"))
                        {
                            status = "fail";
                        }
                        System.out.println("catgepry Process completed  for" + " : " +  url+ " : "+statusURL);
                    }
                }
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String partnerProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
				if(checkCoursesByFromMegamenu.size()>0)
                {
                    for (WebElement eachPartner : checkCoursesByFromMegamenu) 
                    {
                        js.executeScript("arguments[0].scrollIntoView();", eachPartner);
                        String url = eachPartner.getAttribute("href");
                        String statusURL = this.checkURLStatus(url);
                        if (statusURL.contains("fail"))
                        {
                            status = "fail";
                        }
                        System.out.println("partner Process completed  for" + " : " +  url+ " : "+statusURL);
                    }
                }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String PopularCoursesProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{

				if(checkCoursesByFromMegamenu.size()>0)
                {
                    for (WebElement eachPartner : checkCoursesByFromMegamenu) 
                    {
                        js.executeScript("arguments[0].scrollIntoView();", eachPartner);
                        String url = eachPartner.getAttribute("href");
                        String statusURL = this.checkURLStatus(url);
                        if (statusURL.contains("fail"))
                        {
                            status = "fail";
                        }
                        System.out.println("Popular courses Process completed  for" + " : " +  url+ " : "+statusURL);
                    }
                }
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String ServicesProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", checkServicesFromMegamenu);
			if(checkServicesFromMegamenu.isDisplayed())
            {
                    String url = checkServicesFromMegamenu.getAttribute("href");
                    String statusURL = this.checkURLStatus(url);
                    if (statusURL.contains("fail"))
                    {
                        status = "fail";
                    }
                    System.out.println("service Process completed  for" + " : " +  url+ " : "+statusURL);
                }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String ExploreAllProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", checkExploreAll);
			if(checkExploreAll.isDisplayed())
            {
                    String url = checkExploreAll.getAttribute("href");
                    String statusURL = this.checkURLStatus(url);
                    if (statusURL.contains("fail"))
                    {
                        status = "fail";
                    }
                    Thread.sleep(1000);
            }
			js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click();", clickDropdown);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
				System.out.println("explore all Process completed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String twitterProcess() throws InterruptedException
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickTwitter);
			String statusURL = this.checkURLStatus(clickTwitter.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			 System.out.println("twitter Process completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String facebookProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickFacebook);
			String statusURL = this.checkURLStatus(clickFacebook.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("facebook Process completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String linkedInProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickLinkedIn);
			String statusURL = this.checkURLStatus(clickLinkedIn.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("linked in Process completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String instagramProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickInstagram);
			String statusURL = this.checkURLStatus(clickInstagram.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("instagram Process completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String youtubeProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickYoutube);
			String statusURL = this.checkURLStatus(clickYoutube.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("youtube Process completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String contactUSProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickContactUSIcon);
			String statusURL = this.checkURLStatus(clickContactUSIcon.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("contactUs  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	
	public String skillupLogoFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickSkillupLogoOnFooter);
			String statusURL = this.checkURLStatus(clickSkillupLogoOnFooter.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("skillup Logo  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	
	public String AboutSkillupOnFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickAboutSkillupOnlineFooter);
			String statusURL = this.checkURLStatus(clickAboutSkillupOnlineFooter.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("About Skillup  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String SkillupOnlineForBusinessProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickSkillupOnlineForBusiness);
			String statusURL = this.checkURLStatus(clickSkillupOnlineForBusiness.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("business  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String PlacementProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickPlacement);
			String statusURL = this.checkURLStatus(clickPlacement.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			}
			System.out.println("placement  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String FAQProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickFAQ);
			String statusURL = this.checkURLStatus(clickFAQ.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("FAQ  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String PrivacyPolicyProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickPrivacyPolicy);
			String statusURL = this.checkURLStatus(clickPrivacyPolicy.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("privacy  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String TermsOfServiceProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickTermsOfService);
			String statusURL = this.checkURLStatus(clickTermsOfService.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("TOS  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String BlogFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickBlogFooter);
			String statusURL = this.checkURLStatus(clickBlogFooter.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("Blog  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	
	public String pressReleaseProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickPressRelease);
			String statusURL = this.checkURLStatus(clickPressRelease.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("press Release  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	public String eventsProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickEvents);
			String statusURL = this.checkURLStatus(clickEvents.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("Event  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	public String newsLetterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", clickNewsLetter);
			String statusURL = this.checkURLStatus(clickNewsLetter.getAttribute("href"));
			if (statusURL.contains("fail"))
			{
				status = "fail";
			} 
			System.out.println("newsLetter  Process on Bottom completed  for "+statusURL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	public String PopularCategoriesOnFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			 
			for (WebElement eachCategoryFromFooter : checkPopularCategoriesOnFooter) 
			{
				js.executeScript("arguments[0].scrollIntoView();", eachCategoryFromFooter);
				String url = eachCategoryFromFooter.getAttribute("href");
				String statusURL = this.checkURLStatus(url);
				if (statusURL.contains("fail"))
				{
					status = "fail";
				}
				System.out.println("Catgeory  Process on Bottom completed  for " +url +" : " + statusURL);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	public String PopularCoursesOnFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			for (WebElement eachPopularCoursesFromFooter : checkPopularCoursesOnFooter) 
			{
				js.executeScript("arguments[0].scrollIntoView();", eachPopularCoursesFromFooter);
				String url = eachPopularCoursesFromFooter.getAttribute("href");
				String statusURL = this.checkURLStatus(url);
				if (statusURL.contains("fail"))
				{
					status = "fail";
				}
				System.out.println("popukarCourse  Process on Bottom completed  for " +url +" : " + statusURL);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
	public String LatestBlogsOnFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			for (WebElement eachBlogsFromFooter : checkLatestBlogsOnFooter) 
			{
				js.executeScript("arguments[0].scrollIntoView();", eachBlogsFromFooter);
				String url = eachBlogsFromFooter.getAttribute("href");
				String statusURL = this.checkURLStatus(url);
				if (statusURL.contains("fail"))
				{
					status = "fail";
				}
				System.out.println("Latest Blogs  Process on Bottom completed  for " +url +" : " + statusURL);
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "exception";
		}
		return status;
	}
}
