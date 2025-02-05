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

public class GoogleCloudPartnerPageLocator
{
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]")
	private List<WebElement> programCardSection;
	
	@FindBy(xpath = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show more')]")
	private List<WebElement> programCardShowmoreLocator;
	
	@FindBy(xpath = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//div[contains(@class,'LearningCatalog_customCard')]")
	private List<WebElement> programCards;
	
	String programCardsURL = ".//div[contains(@class,'FlatCourseCard_FlatcardLinks')]/a";
	
	String programCardsImage = ".//img[@alt='course-image']";
	
	String ProgramCardsName = ".//h2";
	
	String programCardLevelSection = ".//div[contains(@class,'FlatCourseCard_propertiesList')]";
	
	String ProgramCardsLevel1 = ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li[1]";
	
	String ProgramCardsLevel2 = ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li[2]";
	
	String ProgramCardsLevel3 = ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li[3]";
	
	String ProgramCardsPartner = ".//h6[contains(@class,'FlatCourseCard_companyTitle')]";
	
	String ProgramCardsStartDate = ".//div[contains(@class,'FlatCourseCard_courseStartSection')]//h6[contains(text(),'Course starts on')]/following-sibling::h4";
	
	String programEnrollmentSection = ".//div[contains(@class,'FlatCourseCard_courseStartSection')]";
	
	String ProgramCardsEnrollStatus = ".//div[contains(@class,'FlatCourseCard_courseStartSection')]//h6[contains(text(),'Enrollment Status')]/following-sibling::h4";
	
	String programCardCourseStartedDate = ".//div[contains(@class,'FlatCourseCard_courseStartSection')]//h6[contains(text(),'Course starts on')]/following-sibling::h4";///following-sibling::h4
	
	String programCardPriceSection = ".//div[contains(@class,'FlatCourseCard_priceSection')]";
	
	String ProgramCardsPrice = ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3";
	
	String programPageLocator = "//section[contains(@class,'CourseDescription_mainSection')]";
	
	String programPageName = ".//h1";
	
	String programPageLevel1 = ".//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//div[contains(@class,'CourseDescription_levelSection')]//p[1]|//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//h2";
	
	String  programPageLevel2 = ".//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//div[contains(@class,'CourseDescription_levelSection')]//p[3]|//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//h3[1]";
	
	String programPageLevel3 = ".//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//div[contains(@class,'CourseDescription_levelSection')]//p[5]|//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//h3[2]";
	
	String programPagePartner = ".//img[@alt='Skillup']";
	
	String programPageEnrollStatus = ".//button[contains(@class,'CourseDescription_EnrollBtn')]|//div[contains(@class,'CourseDescription_buttonsContent')]/h6";
	
	
	String programPageDurationSection = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]";
	
	
	String ProgramPageSelfOrVilt = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//h2";
	
	String programPagePrice = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]//h2[contains(text(),'Fee')]/following-sibling::p";
	//***********************************************************************************************************************************************
	String courseCardSection = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]";
	
	@FindBy(xpath =  "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//button[contains(text(),'Show more')]")
	private List<WebElement> CourseCardShowmoreLocator;
	
	@FindBy(xpath = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_customCard')]")
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
	
	String courseCardCourseStartedDate = ".//div[contains(@class,'RegularCourseCard_priceSectionInner')]//h2[contains(text(),'Coming soon')]/following-sibling::p|//div[contains(@class,'RegularCourseCard_priceSectionInner')]//h2[contains(text(),'Course start')]/following-sibling::p";
	
	String CourseCardsPrice = ".//div[contains(@class,'RegularCourseCard_priceRight')]//h2[contains(text(),'From')]/following-sibling::p|//div[contains(@class,'RegularCourseCard_priceRight')]//h2[contains(text(),'Fee')]/following-sibling::p";
	
	String CoursePageLocator = "//section[contains(@class,'CourseDescription_mainSection')]";
	
	String CoursePageName = ".//h1";
	
	String CoursePageLevel1 = ".//div[contains(@class,'CourseDescription_levelSection')]/h2";
	
	String CoursePageLevel2 = ".//div[contains(@class,'CourseDescription_levelSection')]/h3[1]";
	
	String CoursePageLevel3 = ".//div[contains(@class,'CourseDescription_levelSection')]/h3[2]";
	
	String CoursePagePartner = ".//img[@alt='Skillup']|//img[@alt='org-logo']";
	
	String CoursePageDurationSection = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]";
	
	String CoursePageSelfOrVilt = ".//div[contains(@class,'d-flex gap-2')][1]/div[contains(@class,'CourseDescription_courseAboutTextSection')]/h2[contains(text(),'Starts on')]";
	
	String CoursePageEnrollmentSection = ".//div[contains(@class,'CourseDescription_PreferredCohort')]|//div[contains(@class,'CourseDescription_buttonsContent')]";
	
	String CoursePageEnrollStatus = ".//div[contains(@class,'CourseDescription_PreferredCohort')]//div[contains(@class,'CourseDescription_CohortBox')]/button|//div[contains(@class,'CourseDescription_buttonsContent')]/h6|//div[contains(@class,'CourseDescription_buttonsContent')]/button[1]";
	
	String CoursePagePrice = ".//div[contains(@class,'CourseDescription_courseAboutTextSection')]/h2[contains(text(),'Fee')]/following-sibling::p";
	
	public GoogleCloudPartnerPageLocator(WebDriver driver)
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
	public ArrayList<String> verifyGoogleCouldPage()
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			//parentWindow = driver.getWindowHandle();
			//google cloud = google-cloud-courses-and-programs/?utm_source=websiteinternal&utm_medium=megamenu&utm_campaign=NA
			//ibm = ibm-courses-and-programs/?utm_source=websiteinternal&utm_medium=megamenu&utm_campaign=NA
			
			String googleCloudURL = driver.getCurrentUrl()+"google-cloud-courses-and-programs/?utm_source=websiteinternal&utm_medium=megamenu&utm_campaign=NA";
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(googleCloudURL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
			
			parentWindow = driver.getWindowHandle();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	
	public ArrayList<String> verifyGoogleCloudProgramcards()
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (programCardShowmoreLocator.size() > 0) { // Check if the "Show More" button is present
			    List<WebElement> showMore = programCardShowmoreLocator;

			    while (showMore.size() > 0) {
			        WebElement showMoreButton = showMore.get(0); // Always interact with the first "Show More" button

			        // Scroll into view of the "Show More" button
			        js.executeScript("arguments[0].scrollIntoView();", showMoreButton);

			        // Check if the button contains "more" and click if true
			        if (showMoreButton.getText().contains("more")) {
			            js.executeScript("arguments[0].click();", showMoreButton);

			            // Refresh the list of "Show More" buttons after the click
			            showMore = programCardShowmoreLocator;
			        } else {
			            break; // Exit the loop if the button does not contain "more"
			        }
			    }
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(programCards.size()>0)
			{
				List<WebElement> programCard = programCards;
				
				for(WebElement card : programCard)
				{
					js.executeScript("arguments[0].scrollIntoView();", card);
					
					String programCardName = card.findElement(By.xpath(ProgramCardsName)).getText();
					
					String getProgramCardURL = card.findElement(By.xpath(programCardsURL)).getAttribute("href");
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(programCardsImage)).size()<=0)
					{
						status.add("image not present in " +programCardName);
					}
					else
					{
						WebElement image = card.findElement(By.xpath(programCardsImage));
                        js.executeScript("arguments[0].scrollIntoView();", image);
                    }
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(ProgramCardsPartner)).size()<=0)
					{
						status.add("partner name not present in "+programCardName);
					}
					else
					{
						WebElement partner = card.findElement(By.xpath(ProgramCardsPartner));
						js.executeScript("arguments[0].scrollIntoView();", partner);
					}
					
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(programCardLevelSection)).size()>0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (card.findElements(By.xpath(ProgramCardsLevel1)).size() > 0)
						{
							WebElement level1 = card.findElement(By.xpath(ProgramCardsLevel1));
							js.executeScript("arguments[0].scrollIntoView();", level1);
							String cardLevel1 = level1.getText();
							cardLevelStatus.add(cardLevel1);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (card.findElements(By.xpath(ProgramCardsLevel2)).size() > 0)
						{
							WebElement level2 = card.findElement(By.xpath(ProgramCardsLevel2));
							js.executeScript("arguments[0].scrollIntoView();", level2);
							String cardLevel2 = level2.getText();
							cardLevelStatus.add(cardLevel2);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (card.findElements(By.xpath(ProgramCardsLevel3)).size() > 0)
						{
							WebElement level3 = card.findElement(By.xpath(ProgramCardsLevel3));
							js.executeScript("arguments[0].scrollIntoView();", level3);
							String cardLevel3 = level3.getText();
							cardLevelStatus.add(cardLevel3);
						}
					}
					else
					{
						status.add("level section not present in "+programCardName);
					}
					
					
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if (card.findElements(By.xpath(ProgramCardsPrice)).size() <= 0)
					{
						cardPriceStatus.add("price not present in " +programCardName);
					}
					else
					{
						WebElement getPrices = card.findElement(By.xpath(ProgramCardsPrice));
						js.executeScript("arguments[0].scrollIntoView();", getPrices);
						String cardPrice = getPrices.getText();
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
					if(card.findElements(By.xpath(programEnrollmentSection)).size() > 0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (card.findElements(By.xpath(ProgramCardsEnrollStatus)).size() > 0)
						{
							WebElement enrollStatus = card.findElement(By.xpath(ProgramCardsEnrollStatus));
							js.executeScript("arguments[0].scrollIntoView();", enrollStatus);
							String cardEnrollStatus = card.findElement(By.xpath(ProgramCardsEnrollStatus)).getText();
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
						else if(card.findElements(By.xpath(programCardCourseStartedDate)).size() > 0)
						{
							WebElement enrollStartDate = card.findElement(By.xpath(programCardCourseStartedDate));
							js.executeScript("arguments[0].scrollIntoView();", enrollStartDate);
							String cardEnrollStartDateStatus = enrollStartDate.getText();
							
							if(cardEnrollStartDateStatus.contains("Course starts on"))
							{
								cardEnrollmentStatus.add("Open");
							}
							else if(cardEnrollStartDateStatus.contains("Coming soon"))
							{
								cardEnrollmentStatus.add("Closed");
							}
							else
							{
								cardEnrollmentStatus.add("Closed");
							}
	                    }
					}
					else
					{
						cardEnrollmentStatus.add("enrollment section not present in " +programCardName);
					}
					
					//********************************************************************************************
					if (!checkURLStatus(getProgramCardURL).contains("fail"))
					{
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(getProgramCardURL);
					
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					Thread.sleep(100);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if (driver.getCurrentUrl().contains("404")) 
					{
						status.add("404 page is present in this card page  " + programCardName);
					}
					else if(driver.getTitle().contains("null")|| driver.getTitle().contains("undefined"))
					{
						status.add("null or undefined  is present on page title  " + programCardName);
					}
					else
					{
						WebElement programPageSection = driver.findElement(By.xpath(programPageLocator));
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (programPageSection.findElements(By.xpath(programPageName)).size() <= 0)
						{
							status.add("program name not present in this card page  " + programCardName);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						if (programPageSection.findElements(By.xpath(programPageLevel1)).size() > 0)
						{
							WebElement locatelevel1 = programPageSection.findElement(By.xpath(programPageLevel1));
							js.executeScript("arguments[0].scrollIntoView();", locatelevel1);
							String level1 = locatelevel1.getText();
							pageLevelStatus.add(level1);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (programPageSection.findElements(By.xpath(programPageLevel2)).size() > 0) 
						{
							WebElement locatelevel2 = programPageSection.findElement(By.xpath(programPageLevel2));
							js.executeScript("arguments[0].scrollIntoView();", locatelevel2);
							String level2 = locatelevel2.getText();
							pageLevelStatus.add(level2);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (programPageSection.findElements(By.xpath(programPageLevel3)).size() > 0) 
						{
							WebElement locatelevel3 = programPageSection.findElement(By.xpath(programPageLevel3));
							js.executeScript("arguments[0].scrollIntoView();", locatelevel3);
							String level3 = locatelevel3.getText();
							pageLevelStatus.add(level3);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (programPageSection.findElements(By.xpath(programPagePartner)).size() <= 0)
						{
							status.add("partner name not present in this card page  " + programCardName);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (programPageSection.findElements(By.xpath(programPageEnrollStatus)).size() <= 0) 
						{
							status.add("enroll status not present in this card page  " + programCardName);
						}
						else
						{
							List<WebElement> enrollButton = programPageSection.findElements(By.xpath(programPageEnrollStatus));
							js.executeScript("arguments[0].scrollIntoView();", enrollButton.get(0));
							String getPageEnrollStatus = enrollButton.get(0).getText();
							if(getPageEnrollStatus.contains("Enroll now")||getPageEnrollStatus.contains("Enroll Now"))
							{
								pageEnrollmentStatus.add("Open");
							}
							else if(getPageEnrollStatus.contains("Enrollment is Closed"))
							{
								pageEnrollmentStatus.add("Closed");
							}
						}
						
						if (cardEnrollmentStatus.size() == pageEnrollmentStatus.size())
						{
							if(!cardEnrollmentStatus.get(0).toLowerCase().equals(pageEnrollmentStatus.get(0).toLowerCase()))
							{
								status.add("enrollment status are matching in card page and program page  "
										+ programCardName);
							} 
							
						}
						else 
						{
							status.add("enrollment status are not matching in card page and program page  "
									+ programCardName);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (programPageSection.findElements(By.xpath(programPageDurationSection)).size() <= 0) 
						{
							status.add("duration fee section not present in this card page  " + programCardName);
						}
						else
						{
							if(cardLevelStatus.size() == pageLevelStatus.size())
							{
								if ((cardLevelStatus.get(0).toLowerCase()).equals(pageLevelStatus.get(0).toLowerCase()))
								{
									
									if(pageLevelStatus.get(0).toLowerCase().contains("Self-Paced"))//self paced
									{
										if(programPageSection.findElements(By.xpath(ProgramPageSelfOrVilt)).size()>0)
										{
											status.add("starts on presented on self paced card page  " + programCardName);
										}
									}
									else if(pageLevelStatus.get(0).toLowerCase().contains("vilt")||pageLevelStatus.get(0).toLowerCase().contains("instructor-led"))//Instructor-Led
									{
										if(programPageSection.findElements(By.xpath(ProgramPageSelfOrVilt)).size()<=0)
										{
											status.add("starts on not presented on Vilt card page  " + programCardName);
										}
									}
								}
								else
								{
									status.add("level 1 status are not matching in card page and program page  " + programCardName);
								}
										
							}
							else 
							{
								status.add("level status are not matching in card page and program page  " + programCardName);
							}
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (programPageSection.findElements(By.xpath(programPagePrice)).size() <= 0) 
						{
							status.add("price  not present in this card page  " + programCardName);
						}
						else
						{
							WebElement getPrices = programPageSection.findElement(By.xpath(programPagePrice));
							js.executeScript("arguments[0].scrollIntoView();", getPrices);
							String getPagePrice = getPrices.getText();
							 String priceString = getPagePrice;
							  String getPrice[] = priceString.split(" ");
							  String priceOfCourseCard = "";
							  if(getPrice.length>1)
							  {
								  priceOfCourseCard = getPrice[0].replaceAll("[^0-9,]", "").replace(",", "");
							  }
							  else
							  {
								  priceOfCourseCard =  getPrice[0].replaceAll("[^0-9,]", "").replace(",", "");
							  }
							  System.out.println("price on card : "+priceOfCourseCard);
							pagePriceStatus.add(priceOfCourseCard);
						}
						
						if(!cardPriceStatus.equals(pagePriceStatus))
						{
							status.add("price status are not matching in card page and program page  " + programCardName);
						}
						else
						{
							System.out.println("price are same");
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
				driver.switchTo().window(parentWindow);
				}
			}
			else
			{
				System.out.println("Program cards are not available in google cloud partner page");
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	
	public ArrayList<String> verifyGoogleCloudCourseCards()
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
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
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(CourseCards.size()>0)
			{
				List<WebElement> courseCard = CourseCards;
				
				for(WebElement card : courseCard)
				{
					js.executeScript("arguments[0].scrollIntoView();", card);
					
					String courseCardName = card.findElement(By.xpath(CourseCardsName)).getText();
					
					String getCourseCardURL = card.findElement(By.xpath(courseCardURL)).getAttribute("href");
					
					String courseCardImage = ".//img[@alt='"+courseCardName+"']";
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(courseCardImage)).size()<=0)
					{
						status.add("image not present in " +courseCardName);
					}
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(CourseCardsPartner)).size()<=0)
					{
						status.add("partner name not present in "+courseCardName);
					}
					
					
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(CourseCardLevelSection)).size()>0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (card.findElements(By.xpath(CourseCardsLevel1)).size() > 0)
						{
							String cardLevel1 = card.findElement(By.xpath(CourseCardsLevel1)).getText();
							cardLevelStatus.add(cardLevel1);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (card.findElements(By.xpath(CourseCardsLevel2)).size() > 0)
						{
							String cardLevel2 = card.findElement(By.xpath(CourseCardsLevel2)).getText();
							cardLevelStatus.add(cardLevel2);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
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
					
					
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if (card.findElements(By.xpath(CourseCardsPrice)).size() <= 0)
					{
						cardPriceStatus.add("price not present in " +courseCardName);
					}
					else
					{
						String cardPrice = card.findElement(By.xpath(CourseCardsPrice)).getText();
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
					if(card.findElements(By.xpath(courseEnrollmentSection)).size() > 0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
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
						
						  else if(card.findElements(By.xpath(courseCardCourseStartedDate)).size() > 0)
						  { 
							  String cardEnrollStartDateStatus =
						  card.findElement(By.xpath(programCardCourseStartedDate)).getText();
						  
						  if(cardEnrollStartDateStatus.contains("Course starts on")) {
						  cardEnrollmentStatus.add("Open"); } else {
						  cardEnrollmentStatus.add("Closed"); } }
						 
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
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
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
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (CoursePageSection.findElements(By.xpath(CoursePageName)).size() <= 0)
						{
							status.add("program name not present in this card page  " + courseCardName);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						if (CoursePageSection.findElements(By.xpath(CoursePageLevel1)).size() > 0)
						{
							WebElement locatelevel1 = CoursePageSection.findElement(By.xpath(CoursePageLevel1));
							js.executeScript("arguments[0].scrollIntoView();", locatelevel1);
							String level1 = locatelevel1.getText();
							pageLevelStatus.add(level1);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (CoursePageSection.findElements(By.xpath(CoursePageLevel2)).size() > 0) 
						{
							WebElement locatelevel2 = CoursePageSection.findElement(By.xpath(CoursePageLevel2));
							js.executeScript("arguments[0].scrollIntoView();", locatelevel2);
							String level2 = locatelevel2.getText();
							pageLevelStatus.add(level2);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (CoursePageSection.findElements(By.xpath(CoursePageLevel3)).size() > 0) 
						{
							WebElement locatelevel3 = CoursePageSection.findElement(By.xpath(CoursePageLevel3));
							js.executeScript("arguments[0].scrollIntoView();", locatelevel3);
							String level3 = locatelevel3.getText();
							pageLevelStatus.add(level3);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (CoursePageSection.findElements(By.xpath(CoursePagePartner)).size() <= 0)
						{
							status.add("partner name not present in this card page  " + courseCardName);
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (CoursePageSection.findElements(By.xpath(CoursePageEnrollmentSection)).size() <= 0) 
						{
							status.add("enroll status not present in this card page  " + courseCardName);
						}
						else
						{
							List<WebElement> enrollButton = CoursePageSection.findElements(By.xpath(CoursePageEnrollStatus));
							js.executeScript("arguments[0].scrollIntoView();", enrollButton.get(0));
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
										+ courseCardName);
							} 
							
						}
						else 
						{
							status.add("enrollment status are not available in card page and program page  "
									+ courseCardName);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
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
									status.add("level 1 status are not matching in card page and program page  " + courseCardName);
								}
										
							}
							else 
							{
								status.add("level status are not available in card page and program page  " + courseCardName);
							}
						}
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						if (CoursePageSection.findElements(By.xpath(CoursePagePrice)).size() <= 0) 
						{
							status.add("price  not present in this card page  " + courseCardName);
						}
						else
						{
							WebElement getPrices = CoursePageSection.findElement(By.xpath(CoursePagePrice));
							js.executeScript("arguments[0].scrollIntoView();", getPrices);
							String getPagePrice = getPrices.getText();
							 String priceString = getPagePrice;
							  String getPrice[] = priceString.split(" ");
							  String priceOfCourseCard = "";
							  if(getPrice.length>1)
							  {
								  priceOfCourseCard = getPrice[0].replaceAll("[^0-9,]", "").replace(",", "");
							  }
							  else
							  {                                
                                    priceOfCourseCard =  getPrice[0].replaceAll("[^0-9,]", "").replace(",", "");
                                }
							 
							  System.out.println("price on card : "+priceOfCourseCard);
							pagePriceStatus.add(priceOfCourseCard);
						}
						
						if(!cardPriceStatus.equals(pagePriceStatus))
						{
							status.add("price status are not matching in card page and program page  " + courseCardName);
						}
						else
						{
							System.out.println("price are same");
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
				System.out.println("Program cards are not available in google cloud partner page");
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
}
