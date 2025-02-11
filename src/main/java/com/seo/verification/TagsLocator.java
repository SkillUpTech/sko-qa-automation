package com.seo.verification;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
	
	@FindBy(xpath = "//div[contains(@class,'LearningCatalogibm_cardRow')]/div//a")
	List<WebElement> ProgramsShowmore;//ibm
	
	@FindBy(xpath = "//div[contains(@class,'LearningCatalogibm_cardRow')]/div//a")
	List<WebElement> Programs;//ibm
	
	@FindBy(xpath = "//img[@id='scrollToTopCourse']//ancestor::button[contains(text(),'Show more')]")
	List<WebElement> CoursesShowmore;//ibm
	
	@FindBy(xpath = "//img[@id='scrollToTopCourse']//ancestor::button[contains(text(),'Show less')]")
	List<WebElement> CoursesShowless;//ibm
	
	@FindBy(xpath = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[contains(@class,'row')]/descendant::div[contains(@class,'LearningCatalog_cardRow')]//a")
	List<WebElement> Courses;//ibm
	
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
	
	public ArrayList<String> checkMetaTags()
	{
		ArrayList<String> status = new ArrayList<String>();
		
		HashMap<String, List<WebElement>> metaTags = new HashMap<String, List<WebElement>>();
		metaTags.put("ogTypeInfo", ogType);
		
		  metaTags.put("ogURLInfo", ogURL); metaTags.put("ogTitleInfo", ogTitle);
		  metaTags.put("ogDesciptionInfo", ogDescription); metaTags.put("ogImageInfo",
		  ogImage); metaTags.put("twitterURLInfo", twitterURL);
		  metaTags.put("twitterCardInfo", twitterCard);
		  metaTags.put("twitterTitleInfo", twitterTitle);
		  metaTags.put("twitterDescriptionInfo", twitterDescription);
		  metaTags.put("twitterImageInfo", twitterImage);
		 
		
		
		try
		{
			
			for (Map.Entry<String, List<WebElement>> tag : metaTags.entrySet())
			{
				if (tag.getValue().size() > 0)
				{
					 String key = tag.getKey();
					String value = tag.getValue().get(0).getAttribute("content");
					if (value != null && value != "")
					{
						System.out.println("✅ Meta tag is present and content is present" + key);
					} 
					else 
					{
						status.add("Meta tag is not present" +key);
					}
				}
			}
			/*
			 * { if(tag.size()>0) { String value = tag.get(0).getAttribute("content");
			 * if(value != null && value != "") {
			 * System.out.println("✅ Meta tag is present and content is present"); } else {
			 * status.add("Meta tag is not present"); } } }
			 */
			
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
			status.add("issue on meta tags - fail");
		}
		return status;
	}
	
	public String FAQ()
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
				status = "FAQ Schema is not present";
			}

	    } 
		catch (Exception e)
		{
	            System.out.println("❌ Error: " + e.getMessage());
	            status ="issue on faq schema - fail";
		}
		return status;
	}
	
	public String courseSchema()
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
                status = "Course Schema is not present";
            }

	    } 
		catch (Exception e)
		{
	            System.out.println("❌ Error: " + e.getMessage());
	            status = "issue on course schema - fail";
		}
		return status;
	}

	public String checkH1Tag(WebElement locator)
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
				status="H1 Tag is not present";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			status = "issue on H1 tag - fail";
		}
		return status;
	}
	
	public static boolean validateSchema(WebDriver driver, String courseSchemaScriptLocator, String expectedType) 
	{
		String status = "";
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
			status = "issue on validating courseschema and faq schema process - fail";
		}
		return false;
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
						checkValidationPage = false;
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
			e.printStackTrace();
			status.add("issue on opening page - fail");
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
				//landing on partner page and checking programs cards
				if(Programs.size()>0)
				{
					List<WebElement> programs = Programs;
					for(WebElement program : programs)
					{
						String programURL = program.getAttribute("href");
						status.addAll(this.openPage(programURL));
						if (!status.contains("fail"))
						{
							
							status.add(this.FAQ());
							status.add(this.courseSchema());
							status.add(this.checkH1Tag(H1TagForCategoryProgramsAndCourses));
							status.addAll(this.checkMetaTags());
							driver.close();
							driver.switchTo().window(validationPage);
							checkValidationPage = true;
						}
					}
				}
				checkValidationPage = true;
			}
			else
			{
				status.add("program cards are not present");
			}
			checkValidationPage = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("issue on partner programs - fail");
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
				//show more button verification for courses
				while (CoursesShowmore.size() > 0)
				{
					List<WebElement> showMore = CoursesShowmore;
						for (WebElement show : showMore)
						{
							js.executeScript("arguments[0].scrollIntoView();", show);
							js.executeScript("arguments[0].click();", show);
							if(CoursesShowless.size()>0)
							{
								break;
							}
						}
				}
				//course card  verification
				if(Courses.size()>0)
				{
					List<WebElement> courses = Courses;
					for(WebElement course : courses)
					{
						String courseURL = course.getAttribute("href");
						status.addAll(this.openPage(courseURL));
						if (!status.contains("fail"))
						{
							status.add(this.FAQ());
							status.add(this.courseSchema());
							status.add(this.checkH1Tag(H1TagForCategoryProgramsAndCourses));
							status.addAll(this.checkMetaTags());
							driver.close();
							driver.switchTo().window(validationPage);
							checkValidationPage = true;
							checkHomePage = false;
							}
					}
				}
				else
				{
					status.add("course cards are not present");
					checkValidationPage = false;
					
				}
				
			}
			else
			{
				status.add("issue on partner page - fail");
				
			}
			checkPageStatus = false;
			driver.close();
			driver.switchTo().window(parentWindow);
			checkHomePage = false;
			checkValidationPage = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("issue on partner courses - fail");
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
				status.add(this.FAQ());
				status.add(this.courseSchema());
				status.add(this.checkH1Tag(IBMH1Tag));
				status.addAll(this.checkMetaTags());
			}
			if (!checkPageStatus) 
			{
				driver.close();
				driver.switchTo().window(parentWindow);
			}
			
				
		}
		catch(Exception e)
        {
            e.printStackTrace();
            status.add("issue on IBM partner page - fail");
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
			e.printStackTrace();
			status.add("issue on partner programs - fail");
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
			e.printStackTrace();
			status.add("issue on partner programs - fail");
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
			e.printStackTrace();
			status.add("issue on partner programs - fail");
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
			e.printStackTrace();
			status.add("issue on partner programs - fail");
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
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(MicrosoftH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
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
			
			if(checkPageStatus)
			{
				//landing on partner page and checking programs cards
				if(Programs.size()>0)
				{
					List<WebElement> programs = Programs;
					for(WebElement program : programs)
					{
						String programURL = program.getAttribute("href");
						status.addAll(this.openPage(programURL));
						if (!status.contains("fail"))
						{
							
							status.add(this.FAQ());
							status.add(this.courseSchema());
							status.add(this.checkH1Tag(H1TagForCategoryProgramsAndCourses));
							status.addAll(this.checkMetaTags());
							driver.close();
							driver.switchTo().window(validationPage);
							checkValidationPage = true;
						}
					}
				}
				checkValidationPage = true;
			}
			else
			{
				status.add("program cards are not present");
			}
			checkValidationPage = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("issue on IBM partner programs - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	public ArrayList<String> checkMicrosoft_PartnerPage_Courses()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(checkPageStatus)
			{
				//show more button verification for courses
				while (CoursesShowmore.size() > 0)
				{
					List<WebElement> showMore = CoursesShowmore;
						for (WebElement show : showMore)
						{
							js.executeScript("arguments[0].scrollIntoView();", show);
							js.executeScript("arguments[0].click();", show);
							if(CoursesShowless.size()>0)
							{
								break;
							}
						}
				}
				//course card  verification
				if(Courses.size()>0)
				{
					List<WebElement> courses = Courses;
					for(WebElement course : courses)
					{
						String courseURL = course.getAttribute("href");
						status.addAll(this.openPage(courseURL));
						if (!status.contains("fail"))
						{
							status.add(this.FAQ());
							status.add(this.courseSchema());
							status.add(this.checkH1Tag(H1TagForCategoryProgramsAndCourses));
							status.addAll(this.checkMetaTags());
							driver.close();
							driver.switchTo().window(validationPage);
							checkValidationPage = true;
							checkHomePage = false;
							}
					}
				}
				else
				{
					status.add("course cards are not present");
					checkValidationPage = false;
					
				}
				
			}
			else
			{
				status.add("issue on IBM partner page - fail");
				
			}
			checkPageStatus = false;
			driver.close();
			driver.switchTo().window(parentWindow);
			checkHomePage = false;
			checkValidationPage = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("issue on IBM partner courses - fail");
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	public ArrayList<String> checkGoogleCloud_PartnerPage(String data) 
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "googleCloud_PartnerPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(googleCloudH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkPLU_PartnerPage(String data) 
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "PLU_PartnerPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(PLUH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkFutureSkill_PartnerPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "FutureSkill_PartnerPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
            {
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(FutureSkillH1Tag));
			status.addAll(this.checkMetaTags());
            }
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}

	
	public ArrayList<String> AI_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "AI_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkAzure_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "Azure_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkBigData_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "BigData_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkBlockchain_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "Blockchain_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkBusinessApplication_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "BusinessApplication_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkCloudComputing_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "CloudComputing_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkCompliancePOSH_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "CompliancePOSH_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkCybersecurity_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "Cybersecurity_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> BusinessApplication_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "BusinessApplication_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkDataAnalytics_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "DataAnalytics_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkDataScience_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "DataScience_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkDevOps_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "DevOps_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkHumanSkills_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "HumanSkills_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkIOT_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "IOT_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status.stream()
                .filter(s -> s != null && !s.trim().isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> checkModernWorkplace_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "ModernWorkplace_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> checkPowerBI_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "PowerBI_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> checkPowerPlatform_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "PowerPlatform_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> checkProductivity_CategoryPage(String data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String testcase = "Productivity_CategoryPage";
		try 
		{
			status.addAll(this.openPage(data));
			if(!status.contains("fail"))
			{
			status.add(this.FAQ());
			status.add(this.courseSchema());
			status.add(this.checkH1Tag(categoryH1Tag));
			status.addAll(this.checkMetaTags());
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
}
