package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderFeatureLocators 
{
	WebDriver driver;
	int respCode = 200;
	HttpURLConnection huc = null;
	public HeaderFeatureLocators(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public ArrayList<String> checkFooterPart()
	{
		String parentWindow = driver.getWindowHandle();
		ArrayList<String> linkStatus = new ArrayList<String>();
		ArrayList<String> data = new ArrayList<String>();
		data.add("//a[contains(@href,'twitter')]");
		data.add("//a[contains(@href,'facebook')]");
		data.add("//a[contains(@href,'linked')]");
		data.add("//a[contains(@href,'instagram')]");
		data.add("//a[contains(@href,'youtube')]");
		data.add("//a[contains(@href, '/about/?utm') and contains(@href, 'Footer')]");
		data.add("//a[contains(@href, '/enterprise?utm') and contains(@href, 'Footer')]");
		data.add("//a[contains(@href, '/faq/?utm') and contains(@href, 'Footer')]");
		data.add("//a[contains(@href, '/privacy/?utm') and contains(@href, 'Footer')]");
		data.add("//a[contains(@href, '/tos/?utm') and contains(@href, 'Footer')]");
		data.add("//div[contains(@class,'Footer_FootMenu')]//li[1]/a[contains(@href, '/blog')]");
		data.add("//div[contains(@class,'Footer_FootMenu')]//li[2]/a[contains(@href, '/prpage')]");
		data.add("//div[contains(@class,'Footer_FootMenu')]//li[3]/a[contains(@href, '/events')]");
		data.add("//div[contains(@class,'Footer_FootMenu')]//li[4]/a[contains(@href, '/newsletter')]");
		data.add("//div[contains(@class,'Footer_FootMenu')]//li[5]/a[contains(@href, '/placement')]");
		data.add("//div[contains(@class,'Footer_ContActUs_')]/a[contains(@href,'/contact/?')]");

		
		for(int i = 0; i < data.size(); i++)
		{
			String getLocator = data.get(i);
			String getURL ="";
			try
			{
				if(driver.findElements(By.xpath(getLocator)).size()>0)
				{
					WebElement checkTwitter = driver.findElement(By.xpath(getLocator));
					getURL = checkTwitter.getAttribute("href");
					String urlStatus = this.checkURLStatus(getURL);
					if(urlStatus.contains("fail"))
					{
						linkStatus.add("error  in link");
					}
					else
					{
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.close();
						driver.switchTo().window(parentWindow);
					}
				}
				else
				{
					linkStatus.add("link not present : "+getURL);
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				linkStatus.add("fail in footer part");
			}
		}
		
		return linkStatus;
	}
	
	public String checkURLStatus(String data) {
	    String status = "fail";
	    HttpURLConnection huc = null;
	    int respCode = 200;
	    String addHosturl = data;
	    try {
	        huc = (HttpURLConnection) (new URL(addHosturl).openConnection());
	        huc.setRequestMethod("HEAD");
	        huc.connect();
	        respCode = huc.getResponseCode();
	        System.out.println("status code : " + respCode + " " + addHosturl);
	        if (respCode == 403) {
	            System.out.println("restricted link : " + addHosturl);
	            status = "restricted";
	        } else if (respCode == 502) {
	            System.out.println("temporary issue link : " + addHosturl);
	            status = "temporary issue";
	        } else if (respCode > 200) {
	            System.out.println("broken link : " + addHosturl);
	            System.out.println("response code : " + respCode);
	            status = "fail" + respCode;
	        } else {
	            System.out.println("unbroken link : " + " " + addHosturl + " " + respCode);
	            status = "success";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return status;
	}
	
	public ArrayList<String> headerFeatureOnCategory(String data)
	{
		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		try
		{
			String baseWindow = driver.getWindowHandle();
				String url = OpenWebsite.setHost+data;
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);String parentWindow = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for(String window : allWindows)
				{
					driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains(url))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
						{
							
							System.out.println("mega menu section is present");
							
							WebElement openmegaMenu = driver.findElement(By.xpath("//ul[@class='navbar-nav nav ']/li/a"));
							
							wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
							js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
							
							if(openmegaMenu.isDisplayed())
							{
								js.executeScript("arguments[0].click()", openmegaMenu);
								
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
								{
									System.out.println("category present");
								}
								else
								{
									datastatus.add("category not present");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
								{
									System.out.println("partners present");
								}
								else
								{
									datastatus.add("partners not present");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
								{
									System.out.println("popularCourses present");
								}
								else
								{
									datastatus.add("popularCourses not present");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
								{
									System.out.println("services present");
								}
								else
								{
									datastatus.add("services not present");
								}
								js.executeScript("arguments[0].click()", openmegaMenu);
							}
						}
						else
						{
							datastatus.add("megaMenu not present");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in megaMenu ");
					}
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='nav navbar-nav Header_headSearch'] form[id='searchForm']")).size()>0)
						{
							System.out.println("SearchBox drop down is present");
						}
						else
						{
							datastatus.add("SearchBox not present");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in SearchBox ");
					}
					
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a")).size()>0)
						{
							WebElement checkAboutSkillup = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
							String urlAboutSkillup = checkAboutSkillup.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlAboutSkillup);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in About skillup online icon in category page");
							}
							System.out.println("About skillup online icon is present");
						}
						else
						{
							datastatus.add("About skillup online icon not present in category page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in About skillup online icon in category page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a")).size()>0)
						{
						
							WebElement checkContactUs = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
							js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
							String urlContactUs = checkContactUs.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlContactUs);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in contact icon in category page");
							}
							System.out.println("Contact Us icon is present");
						}
						else
						{
								datastatus.add("Contact Us icon not present in category page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Contact Us icon in category page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a")).size()>0)
						{
							WebElement checkBlog = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
							js.executeScript("arguments[0].scrollIntoView();", checkBlog);
							String urlBlog = checkBlog.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlBlog);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in blog in category page");
							}
						}
						else
						{
							datastatus.add("Blog icon not present in category page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Blog icon in category page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a")).size()>0)
						{
							WebElement checkLogin = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkLogin);
							String urlLogin = checkLogin.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlLogin);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in login in category page");
							}
						}
						else
						{
							datastatus.add("Login icon not present in category page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Login icon in category page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a")).size()>0)
						{
						WebElement checkSignUp = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
						js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
						String urlSignUp = checkSignUp.getAttribute("href");
						String urlStatus = this.checkURLStatus(urlSignUp);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in signup in category page");
							}
						}
						else
						{
							datastatus.add("Sign up icon not present in category page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Sign up in category page");
					}
					
					
					driver.close();
					break;
				}
				driver.switchTo().window(parentWindow);
				
			}
				driver.switchTo().window(baseWindow);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			datastatus.add("exception in category page");
		}
		
		return datastatus;
	}
	public ArrayList<String> headerFeatureOncourse(String data)
	{
		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
			try
			{
				String baseWindow = driver.getWindowHandle();
					String url = OpenWebsite.setHost+data;
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(url);
					String parentWindow = driver.getWindowHandle();
					Set<String> allWindows = driver.getWindowHandles();
					for(String window : allWindows)
					{
						driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains(url))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
							{
								
								System.out.println("mega menu section is present");
								
								WebElement openmegaMenu = driver.findElement(By.xpath("//ul[@class='navbar-nav nav ']/li/a"));
								
								wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
								js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
								
								if(openmegaMenu.isDisplayed())
								{
									js.executeScript("arguments[0].click()", openmegaMenu);
									
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
									{
										System.out.println("category present");
									}
									else
									{
										datastatus.add("category not present in course page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
									{
										System.out.println("partners present");
									}
									else
									{
										datastatus.add("partners not present in course page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
									{
										System.out.println("popularCourses present");
									}
									else
									{
										datastatus.add("popularCourses not present in course page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
									{
										System.out.println("services present");
									}
									else
									{
										datastatus.add("services not present in course page");
									}
									js.executeScript("arguments[0].click()", openmegaMenu);
								}
							}
							else
							{
								datastatus.add("megaMenu not present in course page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in megaMenu in course page");
						}
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='nav navbar-nav Header_headSearch'] form[id='searchForm']")).size()>0)
							{
								System.out.println("SearchBox drop down is present");
							}
							else
							{
								datastatus.add("SearchBox not present in course page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in SearchBox in course page");
						}
						
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a")).size()>0)
							{
								WebElement checkAboutSkillup = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a"));
								js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
								String urlAboutSkillup = checkAboutSkillup.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlAboutSkillup);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in About skillup online icon in course page");
								}
								System.out.println("About skillup online icon is present");
							}
							else
							{
								datastatus.add("About skillup online icon not present in course page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in About skillup online icon in course page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a")).size()>0)
							{
							
								WebElement checkContactUs = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a"));
								wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
								js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
								String urlContactUs = checkContactUs.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlContactUs);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in contact icon in course page");
								}
								System.out.println("Contact Us icon is present");
							}
							else
							{
									datastatus.add("Contact Us icon not present in course page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Contact Us icon in course page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a")).size()>0)
							{
								WebElement checkBlog = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a"));
								wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
								js.executeScript("arguments[0].scrollIntoView();", checkBlog);
								String urlBlog = checkBlog.getAttribute("href");
								this.checkURLStatus(urlBlog);
								String urlStatus = this.checkURLStatus(urlBlog);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in blog in course page");
								}
							}
							else
							{
								datastatus.add("Blog icon not present in course page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Blog icon in course page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a")).size()>0)
							{
								WebElement checkLogin = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a"));
								js.executeScript("arguments[0].scrollIntoView();", checkLogin);
								String urlLogin = checkLogin.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlLogin);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in login in course page");
								}
							}
							else
							{
								datastatus.add("Login icon not present in course page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Login icon in course page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a")).size()>0)
							{
							WebElement checkSignUp = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
							js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
							String urlSignUp = checkSignUp.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlSignUp);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in signup in course page");
								}
							}
							else
							{
								datastatus.add("Sign up icon not present in course page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Sign up in course page");
						}
						driver.close();
						break;
					}
					driver.switchTo().window(parentWindow);
				}
					driver.switchTo().window(baseWindow);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				datastatus.add("exception in course page");
			}
			
			datastatus.addAll(this.checkFooterPart());
			return datastatus;
	}
	public ArrayList<String> headerFeatureOnprogram(String data)
	{
		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
			try
			{
				String baseWindow = driver.getWindowHandle();
					String url = OpenWebsite.setHost+data;
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(url);
					String parentWindow = driver.getWindowHandle();
					Set<String> allWindows = driver.getWindowHandles();
					for(String window : allWindows)
					{
						driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains(url))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
							{
								
								System.out.println("mega menu section is present");
								
								WebElement openmegaMenu = driver.findElement(By.xpath("//ul[@class='navbar-nav nav ']/li/a"));
								
								wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
								js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
								
								if(openmegaMenu.isDisplayed())
								{
									js.executeScript("arguments[0].click()", openmegaMenu);
									
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
									{
										System.out.println("category present");
									}
									else
									{
										datastatus.add("category not present in program page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
									{
										System.out.println("partners present");
									}
									else
									{
										datastatus.add("partners not present in program page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
									{
										System.out.println("popularCourses present");
									}
									else
									{
										datastatus.add("popularCourses not present in program page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
									{
										System.out.println("services present");
									}
									else
									{
										datastatus.add("services not present in program page");
									}
									js.executeScript("arguments[0].click()", openmegaMenu);
								}
							}
							else
							{
								datastatus.add("megaMenu not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in megaMenu in program page");
						}
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='nav navbar-nav Header_headSearch'] form[id='searchForm']")).size()>0)
							{
								System.out.println("SearchBox drop down is present");
							}
							else
							{
								datastatus.add("SearchBox not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in SearchBox in program page");
						}
						
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a")).size()>0)
							{
								WebElement checkAboutSkillup = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a"));
								js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
								String urlAboutSkillup = checkAboutSkillup.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlAboutSkillup);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in About skillup online icon in program page");
								}
								System.out.println("About skillup online icon is present");
							}
							else
							{
								datastatus.add("About skillup online icon not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in About skillup online icon in program page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a")).size()>0)
							{
							
								WebElement checkContactUs = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a"));
								wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
								js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
								String urlContactUs = checkContactUs.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlContactUs);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in contact icon in program page");
								}
								System.out.println("Contact Us icon is present");
							}
							else
							{
									datastatus.add("Contact Us icon not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Contact Us icon in program page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a")).size()>0)
							{
								WebElement checkBlog = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a"));
								wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
								js.executeScript("arguments[0].scrollIntoView();", checkBlog);
								String urlBlog = checkBlog.getAttribute("href");
								this.checkURLStatus(urlBlog);
								String urlStatus = this.checkURLStatus(urlBlog);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in blog in program page");
								}
							}
							else
							{
								datastatus.add("Blog icon not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Blog icon in program page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a")).size()>0)
							{
								WebElement checkLogin = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a"));
								js.executeScript("arguments[0].scrollIntoView();", checkLogin);
								String urlLogin = checkLogin.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlLogin);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in login in program page");
								}
							}
							else
							{
								datastatus.add("Login icon not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Login icon in program page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a")).size()>0)
							{
							WebElement checkSignUp = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
							js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
							String urlSignUp = checkSignUp.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlSignUp);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in signup in program page");
								}
							}
							else
							{
								datastatus.add("Sign up icon not present program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Sign up in program page");
						}
						driver.close();
						break;
					}
					driver.switchTo().window(parentWindow);
				}
					driver.switchTo().window(baseWindow);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				datastatus.add("exception in program page");
			}
			datastatus.addAll(this.checkFooterPart());
			return datastatus;
		
			
	}
	public ArrayList<String> headerFeatureOnpartner(String data)
	{
		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
			try
			{
				String baseWindow = driver.getWindowHandle();
					String url = OpenWebsite.setHost+data;
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(url);
					String parentWindow = driver.getWindowHandle();
					Set<String> allWindows = driver.getWindowHandles();
					for(String window : allWindows)
					{
						driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains(url))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
							{
								
								System.out.println("mega menu section is present");
								
								WebElement openmegaMenu = driver.findElement(By.xpath("//ul[@class='navbar-nav nav ']/li/a"));
								
								wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
								js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
								
								if(openmegaMenu.isDisplayed())
								{
									js.executeScript("arguments[0].click()", openmegaMenu);
									
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
									{
										System.out.println("category present");
									}
									else
									{
										datastatus.add("category not present in program page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
									{
										System.out.println("partners present");
									}
									else
									{
										datastatus.add("partners not present in program page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
									{
										System.out.println("popularCourses present");
									}
									else
									{
										datastatus.add("popularCourses not present in program page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
									{
										System.out.println("services present");
									}
									else
									{
										datastatus.add("services not present in program page");
									}
									js.executeScript("arguments[0].click()", openmegaMenu);
								}
							}
							else
							{
								datastatus.add("megaMenu not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in megaMenu in program page");
						}
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='nav navbar-nav Header_headSearch'] form[id='searchForm']")).size()>0)
							{
								System.out.println("SearchBox drop down is present");
							}
							else
							{
								datastatus.add("SearchBox not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in SearchBox in program page");
						}
						
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a")).size()>0)
							{
								WebElement checkAboutSkillup = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a"));
								js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
								String urlAboutSkillup = checkAboutSkillup.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlAboutSkillup);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in About skillup online icon in program page");
								}
								System.out.println("About skillup online icon is present");
							}
							else
							{
								datastatus.add("About skillup online icon not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in About skillup online icon in program page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a")).size()>0)
							{
							
								WebElement checkContactUs = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a"));
								wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
								js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
								String urlContactUs = checkContactUs.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlContactUs);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in ContactUs icon in program page");
								}
								System.out.println("Contact Us icon is present");
							}
							else
							{
									datastatus.add("Contact Us icon not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Contact Us icon in program page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a")).size()>0)
							{
								WebElement checkBlog = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a"));
								wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
								js.executeScript("arguments[0].scrollIntoView();", checkBlog);
								String urlBlog = checkBlog.getAttribute("href");
								this.checkURLStatus(urlBlog);
								String urlStatus = this.checkURLStatus(urlBlog);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in blog in program page");
								}
							}
							else
							{
								datastatus.add("Blog icon not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Blog icon in program page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a")).size()>0)
							{
								WebElement checkLogin = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a"));
								js.executeScript("arguments[0].scrollIntoView();", checkLogin);
								String urlLogin = checkLogin.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlLogin);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in login in program page");
								}
							}
							else
							{
								datastatus.add("Login icon not present in program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Login icon in program page");
						}
						
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a")).size()>0)
							{
							WebElement checkSignUp = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
							js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
							String urlSignUp = checkSignUp.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlSignUp);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in signup in program page");
								}
							}
							else
							{
								datastatus.add("Sign up icon not present program page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Sign up in program page");
						}
						driver.close();
						break;
					}
					driver.switchTo().window(parentWindow);
				}
					driver.switchTo().window(baseWindow);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				datastatus.add("exception in partner page");
			}
			return datastatus;
	}
	
	public ArrayList<String> headerFeatureOnplacement(String data)
	{
		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try
		{
			String baseWindow = driver.getWindowHandle();
				String url = OpenWebsite.setHost+data;
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
				String parentWindow = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for(String window : allWindows)
				{
					driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains(url))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
						{
							
							System.out.println("mega menu section is present");
							
							WebElement openmegaMenu = driver.findElement(By.xpath("//ul[@class='navbar-nav nav ']/li/a"));
							
							wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
							js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
							
							if(openmegaMenu.isDisplayed())
							{
								js.executeScript("arguments[0].click()", openmegaMenu);
								
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
								{
									System.out.println("category present");
								}
								else
								{
									datastatus.add("category not present in program page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
								{
									System.out.println("partners present");
								}
								else
								{
									datastatus.add("partners not present in program page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
								{
									System.out.println("popularCourses present");
								}
								else
								{
									datastatus.add("popularCourses not present in program page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
								{
									System.out.println("services present");
								}
								else
								{
									datastatus.add("services not present in program page");
								}
								js.executeScript("arguments[0].click()", openmegaMenu);
							}
						}
						else
						{
							datastatus.add("megaMenu not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in megaMenu in program page");
					}
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='nav navbar-nav Header_headSearch'] form[id='searchForm']")).size()>0)
						{
							System.out.println("SearchBox drop down is present");
						}
						else
						{
							datastatus.add("SearchBox not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in SearchBox in program page");
					}
					
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a")).size()>0)
						{
							WebElement checkAboutSkillup = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
							String urlAboutSkillup = checkAboutSkillup.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlAboutSkillup);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in About skillup online icon in program page");
							}
							System.out.println("About skillup online icon is present");
						}
						else
						{
							datastatus.add("About skillup online icon not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in About skillup online icon in program page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a")).size()>0)
						{
						
							WebElement checkContactUs = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
							js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
							String urlContactUs = checkContactUs.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlContactUs);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in ContactUs in program page");
							}
							System.out.println("Contact Us icon is present");
						}
						else
						{
								datastatus.add("Contact Us icon not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Contact Us icon in program page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a")).size()>0)
						{
							WebElement checkBlog = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
							js.executeScript("arguments[0].scrollIntoView();", checkBlog);
							String urlBlog = checkBlog.getAttribute("href");
							this.checkURLStatus(urlBlog);
							String urlStatus = this.checkURLStatus(urlBlog);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in blog in program page");
							}
						}
						else
						{
							datastatus.add("Blog icon not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Blog icon in program page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a")).size()>0)
						{
							WebElement checkLogin = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkLogin);
							String urlLogin = checkLogin.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlLogin);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in login in program page");
							}
						}
						else
						{
							datastatus.add("Login icon not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Login icon in program page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a")).size()>0)
						{
						WebElement checkSignUp = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
						js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
						String urlSignUp = checkSignUp.getAttribute("href");
						String urlStatus = this.checkURLStatus(urlSignUp);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in signup in program page");
							}
						}
						else
						{
							datastatus.add("Sign up icon not present program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Sign up in program page");
					}
					driver.close();
					break;
				}
				driver.switchTo().window(parentWindow);
			}
			driver.switchTo().window(baseWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			datastatus.add("exception in placement page");
		}
		datastatus.addAll(this.checkFooterPart());
		return datastatus;
	}
	public ArrayList<String> headerFeatureOnLoginPage(String data)
	{
		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try
		{

				String baseWindow = driver.getWindowHandle();
				String url = OpenWebsite.setHost+data;
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
				String parentWindow = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for(String window : allWindows)
				{
					driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("login"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					
					try
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
						{
							
							System.out.println("mega menu section is present On LoginPage");
							
							WebElement openmegaMenu = driver.findElement(By.xpath("//ul[@class='navbar-nav nav ']/li/a"));
							
							wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
							js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
							
							if(openmegaMenu.isDisplayed())
							{
								js.executeScript("arguments[0].click()", openmegaMenu);
								
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
								{
									System.out.println("category present  On LoginPage");
								}
								else
								{
									datastatus.add("category not present  On LoginPage");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
								{
									System.out.println("partners present");
								}
								else
								{
									datastatus.add("partners not present  On LoginPage");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
								{
									System.out.println("popularCourses present  On LoginPage");
								}
								else
								{
									datastatus.add("popularCourses not present  On LoginPage");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
								{
									System.out.println("services present  On LoginPage");
								}
								else
								{
									datastatus.add("services not present  On LoginPage");
								}
								js.executeScript("arguments[0].click()", openmegaMenu);
							}
						}
						else
						{
							datastatus.add("megaMenu not present  On LoginPage");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in megaMenu  On LoginPage");
					}
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='nav navbar-nav Header_headSearch'] form[id='searchForm']")).size()>0)
						{
							System.out.println("SearchBox drop down is present  On LoginPage");
						}
						else
						{
							datastatus.add("SearchBox not present On LoginPage");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in SearchBox On LoginPage");
					}
					
					
					
					
					try
					{
						if(driver.findElements(By.xpath("//ul[@class='nav navbar-nav MobIlE_MenU']//a[contains(text(),'About SkillUp')]")).size()>0)
						{
							WebElement checkAboutSkillup = driver.findElement(By.xpath("//ul[@class='nav navbar-nav MobIlE_MenU']//a[contains(text(),'About SkillUp')]"));
							js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
							String urlAboutSkillup = checkAboutSkillup.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlAboutSkillup);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in About skillup online icon in program page");
							}
							System.out.println("About skillup online icon is present");
						}
						else
						{
							datastatus.add("About skillup online icon not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in About skillup online icon in program page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.xpath("//ul[@class='nav navbar-nav MobIlE_MenU']//a[contains(text(),'Contact us')]")).size()>0)
						{
						
							WebElement checkContactUs = driver.findElement(By.xpath("//ul[@class='nav navbar-nav MobIlE_MenU']//a[contains(text(),'Contact us')]"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
							js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
							String urlContactUs = checkContactUs.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlContactUs);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in About skillup online icon in program page");
							}
							System.out.println("Contact Us icon is present");
						}
						else
						{
								datastatus.add("Contact Us icon not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Contact Us icon in program page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.xpath("//ul[@class='nav navbar-nav MobIlE_MenU']//a[contains(text(),'Blog')]")).size()>0)
						{
							WebElement checkBlog = driver.findElement(By.xpath("//ul[@class='nav navbar-nav MobIlE_MenU']//a[contains(text(),'Blog')]"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
							js.executeScript("arguments[0].scrollIntoView();", checkBlog);
							String urlBlog = checkBlog.getAttribute("href");
							this.checkURLStatus(urlBlog);
							String urlStatus = this.checkURLStatus(urlBlog);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in blog in program page");
							}
						}
						else
						{
							datastatus.add("Blog icon not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Blog icon in program page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.xpath("//ul[@class='nav navbar-nav LoGInMeNU']//a[contains(text(),'LOGIN')]")).size()>0)
						{
							WebElement checkLogin = driver.findElement(By.xpath("//ul[@class='nav navbar-nav LoGInMeNU']//a[contains(text(),'LOGIN')]"));
							js.executeScript("arguments[0].scrollIntoView();", checkLogin);
							String urlLogin = checkLogin.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlLogin);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in login in program page");
							}
						}
						else
						{
							datastatus.add("Login icon not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Login icon in program page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.xpath("//ul[@class='nav navbar-nav LoGInMeNU']//a[contains(text(),'SIGNUP ')]")).size()>0)
						{
						WebElement checkSignUp = driver.findElement(By.xpath("//ul[@class='nav navbar-nav LoGInMeNU']//a[contains(text(),'SIGNUP ')]"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
						js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
						String urlSignUp = checkSignUp.getAttribute("href");
						String urlStatus = this.checkURLStatus(urlSignUp);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in signup in program page");
							}
						}
						else
						{
							datastatus.add("Sign up icon not present in program page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Sign up in program page");
					}
					driver.close();
					break;
				}
				driver.switchTo().window(parentWindow);
			}
				driver.switchTo().window(baseWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
				datastatus.add("exception in login page");
		}
		datastatus.addAll(this.checkFooterPart());
		return datastatus;
	}
	
	public ArrayList<String> headerFeatureOnSignupPage(String data)
	{
		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try
		{

				String baseWindow = driver.getWindowHandle();
				String url = OpenWebsite.setHost+data;
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
				String parentWindow = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for(String window : allWindows)
				{
					driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains(url))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
						{
							
							System.out.println("mega menu section is present  On SignupPage");
							
							WebElement openmegaMenu = driver.findElement(By.xpath("//ul[@class='navbar-nav nav ']/li/a"));
							
							wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
							js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
							
							if(openmegaMenu.isDisplayed())
							{
								js.executeScript("arguments[0].click()", openmegaMenu);
								
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
								{
									System.out.println("category present On SignupPage");
								}
								else
								{
									datastatus.add("category not present  On SignupPage");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
								{
									System.out.println("partners present  On SignupPage");
								}
								else
								{
									datastatus.add("partners not present  in program page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
								{
									System.out.println("popularCourses present   On SignupPage");
								}
								else
								{
									datastatus.add("popularCourses not present  in program page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
								{
									System.out.println("services present   On SignupPage");
								}
								else
								{
									datastatus.add("services not present    On SignupPage");
								}
								js.executeScript("arguments[0].click()", openmegaMenu);
							}
						}
						else
						{
							datastatus.add("megaMenu not present   On SignupPage");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in megaMenu   On SignupPage");
					}
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='nav navbar-nav Header_headSearch'] form[id='searchForm']")).size()>0)
						{
							System.out.println("SearchBox drop down is present   On SignupPage");
						}
						else
						{
							datastatus.add("SearchBox not present   On SignupPage");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in SearchBox   On SignupPage ");
					}
					
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a")).size()>0)
						{
							WebElement checkAboutSkillup = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
							System.out.println("About skillup online icon is present");
							String urlSignUp = checkAboutSkillup.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlSignUp);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in about icon  On SignupPage");
								}
						}
						else
						{
							datastatus.add("About skillup online icon not present  On SignupPage");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in About skillup online icon  On SignupPage");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a")).size()>0)
						{
						
							WebElement checkContactUs = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
							js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
							String urlSignUp = checkContactUs.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlSignUp);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in contact icon  On SignupPage");
								}
							System.out.println("Contact Us icon is present  On SignupPage");
						}
						else
						{
								datastatus.add("Contact Us icon not present  On SignupPage");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Contact Us icon  On SignupPage");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a")).size()>0)
						{
						WebElement checkBlog = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
						js.executeScript("arguments[0].scrollIntoView();", checkBlog);
						js.executeScript("arguments[0].click()", checkBlog);
							System.out.println("Blog icon is present  On SignupPage");
						}
						else
						{
							datastatus.add("Blog icon not present  On SignupPage");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Blog icon  On SignupPage");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a")).size()>0)
						{
							WebElement checkLogin = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkLogin);
							js.executeScript("arguments[0].click()", checkLogin);
							System.out.println("Login icon is present  On SignupPage");
						}
						else
						{
							datastatus.add("Login icon not present  On SignupPage");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Login icon  On SignupPage");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a")).size()>0)
						{
						WebElement checkSignUp = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
						js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
						String urlSignUp = checkSignUp.getAttribute("href");
						String urlStatus = this.checkURLStatus(urlSignUp);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in contact icon  On SignupPage");
							}
						}
						else
						{
							datastatus.add("Sign up icon not present  On SignupPage");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Sign up ");
					}
					driver.close();
					break;
				}
				driver.switchTo().window(parentWindow);
			}
				driver.switchTo().window(baseWindow);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			datastatus.add("exception in signup page");
		}
		datastatus.addAll(this.checkFooterPart());
		return datastatus;
	}
	
	public ArrayList<String> headerFeatureOnBlog(String data)
	{

		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try
		{

				String baseWindow = driver.getWindowHandle();
				String url = OpenWebsite.setHost+data;
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
				String parentWindow = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for(String window : allWindows)
				{
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains(url))
					{
						driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='navbar-right NAVRiGhT']>ul:nth-child(1)>li>div[class='dropdown']>a")).size()>0)
						{
							
							System.out.println("mega menu section is present On Blog page");
							
							WebElement openmegaMenu = driver.findElement(By.cssSelector("div[class*='navbar-right NAVRiGhT']>ul:nth-child(1)>li>div[class='dropdown']>a"));
							
							wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
							js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
							
							if(openmegaMenu.isDisplayed())
							{
								js.executeScript("arguments[0].click()", openmegaMenu);
								
								if(driver.findElements(By.xpath("//h4[contains(text(),'Categories')]")).size()>0)
								{
									System.out.println("category present On Blog page");
								}
								else
								{
									datastatus.add("category not present On Blog page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
								{
									System.out.println("partners present  On Blog page");
								}
								else
								{
									datastatus.add("partners not present On Blog page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
								{
									System.out.println("popularCourses present  On Blog page");
								}
								else
								{
									datastatus.add("popularCourses not present On Blog page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
								{
									System.out.println("services present On Blog page");
								}
								else
								{
									datastatus.add("services not present On Blog page");
								}
								js.executeScript("arguments[0].click()", openmegaMenu);
							}
						}
						else
						{
							datastatus.add("megaMenu not present On Blog page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in megaMenu On Blog page");
					}
					
					
					try
					{
						if(driver.findElements(By.cssSelector("input[id='search_box']")).size()>0)
						{
							System.out.println("SearchBox drop down is present On Blog page");
						}
						else
						{
							datastatus.add("SearchBox not present On Blog page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in SearchBox On Blog page");
					}
					
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("//ul[@class='nav navbar-nav MobIlE_MenU']/li/a[contains(text(),'About SkillUp online')]")).size()>0)
						{
							WebElement checkAboutSkillup = driver.findElement(By.cssSelector("//ul[@class='nav navbar-nav MobIlE_MenU']/li/a[contains(text(),'About SkillUp online')]"));
							js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
							System.out.println("About skillup online icon is present");
							String urlSignUp = checkAboutSkillup.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlSignUp);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in about skill up icon On Blog page");
								}
						}
						else
						{
							datastatus.add("About skillup online icon not present On Blog page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in About skillup online icon On Blog page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("//ul[@class='nav navbar-nav MobIlE_MenU']/li/a[contains(text(),'Contact us')]")).size()>0)
						{
						
							WebElement checkContactUs = driver.findElement(By.cssSelector("//ul[@class='nav navbar-nav MobIlE_MenU']/li/a[contains(text(),'Contact us')]"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
							js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
							js.executeScript("arguments[0].click()", checkContactUs);
							System.out.println("Contact Us icon is present On Blog page");
						}
						else
						{
								datastatus.add("Contact Us icon not present On Blog page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Contact Us icon On Blog page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("//ul[@class='nav navbar-nav MobIlE_MenU']/li/a[contains(text(),'Blog')]")).size()>0)
						{
						WebElement checkBlog = driver.findElement(By.cssSelector("//ul[@class='nav navbar-nav MobIlE_MenU']/li/a[contains(text(),'Blog')]"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
						js.executeScript("arguments[0].scrollIntoView();", checkBlog);
						String urlSignUp = checkBlog.getAttribute("href");
						String urlStatus = this.checkURLStatus(urlSignUp);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in blog icon On Blog page");
							}
						}
						else
						{
							datastatus.add("Blog icon not present On Blog page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Blog icon On Blog page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("//ul[@class='nav navbar-nav LoGInMeNU']/li/a[contains(text(),'LOGIN')]")).size()>0)
						{
							WebElement checkLogin = driver.findElement(By.cssSelector("//ul[@class='nav navbar-nav LoGInMeNU']/li/a[contains(text(),'LOGIN')]"));
							js.executeScript("arguments[0].scrollIntoView();", checkLogin);
							js.executeScript("arguments[0].click()", checkLogin);
							System.out.println("Login icon is present On Blog page");
						}
						else
						{
							datastatus.add("Login icon not present On Blog page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Login icon On Blog page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("//ul[@class='nav navbar-nav LoGInMeNU']/li/a[contains(text(),'SIGNUP ')]")).size()>0)
						{
						WebElement checkSignUp = driver.findElement(By.cssSelector("//ul[@class='nav navbar-nav LoGInMeNU']/li/a[contains(text(),'SIGNUP ')]"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
						js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
						String urlSignUp = checkSignUp.getAttribute("href");
						String urlStatus = this.checkURLStatus(urlSignUp);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in signup icon On Blog page");
							}
							System.out.println("Sign up icon is present On Blog page");
						}
						else
						{
							datastatus.add("Sign up icon not present On Blog page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Sign up On Blog page");
					}
					driver.close();
					break;
				}
				driver.switchTo().window(parentWindow);
			}
				driver.switchTo().window(baseWindow);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			datastatus.add("exception in signup page On Blog page");
		}
		datastatus.addAll(this.checkFooterPart());
		return datastatus;
	
	}
	
	public ArrayList<String> headerFeatureOnCourseAsProgram(String data)
	{
		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try
		{

				String baseWindow = driver.getWindowHandle();
				String url = OpenWebsite.setHost+data;
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
				String parentWindow = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for(String window : allWindows)
				{
					driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains(url))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
						{
							
							System.out.println("mega menu section is present");
							
							WebElement openmegaMenu = driver.findElement(By.xpath("//ul[@class='navbar-nav nav ']/li/a"));
							
							wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
							js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
							
							if(openmegaMenu.isDisplayed())
							{
								js.executeScript("arguments[0].click()", openmegaMenu);
								
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
								{
									System.out.println("category present");
								}
								else
								{
									datastatus.add("category not present in CourseAsProgram page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
								{
									System.out.println("partners present");
								}
								else
								{
									datastatus.add("partners not present");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
								{
									System.out.println("popularCourses present");
								}
								else
								{
									datastatus.add("popularCourses not present in CourseAsProgram page");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
								{
									System.out.println("services present");
								}
								else
								{
									datastatus.add("services not present");
								}
								js.executeScript("arguments[0].click()", openmegaMenu);
							}
						}
						else
						{
							datastatus.add("megaMenu not present in CourseAsProgram page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in megaMenu in CourseAsProgram page");
					}
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='nav navbar-nav Header_headSearch'] form[id='searchForm']")).size()>0)
						{
							System.out.println("SearchBox drop down is present");
						}
						else
						{
							datastatus.add("SearchBox not present in CourseAsProgram page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in SearchBox in CourseAsProgram page");
					}
					
					
					
					

					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a")).size()>0)
						{
							WebElement checkAboutSkillup = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
							String urlAboutSkillup = checkAboutSkillup.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlAboutSkillup);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in About skillup online icon in CourseAsProgram page");
							}
							System.out.println("About skillup online icon is present");
						}
						else
						{
							datastatus.add("About skillup online icon not present in CourseAsProgram page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in About skillup online iconin CourseAsProgram page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a")).size()>0)
						{
						
							WebElement checkContactUs = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
							js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
							String urlContactUs = checkContactUs.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlContactUs);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in ContactUs icon in CourseAsProgram page");
							}
							System.out.println("Contact Us icon is present");
						}
						else
						{
								datastatus.add("Contact Us icon not present in CourseAsProgram page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Contact Us icon in CourseAsProgram page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a")).size()>0)
						{
							WebElement checkBlog = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
							js.executeScript("arguments[0].scrollIntoView();", checkBlog);
							String urlBlog = checkBlog.getAttribute("href");
							this.checkURLStatus(urlBlog);
							String urlStatus = this.checkURLStatus(urlBlog);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in blog in CourseAsProgram page");
							}
						}
						else
						{
							datastatus.add("Blog icon not present in CourseAsProgram page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Blog icon in CourseAsProgram page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a")).size()>0)
						{
							WebElement checkLogin = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkLogin);
							String urlLogin = checkLogin.getAttribute("href");
							String urlStatus = this.checkURLStatus(urlLogin);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in login in CourseAsProgram page");
							}
						}
						else
						{
							datastatus.add("Login icon not present in CourseAsProgram page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Login icon in CourseAsProgram page");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a")).size()>0)
						{
						WebElement checkSignUp = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
						js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
						String urlSignUp = checkSignUp.getAttribute("href");
						String urlStatus = this.checkURLStatus(urlSignUp);
							if(urlStatus.contains("fail"))
							{
								datastatus.add("error code in signup in CourseAsProgram page");
							}
						}
						else
						{
							datastatus.add("Sign up icon not present in CourseAsProgram page");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Sign up in CourseAsProgram page");
					}
					driver.close();
					break;
				}
				driver.switchTo().window(parentWindow);
			}
			driver.switchTo().window(baseWindow);
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			datastatus.add("exception in signup page in CourseAsProgram page");
		}
		
		datastatus.addAll(this.checkFooterPart());
		return datastatus;
	
	
	}
	public ArrayList<String> headerFeatureOnceLogin(ArrayList<String> data)
	{


		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try
		{

				String baseWindow = driver.getWindowHandle();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				String url = OpenWebsite.setHost+data.get(1);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				driver.switchTo().newWindow(WindowType.TAB);
				
				driver.get(url);
				Set<String> allWindows = driver.getWindowHandles();
				for(String window : allWindows)
				{
					 if (!window.equals(baseWindow))
					 {
			                driver.switchTo().window(window);
			                if (driver.getCurrentUrl().contains("login"))
			                {
					WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
					js.executeScript("arguments[0].scrollIntoView();", userNameElement);
					userNameElement.clear();
					userNameElement.sendKeys(data.get(2));
					WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#password")));
					js.executeScript("arguments[0].scrollIntoView();", passwordElement);
					passwordElement.clear();
					passwordElement.sendKeys(data.get(3));
					js.executeScript("window.scrollBy(0, 100)", "");
					WebElement clickSubmit =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Log In']")));
					js.executeScript("arguments[0].scrollIntoView();", clickSubmit);
					if(clickSubmit.isDisplayed())
					{
						js.executeScript("arguments[0].click()", clickSubmit);
					}
			                }
					if(driver.getCurrentUrl().contains("dashboard"))
                    {
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
							{
								
								System.out.println("mega menu section is present");
								
								WebElement openmegaMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='navbar-nav nav ']/li/a")));
								
								wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
								js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
								
								if(openmegaMenu.isDisplayed())
								{
									js.executeScript("arguments[0].click()", openmegaMenu);
									
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
									{
										System.out.println("category present");
									}
									else
									{
										datastatus.add("category not present in dashboard page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
									{
										System.out.println("partners present");
									}
									else
									{
										datastatus.add("partners not present in dashboard page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
									{
										System.out.println("popularCourses present");
									}
									else
									{
										datastatus.add("popularCourses not present in dashboard page");
									}
									if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
									{
										System.out.println("services present");
									}
									else
									{
										datastatus.add("services not present in dashboard page");
									}
									js.executeScript("arguments[0].click()", openmegaMenu);
								}
							}
							else
							{
								datastatus.add("megaMenu not present in dashboard page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in megaMenu in dashboard page");
						}
						
						
						try
						{
							if(driver.findElements(By.xpath("//div[contains(@class,'Header_headerRight')]/ul[2]//input[@id='contentSearch']")).size()>0)
							{
								System.out.println("SearchBox drop down is present on dashboard page");
							}
							else
							{
								datastatus.add("SearchBox not present in dashboard page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in SearchBox in dashboard page");
						}
						
						try
						{
							if(driver.findElements(By.xpath("//div[contains(@class,'Header_headerRight')]/ul[3]//a[contains(text(),'About SkillUp')]")).size()>0)
							{
								WebElement checkAboutSkillup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Header_headerRight')]/ul[3]//a[contains(text(),'About SkillUp')]")));
								js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
								String urlAboutSkillup = checkAboutSkillup.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlAboutSkillup);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in About skillup online icon in dashboard page");
								}
								System.out.println("About skillup online icon is present");
							}
							else
							{
								datastatus.add("About skillup online icon not present in dashboard page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in About skillup online icon in dashboard page");
						}
						
						
						try
						{
							if(driver.findElements(By.xpath("//div[contains(@class,'Header_headerRight')]/ul[3]//a[contains(text(),'Contact us')]")).size()>0)
							{
							
								WebElement checkContactUs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Header_headerRight')]/ul[3]//a[contains(text(),'Contact us')]")));
								wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
								js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
								String urlContactUs = checkContactUs.getAttribute("href");
								String urlStatus = this.checkURLStatus(urlContactUs);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in About skillup online icon in dashboard page");
								}
								System.out.println("Contact Us icon is present");
							}
							else
							{
									datastatus.add("Contact Us icon not present in dashboard page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Contact Us icon in dashboard page");
						}
						
						
						try
						{
							if(driver.findElements(By.xpath("//div[contains(@class,'Header_headerRight')]/ul[3]//a[contains(text(),'Blog')]")).size()>0)
							{
								WebElement checkBlog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Header_headerRight')]/ul[3]//a[contains(text(),'Blog')]")));
								wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
								js.executeScript("arguments[0].scrollIntoView();", checkBlog);
								String urlBlog = checkBlog.getAttribute("href");
								this.checkURLStatus(urlBlog);
								String urlStatus = this.checkURLStatus(urlBlog);
								if(urlStatus.contains("fail"))
								{
									datastatus.add("error code in blog in dashboard page");
								}
							}
							else
							{
								datastatus.add("Blog icon not present in dashboard page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Blog icon in dashboard page");
						}
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a[data-toggle='dropdown']")).size()>0)
							{
								WebElement checkInitialDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a[data-toggle='dropdown']")));
								js.executeScript("arguments[0].scrollIntoView();", checkInitialDropdown);
							}
							else
							{
								datastatus.add("error  in initial drop down in dashboard page");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in dashboard page");
						}
						
						
						try
						{
							if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a")).size()>0)
							{
								datastatus.add("Sign up icon  present in dashboard page");
							}
							else
							{
								System.out.println("no signu icon on dashboard");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
							datastatus.add("exception in Sign up in dashboard page");
						}
						
						
					driver.close();
                    }
					}
					driver.switchTo().window(baseWindow);
					}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			datastatus.add("exception in dashboard page");
		}
		
		datastatus.addAll(this.checkFooterPart());
		return datastatus;
	
	
	}
	public ArrayList<String> headerFeatureOnceSignup(String data)
	{


		ArrayList<String> datastatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try
		{

			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				String url = OpenWebsite.setHost+data;
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(url);
				if(driver.getCurrentUrl().contains(url))
				{
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class='navbar-nav nav '] a[id='navbarDropdown']")).size()>0)
						{
							
							System.out.println("mega menu section is present");
							
							WebElement openmegaMenu = driver.findElement(By.xpath("//ul[@class='navbar-nav nav ']/li/a"));
							
							wait.until(ExpectedConditions.visibilityOfAllElements(openmegaMenu));
							js.executeScript("arguments[0].scrollIntoView();", openmegaMenu);
							
							if(openmegaMenu.isDisplayed())
							{
								js.executeScript("arguments[0].click()", openmegaMenu);
								
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Categories')]")).size()>0)
								{
									System.out.println("category present");
								}
								else
								{
									datastatus.add("category not present");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Courses by')]")).size()>0)
								{
									System.out.println("partners present");
								}
								else
								{
									datastatus.add("partners not present");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Popular Courses')]")).size()>0)
								{
									System.out.println("popularCourses present");
								}
								else
								{
									datastatus.add("popularCourses not present");
								}
								if(driver.findElements(By.xpath("//ul[@class='navbar-nav nav ']//h2[contains(text(),'Services')]")).size()>0)
								{
									System.out.println("services present");
								}
								else
								{
									datastatus.add("services not present");
								}
								js.executeScript("arguments[0].click()", openmegaMenu);
							}
						}
						else
						{
							datastatus.add("megaMenu not present");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in megaMenu ");
					}
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='nav navbar-nav Header_headSearch'] form[id='searchForm']")).size()>0)
						{
							System.out.println("SearchBox drop down is present");
						}
						else
						{
							datastatus.add("SearchBox not present");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in SearchBox ");
					}
					
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a")).size()>0)
						{
							WebElement checkAboutSkillup = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(1)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkAboutSkillup);
							System.out.println("About skillup online icon is present");
							js.executeScript("arguments[0].click()", checkAboutSkillup);
						}
						else
						{
							datastatus.add("About skillup online icon not present");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in About skillup online icon");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a")).size()>0)
						{
						
							WebElement checkContactUs = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(2)>a"));
							wait.until(ExpectedConditions.visibilityOfAllElements(checkContactUs));
							js.executeScript("arguments[0].scrollIntoView();", checkContactUs);
							js.executeScript("arguments[0].click()", checkContactUs);
							System.out.println("Contact Us icon is present");
						}
						else
						{
								datastatus.add("Contact Us icon not present");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Contact Us icon");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a")).size()>0)
						{
						WebElement checkBlog = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navLinks']>li:nth-child(3)>a"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkBlog));
						js.executeScript("arguments[0].scrollIntoView();", checkBlog);
						js.executeScript("arguments[0].click()", checkBlog);
							System.out.println("Blog icon is present");
						}
						else
						{
							datastatus.add("Blog icon not present");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Blog icon");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a")).size()>0)
						{
							WebElement checkLogin = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(2)>a"));
							js.executeScript("arguments[0].scrollIntoView();", checkLogin);
							js.executeScript("arguments[0].click()", checkLogin);
							System.out.println("Login icon is present");
						}
						else
						{
							datastatus.add("Login icon not present");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Login icon");
					}
					
					
					
					try
					{
						if(driver.findElements(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a")).size()>0)
						{
						WebElement checkSignUp = driver.findElement(By.cssSelector("div[class*='Header_headerRight']>ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li:nth-child(3)>a"));
						wait.until(ExpectedConditions.visibilityOfAllElements(checkSignUp));
						js.executeScript("arguments[0].scrollIntoView();", checkSignUp);
						js.executeScript("arguments[0].click()", checkSignUp);
							System.out.println("Sign up icon is present");
						}
						else
						{
							datastatus.add("Sign up icon not present");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						datastatus.add("exception in Sign up ");
					}
					driver.close();
					driver.switchTo().window(parentWindow);
					break;
				}
				driver.switchTo().window(parentWindow);
			}
			driver.switchTo().window(parentWindow);
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			datastatus.add("exception in signup page");
		}
		
		datastatus.addAll(this.checkFooterPart());
		return datastatus;
	
	
	}
}
