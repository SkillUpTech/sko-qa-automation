package com.seo.regression.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		ArrayList<String> getURL = new ArrayList<String>();
		try
		{
			for(int i = 0; i < getURL.size(); i++)
			{
				String openPage = OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE)+getURL.get(i);
				status.add(microsoftCourseLocator.checkCourseCode(openPage));
				if(status.contains("fail"))
				{
					System.out.println("Facing issue on site");
				}
				driver.get(openPage);
				WebElement getTitle = driver.findElement(By.xpath("//h1"));
				courseName = getTitle.getText();
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

		ArrayList<String> statusOfProcess = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try 
		{
			js.executeScript("window.scrollBy(0,200)");
			String getCurrentURL = driver.getCurrentUrl();
			if(getCurrentURL.contains("in"))// india site
			{
				js.executeScript("window.scrollBy(0,700)");
				WebElement checkEnrollButton = driver.findElement(By.xpath("//div[contains(@class,'FixedContentBar_buttonsContent')]/button[contains(text(),'Enroll Now')]"));
				js.executeScript("arguments[0].scrollIntoView();", checkEnrollButton);
				
				if(checkEnrollButton.isDisplayed())
				{
					if(checkEnrollButton.getText().equalsIgnoreCase("Enroll Now"))
					{
						System.out.println("Enroll Button is displayed");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						wait.until(ExpectedConditions.elementToBeClickable(checkEnrollButton));
						js.executeScript("arguments[0].click()", checkEnrollButton);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						WebElement EnrollLink = driver.findElement(By.xpath("//button[contains(@class,'CourseDescription_EnrollBtn')]"));
						js.executeScript("arguments[0].scrollIntoView();", EnrollLink);
						if(EnrollLink.isDisplayed())
						{
							js.executeScript("arguments[0].click()", EnrollLink);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						}
					}
				}
				String parentWindow = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for(String window : allWindows)
				{
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("login?"))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						WebElement clickLoginIcon = driver.findElement(By.cssSelector("li#signinlink"));
						clickLoginIcon.click();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						break;
					}
				}
				statusOfProcess.add(regressionGenericLocator.loginProcess(enrollDataFromExcel.get(1)));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				
				statusOfProcess.add(regressionGenericLocator.checkOutRazorpay(enrollDataFromExcel.get(3)));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				
				statusOfProcess.addAll(regressionGenericLocator.indiaPaymentProcess(enrollDataFromExcel.get(4), enrollDataFromExcel.get(5)));
			}
			else
			{
				System.out.println("US Enroll Process");
			}
			WebElement clickDropdownIcon = driver.findElement(By.cssSelector("li[class='SigNUP']>a"));
			clickDropdownIcon.click();
			Thread.sleep(2000);
			WebElement clickSignOut = driver.findElement(By.cssSelector("ul[class*='dropdown-menu Primary02_Blue'] li:nth-child(5) a"));
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("arguments[0].click()", clickSignOut);
			Thread.sleep(2000);
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
		try
		{
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
	public String enrolledCourse()
	{
		String status = "fail";
		String getOrderNumber = regressionGenericLocator.orderNumber;
		String getEnrolledCourseOrProgramName = regressionGenericLocator.getEnrolledCourseName;
		try
		{
			if(courseName.equalsIgnoreCase(getEnrolledCourseOrProgramName))
			{
				System.out.println("course enrolled for "+getEnrolledCourseOrProgramName);
				status = "success";
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
	public String enrolledProgram()
	{
		String status = "fail";
		try
		{
			
		}
		catch(Exception e)
		{
			
		}
		return status;
	}
	public String verfiyShareCourseFromDashboard()
	{
		String status = "fail";
		try
		{
			List<WebElement> shareIcons = driver.findElements(By.cssSelector("section[class*='dashboardCourseCards_cardContainer'] [class*='dashboardCourseCards_containerBottom'] div[href]>p"));
			for(int i = 0; i < shareIcons.size(); i++)
			{
				if(i == 0)
				{
					shareIcons.get(i).click();
					WebElement clickCopy = driver.findElement(By.cssSelector("button[class*='btn shadow-none shareSocialMedia_copyButton']"));
					clickCopy.click();
					List<WebElement> socialLink = driver.findElements(By.cssSelector("div[class*='shareSocialMedia_sociallist']>ul>li>a"));
					for(int j = 0; j < socialLink.size(); j++)
					{
						if(socialLink.get(j).getAttribute("href").contains("whatsapp"))
						{
							socialLink.get(j).click();
							String parentWindow = driver.getWindowHandle();
							Set<String> windows = driver.getWindowHandles();
							for(String window : windows)
							{
								driver.switchTo().window(window);
								if(driver.getCurrentUrl().contains("whatsapp"))
								{
									
								}
							}
						}
					}
					System.out.println("Share whtsapp ");
					status = "success";
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public String checkSocialLink()
	{
		String status = "fail";
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
