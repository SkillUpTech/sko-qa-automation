package com.seo.card;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import com.seo.card.CardLocators;

public class CardProcess
{
	WebDriver driver;
	String cardName = "";
	String pageName = "";
	String statusOfCard = "";
	public CardProcess(WebDriver driver)
	{
		this.driver = driver;
	}
	public String checkURLStatus(String data)
	{
		  String status = "";
	        HttpURLConnection connection = null;
	        int responseCode = 200;
			 try 
			 {
				 	URI uri = new URI(data); // Convert string to URI
		            URL url = uri.toURL();
		            connection = (HttpURLConnection) url.openConnection();
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
				 status = "issue/fail on url : "+data;
		     }
			return status;
	}
	
	
	public ArrayList<String> checkImage(String data, String statusOfCard)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			
		}
		catch (Exception e)
		{
			status.add("issue on image verification : "+data);
		}
		return status;
	}
	
	public ArrayList<String> checkIcon(String data, String statusOfCard)
	{
		ArrayList<String> status = new ArrayList<String>();
		
		
		try
		{
			
		}
		catch (Exception e)
		{
		}
		return status;
	}
	
	public ArrayList<String> checkLabel(String data, String statusOfCard)
	{
		ArrayList<String> status = new ArrayList<String>();
		
		
		try
		{
			
		}
		catch (Exception e)
		{
		}
		return status;
	}

	public ArrayList<String> checkTitle(String data, String statusOfCard)
	{
		ArrayList<String> status = new ArrayList<String>();
		
		
		try
		{
			
		}
		catch (Exception e)
		{
		}
		return status;
	}
	
	public ArrayList<String> checkPartner(String data, String statusOfCard) 
	{
		ArrayList<String> status = new ArrayList<String>();
		
		
		try
		{
			
		}
		catch (Exception e)
		{
		}
		return status;
	}
	
	public ArrayList<String> checkLevels(String data, String statusOfCard)
	{
		ArrayList<String> status = new ArrayList<String>();
		
		
		try
		{
			
		}
		catch (Exception e)
		{
		}
		return status;
	}
	
	public ArrayList<String> checkLevel1Value(String data, String statusOfCard)
	{
		ArrayList<String> status = new ArrayList<String>();
		
		
		try
		{
			
		}
		catch (Exception e)
		{
		}
		return status;
	}
	
	public ArrayList<String> checkPrice(String data, String statusOfCard)
	{
		ArrayList<String> status = new ArrayList<String>();
		
		
		try
		{
			
		}
		catch (Exception e)
		{
		}
		return status;
	}
	
	public ArrayList<String> checkEnrollStatus(String data, String statusOfCard)
	{
		ArrayList<String> status = new ArrayList<String>();
		
		
		try
		{
			
		}
		catch (Exception e)
		{
		}
		return status;
	}
	String parentWindow = "";
	String validationPage = "";
	boolean checkHomePage;
	boolean checkValidationPage;
	String programOrCourcePage = "";
	String urlToLanuch = "";
	String verifyStatus = "";
	
	String showMoreLocatorForProgram = "";
    String showLessLocatorForProgram =  "";
    String programLocator =  "";
    
    String programCardImageLocator =  "";
    String programCardIconLocator =  "";
    String programCardLabelLocator =  "";
    String programCardNameLocator =  "";
    String programCardLevelLocator =  "";
    String programCardPartnerLocator =  "";
    String programCardEnrollStatusLocator =  "";
    String programCardEnrollIsCloseLocator =  "";
    String programCardEnrollStartedStatusLocator =  ""; 
    String programCardPriceLocator =  "";
    
    String courseCardImageLocator =  "";
    String courseCardIconLocator =  "";
    String courseCardLabelLocator =  "";
    String courseCardNameLocator =  "";
    String courseCardLevelLocator =  "";
    String courseCardPartnerLocator =  "";
    String courseCardEnrollStatusLocator =  "";
    String courseCardEnrollIsCloseLocator =  "";
    String courseCardEnrollStartedStatusLocator =  ""; 
    String courseCardPriceLocator =  "";
    
    String coursePageImageLocator =  "";
    String coursePageIconLocator =  "";
    String coursePageLabelLocator =  "";
    String coursePagePartnerLocator =  "";
    String coursePageLevelsLocator =  "";
    String coursePageLevel1Locator =  "";
    String coursePageLevel1ValueLocator =  "";
    String coursePagePriceLocator =  "";
    String coursePageEnrollStatusLocator =  "";
    
    
	public ArrayList<String> openPage(String url)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			String getCurrentURL = "";
			if (!checkHomePage && !checkValidationPage) //if validation page is false
			{
				checkHomePage = true;
				checkValidationPage = false;
				parentWindow = driver.getWindowHandle(); // home page site
				getCurrentURL = driver.getCurrentUrl(); // home page url
				urlToLanuch = getCurrentURL+url; //validation page url(partner/category page)
				verifyStatus = checkURLStatus(urlToLanuch);
				if(!verifyStatus.contains("fail"))
				{
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(urlToLanuch);
					String partnerPageTitle = driver.getTitle();
					if (partnerPageTitle.contains("error")||partnerPageTitle.contains("undefined")||driver.getCurrentUrl().contains("?utm"))
					{
						status.add("issue on partner page title or page : "+ urlToLanuch);
						checkHomePage = false;
						checkValidationPage = false;
					}
					else
					{
						validationPage = driver.getWindowHandle(); //validation page (partner/catgory page)
						checkHomePage = false;
						checkValidationPage = true;
					}
				}
				else 
				{
					System.out.println("❌ Error: " + verifyStatus);
					status.add(verifyStatus + " for " + urlToLanuch);
					checkHomePage = false;
					checkValidationPage = false;
				}
			}
			else
			{
				urlToLanuch = url;
				verifyStatus = checkURLStatus(urlToLanuch);
				programOrCourcePage = driver.getWindowHandle();
				if(!verifyStatus.contains("fail"))
				{
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(urlToLanuch);
					String partnerPageTitle = driver.getTitle();
					if (partnerPageTitle.contains("error")||partnerPageTitle.contains("undefined")|| driver.getCurrentUrl().contains("?utm"))
					{
						status.add("issue on partner page title or page : "+ urlToLanuch);
						checkHomePage = false;
						checkValidationPage = false;
					}
					else
					{
						programOrCourcePage = driver.getWindowHandle(); //validation page (partner/catgory page)
						checkHomePage = false;
						checkValidationPage = true;
					}
				}
				else 
				{
					System.out.println("❌ Error: " + verifyStatus);
					status.add(verifyStatus + " for " + urlToLanuch);
					checkHomePage = false;
					checkValidationPage = false;
				}
			}

			
		}
		catch (Exception e) 
		{
			status.add("issue on url : " +urlToLanuch);
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	boolean checkPageStatus;
	
	
	public ArrayList<String> checkPrograms()
	{
		ArrayList<String> status = new ArrayList<String>();
		ArrayList<String> enrollStatus = new ArrayList<String>();
		try
		{
			
			if(checkPageStatus)
			{
				
				String currentURL = driver.getCurrentUrl();
		        String currentPageType = "";

		        // Identify page type based on URL keywords
		        if (currentURL.contains("artificial")) 
		        {
		            currentPageType = "Artificial";
		        } 
		        else if (currentURL.contains("futureskills")) 
		        {
		            currentPageType = "FutureSkills";
		        }
		        else if (currentURL.contains("ibm")) 
		        {
		            currentPageType = "IBM";
				} 
		        else if (currentURL.contains("microsft")) 
		        {
					currentPageType = "Microsoft";
				}
		        else if (currentURL.contains("azure")) 
		        {
		            currentPageType = "Azure";
		        } 
		        
				else if (currentURL.contains("big-data")) {
					currentPageType = "BigData";
				} else if (currentURL.contains("blockchain")) {
					currentPageType = "Blockchain";
				} else if (currentURL.contains("business-application")) {
					currentPageType = "BusinessApplication";
				} else if (currentURL.contains("cloud-computing")) {
					currentPageType = "CloudComputing";
				} else if (currentURL.contains("cybersecurity")) {
					currentPageType = "CyberSecurity";
				} else if (currentURL.contains("data-analytics")) {
					currentPageType = "DataAnalytics";
				} else if (currentURL.contains("data-science")) {
					currentPageType = "DataScience";
				} else if (currentURL.contains("devops")) {
					currentPageType = "DevOps";
				} 
				else if (currentURL.contains("human-skills")) {
					currentPageType = "HumanSkills";
				} else if (currentURL.contains("iot")) {
					currentPageType = "IoT";
				}else if (currentURL.contains("modern-workplace")) {
					currentPageType = "ModernWorkplace";
				} 
				else if (currentURL.contains("modern-workplace")) {
					currentPageType = "PowerBI";
				}
				else if (currentURL.contains("power-platform")) {
					currentPageType = "PowerPlatform";}
				else {
					currentPageType = "Unknown";
				}
		        
		         showMoreLocatorForProgram = CardLocators.getLocator(currentPageType, "programShowmore");
		         showLessLocatorForProgram = CardLocators.getLocator(currentPageType, "programShowless");
		         programLocator = CardLocators.getLocator(currentPageType, "programs");
		        
		         programCardImageLocator = CardLocators.getLocator(currentPageType, "programCardImage");
		         programCardIconLocator = CardLocators.getLocator(currentPageType, "programCardIcon");
		         programCardLabelLocator = CardLocators.getLocator(currentPageType, "programCardLabel");
		         programCardNameLocator = CardLocators.getLocator(currentPageType, "programCardName");
		         programCardLevelLocator = CardLocators.getLocator(currentPageType, "programCardLevel");
		         programCardPartnerLocator = CardLocators.getLocator(currentPageType, "programCardPartner");
		         programCardEnrollStatusLocator = CardLocators.getLocator(currentPageType, "programCardEnrollStatus");
		         programCardEnrollIsCloseLocator = CardLocators.getLocator(currentPageType, "programCardEnrollIsClose");
		         programCardEnrollStartedStatusLocator = CardLocators.getLocator(currentPageType, "courseCardEnrollStartedStatus"); 
		         programCardPriceLocator = CardLocators.getLocator(currentPageType, "programCardPrice");
		        
		        
		        
		         coursePageImageLocator = CardLocators.getLocator(currentPageType, "coursePageImage");
		         coursePageIconLocator = CardLocators.getLocator(currentPageType, "coursePageIcon");
		         coursePageLabelLocator = CardLocators.getLocator(currentPageType, "coursePageLabel");
		         coursePagePartnerLocator = CardLocators.getLocator(currentPageType, "coursePagePartner");
		         coursePageLevelsLocator = CardLocators.getLocator(currentPageType, "coursePageLevels");
		         coursePageLevel1Locator = CardLocators.getLocator(currentPageType, "coursePageLevel1");
		         coursePageLevel1ValueLocator = CardLocators.getLocator(currentPageType, "coursePageLevel1Value");
		         coursePagePriceLocator = CardLocators.getLocator(currentPageType, "coursePagePrice");
		         coursePageEnrollStatusLocator = CardLocators.getLocator(currentPageType, "coursePageEnrollStatus");
		        
		        
		        
		        if (showMoreLocatorForProgram != null && !showMoreLocatorForProgram.isEmpty())
		        {
		            while (driver.findElements(By.xpath(showMoreLocatorForProgram)).size() > 0) {
		                List<WebElement> showMore = driver.findElements(By.xpath(showMoreLocatorForProgram));
		                
		                for (WebElement show : showMore) {
		                    JavascriptExecutor js = (JavascriptExecutor) driver;
		                    js.executeScript("arguments[0].scrollIntoView();", show);
		                    js.executeScript("arguments[0].click();", show);

		                    // Ensure 'showLessLocatorForProgram' is valid before breaking
		                    if (showLessLocatorForProgram != null && !showLessLocatorForProgram.isEmpty()) {
		                        break;
		                    }
		                }
		            }
		        }
		        else
		        {
		            System.out.println("showMoreLocatorForProgram is null or empty. Skipping...");
		        }

		        
				if (programLocator != null && !programLocator.isEmpty())
				{
				    List<WebElement> programs = driver.findElements(By.xpath(programLocator));

				    if (!programs.isEmpty())
				    {
				        // Perform operations on programs
				        for (WebElement program : programs) 
				        {
				        	WebElement getProgramCard = program;
				        	
				        	//name verifictaion
				        	if(getProgramCard.findElements(By.xpath(programCardNameLocator)).size()>0)
				        	{
				        		cardName = getProgramCard.findElement(By.xpath(programCardNameLocator)).getText();
				        	}
				        	else
				        	{
				        		status.add("Name not found for program card : "+driver.getCurrentUrl());
				        		
				        	}
				        	//image verification
				        	if(getProgramCard.findElements(By.xpath(programCardImageLocator)).size()<0)
				        	{
				        		status.add("Image not found for program card : "+cardName);
				        	}
				        	//icon verification
							if (getProgramCard.findElements(By.xpath(programCardIconLocator)).size() < 0)
							{
								status.add("Icon not found for program card : " + cardName);
							}
				        	//label verification
							if (getProgramCard.findElements(By.xpath(programCardLabelLocator)).size() < 0)
							{
								status.add("Label not found for program card : " + cardName);
                            }
                        	//partner verification
							if (getProgramCard.findElements(By.xpath(programCardPartnerLocator)).size() < 0) 
							{
								status.add("Partner not found for program card : " + cardName);
							}
							
							//level verification
							if (getProgramCard.findElements(By.xpath(programCardLevelLocator)).size() < 0)
							{
								status.add("Level not found for program card : " + cardName);
							}
							String EnrollData = "";
							//enroll status verification
							if(getProgramCard.findElements(By.xpath(programCardEnrollStatusLocator)).size() > 0)
							{
								WebElement enroll = getProgramCard.findElement(By.xpath(programCardEnrollStatusLocator));
								EnrollData = enroll.getText();
								if(EnrollData.contains("Open"))
								{
									enrollStatus.add("Open");
								}
								else if (EnrollData.contains("Closed"))
								{
									enrollStatus.add("Close");
								}
								else if (EnrollData.contains("Coming soon"))
								{
									enrollStatus.add("Close");
								}
							}
							else if(getProgramCard.findElements(By.xpath(programCardEnrollIsCloseLocator)).size() > 0)
							{
								WebElement enroll = getProgramCard.findElement(By.xpath(programCardEnrollStatusLocator));
								EnrollData = enroll.getText();
								if(EnrollData.contains("Open"))
								{
									enrollStatus.add("Open");
								}
								else if (EnrollData.contains("Closed"))
								{
									enrollStatus.add("Close");
								}
								else if (EnrollData.contains("Coming soon"))
								{
									enrollStatus.add("Close");
								}
							}
							else if(getProgramCard.findElements(By.xpath(programCardEnrollStartedStatusLocator)).size() > 0)
							{
								WebElement enroll = getProgramCard.findElement(By.xpath(programCardEnrollStatusLocator));
								EnrollData = enroll.getText();//Aug 22, 2023
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						        LocalDate dateToCheck = LocalDate.parse(EnrollData, formatter);
						        LocalDate currentDate = LocalDate.now();
						        
						        if (dateToCheck.isBefore(currentDate))
						        {
						            System.out.println(EnrollData + " is in the past.");
						            enrollStatus.add("Open");
						        } 
						        else if (dateToCheck.isAfter(currentDate))
						        {
						            System.out.println(EnrollData + " is in the future.");
						            enrollStatus.add("Close");
						        } 
						        else
						        {
						            System.out.println(EnrollData + " is today.");
						            enrollStatus.add("Open");
						        }
							}
							else
							{
								status.add("enroll status not found for program card : " + cardName);
							}
							
							String programURL = getProgramCard.getAttribute("href");
							status.addAll(this.openPage(programURL));
							if (!status.contains("fail"))
							{
								status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
								status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
								status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
								status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
								status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
								status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
								status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
								status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
								status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
								driver.close();
								driver.switchTo().window(validationPage);
								checkValidationPage = true;
							}
						
				        }
				    } 
				    else 
				    {
				        System.out.println("No programs found. Skipping to next section.");
				        checkPageStatus = true;
				    }
				} 
				else
				{
				    System.out.println("Programs section not available. Skipping...");
				    checkPageStatus = true;
				}
				checkValidationPage = true;
			}
			else
			{
				checkValidationPage = true;
				 checkPageStatus = true;
			}
			
		}
		catch(Exception e)
		{
			status.add("issue on programs " + "- URL - "+ driver.getCurrentUrl());
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	public ArrayList<String> checkCourses()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(checkPageStatus)
			{
				String currentURL = driver.getCurrentUrl();
		        String currentPageType = "";

		        // Identify page type based on URL keywords
		        if (currentURL.contains("artificial")) 
		        {
		            currentPageType = "Artificial";
		        } 
		        else if (currentURL.contains("futureskills")) 
		        {
		            currentPageType = "FutureSkills";
		        }
		        else if (currentURL.contains("ibm")) 
		        {
		            currentPageType = "IBM";
				} 
		        else if (currentURL.contains("microsoft")) 
		        {
					currentPageType = "Microsoft";
				}
		        else if (currentURL.contains("azure")) 
		        {
		            currentPageType = "Azure";
		        } 
		        
				else if (currentURL.contains("big-data")) {
					currentPageType = "BigData";
				} else if (currentURL.contains("blockchain")) {
					currentPageType = "Blockchain";
				} else if (currentURL.contains("business-application")) {
					currentPageType = "BusinessApplication";
				} else if (currentURL.contains("cloud-computing")) {
					currentPageType = "CloudComputing";
				} else if (currentURL.contains("cybersecurity")) {
					currentPageType = "CyberSecurity";
				} else if (currentURL.contains("data-analytics")) {
					currentPageType = "DataAnalytics";
				} else if (currentURL.contains("data-science")) {
					currentPageType = "DataScience";
				} else if (currentURL.contains("devops")) {
					currentPageType = "Devops";
				} 
				else if (currentURL.contains("human-skills")) {
					currentPageType = "HumanSkills";
				} else if (currentURL.contains("iot")) {
					currentPageType = "IoT";
				}else if (currentURL.contains("modern-workplace")) {
					currentPageType = "ModernWorkplace";
				} 
				else if (currentURL.contains("modern-workplace")) {
					currentPageType = "PowerBI";
				}
				else if (currentURL.contains("power-platform")) {
					currentPageType = "PowerPlatform";}
				else {
					currentPageType = "Unknown";
				}

				String showMoreLocatorForCourses = CardLocators.getLocator(currentPageType, "coursesShowmore");
				String showLessLocatorForCourses = CardLocators.getLocator(currentPageType, "coursesShowless");
				String courseLocator = CardLocators.getLocator(currentPageType, "courses");
				
				 courseCardImageLocator = CardLocators.getLocator(currentPageType, "CourseCardImage");
				 courseCardIconLocator = CardLocators.getLocator(currentPageType, "CourseCardIcon");
				 courseCardLabelLocator = CardLocators.getLocator(currentPageType, "CourseCardLabel");
				 courseCardNameLocator = CardLocators.getLocator(currentPageType, "CourseCardName");
				 courseCardLevelLocator = CardLocators.getLocator(currentPageType, "CourseCardLevel");
				 courseCardPartnerLocator = CardLocators.getLocator(currentPageType, "CourseCardPartner");
				 courseCardEnrollStatusLocator = CardLocators.getLocator(currentPageType, "CourseCardEnrollStatus");
				 courseCardEnrollIsCloseLocator = CardLocators.getLocator(currentPageType, "CourseCardEnrollIsClose");
				 courseCardEnrollStartedStatusLocator = CardLocators.getLocator(currentPageType, "CourseCardEnrollStartedStatus"); 
				 courseCardPriceLocator = CardLocators.getLocator(currentPageType, "CourseCardPrice");
				
				 coursePageImageLocator = CardLocators.getLocator(currentPageType, "coursePageImage");
		         coursePageIconLocator = CardLocators.getLocator(currentPageType, "coursePageIcon");
		         coursePageLabelLocator = CardLocators.getLocator(currentPageType, "coursePageLabel");
		         coursePagePartnerLocator = CardLocators.getLocator(currentPageType, "coursePagePartner");
		         coursePageLevelsLocator = CardLocators.getLocator(currentPageType, "coursePageLevels");
		         coursePageLevel1Locator = CardLocators.getLocator(currentPageType, "coursePageLevel1");
		         coursePageLevel1ValueLocator = CardLocators.getLocator(currentPageType, "coursePageLevel1Value");
		         coursePagePriceLocator = CardLocators.getLocator(currentPageType, "coursePagePrice");
		         coursePageEnrollStatusLocator = CardLocators.getLocator(currentPageType, "coursePageEnrollStatus");
				
				
				//show more button verification for courses
				if (showMoreLocatorForCourses != null && !showMoreLocatorForCourses.isEmpty())
				{
				    while (!driver.findElements(By.xpath(showMoreLocatorForCourses)).isEmpty()) 
				    {
				        List<WebElement> showMore = driver.findElements(By.xpath(showMoreLocatorForCourses));

				        for (WebElement show : showMore)
				        {
				            js.executeScript("arguments[0].scrollIntoView();", show);
				            js.executeScript("arguments[0].click();", show);

				            // Check if "Show Less" button exists, then break
				            if (!driver.findElements(By.xpath(showLessLocatorForCourses)).isEmpty())
				            {
				                break;
				            }
				        }
				    }
				}
				else
				{
				    System.out.println("showMoreLocatorForProgram is null or empty. Skipping...");
				}

				//course card  verification
				if(courseLocator!=null)
				{
					List<WebElement> courses = driver.findElements(By.xpath(courseLocator));
					for(WebElement course : courses)
					{
						String courseURL = course.getAttribute("href");
						status.addAll(this.openPage(courseURL));
						if (!status.contains("fail"))
						{
							status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
							status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
							status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
							status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
							status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
							status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
							status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
							status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
							status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
							driver.close();
							driver.switchTo().window(validationPage);
							checkValidationPage = true;
							checkHomePage = false;
						}
					}
				}
				else
				{
					System.out.println("No courses found. Skipping to next section.");
				}
				
			}
			checkPageStatus = false;
			driver.close();
			driver.switchTo().window(parentWindow);
			checkHomePage = false;
			checkValidationPage = false;
		}
		catch(Exception e)
		{
			status.add("issue on courses " + "- URL - "+ driver.getCurrentUrl());
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	public ArrayList<String> checkIBM_PartnerPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
				
		}
		catch(Exception e)
        {
            System.out.println("issue on ibm partner page - fail");
        }
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkIBM_Partner_Programs()
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			status.addAll(this.checkPrograms());
		}
		catch(Exception e)
		{
			System.out.println("issue on ibm partner page for program verification - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkIBM_Partner_Courses()
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			status.addAll(this.checkCourses());
		}
		catch(Exception e)
		{
			System.out.println("issue on ibm partner page for course verification - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkAI_CategoryPage_Programs()
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			status.addAll(this.checkPrograms());
		}
		catch(Exception e)
		{
			System.out.println("issue on AI page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	
		
	}
	public ArrayList<String> checkAI_CategoryPage_Courses()
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			status.addAll(this.checkCourses());
		}
		catch(Exception e)
		{
			System.out.println("issue on AI page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	public ArrayList<String> checkMicrosoft_PartnerPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on microsoft page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	public ArrayList<String> checkMicrosoft_PartnerPage_Programs()
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			status.addAll(this.checkPrograms());
		}
		catch(Exception e)
		{
			System.out.println("issue on microsoft program page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	
		
	}
	public ArrayList<String> checkMicrosoft_PartnerPage_Courses()
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			status.addAll(this.checkCourses());
		}
		catch(Exception e)
		{
			System.out.println("issue on microsoft course  page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	public ArrayList<String> checkGoogleCloud_PartnerPage(String data) 
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			checkValidationPage = false;
			checkHomePage = false;
			/*
			 * } if (!checkPageStatus) {
			 */
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on google cloud page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkGoogleCloud_PartnerPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on google cloud page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}

	public ArrayList<String> checkGoogleCloud_PartnerPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on google cloud page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public ArrayList<String> checkPLU_PartnerPage(String data) 
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			/*
			 * } if (!checkPageStatus) {
			 */
				driver.close();
				driver.switchTo().window(parentWindow);
				checkValidationPage = false;
				checkHomePage = false;
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on plu page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<String> checkPLU_PartnerPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on plu page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}

	public ArrayList<String> checkPLU_PartnerPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on plu page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	public ArrayList<String> checkFutureSkill_PartnerPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
            {
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
            }
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on futureskills page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<String> checkFutureSkill_PartnerPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on futureskills page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkFutureSkill_PartnerPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on futureskills page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> AI_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on AI page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> AI_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on AI page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}

	public ArrayList<String> AI_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on AI page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkAzure_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on azure page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkAzure_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on azure page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkAzure_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on azure page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkBigData_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on bigdata page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkBigData_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on bigdata page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkBigData_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on bigdata page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkBlockchain_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on blockchain page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkBlockchain_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on blockchain page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkBlockchain_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on blockchain page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkBusinessApplication_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on business App page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkBusinessApplication_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on business App page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkBusinessApplication_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on business App page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkCloudComputing_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on cloud computing page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkCloudComputing_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on cloud computing page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkCloudComputing_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on cloud computing page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkCompliancePOSH_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on posh page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	/*
	 * public ArrayList<String> checkCompliancePOSH_CategoryPage_Programs() {
	 * ArrayList<String> status = new ArrayList<String>(); try {
	 * status.addAll(this.checkPrograms()); } catch (Exception e) {
	 * System.out.println("issue on posh page - fail"); } return
	 * status.stream().filter(s -> s != null && !s.trim().isEmpty())
	 * .collect(Collectors.toCollection(ArrayList::new));
	 * 
	 * }
	 * 
	 * public ArrayList<String> checkCompliancePOSH_CategoryPage_Courses() {
	 * ArrayList<String> status = new ArrayList<String>(); try {
	 * status.addAll(this.checkCourses()); } catch (Exception e) {
	 * System.out.println("issue on posh page - fail"); } return
	 * status.stream().filter(s -> s != null && !s.trim().isEmpty())
	 * .collect(Collectors.toCollection(ArrayList::new)); }
	 */
	
	public ArrayList<String> checkCybersecurity_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on cybersecurity page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkCybersecurity_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on cybersecurity page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkCybersecurity_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on cybersecurity page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	
	
	public ArrayList<String> checkDataAnalytics_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on data analytics page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkDataAnalytics_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on data analytics page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkDataAnalytics_CategoryPage_Courses() {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.checkCourses());
        } catch (Exception e) {
        	System.out.println("issue on data analytics page - fail");
        }
        return status.stream().filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
                }
	
	public ArrayList<String> checkDataScience_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on data science page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkDataScience_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on data science page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkDataScience_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on data science page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkDevOps_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on devops page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public ArrayList<String> checkDevOps_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on devops page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkDevOps_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on devops page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkHumanSkills_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on humanskills page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public ArrayList<String> checkHumanSkills_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on humanskills page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkHumanSkills_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on humanskills page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkIOT_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on IOT page - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public ArrayList<String> checkIOT_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on IOT page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkIOT_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on IOT page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	public ArrayList<String> checkModernWorkplace_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on Modern Workplace  page - fail");
		}
		return status;
	}
	
	public ArrayList<String> checkModernWorkplace_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on Modern Workplace  page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkModernWorkplace_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on Modern Workplace  page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	
	public ArrayList<String> checkPowerBI_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on power BI  page - fail");
		}
		return status;
	}
	
	public ArrayList<String> checkPowerBI_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on power BI  page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkPowerBI_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on power BI  page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	
	public ArrayList<String> checkPowerPlatform_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on Power Platform  page - fail");
		}
		return status;
	}
	
	public ArrayList<String> checkPowerPlatform_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on Power Platform  page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkPowerPlatform_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on Power Platform  page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	
	
	public ArrayList<String> checkProductivity_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
				checkPageStatus = true;
				status.addAll(this.checkImage(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkIcon(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLabel(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkTitle(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPartner(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevels(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkLevel1Value(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkPrice(coursePageImageLocator, statusOfCard));
				status.addAll(this.checkEnrollStatus(coursePageImageLocator, statusOfCard));
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		} 
		catch (Exception e)
		{
			System.out.println("issue on productivity  page - fail");
		}
		return status;
	}
	
	public ArrayList<String> checkProductivity_CategoryPage_Programs() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkPrograms());
		} catch (Exception e) {
			System.out.println("issue on productivity  page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));

	}
	
	public ArrayList<String> checkProductivity_CategoryPage_Courses() {
		ArrayList<String> status = new ArrayList<String>();
		try {
			status.addAll(this.checkCourses());
		} catch (Exception e) {
			System.out.println("issue on productivity  page - fail");
		}
		return status.stream().filter(s -> s != null && !s.trim().isEmpty())
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
