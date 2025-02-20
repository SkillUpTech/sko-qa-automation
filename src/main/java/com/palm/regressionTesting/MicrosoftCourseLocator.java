package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicrosoftCourseLocator 
{
	WebDriver driver;
	int respCode = 200;
	HttpURLConnection huc = null;
	String parentWindow = "";
	String microsoftPage = "";
	
	@FindBy(xpath = "//div[contains(@class,'Collaborate_excollaborationInner')]/ul/li/a")
	private List<WebElement> locatePartnerName;
	
	@FindBy(css = "div[class='TechCategories_exCollaborationInner__nW6ww'] ul li a")
	private List<WebElement> topTechCategoriesLocator;
	
	@FindBy(xpath =  "//div[contains(@class,'ManageCardsLimit_showMoreSection')]/button")
	private List<WebElement> CourseCardShowmoreLocator;
	
	@FindBy(xpath = "//div[contains(@class,'LearningCatalog_cardRow')]//div[contains(@class,'LearningCatalog_customCard')]")
	private List<WebElement> CourseCards;	
	
	public MicrosoftCourseLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ArrayList<String> verifyMicrosftPage()
	{
		ArrayList<String> processStatus = new ArrayList<String>();
		try
		{
			parentWindow = driver.getWindowHandle();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			String url = driver.getCurrentUrl()+"microsoft-courses-and-programs/?utm_source=websiteinternal&utm_medium=megamenu&utm_campaign=NA";
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			microsoftPage = driver.getWindowHandle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			processStatus.add("fail");
		}
		return processStatus;
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
		            if (responseCode >= 400 && responseCode <= 405 || responseCode == 410 ||responseCode == 302 || responseCode == 429 || responseCode >=500 && responseCode <= 505) 
		            {
		                System.out.println("Broken link: " + data);
		                status = "fail: " + responseCode + " url : " + data;
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
	
	public ArrayList<String> verifyMicrosoftScourses()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		
		String cardLocator = "//div[contains(@class,'LearningCatalog_cardRow')]//div[contains(@class,'LearningCatalog_customCard')]";
		String cardPartner = ".//div[contains(@class,'RegularCourseCard_courseCompany')]";
		String cardURL = ".//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a";
		String cardCourseLabel = ".//div[contains(@class,'RegularCourseCard_courseType')]//p[contains(text(),'Course')]";
		String cardHeading =".//div[contains(@class,'RegularCourseCard_courseHeading')]/p";
		String cardLevel1 = ".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul/li[1]";
		String cardLevel2 = ".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul/li[2]";
		String cardLevel3 =".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul/li[3]";
		String enrollPriceSection = ".//div[contains(@class,'RegularCourseCard_priceSection')]";
		String cardprice = ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2/following-sibling::p";
		String EnrollStatus = ".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2";
		
		String pageBaseLocator = "//section[contains(@class,'CourseDescription_mainSection')]";
		String pageHeading =".//div[contains(@class,'CourseDescription_courseText')]/h1";
		String pageLevelSection = ".//div[contains(@class,'CourseDescription_levelSection')]";
		String pageLevel1 = ".//div[contains(@class,'CourseDescription_levelSection')]/h2";
		String pageLevel2  = ".//div[contains(@class,'CourseDescription_levelSection')]/h3[1]";
		String pageLevel3 = ".//div[contains(@class,'CourseDescription_levelSection')]/h3[2]";
		String pageEnrollPriceSection = ".//div[contains(@class,'CourseDescription_buttonsContent')]";
		String pageIsSelfpacedOrVilt = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//div[contains(@class,'CourseDescription_courseAboutTextSection')]/h2";
		String pageEnrollStatus = ".//button[contains(@class,'CourseDescription_enrollNowBtn')] | //div[contains(@class,'CourseDescription_buttonsContent')]/h6|//div[contains(@class,'CourseDescription_buttonsContent')]/a/button[1]";
		String pagePrice = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]//div[contains(@class,'CourseDescription_courseAboutTextSection')]/h2[contains(text(),'Fee')]/following-sibling::p";
		String pagePartner = ".//img[@alt='org-logo']";
		String courseCardName = ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p";
		
			
		
			ArrayList<String> status = new ArrayList<String>();
			ArrayList<String> cardLevelStatus = new ArrayList<String>();
			ArrayList<String> cardPriceStatus = new ArrayList<String>();
			ArrayList<String> cardEnrollmentStatus = new ArrayList<String>();
			ArrayList<String> pageLevelStatus = new ArrayList<String>();
			ArrayList<String> pagePriceStatus = new ArrayList<String>();
			ArrayList<String> pageEnrollmentStatus = new ArrayList<String>();
			
			try
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if (CourseCardShowmoreLocator.size() > 0)
				{ // Check if the "Show More" button is present
				    List<WebElement> showMore = CourseCardShowmoreLocator;

				    while (showMore.size() > 0) {
				        WebElement showMoreButton = showMore.get(0); // Always interact with the first "Show More" button

				        // Scroll into view of the "Show More" button
				        js.executeScript("arguments[0].scrollIntoView();", showMoreButton);

				        // Check if the button contains "more" and click if true
				        if (showMoreButton.getText().contains("more"))
				        {
				            js.executeScript("arguments[0].click();", showMoreButton);

				            // Refresh the list of "Show More" buttons after the click
				            showMore = CourseCardShowmoreLocator;
				        } 
				        else 
				        {
				            break; // Exit the loop if the button does not contain "more"
				        }
				    }
				}
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				if(CourseCards.size()>0)
				{
					List<WebElement> courseCard = CourseCards;
					
					for(WebElement card : courseCard)
					{
						js.executeScript("arguments[0].scrollIntoView();", card);
						
						String courseCardNames = card.findElement(By.xpath(courseCardName)).getText();
						
						if(courseCardNames.contains("MS-600: Building Applications and Solutions with Microsoft 365 Core Services")||courseCardNames.contains("AZ-900: Microsoft Azure Fundamentals - Weekend Batch")||courseCardNames.contains("AZ-900: Microsoft Azure Fundamentals")
								|| courseCardNames.contains("MB-300: Microsoft Dynamics 365: Core Finance and Operations"))
							continue;
						
						String getCourseCardURL = card.findElement(By.xpath(cardURL)).getAttribute("href");
						
						if(getCourseCardURL.contains("/courses/?id=course-v1:SkillUp+SKOAZ900ILT+2022_Q4"))
							continue;
						String courseCardImage = ".//img[@alt='"+courseCardNames+"']";
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if(card.findElements(By.xpath(courseCardImage)).size()<=0)
						{
							status.add("image not present in " +courseCardNames);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if(card.findElements(By.xpath(cardPartner)).size()<=0)
						{
							status.add("partner name not present in "+courseCardNames);
						}
						
						
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if(card.findElements(By.xpath(cardCourseLabel)).size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (card.findElements(By.xpath(cardLevel1)).size() > 0)
							{
								String CourseCardLevel1 = card.findElement(By.xpath(cardLevel1)).getText();
								cardLevelStatus.add(CourseCardLevel1);
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (card.findElements(By.xpath(cardLevel2)).size() > 0)
							{
								String CourseCardardLevel2 = card.findElement(By.xpath(cardLevel2)).getText();
								cardLevelStatus.add(CourseCardardLevel2);
							}
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (card.findElements(By.xpath(cardLevel3)).size() > 0)
							{
								String CourseCardLevel3 = card.findElement(By.xpath(cardLevel3)).getText();
								cardLevelStatus.add(CourseCardLevel3);
							}
						}
						else
						{
							status.add("level section not present in "+courseCardNames);
						}
						
						
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (card.findElements(By.xpath(cardprice)).size() <= 0)
						{
							cardPriceStatus.add("price not present in " +courseCardNames);
						}
						else
						{
							String cardPrice = card.findElement(By.xpath(cardprice)).getText();
							 String priceString = cardPrice;
							  String getPrice[] = priceString.split(" ");
							  String priceOfCourseCard = "";
							  if(getPrice.length>1)
							  {
								  priceOfCourseCard = getPrice[1].replaceAll("[^0-9]", "");
							  }
							  else
							  {
								  priceOfCourseCard =  getPrice[0].replaceAll("[^0-9]", "");
							  }
							  System.out.println("price on card : "+priceOfCourseCard);
	                        cardPriceStatus.add(priceOfCourseCard);
	                    }
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						if(card.findElements(By.xpath(enrollPriceSection)).size() > 0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (card.findElements(By.xpath(EnrollStatus)).size() > 0)
							{
								String cardEnrollStatus = card.findElement(By.xpath(EnrollStatus)).getText();
								if(cardEnrollStatus.contains("Open"))
								{
									cardEnrollmentStatus.add("Open");
								}
								else if(cardEnrollStatus.contains("not reached"))
								{
									cardEnrollmentStatus.add("Closed");
								}
								else if(cardEnrollStatus.contains("Coming soon"))
								{
									cardEnrollmentStatus.add("Closed");
								}
								else
								{
									cardEnrollmentStatus.add("Closed");
								}
							}
							/*
							 * else if(card.findElements(By.xpath(courseCardCourseStartedDate)).size() > 0)
							 * { String cardEnrollStartDateStatus =
							 * card.findElement(By.xpath(programCardCourseStartedDate)).getText();
							 * 
							 * if(cardEnrollStartDateStatus.contains("Course starts on")) {
							 * cardEnrollmentStatus.add("Open"); } else {
							 * cardEnrollmentStatus.add("Closed"); } }
							 */
						}
						else
						{
							cardEnrollmentStatus.add("enrollment section not present in " +courseCardNames);
						}
						
						//********************************************************************************************
						
						String checkURLStatus = checkURLStatus(getCourseCardURL);
						if(!checkURLStatus.contains("fail"))
						{
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(getCourseCardURL);
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if(driver.getTitle().contains("null")|| driver.getTitle().contains("undefined")||driver.getCurrentUrl().contains("/microsoft-courses-and-programs/"))
							{
								status.add("null or undefined or issue  is present on page   " + courseCardNames);
							}
						else
						{
							WebElement CoursePageSection = driver.findElement(By.xpath(pageBaseLocator));
							js.executeScript("arguments[0].scrollIntoView();", CoursePageSection);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (CoursePageSection.findElements(By.xpath(pageHeading)).size() <= 0)
							{
								status.add("program name not present in this card page  " + courseCardNames);
							}
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							if (CoursePageSection.findElements(By.xpath(pageLevel1)).size() > 0)
							{
								String level1 = CoursePageSection.findElement(By.xpath(pageLevel1)).getText();
								pageLevelStatus.add(level1);
							}
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (CoursePageSection.findElements(By.xpath(pageLevel2)).size() > 0) 
							{
								String level2 = CoursePageSection.findElement(By.xpath(pageLevel2)).getText();
								pageLevelStatus.add(level2);
							}
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (CoursePageSection.findElements(By.xpath(pageLevel3)).size() > 0) 
							{
								String level3 = CoursePageSection.findElement(By.xpath(pageLevel3)).getText();
								pageLevelStatus.add(level3);
							}
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (CoursePageSection.findElements(By.xpath(pagePartner)).size() <= 0)
							{
								status.add("partner name not present in this card page  " + courseCardNames);
							}
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (CoursePageSection.findElements(By.xpath(pageEnrollPriceSection)).size() <= 0) 
							{
								status.add("enroll status not present in this card page  " + courseCardNames);
							}
							else
							{
								List<WebElement> enrollButton = CoursePageSection.findElements(By.xpath(pageEnrollStatus));
								String getPageEnrollStatus = enrollButton.get(0).getText();
								if(getPageEnrollStatus.contains("Enroll Now"))
								{
									pageEnrollmentStatus.add("Open");
								}
								else if(getPageEnrollStatus.contains("Enrollment is Closed"))
								{
									pageEnrollmentStatus.add("Closed");
								}
								else if(getPageEnrollStatus.contains("Enroll now"))
								{
									pageEnrollmentStatus.add("Closed");
								}
								else
								{
									pageEnrollmentStatus.add("Closed");
								}
							}
							
							if (cardEnrollmentStatus.size() == pageEnrollmentStatus.size())
							{
								if(!cardEnrollmentStatus.get(0).toLowerCase().equals(pageEnrollmentStatus.get(0).toLowerCase()))
								{
									status.add("enrollment status are not matching in card page and program page  "
											+ courseCardNames);
								} 
								
							}
							else 
							{
								status.add("enrollment status are not available in card page and program page  "
										+ courseCardNames);
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (CoursePageSection.findElements(By.xpath(pageLevelSection)).size() <= 0) 
							{
								status.add("duration fee section not present in this card page  " + courseCardNames);
							}
							else
							{
								if(cardLevelStatus.size() == pageLevelStatus.size())
								{
									if ((cardLevelStatus.get(0).toLowerCase()).equals(pageLevelStatus.get(0).toLowerCase()))
									{
										String getDurationText = CoursePageSection.findElement(By.xpath(pageIsSelfpacedOrVilt)).getText(); //Starts on
										
										if(pageLevelStatus.get(0).toLowerCase().contains("self"))//self paced
										{
											if(CoursePageSection.findElements(By.xpath(pageIsSelfpacedOrVilt)).size()>0)
											{
												status.add("starts on presented on self paced card page  " + courseCardNames);
											}
										}
										else if(pageLevelStatus.get(0).toLowerCase().contains("vilt")||pageLevelStatus.get(0).toLowerCase().contains("instructor-led"))//Instructor-Led
										{
											if(CoursePageSection.findElements(By.xpath(pageIsSelfpacedOrVilt)).size()<=0)
											{
												status.add("starts on not presented on Vilt card page  " + courseCardNames);
											}
										}
									}
									else
									{
										status.add("level 1 status are not matching in card page and program page  " + courseCardNames);
									}
											
								}
								else 
								{
									status.add("level status are not available in card page and program page  " + courseCardNames);
								}
							}
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (CoursePageSection.findElements(By.xpath(pagePrice)).size() <= 0) 
							{
								status.add("price  not present in this card page  " + courseCardName);
							}
							else
							{
								String getPagePrice = CoursePageSection.findElement(By.xpath(pagePrice)).getText();
								 String priceString = getPagePrice;
								  String getPrice[] = priceString.split(" ");
								  String priceOfCourseCard = "";
								  if(getPrice.length>1)
								  {
									  priceOfCourseCard = getPrice[0].replaceAll("[^0-9,]", "").replace(",", "");
								  }else {
									  priceOfCourseCard = getPrice[0].replaceAll("[^0-9,]", "").replace(",", "");
								  }
								 
								  System.out.println("price on card : "+priceOfCourseCard);
								pagePriceStatus.add(priceOfCourseCard);
							}
							
							if(!cardPriceStatus.equals(pagePriceStatus))
							{
								status.add("price status are not matching in card page and program page  " + courseCardNames);
							}
						}
					}
						cardLevelStatus.clear();
						cardPriceStatus.clear();
						cardEnrollmentStatus.clear();
						pageLevelStatus.clear();
						pagePriceStatus.clear();
						pageEnrollmentStatus.clear();
					driver.close();
					driver.switchTo().window(microsoftPage);
					}
				}
				else
				{
					System.out.println("Course cards are not available in google cloud partner page");
				}
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				status.add("fail");
			}
			return status;

}
}