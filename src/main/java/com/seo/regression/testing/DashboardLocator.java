package com.seo.regression.testing;

<<<<<<< HEAD
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
=======
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
>>>>>>> bdd0f2cec4ad56528210943314c35d5174841808
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardLocator
{
	WebDriver driver;
<<<<<<< HEAD
	public DashboardLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	public String checkSliderLink(String dataFromExcel) throws InterruptedException
	{
		String statusOfSliderScreen = "fail";
		List<WebElement> sliderPage = driver.findElements(By.cssSelector("div[class='bannersliderhome_Mainslider__w62pu'] div[class='bannersliderhome_bannerSliderH__YF848 bannersliderhome_bannerSliderHDesktOP__LpvuC'] div[class='slick-slider homebannerslider slick-initialized'] div[class*='slick-slide']"));
		Thread.sleep(2000);
		for(int i = 0; i < sliderPage.size(); i++)
		{
			Thread.sleep(3000);
			String checkPage = sliderPage.get(i).getAttribute("aria-hidden");
			Thread.sleep(1000);
			if (checkPage.contains("false"))
			{
				Thread.sleep(1000);
				String getSliderURL = sliderPage.get(i).findElement(By.cssSelector(" a")).getAttribute("href");
				System.out.println(getSliderURL);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
				wait.until(ExpectedConditions.elementToBeClickable(sliderPage.get(i).findElement(By.cssSelector(" img"))));
				sliderPage.get(i).click();
				if(!driver.getCurrentUrl().equals(OpenWebsite.setHost))
				{
					statusOfSliderScreen = "pass";
					break;
				}
				else
				{
					statusOfSliderScreen = "fail";
					break;
				}
			}
		}
		driver.get(OpenWebsite.setHost);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		Thread.sleep(1000);
		return statusOfSliderScreen;
	}
	
	public String checkURLStatus(String data)
	{
		String status = "fail";
			HttpURLConnection huc = null;
			int respCode = 200;
			String addHosturl = data;
			try
			{
				huc = (HttpURLConnection)(new URL(addHosturl).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				System.out.println("status code : "+respCode + " " +addHosturl);
				if(respCode > 200)
				{
					System.out.println("broken link : "+addHosturl);
					System.out.println("response code : "+respCode);
					status = "fail";
				}
				else
				{
					System.out.println("unbroken link : "+" "+addHosturl+" "+respCode);
					/*
					 * JavascriptExecutor js = (JavascriptExecutor) driver; js. executeScript(
					 * "window. open('"+addHosturl+"');" );
					 */
					status = "success";
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return status;
	}
	
	public ArrayList<String> checkLearningPartners(ArrayList<String> data)
	{
		ArrayList<String> verifyPocess = new ArrayList<String>();
		try
		{
			System.out.println("learning Partners process started");
			if(!driver.getCurrentUrl().equalsIgnoreCase(OpenWebsite.setHost))
			{
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.open()");
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				OpenWebsite.openSite(driver);
			}
			else
			{
				System.out.println("host is present");
			}
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			List<WebElement> partnerList = driver.findElements(By.cssSelector("div[class='Collaborate_excollaborationInner__0u_r2'] ul li a"));
			for(int i = 0; i < partnerList.size(); i++)
			{
				if(data.get(i+1).equalsIgnoreCase(partnerList.get(i).getText()))
				{
					String partnerURL = partnerList.get(i).getAttribute("href");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					String urlLinkStatus = this.checkURLStatus(partnerURL);
					if(urlLinkStatus.equalsIgnoreCase("fail"))
					{
						verifyPocess.add(partnerList.get(i).getText());
					}
					else
					{
						verifyPocess.add("pass");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					 String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
					 partnerList.get(i).sendKeys(clicklnk);
					 String parentWindow = driver.getWindowHandle();
					Set<String> childWindows = driver.getWindowHandles();
					for(String windows : childWindows)
					{
						if(!parentWindow.equalsIgnoreCase(windows))
						{
							driver.switchTo().window(windows);
							driver.close();
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
							driver.switchTo().window(parentWindow);
						}
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return verifyPocess;
	}
	
	public ArrayList<String> checkLearningCatalog() throws InterruptedException
	{
		ArrayList<String> verifyPocess = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		List<WebElement> learningCatalogCourses = driver.findElements(By.cssSelector("section[class*='Courses_mainSection']>div>div:nth-child(2) div[class='slick-track']>div[class*='slick-slide'] a"));
		for(int j = 0; j < learningCatalogCourses.size(); j++)
		{
			Thread.sleep(2000);
			System.out.println(" learning catalog courses size : " +learningCatalogCourses.size());
			String checkCourse = learningCatalogCourses.get(j).getAttribute("href");
			System.out.println(" learning catalog courses Name : " +checkCourse);
			verifyPocess.add(this.checkURLStatus(checkCourse));
			
			 JavascriptExecutor js1 = (JavascriptExecutor) driver; js1. executeScript(
			 "window. open('"+checkCourse+"');" );
			String parentWindow = driver.getWindowHandle();
			Set<String> childWindow = driver.getWindowHandles();
			for(String windows : childWindow)
			{
				driver.switchTo().window(windows);
				if(!(parentWindow.equalsIgnoreCase(windows)))
				{
					driver.switchTo().window(windows);
					System.out.println("learning catalog course link :"+j+" "+driver.getCurrentUrl());
					driver.close();
					driver.switchTo().window(parentWindow);
				}
			}
		}
		return verifyPocess;
	}
	
	public ArrayList<String> checkHumanSkills(ArrayList<String> dataFromExcel)
	{
		System.out.println("human skill process started");
		ArrayList<String> verifyProcess = new ArrayList<String>();
		List<WebElement> humanSkillsCourses = driver.findElements(By.cssSelector("div[class*='LearningCatalog_browserCard']"));
		for(int i = 0; i < humanSkillsCourses.size(); i++)
		{
			if(dataFromExcel.get(i+1).equalsIgnoreCase(humanSkillsCourses.get(i).findElement(By.cssSelector(" div[class*='RegularCourseCard_courseHeading'] p")).getText()))
			{
				String courseLink = humanSkillsCourses.get(i).findElement(By.cssSelector("div[class*='RegularCourseCard_RegularcardLinks'] a")).getAttribute("href");
				String urlStatus = this.checkURLStatus(courseLink);
				if(urlStatus.equalsIgnoreCase("fail"))
				{
					verifyProcess.add(dataFromExcel.get(i+1));
				}
				else
				{
					verifyProcess.add("pass");	
				}
				JavascriptExecutor js1 = (JavascriptExecutor) driver; js1. executeScript(
						"window. open('"+courseLink+"');" );
				String parentWindow = driver.getWindowHandle();
				Set<String> childWindow = driver.getWindowHandles();
				for(String windows : childWindow)
				{
					driver.switchTo().window(windows);
					if(!parentWindow.equalsIgnoreCase(windows))
					{
						driver.switchTo().window(windows);
						System.out.println("Human skill course : "+courseLink);
						driver.close();
						driver.switchTo().window(parentWindow);
					}
				}
			}
		}
		return verifyProcess;
		}
	
	public ArrayList<String> checkTopTechCategories(ArrayList<String> data)
	{
		System.out.println("top tech categories process started");
		ArrayList<String> verifyPocess = new ArrayList<String>();
		List<WebElement> topTechCategories = driver.findElements(By.cssSelector("div[class='TechCategories_exCollaborationInner__nW6ww'] ul li a"));
		for(int i = 0; i < topTechCategories.size(); i++)
		{
			if(data.get(i+1).equalsIgnoreCase(topTechCategories.get(i).getText()))
			{
				String getCourseLink = topTechCategories.get(i).getAttribute("href");
				String urlLink = this.checkURLStatus(getCourseLink);
				if(urlLink.equalsIgnoreCase("fail"))
				{
					verifyPocess.add(data.get(i+1));
				}
				else
				{
					verifyPocess.add("fail");
				}
				JavascriptExecutor js1 = (JavascriptExecutor) driver; js1. executeScript(
						"window. open('"+topTechCategories.get(i).getAttribute("href")+"');" );
				String parentWindow = driver.getWindowHandle();
				Set<String> childWindow = driver.getWindowHandles();
				for(String windows : childWindow)
				{
					driver.switchTo().window(windows);
					if(!(parentWindow.equalsIgnoreCase(windows)))
					{
						driver.switchTo().window(windows);
						System.out.println("Top Categories course : "+i+" "+driver.getCurrentUrl());
						driver.close();
						driver.switchTo().window(parentWindow);
					}
				}
			}
		}
		return verifyPocess;
=======
	OpenWebsite openWebsite;
	MicrosoftCourseLocator microsoftCourseLocator;
	RegressionGenericLocator regressionGenericLocator;
	public DashboardLocator(WebDriver driver)
	{
		this.driver = driver;
		this.microsoftCourseLocator = new MicrosoftCourseLocator(this.driver);
		this.regressionGenericLocator = new RegressionGenericLocator(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	public String openSite(String url)
	{
		String status = "";
		try
		{
			String openPage = OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE)+url;
			status = microsoftCourseLocator.checkCourseCode(openPage);
			if(status.contains("fail"))
			{
				System.out.println("Facing issue on site");
			}
			else
			{
				
			}
			driver.get(openPage);
		}
		catch(Exception e)
		{
			status = "fail";
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
				WebElement checkEnrollButton = driver.findElement(By.cssSelector("button[class*='CourseDescription_enrollNowBtn']"));
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
					}
				}
				String parentWindow = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for(String window : allWindows)
				{
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("register?"))
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
	
>>>>>>> bdd0f2cec4ad56528210943314c35d5174841808
	}
}
