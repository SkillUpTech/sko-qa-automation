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

public class HomepageLocator
{
	WebDriver driver;
	
	public HomepageLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	String baseWindow = "";
	String HomePage = "";
	public ArrayList<String> checkSliderLink() throws InterruptedException
	{
		baseWindow = driver.getWindowHandle();
		String getURL = driver.getCurrentUrl();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(getURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		HomePage = driver.getWindowHandle();
				
		ArrayList<String> statusOfSliderScreen = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String BannerLocator = "div[class*='bannersliderhome_Mainslider'] div[class*='bannersliderhome_bannerContainer']>div[class*='bannersliderhome_bannerSliderHDesktOP'] div[class*='slick-track']>div[class*='slick-slide']  a";
		
		try
		{
				if(driver.findElements(By.cssSelector(BannerLocator)).size()>0)
				{
					List<WebElement> clickSlide = driver.findElements(By.cssSelector(BannerLocator));
					for(int i = 0; i < clickSlide.size(); i++)
					{
						js.executeScript("arguments[0].scrollIntoView();",  clickSlide.get(i));
						if (clickSlide.get(i).isDisplayed())
						{
							String getSlideLink = clickSlide.get(i).getAttribute("href");
							String urlStatus = this.checkURLStatus(getSlideLink);
							if (urlStatus.contains("fail"))
							{
								statusOfSliderScreen.add(getSlideLink + urlStatus);
							}
							else
							{
								System.out.println("Slide link is working fine");
								driver.switchTo().newWindow(WindowType.TAB);
								driver.get(getSlideLink);
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
								driver.close();
								driver.switchTo().window(HomePage);
							}
						}
					}
					
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfSliderScreen.add("exception occured in slider link process");
		}
		
		return statusOfSliderScreen;
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
	
	public ArrayList<String> checkLearningPartners()
	{
		ArrayList<String> verifyPocess = new ArrayList<String>();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String partnerLocator = "div[class='Collaborate_excollaborationInner__0u_r2'] ul li a";
		try
		{
			System.out.println("learning Partners process started");
			List<WebElement> partnerList = driver.findElements(By.cssSelector(partnerLocator));
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
							verifyPocess.add(partnerList.get(i).getText() + checkURL);
						}
						else
						{
							System.out.println("partner link is working fine");
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(partnerURL);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
							driver.close();
							driver.switchTo().window(HomePage);
						}
					}
					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			verifyPocess.add("exception occured in learning partners process");
		}
		
		return verifyPocess;
	}
	
	public ArrayList<String> checkLearningCatalog() throws InterruptedException
	{
		ArrayList<String> verifyPocess = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String learningCatalogLocator = "section[class*='Courses_mainSection']>div>div:nth-child(2) div[class='slick-track']>div[class*='slick-slide'] a";
		
		try
		{
			List<WebElement> learningCatalogCourses = driver.findElements(By.cssSelector(learningCatalogLocator));
			for(int j = 0; j < learningCatalogCourses.size(); j++)
			{
				js.executeScript("arguments[0].scrollIntoView();",  learningCatalogCourses.get(j));
				if(learningCatalogCourses.get(j).isDisplayed())
                {
                    String courseLink = learningCatalogCourses.get(j).getAttribute("href");
                    String urlStatus = this.checkURLStatus(courseLink);
                    if(urlStatus.contains("fail"))
                    {
                        verifyPocess.add(courseLink + urlStatus);
                    }
                    else
                    {
                    	System.out.println("Course link is working fine");
                        driver.switchTo().newWindow(WindowType.TAB);
                        driver.get(courseLink);
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
                        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
                        driver.close();
                        driver.switchTo().window(HomePage);
                    }
                }
			}	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			verifyPocess.add("exception occured in learning catalog process");
		}
		return verifyPocess;
	}
	
	public ArrayList<String> checkHumanSkills()
	{
		System.out.println("human skill process started");
		ArrayList<String> verifyProcess = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String humanSkillsLocator = "div[class*='LearningCatalog_browserCard'] a";
		try
		{
			
			List<WebElement> humanSkillsCourses = driver.findElements(By.cssSelector(humanSkillsLocator));
			for(int i = 0; i < humanSkillsCourses.size(); i++)
			{
				
				js.executeScript("arguments[0].scrollIntoView();",  humanSkillsCourses.get(i));
				if(humanSkillsCourses.get(i).isDisplayed())
				{
					String courseLink = humanSkillsCourses.get(i).getAttribute("href");
					String urlStatus = this.checkURLStatus(courseLink);
					if(urlStatus.contains("fail"))
					{
						verifyProcess.add(courseLink + urlStatus);
					}
					else
                    {
                        System.out.println("Course link is working fine");
                        driver.switchTo().newWindow(WindowType.TAB);
                        driver.get(courseLink);
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
                        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
                        driver.close();
                        driver.switchTo().window(HomePage);
				}
			}
		}
		}
		catch(Exception e)
        {
            e.printStackTrace();
               verifyProcess.add("exception occured in human skills process");
         }
		return verifyProcess;
		}
	
	public ArrayList<String> checkTopTechCategories()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("top tech categories process started");
		ArrayList<String> verifyPocess = new ArrayList<String>();
		String topTechCategoriesLocator = "div[class='TechCategories_exCollaborationInner__nW6ww'] ul li a";
		try
		{
			List<WebElement> topTechCategories = driver.findElements(By.cssSelector(topTechCategoriesLocator));
			for(int i = 0; i < topTechCategories.size(); i++)
			{
				js.executeScript("arguments[0].scrollIntoView();",  topTechCategories.get(i));
				if(topTechCategories.get(i).isDisplayed())
				{
					String getCourseLink = topTechCategories.get(i).getAttribute("href");
					String urlLink = this.checkURLStatus(getCourseLink);
					if(urlLink.contains("fail"))
					{
						verifyPocess.add(getCourseLink+urlLink);
					}
					else
					{
						System.out.println("Course link is working fine");
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getCourseLink);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.close();
						driver.switchTo().window(HomePage);
					}
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			verifyPocess.add("exception occured in top tech categories process");
		}
		return verifyPocess;
	}

	public ArrayList<String> verifyPageTitlePartner()
	{
		ArrayList<String> statusForPageTitle = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String partnerPageWindow = "";
		try
		{
			if(driver.findElements(By.xpath("//div[contains(@class,'Collaborate_excollaborationInner')]/ul/li/a")).size()>0)
			{
				List<WebElement> partnerLocator = driver.findElements(By.xpath("//div[contains(@class,'Collaborate_excollaborationInner')]/ul/li/a"));
				for (WebElement getPartner : partnerLocator) 
				{
					js.executeScript("arguments[0].scrollIntoView();",  getPartner);
					String partnerLink = getPartner.getAttribute("href");
					String partnerLinkStatus = this.checkURLStatus(partnerLink);
					if (partnerLinkStatus.contains("fail"))
					{
						statusForPageTitle.add(partnerLink + " - failed");
					}
					else
					{
						System.out.println("Partner link is working fine");
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(partnerLink);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						
						System.out.println("Partner page title: " + driver.getTitle());
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//div[contains(@class,'FlatCourseCard_FlatcardLinks')]/a")).size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show more')]")).size()>0)
							{
								WebElement clickShowmore = driver.findElement(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//div[contains(@class,'ManageCardsLimit_showMoreSection')]/button"));
								
								js.executeScript("arguments[0].scrollIntoView();",  clickShowmore);
								
								while (clickShowmore.getText().contains("Show more"))
								{
									js.executeScript("arguments[0].click();",  clickShowmore);
								}
							}
							else
							{
								System.out.println("no show more button");
							}
							partnerPageWindow = driver.getWindowHandle();
							List<WebElement> partnerProgram = driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//div[contains(@class,'FlatCourseCard_FlatcardLinks')]/a"));
							for (WebElement program : partnerProgram)
							{
								String programLink = program.getAttribute("href");
								String programStatus = this.checkURLStatus(programLink);
								if (programStatus.contains("fail")) 
								{
									statusForPageTitle.add(programLink + " - failed");
								} 
								else 
								{
									System.out.println("program link is working fine");
									driver.switchTo().newWindow(WindowType.TAB);
									driver.get(programLink);
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
									driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
									if (driver.getTitle().contains("null") || driver.getTitle().contains("undefined"))
									{
										statusForPageTitle.add("program page title is not available : "+programLink);
									} 
									driver.close();
									driver.switchTo().window(partnerPageWindow);
								}
							}
						}
						else
						{
							System.out.println("no program : "+partnerLink);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]/div//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a")).size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//button[contains(text(),'Show more')]")).size()>0)
							{

								WebElement clickShowmore = driver.findElement(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'ManageCardsLimit_showMoreSection')]/button"));
								
								js.executeScript("arguments[0].scrollIntoView();",  clickShowmore);
								
								while (clickShowmore.getText().contains("Show more"))
								{
									js.executeScript("arguments[0].click();",  clickShowmore);
								}
							
							}
							else
							{
								System.out.println("no show more button");
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]/div//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a")).size()>0)
							{
								List<WebElement> coursesFromPartnerPage = driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]/div//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a"));
								for(WebElement getCourse : coursesFromPartnerPage)
								{
									js.executeScript("arguments[0].scrollIntoView();",  getCourse);
									String courseLink = getCourse.getAttribute("href");
									String courseStatus = this.checkURLStatus(courseLink);
									if (courseStatus.contains("fail")) 
									{
										statusForPageTitle.add(courseLink + " - failed");
									} 
									else
									{
										System.out.println("course link is working fine");
										driver.switchTo().newWindow(WindowType.TAB);
										driver.get(courseLink);
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
										driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
										if (driver.getTitle().contains("null") || driver.getTitle().contains("undefined")) 
										{
											statusForPageTitle.add("course page title is not available : " + courseLink);
										} 
										driver.close();
										driver.switchTo().window(partnerPageWindow);
									}
								}
							}
							else
							{
								System.out.println("no course : "+partnerLink);
							}
						}
						else
						{
							System.out.println("no course : "+partnerLink);
						}
						driver.close();
						driver.switchTo().window(HomePage);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return statusForPageTitle;
	}
	
	public ArrayList<String> verifyPageTitleCategories()
	{
		ArrayList<String> statusForPageTitle = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String categoryPageWindow = "";
		try
		{
			if(driver.findElements(By.xpath("//div[contains(@class,'TechCategories_exCollaborationInner')]//ul/li/a")).size()>0)
			{
				List<WebElement> categoryLocator = driver.findElements(By.xpath("//div[contains(@class,'TechCategories_exCollaborationInner')]//ul/li/a"));
				for (WebElement getPartner : categoryLocator) 
				{
					js.executeScript("arguments[0].scrollIntoView();",  getPartner);
					String categoryLink = getPartner.getAttribute("href");
					String partnerLinkStatus = this.checkURLStatus(categoryLink);
					if (partnerLinkStatus.contains("fail"))
					{
						statusForPageTitle.add(categoryLink + " - failed");
					}
					else
					{
						System.out.println("category link is working fine");
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(categoryLink);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						
						System.out.println("Partner page title: " + driver.getTitle());
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//div[contains(@class,'FlatCourseCard_FlatcardLinks')]/a")).size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show more')]")).size()>0)
							{
								WebElement clickShowmore = driver.findElement(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//div[contains(@class,'ManageCardsLimit_showMoreSection')]/button"));
								
								js.executeScript("arguments[0].scrollIntoView();",  clickShowmore);
								
								while (clickShowmore.getText().contains("Show more"))
								{
									js.executeScript("arguments[0].click();",  clickShowmore);
								}
							}
							else
							{
								System.out.println("no show more button");
							}
							categoryPageWindow = driver.getWindowHandle();
							List<WebElement> categoryProgram = driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//div[contains(@class,'FlatCourseCard_FlatcardLinks')]/a"));
							for (WebElement program : categoryProgram)
							{
								String programLink = program.getAttribute("href");
								String programStatus = this.checkURLStatus(programLink);
								if (programStatus.contains("fail")) 
								{
									statusForPageTitle.add(programLink + " - failed");
								} 
								else 
								{
									System.out.println("program link is working fine");
									driver.switchTo().newWindow(WindowType.TAB);
									driver.get(programLink);
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
									driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
									if (driver.getTitle().contains("null") || driver.getTitle().contains("undefined"))
									{
										statusForPageTitle.add("program page title is not available : "+programLink);
									} 
									driver.close();
									driver.switchTo().window(categoryPageWindow);
								}
							}
						}
						else
						{
							System.out.println("no program : "+categoryLink);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]/div//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a")).size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//button[contains(text(),'Show more')]")).size()>0)
							{

								WebElement clickShowmore = driver.findElement(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'ManageCardsLimit_showMoreSection')]/button"));
								
								js.executeScript("arguments[0].scrollIntoView();",  clickShowmore);
								
								while (clickShowmore.getText().contains("Show more"))
								{
									js.executeScript("arguments[0].click();",  clickShowmore);
								}
							
							}
							else
							{
								System.out.println("no show more button");
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							if(driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]/div//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a")).size()>0)
							{
								List<WebElement> coursesFromCategoryPage = driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]/div//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a"));
								for(WebElement getCourse : coursesFromCategoryPage)
								{
									js.executeScript("arguments[0].scrollIntoView();",  getCourse);
									String courseLink = getCourse.getAttribute("href");
									String courseStatus = this.checkURLStatus(courseLink);
									if (courseStatus.contains("fail")) 
									{
										statusForPageTitle.add(courseLink + " - failed");
									} 
									else
									{
										System.out.println("course link is working fine");
										driver.switchTo().newWindow(WindowType.TAB);
										driver.get(courseLink);
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
										driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
										if (driver.getTitle().contains("null") || driver.getTitle().contains("undefined")) 
										{
											statusForPageTitle.add("course page title is not available : " + courseLink);
										} 
										driver.close();
										driver.switchTo().window(categoryPageWindow);
									}
								}
							}
							else
							{
								System.out.println("no course : "+categoryLink);
							}
						}
						else
						{
							System.out.println("no course : "+categoryLink);
						}
						driver.close();
						driver.switchTo().window(HomePage);
					}
				}
			}
			driver.switchTo().window(HomePage);
			driver.close();
			driver.switchTo().window(baseWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return statusForPageTitle;
	}
}
