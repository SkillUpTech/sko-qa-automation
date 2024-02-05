package com.seo.regression.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DashboardLocator
{
	WebDriver driver;
	OpenWebsite openWebsite;
	MicrosoftCourseLocator microsoftCourseLocator;
	RegressionGenericLocator regressionGenericLocator;
	String courseName = "";
	public DashboardLocator(WebDriver driver)
	{
		this.driver = driver;
		this.microsoftCourseLocator = new MicrosoftCourseLocator(this.driver);
		this.regressionGenericLocator = new RegressionGenericLocator(this.driver);
		
		PageFactory.initElements(driver, this);
	}
	public ArrayList<String> openSite(ArrayList<String> urgetURLl)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			for(int i = 1; i < urgetURLl.size(); i++)
			{
				String openPage = OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE)+urgetURLl.get(1);
				
				status.add(microsoftCourseLocator.checkCourseCode(openPage));
				if(status.contains("fail"))
				{
					System.out.println("Facing issue on site");
				}
				driver.get(openPage);
				WebElement getTitle = driver.findElement(By.xpath("//h1"));
				courseName = getTitle.getText().replaceAll("[-+.^:,]","").replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").trim();
				System.out.println("course or  program  name : "+courseName);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public ArrayList<String> EnrollFlatPrice(ArrayList<String> enrollDataFromExcel)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		ArrayList<String> statusOfProcess = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try 
		{
			js.executeScript("window.scrollBy(0,400)");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			String getCurrentURL = driver.getCurrentUrl();
			if(getCurrentURL.contains("in"))// india site
			{
				Thread.sleep(400);
				js.executeScript("window.scrollBy(0,700)");
				Thread.sleep(400);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				WebElement checkEnrollButton = driver.findElement(By.xpath("//div[contains(@class,'FixedContentBar_buttonsContent')]/button[contains(text(),'Enroll Now')]"));
				js.executeScript("arguments[0].scrollIntoView();", checkEnrollButton);
				Thread.sleep(400);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				if(checkEnrollButton.isDisplayed())
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					if(checkEnrollButton.getText().equalsIgnoreCase("Enroll Now"))
					{
						System.out.println("Enroll Button is displayed");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						wait.until(ExpectedConditions.elementToBeClickable(checkEnrollButton));
						js.executeScript("arguments[0].click()", checkEnrollButton);
						Thread.sleep(400);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						String parentWindow = driver.getWindowHandle();
						Set<String> allWindows = driver.getWindowHandles();
						for(String window : allWindows)
						{
							driver.switchTo().window(window);
							if(driver.getCurrentUrl().contains("login?"))
							{
								driver.switchTo().window(window);
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
								/*
								 * WebElement clickLoginIcon =
								 * driver.findElement(By.cssSelector("li#signinlink")); clickLoginIcon.click();
								 */
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
								break;
							}
						}
					}
				}
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				statusOfProcess.add(regressionGenericLocator.loginProcess(enrollDataFromExcel.get(1)));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				Thread.sleep(500);
				statusOfProcess.add(regressionGenericLocator.checkOutRazorpay(enrollDataFromExcel.get(3)));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				
				statusOfProcess.addAll(regressionGenericLocator.indiaPaymentProcess(enrollDataFromExcel.get(2), enrollDataFromExcel.get(3)));
			}
			else
			{
				System.out.println("US Enroll Process");
			}
			String className = this.getClass().getSimpleName();
			if(!className.contains("Dashboard"))
			{
				WebElement clickDropdownIcon = driver.findElement(By.cssSelector("li[class='SigNUP']>a"));
				clickDropdownIcon.click();
				Thread.sleep(2000);
				WebElement clickSignOut = driver.findElement(By.cssSelector("ul[class*='dropdown-menu Primary02_Blue'] li:nth-child(5) a"));
				JavascriptExecutor js3 = (JavascriptExecutor) driver;
				js3.executeScript("arguments[0].click()", clickSignOut);
				Thread.sleep(2000);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			statusOfProcess.add("fail");
		}
		return statusOfProcess;
	
	}
	public String clickDashboard()
	{
		String status = "fail";
		String parentWindow = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try
		{
			js.executeScript("window.scrollBy(0,400)");
			WebElement clickDashboard = driver.findElement(By.xpath("//a[contains(text(),'Continue to your Dashboard')]"));
			if(clickDashboard.isDisplayed())
			{
				clickDashboard.click();
				parentWindow = driver.getWindowHandle();
				Set<String> windows = driver.getWindowHandles();
				for(String window : windows)
				{
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("dashboard"))
					{
						driver.switchTo().window(window);
						js.executeScript("window.scrollBy(0,200)");
						System.out.println("Landed to Dashboard Page");
						status = "success";
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	String getEnrolledCourseOrProgramName = "";
	String modifiedcourseName = "";//.replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").trim()
	public String enrolledCourse()
	{
		String status = "fail";
		String getOrderNumber = regressionGenericLocator.orderNumber;
		getEnrolledCourseOrProgramName = regressionGenericLocator.getEnrolledCourseName;
		String getCourseName[] = getEnrolledCourseOrProgramName.split("in", 2);
		try
		{
			if(courseName.replaceAll("\\s", "").trim().contains(getCourseName[1].replaceAll("[^a-zA-Z0-9]", " ").replaceAll("with professional certificate", "").replaceAll("\\s", "").trim()))
			{
				System.out.println("course enrolled for "+getCourseName[1].replaceAll("[^a-zA-Z0-9]", " ").replaceAll("with professional certificate", "").replaceAll("\\s", "").trim());
				status = "success";
				modifiedcourseName = getCourseName[1].replaceAll("[^a-zA-Z0-9]", " ").replaceAll("with professional certificate", "").replaceAll("\\s", "").trim();
			}
			else
			{
				status = courseName;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
			status = courseName;
		}
		return status;
	}
	public String verfiyRelatedProgramFromDashboard(String data)
	{
		String status = "";
		if(data.contains("A"))
		{
			try
			{
				String courseName = regressionGenericLocator.getEnrolledCourseName;
				System.out.println("course name : "+courseName);
				List<WebElement> titles = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
				for(int i = 0; i < titles.size(); i++)
				{
					if(modifiedcourseName.equalsIgnoreCase(titles.get(i).getAttribute("id").replaceAll("[-+.^:,]","").replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").trim()))
					{
						System.out.println("let click related program for this course : "+courseName);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
						List<WebElement> relatedPgm = titles.get(i).findElements(By.cssSelector(" section[class*='dashboardCourseCards_containerBottom'] p[class*='dashboardCourseCards_relatedProgramsLink']"));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
						if(relatedPgm.size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
							System.out.println("Related Program is present : " + relatedPgm.get(0).getText());
							relatedPgm.get(0).click();
							status = "pass";
							break;
						}
						else
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
							System.out.println("Related Program is not present : " );
							status = "pass";
							break;
						}
					}
				}
				List<WebElement> checkAllRelatedPrograms = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section section[class*='dashboardCourseCards_containerBottom'] div[class*='dashboardCourseCards_bottomReletedPrograms']>p[class*='dashboardCourseCards_relatedProgramsLink']"));
				for(int j = 0 ; j < checkAllRelatedPrograms.size();j++)
				{
					System.out.println("related programs are : "+checkAllRelatedPrograms.get(j));
					checkAllRelatedPrograms.get(j).click();
					if(driver.findElements(By.cssSelector("ul[class*='navigation_containerList']>li[class*='navigation_selected']")).size() > 0) {
					    // Your code here
						System.out.println("related programs available in program section");
						String checkCourseSection = driver.findElement(By.cssSelector("ul[class*='navigation_containerList']>li")).getText();
						if(checkCourseSection.equalsIgnoreCase("Courses"))
						{
							driver.findElement(By.xpath("//ul[contains(@class,'navigation_containerList')]//li[contains(text(),'Courses')]")).click();
							status = "pass";
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				status = "fail";
			}
		}
		else
		{
			try
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String courseName = regressionGenericLocator.getEnrolledCourseName;
				System.out.println("course name : "+courseName);
				List<WebElement> titles = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
				for(int i = 0; i < titles.size(); i++)
				{
					if(i == 0)
					{
					//	titles.get(i).click();
						js.executeScript("arguments[0].click()", titles.get(i));
						System.out.println("let click related program for this course : "+courseName);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
						List<WebElement> relatedPgm = titles.get(i).findElements(By.cssSelector(" section[class*='dashboardCourseCards_containerBottom'] p[class*='dashboardCourseCards_relatedProgramsLink']"));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
						if(relatedPgm.size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
							System.out.println("Related Program is present : " + relatedPgm.get(0).getText());
							status = "pass";
							break;
						}
						else
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
							System.out.println("Related Program is not present : " );
							status = "pass";
							break;
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				status = "fail";
			}
		}
		return status;
	}
	
	public ArrayList<String> verfiySelfPacedCourse()
	{
		ArrayList<String> getStatus = new ArrayList<String>();
		String courseName = "";
		try
		{
			List<WebElement>  selfPacedLocator = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			for(int i = 0; i < selfPacedLocator.size(); i++)
			{
				String checkSelfPacedcourse = selfPacedLocator.get(i).findElement(By.cssSelector(" div[class*='dashboardCourseCards_dataOthers'] p[class*='dashboardCourseCards_otherBright']")).getText();
				if(checkSelfPacedcourse.contains("Self-paced"))
				{
					if(selfPacedLocator.get(i).findElements(By.cssSelector(" span")).size()>0)
					{
						courseName = selfPacedLocator.get(i).findElement(By.cssSelector(" p[class*='dashboardCourseCards_dataCourseTitle']")).getText();
						System.out.println("self paced course has date details" + courseName);
						getStatus.add(courseName);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return getStatus;
	}
	public ArrayList<String> verfiyVILTCourse()
	{
		ArrayList<String> getStatus = new ArrayList<String>();
		String courseName = "";
		try
		{
			List<WebElement>  selfPacedLocator = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			for(int i = 0; i < selfPacedLocator.size(); i++)
			{
				String checkSelfPacedcourse = selfPacedLocator.get(i).findElement(By.cssSelector(" div[class*='dashboardCourseCards_dataOthers'] p[class*='dashboardCourseCards_otherBright']")).getText();
				if(checkSelfPacedcourse.contains("vILT"))
				{
					if(selfPacedLocator.get(i).findElements(By.cssSelector(" span")).size() <= 0)
					{
						courseName = selfPacedLocator.get(i).findElement(By.cssSelector(" p[class*='dashboardCourseCards_dataCourseTitle']")).getText();
						System.out.println("VILT course has date details" + courseName);
						getStatus.add(courseName);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return getStatus;
	}
	
	public ArrayList<String> checkBlendedCourse()
	{
		ArrayList<String> getStatus = new ArrayList<String>();
		try
		{
			List<WebElement>  selfPacedLocator = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			for(int i = 0; i < selfPacedLocator.size(); i++)
			{
				String checkSelfPacedcourse = selfPacedLocator.get(i).findElement(By.cssSelector(" div[class*='dashboardCourseCards_dataOthers'] p[class*='dashboardCourseCards_otherBright']")).getText();
				if(checkSelfPacedcourse.contains("Blended"))
				{
					if(selfPacedLocator.get(i).findElements(By.cssSelector(" span")).size() <= 0)
					{
						courseName = selfPacedLocator.get(i).findElement(By.cssSelector(" p[class*='dashboardCourseCards_dataCourseTitle']")).getText();
						System.out.println("Blended course has date details" + courseName);
						getStatus.add(courseName);
					}
				}
			}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return getStatus;
	}
	public ArrayList<String> verfiyPartnerIconRedirectionFromCourse()
	{
		ArrayList<String> getURLStatus = new ArrayList<String>();
		try
		{
			List<WebElement> basicLocator = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id] a[class*='dashboardCourseCards_dataTagsDark']"));
			for(int i = 0; i < basicLocator.size(); i++)
			{
				basicLocator.get(i).click();
				String getPartnerURL = basicLocator.get(i).getAttribute("href");
					String url = microsoftCourseLocator.checkCourseCode(getPartnerURL);
					String n = Keys.chord(Keys.CONTROL, Keys.ENTER);
					basicLocator.get(i).sendKeys(n);
					if(url.equalsIgnoreCase("fail"))
					{
						getURLStatus.add(getPartnerURL);
					}
					String parentWindow = driver.getWindowHandle();
					Set<String> childWnidow = driver.getWindowHandles();
					for(String windows : childWnidow)
					{
						driver.switchTo().window(windows);
						if(driver.getCurrentUrl().contains("dashboard"))
						{
							driver.switchTo().window(windows);
							System.out.println("dasboard page : "+driver.getCurrentUrl());
							break;
						}
					}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return getURLStatus;
	}
	public String enrolledProgram()
	{
		String status = "fail";
		try
		{
			List<WebElement> programs = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			for(int i = 0; i < programs.size(); i++)
			{
				if(programs.get(i).getAttribute("id").replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").trim().equalsIgnoreCase(courseName.replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").trim()))
				{
					System.out.println("enrolled program is available ");
					status = "pass";
				}
			}
		}
		catch(Exception e)
		{
			status = "fail";
		}
		return status;
	}

	
	  public ArrayList<String> verfiyShareCourseFromDashboard(ArrayList<String> share) 
	  {
		  ArrayList<String> status = new ArrayList<String>(); 
		  JavascriptExecutor js = (JavascriptExecutor) driver; 
		  try 
		  {
			  List<WebElement> checkcourseName = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			  for(int j = 0; j < checkcourseName.size(); j++)
			  {
				  if(checkcourseName.get(j).getAttribute("id").replaceAll("[^a-zA-Z0-9]"," ").replaceAll("\\s", "").trim().equalsIgnoreCase(modifiedcourseName))
				  {
					  js.executeScript("window.scrollBy(0,200)");
					  WebElement shareIcons = checkcourseName.get(j).findElement(By.cssSelector(" [class*='dashboardCourseCards_containerBottom'] div[href]>p"));
					  shareIcons.click(); 
					  WebElement clickCopy = driver.findElement(By.cssSelector("button[class*='btn shadow-none shareSocialMedia_copyButton']"));
					  clickCopy.click(); 
					  String parentWindow = driver.getWindowHandle();
					  List<WebElement> socialLink = driver.findElements(By.cssSelector("div[class*='shareSocialMedia_sociallist']>ul>li>a"));
					  for(int k = 0; k < socialLink.size(); k++) 
					  {
						  if(socialLink.get(k).getAttribute("href").contains(share.get(3)))
						  {
							  socialLink.get(k).click(); 
							  Set<String> windows = driver.getWindowHandles(); 
							  for(String window : windows)
							  { 
								  driver.switchTo().window(window);
								  if(driver.getCurrentUrl().contains("linkedin"))
								  { 
									  driver.switchTo().window(window);
									  System.out.println("Linked In page opened");
									 status.add(microsoftCourseLocator.checkCourseCode(driver.getCurrentUrl()));
									  driver.close();
								  }
							  }
							  driver.switchTo().window(parentWindow);
						  }
						  else if(socialLink.get(k).getAttribute("href").contains(share.get(1)))
						  {
							  socialLink.get(k).click(); 
							  Set<String> windows = driver.getWindowHandles(); 
							  for(String window : windows)
							  { 
								  driver.switchTo().window(window);
								  if(driver.getCurrentUrl().contains("whatsapp"))
								  { 
									  driver.switchTo().window(window);
									  System.out.println("whatsapp page opened");
									  status.add(microsoftCourseLocator.checkCourseCode(driver.getCurrentUrl()));
									  driver.close();
								  }
							  }
							  driver.switchTo().window(parentWindow);
						  }
						  else if(socialLink.get(k).getAttribute("href").contains(share.get(4)))
						  {
							  socialLink.get(k).click(); 
							  Set<String> windows = driver.getWindowHandles(); 
							  for(String window : windows)
							  { 
								  driver.switchTo().window(window);
								  if(driver.getCurrentUrl().contains("facebook"))
								  { 
									  driver.switchTo().window(window);
									  System.out.println("facebook page opened");
									  status.add(microsoftCourseLocator.checkCourseCode(driver.getCurrentUrl()));;
									  driver.close();
								  }
							  }
							  driver.switchTo().window(parentWindow);
						  }
						  else if(socialLink.get(k).getAttribute("href").contains(share.get(2)))
						  {
							  socialLink.get(k).click(); 
							  Set<String> windows = driver.getWindowHandles(); 
							  for(String window : windows)
							  { 
								  driver.switchTo().window(window);
								  if(driver.getCurrentUrl().contains("twitter"))
								  { 
									  driver.switchTo().window(window);
									  System.out.println("whatsapp page opened");
									  status.add(microsoftCourseLocator.checkCourseCode(driver.getCurrentUrl()));;
									  driver.close();
								  }
							  }
							  driver.switchTo().window(parentWindow);
						  }
					  } 
					  WebElement clickCloseFromPopup = driver.findElement(By.cssSelector("div[class='modal-dialog modal-dialog-centered'] button[class*='close']"));
					  if(clickCloseFromPopup.isDisplayed())
					  {
						  clickCloseFromPopup.click();
					  }
				  }
			  }
		  }
		  catch(Exception e)
		  { 
		  	e.printStackTrace(); 
		  } 
		  return status; 
	}
	 
	public ArrayList<String> checkSocialLinkFromCourse(ArrayList<String> socialLinks)
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try
		{
			List<WebElement> checkcourseName = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			for(int j = 0; j < checkcourseName.size(); j++)
			{
				if(checkcourseName.get(j).getAttribute("id").replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").trim().equalsIgnoreCase(modifiedcourseName))
				{
					WebElement shareIcons = checkcourseName.get(j).findElement(By.cssSelector(" [class*='dashboardCourseCards_containerBottom'] div[href]>p"));
					js.executeScript("arguments[0].scrollIntoView();", shareIcons);	
					if(shareIcons.isDisplayed())
					{
						//shareIcons.click();
						js.executeScript("arguments[0].click()", shareIcons);
					}
					WebElement clickCopy = driver.findElement(By.cssSelector("button[class*='btn shadow-none shareSocialMedia_copyButton']"));
					clickCopy.click();
					
					List<WebElement> socialLink = driver.findElements(By.cssSelector("div[class*='shareSocialMedia_sociallist']>ul>li>a"));
					for(int k = 0; k < socialLink.size(); k++)
					{
						for(int l = 1; l < socialLinks.size(); l++)
						{
							if(socialLink.get(k).getAttribute("href").contains("mailto:"))
							{
								System.out.println("microsoft mail not open ");
							}
						
								if(socialLink.get(k).getAttribute("href").contains(socialLinks.get(l)))
								{
									socialLink.get(k).click();
									String parentWindow = driver.getWindowHandle();
									Set<String> listOfWindow = driver.getWindowHandles();
									for(String window : listOfWindow)
									{
										driver.switchTo().window(window);
										if(driver.getCurrentUrl().contains(socialLinks.get(l)))
										{
											driver.switchTo().window(window);
											System.out.println("open social links : "+socialLinks.get(l));
											status.add("pass");
											driver.close();
											break;
										}
									}
									driver.switchTo().window(parentWindow);
								}
							}
						}
						WebElement closePopup = driver.findElement(By.cssSelector("button[class*='btn-close shadow-none  shareSocialMedia_modalCloseBtn']"));
						closePopup.click();
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
	public String verifyProgramPage()
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String parentWindow = driver.getWindowHandle();
			if(driver.getCurrentUrl().contains("dashboard"))
			{
				js.executeScript("window.scrollBy(0,-500)");
				List<WebElement> clickProgram = driver.findElements(By.cssSelector("ul[class*='navigation_containerList']>li"));
				if(clickProgram.size()>0)
				{
					for(int i = 0; i < clickProgram.size(); i++)
					{
						js.executeScript("arguments[0].scrollIntoView();", clickProgram.get(i));
						if(clickProgram.get(i).getText().equalsIgnoreCase("Programs"))
						{
							//clickProgram.get(i).click();
							js.executeScript("arguments[0].click()", clickProgram.get(i));
							System.out.println("redirected to program section");
							status = "pass";
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public ArrayList<String> checkSocialLinkfromProgram(ArrayList<String> share)
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			List<WebElement> programs = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			for(int i = 0; i < programs.size(); i++)
			{
				if(programs.get(i).getAttribute("id").replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").trim().equalsIgnoreCase(courseName))
				{
					System.out.println("enrolled program is available ");
					WebElement clickShareIcon = programs.get(i).findElement(By.cssSelector(" section[class*='dashboardProgramCards_containerBottom']>div>div[class*='dashboardProgramCards_actionShare']"));
					js.executeScript("arguments[0].scrollIntoView();", clickShareIcon);	
					if(clickShareIcon.isDisplayed())
					{
						clickShareIcon.click();
					}
					WebElement clickCopy = driver.findElement(By.cssSelector("button[class*='btn shadow-none shareSocialMedia_copyButton']"));
					clickCopy.click();
					 String parentWindow = driver.getWindowHandle();
					List<WebElement> socialLink = driver.findElements(By.cssSelector("div[class*='shareSocialMedia_sociallist']>ul>li>a"));
					for(int k = 0; k < socialLink.size(); k++)
					{
						 if(socialLink.get(k).getAttribute("href").contains(share.get(3)))
						 {
							  socialLink.get(k).click(); 
							  Set<String> windows = driver.getWindowHandles(); 
							  for(String window : windows)
							  { 
								  driver.switchTo().window(window);
								  if(driver.getCurrentUrl().contains("linkedin"))
								  { 
									  driver.switchTo().window(window);
									  System.out.println("Linked In page opened");
									 status.add(microsoftCourseLocator.checkCourseCode(driver.getCurrentUrl()));
									  driver.close();
								  }
							  }
							  driver.switchTo().window(parentWindow);
						  }
						  else if(socialLink.get(k).getAttribute("href").contains(share.get(1)))
						  {
							  socialLink.get(k).click(); 
							  Set<String> windows = driver.getWindowHandles(); 
							  for(String window : windows)
							  { 
								  driver.switchTo().window(window);
								  if(driver.getCurrentUrl().contains("whatsapp"))
								  { 
									  driver.switchTo().window(window);
									  System.out.println("whatsapp page opened");
									  status.add(microsoftCourseLocator.checkCourseCode(driver.getCurrentUrl()));
									  driver.close();
								  }
							  }
							  driver.switchTo().window(parentWindow);
						  }
						  else if(socialLink.get(k).getAttribute("href").contains(share.get(4)))
						  {
							  socialLink.get(k).click(); 
							  Set<String> windows = driver.getWindowHandles(); 
							  for(String window : windows)
							  { 
								  driver.switchTo().window(window);
								  if(driver.getCurrentUrl().contains("facebook"))
								  { 
									  driver.switchTo().window(window);
									  System.out.println("facebook page opened");
									  status.add(microsoftCourseLocator.checkCourseCode(driver.getCurrentUrl()));;
									  driver.close();
								  }
							  }
							  driver.switchTo().window(parentWindow);
						  }
						  else if(socialLink.get(k).getAttribute("href").contains(share.get(2)))
						  {
							  socialLink.get(k).click(); 
							  Set<String> windows = driver.getWindowHandles(); 
							  for(String window : windows)
							  { 
								  driver.switchTo().window(window);
								  if(driver.getCurrentUrl().contains("twitter"))
								  { 
									  driver.switchTo().window(window);
									  System.out.println("whatsapp page opened");
									  status.add(microsoftCourseLocator.checkCourseCode(driver.getCurrentUrl()));;
									  driver.close();
								  }
							  }
							  driver.switchTo().window(parentWindow);
						  }
					}
						WebElement closePopup = driver.findElement(By.cssSelector("button[class*='btn-close shadow-none  shareSocialMedia_modalCloseBtn']"));
						if(closePopup.isDisplayed())
						{
							closePopup.click();
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

	
	public ArrayList<String> checkCourseContentTabs()
	{
		ArrayList<String> getStatus = new ArrayList<String>();
		try
		{
			 List<WebElement> checkcourseName = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			  for(int j = 0; j < checkcourseName.size(); j++)
			  {
				  if(checkcourseName.get(j).getAttribute("id").replaceAll("[^a-zA-Z0-9]"," ").replaceAll("\\s", "").trim().equalsIgnoreCase(modifiedcourseName))
				  {
					System.out.println("enrolled program is available and Let see course view tabs");
					String parentWindow = driver.getCurrentUrl();
					checkcourseName.get(j).click();
					Set<String> allWindows = driver.getWindowHandles();
					for(String windows : allWindows)
					{
						driver.switchTo().window(windows);
						if(driver.getCurrentUrl().contains("skillsnetwork"))
						{
							driver.switchTo().window(windows);
							System.out.println("Course view page displayed");
							List<WebElement> courseViewTabs= driver.findElements(By.cssSelector("div#courseTabsNavigation a[href]"));
							for(int i = 0; i < courseViewTabs.size(); i++)
							{
								if(courseViewTabs.get(i).isDisplayed())
								{
									courseViewTabs.get(i).click();
									getStatus.add(microsoftCourseLocator.checkCourseCode(courseViewTabs.get(i).getAttribute("href")));
									System.out.println("course view tab page url : "+courseViewTabs.get(i).getAttribute("href"));
								}
								driver.navigate().forward();
							}
							WebElement clickDropDown = driver.findElement(By.cssSelector("dropdown-toggle btn btn-outline-primary"));
							if(clickDropDown.isDisplayed())
							{
								clickDropDown.click();
							}
						}
					}
				 }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return getStatus;
	}
	public ArrayList<String> verifyIncludeCoursesFromProgram(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String checkProgram = "fail";
		try
		{
			String parentWindow = driver.getWindowHandle();
			if(driver.getCurrentUrl().contains("dashboard"))
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-300)");
				List<WebElement> clickProgram = driver.findElements(By.cssSelector("ul[class*='navigation_containerList']>li"));
				if(clickProgram.size()>0)
				{
					for(int i = 0; i < clickProgram.size(); i++)
					{
						if(clickProgram.get(i).getText().equalsIgnoreCase("Programs"))
						{
							//clickProgram.get(i).click();
							js.executeScript("arguments[0].click()", clickProgram.get(i));
							System.out.println("program section is available");
							List<WebElement> programs = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
							for(int j = 0; j < programs.size(); j++)
							{
								if(programs.get(j).getAttribute("id").replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").trim().equalsIgnoreCase(courseName))
								{
									System.out.println("enrolled program is available ");
									checkProgram = "pass";
									WebElement expandCourse = programs.get(j).findElement(By.cssSelector(" section[class*='dashboardProgramCards_containerCourses']>div[class*='dashboardProgramCards_coursesAccordionNav'] img[alt='expand icon']"));
									js.executeScript("arguments[0].scrollIntoView();", expandCourse);	
									if(expandCourse.isDisplayed())
									{
										expandCourse.click();
										System.out.println("Expanded enrolled course");
										status.add("expanded");
										List<WebElement> clickCourses = programs.get(j).findElements(By.cssSelector(" section[class*='dashboardProgramCards_containerCourses'] section[class*='dashboardProgramCards_coursesAccordionList']>div a"));
										for(int k = 0; k < clickCourses.size(); k++)
										{
											if(clickCourses.get(k).isDisplayed())
											{
												//clickCourses.get(k).click();
												String l = Keys.chord(Keys.CONTROL,Keys.ENTER);
												clickCourses.get(k).sendKeys(l);
												String baseWindow = driver.getWindowHandle();
												Set<String> allWindows = driver.getWindowHandles();
												for(String windows : allWindows)
												{
													driver.switchTo().window(windows);
													if(driver.getCurrentUrl().contains("course/"))
													{
														driver.switchTo().window(windows);
														System.out.println("opened course : "+driver.getCurrentUrl());
														driver.close();
													}
												}
												driver.switchTo().window(baseWindow);
											}
										}
										WebElement unexpandCourse = programs.get(j).findElement(By.cssSelector(" section[class*='dashboardProgramCards_containerCourses']>div[class*='dashboardProgramCards_coursesAccordionNav'] img[alt='collapse icon']"));
										if(unexpandCourse.isDisplayed())
										{
											System.out.println("un Expanded enrolled course");
											status.add("unExpanded");
										}
									}
								}
							}
							if(!(checkProgram == "pass"))
							{
								List<WebElement> expandCourse = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id] section[class*='dashboardProgramCards_containerCourses']>div[class*='dashboardProgramCards_coursesAccordionNav'] img[alt='expand icon']"));
								//js.executeScript("arguments[0].scrollIntoView();", expandCourse);	
								if(expandCourse.get(0).isDisplayed())
								{
									expandCourse.get(0).click();
									System.out.println("Expanded enrolled course");
									status.add("expanded");
									List<WebElement> clickCourses = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id] section[class*='dashboardProgramCards_containerCourses'] section[class*='dashboardProgramCards_coursesAccordionList']>div a"));
									for(int k = 0; k < clickCourses.size(); k++)
									{
										if(clickCourses.get(k).isDisplayed())
										{
											//clickCourses.get(k).click();
											String l = Keys.chord(Keys.CONTROL,Keys.ENTER);
											clickCourses.get(k).sendKeys(l);
											String baseWindow = driver.getWindowHandle();
											Set<String> allWindows = driver.getWindowHandles();
											for(String windows : allWindows)
											{
												driver.switchTo().window(windows);
												if(driver.getCurrentUrl().contains("course/"))
												{
													driver.switchTo().window(windows);
													System.out.println("opened course : "+driver.getCurrentUrl());
													driver.close();
												}
											}
											driver.switchTo().window(baseWindow);
										}
									}
									WebElement unexpandCourse = driver.findElement(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id] section[class*='dashboardProgramCards_containerCourses']>div[class*='dashboardProgramCards_coursesAccordionNav'] img[alt='collapse icon']"));
									if(unexpandCourse.isDisplayed())
									{
										unexpandCourse.click();
										System.out.println("un Expanded enrolled course");
										status.add("unExpanded");
									}
								}
							}
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("expandCourseFail");
		}
		return status;
	}
}
