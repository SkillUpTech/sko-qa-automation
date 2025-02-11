package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExploreAllLocator
{
	WebDriver driver;
	String parentWindow = "";
	String HomePage = "";
	public ExploreAllLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public ArrayList<String> checkExploreAllLinks()
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try
		{
			//Mega menu Link
			try
			{
				parentWindow = driver.getWindowHandle();
				if(driver.findElements(By.xpath("//a[@id='navbarDropdown']//img[@alt='icon']")).size()>0)
				{
					WebElement megaMenuDropDown = driver.findElement(By.xpath("//a[@id='navbarDropdown']//img[@alt=\"icon\"]"));
					js.executeScript("arguments[0].scrollIntoView();", megaMenuDropDown);
					if(megaMenuDropDown.isDisplayed())
					{
						js.executeScript("arguments[0].click()", megaMenuDropDown);
						
						WebElement clickExploreAllFromMegaMenu = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show']//li[contains(@class,'exploreAll')]/a"));
						js.executeScript("arguments[0].scrollIntoView();", clickExploreAllFromMegaMenu);
						if(clickExploreAllFromMegaMenu.isDisplayed())
						{
							//js.executeScript("arguments[0].click()", clickExploreAllFromMegaMenu);
							String getExploreAllLink = clickExploreAllFromMegaMenu.getAttribute("href");
							String parentWindow = driver.getWindowHandle();
							driver.switchTo().newWindow(WindowType.TAB);
							driver.get(getExploreAllLink);
							Set<String> allWindows = driver.getWindowHandles();
							for(String window : allWindows)
							{
								driver.switchTo().window(window);
								
								if(driver.getCurrentUrl().contains("explore"))
								{
									driver.switchTo().window(window);
									System.out.println("Explore All Page");
									driver.close();
									driver.switchTo().window(parentWindow);
									break;
								}
							}
						}
					}
					js.executeScript("arguments[0].click()", megaMenuDropDown);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				status.add("megaMenu_Fail");
			}
			//HomePage Link
			try
			{
				if(driver.findElements(By.xpath("//div[contains(@class,'LearningCatalog_navAndTab_')]//button[contains(text(),'Explore All')]")).size()>0)
				{
					WebElement clickExploreAllFromHomePage = driver.findElement(By.xpath("//div[contains(@class,'LearningCatalog_navAndTab_')]//button[contains(text(),'Explore All')]"));
					js.executeScript("arguments[0].scrollIntoView();", clickExploreAllFromHomePage);
					if(clickExploreAllFromHomePage.isDisplayed())
					{
						String exploreAllLinkFromHomePage = clickExploreAllFromHomePage.getAttribute("href");
						String parentWindow = driver.getWindowHandle();
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(exploreAllLinkFromHomePage);
						Set<String> allWindows = driver.getWindowHandles();
						for(String window : allWindows)
						{
							driver.switchTo().window(window);
							if(driver.getCurrentUrl().contains("explore"))
							{
								driver.switchTo().window(window);
								System.out.println("Explore All Page");
								driver.close();
								driver.switchTo().window(parentWindow);
								break;
							}
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				status.add("homePage_Fail");
			}
			try
			{
				if(driver.findElements(By.xpath("//a[@id='navbarDropdown']//img[@alt='icon']")).size()>0)
				{
					WebElement megaMenuDropDown = driver.findElement(By.xpath("//a[@id='navbarDropdown']//img[@alt='icon']"));
					js.executeScript("arguments[0].scrollIntoView();", megaMenuDropDown);
					if(megaMenuDropDown.isDisplayed())
					{
						js.executeScript("arguments[0].click()", megaMenuDropDown);
					
					WebElement exploreAllLink = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show']//li[contains(@class,'exploreAll')]/a"));
					Actions actions = new Actions(driver);
					actions.moveToElement(exploreAllLink).perform();
					}
					js.executeScript("arguments[0].click()", megaMenuDropDown);
				}
				else
				{
                    status.add("mouseHover_Fail");
                }

			}
			catch (Exception e) 
			{
				e.printStackTrace();
				status.add("mouseHover_Fail");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String verifyActiveCategoriesOnHomePage()
	{
		String process = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String activeCategory = "";
		try
		{
			parentWindow = driver.getWindowHandle();
			String getURL = driver.getCurrentUrl();
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(getURL);
			HomePage = driver.getWindowHandle();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			js.executeScript("window.scroll", 0, 500);
			WebElement clickExploreAllFromHomePage = driver.findElement(By.xpath("//button[contains(@class,'LearningCatalog_exploreAllButton_')][contains(text(),'Explore All')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickExploreAllFromHomePage);
			if(clickExploreAllFromHomePage.isDisplayed())
			{
				WebElement locateActiveCategory = driver.findElement(By.xpath("//button[contains(@class,'LearningCatalog_activeButton')]"));
				js.executeScript("arguments[0].scrollIntoView();", locateActiveCategory);
				if(locateActiveCategory.isDisplayed())
				{
					activeCategory = locateActiveCategory.getText();
					System.out.println("active category from homepage : "+activeCategory);
				}
				else
				{
					process = "fail";
				}
				js.executeScript("arguments[0].click()", clickExploreAllFromHomePage);
			}
			WebElement checkCategory = driver.findElement(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[contains(@class,'CourseSection_topFilterItem')]/p"));
			js.executeScript("arguments[0].scrollIntoView();", checkCategory);
			if(checkCategory.isDisplayed())
			{
				String CategoryNameFromExploreAl = checkCategory.getText();
				System.out.println("active category from homepage : "+CategoryNameFromExploreAl);
				if(CategoryNameFromExploreAl.replace(" ", "").trim().equalsIgnoreCase(activeCategory.replace(" ", "").trim()))
				{
					System.out.println("same category name : ");
					process = "Pass";
				}
				else
				{
					process = "fail";
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			process = "fail";
		}
		return process;
	}
	
	public ArrayList<String> verifyClearAllAtExploreAllPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			if(driver.findElements(By.xpath("//div[contains(@class,'CourseSection_filterMain__t2i09') and not(@id='mobileFilter')]//button[contains(text(),'Clear All')]")).size()>0)
			{
				WebElement clickClearAll = driver.findElement(By.xpath("//div[contains(@class,'CourseSection_filterMain__t2i09') and not(@id='mobileFilter')]//button[contains(text(),'Clear All')]"));
				js.executeScript("arguments[0].scrollIntoView();", clickClearAll);
				if(clickClearAll.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickClearAll);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
					if(driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//p[contains(text(),'Results (0)')]")).size()>0)
					{
						WebElement checkResult = driver.findElement(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//p[contains(text(),'Results (0)')]"));
						js.executeScript("arguments[0].scrollIntoView();", checkResult);
						if(checkResult.isDisplayed())
						{
							System.out.println(" checkResult : "+checkResult.getText());
						}
					}
					else
					{
						status.add("ResultsFail");
					}
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
				if(driver.findElements(By.xpath("//h3[contains(text(),'Help us find the right course for you.')]")).size()>0)
				{
					WebElement checkContentFromExploreAllPage = driver.findElement(By.xpath("//h3[contains(text(),'Help us find the right course for you.')]"));
					js.executeScript("arguments[0].scrollIntoView();", checkContentFromExploreAllPage);
					if(checkContentFromExploreAllPage.isDisplayed())
					{
						System.out.println("Content : "+checkContentFromExploreAllPage.getText());
					}
				}
				else
				{
					status.add("ContentFail");
				}
			}
			else
			{
				status.add("clearAllFail");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("Fail");
		}
		return status;
	}
	
	public ArrayList<String> verify_CategoriesFromExploreAllPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		ArrayList<String> status = new ArrayList<String>();
		int loopCount;
		try
		{
			List<WebElement> categories = driver.findElements(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][1]//div[contains(@class,'CourseSection_checkbox')]/input"));
			for(int i = 0; i < categories.size(); i++)
			{
				loopCount = i;
				wait.until(ExpectedConditions.visibilityOf(categories.get(i)));
				js.executeScript("arguments[0].scrollIntoView();", categories.get(i));
				if(categories.get(i).isDisplayed())
				{
					js.executeScript("arguments[0].click()", categories.get(i));
					System.out.println("category Name : "+categories.get(i).getAttribute("id"));
					int retries = 3;
					while (retries > 0)
					{
					    try 
					    {
					    	if(driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[@class='row g-3 mt-2']/div[contains(@class,'col')]//a")).size()>0)
							{
								List<WebElement> listOfCourses = driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[@class='row g-3 mt-2']/div[contains(@class,'col')]//a"));
								for(int j = 0; j < listOfCourses.size(); j++)
								{
									wait.until(ExpectedConditions.visibilityOf(listOfCourses.get(j)));
									js.executeScript("arguments[0].scrollIntoView();", listOfCourses.get(j));
									if(listOfCourses.get(j).isDisplayed())
									{
										System.out.println("course Name : "+listOfCourses.get(j).getAttribute("href"));
									}
									if(j == listOfCourses.size()-1)
									{
										status.add(this.checkNextPage());
									}
								}
							}
					        break;
					    } 
					    catch (StaleElementReferenceException e)
					    {
					        retries--;
					        if (retries == 0)
					        {
					        	status.add("courseFail");
					            throw e;  // Re-throw the exception if all retries fail
					        }
					    }
					}
					
				}
				WebElement disableCategoryCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][1]//div[contains(@class,'CourseSection_checkbox')]["+loopCount+"+1]/input")));
				js.executeScript("arguments[0].click();", disableCategoryCheckbox);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("CategoryFail");
		}
		return status;
	}
	public String checkNextPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
		
		 String status = "";
		 boolean hasNextPage = true;
		 
		 while(hasNextPage)
		 {
			try
			{
				if(driver.findElements(By.xpath("//ul[@class='pagination justify-content-center']/li[@class='page-item false']")).size()>0)
				{
					List<WebElement> pages = driver.findElements(By.xpath("//li[@class='page-item false']"));
					System.out.println("Items of the current page");
					for (WebElement item : pages) 
					{
		                System.out.println("Item: " + item.getText());  // Replace with your item interaction
		            }
					try
					{
						  // Check if "Next" button is present and enabled
						if(driver.findElements(By.xpath("//li[@class='page-item false']/a[@aria-label='Next page']")).size()>0)
						{
							WebElement nextButton = driver.findElement(By.xpath("//li[@class='page-item false']/a[@aria-label='Next page']"));
							if (nextButton.isDisplayed() && nextButton.isEnabled()) 
							{
								System.out.println("Navigating to the next page...");
								nextButton.click();
								List<WebElement> listOfCourses = driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[@class='row g-3 mt-2']/div[contains(@class,'col')]//a"));
								for(int j = 0; j < listOfCourses.size(); j++)
								{
									wait.until(ExpectedConditions.visibilityOf(listOfCourses.get(j)));
									js.executeScript("arguments[0].scrollIntoView();", listOfCourses.get(j));
									if(listOfCourses.get(j).isDisplayed())
									{
										System.out.println("course Name : "+listOfCourses.get(j).getAttribute("href"));
									}
									// Optionally wait for the next page to load
								}
							} 
						}
		                else 
		                {
		                    hasNextPage = false;  // Exit loop if "Next" button is not enabled
		                }
		            }
					catch (Exception e) 
					{
		                // If "Next" button is not found or another exception occurs, assume we are on the last page
		                hasNextPage = false;
		                System.out.println("No more pages to navigate.");
		            }
					break;
			}
			else
			{
				System.out.println("next page not available");
				break;
			}	
		}
		catch(Exception e)
 		{
			e.printStackTrace();
			status = "false";
		}
	}
		return status;
	}
	public ArrayList<String> verify_LevelFromExploreAll()
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		ArrayList<String> status = new ArrayList<String>();
		int loopCount;
		try
		{
			if(driver.findElements(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][2]//button")).size()>0)
			{
				WebElement clickLevel = driver.findElement(By.xpath(
						"//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][2]//button"));
				js.executeScript("arguments[0].scrollIntoView();", clickLevel);
				if (clickLevel.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickLevel);
					List<WebElement> categories = driver.findElements(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][2]//div[contains(@class,'CourseSection_checkbox')]/input"));
					for(int i = 0; i < categories.size(); i++)
					{
						loopCount = i;
						wait.until(ExpectedConditions.visibilityOf(categories.get(i)));
						js.executeScript("arguments[0].scrollIntoView();", categories.get(i));
						if(categories.get(i).isDisplayed())
						{
							js.executeScript("arguments[0].click()", categories.get(i));
							System.out.println("category Name : "+categories.get(i).getAttribute("id"));
							int retries = 3;
							while (retries > 0)
							{
							    try 
							    {
							    	if(driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[@class='row g-3 mt-2']/div[contains(@class,'col')]//a")).size()>0)
									{
										List<WebElement> listOfCourses = driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[@class='row g-3 mt-2']/div[contains(@class,'col')]//a"));
										for(int j = 0; j < listOfCourses.size(); j++)
										{
											wait.until(ExpectedConditions.visibilityOf(listOfCourses.get(j)));
											js.executeScript("arguments[0].scrollIntoView();", listOfCourses.get(j));
											if(listOfCourses.get(j).isDisplayed())
											{
												System.out.println("course Name : "+listOfCourses.get(j).getAttribute("href"));
											}
											if(j == listOfCourses.size()-1)
											{
												status.add(this.checkNextPage());
											}
										}
									}
							        break;
							    } 
							    catch (StaleElementReferenceException e)
							    {
							        retries--;
							        if (retries == 0)
							        {
							        	status.add("courseFail");
							            throw e;  // Re-throw the exception if all retries fail
							        }
							    }
							}
						}
						WebElement disableCategoryCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][2]//div[contains(@class,'CourseSection_checkbox')] ["+loopCount+"+1]/input")));
						js.executeScript("arguments[0].click();", disableCategoryCheckbox);
					}
				}
				WebElement disableLevel = driver.findElement(By.xpath(
						"//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][2]//button"));
				js.executeScript("arguments[0].scrollIntoView();", disableLevel);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("levelsFail");
		}
		return status;
	
	}
	
	public ArrayList<String> verify_learningPartnersFromExploreAll()
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		ArrayList<String> status = new ArrayList<String>();
		int loopCount;
		try
		{
			if(driver.findElements(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][3]//button")).size()>0)
			{
				WebElement clickPartner = driver.findElement(By.xpath(
						"//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][3]//button"));
				js.executeScript("arguments[0].scrollIntoView();", clickPartner);
				if (clickPartner.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickPartner);
					List<WebElement> partners = driver.findElements(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][3]//div[contains(@class,'CourseSection_checkbox')]/input"));
					for(int i = 0; i < partners.size(); i++)
					{
					loopCount = i;
					wait.until(ExpectedConditions.visibilityOf(partners.get(i)));
					js.executeScript("arguments[0].scrollIntoView();", partners.get(i));
					if(partners.get(i).isDisplayed())
					{
					js.executeScript("arguments[0].click()", partners.get(i));
					System.out.println("category Name : "+partners.get(i).getAttribute("id"));
					int retries = 3;
					while (retries > 0)
					{
					    try 
					    {
					    	if(driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[@class='row g-3 mt-2']/div[contains(@class,'col')]//a")).size()>0)
							{
								List<WebElement> listOfCourses = driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[@class='row g-3 mt-2']/div[contains(@class,'col')]//a"));
								for(int j = 0; j < listOfCourses.size(); j++)
								{
									wait.until(ExpectedConditions.visibilityOf(listOfCourses.get(j)));
									js.executeScript("arguments[0].scrollIntoView();", listOfCourses.get(j));
									if(listOfCourses.get(j).isDisplayed())
									{
										System.out.println("course Name : "+listOfCourses.get(j).getAttribute("href"));
									}
									if(j == listOfCourses.size()-1)
									{
										status.add(this.checkNextPage());
									}
								}
							}
					        break;
					    } 
					    catch (StaleElementReferenceException e)
					    {
					        retries--;
					        if (retries == 0)
					        {
					        	status.add("courseFail");
					            throw e;  // Re-throw the exception if all retries fail
					        }
					    }
					}
					
				}
					WebElement disableCategoryCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][3]//div[contains(@class,'CourseSection_checkbox')] ["+loopCount+"+1]/input")));
					js.executeScript("arguments[0].click();", disableCategoryCheckbox);
			}
		}
				WebElement disablePartner = driver.findElement(By.xpath(
						"//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][3]//button"));
				js.executeScript("arguments[0].scrollIntoView();", disablePartner);
			}
			}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("partnerFail");
		}
		return status;
	
	}
	
	public ArrayList<String> verify_learningStylesFromExploreAll()
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		ArrayList<String> status = new ArrayList<String>();
		int loopCount;
		try
		{
			if(driver.findElements(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][4]//button")).size()>0)
			{
				WebElement clickStyles = driver.findElement(By.xpath(
						"//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][4]//button"));
				js.executeScript("arguments[0].scrollIntoView();", clickStyles);
				if (clickStyles.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickStyles);
			List<WebElement> learningStyles = driver.findElements(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][4]//input"));
			for(int i = 0; i < learningStyles.size(); i++)
			{
				loopCount = i;
				wait.until(ExpectedConditions.visibilityOf(learningStyles.get(i)));
				js.executeScript("arguments[0].scrollIntoView();", learningStyles.get(i));
				if(learningStyles.get(i).isDisplayed())
				{
					js.executeScript("arguments[0].click()", learningStyles.get(i));
					System.out.println("category Name : "+learningStyles.get(i).getAttribute("id"));
					int retries = 3;
					while (retries > 0)
					{
					    try 
					    {
					    	if(driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[@class='row g-3 mt-2']/div[contains(@class,'col')]//a")).size()>0)
							{
								List<WebElement> listOfCourses = driver.findElements(By.xpath("//div[contains(@class,'CourseSection_courseResultContainer')]//div[@class='row g-3 mt-2']/div[contains(@class,'col')]//a"));
								for(int j = 0; j < listOfCourses.size(); j++)
								{
									wait.until(ExpectedConditions.visibilityOf(listOfCourses.get(j)));
									js.executeScript("arguments[0].scrollIntoView();", listOfCourses.get(j));
									if(listOfCourses.get(j).isDisplayed())
									{
										System.out.println("course Name : "+listOfCourses.get(j).getAttribute("href"));
									}
									if(j == listOfCourses.size()-1)
									{
										status.add(this.checkNextPage());
									}
								}
							}
					        break;
					    } 
					    catch (StaleElementReferenceException e)
					    {
					        retries--;
					        if (retries == 0)
					        {
					        	status.add("courseFail");
					            throw e;  // Re-throw the exception if all retries fail
					        }
					    }
					}
				}
					    WebElement disableStyleCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][4]//div[contains(@class,'CourseSection_checkbox')] ["+loopCount+"+1]/input")));
						js.executeScript("arguments[0].click();", disableStyleCheckbox);
				}
			}
					WebElement disableStyle = driver.findElement(By.xpath(
							"//div[not(@id='mobileFilter') and contains(@class,'CourseSection_filterMain')]//div[@class='col-12']/div[@class='accordion'][4]//button"));
					js.executeScript("arguments[0].scrollIntoView();", disableStyle);
				}
			driver.close();
			driver.switchTo().window(parentWindow);
				}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("styleFail");
		}
		return status;
	
	}
	
}
