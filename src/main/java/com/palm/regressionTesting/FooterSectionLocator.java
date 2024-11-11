package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterSectionLocator
{
	WebDriver driver;
	String parentWindow;
	public FooterSectionLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	public String getDriverDetails()
	{
		String driverName =	OpenWebsite.openSite(driver)+"/";
		return driverName;
	}
	public String verifySkillupLogo() throws InterruptedException
	{
		parentWindow = driver.getWindowHandle();
		String status = "failed";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			js.executeScript("window.scrollBy(0, -300)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			if(driver.findElements(By.cssSelector("div[class*='Footer_footertopmenu'] a[class*='Footer_FTLogo']")).size()>0)
			{
				System.out.println("logo is displayed");
				WebElement clickLogo = driver.findElement(By.cssSelector("div[class*='Footer_footertopmenu'] a[class*='Footer_FTLogo']"));
				js.executeScript("arguments[0].scrollIntoView();", clickLogo);
				wait.until(ExpectedConditions.elementToBeClickable(clickLogo));
				js.executeScript("arguments[0].click()", clickLogo);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				status = "pass";
			} 
			else
			{
				System.out.println("logo is not displayed");
				status="fail";
			}
			
		}
		catch(Exception e)
		{
			status="fail";
			e.printStackTrace();
		}
		
		return status;
	}
	
	public String verifyTwitter() throws InterruptedException
	{
		String status = "failed";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -200)", "");
		try
		{
			if(driver.findElements(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(1) a")).size()>0)
			{
				WebElement clickTwitter = driver.findElement(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(1) a"));
				js.executeScript("arguments[0].scrollIntoView();", clickTwitter);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
				System.out.println("twitter is displayed");
				wait.until(ExpectedConditions.elementToBeClickable(clickTwitter));
				String twitterURL = clickTwitter.getAttribute("href");
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(twitterURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.close();
				driver.switchTo().window(parentWindow);
				status = "success";
	        }
	        else
	        {
	            System.out.println("twitter is not displayed");
	            status = "failed";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "failed";
		}
		
		return status;
	}
	
	public String verifyInstagram() throws InterruptedException
	{
		String status = "failed";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -100)", "");
		try
		{
			if (driver.findElements(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(4) a")).size() > 0)
			{
				System.out.println("instagram is displayed");
				WebElement clickInstagram = driver.findElement(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(4) a"));
				js.executeScript("arguments[0].scrollIntoView();", clickInstagram);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
				wait.until(ExpectedConditions.elementToBeClickable(clickInstagram));
				String instaURL = clickInstagram.getAttribute("href");
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(instaURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.close();
				driver.switchTo().window(parentWindow);
				status = "success";
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			} 
			else
			{
				System.out.println("instagram is not displayed");
				status = "failed";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "failed";
		}
		
		
		
		return status;
	}
	
	public String verifyFacebook() throws InterruptedException
	{
		String status = "failed";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -160)", "");
		try
		{
			if(driver.findElements(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(2) a")).size()>0)
			{
				System.out.println("facebook is displayed");
				WebElement clickFacebook = driver.findElement(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(2) a"));
				js.executeScript("arguments[0].scrollIntoView();", clickFacebook);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
				wait.until(ExpectedConditions.elementToBeClickable(clickFacebook));
				String fbURL = clickFacebook.getAttribute("href");
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(fbURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.close();
				driver.switchTo().window(parentWindow);
				status = "success";
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			} 
			else 
			{
				System.out.println("facebook is not displayed");
				status = "failed";
			}
		}
		catch(Exception e)
        {
            e.printStackTrace();
            status = "failed";
        }
		
		return status;
	}
	
	public String verifyLinkedIn() throws InterruptedException
	{
		String status = "failed";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -200)", "");
		try
		{
			if(driver.findElements(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(3) a")).size()>0)
			{
				WebElement clickLinkedIn = driver.findElement(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(3) a"));
				js.executeScript("arguments[0].scrollIntoView();", clickLinkedIn);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
				wait.until(ExpectedConditions.elementToBeClickable(clickLinkedIn));
				String linkedInURL = clickLinkedIn.getAttribute("href");
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(linkedInURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.close();
				driver.switchTo().window(parentWindow);
				status = "success";
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			}
			else {
				System.out.println("linkedin is not displayed");
				status = "failed";
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status = "failed";
		}
		
		return status;
	}
	
	public String verifyContactUs() throws InterruptedException
	{
		String status = "failed";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -200)", "");
		try
		{
			if(driver.findElements(By.cssSelector("div[class*='Footer_ContActUs']>a")).size()>0)
			{
				System.out.println("contact us is displayed");
				WebElement clickContactUs = driver.findElement(By.cssSelector("div[class*='Footer_ContActUs']>a"));
				js.executeScript("arguments[0].scrollIntoView();", clickContactUs);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
				wait.until(ExpectedConditions.elementToBeClickable(clickContactUs));
				String contactUsURL = clickContactUs.getAttribute("href");
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(contactUsURL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.close();
				driver.switchTo().window(parentWindow);
				status = "success";
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			}
			else
			{
				System.out.println("contact us is not displayed");
				status = "failed";
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status = "failed";
		}
		return status;
	}
	
	public String verifyAboutSkillupOnline() throws InterruptedException
	{
		String status = "failed";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 500)", "");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -200)", "");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		try
		{
			if(driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a")).size()>0)
			{
				System.out.println("about is displayed");
				List<WebElement> clickAboutSkillupOnline= driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a"));
				for(int i = 0; i < clickAboutSkillupOnline.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();",  clickAboutSkillupOnline.get(i));
					String getAboutSkillupURL = clickAboutSkillupOnline.get(i).getAttribute("href");
					if(getAboutSkillupURL.contains("/about/?"))
					{
						wait.until(ExpectedConditions.elementToBeClickable(clickAboutSkillupOnline.get(i)));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getAboutSkillupURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(parentWindow);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
				}
			
			}
			else
			{
				System.out.println("about is not displayed");
				status = "failed";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			status = "failed";
		}
		
		return status;
	}
	
	public String verifyBusiness() throws InterruptedException
	{
		String status = "failed";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -200)", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		try
		{
			if(driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a")).size()>0)
			{
				System.out.println("Business is displayed");
				List<WebElement> clickBusiness= driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a"));
				for(int i = 0; i < clickBusiness.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();",  clickBusiness.get(i));
					String getBusinessURL = clickBusiness.get(i).getAttribute("href");
					if(getBusinessURL.contains("/enterprise?"))
					{
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getBusinessURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(parentWindow);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
				}
			
			}
			else
			{
				System.out.println("business is not displayed");
				status = "failed";
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status = "failed";
		}
		return status;
	}
	
	public String verifyFaq() throws InterruptedException
	{
		String status = "failed";
		try
		{
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, -200)", "");
			if(driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a")).size()>0)
			{
				System.out.println("Faq is displayed");
				List<WebElement> clickFAQ= driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a"));
				for(int i = 0; i < clickFAQ.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();",  clickFAQ.get(i));
					String getFAQURL = clickFAQ.get(i).getAttribute("href");
					if(getFAQURL.contains("/faq/?"))
					{
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getFAQURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(parentWindow);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
				}
			
			}
			else
			{
				System.out.println("FAQ is not displayed");
				status = "failed";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public String verifyPrivacyPolicy() throws InterruptedException
	{
		String status = "failed";
		try
		{
			System.out.println("privacy page verification");
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, -200)", "");
			if(driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a")).size()>0)
			{
				System.out.println("privacy policy is displayed");
				List<WebElement> clickPrivacy= driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a"));
				for(int i = 0; i < clickPrivacy.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();",  clickPrivacy.get(i));
					String getPrivacyURL = clickPrivacy.get(i).getAttribute("href");
					if(getPrivacyURL.contains("/privacy/?"))
					{
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getPrivacyURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(parentWindow);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
				}
			
			}
			else
			{
				System.out.println("privacy policy is not displayed");
				status = "failed";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public String verifyTermsofService() throws InterruptedException
	{
		
		String status = "failed";
		try
		{
			System.out.println("Terms page verification");
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, -200)", "");
			if(driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a")).size()>0)
			{
				System.out.println("TOS is displayed");
				List<WebElement> clickTOS= driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a"));
				for(int i = 0; i < clickTOS.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();",  clickTOS.get(i));
					String getTOSURL = clickTOS.get(i).getAttribute("href");
					if(getTOSURL.contains("/privacy/?"))
					{
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getTOSURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(parentWindow);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
				}
			
			}
			else
			{
				System.out.println("Terms of service is not displayed");
				status = "failed";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public String verifyBlog() throws InterruptedException
	{
		String status = "failed";
		try
		{
			System.out.println("Blog page verification");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			((JavascriptExecutor) driver)
		     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, -200)", "");
			if(driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a")).size()>0)
			{
				System.out.println("privacy policy is displayed");
				List<WebElement> clickBlog= driver.findElements(By.cssSelector("div[class*='Footer_FootMenu']>ul>li>a"));
				for(int i = 0; i < clickBlog.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();",  clickBlog.get(i));
					String getBlogURL = clickBlog.get(i).getAttribute("href");
					if(getBlogURL.contains("/blog"))
					{
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getBlogURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(parentWindow);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
				}
			
			}
			else
			{
				System.out.println("blog is not displayed");
				status = "failed";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public ArrayList<String> verifyPopularCategories() throws InterruptedException
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			List<WebElement> popularCategories = driver.findElements(By.cssSelector("div[class*='Footer_PopularCategories'] ul>li>a"));
			for(int i = 0; i < popularCategories.size(); i++)
			{
				
				js.executeScript("arguments[0].scrollIntoView();", popularCategories.get(i));
				if(popularCategories.get(i).isDisplayed())
				{
					String categoryURL = popularCategories.get(i).getAttribute("href");
					String CategoryStatusURL=this.checkURLStatus(categoryURL);
                    if(CategoryStatusURL.contains("fail"))
                    {
                        status.add(categoryURL);
                    }
                    else
                    {
                       driver.switchTo().newWindow(WindowType.TAB);
                       driver.get(categoryURL);
                       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
                       driver.close();
                       driver.switchTo().window(parentWindow);
                    }
                }
			}
		}
		catch(StaleElementReferenceException e)
		{
			e.printStackTrace();
			status.add("failed");
		}
		return status;
	}
	
	public String checkURLStatus(String getURL) {
	    String URLStatus = "failed";
	    HttpURLConnection huc = null;
	    int respCode = 200;
	    try {
	    	URI uri = new URI(getURL);
	    	URL url = uri.toURL();
	        huc = (HttpURLConnection) url.openConnection();
	        huc.setRequestMethod("HEAD");
	        huc.connect();
	        respCode = huc.getResponseCode();
	        System.out.println("status code : " + respCode + " " + getURL);
	        if (respCode == 403) {
	            System.out.println("restricted link : " + getURL);
	            URLStatus = "restricted";
	        } else if (respCode == 502) {
	            System.out.println("temporary issue link : " + getURL);
	            URLStatus = "temporary issue";
	        } else if (respCode > 200) {
	            System.out.println("broken link : " + getURL);
	            System.out.println("response code : " + respCode);
	            URLStatus = "fail" + respCode;
	        } else {
	            System.out.println("unbroken link : " + getURL + " " + respCode);
	            URLStatus = "pass";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        URLStatus = "failed";
	    }
	    return URLStatus;
	}
	
	public ArrayList<String> verifyPopularCourses() throws InterruptedException
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
		List<WebElement> popularCourses = driver.findElements(By.cssSelector("div[class*='Footer_PopularCourses'] ul li a"));
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
                   driver.close();
                   driver.switchTo().window(parentWindow);
                }
            }
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();
		status.add("failed");
		}
		return status;
	}
	
	public ArrayList<String> verifyLatestBlogs() throws InterruptedException
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> blogs = driver.findElements(By.cssSelector("div[class*='Footer_LatestBlogsRepT'] a"));
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
                   driver.close();
                   driver.switchTo().window(parentWindow);
                }
            }
		}
		return status;
	}
}
