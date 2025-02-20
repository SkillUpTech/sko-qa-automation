package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
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

public class CourseLevelLocators
{
	WebDriver driver;
	
	@FindBy(xpath = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]")
	private List<WebElement> programCardSection;
	
	@FindBy(xpath = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show more')]")
	private List<WebElement> programCardShowmoreLocator;
	
	@FindBy(xpath = "")
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
	
	String programCardCourseStartedDate = ".//div[contains(@class,'FlatCourseCard_courseStartSection')]//h6[contains(text(),'Course start')]/following-sibling::h4";
	
	
	String programCardPriceSection = ".//div[contains(@class,'FlatCourseCard_priceSection')]";
	
	String ProgramCardsPrice = ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3";
	
	String programPageLocator = "//section[contains(@class,'CourseDescription_mainSection')]";
	
	String programPageName = ".//h1";
	
	String programPageLevel1 = ".//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//div[contains(@class,'CourseDescription_levelSection')]//p[1]|//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//h2";
	
	String  programPageLevel2 = ".//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//div[contains(@class,'CourseDescription_levelSection')]//p[3]|//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//h3[1]";
	
	String programPageLevel3 = ".//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//div[contains(@class,'CourseDescription_levelSection')]//p[5]|//div[contains(@class,'CourseDescription_levelsAndShareContainer')]//h3[2]";
	
	String programPagePartner = ".//img[@alt='Skillup']";
	
	String programPageEnrollStatus = ".//button[contains(@class,'CourseDescription_enrollNowBtn')]|//div[contains(@class,'CourseDescription_buttonsContent')]/h6";
	
	
	String programPageDurationSection = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]";
	
	
	String ProgramPageSelfOrVilt = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//h2[contains(text(),'Starts on')]";
	
	String programPagePrice = ".//div[contains(@class,'CourseDescription_durationAndPriceSection')]//h2[contains(text(),'Fee')]/following-sibling::p";
	//***********************************************************************************************************************************************
	String courseCardSection = "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]|//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]";
	
	@FindBy(xpath =  "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//button[contains(text(),'Show more')]|//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//button[contains(text(),'Show more')]")
	private List<WebElement> CourseCardShowmoreLocator;
	
	@FindBy(xpath = "")
	private List<WebElement> CourseCards;
	 
	
	
	
	@FindBy(xpath = "//div[contains(@class,'TechCategories_exCollaborationInner')]/ul/li/a")
	private List<WebElement> CategoriesListFromHomePage;
	
	String courseCardURL = ".//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a";
	
	String CourseCardsName = ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p";
	
	String CourseCardLevelSection = ".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul";
	
	String CourseCardsLevel1 = ".//div[contains(@class,'RegularCourseCard_courseDes')]//ul/li[1]";
	
	String CourseCardsLevel2 = ".//div[contains(@class,'RegularCourseCard_courseDes')]//ul/li[2]";
	
	String CourseCardsLevel3 = ".//div[contains(@class,'RegularCourseCard_courseDes')]//ul/li[3]";
	
	String CourseCardsPartner = ".//div[contains(@class,'RegularCourseCard_courseCompany')]";
	
	String courseEnrollmentSection = ".//div[contains(@class,'RegularCourseCard_priceSection')]//div[contains(@class,'RegularCourseCard_priceLeft')]";
	
	String CourseCardsEnrollStatus = ".//div[contains(@class,'RegularCourseCard_priceSectionInner')]//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Enrollment Status')]/following-sibling::p";
	
	String courseCardCourseStartedDate = ".//div[contains(@class,'RegularCourseCard_priceSectionInner')]//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Course')]/following-sibling::p";
	
	String CourseCardsPrice = ".//div[contains(@class,'RegularCourseCard_priceRight')]//h2[contains(text(),'From')]/following-sibling::p";
	
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
	
	String CoursePagePrice = ".//div[contains(@class,'CourseDescription_courseAboutTextSection')]/h2[contains(text(),'Fee')]/following-sibling::p|//div[contains(@class,'CourseDescription_courseAboutTextSection')]/h2[contains(text(),'From')]/following-sibling::p";
	
	
	
	String parentWindow = "";
	
	public CourseLevelLocators(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ArrayList<String> checkSelfPacedVILTOnHomePage()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try
		{
			parentWindow = driver.getWindowHandle();
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
			if(driver.findElements(By.xpath("//section[contains(@class,'Courses_mainSection')]//div[@id='learningCatalog2']//div[contains(@class,'LearningCatalog_cardRow')]/div")).size()>0)////section[contains(@class,'Courses_mainSection')]/div/div[@class='row'][2]//div[contains(@class,'LearningCatalog_browserCard')]
			{
				List<WebElement> courseCards = driver.findElements(By.xpath("//section[contains(@class,'Courses_mainSection')]//div[@id='learningCatalog2']//div[contains(@class,'LearningCatalog_cardRow')]/div"));
				for(int i = 0; i < courseCards.size(); i++)
				{
					if(courseCards.size()>0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						WebElement checkCourseCardLevel = courseCards.get(i).findElement(By.xpath(".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li[1]"));
						js.executeScript("arguments[0].scrollIntoView();", checkCourseCardLevel);
						if(checkCourseCardLevel.getText().contains("Self-Paced"))
						{
							System.out.println("self paced course card");
							
							//parentWindow = driver.getWindowHandle();
							WebElement cardLink = checkCourseCardLevel.findElement(By.xpath(".//ancestor::a"));
							String url = cardLink.getAttribute("href");
							js.executeScript("arguments[0].scrollIntoView();", cardLink);
							if(cardLink.isDisplayed())
							{
								String urlStatus = this.checkURLStatus(url);
								if(!urlStatus.contains("fail"))
								{
									driver.switchTo().newWindow(WindowType.TAB);
									driver.get(url);
									Set<String> allWindow = driver.getWindowHandles();
									for(String window : allWindow)
									{
										driver.switchTo().window(window);
										if(driver.getCurrentUrl().contains("courses"))
										{
											driver.switchTo().window(window);
											List<WebElement> checkStartDate = driver.findElements(By.xpath("//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[@class='d-flex gap-2']//h2"));
											for(int j = 0; j < checkStartDate.size(); j++)
											{
												if(checkStartDate.size()>0)
												{
													js.executeScript("arguments[0].scrollIntoView();", checkStartDate.get(j));
													if(checkStartDate.get(j).getText().contains("Starts on"))//self paced  level data validation
													{
														status.add(url);
														System.out.println("starts on date presented for Self paced course");
														driver.close();
														driver.switchTo().window(parentWindow);
														break;
													}
													else
													{
														System.out.println("starts on date not presented for Self paced course");
														driver.close();
														driver.switchTo().window(parentWindow);
														break;
													}
												}
												else
												{
													System.out.println("no levels on page");
													driver.close();
													driver.switchTo().window(parentWindow);
													break;
												}
												
											}
										}
									}
								}
								else
								{
									System.out.println("url facing issue : "+url);
									status.add(url + ": Issue in url");
									driver.close();
									driver.switchTo().window(parentWindow);
									break;
								}
							}
						}
					}
					else
					{
						System.out.println("no course card on homepage");
					}
					
				}
			}
		
			if(driver.findElements(By.xpath("//section[contains(@class,'Courses_mainSection')]/div/div[@class='row'][2]//div[contains(@class,'LearningCatalog_browserCard')]")).size()>0)
			{
					List<WebElement> courseCards = driver.findElements(By.xpath("//section[contains(@class,'Courses_mainSection')]/div/div[@class='row'][2]//div[contains(@class,'LearningCatalog_browserCard')]"));
					for(int i = 0; i < courseCards.size(); i++)
					{
						if(courseCards.size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
							WebElement checkCourseCardLevelVILT = courseCards.get(i).findElement(By.xpath(".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li[1]"));
							js.executeScript("arguments[0].scrollIntoView();", checkCourseCardLevelVILT);
						if(checkCourseCardLevelVILT.getText().contains("vILT")||checkCourseCardLevelVILT.getText().contains("Instructor-Led"))
						{
							System.out.println("VILT paced course card");
						String parentWindow = driver.getWindowHandle();
						WebElement VILTcardLink = checkCourseCardLevelVILT.findElement(By.xpath(".//ancestor::a"));
						String url = VILTcardLink.getAttribute("href");
						js.executeScript("arguments[0].scrollIntoView();", VILTcardLink);
						if(VILTcardLink.isDisplayed())
						{
							String urlStatus = this.checkURLStatus(url);
							
							if(!urlStatus.contains("fail"))
							{
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(url);
							Set<String> allWindow = driver.getWindowHandles();
							for(String window : allWindow)
							{
								driver.switchTo().window(window);
								if(driver.getCurrentUrl().contains("courses"))
								{
									driver.switchTo().window(window);
									if(driver.findElements(By.xpath("//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[@class='d-flex gap-2'][1]//h2")).size()>0)
									{
										System.out.println("starts on date not presented for Blended course may be invite only vourse");
										driver.close();
										driver.switchTo().window(parentWindow);
										break;
									}
									else
									{
										WebElement checkStartDate = driver.findElement(By.xpath("//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[@class='d-flex gap-2'][1]//h2"));
										js.executeScript("arguments[0].scrollIntoView();", checkStartDate);
										
										if(!checkStartDate.getText().contains("Starts on"))
										{
											System.out.println("starts on date not presented for VILT course");
											status.add(url+" : starts on date not presented for VILT course");
											driver.close();
											driver.switchTo().window(parentWindow);
											break;
										}
									}
									}
								}
							}
						}
						else
						{
							System.out.println("url facing issue : "+url);
							status.add(url+" : issue on url");
							driver.close();
							driver.switchTo().window(parentWindow);
							break;
						}
						}
					}
				}
			}
			if(driver.findElements(By.xpath("//section[contains(@class,'Courses_mainSection')]/div/div[@class='row'][2]//div[contains(@class,'LearningCatalog_browserCard')]")).size()>0)
			{
					List<WebElement> courseCards = driver.findElements(By.xpath("//section[contains(@class,'Courses_mainSection')]/div/div[@class='row'][2]//div[contains(@class,'LearningCatalog_browserCard')]"));
					for(int i = 0; i < courseCards.size(); i++)
					{
						if(courseCards.size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
							WebElement checkCourseCardLevelBlended = courseCards.get(i).findElement(By.xpath(".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li[1]"));
							js.executeScript("arguments[0].scrollIntoView();", checkCourseCardLevelBlended);
					if(checkCourseCardLevelBlended.getText().contains("BLENDED"))
					{
						System.out.println("Blended  course card");
						String parentWindow = driver.getWindowHandle();
						WebElement BlendedcardLink = checkCourseCardLevelBlended.findElement(By.xpath(".//ancestor::a"));
						String url = BlendedcardLink.getAttribute("href");
						js.executeScript("arguments[0].scrollIntoView();", BlendedcardLink);
						if(BlendedcardLink.isDisplayed())
						{
							String urlStatus = this.checkURLStatus(url);
							
							if(!urlStatus.contains("fail"))
							{
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(url);
							Set<String> allWindow = driver.getWindowHandles();
							for(String window : allWindow)
							{
								driver.switchTo().window(window);
								if(driver.getCurrentUrl().contains("courses"))
								{
									driver.switchTo().window(window);
									if(driver.findElements(By.xpath("//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[@class='d-flex gap-2'][1]//h2")).size()>0)
									{
										System.out.println("starts on date not presented for Blended course may be invite only vourse");
										driver.close();
										driver.switchTo().window(parentWindow);
										break;
									}
									else
									{
										WebElement checkStartDate = driver.findElement(By.xpath("//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[@class='d-flex gap-2'][1]//h2"));
										js.executeScript("arguments[0].scrollIntoView();", checkStartDate);
										
										if(!checkStartDate.getText().contains("Starts on")||checkStartDate.getText().contains("Starts on"))
										{
											System.out.println("starts on date not presented for Blended course");
											status.add(url+" : starts on date not presented for Blended course");
											driver.close();
											driver.switchTo().window(parentWindow);
											break;
										}
									}
									}
								}
							}
						}
						else
						{
							System.out.println("url facing issue : "+url);
							status.add(url+" : issue on url");
							driver.close();
							driver.switchTo().window(parentWindow);
							break;
						}
						}
					}
				}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	
	public String checkURLStatus(String data)
	{
		  String status = "";
	        HttpURLConnection connection = null;
			 try 
			 {
				 URL url = new URI(data).toURL();
				 connection = (HttpURLConnection)  url.openConnection();
		            connection.setRequestMethod("GET");
		            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		            connection.connect();
		            int responseCode = connection.getResponseCode();
		            System.out.println("Status code: " + responseCode + " URL: " + data);
		            if (responseCode >= 400 && responseCode <= 405 || responseCode == 410 || responseCode == 429 || responseCode >=500 && responseCode <= 505) 
		            {
		                System.out.println("Broken link: " + data);
		                status = "fail " + responseCode;
		            } 
		            else 
		            {
		                System.out.println("Unbroken link: " + data + " " + responseCode);
		                status = "success" + responseCode;
		            }
		        } 
			 catch (Exception e) 
			 {
				 System.out.println("Exception occurred while validating the URL: " + data);
		            e.printStackTrace();
		            status = "fail Exception";
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
	
	public ArrayList<String> checkSelfPacedVILTForProgramCardsOnCategory()
	{
		String locateProgramCards = "";
		
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
			parentWindow = driver.getWindowHandle();
			
			if(CategoriesListFromHomePage.size()>0)
			{
				List<WebElement> categoriesList = CategoriesListFromHomePage;
				for(WebElement category : categoriesList)
				{
					String getCategoryURL = category.getAttribute("href");
					String getCategoryName = category.getText();
					if (!(getCategoryName.contains("Azure") ||
						      getCategoryName.contains("Business Applications") ||
						      getCategoryName.contains("Blockchain") ||
						      getCategoryName.contains("Compliance-POSH") ||
						      getCategoryName.contains("Human Skills") ||
						      getCategoryName.contains("Internet of Things (IoT)")||
						      getCategoryName.contains("Modern workspace")||
						      getCategoryName.contains("Power Platform")||
						      getCategoryName.contains("Productivity")||
						      getCategoryName.contains("Power BI")))
					{
						
						locateProgramCards = "//section[contains(@class,'Courses_mainSection')]/div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//div[contains(@class,'LearningCatalog_cardRow')]/div";
					}
					
					System.out.println("program card verification started in : "+getCategoryName);
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(getCategoryURL);
					
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
					
					String categoryWindow = driver.getWindowHandle();
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					if (programCardShowmoreLocator.size() > 0)
					{ // Check if the "Show More" button is present
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
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					if(driver.findElements(By.xpath(locateProgramCards)).size()>0)
					{
						List<WebElement> programCards = driver.findElements(By.xpath(locateProgramCards));    
						
						for(WebElement card : programCards)
						{
							js.executeScript("arguments[0].scrollIntoView();", card);
							
							String programCardName = card.findElement(By.xpath(ProgramCardsName)).getText();
							
							String getProgramCardURL = card.findElement(By.xpath(programCardsURL)).getAttribute("href");
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if(card.findElements(By.xpath(programCardsImage)).size()<=0)
							{
								status.add("image not present in " +programCardName);
							}
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if(card.findElements(By.xpath(ProgramCardsPartner)).size()<=0)
							{
								status.add("partner name not present in "+programCardName);
							}
							
							
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if(card.findElements(By.xpath(programCardLevelSection)).size()>0)
							{
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (card.findElements(By.xpath(ProgramCardsLevel1)).size() > 0)
								{
									String cardLevel1 = card.findElement(By.xpath(ProgramCardsLevel1)).getText();
									cardLevelStatus.add(cardLevel1);
								}
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (card.findElements(By.xpath(ProgramCardsLevel2)).size() > 0)
								{
									String cardLevel2 = card.findElement(By.xpath(ProgramCardsLevel2)).getText();
									cardLevelStatus.add(cardLevel2);
								}
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (card.findElements(By.xpath(ProgramCardsLevel3)).size() > 0)
								{
									String cardLevel3 = card.findElement(By.xpath(ProgramCardsLevel3)).getText();
									cardLevelStatus.add(cardLevel3);
								}
							}
							else
							{
								status.add("level section not present in "+programCardName);
							}
							
							
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
							if (card.findElements(By.xpath(ProgramCardsPrice)).size() <= 0)
							{
								cardPriceStatus.add("price not present in " +programCardName);
							}
							else
							{
								String cardPrice = card.findElement(By.xpath(ProgramCardsPrice)).getText();
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
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (card.findElements(By.xpath(ProgramCardsEnrollStatus)).size() > 0)
								{
									WebElement enrollButton = card.findElement(By.xpath(ProgramCardsEnrollStatus));
									js.executeScript("arguments[0].scrollIntoView();", enrollButton);
									String cardEnrollStatus = enrollButton.getText();
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
									else if(cardEnrollStatus.contains("Closed"))
									{
										cardEnrollmentStatus.add("Closed");
									}
									else
									{
										cardEnrollmentStatus.add("Closed");
									}
								}
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if(card.findElements(By.xpath(programCardCourseStartedDate)).size() > 0)
								{
									WebElement getStatus = card.findElement(By.xpath(programCardCourseStartedDate));
								
									js.executeScript("arguments[0].scrollIntoView();", getStatus);
									String cardEnrollStartDateStatus = getStatus.getText();
									
									if(cardEnrollStartDateStatus.contains("Course started on"))
									{
										cardEnrollmentStatus.add("Open");
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
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
							
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (programPageSection.findElements(By.xpath(programPageName)).size() <= 0)
								{
									status.add("program name not present in this card page  " + programCardName);
								}
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
								if (programPageSection.findElements(By.xpath(programPageLevel1)).size() > 0)
								{
									String level1 = programPageSection.findElement(By.xpath(programPageLevel1)).getText();
									pageLevelStatus.add(level1);
								}
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (programPageSection.findElements(By.xpath(programPageLevel2)).size() > 0) 
								{
									String level2 = programPageSection.findElement(By.xpath(programPageLevel2)).getText();
									pageLevelStatus.add(level2);
								}
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (programPageSection.findElements(By.xpath(programPageLevel3)).size() > 0) 
								{
									String level3 = programPageSection.findElement(By.xpath(programPageLevel3)).getText();
									pageLevelStatus.add(level3);
								}
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (programPageSection.findElements(By.xpath(programPagePartner)).size() <= 0)
								{
									status.add("partner name not present in this card page  " + programCardName);
								}
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (programPageSection.findElements(By.xpath(programPageEnrollStatus)).size() <= 0) 
								{
									status.add("enroll status not present in this card page  " + programCardName);
								}
								else
								{
									WebElement enrollButton = programPageSection.findElement(By.xpath(programPageEnrollStatus));
									js.executeScript("arguments[0].scrollIntoView();", enrollButton);
									String getPageEnrollStatus = enrollButton.getText();
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
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
											//String getDurationText = programPageSection.findElement(By.xpath(ProgramPageSelfOrVilt)).getText(); //Starts on
											
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
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								if (programPageSection.findElements(By.xpath(programPagePrice)).size() <= 0) 
								{
									status.add("price  not present in this card page  " + programCardName);
								}
								else
								{
									String getPagePrice = programPageSection.findElement(By.xpath(programPagePrice)).getText();
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
							}
						}
							cardLevelStatus.clear();
							cardPriceStatus.clear();
							cardEnrollmentStatus.clear();
							pageLevelStatus.clear();
							pagePriceStatus.clear();
							pageEnrollmentStatus.clear();
						driver.close();
						driver.switchTo().window(categoryWindow);
						}
					}
					else
					{
						System.out.println("Program cards are not available in "+getCategoryName);
					}
					
					driver.close();
					driver.switchTo().window(parentWindow);
					System.out.println("program card verification completed from : "+getCategoryName);
			}
			}
			else
			{
				System.out.println("no categories on homepage");
			}
			
			
			
			
			
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("exception");
		}
		return status;
	}

	public ArrayList<String> checkCourseCardOnCategory()
	{
		String locateCourseCards = "";
		ArrayList<String> status = new ArrayList<String>();
		ArrayList<String> cardLevelStatus = new ArrayList<String>();
		ArrayList<String> cardPriceStatus = new ArrayList<String>();
		ArrayList<String> cardEnrollmentStatus = new ArrayList<String>();
		ArrayList<String> pageLevelStatus = new ArrayList<String>();
		ArrayList<String> pagePriceStatus = new ArrayList<String>();
		ArrayList<String> pageEnrollmentStatus = new ArrayList<String>();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try
		{
			
			parentWindow = driver.getWindowHandle();
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			 js.executeScript("window.scrollBy(0, 4000);"); 
			 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 
			 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			 
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			if(CategoriesListFromHomePage.size()>0)
			{
				List<WebElement> categoriesList = CategoriesListFromHomePage;
				for(WebElement category : categoriesList)
				{
					wait.until(ExpectedConditions.visibilityOf(category));
					String getCategoryURL = category.getAttribute("href");
					String getCategoryName = category.getText();
					
					
					if(getCategoryName.contains("Artificial Intelligence")|getCategoryName.contains("BigData")|getCategoryName.contains("Blockchain")|getCategoryName.contains("Data Science")|getCategoryName.contains("Human Skills")|getCategoryName.contains("Internet of Things (IoT)"))//AI, BigData, blockchain, Data science, human skill, IOT
					{
						locateCourseCards = "//section[contains(@class,'Courses_mainSection')]/div[contains(@class,'container-fluid Courses_containerInner')]/div[6]//div[contains(@class,'LearningCatalog_cardRow')]/div|\r\n"
								+ "//div[contains(@id,'learningCatalogCourses')]/div[2]/div[3]/div[contains(@class,'LearningCatalog_cardRow')]/div|\r\n"
								+ "//section[contains(@class,'Courses_mainSection')]/div[contains(@class,'container-fluid Courses_containerInner')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]/div|\r\n"
								+ "//section[contains(@class,'Courses_mainSection')]//div[@id='learningCatalog']/div[2]/div[3]/div[contains(@class,'LearningCatalog_cardRow')]/div|\r\n"
								+ "//section[contains(@class,'Courses_mainSection')]/div[contains(@class,'container-fluid Courses_containerInner')]/div[@id='learningCatalogCourses']/div[2]/div[3]/div[contains(@class,'LearningCatalog_cardRow')]/div";
					}
					else if(getCategoryName.contains("Azure")|getCategoryName.contains("Business Application")|getCategoryName.contains("Modern workspace")|getCategoryName.contains("power Bi")|getCategoryName.contains("productivity"))//Azure, Business Application,Modern workspace, power Bi, productivity
					{
						locateCourseCards = "//section[contains(@class,'Courses_mainSection')]/div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//div[contains(@class,'LearningCatalog_cardRow')]/div";
					}
					else if(getCategoryName.contains("cloud computing")|getCategoryName.contains("cybersecurity")|getCategoryName.contains("Data analytics")|getCategoryName.contains("Devops"))//cloud computing, cybersecurity, Data analytics, Devops
					{
						locateCourseCards = "//section[contains(@class,'Courses_mainSection')]/div[contains(@class,'container-fluid Courses_containerInner')]/div[6]//div[contains(@class,'LearningCatalog_cardRow')]/div|//div[contains(@id,'learningCatalogCourses')]/div[2]/div[3]/div[contains(@class,'LearningCatalog_cardRow')]/div|//section[contains(@class,'Courses_mainSection')]/div[contains(@class,'container-fluid Courses_containerInner')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]/div";
					}
					System.out.println("course card verification started in : "+getCategoryName);
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(getCategoryURL);
					
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					
					String categoryWindow = driver.getWindowHandle();
					js.executeScript("window.scrollBy(0, 2000);"); 
					
					//wait.until(ExpectedConditions.visibilityOfAllElements(CourseCardShowmoreLocator));
					if (CourseCardShowmoreLocator.size() > 0)
					{ // Check if the "Show More" button is present
					    List<WebElement> showMore = CourseCardShowmoreLocator;

					    while (showMore.size() > 0) 
					    {
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
			//wait.until(ExpectedConditions.visibilityOfAllElements(CourseCards));
			if(driver.findElements(By.xpath(locateCourseCards)).size()>0)
			{
				List<WebElement> CourseCards = driver.findElements(By.xpath(locateCourseCards));		
				
				for(WebElement card : CourseCards)
				{
					wait.until(ExpectedConditions.visibilityOf(card));
					
					js.executeScript("arguments[0].scrollIntoView();", card);
					
					String courseCardName = card.findElement(By.xpath(CourseCardsName)).getText();
					
					String getCourseCardURL = card.findElement(By.xpath(courseCardURL)).getAttribute("href");
					
					
					String courseCardImage = ".//img[@alt='"+courseCardName+"']";
					
					if(courseCardName.contains("MS-600: Building Applications and Solutions with Microsoft 365 Core Services")||courseCardName.contains("Google Cloud Infrastructure Fundamentals")||courseCardName.contains("Test Session")||courseCardName.contains("Test course Navjot")||courseCardName.contains("Growth Mindset for Professional Success")||courseCardName.contains("Executive Presence for Professional Success")||courseCardName.contains("Coaching Skills for Managers")||courseCardName.contains("Creating Impact and Presence in the Virtual World")||courseCardName.contains("Building Your Personal Brand")||courseCardName.contains("Exploring Spark's GraphX")||courseCardName.contains("Building Your Personal Brand"))
					{
						continue;
					}
					
					if(card.findElements(By.xpath(courseCardImage)).size()>0)
					{
						try 
						{
							WebElement locateCardImage = card.findElement(By.xpath(courseCardImage));
							js.executeScript("arguments[0].scrollIntoView();", locateCardImage);
							//    wait.until(ExpectedConditions.visibilityOf(locateCardImage));
						} 
						catch (Exception e)
						{
							status.add("image not present in " + courseCardName);
						}
					}
                    else
                    {
                    	status.add("image not present in " + courseCardName);
                    }
				    
					if(card.findElements(By.xpath(CourseCardsPartner)).size()>0)
					{
						try 
						{
							WebElement locateCardPartner = card.findElement(By.xpath(CourseCardsPartner));
							js.executeScript("arguments[0].scrollIntoView();", locateCardPartner);
							// wait.until(ExpectedConditions.visibilityOf(locateCardPartner));
						} 
						catch (Exception e)
						{
							status.add("image not present in " + courseCardName);
						}
					}
					else
					{
						status.add("image not present in " + courseCardName);
					}
					
					//wait.until(ExpectedConditions.visibilityOfAllElements(card.findElements(By.xpath(CourseCardLevelSection))));
				    try 
					 {
					        if (card.findElements(By.xpath(CourseCardLevelSection)).size() > 0) 
					        {
					        	if(card.findElements(By.xpath(CourseCardsLevel1)).size()>0)
					        	{
					        		try 
					        		{
					        			List<WebElement> locateCardLevel1 = card.findElements(By.xpath(CourseCardsLevel1));
					        			//  wait.until(ExpectedConditions.visibilityOfAllElements(locateCardLevel1));
					        			if (locateCardLevel1.size() > 0) 
					        			{
					        				String cardLevel1 = locateCardLevel1.get(0).getText();
					        				cardLevelStatus.add(cardLevel1);
					        			}
					        		} 
					        		catch (Exception e)
					        		{
					        			status.add("Level 1 not present in " + courseCardName);
					        		}
					        	}
					        	else
					        	{
					        		status.add("Level 1 not present in " + courseCardName);
					        	}
					        	
					        	if(card.findElements(By.xpath(CourseCardsLevel2)).size()>0)
					        	{
					        		try 
					        		{
					        			List<WebElement> locateCardLevel2 = card.findElements(By.xpath(CourseCardsLevel2));
					        			//  wait.until(ExpectedConditions.visibilityOfAllElements(locateCardLevel2));
					        			if (locateCardLevel2.size() > 0) 
					        			{
					        				String cardLevel2 = locateCardLevel2.get(0).getText();
					        				cardLevelStatus.add(cardLevel2);
					        			}
					        		} 
					        		catch (Exception e) 
					        		{
					        			status.add("Level 2 not present in " + courseCardName);
					        		}
					        	}
					        	else
					        	{
					        		status.add("Level 2 not present in " + courseCardName);
					        	}
					        	
					        	if(card.findElements(By.xpath(CourseCardsLevel3)).size()>0)
					        	{
					        		try
					        		{
					        			List<WebElement> locateCardLevel3 = card.findElements(By.xpath(CourseCardsLevel3));
					        			if (locateCardLevel3.size() > 0)
					        			{
					        				String cardLevel3 = locateCardLevel3.get(0).getText();
					        				cardLevelStatus.add(cardLevel3);
					        			}
					        		} 
					        		catch (Exception e)
					        		{
					        			status.add("Level 3 not present in " + courseCardName);
					        		}
					        	}
					        	else
					        	{
					        		status.add("Level 3 not present in " + courseCardName);
					        	}
					        }
					        else
					        {
					            status.add("Level section not present in " + courseCardName);
					        }
					 } 
					 catch (Exception e)
					 {
						 status.add("level section not present in "+courseCardName);
					 }
				    
				    
					
					//wait.until(ExpectedConditions.visibilityOfAllElements(card.findElements(By.xpath(CourseCardsPrice))));
					
				    try 
					 {
				    	WebElement locateCardPrice = card.findElement(By.xpath(CourseCardsPrice));
				     //   wait.until(ExpectedConditions.visibilityOf(locateCardPrice));
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
					 catch (Exception e)
					 {
						 cardPriceStatus.add("price not present in " +courseCardName);
					 }
				    
					

					try 
					{
					    List<WebElement> locateCardEnrollmentSection = card.findElements(By.xpath(CourseCardsEnrollStatus));
					//    wait.until(ExpectedConditions.visibilityOfAllElements(locateCardEnrollmentSection));
					    if (locateCardEnrollmentSection.size() > 0) 
					    {
					        String cardEnrollStatus = locateCardEnrollmentSection.get(0).getText();
					        if (cardEnrollStatus.contains("Open"))
					        {
					            cardEnrollmentStatus.add("Open");
					        } 
					        else
					        {
					            cardEnrollmentStatus.add("Closed");
					        }
					        System.out.println("card Enrollment status: " + cardEnrollStatus);
					    } 
					    if(card.findElements(By.xpath(courseCardCourseStartedDate)).size()>0)
                        {
                        	String cardEnrollStartDateStatus = card.findElement(By.xpath(courseCardCourseStartedDate)).getText();
                        	String cardEnrollStatus = cardEnrollStartDateStatus;
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
                            System.out.println("card Enrollment status: " + cardEnrollStatus);
                        }
					} 
					catch (Exception e) 
					{
					    cardEnrollmentStatus.add("enrollment section not present in " + courseCardName);
					}

					
					//********************************************************************************************
					
					String statusOfURL = checkURLStatus(getCourseCardURL);
					
					if(!statusOfURL.contains("fail") || !statusOfURL.contains("404") || !statusOfURL.contains("500"))
					{
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(getCourseCardURL);
					
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
					
					js.executeScript("window.scrollBy(0, 400);");
					String pageTitle = driver.getTitle();
					String currentUrl = driver.getCurrentUrl();
					
					if (currentUrl.contains("404"))
					{
					    status.add("404 page is present in this card page " + courseCardName);
					}
					else if (pageTitle.contains("null") || pageTitle.contains("undefined") || pageTitle.contains("500")) 
					{
					    status.add("null or undefined is present on page title " + courseCardName);
					}
					else
					{
						WebElement CoursePageSection = driver.findElement(By.xpath(CoursePageLocator));
						js.executeScript("arguments[0].scrollIntoView();", CoursePageSection);
						//wait.until(ExpectedConditions.visibilityOf(CoursePageSection));
						try
						{
							WebElement locateCoursePageName = CoursePageSection.findElement(By.xpath(CoursePageName));
							js.executeScript("arguments[0].scrollIntoView();", locateCoursePageName);
							//wait.until(ExpectedConditions.visibilityOf(locateCoursePageName));
								 
						}
						catch(Exception e)
						{
							status.add("course name not present in this course page " + courseCardName);
						}
						
						if(CoursePageSection.findElements(By.xpath(CoursePageLevel1)).size()>0)
						{
							try
							{
								WebElement locateCoursePageLevel1 = CoursePageSection.findElement(By.xpath(CoursePageLevel1));
								js.executeScript("arguments[0].scrollIntoView();", locateCoursePageLevel1);
								//	 wait.until(ExpectedConditions.visibilityOf(locateCoursePageLevel1));
								pageLevelStatus.add(locateCoursePageLevel1.getText());
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else
						{
							status.add("level 1 not present in this course page " + courseCardName);
						}
						
						if(CoursePageSection.findElements(By.xpath(CoursePageLevel2)).size()>0)
						{
							try
							{
								WebElement locateCoursePageLevel2 = CoursePageSection.findElement(By.xpath(CoursePageLevel2));
								js.executeScript("arguments[0].scrollIntoView();", locateCoursePageLevel2);
								//	 wait.until(ExpectedConditions.visibilityOf(locateCoursePageLevel2));
								pageLevelStatus.add(locateCoursePageLevel2.getText());
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else
						{
							status.add("level 2 not present in this course page " + courseCardName);
						}
						
						if(CoursePageSection.findElements(By.xpath(CoursePageLevel3)).size()>0)
						{
							try
							{
								WebElement locateCoursePageLevel3 = CoursePageSection.findElement(By.xpath(CoursePageLevel3));
								js.executeScript("arguments[0].scrollIntoView();", locateCoursePageLevel3);
								//	wait.until(ExpectedConditions.visibilityOf(locateCoursePageLevel3));
								pageLevelStatus.add(locateCoursePageLevel3.getText());
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						else
						{
							status.add("level 3 not present in this course page " + courseCardName);
                        }
						
						if(CoursePageSection.findElements(By.xpath(CoursePagePartner)).size()>0)
						{
							try
							{
								WebElement locateCoursePartner = CoursePageSection.findElement(By.xpath(CoursePagePartner));
								js.executeScript("arguments[0].scrollIntoView();", locateCoursePartner);
								//	wait.until(ExpectedConditions.visibilityOf(locateCoursePartner));
							}
							catch(Exception e)
							{
								status.add("partner name not present in this course page " + courseCardName);
							}
						}
						else
						{
							status.add("partner name not present in this course page " + courseCardName);
                        }
						try
						{
							Thread.sleep(500);
							  List<WebElement> locateCourseEnrolmentSection =  CoursePageSection.findElements(By.xpath(CoursePageEnrollmentSection));
							  js.executeScript("arguments[0].scrollIntoView();", locateCourseEnrolmentSection.get(0));
							 // wait.until(ExpectedConditions.visibilityOf(locateCourseEnrolmentSection.get(0)));
							  if(locateCourseEnrolmentSection.size()>0) 
							  {
							 
								WebElement locateCourseEnrollStatus = CoursePageSection.findElement(By.xpath(CoursePageEnrollStatus));
								js.executeScript("arguments[0].scrollIntoView();", locateCourseEnrollStatus);
								/*
								 * wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(
								 * locateCourseEnrollStatus),
								 * ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath(
								 * CoursePageEnrollStatus), "Loading...")) ));
								 */
								
									/*
									 * boolean isStatusUpdated = new WebDriverWait(driver, Duration.ofSeconds(30))
									 * // Adjust the timeout as needed .until(driver -> { String statusText =
									 * locateCourseEnrollStatus.getText(); System.out.println("Current Status: " +
									 * statusText); // Log the current status for debugging return
									 * !statusText.equalsIgnoreCase("Loading...") && !statusText.isEmpty(); });
									 */

									    // If status is updated, fetch the final text
										/*
										 * if (isStatusUpdated) {
										 */
									
									String getPageEnrollStatus = locateCourseEnrollStatus.getText();
									System.out.println("Course Enroll Status: " + getPageEnrollStatus);
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
										pageEnrollmentStatus.add("Open");
									}
									else
									{
										pageEnrollmentStatus.add("Closed");
									}
									try
									{
										if (cardEnrollmentStatus.size() == pageEnrollmentStatus.size())
										{
											if(!cardEnrollmentStatus.get(0).toLowerCase().equals(pageEnrollmentStatus.get(0).toLowerCase()))
											{
												status.add("enrollment status are not matching in card page and course page  "
														+ courseCardName);
											} 
											
										}
										System.out.println("verified enrollment status");
										
									}
									catch(Exception e)
									{
										status.add("enrollment status are not available in card page and course page  "
												+ courseCardName);
									}
								//}
							 }
						}
						catch(Exception e)
						{
							status.add("enroll status not present in this course page " + courseCardName);
						}
						
						
						
						
						
						try
						{
							List<WebElement> locateCourseDurationStatus = CoursePageSection.findElements(By.xpath(CoursePageDurationSection));
							if(locateCourseDurationStatus.size()>0)
							{

								if(cardLevelStatus.size() == pageLevelStatus.size())
								{
									if ((cardLevelStatus.get(0).toLowerCase()).equals(pageLevelStatus.get(0).toLowerCase()))
									{
										
										if(pageLevelStatus.get(0).toLowerCase().contains("self"))//self paced
										{
											if(CoursePageSection.findElements(By.xpath(CoursePageSelfOrVilt)).size()>0)
											{
												status.add("starts on presented on self paced course page  " + courseCardName);
											}
										}
										else if(pageLevelStatus.get(0).toLowerCase().contains("vilt")||pageLevelStatus.get(0).toLowerCase().contains("instructor-led"))//Instructor-Led
										{
											if(CoursePageSection.findElements(By.xpath(CoursePageSelfOrVilt)).size()<=0)
											{
												status.add("starts on not presented on Vilt course page  " + courseCardName);
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
						}
						catch(Exception e)
						{
							status.add("duration fee section not present in this course page  " + courseCardName);
						}
						
						try
						{
							List<WebElement> locateCoursePagePriceSection = CoursePageSection.findElements(By.xpath(CoursePagePrice));
							if(locateCoursePagePriceSection.size()>0)
							{
								WebElement pElement = CoursePageSection.findElement(By.xpath(CoursePagePrice));
								String fullText = pElement.getText();
								// Split text and extract only the desired part
								String requiredText = fullText.replace(pElement.findElement(By.tagName("span")).getText(), "").trim();
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
								if (!cardPriceStatus.equals(pagePriceStatus))
								{
								    status.add("price status are not matching in card page and course page " + courseCardName);
								}
							}
						}
						catch(Exception e)
						{
							status.add("price  not present in this course page  " + courseCardName);
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
					driver.switchTo().window(categoryWindow);
					}
				}
				else
				{
					System.out.println("course cards are not available in "+getCategoryName);
				}
				
				driver.close();
				driver.switchTo().window(parentWindow);
				System.out.println("course card verification completed from : "+getCategoryName);
			}
		}
		else
		{
			System.out.println("no categories on homepage");
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

