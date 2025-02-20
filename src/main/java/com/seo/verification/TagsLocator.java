package com.seo.verification;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TagsLocator
{
	WebDriver driver;
	
	
	@FindBy(xpath = "//div[contains(@class,'TopBanner_bannerContent')]//h1")
	WebElement googleCloudH1Tag;
	
	@FindBy(xpath = "//div[contains(@class,'TopBanner_bannerContent')]/h1")
	WebElement IBMH1Tag;
	
	@FindBy(xpath = "//div[contains(@class,'TopBanner_rightSide')]/h1")
	WebElement MicrosoftH1Tag;
	
	@FindBy(xpath = "//h1[contains(@class,'TopBanner_universityName')]")
	WebElement PLUH1Tag;
	
	@FindBy(xpath = "//div[contains(@class,'TopBanner_rightSide')]/h1")
	WebElement FutureSkillH1Tag;
	
	@FindBy(xpath = "//div[contains(@class,'TopSection_left')]//h1|//div[contains(@class,'HumanTopBanner_humanCategory')]//h1") //AI, bigdata,blockchain, cloud computing, cybersecurity, data analytics, data science,humanskill,IOt,power platform, 
	WebElement categoryH1Tag;
	
	@FindBy(xpath = "//div[contains(@class,'TopBanner_rightSide')]/h1")
	WebElement courseH1Tag;
	
	@FindBy(xpath = "//h1[not(contains(@class, 'hidden'))]")
	WebElement H1TagForCategoryProgramsAndCourses;
	
	
	
	@FindBy(xpath = "//meta[@property='og:type'][1]")
	List<WebElement> ogType;
	
	@FindBy(xpath = "//meta[@property='og:url'][1]")
	List<WebElement> ogURL;
	
	@FindBy(xpath = "//meta[@property='og:title'][1]")
	List<WebElement> ogTitle;
	
	@FindBy(xpath = "//meta[@property='og:description'][1]")
	List<WebElement> ogDescription;
	
	@FindBy(xpath = "//meta[@property='og:image'][1]")
	List<WebElement> ogImage;
	
	@FindBy(xpath = "//meta[@property='twitter:url'][1]")
	List<WebElement> twitterURL;
	
	@FindBy(xpath = "//meta[@property='twitter:card'][1]")
	List<WebElement> twitterCard;
	
	@FindBy(xpath = "//meta[@property='twitter:title'][1]")
	List<WebElement> twitterTitle;
	
	@FindBy(xpath = "//meta[@property='twitter:description'][1]")
	List<WebElement> twitterDescription;
	
	@FindBy(xpath = "//meta[@property='twitter:image'][1]")
	List<WebElement> twitterImage;
	
	@FindBy(xpath = "")
	List<WebElement> ProgramsShowmore;//
	
	@FindBy(xpath = "//div[contains(@class,'LearningCatalogibm_cardRow')]/div//a")
	List<WebElement> Programs;//ibm
	
	@FindBy(xpath = "//img[@id='scrollToTopCourse']//ancestor::button[contains(text(),'Show more')]|")
	List<WebElement> CoursesShowmore;//ibm, microsoft, futureskill
	
	@FindBy(xpath = "//img[@id='scrollToTopCourse']//ancestor::button[contains(text(),'Show less')]")
	List<WebElement> CoursesShowless;//ibm, microsoft, futureskill
	
	@FindBy(xpath = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[contains(@class,'row')]/descendant::div[contains(@class,'LearningCatalog_cardRow')]//a")
	List<WebElement> Courses;//ibm, microsoft, futureskill
	
	String parentWindow = "";
	String validationPage = "";
	
	public TagsLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		parentWindow = driver.getWindowHandle();
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
	
	public ArrayList<String> checkMetaTags(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		
		HashMap<String, List<WebElement>> metaTags = new HashMap<String, List<WebElement>>();
			metaTags.put("ogTypeInfo", ogType);
		
		  metaTags.put("ogURLInfo", ogURL); 
		  metaTags.put("ogTitleInfo", ogTitle);
		  metaTags.put("ogDesciptionInfo", ogDescription); 
		  metaTags.put("ogImageInfo",
		  ogImage); 
		  metaTags.put("twitterURLInfo", twitterURL);
		  metaTags.put("twitterCardInfo", twitterCard);
		  metaTags.put("twitterTitleInfo", twitterTitle);
		  metaTags.put("twitterDescriptionInfo", twitterDescription);
		  metaTags.put("twitterImageInfo", twitterImage);
		 
		  String key ="";
		
		try
		{
			
			for (Map.Entry<String, List<WebElement>> tag : metaTags.entrySet())
			{
				if (tag.getValue().size() > 0)
				{
					key = tag.getKey();
					String value = tag.getValue().get(0).getAttribute("content");
					if (value != null && value != "")
					{
						System.out.println("✅ Meta tag is present and content is present" + key);
					}
					else 
					{
						status.add(key+ " : "+ data);
					}
				}
			}
			
			

		}
		catch (Exception e)
		{
			System.out.println("issue/fail on meta tags "+ key+ " : "+ data);;
		}
		return status;
	}
	
	public String FAQ(String data)
	{
		String status = "";
		try
		{
			boolean isFAQSchemaPresent = validateSchema(driver, "//script[contains(@id,'schema')]", "FAQPage");
			if(isFAQSchemaPresent)
			{
				//status = "FAQ Schema is present";
				System.out.println("FAQ Schema is present");
			} 
			else
			{
				status = "faq  not available on "+ data;
			}

	    } 
		catch (Exception e)
		{
			System.out.println("fail on faq "+ data);
		}
		return status;
	}
	
	public String courseSchema(String data)
	{
		String status = "";
		try
		{
			boolean isCourseSchemaPresent = validateSchema(driver, "//script[contains(@id,'courseschema')]|//script[contains(@id,'CourseSchema')]", "Course");
			if(isCourseSchemaPresent)
			{
				//status = "Course Schema is present";
				System.out.println("Course Schema is present");
            } 
            else
            {
                status = "CourseSchema  : " + data;
            }

	    } 
		catch (Exception e)
		{
	            System.out.println("fail on course schema"+ data);
		}
		return status;
	}

	public String checkH1Tag(WebElement locator, String data)
	{
		String status = "";
		try
		{
			WebElement isH1Present = locator;
			
			if (isH1Present.isDisplayed())
			{
				//status="H1 Tag is present";
				System.err.println("H1 Tag is present");
			}
			else 
			{
				status="H1  : " + data;
			}
		}
		catch (Exception e)
		{
			System.out.println("  h1 tag fail : "+ data);
		}
		return status;
	}
	
	public static boolean validateSchema(WebDriver driver, String courseSchemaScriptLocator, String expectedType) 
	{
		try
		{
			if(driver.findElements(By.xpath(courseSchemaScriptLocator)).size()>0)
			{
				List<WebElement> courseSchemaAndFAQ = driver.findElements(By.xpath(courseSchemaScriptLocator));
				for (WebElement element : courseSchemaAndFAQ)
				{
	                // Extract JSON content from the script tag
	                String jsonContent = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", element);

	                // Parse the JSON content
	                JSONObject jsonObject = new JSONObject(jsonContent);

	                // Check if @type exists and matches the expected type
	                if (jsonObject.has("@type") && jsonObject.getString("@type").equals(expectedType)) 
	                {
	                    return true; // Stop iteration and return true if a valid schema is found
	                }
			    }
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
		return false;
	}
	
	public String checkCanonicalTag(String data)
	{
		String status = "";
		try
		{
			WebElement canonicalTag = driver.findElement(By.xpath("//link[@rel='canonical']"));

            // Check if the href attribute is present and not empty
            String hrefValue = canonicalTag.getAttribute("href");

            if (hrefValue != null && !hrefValue.trim().isEmpty())
            {
                System.out.println("Canonical tag is present with href: " + hrefValue);
            } 
            else
            {
                System.out.println("Canonical tag is missing or href attribute is empty!");
                status = "canonical tag not available" + data;
            }
		}
		catch (Exception e) 
		{
			System.out.println("issue on canonical tag");
		}
		return status;
	}
	boolean checkHomePage;
	boolean checkValidationPage;
	String programOrCourcePage = "";
	String urlToLanuch = "";
	String verifyStatus = "";
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
					if (partnerPageTitle.contains("error")||partnerPageTitle.contains("undefined")|| partnerPageTitle.isEmpty()|| partnerPageTitle == null)
					{
						status.add("issue on partner page title - fail : "+ urlToLanuch);
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
					if (partnerPageTitle.contains("error")||partnerPageTitle.contains("undefined")|| partnerPageTitle.isEmpty()|| partnerPageTitle == null)
					{
						status.add("issue on partner page title - fail : "+ urlToLanuch);
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
			status.add("fail on url : " +urlToLanuch);
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	boolean checkPageStatus;
	
	
	public ArrayList<String> checkPrograms()
	{
		ArrayList<String> status = new ArrayList<String>();
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
		        
		        String showMoreLocatorForProgram = Locators.getLocator(currentPageType, "programShowmore");
		        String showLessLocatorForProgram = Locators.getLocator(currentPageType, "programShowless");
		        String programLocator = Locators.getLocator(currentPageType, "programs");
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
		        } else {
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
							String programURL = program.getAttribute("href");
							status.addAll(this.openPage(programURL));
							if (!status.contains("fail"))
							{
								status.add(this.checkCanonicalTag(programURL));
								status.add(this.FAQ(programURL));
								status.add(this.checkH1Tag(H1TagForCategoryProgramsAndCourses, programURL));
								status.addAll(this.checkMetaTags(programURL));
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
			status.add("issue/fail on programs " + "- URL - "+ driver.getCurrentUrl());
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

				String showMoreLocatorForCourses = Locators.getLocator(currentPageType, "coursesShowmore");
				String showLessLocatorForCourses = Locators.getLocator(currentPageType, "coursesShowless");
				String courseLocator = Locators.getLocator(currentPageType, "courses");
				
				
				//show more button verification for courses
				if (showMoreLocatorForCourses != null && !showMoreLocatorForCourses.isEmpty())
				{
				    while (!driver.findElements(By.xpath(showMoreLocatorForCourses)).isEmpty()) {
				        List<WebElement> showMore = driver.findElements(By.xpath(showMoreLocatorForCourses));

				        for (WebElement show : showMore) {
				            js.executeScript("arguments[0].scrollIntoView();", show);
				            js.executeScript("arguments[0].click();", show);

				            // Check if "Show Less" button exists, then break
				            if (!driver.findElements(By.xpath(showLessLocatorForCourses)).isEmpty()) {
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
							status.add(this.checkCanonicalTag(courseURL));
							status.add(this.FAQ(courseURL));
							status.add(this.courseSchema(courseURL));
							status.add(this.checkH1Tag(H1TagForCategoryProgramsAndCourses, courseURL));
							status.addAll(this.checkMetaTags(courseURL));
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
			status.add("issue/fail on courses " + "- URL - "+ driver.getCurrentUrl());
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
				status.add(this.checkCanonicalTag(data));
				status.add(this.FAQ(data));
				status.add(this.checkH1Tag(IBMH1Tag, data));
				status.addAll(this.checkMetaTags(data));
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
			System.out.println("issue on ibm partner page - fail");
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
			System.out.println("issue on ibm partner page - fail");
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
			status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(MicrosoftH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(googleCloudH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(PLUH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(FutureSkillH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
			status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
				status.add(this.checkCanonicalTag(data));
			status.add(this.FAQ(data));
			status.add(this.checkH1Tag(categoryH1Tag, data));
			status.addAll(this.checkMetaTags(data));
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
