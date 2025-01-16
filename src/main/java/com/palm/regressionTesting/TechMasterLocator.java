package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TechMasterLocator
{
	WebDriver driver;
String courseCardSection = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]";
	
	@FindBy(xpath =  "//div[contains(@class,'container-fluid FutureSkillPrimeCourses_containerInner')]/div[3]//button[contains(text(),'Show more')]")
	private List<WebElement> CourseCardShowmoreLocator;
	
	@FindBy(xpath = "//div[contains(@class,'container-fluid FutureSkillPrimeCourses_containerInner')]/div[3]//div[contains(@class,'LearningCatalog_customCard')]")
	private List<WebElement> CourseCards;
	
	String courseCardURL = ".//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a";
	
	String CourseCardsName = ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p";
	
	String CourseCardLevelSection = ".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul";
	
	String CourseCardsLevel1 = ".//div[contains(@class,'RegularCourseCard_courseDes')]//ul/li[1]";
	
	String CourseCardsLevel2 = ".//div[contains(@class,'RegularCourseCard_courseDes')]//ul/li[2]";
	
	String CourseCardsLevel3 = ".//div[contains(@class,'RegularCourseCard_courseDes')]//ul/li[3]";
	
	String CourseCardsPartner = ".//div[contains(@class,'RegularCourseCard_courseCompany')]";
	
	String courseEnrollmentSection = ".//div[contains(@class,'RegularCourseCard_priceSection')]//div[contains(@class,'RegularCourseCard_priceLeft')]";
	
	String CourseCardsEnrollStatus = ".//div[contains(@class,'RegularCourseCard_priceSectionInner')]//h2[contains(text(),'Enrollment Status')]/following-sibling::p";
	
	//String courseCardCourseStartedDate = "";
	
	String CourseCardsPrice = ".//div[contains(@class,'RegularCourseCard_priceRight')]//h2[contains(text(),'From')]/following-sibling::p";
	
	String CoursePageLocator = "//section[contains(@class,'CourseDescription_mainSection')]";
	
	String CoursePageName = ".//h1";
	
	String CoursePageLevel1 = ".//div[contains(@class,'CourseDescription_levelSection')]/h2";
	
	String CoursePageLevel2 = ".//div[contains(@class,'CourseDescription_levelSection')]/h3[1]";
	
	String CoursePageLevel3 = ".//div[contains(@class,'CourseDescription_levelSection')]/h3[2]";
	
	String CoursePagePartner = ".//img[@alt='org-logo']";
	
	String CoursePageDurationSection = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]";
	
	String CoursePageSelfOrVilt = ".//div[contains(@class,'d-flex gap-2')][1]/div[contains(@class,'CourseDescription_courseAboutTextSection')]/h2";
	
	String CoursePageEnrollmentSection = ".//div[contains(@class,'CourseDescription_PreferredCohort')]|//div[contains(@class,'CourseDescription_buttonsContent')]";
	
	String CoursePageEnrollStatus = ".//div[contains(@class,'CourseDescription_PreferredCohort')]//div[contains(@class,'CourseDescription_CohortBox')]/button|//div[contains(@class,'CourseDescription_buttonsContent')]/h6|//div[contains(@class,'CourseDescription_buttonsContent')]/button[1]";
	
	String CoursePagePrice = ".//div[contains(@class,'CourseDescription_courseAboutTextSection')]/h2[contains(text(),'Fee')]/following-sibling::p|//div[contains(@class,'CourseDescription_courseAboutTextSection')]/h2[contains(text(),'From')]/following-sibling::p";
	String parentWindow = "";
	public TechMasterLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String launchSite(String url)
	{
		String Status = "";
		try
		{
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(OpenWebsite.setHost+url);
			Status = "pass";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Status = "fail";
		}
		return Status;
	}
	
	public String findOutMore_Button()
	{
		String Status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.cssSelector("a[class*='btn shadow-none TopBanner_requestButton']")).size()>0)
			{
				WebElement clickFindOutMore = driver.findElement(By.cssSelector("a[class*='btn shadow-none TopBanner_requestButton']"));
				js.executeScript("arguments[0].click()", clickFindOutMore);
				Status = "pass";
			}
			if(driver.findElements(By.cssSelector("a[class*='btn shadow-none TopBanner_requestButton']")).size()>0)
			{
				WebElement clickFindOutMore = driver.findElement(By.cssSelector("a[class*='btn shadow-none TopBanner_requestButton']"));
				js.executeScript("arguments[0].click()", clickFindOutMore);
				Status = "pass";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Status = "fail";
		}
		return Status;
	}
	public String learnmore_Button()
	{
		String Status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.cssSelector("a[class*='EligibleForIncentive_knowMoreButton']")).size()>0)
			{
				WebElement learnmore = driver.findElement(By.cssSelector("a[class*='EligibleForIncentive_knowMoreButton']"));
				js.executeScript("arguments[0].click()", learnmore);
				Status = "pass";
				parentWindow = driver.getWindowHandle();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Status = "fail";
		}
		return Status;
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
	public ArrayList<String> Cards()
	{
		ArrayList<String> status = new ArrayList<String>();
		ArrayList<String> cardLevelStatus = new ArrayList<String>();
		ArrayList<String> cardPriceStatus = new ArrayList<String>();
		ArrayList<String> cardEnrollmentStatus = new ArrayList<String>();
		ArrayList<String> pageLevelStatus = new ArrayList<String>();
		ArrayList<String> pagePriceStatus = new ArrayList<String>();
		ArrayList<String> pageEnrollmentStatus = new ArrayList<String>();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
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
			        if (showMoreButton.getText().contains("more")) {
			            js.executeScript("arguments[0].click();", showMoreButton);

			            // Refresh the list of "Show More" buttons after the click
			            showMore = CourseCardShowmoreLocator;
			        } else {
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
					
					String courseCardName = card.findElement(By.xpath(CourseCardsName)).getText();
					
					String getCourseCardURL = card.findElement(By.xpath(courseCardURL)).getAttribute("href");
					
					String courseCardImage = ".//img[@alt='"+courseCardName+"']";
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					if(card.findElements(By.xpath(courseCardImage)).size()<=0)
					{
						status.add("image not present in " +courseCardName);
					}
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					if(card.findElements(By.xpath(CourseCardsPartner)).size()<=0)
					{
						status.add("partner name not present in "+courseCardName);
					}
					
					
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					if(card.findElements(By.xpath(CourseCardLevelSection)).size()>0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (card.findElements(By.xpath(CourseCardsLevel1)).size() > 0)
						{
							String cardLevel1 = card.findElement(By.xpath(CourseCardsLevel1)).getText();
							cardLevelStatus.add(cardLevel1);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (card.findElements(By.xpath(CourseCardsLevel2)).size() > 0)
						{
							String cardLevel2 = card.findElement(By.xpath(CourseCardsLevel2)).getText();
							cardLevelStatus.add(cardLevel2);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (card.findElements(By.xpath(CourseCardsLevel3)).size() > 0)
						{
							String cardLevel3 = card.findElement(By.xpath(CourseCardsLevel3)).getText();
							cardLevelStatus.add(cardLevel3);
						}
					}
					else
					{
						status.add("level section not present in "+courseCardName);
					}
					
					

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					if (card.findElements(By.xpath(CourseCardsPrice)).size() <= 0)
					{
						cardPriceStatus.add("price not present in " +courseCardName);
					}
					else
					{
						WebElement pElement = card.findElement(By.xpath(CourseCardsPrice));
						String fullText = pElement.getText();
						// Split text and extract only the desired part
						String requiredText = pElement.getText().replace(pElement.findElement(By.tagName("span")).getText(), "").trim();
						System.out.println(requiredText);
						
						//String cardPrice = card.findElement(By.xpath(CourseCardsPrice)).getText();
						 String priceString = requiredText;
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
					if(card.findElements(By.xpath(courseEnrollmentSection)).size() > 0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (card.findElements(By.xpath(CourseCardsEnrollStatus)).size() > 0)
						{
							String cardEnrollStatus = card.findElement(By.xpath(CourseCardsEnrollStatus)).getText();
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
						cardEnrollmentStatus.add("enrollment section not present in " +courseCardName);
					}
					
					//********************************************************************************************
					if(!checkURLStatus(getCourseCardURL).contains("fail"))
					{
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(getCourseCardURL);
					
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					if (driver.getCurrentUrl().contains("404")) 
					{
						status.add("404 page is present in this card page  " + courseCardName);
					}
					else if(driver.getTitle().contains("null")|| driver.getTitle().contains("undefined"))
					{
						status.add("null or undefined  is present on page title  " + courseCardName);
					}
					else
					{
						WebElement CoursePageSection = driver.findElement(By.xpath(CoursePageLocator));
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (CoursePageSection.findElements(By.xpath(CoursePageName)).size() <= 0)
						{
							status.add("program name not present in this card page  " + courseCardName);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						if (CoursePageSection.findElements(By.xpath(CoursePageLevel1)).size() > 0)
						{
							String level1 = CoursePageSection.findElement(By.xpath(CoursePageLevel1)).getText();
							pageLevelStatus.add(level1);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (CoursePageSection.findElements(By.xpath(CoursePageLevel2)).size() > 0) 
						{
							String level2 = CoursePageSection.findElement(By.xpath(CoursePageLevel2)).getText();
							pageLevelStatus.add(level2);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (CoursePageSection.findElements(By.xpath(CoursePageLevel3)).size() > 0) 
						{
							String level3 = CoursePageSection.findElement(By.xpath(CoursePageLevel3)).getText();
							pageLevelStatus.add(level3);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (CoursePageSection.findElements(By.xpath(CoursePagePartner)).size() <= 0)
						{
							status.add("partner name not present in this card page  " + courseCardName);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (CoursePageSection.findElements(By.xpath(CoursePageEnrollmentSection)).size() <= 0) 
						{
							status.add("enroll status not present in this card page  " + courseCardName);
						}
						else
						{
							List<WebElement> enrollButton = CoursePageSection.findElements(By.xpath(CoursePageEnrollStatus));
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
								status.add("enrollment status are not matching in card page and course page  "
										+ courseCardName);
							} 
							
						}
						else 
						{
							status.add("enrollment status are not available in card page and course page  "
									+ courseCardName);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (CoursePageSection.findElements(By.xpath(CoursePageDurationSection)).size() <= 0) 
						{
							status.add("duration fee section not present in this card page  " + courseCardName);
						}
						else
						{
							if(cardLevelStatus.size() == pageLevelStatus.size())
							{
								if ((cardLevelStatus.get(0).toLowerCase()).equals(pageLevelStatus.get(0).toLowerCase()))
								{
									String getDurationText = CoursePageSection.findElement(By.xpath(CoursePageSelfOrVilt)).getText(); //Starts on
									
									if(pageLevelStatus.get(0).toLowerCase().contains("self"))//self paced
									{
										if(CoursePageSection.findElements(By.xpath(CoursePageSelfOrVilt)).size()>0)
										{
											status.add("starts on presented on self paced card page  " + courseCardName);
										}
									}
									else if(pageLevelStatus.get(0).toLowerCase().contains("vilt")||pageLevelStatus.get(0).toLowerCase().contains("instructor-led"))//Instructor-Led
									{
										if(CoursePageSection.findElements(By.xpath(CoursePageSelfOrVilt)).size()<=0)
										{
											status.add("starts on not presented on Vilt card page  " + courseCardName);
										}
									}
								}
								else
								{
									status.add("level 1 status are not matching in card page and course page  " + courseCardName);
								}
										
							}
							else 
							{
								status.add("level status are not available in card page and course page  " + courseCardName);
							}
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						if (CoursePageSection.findElements(By.xpath(CoursePagePrice)).size() <= 0) 
						{
							status.add("price  not present in this card page  " + courseCardName);
						}
						else
						{
							WebElement pElement = CoursePageSection.findElement(By.xpath(CoursePagePrice));
							String fullText = pElement.getText();
							// Split text and extract only the desired part
							String requiredText = pElement.getText().replace(pElement.findElement(By.tagName("span")).getText(), "").trim();
							System.out.println(requiredText);
							
							//String cardPrice = card.findElement(By.xpath(CourseCardsPrice)).getText();
							 String priceString = requiredText;
							  String getPrice[] = priceString.split(" ");
							  String priceOfCourseCard = "";
							  if(getPrice.length>1)
							  {
								  priceOfCourseCard = getPrice[0].replaceAll("[^0-9,]", "").replace(",", "");
							  }
							  else
							  {
								  priceOfCourseCard = getPrice[0].replaceAll("[^0-9,]", "").replace(",", "");
							  }
							  System.out.println("price on card : "+priceOfCourseCard);
							pagePriceStatus.add(priceOfCourseCard);
						}
						
						if(!cardPriceStatus.equals(pagePriceStatus))
						{
							status.add("price status are not matching in card page and course page  " + courseCardName);
						}
					}
					cardLevelStatus.clear();
					cardPriceStatus.clear();
					cardEnrollmentStatus.clear();
					pageLevelStatus.clear();
					pagePriceStatus.clear();
					pageEnrollmentStatus.clear();
				driver.close();
				driver.switchTo().window(parentWindow);
				}
				}
			}
			else
			{
				System.out.println("course cards are not available in google cloud partner page");
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	public String CheckFAQFocus()
	{
		String Status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement focusFAQ = driver.findElement(By.xpath("//a[contains(text(),'Check our FAQs section for detail')]"));
			js.executeScript("arguments[0].scrollIntoView();", focusFAQ);
			if(focusFAQ.isDisplayed())
			{
				js.executeScript("arguments[0].click()", focusFAQ);
				if(driver.findElements(By.xpath("Section#go-to-Faq")).size()>0)
				{
					Status = "pass";
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Status = "fail";
		}
		return Status;
	}
}
