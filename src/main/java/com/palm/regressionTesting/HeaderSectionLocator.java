package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderSectionLocator
{
	WebDriver driver;
	String parentWindow = "";
	public HeaderSectionLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	public String checkSkillupLogo() throws InterruptedException
	{
		String status = "fail";
		parentWindow = driver.getWindowHandle();
		String skillupLogoLocator = "div[class*='Header_headerLeft'] a img[alt='logo']";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if(driver.findElements(By.cssSelector(skillupLogoLocator)).size()>0)
			{
				WebElement clickLogo = driver.findElement(By.cssSelector(skillupLogoLocator));
				js.executeScript("arguments[0].scrollIntoView();", clickLogo);
				if(clickLogo.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickLogo);
					status = "pass";
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

	public String checkContactUs() throws InterruptedException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		String status = "fail";
		String contactUsLocator = "header[class*='Header_headerBody']>ul[class*='Header_navLinks']>li:nth-child(2)>a[href*='contact']";
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if(driver.findElements(By.cssSelector(contactUsLocator)).size()>0)
			{
				WebElement clickContactUs = driver.findElement(By.cssSelector(contactUsLocator));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				js.executeScript("arguments[0].scrollIntoView();", clickContactUs);
				String contactUsURL = clickContactUs.getAttribute("href");
				if(clickContactUs.isDisplayed())
				{
					wait.until(ExpectedConditions.elementToBeClickable(clickContactUs));
					String checkURLStatus = this.checkURLStatus(contactUsURL);
					if(checkURLStatus.contains("fail"))
					{
						status = "fail";
                    }
                    else
                    {
                       driver.switchTo().newWindow(WindowType.TAB);
                       driver.get(contactUsURL);
                       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
                       status = "pass";
                       driver.close();
                       driver.switchTo().window(parentWindow);
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

	public String checkBusiness() 
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String businessLocator = "div[class*='Header_headerRight'] ul[class*='Header_navLinks'] li:nth-child(1) a";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if(driver.findElements(By.cssSelector(businessLocator)).size()>0)
            {
                System.out.println("business validation started");
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                WebElement clickBusiness = driver.findElement(By.cssSelector(businessLocator));
                js.executeScript("arguments[0].scrollIntoView();", clickBusiness);
                String getBusinessURL = clickBusiness.getAttribute("href");
                if (clickBusiness.isDisplayed()) 
                {
                	wait.until(ExpectedConditions.elementToBeClickable(clickBusiness));
                	String statusOfBusiness = this.checkURLStatus(getBusinessURL);
                	if(statusOfBusiness.contains("fail"))
                	{
                		status = "fail";
                	}
                	else
                	{
                		driver.switchTo().newWindow(WindowType.TAB);
                		driver.get(getBusinessURL);
                		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
                		status = "pass";
                		driver.close();
                		driver.switchTo().window(parentWindow);
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

	public String checkBlog() throws InterruptedException 
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		String blogLocator = "div[class*='Header_headerRight'] ul[class*='Header_navLinks'] li:nth-child(3) a";
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if (driver.findElements(By.cssSelector(blogLocator)).size() > 0)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				WebElement clickBlog = driver.findElement(By.cssSelector(blogLocator));
				js.executeScript("arguments[0].scrollIntoView();", clickBlog);
				if (clickBlog.isDisplayed())
				{
					wait.until(ExpectedConditions.elementToBeClickable(clickBlog));
					String getBlogURL = clickBlog.getAttribute("href");
					String checkURLStatus = this.checkURLStatus(getBlogURL);
					if (checkURLStatus.contains("fail"))
					{
						status = "fail";
					} 
					else
					{
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getBlogURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
						status = "pass";
						driver.close();
						driver.switchTo().window(parentWindow);
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

	public ArrayList<String> checkCategories()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("categories validation started");
		String megaMenuDropdownLocator = "ul[class*='navbar-nav nav '] a#navbarDropdown";
		String categoryLocator = "ul[class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show'] div[class='MainCatE catcolumn divbox1']>ul[class='categorylist customscroll dropdown-submenu']>li a";
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			WebElement  clickCourseDropdown = driver.findElement(By.cssSelector(megaMenuDropdownLocator));
			js.executeScript("arguments[0].scrollIntoView();", clickCourseDropdown);
			if(clickCourseDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickCourseDropdown);
				List<WebElement> selectCourse = driver.findElements(By.cssSelector(categoryLocator));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				for(int i = 0; i <selectCourse.size(); i++)
				{	
					js.executeScript("arguments[0].scrollIntoView();", selectCourse.get(i));
					String getCatagoriesURL = selectCourse.get(i).getAttribute("href");
					if(selectCourse.get(i).isDisplayed())
					{
						String urlLinkStatus = this.checkURLStatus(getCatagoriesURL);
						if(urlLinkStatus.contains("fail"))
						{
							status.add(selectCourse.get(i).getText());
                        }
                        else
                        {
                        	driver.switchTo().newWindow(WindowType.TAB);
                        	driver.get(getCatagoriesURL);
                        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                        	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
                        	driver.close();
                        	driver.switchTo().window(parentWindow);
                        }
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					}
				}
			}
			js.executeScript("arguments[0].scrollIntoView();", clickCourseDropdown);
			js.executeScript("arguments[0].click()", clickCourseDropdown);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}

	public ArrayList<String> checkPopularCourses()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String megaMenuDropdownLocator = "ul[class*='navbar-nav nav '] a#navbarDropdown";
		String popularCourseLocator = "ul[class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show'] div[class='PolularCourSE catcolumn divbox3'] ul[class='MegaMenu_PopularCourse'] li a";
		try
		{
			WebElement clickDropdown = driver.findElement(By.cssSelector(megaMenuDropdownLocator));
			js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickDropdown);
				
				List<WebElement> popularCourses = driver.findElements(By.cssSelector(popularCourseLocator));
				
				for (int i = 0; i < popularCourses.size(); i++) 
				{
					String popularCourseName = popularCourses.get(i).getText();
					
					String getPopularCourseURL = popularCourses.get(i).getAttribute("href");
					
					String urlLinkStatus = this.checkURLStatus(getPopularCourseURL);
					if (urlLinkStatus.equalsIgnoreCase("fail"))
					{
						status.add(popularCourseName);
					} 
					else
					{
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getPopularCourseURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
						driver.close();
						driver.switchTo().window(parentWindow);
					}
				}
			}
			js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
			js.executeScript("arguments[0].click()", clickDropdown);
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		
		return status;
	}

	public String checkLogin()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "fail";
		String loginLocator = "div[class*='Header_headerRight'] ul[class*='Header_navButtons'] li[class*='Header_loginBtn'] a";
		
		try
		{
			if (driver.findElements(By.cssSelector(loginLocator)).size() > 0)
			{
				WebElement clickLogin = driver.findElement(By.cssSelector(loginLocator));
				js.executeScript("arguments[0].scrollIntoView();", clickLogin);
				String getLoginURL = clickLogin.getAttribute("href");
				if (clickLogin.isDisplayed()) 
				{
					String checkURLStatus = this.checkURLStatus(getLoginURL);
					if (checkURLStatus.contains("fail")) 
					{
						status = "fail";
					} 
					else
					{
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getLoginURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						status = "pass";
						driver.close();
						driver.switchTo().window(parentWindow);
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

	public String checkSignUP() throws InterruptedException
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String signUpLocator = "div[class*='Header_headerRight'] ul[class*='Header_navButtons'] li[class*='Header_signupBtn'] a";
		try
		{
			if (driver.findElements(By.cssSelector(signUpLocator)).size() > 0)
			{
				WebElement clickSignUp = driver.findElement(By.cssSelector(signUpLocator));
				js.executeScript("arguments[0].scrollIntoView();", clickSignUp);
				String getSignUpURL = clickSignUp.getAttribute("href");
				
				if (clickSignUp.isDisplayed()) 
				{
					String checkURLStatus = this.checkURLStatus(getSignUpURL);
					if (checkURLStatus.contains("fail"))
					{
						status = "fail";
					} 
					else
					{
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getSignUpURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
						status = "pass";
						driver.close();
						driver.switchTo().window(parentWindow);
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
	
	public String checkURLStatus(String getURL)
	{
		String urlStatus = "fail";
		String addHosturl = getURL;
		HttpURLConnection huc = null;
		int respCode = 200;
		try
		{
			huc = (HttpURLConnection)(new URL(addHosturl).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			System.out.println("status code : "+respCode + " " +addHosturl);
			if(respCode > 200)
			{
				System.out.println("broken link"+addHosturl);
				urlStatus = "fail";
			}
			else
			{
				System.out.println("un broken link"+addHosturl);
				urlStatus = "pass";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			urlStatus = "fail";
		}
		return urlStatus;
	}
	public ArrayList<String> verifyLearningPartner()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String megaMenuDropdownLocator = "ul[class*='navbar-nav nav '] a#navbarDropdown";
		String learningPartnerLocator = "ul[class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show'] div[class='LearningPartners catcolumn divbox2'] li a";
		try
		{
			System.out.println("learning partner validation started");
			WebElement clickDropdown = driver.findElement(By.cssSelector(megaMenuDropdownLocator));
			js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
			if(clickDropdown.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickDropdown);
				
				List<WebElement> learningPartners = driver.findElements(By.cssSelector(learningPartnerLocator));
				
				for (int i = 0; i < learningPartners.size(); i++) 
				{
					js.executeScript("arguments[0].scrollIntoView();", learningPartners.get(i));
					
					if(learningPartners.get(i).isDisplayed())
					{
						String getLearningPartnerURL = learningPartners.get(i).getAttribute("href");

						String urlLinkStatus = this.checkURLStatus(getLearningPartnerURL);
						
						if (urlLinkStatus.equalsIgnoreCase("fail"))
						{
							status.add(getLearningPartnerURL);
						} 
						else 
						{
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(getLearningPartnerURL);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
							driver.close();
							driver.switchTo().window(parentWindow);
						}
					}
				}
			}
			js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
			js.executeScript("arguments[0].click()", clickDropdown);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	
}
