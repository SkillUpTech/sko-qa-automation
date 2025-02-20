package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaviconLocator 
{
	WebDriver driver;
	
	@FindBy(xpath = "//link[@href='/favicon.png']|//link[@href='/favicon.png'][following-sibling::title]|//link[contains(@href,'favicon')]")
	private List<WebElement> checkFaviconSymbol;
	
	@FindBy(css = "div[class='TechCategories_exCollaborationInner__nW6ww'] ul li a")
	private List<WebElement> topTechCategoriesLocator;
	
	@FindBy(css = "div[class*='bannersliderhome_Mainslider'] div[class*='bannersliderhome_bannerContainer']>div[class*='bannersliderhome_bannerSliderHDesktOP'] div[class*='slick-track']>div[class*='slick-slide']  a")
	private List<WebElement> BannerLocator;
	
	@FindBy(css = "div[class*='LearningCatalog_browserCard'] a")
	private List<WebElement> humanSkillsLocator;
	
	@FindBy(css = "div[class='Collaborate_excollaborationInner__0u_r2'] ul li a")
	private List<WebElement> partnerLocator;
	
	@FindBy(css = "div[class*='Header_headerRight'] ul[class*='Header_navLinks'] li:nth-child(1) a")
	private List<WebElement> AboutSkillupHeaderIcon;
	
	@FindBy(css = "div[class*='Header_headerRight'] ul[class*='Header_navLinks'] li:nth-child(2) a")
	private List<WebElement> contactUsHeaderIcon;
	
	@FindBy(css = "div[class*='Header_headerRight'] ul[class*='Header_navLinks'] li:nth-child(3) a")
	private List<WebElement> BlogHeaderIcon;
	
	@FindBy(css = "div[class*='Header_headerRight'] ul[class*='Header_navButtons'] li[class*='Header_loginBtn'] a")
	private List<WebElement> LoginHeaderIcon;
	
	@FindBy(css = "div[class*='Header_headerRight'] ul[class*='Header_navButtons'] li[class*='Header_signupBtn'] a")
	private List<WebElement> SignupHeaderIcon;
	
	@FindBy(css = "ul[class*=' Footer_socialIconsSection'] li:nth-child(1) a")
	private List<WebElement> TwitterIcon;
	
	@FindBy(css = "ul[class*=' Footer_socialIconsSection'] li:nth-child(2) a")
	private List<WebElement> FacebookIcon;
	
	@FindBy(css = "ul[class*=' Footer_socialIconsSection'] li:nth-child(3) a")
	private List<WebElement> LinkedInIcon;
	
	@FindBy(css = "ul[class*=' Footer_socialIconsSection'] li:nth-child(4) a")
	private List<WebElement> InstagramIcon;
	
	@FindBy(css = "ul[class*=' Footer_socialIconsSection'] li:nth-child(5) a")
	private List<WebElement> YoutubeIcon;
	
	@FindBy(css = "div[class*='Footer_FootMenu']>ul>li>a[href*='about']")
	private List<WebElement> AboutSkillupFooterIcon;
	
	@FindBy(css = "div[class*='Footer_FootMenu']>ul>li>a[href*='enterprise']")
	private List<WebElement> EnterpriseFooterIcon;
	
	@FindBy(css = "div[class*='Footer_FootMenu']>ul>li>a[href*='faq']")
	private List<WebElement> FAQFooterIcon;
	
	@FindBy(css = "div[class*='Footer_FootMenu']>ul>li>a[href*='privacy']")
	private List<WebElement> PrivacyFooterIcon;
	
	@FindBy(css = "div[class*='Footer_FootMenu']>ul>li>a[href*='tos']")
	private List<WebElement> TOSFooterIcon;

	@FindBy(css = "div[class*='Footer_FootcoliNR']>div:nth-child(3) ul>li:nth-child(1)>a[href*='blog']")
	private List<WebElement> BlogFooterIcon;
	
	@FindBy(css = "div[class*='Footer_FootcoliNR']>div:nth-child(3) ul>li:nth-child(2)>a[href*='prpage']")
	private List<WebElement> PressReleaseFooterIcon;
	
	@FindBy(css = "div[class*='Footer_FootcoliNR']>div:nth-child(3) ul>li:nth-child(3)>a[href*='events']")
	private List<WebElement> EventsFooterIcon;
	
	@FindBy(css = "div[class*='Footer_FootcoliNR']>div:nth-child(3) ul>li:nth-child(4)>a[href*='newsletterpage']")
	private List<WebElement> NewsLetterFooterIcon;
	
	@FindBy(css = "div[class*='Footer_FootcoliNR']>div:nth-child(3) ul>li:nth-child(5)>a[href*='placement']")
	private List<WebElement> PlacementFooterIcon;
	
	@FindBy(css = "div[class*='Footer_PopularCourses'] ul li a")
	private List<WebElement> PopularCoursesFooterIcon;
	
	@FindBy(xpath = "//div[contains(@class,'Footer_LatestBlogs')]/div[2]/div//a[contains(@class,'Footer_linkblogpost')]")
	private List<WebElement> LatestBlogFooterIcon;
	
	/*
	 * @FindBy(xpath =
	 * "//li[contains(@class,'nav-item dropdown Header_dropdown')]//a") private
	 * List<WebElement> dropDownSelector;
	 */
	
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show']//ul[@class='categorylist customscroll dropdown-submenu']/li/a")
	private List<WebElement> categoryListLocator;
	
	@FindBy(css = "section[id='scrollToTop']>div>div:nth-child(3) div[class*='ManageCardsLimit_showMoreSection']>button")
	private List<WebElement> showMoreSelectorForProgramFromCategory;
	
	@FindBy(css = "div[id='learningCatalogCourses'] div[class*='ManageCardsLimit_showMoreSection'] button")
	private List<WebElement> showMoreSelectorForCoursesFromCategory;
	
	@FindBy(css = "section#scrollToTop>div[class*='container-fluid Courses_containerInner']>div:nth-child(3) div[class*='LearningCatalog_cardRow'] div[class*='FlatCourseCard_FlatcardLinks'] a")
	private List<WebElement> ProgramCardsSelector;
	
	@FindBy(css = "section[class*='container-fluid TechPrograms_mainContainer']>div:nth-child(2) div[class*='TechPrograms_cardWrapper'] a, div[class*='LearningCatalog_cardRow'] div[class*='FlatCourseCard_FlatcardLinks'] a,div[class*='LearningCatalogibm_cardRow'] div[class*='FlatCourseCard_FlatcardLinks'] a")
	private List<WebElement> ProgramCardsSelectorFromPartnerPage;
	
	@FindBy(css = "div[class*='LearningCatalog_cardRow'] div[class*='RegularCourseCard_RegularcardLinks']>a, div[class='row g-3']>div[class*='col-12']>div[class*='HumanSkills_rightCardWrapper'] >a")
	private List<WebElement> CourseCardsSelectorFromPartnerPage;
	
	@FindBy(css = "div[class*='ManageCardsLimit_showMoreSection']>button")
	private List<WebElement> showmoreIconFromPartnerPage;
	
	public FaviconLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	String parentWindow = "";
	public String checkURLStatus(String data)
	{
		String status = "fail";
	    HttpURLConnection connection = null;
	    int responseCode = 200;
        try
        {
            if (data != null && !data.isEmpty())
            {
                connection = (HttpURLConnection) (new URL(data).openConnection());
                connection.setRequestMethod("GET");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                connection.connect();
                responseCode = connection.getResponseCode();
                System.out.println("Status code: " + responseCode + " URL: " + data);
                if (responseCode >= 400 && responseCode <= 405 || responseCode == 410 || responseCode == 429 || responseCode >= 500 && responseCode <= 505) {
                    System.out.println("Broken link: " + data);
                    status = "fail: " + responseCode;
                } else {
                    System.out.println("Unbroken link: " + data + " " + responseCode);
                    status = "success";
                }
            } 
            else 
            {
                System.out.println("Invalid URL: " + data);
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
	
	public ArrayList<String> checkHomePage()
	{
		ArrayList<String> status = new ArrayList<String>();
		System.out.println("Checking Home Page");
		try
		{
			parentWindow = driver.getWindowHandle();
			if(checkFaviconSymbol.size()>0)
			{
				System.out.println("Favicon Symbol is Present on Home Page");
			}
			else
			{
				status.add(driver.getCurrentUrl());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> checkSliderLink() throws InterruptedException
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		try
		{
				if(BannerLocator.size()>0)
				{
					List<WebElement> clickSlide = BannerLocator;
					for(int i = 0; i < clickSlide.size(); i++)
					{
						js.executeScript("arguments[0].scrollIntoView();",  clickSlide.get(i));
						if (clickSlide.get(i).isDisplayed())
						{
							String getSlideLink = clickSlide.get(i).getAttribute("href");
							String urlStatus = this.checkURLStatus(getSlideLink);
							if (urlStatus.contains("fail"))
							{
								status.add(getSlideLink + urlStatus);
							}
							else
							{
								System.out.println("Slide link is working fine");
								driver.switchTo().newWindow(WindowType.TAB);
								driver.get(getSlideLink);
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if(checkFaviconSymbol.size()<=0)
								{
									status.add(getSlideLink);
								}
								driver.close();
								driver.switchTo().window(parentWindow);
							}
						}
					}
					
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public ArrayList<String> checkCategoryPage()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Checking category Page");
		try
		{
			List<WebElement> topTechCategories = topTechCategoriesLocator;
			for(int i = 0; i < topTechCategories.size(); i++)
			{
				js.executeScript("arguments[0].scrollIntoView();",  topTechCategories.get(i));
				if(topTechCategories.get(i).isDisplayed())
				{
					String getCourseLink = topTechCategories.get(i).getAttribute("href");
					String urlLink = this.checkURLStatus(getCourseLink);
					if(urlLink.contains("fail"))
					{
						status.add(getCourseLink+urlLink);
					}
					else
					{
						System.out.println("Course link is working fine");
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getCourseLink);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if(checkFaviconSymbol.size()<=0)
						{
							status.add(getCourseLink);
						}
						
						driver.close();
						driver.switchTo().window(parentWindow);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> checkHumanSkills()
	{
		System.out.println("human skill process started");
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			
			List<WebElement> humanSkillsCourses = humanSkillsLocator;
			for(int i = 0; i < humanSkillsCourses.size(); i++)
			{
				
				js.executeScript("arguments[0].scrollIntoView();",  humanSkillsCourses.get(i));
				if(humanSkillsCourses.get(i).isDisplayed())
				{
					String courseLink = humanSkillsCourses.get(i).getAttribute("href");
					String urlStatus = this.checkURLStatus(courseLink);
					if(urlStatus.contains("fail"))
					{
						status.add(courseLink + urlStatus);
					}
					else
                    {
                        System.out.println("Course link is working fine");
                        driver.switchTo().newWindow(WindowType.TAB);
                        driver.get(courseLink);
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
                        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                        if(checkFaviconSymbol.size()<=0)
						{
							status.add(courseLink);
						}
                        driver.close();
                        driver.switchTo().window(parentWindow);
				}
			}
		}
		}
		catch(Exception e)
        {
            e.printStackTrace();
         }
		return status;
		}
	
	public ArrayList<String> checkLearningPartners()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try
		{
			System.out.println("learning Partners process started");
			List<WebElement> partnerList = partnerLocator;
			for(int i = 0; i < partnerList.size(); i++)
			{
					jse.executeScript("arguments[0].scrollIntoView();",  partnerList.get(i));
					if(partnerList.get(i).isDisplayed())
					{
						System.out.println("partner name : " +partnerList.get(i).getText());
						String partnerURL = partnerList.get(i).getAttribute("href");
						String checkURL = this.checkURLStatus(partnerURL);
						if (checkURL.contains("fail"))
						{
							status.add(partnerList.get(i).getText() + checkURL);
						}
						else
						{
							System.out.println("partner link is working fine");
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(partnerURL);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if(checkFaviconSymbol.size()<=0)
							{
								status.add(partnerURL);
							}
							driver.close();
							driver.switchTo().window(parentWindow);
						}
					}
					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	public ArrayList<String> checkHeader()
	{
		ArrayList<String> status = new ArrayList<String>();
		System.out.println("Checking Header Page");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try
		{
			if(AboutSkillupHeaderIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  AboutSkillupHeaderIcon.get(0));
				String aboutSkillupURL = AboutSkillupHeaderIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(aboutSkillupURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(aboutSkillupURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(contactUsHeaderIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  contactUsHeaderIcon.get(0));
				String ContactUSupURL = contactUsHeaderIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(ContactUSupURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(ContactUSupURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(BlogHeaderIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  BlogHeaderIcon.get(0));
				String BlogHeaderURL = BlogHeaderIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(BlogHeaderURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(BlogHeaderURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(LoginHeaderIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  LoginHeaderIcon.get(0));
				String LoginHeaderURL = LoginHeaderIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(LoginHeaderURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(LoginHeaderURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(SignupHeaderIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  SignupHeaderIcon.get(0));
				String SignupHeaderURL = SignupHeaderIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(SignupHeaderURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(SignupHeaderURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> checkFooter()
	{
		ArrayList<String> status = new ArrayList<String>();
		System.out.println("Checking Footer Page");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		try
		{
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			if(TwitterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  TwitterIcon.get(0));
				String TwitterIconURL = TwitterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(TwitterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(TwitterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(FacebookIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  FacebookIcon.get(0));
				String FacebookIconURL = FacebookIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(FacebookIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(FacebookIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(LinkedInIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  LinkedInIcon.get(0));
				String LinkedInIconURL = LinkedInIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(LinkedInIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(LinkedInIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(InstagramIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  InstagramIcon.get(0));
				String InstagramIconURL = InstagramIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(InstagramIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(InstagramIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(YoutubeIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  YoutubeIcon.get(0));
				String YoutubeIconURL = YoutubeIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(YoutubeIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(YoutubeIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(AboutSkillupFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  AboutSkillupFooterIcon.get(0));
				String AboutSkillupFooterIconURL = AboutSkillupFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(AboutSkillupFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(AboutSkillupFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(EnterpriseFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  EnterpriseFooterIcon.get(0));
				String EnterpriseFooterIconURL = EnterpriseFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(EnterpriseFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(EnterpriseFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(FAQFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  FAQFooterIcon.get(0));
				String FAQFooterIconURL = FAQFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(FAQFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(FAQFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(PrivacyFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  PrivacyFooterIcon.get(0));
				String PrivacyFooterIconURL = PrivacyFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(PrivacyFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(PrivacyFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(TOSFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  TOSFooterIcon.get(0));
				String TOSFooterIconURL = TOSFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(TOSFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(TOSFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(BlogFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  BlogFooterIcon.get(0));
				String BlogFooterIconURL = BlogFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(BlogFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(BlogFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(PressReleaseFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", PressReleaseFooterIcon.get(0));
				String PressReleaseFooterIconURL = PressReleaseFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(PressReleaseFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(PressReleaseFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(EventsFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",   EventsFooterIcon.get(0));
				String EventsFooterIconURL = EventsFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(EventsFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(EventsFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(NewsLetterFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  NewsLetterFooterIcon.get(0));
				String NewsLetterFooterIconURL = NewsLetterFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(NewsLetterFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(NewsLetterFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			if(PlacementFooterIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();",  PlacementFooterIcon.get(0));
				String PlacementFooterIconURL = PlacementFooterIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(PlacementFooterIconURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(checkFaviconSymbol.size()<=0)
				{
					status.add(PlacementFooterIconURL);
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> verifyPopularCourses() throws InterruptedException
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(PopularCoursesFooterIcon.size()>0)
			{
				List<WebElement> popularCourses = PopularCoursesFooterIcon;
				for(int i = 0; i < popularCourses.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();", popularCourses.get(i));
					if(popularCourses.get(i).isDisplayed())
					{
						String popularCoursesURL=popularCourses.get(i).getAttribute("href");
						String popularCourseStatus = this.checkURLStatus(popularCoursesURL);
						if(popularCourseStatus.contains("fail"))
						{
							status.add(popularCoursesURL);
						}
						else
						{
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(popularCoursesURL);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
							if(driver.getTitle().contains("null")||driver.getTitle().contains("undefined"))
							{
								status.add("title not found" + popularCoursesURL);
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
							}
							else
							{
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if(checkFaviconSymbol.size()<=0)
								{
									status.add(popularCoursesURL);
								}
							}
						}
						driver.close();
						driver.switchTo().window(parentWindow);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					}
				}
			}
			else
			{
				status.add("popular courses not displayed on footer section");
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return status;
	}
	
	

	public ArrayList<String> verifyLatestBlogs() throws InterruptedException
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			List<WebElement> blogs = LatestBlogFooterIcon;
			for(int i = 0; i < blogs.size(); i++)
			{
				js.executeScript("arguments[0].scrollIntoView();", blogs.get(i));
				if(blogs.get(i).isDisplayed())
				{
					String URLForBlogs = blogs.get(i).getAttribute("href");
					String blogsStatusURL=this.checkURLStatus(URLForBlogs);
	                if(blogsStatusURL.contains("fail"))
	                {
	                    status.add(URLForBlogs);
	                }
	                else
	    			{
	    				driver.switchTo().newWindow(WindowType.TAB);
	    				driver.get(URLForBlogs);
	    				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	    				if(driver.getTitle().contains("null")||driver.getTitle().contains("undefined"))
	    				{
	    					status.add("title not found");
	    					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    				} 
	    				else
						{
	    					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	    					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
	    					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if(checkFaviconSymbol.size()<=0)
							{
								status.add(URLForBlogs);
							}
						}
	    			}	
	                driver.close();
	                driver.switchTo().window(parentWindow);
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	            }
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public ArrayList<String> verifyCourseFromCategoryPage()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		String cardsSelector = "";
		
		try
		{
			js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
			System.out.println("course card validation started in category page");
			List<WebElement> topTechCategories = topTechCategoriesLocator;
			for(int i = 0; i < topTechCategories.size(); i++)
			{
				js.executeScript("arguments[0].scrollIntoView();",  topTechCategories.get(i));
				if(topTechCategories.get(i).isDisplayed())
				{
					String getCourseLink = topTechCategories.get(i).getAttribute("href");
						String categoryStatus = this.checkURLStatus(getCourseLink);
						
						if(!categoryStatus.equals("fail"))
						{
							if(getCourseLink.contains("?utm"))
							{
								driver.switchTo().newWindow(WindowType.TAB);
								
								driver.get(getCourseLink);
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
								
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
								
								js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
								
								if(showMoreSelectorForCoursesFromCategory.size()> 0)
								{
									List<WebElement> showMore = showMoreSelectorForCoursesFromCategory;
									boolean hasShowMore = showMore.size() > 0;
									while(hasShowMore)
									{
										js.executeScript("arguments[0].scrollIntoView();", showMore.get(0));
										js.executeScript("arguments[0].click()", showMore.get(0));
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
										
										showMore = showMoreSelectorForCoursesFromCategory;
										if(showMore.size() > 0)
										{
											if (showMore.get(0).getText().contains("more"))
												hasShowMore = true;
											else
												hasShowMore = false;
										}
									}
								}
								cardsSelector = "div[class*='LearningCatalog_cardRow'] div[class*='RegularCourseCard_RegularcardLinks']>a";
								
								  if(getCourseLink.contains("azure"))
								  {
									  cardsSelector = "section#scrollToTop>div[class*='container-fluid Courses_containerInner']>div:nth-child(1) div[class*='LearningCatalog_cardRow']>div";
								  }
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if(driver.findElements(By.cssSelector(cardsSelector)).size() > 0)
								{
									List<WebElement> cards = driver.findElements(By.cssSelector(cardsSelector));
									
									String categoryPage = driver.getWindowHandle();
									
									for(WebElement card: cards)
									{
										js.executeScript("arguments[0].scrollIntoView();", card);
										
										String cardNameLocator = " div[class*='RegularCourseCard_courseHeading']>p";
										
										WebElement cardName = card.findElement(By.cssSelector(cardNameLocator));
										wait.until(ExpectedConditions.visibilityOf(cardName));
										String href = card.getAttribute("href");
										
										boolean isCardWorking = this.checkURLStatus(href).equals("success");
										if(isCardWorking)
										{
											driver.switchTo().newWindow(WindowType.TAB);
											driver.get(href);
											driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					    					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					    					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
											if(checkFaviconSymbol.size()<=0)
											{
												status.add(href);
											}
											 driver.close();
											 driver.switchTo().window(categoryPage);
										}
									}
								}
								driver.close();
								driver.switchTo().window(parentWindow);
							}
						}
					}
					
				}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> verifyProgramFromCategoryPage()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("window.scrollTo(0, document.body.scrollHeight / 2)");
			System.out.println("program card validation started in category page");
			List<WebElement> topTechCategories = topTechCategoriesLocator;
			for(int i = 0; i < topTechCategories.size(); i++)
			{
				js.executeScript("arguments[0].scrollIntoView();",  topTechCategories.get(i));
				if(topTechCategories.get(i).isDisplayed())
				{
					String getCourseLink = topTechCategories.get(i).getAttribute("href");
						
						String categoryStatus = this.checkURLStatus(getCourseLink);
						
						if(!categoryStatus.equals("fail"))
						{
							if(getCourseLink.contains("?utm"))
							{
								driver.switchTo().newWindow(WindowType.TAB);
								
								driver.get(getCourseLink);
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								
								if(showMoreSelectorForProgramFromCategory.size()> 0)
								{
									List<WebElement> showMore = showMoreSelectorForProgramFromCategory;
									boolean hasShowMore = showMore.size() > 0;
									while(hasShowMore)
									{
										js.executeScript("arguments[0].scrollIntoView();", showMore.get(0));
										js.executeScript("arguments[0].click()", showMore.get(0));
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
										
										showMore = showMoreSelectorForProgramFromCategory;
										if(showMore.size() > 0)
										{
											if (showMore.get(0).getText().contains("more"))
												hasShowMore = true;
											else
												hasShowMore = false;
										}
									}
								}
								
								if(ProgramCardsSelector.size() > 0)
								{
									List<WebElement> cards = ProgramCardsSelector;
									
									String categoryPage = driver.getWindowHandle();
									
									for(WebElement card: cards)
									{
										js.executeScript("arguments[0].scrollIntoView();", card);
										
										String href = card.getAttribute("href");
										
										boolean isCardWorking = this.checkURLStatus(href).equals("success");
										if(isCardWorking)
										{
											driver.switchTo().newWindow(WindowType.TAB);
											driver.get(href);
											driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					    					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					    					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
											if(checkFaviconSymbol.size()<=0)
											{
												status.add(href);
											}
											 driver.close();
											 driver.switchTo().window(categoryPage);
										}
									}
								}
								driver.close();
								driver.switchTo().window(parentWindow);
							}
						}
					}
					
				}
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> verifyCourseFromPartnerPage()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			System.out.println("course card validation started in partner page");
			List<WebElement> partnerList = partnerLocator;
			for(int i = 0; i < partnerList.size(); i++)
			{
					js.executeScript("arguments[0].scrollIntoView();",  partnerList.get(i));
					if(partnerList.get(i).isDisplayed())
					{
						System.out.println("partner name : " +partnerList.get(i).getText());
						String partnerURL = partnerList.get(i).getAttribute("href");
						String checkURL = this.checkURLStatus(partnerURL);
						if (checkURL.contains("fail"))
						{
							status.add(partnerList.get(i).getText() + checkURL);
						}
						else
						{
							System.out.println("partner link is working fine");
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(partnerURL);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							
							if(showmoreIconFromPartnerPage.size()>0)
							{
								List<WebElement> showMore = showmoreIconFromPartnerPage;
								boolean hasShowMore = showMore.size() > 0;
								while (hasShowMore) {
									js.executeScript("arguments[0].scrollIntoView();", showMore.get(0));
									js.executeScript("arguments[0].click()", showMore.get(0));
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

									showMore = showmoreIconFromPartnerPage;
									if (showMore.size() > 0) {
										if (showMore.get(0).getText().contains("more"))
											hasShowMore = true;
										else
											hasShowMore = false;
									}
								}
							}
							
							if(CourseCardsSelectorFromPartnerPage.size()>0)
							{
								List<WebElement> cards =  CourseCardsSelectorFromPartnerPage;
								String partnerPage = driver.getWindowHandle();
								
								for(WebElement card: cards)
								{
									js.executeScript("arguments[0].scrollIntoView();", card);
									
									String href = card.getAttribute("href");
									
									boolean isCardWorking = this.checkURLStatus(href).equals("success");
									if(isCardWorking)
									{
										driver.switchTo().newWindow(WindowType.TAB);
										driver.get(href);
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				    					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				    					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
										if(checkFaviconSymbol.size()<=0)
										{
											status.add(href);
										}
										 driver.close();
										 driver.switchTo().window(partnerPage);
									}
								}
							}
							driver.close();
							driver.switchTo().window(parentWindow);
						}
					}
					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> verifyProgramFromPartnerPage()
	{
		ArrayList<String> status = new ArrayList<String>();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try
        {
        	System.out.println("program card validation started in partner page");
			List<WebElement> partnerList = partnerLocator;
			for(int i = 0; i < partnerList.size(); i++)
			{
					js.executeScript("arguments[0].scrollIntoView();",  partnerList.get(i));
					if(partnerList.get(i).isDisplayed())
					{
						System.out.println("partner name : " +partnerList.get(i).getText());
						String partnerURL = partnerList.get(i).getAttribute("href");
						String checkURL = this.checkURLStatus(partnerURL);
						if (checkURL.contains("fail"))
						{
							status.add(partnerList.get(i).getText() + checkURL);
						}
						else
						{
							System.out.println("partner link is working fine");
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(partnerURL);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							
							if(ProgramCardsSelectorFromPartnerPage.size()>0)
							{
								List<WebElement> cards =  ProgramCardsSelectorFromPartnerPage;
								String partnerPage = driver.getWindowHandle();
								
								for(WebElement card: cards)
								{
									js.executeScript("arguments[0].scrollIntoView();", card);
									
									String href = card.getAttribute("href");
									
									boolean isCardWorking = this.checkURLStatus(href).equals("success");
									if(isCardWorking)
									{
										driver.switchTo().newWindow(WindowType.TAB);
										driver.get(href);
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				    					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				    					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
										if(checkFaviconSymbol.size()<=0)
										{
											status.add(href);
										}
										 driver.close();
										 driver.switchTo().window(partnerPage);
									}
								}
							}
							Thread.sleep(2000);
							driver.close();
							driver.switchTo().window(parentWindow);
						}
					}
					
			}
		
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
}
