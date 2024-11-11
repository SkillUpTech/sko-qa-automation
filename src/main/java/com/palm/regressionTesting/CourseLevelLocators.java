package com.palm.regressionTesting;

import java.net.HttpURLConnection;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseLevelLocators
{
	WebDriver driver;
	IBMPageLocator ibmPageLocator;
	
	public CourseLevelLocators(WebDriver driver)
	{
		this.driver = driver;
		this.ibmPageLocator = new IBMPageLocator(this.driver);
	}
	
	public ArrayList<String> checkSelfPacedVILTOnHomePage()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try
		{
			if(driver.findElements(By.xpath("//section[contains(@class,'Courses_mainSection')]/div/div[@class='row'][2]//div[contains(@class,'LearningCatalog_browserCard')]")).size()>0)
			{
				List<WebElement> courseCards = driver.findElements(By.xpath("//section[contains(@class,'Courses_mainSection')]/div/div[@class='row'][2]//div[contains(@class,'LearningCatalog_browserCard')]"));
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
							
							String parentWindow = driver.getWindowHandle();
							WebElement cardLink = checkCourseCardLevel.findElement(By.xpath(".//ancestor::a"));
							String url = cardLink.getAttribute("href");
							js.executeScript("arguments[0].scrollIntoView();", cardLink);
							if(cardLink.isDisplayed())
							{
								String urlStatus = ibmPageLocator.checkURLStatus(url);
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
							String urlStatus = ibmPageLocator.checkURLStatus(url);
							
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
							String urlStatus = ibmPageLocator.checkURLStatus(url);
							
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
	
	public ArrayList<String> checkSelfPacedVILTOnCategory(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		ArrayList<String> cardlevelStatus = new ArrayList<String>();
		ArrayList<String> pageLevelStatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		try
		{
			String dropDownSelector = "//li[contains(@class,'nav-item dropdown Header_dropdown')]//a";
			if(driver.findElements(By.xpath(dropDownSelector)).size()>0)
			{
				WebElement clickDropdown = driver.findElement(By.xpath(dropDownSelector));
				wait.until(ExpectedConditions.visibilityOf(clickDropdown));
				js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
				if(clickDropdown.isDisplayed())
					js.executeScript("arguments[0].click()", clickDropdown);
				
				String parentWindow = driver.getWindowHandle(); // Mega menu Home page
				
				List<WebElement> categoryList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show']//ul[@class='categorylist customscroll dropdown-submenu']/li/a"));
				for (int i = 0; i < categoryList.size(); i++) 
				{
					js.executeScript("arguments[0].scrollIntoView();", categoryList.get(i));
					wait.until(ExpectedConditions.visibilityOf(categoryList.get(i)));
					if (categoryList.get(i).isDisplayed()) 
					{
						String categoryName = categoryList.get(i).getText();
						String url = categoryList.get(i).getAttribute("href");
						
						System.out.println("category name : "+categoryName);
						
						
						  if(categoryName.equalsIgnoreCase("Azure"))
								  continue;
						 
						String categoryStatus = this.checkURLStatus(url);
						
						if(!categoryStatus.equals("fail"))
						{
							if(url.contains("?utm"))
							{
								driver.switchTo().newWindow(WindowType.TAB);
								
								driver.get(url);
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								String showMoreSelector = "div[class*='container-fluid Courses_containerInner']>div:nth-child(3) div[class*='ManageCardsLimit_showMoreSection']>button";
								if(driver.findElements(By.cssSelector(showMoreSelector)).size()> 0)
								{
									List<WebElement> showMore = driver.findElements(By.cssSelector(showMoreSelector));
									boolean hasShowMore = showMore.size() > 0;
									while(hasShowMore)
									{
										js.executeScript("arguments[0].scrollIntoView();", showMore.get(0));
										js.executeScript("arguments[0].click()", showMore.get(0));
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
										
										showMore = driver.findElements(By.cssSelector(showMoreSelector));
										if(showMore.size() > 0)
										{
											if (showMore.get(0).getText().contains("more"))
												hasShowMore = true;
											else
												hasShowMore = false;
										}
									}
								}
								
								String cardsSelector = "section#scrollToTop>div[class*='container-fluid Courses_containerInner']>div:nth-child(3) div[class*='LearningCatalog_cardRow'] div[class*='FlatCourseCard_FlatcardLinks']";
								
								if(driver.findElements(By.cssSelector(cardsSelector)).size() > 0)
								{
									List<WebElement> cards = driver.findElements(By.cssSelector(cardsSelector));
									
									String categoryPage = driver.getWindowHandle();
									
									for(WebElement card: cards)
									{
										js.executeScript("arguments[0].scrollIntoView();", card);
										wait.until(ExpectedConditions.visibilityOf(card));
										String href = card.findElement(By.cssSelector(" a")).getAttribute("href");
										String name = card.findElement(By.cssSelector(" h2")).getText();
										System.out.println("card name : "+name);
										
										
										String cardLabel1 = " div[class*='FlatCourseCard_propertiesList']>ul>li:nth-child(1)";
										String cardLabel2 = " div[class*='FlatCourseCard_propertiesList']>ul>li:nth-child(2)";
										String cardLabel3 = " div[class*='FlatCourseCard_propertiesList']>ul>li:nth-child(3)";
										
										driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
										
										if(card.findElements(By.cssSelector(cardLabel1)).size()>0)
										{
											WebElement label1 = card.findElement(By.cssSelector(cardLabel1));
											cardLabel1 = label1.getText().toLowerCase();
											cardlevelStatus.add(cardLabel1);
										}
										driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
										
										if(card.findElements(By.cssSelector(cardLabel2)).size()>0)
                                        {
											WebElement  label2 = card.findElement(By.cssSelector(cardLabel2));
											cardLabel2 = label2.getText().toLowerCase();
											cardlevelStatus.add(cardLabel2);
                                        }
										driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
										
                                        if(card.findElements(By.cssSelector(cardLabel3)).size()>0)
                                        {
                                        	WebElement  label3 = card.findElement(By.cssSelector(cardLabel3));
                                        	cardLabel3 = label3.getText().toLowerCase();
                                        	cardlevelStatus.add(cardLabel3);
                                        }
										
										
										boolean isCardWorking = this.checkURLStatus(href).equals("success");
										if(isCardWorking)
										{
											driver.switchTo().newWindow(WindowType.TAB);
											driver.get(href);
											
											driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
											System.out.println("card link is  : "+href);
											
											String pageLevel1 = "div[class*='CourseDescription_TooltipAboutSection']>p:nth-child(1),div[class*='FlatCourseCard_propertiesList']>ul>li:nth-child(1),div[class*='CourseDescription_levelSection']>h2, div[class*='CourseDescription_TooltipAboutSection']>h2:nth-child(1)";
											String pageLevel2 =  "div[class*='CourseDescription_TooltipAboutSection']>p:nth-child(1),div[class*='FlatCourseCard_propertiesList']>ul>li:nth-child(1),div[class*='CourseDescription_levelSection']>h2, div[class*='CourseDescription_TooltipAboutSection']>h2:nth-child(2)";
											String pageLevel3 = "div[class*='CourseDescription_TooltipAboutSection']>p:nth-child(1),div[class*='FlatCourseCard_propertiesList']>ul>li:nth-child(1),div[class*='CourseDescription_levelSection']>h2, div[class*='CourseDescription_TooltipAboutSection']>h2:nth-child(3)";
											String checkDuration = "div[class='d-flex gap-2']:nth-child(1) div[class*='CourseDescription_courseAboutTextSection']>h2";
											driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
											if(driver.findElements(By.cssSelector(pageLevel1)).size()>0)
											{
												WebElement level1 = driver.findElement(By.cssSelector(pageLevel1));
												pageLevelStatus.add(level1.getText().toLowerCase());
											}
											driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
											if (driver.findElements(By.cssSelector(pageLevel2)).size() > 0) 
											{
												 WebElement level2 = driver.findElement(By.cssSelector(pageLevel2));
												 pageLevelStatus.add(level2.getText().toLowerCase());
											}
											driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
											if (driver.findElements(By.cssSelector(pageLevel3)).size() > 0)
											{
												WebElement level3 = driver.findElement(By.cssSelector(pageLevel3));
												pageLevelStatus.add(level3.getText().toLowerCase());
											}
											driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
											
											if(cardlevelStatus.equals(pageLevelStatus))
											{
												if(cardlevelStatus.get(0).equals(pageLevelStatus.get(0)))
												{
													driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
													if(pageLevelStatus.get(0).equalsIgnoreCase("SELF-PACED".toLowerCase()) || pageLevelStatus.get(0).equalsIgnoreCase("BLENDED".toLowerCase()))
													{
														if(driver.findElements(By.cssSelector(checkDuration)).size()>0)
														{
															WebElement firstCourseInfo = driver.findElement(By.cssSelector(checkDuration));
															if (firstCourseInfo.getText().equalsIgnoreCase("Starts on"))
																status.add("starts on date is presented for self paced level 1 : " + name + " : " + categoryName);
														}
													}
													driver.manage()	.timeouts().implicitlyWait(Duration.ofSeconds(10));
													if (pageLevelStatus.get(0).equalsIgnoreCase("VILT".toLowerCase()) || pageLevelStatus.get(0).equalsIgnoreCase("Instructor-Led".toLowerCase())) {
														if (driver.findElements(By.cssSelector(checkDuration)).size() > 0) 
														{
															WebElement firstCourseInfo = driver.findElement(By.cssSelector(checkDuration));
															if (!firstCourseInfo.getText().equalsIgnoreCase("Starts on"))
																status.add("starts on date is not presented for VILT and Instructor : "	+ name + " : " + categoryName);
														}
													}
												}
												if (!cardlevelStatus.get(1).equals(pageLevelStatus.get(1))) 
												{
													status.add("level 2 from : " + name + " is not same as with program page : " + categoryName);
												}
												if (!cardlevelStatus.get(2).equals(pageLevelStatus.get(2))) 
												{
													status.add("level 3 from : " + name + " is not same as with program page : " + categoryName);
												}
														
											}
											
											
											else
											{
												System.out.println("card level 1, 2 , 3 and page level 1 , 2, 3 are not same");
												status.add(categoryName + " : "+ name + " : card level 1, 2 , 3 and page level 1 , 2, 3 are not same");
											}
											  cardlevelStatus.clear(); pageLevelStatus.clear();
											  driver.close();
											  driver.switchTo().window(categoryPage);
											 
										}
										else
										{
											status.add("Card "+name+" is not working from category " + categoryName);
										}
									}
								}
								else
								{
									System.out.println("no program cards");
									status.add("no program cards on category page : "+categoryName);
								}
								driver.close();
							}
							else
							{
								System.out.println(categoryName +" : category url facing issue : " + url);
								status.add(url + " : issue on category url : " +categoryName );
								driver.close();
							}
							driver.switchTo().window(parentWindow);
						}
						else
						{
							System.out.println("category url facing issue : " + url);
							status.add(url + " : issue on category url : " + categoryName);
						}
					}
					else
						System.out.println("no category on page");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}


}
