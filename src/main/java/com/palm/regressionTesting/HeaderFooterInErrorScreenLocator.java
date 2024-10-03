package com.palm.regressionTesting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
	WebDriver driver;
	@FindBy(css = "ul[class='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li[class='Header_loginBtn__3Xv3A']>a")
	private WebElement clickLoginIcon;
	
	@FindBy(css = "li[class*='Header_signupBtn']>a[href*='register']") //Find out more
	private WebElement clickSignUpIcon;
	
	@FindBy(css = "div[class='navbar-brand']>a") //skillup icon
	private WebElement clickSkillupIcon;
	
	@FindBy(css = "ul[class='list-unstyled navbar-nav nav Header_navLinks__aS6_P']>li:nth-child(1)>a")
	private WebElement clickAboutSkillupIcon;
	
	@FindBy(css = "ul[class='list-unstyled navbar-nav nav Header_navLinks__aS6_P']>li:nth-child(2)>a")
	private WebElement clickContactUSIcon;
	
	@FindBy(css = "ul[class='list-unstyled navbar-nav nav Header_navLinks__aS6_P']>li:nth-child(3)>a")
	private WebElement clickBlogIcon;
	
	@FindBy(css = "ul[class=' Footer_socialIconsSection__5DztA d-flex']>li:nth-child(1)>a")
	private WebElement clickTwitter;
	
	@FindBy(css = "ul[class=' Footer_socialIconsSection__5DztA d-flex']>li:nth-child(2)>a")
	private WebElement clickFacebook;
	
	@FindBy(css = "ul[class=' Footer_socialIconsSection__5DztA d-flex']>li:nth-child(3)>a")
	private WebElement clickLinkedIn;
	
	@FindBy(css = "ul[class=' Footer_socialIconsSection__5DztA d-flex']>li:nth-child(4)>a")
	private WebElement clickInstagram;
	
	@FindBy(css = "ul[class*=' Footer_socialIconsSection']>li:nth-child(5)>a")
	private WebElement clickYoutube;
	
	@FindBy(css = "div[class*='Footer_FootLoGo'] img[alt*='logo']")
	private WebElement clickSkillupLogoOnFooter;
	
	@FindBy(css = "div[class='Footer_ContActUs__bZ1xZ']>a")
	private WebElement clickContactUSFooter;
	
	@FindBy(css = "div[class*='Foot'] li:nth-child(1)>a[href*='about']")
	private WebElement clickAboutSkillupOnlineFooter;
	
	@FindBy(css = "div[class*='Foot'] li:nth-child(2)>a[href*='enterprise']")
	private WebElement clickSkillupOnlineForBusiness;
	
	@FindBy(css = "div[class*='Foot'] ul>li:nth-child(5) a[href*='placement']")
	private WebElement clickPlacement;
	
	@FindBy(css = "div[class*='Foot'] ul>li:nth-child(3)>a[href*='faq']")
	private WebElement clickFAQ;
	
	@FindBy(css = "div[class*='Foot'] ul>li:nth-child(4) a[href*='privacy']")
	private WebElement clickPrivacyPolicy;
	
	@FindBy(css = "div[class*='Footer_FootMenu'] ul>li:nth-child(5)>a[href*='tos']")
	private WebElement clickTermsOfService;
	
	@FindBy(css = "div[class*='Foot'] ul>li:nth-child(1) a[href*='blog']")
	private WebElement clickBlogFooter;
	
	@FindBy(css = "div[class*='Foot'] ul>li:nth-child(4) a[href*='news']")
	private WebElement clickNewsLetter;
	
	@FindBy(css = "div[class*='Foot'] ul>li:nth-child(2) a[href*='prpage']")
	private WebElement clickPressRelease;
	
	@FindBy(css = "div[class*='Foot'] ul>li:nth-child(3) a[href*='events']")
	private WebElement clickEvents;
	
	@FindBy(xpath = "//li[contains(@class,'nav-item dropdown Header_dropdown')]//img[@alt='icon']")
	private WebElement clickDropdown;
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//div[@class='CatMENUInR']/div[1]/div[@class='CatHeading']/h2")
	private WebElement checkCategory;//Categories
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//div[@class='CatMENUInR']/div[2]/div[@class='CatHeading']/h2")
	private WebElement checkCoursesBy;//Courses by
	
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//div[@class='CatMENUInR']/div[3]/div[@class='CatHeading']/h2")
	private WebElement checkPopularCourses;//Popular Courses
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//div[@class='CatMENUInR']/div[4]//h2")
	private WebElement checkServices;//Popular Courses
	
	@FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//div[@class='CatMENUInR']/div[3]/div[2]//li[@class='exploreAll']/a")
	private WebElement checkExploreAll;//Explore All
	
	@FindBy(xpath = "//div[contains(@class,'Footer_footerMiddleInR')]/div[1]//h2")
	private WebElement checkPopularCategoriesOnFooter;//Popular Categories
	
	@FindBy(xpath = "//div[contains(@class,'Footer_footerMiddleInR')]/div[2]//h2")
	private WebElement checkPopularCoursesOnFooter;//Popular Courses
	
	@FindBy(xpath = "//div[contains(@class,'Footer_footerMiddleInR')]/div[3]//h2")
	private WebElement checkLatestBlogsOnFooter;//Latest Blogs
	
	public HeaderFooterInErrorScreenLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String checkURL(String link)
	{
		String url = link;
		String urlStatus = "";
		try
		{
			URL obj = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			conn.setReadTimeout(5000);
			conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
			conn.addRequestProperty("User-Agent", "Mozilla");
			conn.addRequestProperty("Referer", "google.com");

			System.out.println("Request URL ... " + url);

			boolean redirect = false;

			// normally, 3xx is redirect
			int status = conn.getResponseCode();
			if (status != HttpURLConnection.HTTP_OK) {
				if (status == HttpURLConnection.HTTP_MOVED_TEMP
					|| status == HttpURLConnection.HTTP_MOVED_PERM
						|| status == HttpURLConnection.HTTP_SEE_OTHER)
				redirect = true;
			}

			System.out.println("Response Code ... " + status);

			if (redirect) {

				// get redirect url from "location" header field
				String newUrl = conn.getHeaderField("Location");

				// get the cookie if need, for login
				String cookies = conn.getHeaderField("Set-Cookie");

				conn = (HttpURLConnection) new URL(newUrl).openConnection();
				conn.setRequestProperty("Cookie", cookies);
				conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
				conn.addRequestProperty("User-Agent", "Mozilla");
				conn.addRequestProperty("Referer", "google.com");
										
				System.out.println("Redirect to URL : " + newUrl);

			}

			BufferedReader in = new BufferedReader(
		                              new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer html = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				html.append(inputLine);
			}
			in.close();

			System.out.println("Done");
			if(status>200)
			{
				urlStatus = "fail" + status;
			}
			else
			{
				urlStatus = "pass";
			}
		    } 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return urlStatus;
		
	}
	public String loginProcess()
	{
		String status = "";
		try
		{
				String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickLoginIcon).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("login"))
					{
						driver.switchTo().window(windows);
						System.out.println("Login page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String signUpIconProcess()
	{
		String status = "";
		try
		{
			String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickSignUpIcon).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("register"))
					{
						driver.switchTo().window(windows);
						System.out.println("signup page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String skillupIconOnTopProcess()
	{
		String status = "";
		try
		{
			driver.get(OpenWebsite.setHost+"/courses/deep/");
			String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickSkillupIcon).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().equals(OpenWebsite.setHost+"/"))
					{
						driver.switchTo().window(windows);
						System.out.println("skillup logo page");
						status = "pass";
						driver.close();
						
						break;
					}
				}
				driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String AboutSkillupOnlineProcess()
	{
		String status = "";
		try
		{
			String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickAboutSkillupIcon).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("about"))
					{
						driver.switchTo().window(windows);
						System.out.println("About Skill up Online process page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String ContactUsProcess()
	{
		String status = "";
		try
		{
			String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickContactUSIcon).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("contact"))
					{
						driver.switchTo().window(windows);
						System.out.println("contact Us  page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String BlogProcess()
	{
		String status = "";
		try
		{
			String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickBlogIcon).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("blog"))
					{
						driver.switchTo().window(windows);
						System.out.println("Blog  page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String categoryProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView(true);", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click();", clickDropdown);
				js.executeScript("arguments[0].scrollIntoView(true);", checkCategory);
				if(checkCategory.isDisplayed())
				{
					System.out.println("category is available");
					status = "pass";
				}
				else
				{
					status = "fail";
				}
				js.executeScript("arguments[0].scrollIntoView(true);", clickDropdown);
				js.executeScript("arguments[0].click();", clickDropdown);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String partnerProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView(true);", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click();", clickDropdown);
				js.executeScript("arguments[0].scrollIntoView(true);", checkCoursesBy);
				if(checkCoursesBy.isDisplayed())
				{
					System.out.println("partners is available");
					status = "pass";
				}
				else
				{
					status = "fail";
				}
				js.executeScript("arguments[0].scrollIntoView(true);", clickDropdown);
				js.executeScript("arguments[0].click();", clickDropdown);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String PopularCoursesProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView(true);", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click();", clickDropdown);
				js.executeScript("arguments[0].scrollIntoView(true);", checkPopularCourses);
				if(checkPopularCourses.isDisplayed())
				{
					System.out.println(" PopularCourses is available");
					status = "pass";
				}
				else
				{
					status = "fail";
				}
				js.executeScript("arguments[0].scrollIntoView(true);", clickDropdown);
				js.executeScript("arguments[0].click();", clickDropdown);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String ServicesProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView(true);", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click();", clickDropdown);
				js.executeScript("arguments[0].scrollIntoView(true);", checkServices);
				if(checkServices.isDisplayed())
				{
					System.out.println(" services is available");
				}
				else
				{
					status = "fail";
				}
				js.executeScript("arguments[0].scrollIntoView(true);", clickDropdown);
				js.executeScript("arguments[0].click();", clickDropdown);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String ExploreAllProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView(true);", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click();", clickDropdown);
				js.executeScript("arguments[0].scrollIntoView(true);",checkExploreAll);
				if(checkExploreAll.isDisplayed())
				{
					System.out.println(" explore all is available");
					String parentWindow = driver.getWindowHandle();
					Actions action = new Actions(driver);
					action.keyDown(Keys.CONTROL).click(checkExploreAll).keyUp(Keys.CONTROL).build().perform();
					Set<String> allWindows = driver.getWindowHandles();
					for(String windows : allWindows)
					{
						driver.switchTo().window(windows);
						if(driver.getCurrentUrl().contains("explore"))
						{
							driver.switchTo().window(windows);
							System.out.println("explore ALL page");
							Thread.sleep(200);
							driver.close();
							Thread.sleep(200);
							status = "pass";
							driver.switchTo().window(parentWindow);
							break;
						}
					}
				}
				else
				{
					status = "fail";
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String twitterProcess() throws InterruptedException
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,-400)", "");
		Thread.sleep(500);
		try
		{
			String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickTwitter).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("x.com"))
					{
						driver.switchTo().window(windows);
						System.out.println("twitter page");
						status = "pass";
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String facebookProcess()
	{
		String status = "";
		try
		{
			String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickFacebook).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("facebook"))
					{
						driver.switchTo().window(windows);
						System.out.println("facebook page");
						status = "pass";
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						driver.switchTo().window(parentWindow);
						break;
					}
					driver.switchTo().window(windows);
				}
				driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String linkedInProcess()
	{
		String status = "";
		try
		{
			String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickLinkedIn).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("linked"))
					{
						driver.switchTo().window(windows);
						System.out.println("LinkedIn page");
						status = "pass";
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String instagramProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String parentWindow = driver.getWindowHandle();
			
				js.executeScript("arguments[0].scrollIntoView();", clickInstagram);
				String instaLink = clickInstagram.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(instaLink);
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("instagram"))
					{
						driver.switchTo().window(windows);
						System.out.println("intagram page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String youtubeProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickYoutube);
				String YoutubeLink = clickYoutube.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(YoutubeLink);
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("youtube"))
					{
						driver.switchTo().window(windows);
						System.out.println("youtube  page");
						status = "pass";
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String contactUSProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String parentWindow = driver.getWindowHandle();
			js.executeScript("arguments[0].scrollIntoView();", clickContactUSFooter);
			String ContactUSFooterLink = clickContactUSFooter.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(ContactUSFooterLink);
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("contact"))
					{
						driver.switchTo().window(windows);
						System.out.println("contact US Page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	
	public String skillupLogoFooterProcess()
	{
		String status = "";
		try
		{
			String parentWindow = driver.getWindowHandle();
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickSkillupLogoOnFooter).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().equals(OpenWebsite.setHost+"/"))
					{
						driver.switchTo().window(windows);
						System.out.println("skillup logo page");
						status = "pass";
						driver.close();
						break;
					}
				}
				driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	
	public String AboutSkillupOnFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickAboutSkillupOnlineFooter);
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickAboutSkillupOnlineFooter).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("about"))
					{
						driver.switchTo().window(windows);
						System.out.println("About Skillup Online footer page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String SkillupOnlineForBusinessProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
				String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickSkillupOnlineForBusiness);
				String SkillupOnlineForBusinessLink = clickSkillupOnlineForBusiness.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(SkillupOnlineForBusinessLink);
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("enterprise"))
					{
						driver.switchTo().window(windows);
						System.out.println("skill up online for business process page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String PlacementProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
				String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickPlacement);
				String PlacementLink = clickPlacement.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(PlacementLink);
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("placement"))
					{
						driver.switchTo().window(windows);
						System.out.println("placement page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String FAQProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickFAQ);
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickFAQ).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("faq"))
					{
						driver.switchTo().window(windows);
						System.out.println("FAQ page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String PrivacyPolicyProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
				String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickPrivacyPolicy);
				String PrivacyPolicyLink = clickPrivacyPolicy.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(PrivacyPolicyLink);
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("privacy"))
					{
						driver.switchTo().window(windows);
						System.out.println("Privacy policy page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String TermsOfServiceProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
				String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickTermsOfService);
				String TermsOfServiceLink = clickTermsOfService.getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(TermsOfServiceLink);
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("tos"))
					{
						driver.switchTo().window(windows);
						System.out.println("Terms of service page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String BlogFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickBlogFooter);
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickBlogFooter).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("blog"))
					{
						driver.switchTo().window(windows);
						System.out.println("blog footer page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String pressReleaseProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickPressRelease);
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickPressRelease).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("pr"))
					{
						driver.switchTo().window(windows);
						System.out.println("pressRelease page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public String eventsProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickEvents);
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickEvents).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("events"))
					{
						driver.switchTo().window(windows);
						System.out.println("events page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public String newsLetterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Thread.sleep(200);
			String parentWindow = driver.getWindowHandle();
				js.executeScript("arguments[0].scrollIntoView();", clickNewsLetter);
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).click(clickNewsLetter).keyUp(Keys.CONTROL).build().perform();
				Set<String> allWindows = driver.getWindowHandles();
				for(String windows : allWindows)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("news"))
					{
						driver.switchTo().window(windows);
						System.out.println("newsLetter page");
						Thread.sleep(200);
						driver.close();
						Thread.sleep(200);
						status = "pass";
						driver.switchTo().window(parentWindow);
						break;
					}
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public String PopularCategoriesOnFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
				js.executeScript("arguments[0].scrollIntoView();", checkPopularCategoriesOnFooter);
				if(checkPopularCategoriesOnFooter.isDisplayed())
				{
					System.out.println(" Popular Categories On Footer is available");
					status = "pass";
				}
				else
				{
					status = "fail";
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public String PopularCoursesOnFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", checkPopularCoursesOnFooter);
			if(checkPopularCoursesOnFooter.isDisplayed())
			{
				System.out.println(" Popular courses On Footer is available");
				status = "pass";
			}
			else
			{
				status = "fail";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public String LatestBlogsOnFooterProcess()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("arguments[0].scrollIntoView();", checkLatestBlogsOnFooter);
			if(checkLatestBlogsOnFooter.isDisplayed())
			{
				System.out.println(" Popular bolgs On Footer is available");
				status = "pass";
			}
			else
			{
				status = "fail";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
