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
	String parentWindow="";
	String footerValidationPage = "";
	public FooterSectionLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	public String verifySkillupLogo() throws InterruptedException
	{
		parentWindow = driver.getWindowHandle();
		String getURL = driver.getCurrentUrl();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(getURL);
		footerValidationPage = driver.getWindowHandle();
		String status = "fail";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(100);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(100);
			js.executeScript("window.scrollBy(0, 5000);");
			if(driver.findElements(By.cssSelector("div[class*='Footer_footertopmenu'] a[class*='Footer_FTLogo']")).size()>0)
			{
				System.out.println("logo is displayed");
				WebElement clickLogo = driver.findElement(By.cssSelector("div[class*='Footer_footertopmenu'] a[class*='Footer_FTLogo']"));
				js.executeScript("arguments[0].scrollIntoView();", clickLogo);
				wait.until(ExpectedConditions.elementToBeClickable(clickLogo));
				if(clickLogo.isDisplayed())
				{
					String href = clickLogo.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(href);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					status = "pass";
					driver.close();
					driver.switchTo().window(footerValidationPage);
				}
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
		String status = "fail";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(1) a")).size()>0)
			{
				WebElement clickTwitter = driver.findElement(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(1) a"));
				js.executeScript("arguments[0].scrollIntoView();", clickTwitter);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
				if(clickTwitter.isDisplayed())
                {
					System.out.println("twitter is displayed");
					wait.until(ExpectedConditions.elementToBeClickable(clickTwitter));
					String twitterURL = clickTwitter.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(twitterURL);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					status = "success";
					driver.close();
					driver.switchTo().window(footerValidationPage);
                }
	        }
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	}
	
	public String verifyInstagram() throws InterruptedException
	{
		String status = "fail";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		try
		{
			if (driver.findElements(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(4) a")).size() > 0)
			{
				System.out.println("instagram is displayed");
				WebElement clickInstagram = driver.findElement(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(4) a"));
				js.executeScript("arguments[0].scrollIntoView();", clickInstagram);
				if(clickInstagram.isDisplayed())
				{
					
					wait.until(ExpectedConditions.elementToBeClickable(clickInstagram));
					String instaURL = clickInstagram.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(instaURL);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.close();
					driver.switchTo().window(footerValidationPage);
					status = "success";
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				}
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "fail";
		}
		
		
		
		return status;
	}
	
	public String verifyFacebook() throws InterruptedException
	{
		String status = "failed";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		try
		{
			if(driver.findElements(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(2) a")).size()>0)
			{
				System.out.println("facebook is displayed");
				WebElement clickFacebook = driver.findElement(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(2) a"));
				js.executeScript("arguments[0].scrollIntoView();", clickFacebook);
				if(clickFacebook.isDisplayed())
				{
					System.out.println("facebook is displayed");
					wait.until(ExpectedConditions.elementToBeClickable(clickFacebook));
					String fbURL = clickFacebook.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(fbURL);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					status = "success";
					driver.close();
					driver.switchTo().window(footerValidationPage);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
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
	
	public String verifyLinkedIn() throws InterruptedException
	{
		String status = "failed";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		try
		{
			if(driver.findElements(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(3) a")).size()>0)
			{
				WebElement clickLinkedIn = driver.findElement(By.cssSelector("ul[class*=' Footer_socialIconsSection'] li:nth-child(3) a"));
				js.executeScript("arguments[0].scrollIntoView();", clickLinkedIn);
				if(clickLinkedIn.isDisplayed())
				{
					System.out.println("linkedin is displayed");
					
					wait.until(ExpectedConditions.elementToBeClickable(clickLinkedIn));
					String linkedInURL = clickLinkedIn.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(linkedInURL);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.close();
					driver.switchTo().window(footerValidationPage);
					status = "success";
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				}
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	}
	
	public String verifyContactUs() throws InterruptedException
	{
		String status = "failed";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		try
		{
			if(driver.findElements(By.cssSelector("div[class*='Footer_ContActUs']>a")).size()>0)
			{
				System.out.println("contact us is displayed");
				WebElement clickContactUs = driver.findElement(By.cssSelector("div[class*='Footer_ContActUs']>a"));
				js.executeScript("arguments[0].scrollIntoView();", clickContactUs);
				if(clickContactUs.isDisplayed())
				{
					System.out.println("contact us is displayed");
					wait.until(ExpectedConditions.elementToBeClickable(clickContactUs));
					String contactUsURL = clickContactUs.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(contactUsURL);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.close();
					driver.switchTo().window(footerValidationPage);
					status = "success";
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String verifyAboutSkillupOnline() throws InterruptedException
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getAboutSkillupURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.close();
						driver.switchTo().window(footerValidationPage);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
				}
			
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	}
	
	public String verifyBusiness() throws InterruptedException
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getBusinessURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.close();
						driver.switchTo().window(footerValidationPage);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
				}
			
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String verifyFaq() throws InterruptedException
	{
		String status = "fail";
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
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getFAQURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(footerValidationPage);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
				}
			
			}
			else
			{
				System.out.println("FAQ is not displayed");
				status = "fail";
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
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			System.out.println("privacy page verification");
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
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getPrivacyURL);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(footerValidationPage);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
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
	
	public String verifyTermsofService() throws InterruptedException
	{
		
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			System.out.println("Terms page verification");
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
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getTOSURL);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(footerValidationPage);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
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
	
	public String verifyBlog() throws InterruptedException
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			System.out.println("Blog page verification");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
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
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getBlogURL);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(footerValidationPage);
						status = "success";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						break;
					}
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
	
	public ArrayList<String> verifyPopularCategories() throws InterruptedException
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if(driver.findElements(By.cssSelector("div[class*='Footer_PopularCategories'] ul>li>a")).size()>0)
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
							if(driver.getTitle().contains("null")||driver.getTitle().contains("undefined"))
							{
								status.add("title not found");
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
							} 
						}
						driver.close();
						driver.switchTo().window(footerValidationPage);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					}
				}
			}
			else
			{
				status.add("popular categories not displayed on footer section");
			}
		}
		catch(StaleElementReferenceException e)
		{
			e.printStackTrace();
			status.add("exception");
		}
		return status;
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
	
	public ArrayList<String> verifyPopularCourses() throws InterruptedException
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.cssSelector("div[class*='Footer_PopularCourses'] ul li a")).size()>0)
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
							if(driver.getTitle().contains("null")||driver.getTitle().contains("undefined"))
							{
								status.add("title not found" + popularCoursesURL);
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
							} 
						}
						driver.close();
						driver.switchTo().window(footerValidationPage);
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
		status.add("exception");
		}
		return status;
	}
	
	public ArrayList<String> verifyLatestBlogs() throws InterruptedException
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
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
	    				if(driver.getTitle().contains("null")||driver.getTitle().contains("undefined"))
	    				{
	    					status.add("title not found");
	    					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    				} 
	    			}	
	                driver.close();
	                driver.switchTo().window(footerValidationPage);
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	            }
			}
			driver.switchTo().window(footerValidationPage);
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			status.add("exception");
		}
		
		
		return status;
	}
}
