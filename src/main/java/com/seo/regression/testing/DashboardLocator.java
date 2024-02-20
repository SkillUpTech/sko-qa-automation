package com.seo.regression.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
	public String clickDashboard(String data)
	{
		String status = "fail";
		String parentWindow = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(data.contains("yes"))
		{
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			js.executeScript("window.scrollBy(0,400)");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement clickDashboard = driver.findElement(By.xpath("//a[contains(text(),'Continue to your Dashboard')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickDashboard);
			if(clickDashboard.isDisplayed())
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				js.executeScript("arguments[0].click()", clickDashboard);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				parentWindow = driver.getWindowHandle();
				Set<String> windows = driver.getWindowHandles();
				for(String window : windows)
				{
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("dashboard"))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						js.executeScript("window.scrollBy(0,200)");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		
			
		}
		else
		{
			driver.get("https://stage-in.skillup.online/");
			WebElement login = driver.findElement(By.cssSelector("li[class*='Header_loginBtn']>a"));
			 String n = Keys.chord(Keys.CONTROL, Keys.ENTER); 
			 login.sendKeys(n);
			regressionGenericLocator.loginProcess("hemamalini@skillup.tech-split-Test@123");
			status = "pass";
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
				status = "success";
				modifiedcourseName = courseName.replaceAll("\\s", "").trim();
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Related Program Function validation");
			try
			{
				String courseName = regressionGenericLocator.getEnrolledCourseName;
				System.out.println("course name : "+modifiedcourseName);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				List<WebElement> titles = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
				for(int i = 0; i < titles.size(); i++)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					if(modifiedcourseName.equalsIgnoreCase(titles.get(i).getAttribute("id").replaceAll("[-+.^:,]","").replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").trim()))
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
						System.out.println("let click related program for this course : "+courseName);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
						List<WebElement> relatedPgm = titles.get(i).findElements(By.cssSelector(" section[class*='dashboardCourseCards_containerBottom'] p[class*='dashboardCourseCards_relatedProgramsLink']"));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
						if(relatedPgm.size()>0)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
							System.out.println("Related Program is present : " + relatedPgm.get(0).getText());
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
							js.executeScript("arguments[0].click()", relatedPgm.get(0));
							status = "pass";
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
							WebElement checkProgramSection = driver.findElement(By.cssSelector("ul[class*='navigation_containerList']>li[class*='navigation_selected']"));
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
							if(checkProgramSection.isDisplayed())
							{
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
								if(checkProgramSection.getText().equalsIgnoreCase("Programs"))
								{
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
									System.out.println("Landed on program section");
									List<WebElement> courseSectionLocator = driver.findElements(By.cssSelector("ul[class*='navigation_containerList']>li"));
									for(int j = 0; j < courseSectionLocator.size(); j++)
									{
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
										if(courseSectionLocator.get(j).getText().contains("Courses"))
										{
											driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
											js.executeScript("arguments[0].click()", courseSectionLocator.get(j));
											System.out.println("Redirected to course section");
											driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
											break;
										}
									}
								}
							}
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
				/*
				 * List<WebElement> allCourses = driver.findElements(By.
				 * cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id] p[class*='dashboardCourseCards_relatedProgramsLink']"
				 * )); System.out.println("Related programs count : "+allCourses.size());
				 * for(int k = 0; k < allCourses.size(); k++) {
				 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				 * js.executeScript("arguments[0].scrollIntoView();", allCourses.get(k));
				 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				 * if(allCourses.get(k).isDisplayed()) {
				 * js.executeScript("arguments[0].click()", allCourses.get(k)); List<WebElement>
				 * courseSectionLocator = driver.findElements(By.cssSelector(
				 * "ul[class*='navigation_containerList']>li[class*='navigation_selected']"));
				 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40)); for(int j
				 * = 0; j < courseSectionLocator.size(); j++) {
				 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				 * if(courseSectionLocator.get(j).getText().contains("Programs")) {
				 * js.executeScript("arguments[0].click()", courseSectionLocator.get(j));
				 * System.out.println("Redirected to program section");
				 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				 * List<WebElement> courseSectionLocator1 =
				 * driver.findElements(By.cssSelector("ul[class*='navigation_containerList']>li"
				 * )); for(int l = 0; l < courseSectionLocator1.size(); l++) {
				 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				 * if(courseSectionLocator1.get(l).getText().contains("Courses")) {
				 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				 * js.executeScript("arguments[0].click()", courseSectionLocator1.get(l));
				 * System.out.println("Redirected to course section"); break; } } } } } }
				 */
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				status = "fail";
			}
		return status;
	}
	
	public ArrayList<String> verfiySelfPacedCourse()
	{
		ArrayList<String> getStatus = new ArrayList<String>();
		String courseName = "";
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			List<WebElement>  selfPacedLocator = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			for(int i = 0; i < selfPacedLocator.size(); i++)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				String checkSelfPacedcourse = selfPacedLocator.get(i).findElement(By.cssSelector(" div[class*='dashboardCourseCards_dataOthers'] p[class*='dashboardCourseCards_otherBright']")).getText();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				if(checkSelfPacedcourse.contains("Self-paced"))
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					if(selfPacedLocator.get(i).findElements(By.cssSelector(" span")).size()>0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
						courseName = selfPacedLocator.get(i).findElement(By.cssSelector(" p[class*='dashboardCourseCards_dataCourseTitle']")).getText();
						System.out.println("self paced course has date details" + courseName);
						getStatus.add(courseName);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			List<WebElement>  selfPacedLocator = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			for(int i = 0; i < selfPacedLocator.size(); i++)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				String checkSelfPacedcourse = selfPacedLocator.get(i).findElement(By.cssSelector(" div[class*='dashboardCourseCards_dataOthers'] p[class*='dashboardCourseCards_otherBright']")).getText();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				if(checkSelfPacedcourse.contains("vILT"))
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					if(selfPacedLocator.get(i).findElements(By.cssSelector(" span")).size() >= 0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
						courseName = selfPacedLocator.get(i).findElement(By.cssSelector(" p[class*='dashboardCourseCards_dataCourseTitle']")).getText();
						System.out.println("VILT course has date details" + courseName);
					}
					else
					{
						getStatus.add(courseName);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			List<WebElement>  selfPacedLocator = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			for(int i = 0; i < selfPacedLocator.size(); i++)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				String checkSelfPacedcourse = selfPacedLocator.get(i).findElement(By.cssSelector(" div[class*='dashboardCourseCards_dataOthers'] p[class*='dashboardCourseCards_otherBright']")).getText();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				if(checkSelfPacedcourse.contains("Blended"))
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					if(selfPacedLocator.get(i).findElements(By.cssSelector(" span")).size() <= 0)
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
						courseName = selfPacedLocator.get(i).findElement(By.cssSelector(" p[class*='dashboardCourseCards_dataCourseTitle']")).getText();
						System.out.println("Blended course has date details" + courseName);
						getStatus.add(courseName);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
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
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String getPartnerURL = basicLocator.get(i).getAttribute("href");
				//js.executeScript("arguments[0].click()", basicLocator.get(i));
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
						}
						else if(!driver.getCurrentUrl().contains("dashboard"))
						{
							driver.close();
						}
					}
					driver.switchTo().window(parentWindow);
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
					 if(shareIcons.isDisplayed())
					 {
						 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
						 js.executeScript("arguments[0].click()", shareIcons);
						 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
						// shareIcons.click(); 
					 }
					  WebElement clickCopy = driver.findElement(By.cssSelector("button[class*='btn shadow-none shareSocialMedia_copyButton']"));
					 if(clickCopy.isDisplayed())
					 {
						 js.executeScript("arguments[0].click()", clickCopy);
						 //clickCopy.click(); 
					 }
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
						  break;
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
				WebElement clickProgram = driver.findElement(By.xpath("//ul[contains(@class,'navigation_containerList')]/li[@class='navigation_selected__Kzs2R']"));
				if(!clickProgram.getText().contains("Courses"))
				{
					js.executeScript("arguments[0].scrollIntoView();", clickProgram);
					WebElement clickCourses = driver.findElement(By.xpath("//ul[contains(@class,'navigation_containerList')]/li[contains(text(),'Courses')]"));
					js.executeScript("arguments[0].click()", clickCourses);
					System.out.println("redirected to program section");
					status = "pass";
				}
				else
				{
					System.out.println("It already in course section");
					status = "pass";
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

	
	public ArrayList<String> checkCourseContentTabs(String data)
	{
		ArrayList<String> getStatus = new ArrayList<String>();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(!data.contains("Yes"))
		{
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			 List<WebElement> checkcourseName = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			 for(int j = 0; j < checkcourseName.size(); j++)
			 {
				 js.executeScript("arguments[0].scrollIntoView();", checkcourseName.get(j));
				 
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				 
				  if(checkcourseName.get(j).getAttribute("id").replaceAll("[^a-zA-Z0-9]"," ").replaceAll("\\s", "").trim().equalsIgnoreCase(modifiedcourseName))
				  {

						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
						System.out.println("enrolled course displayed"); 
						System.out.println("enrolled program is available and Let see course view tabs");
						
						
						
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
							WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
							
							WebElement clickCourse = checkcourseName.get(j).findElement(By.cssSelector(" a[class*='dashboardCourseCards_spanLink']"));
							
							js.executeScript("arguments[0].scrollIntoView();", clickCourse);
							
							
							if(clickCourse.isDisplayed())
							{
								String courseContentOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER); 
								  
								js.executeScript("arguments[0].scrollIntoView();", clickCourse);
								
								wait.until(ExpectedConditions.elementToBeClickable(clickCourse));
								  
								clickCourse.sendKeys(courseContentOnTab);
							}
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
								  
							
								
								Set<String> allWindows = driver.getWindowHandles();
								
								for(String windows : allWindows)
								{
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

									driver.switchTo().window(windows);
									  
									 if(driver.getCurrentUrl().contains("/courses/")) // verifying course content page
									 {
										 driver.switchTo().window(windows);
										 System.out.println("Course Content view tab Page");
										 List<WebElement> courseViewTabs= driver.findElements(By.cssSelector("div#courseTabsNavigation nav[class='nav flex-nowrap nav-underline-tabs']>a, div#content li[class*='nav-item']>a"));
										 for(int i = 0; i < courseViewTabs.size(); i++)
										 {
											 String courseContentScreen = driver.getWindowHandle();//parent screen of course sontent page
											 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
											 
											 js.executeScript("arguments[0].scrollIntoView();", courseViewTabs.get(i));
											
											 String courseContentTabsURL = courseViewTabs.get(i).getAttribute("href");

											 if(courseViewTabs.get(i).isDisplayed())
											 {
												 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
												 
												 js.executeScript("arguments[0].scrollIntoView();", courseViewTabs.get(i));
												 
										
												 String contentOnNewPage = Keys.chord(Keys.CONTROL, Keys.ENTER); 
												 
												 courseViewTabs.get(i).sendKeys(contentOnNewPage);
											 }
											 
											 Set<String> allTabsWindows = driver.getWindowHandles(); 
											 for(String tabs : allTabsWindows)
											 {
												 driver.switchTo().window(tabs);
												 if(!courseContentScreen.equals(tabs))
												 {
													 driver.switchTo().window(tabs);
													 System.out.println("course content url : "+driver.getCurrentUrl());
													 driver.close();
													// driver.switchTo().window(courseContentScreen);
												 }
											 }
											 driver.switchTo().window(courseContentScreen);
										   }	 
									 }
								}
								break;
							
				  }
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
		else
		{
			try
			{

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				
				 List<WebElement> checkcourseName = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				
				 String DashboardScreen = driver.getCurrentUrl(); // Dashboard page
				 
				 for(int j = 0; j < checkcourseName.size(); j++)
				 {
					 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
					 
					 WebElement CourseBaseLocator  = checkcourseName.get(j);
					// js.executeScript("arguments[0].scrollIntoView();", CourseBaseLocator);
					 
					 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
					  List<WebElement> clickSkillupPartner = CourseBaseLocator.findElements(By.cssSelector(" a[class*='dashboardCourseCards_dataTagsDark'], div[class*='dashboardCourseCards_dataTagsDark']"));
					  {
						  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
						  for(int l = 0; l < clickSkillupPartner.size(); l++)
						  {
							  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
							  if(clickSkillupPartner.get(l).getText().contains("SkillUp Online"))
							  {
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
									System.out.println("enrolled course displayed"); 
									System.out.println("enrolled program is available and Let see course view tabs");
									
									
									
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
										WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
										
										WebElement clickCourse = CourseBaseLocator.findElement(By.cssSelector(" a[class*='dashboardCourseCards_spanLink']"));
										
										js.executeScript("arguments[0].scrollIntoView();", clickCourse);
										
										 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
										if(clickCourse.isDisplayed())
										{
											String courseContentOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER); 
											  
											js.executeScript("arguments[0].scrollIntoView();", clickCourse);
											
											wait.until(ExpectedConditions.elementToBeClickable(clickCourse));
											  
											clickCourse.sendKeys(courseContentOnTab);
										}
											
											driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
											  
										
											
											Set<String> allWindows = driver.getWindowHandles();
											
											for(String windows : allWindows)
											{
												driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));

												driver.switchTo().window(windows);
												  
												 if(driver.getCurrentUrl().contains("/courses/")) // verifying course content page
												 {
													 driver.switchTo().window(windows);
													 System.out.println("Course Content view tab Page");
													 List<WebElement> courseViewTabs= driver.findElements(By.cssSelector("div#courseTabsNavigation nav[class='nav flex-nowrap nav-underline-tabs']>a, div#content li[class*='nav-item']>a"));
													 for(int i = 0; i < courseViewTabs.size(); i++)
													 {
														 String courseContentScreen = driver.getWindowHandle();//parent screen of course sontent page
														 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
														 
														 js.executeScript("arguments[0].scrollIntoView();", courseViewTabs.get(i));
														
														 String courseContentTabsURL = courseViewTabs.get(i).getAttribute("href");

														 if(courseViewTabs.get(i).isDisplayed())
														 {
															 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
															 
															 js.executeScript("arguments[0].scrollIntoView();", courseViewTabs.get(i));
															 
													
															 String contentOnNewPage = Keys.chord(Keys.CONTROL, Keys.ENTER); 
															 
															 courseViewTabs.get(i).sendKeys(contentOnNewPage);
														 }
														 
														 Set<String> allTabsWindows = driver.getWindowHandles(); 
														 for(String tabs : allTabsWindows)
														 {
															 driver.switchTo().window(tabs);
															 if(!courseContentScreen.equals(tabs))
															 {
																 driver.switchTo().window(tabs);
																 System.out.println("course content url : "+driver.getCurrentUrl());
																 driver.close();
																// driver.switchTo().window(courseContentScreen);
															 }
														 }
														 driver.switchTo().window(courseContentScreen);
													   }	 
												 }
											}
											break;
										}
						  }
					  }
					break;
						}
				 driver.switchTo().window(DashboardScreen);
					  }
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		WebElement clickDropDown = driver.findElement(By.cssSelector("button[class='dropdown-toggle btn btn-outline-primary'], div[class='navbar-right NAVRiGhT'] li[class='SigNUP'] img[class='dPaRoW']"));
		js.executeScript("arguments[0].scrollIntoView();", clickDropDown);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		if(clickDropDown.isDisplayed())
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			js.executeScript("arguments[0].click()", clickDropDown);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			List<WebElement> dropDownData = driver.findElements(By.cssSelector("div[class='dropdown-menu-right dropdown-menu show']>a, ul[class='dropdown-menu Primary02_Blue']>li>a"));
			for(int k = 0 ; k < dropDownData.size(); k++)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				if(dropDownData.get(k).getText().contains("Dashboard"))
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					js.executeScript("arguments[0].click()", dropDownData.get(k));
					System.out.println("Landed to dashboard");
					/*
					 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					 * driver.findElement(By.
					 * cssSelector("button[class='dropdown-toggle btn btn-outline-primary'], li[class*='Header_SigNUP'] img[alt='icon']"
					 * )).click(); List<WebElement> logout = driver.findElements(By.
					 * cssSelector("ul[class='dropdown-menu Header_Primary02_Blue__bffoz show']>li>a"
					 * )); for(int i = 0; i < logout.size(); i++) {
					 * if(logout.get(i).getText().contains("Sign Out")) { logout.get(i).click();
					 * System.out.println("logout is done"); } }
					 */
					break;
				}
			}
		}
		return getStatus;
	}
	public ArrayList<String> verifyIncludeCoursesFromProgram(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			String parentWindow = driver.getWindowHandle();
			if(driver.getCurrentUrl().contains("dashboard"))
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-300)");
				WebElement clickProgram = driver.findElement(By.cssSelector("ul[class*='navigation_containerList']>li[class='navigation_selected__Kzs2R']"));
				if(!clickProgram.getText().contains("Programs"))
				{
					WebElement clickProgramSection = driver.findElement(By.xpath("//li[contains(text(),'Programs')]"));
					clickProgramSection.click();

					System.out.println("program section is available");
					List<WebElement> programs = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
					for(int j = 0; j < programs.size(); j++)
					{
						if(j == 0)
						{
							WebElement expandCourse = programs.get(j).findElement(By.cssSelector(" section[class*='dashboardProgramCards_containerCourses']>div[class*='dashboardProgramCards_coursesAccordionNav'] img[alt='expand icon']"));
							js.executeScript("arguments[0].scrollIntoView();", expandCourse);	
							if(expandCourse.isDisplayed())
							{
								js.executeScript("arguments[0].click()", expandCourse);
								if(driver.findElement(By.cssSelector("section[class='dashboardProgramCards_coursesAccordionList__NfQfc']")).isDisplayed())
								{
								
									System.out.println("Expanded Program");
									status.add("expanded");
									
									List<WebElement> clickCourses = programs.get(j).findElements(By.cssSelector(" section[class*='dashboardProgramCards_containerCourses'] section[class*='dashboardProgramCards_coursesAccordionList']>div a"));
									System.out.println("Include courses from program : "+clickCourses.size());
									String baseWindow = driver.getWindowHandle();
									for(int k = 0; k < clickCourses.size(); k++)
									{
										if(clickCourses.get(k).isDisplayed())
										{
											String openNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
											clickCourses.get(k).sendKeys(openNewTab);
											Set<String> allWindows = driver.getWindowHandles();
											for(String windows : allWindows)
											{
												driver.switchTo().window(windows);
												if(driver.getCurrentUrl().contains("/course/"))
												{
													driver.switchTo().window(windows);
													System.out.println("opened course : "+driver.getCurrentUrl());
													driver.close();
												}
											}
											driver.switchTo().window(baseWindow);
										}
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
					
				
				}
				else
				{
							System.out.println("program section is available");
							List<WebElement> programs = driver.findElements(By.cssSelector("section[class*='contentDashboardSection_contentCardsFall']>section[id]"));
							for(int j = 0; j < programs.size(); j++)
							{
								if(j == 0)
								{
									WebElement expandCourse = programs.get(j).findElement(By.cssSelector(" section[class*='dashboardProgramCards_containerCourses']>div[class*='dashboardProgramCards_coursesAccordionNav'] img[alt='expand icon']"));
									js.executeScript("arguments[0].scrollIntoView();", expandCourse);	
									if(expandCourse.isDisplayed())
									{
										js.executeScript("arguments[0].click()", expandCourse);
										if(driver.findElement(By.cssSelector("section[class='dashboardProgramCards_coursesAccordionList__NfQfc']")).isDisplayed())
										{
										
											System.out.println("Expanded Program");
											status.add("expanded");
											
											List<WebElement> clickCourses = programs.get(j).findElements(By.cssSelector(" section[class*='dashboardProgramCards_containerCourses'] section[class*='dashboardProgramCards_coursesAccordionList']>div a"));
											System.out.println("Include courses from program : "+clickCourses.size());
											String baseWindow = driver.getWindowHandle();
											for(int k = 0; k < clickCourses.size(); k++)
											{
												if(clickCourses.get(k).isDisplayed())
												{
													String openNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
													clickCourses.get(k).sendKeys(openNewTab);
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
}
