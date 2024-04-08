package com.seo.regression.testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverAction;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicrosoftCourseLocator 
{
	WebDriver driver;
	int respCode = 200;
	HttpURLConnection huc = null;
	
	public MicrosoftCourseLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public ArrayList<String> verifyMicrosftPage()
	{
		ArrayList<String> processStatus = new ArrayList<String>();
		try
		{
			WebElement  clickCourseDropdown = driver.findElement(By.cssSelector("a#navbarDropdown div[class=' Header_category__mr_e4']"));
			clickCourseDropdown.click();
			List<WebElement> learningPartners = driver.findElements(By.cssSelector("ul[class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show'] div[class='LearningPartners catcolumn divbox2'] ul[class='learning-Partners']>li>a"));
			for(int i = 0; i < learningPartners.size();i++)
			{
				String getLearningPartnerURL = learningPartners.get(i).getAttribute("href");
				if(getLearningPartnerURL.contains("microsoft"))
				{
					String url = this.checkCourseCode(getLearningPartnerURL);
					String n = Keys.chord(Keys.CONTROL, Keys.ENTER);
					learningPartners.get(i).sendKeys(n);
					if(url.equalsIgnoreCase("fail"))
					{
						processStatus.add("fail");
					}
					Set<String> childWnidow = driver.getWindowHandles();
					for(String windows : childWnidow)
					{
						driver.switchTo().window(windows);
						if(driver.getCurrentUrl().contains("microsoft"))
						{
							driver.switchTo().window(windows);
							System.out.println("microsoft page : "+driver.getCurrentUrl());
							processStatus.add("pass");
							break;
						}
					}
					break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			processStatus.add("fail");
		}
		return processStatus;
	}

	public String checkCourseCode(String getURL)
	{
		int status = 0;
		String getstatus = "pass";
		String url="";
		int respCode = 200;
		HttpURLConnection huc = null;
		String addHosturl = "";
			String endURL = getURL;
			if(endURL.contains("enterprise"))
			{	
				if(OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE).contains("stage"))
				{
					url = /* "https://stagecourses-in.skillup.online"+ */endURL;
					addHosturl = url;
				}
			}
			else
			{
				url = /* OpenWebsite.setEnvironment(RegressionTesting.ENV_TO_USE)+ */endURL;
				addHosturl = url;
			}
			try
			{

				URL obj = new URL(url);
				HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
				conn.setReadTimeout(5000);
				conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
				conn.addRequestProperty("User-Agent", "Mozilla");
				conn.addRequestProperty("Referer", "google.com");

				System.out.println("Request URL ... " + addHosturl);

				boolean redirect = false;

				// normally, 3xx is redirect
			status = conn.getResponseCode();
				if (status != HttpURLConnection.HTTP_OK) {
					if (status == HttpURLConnection.HTTP_MOVED_TEMP
						|| status == HttpURLConnection.HTTP_MOVED_PERM
							|| status == HttpURLConnection.HTTP_SEE_OTHER)
					redirect = true;
				}

				System.out.println("Response Code ... " + status);

				if (redirect) {

					// get redirect url from "location" header field
					String newUrl = conn.getHeaderField("Location");

					// get the cookie if need, for login
					String cookies = conn.getHeaderField("Set-Cookie");

					conn = (HttpURLConnection) new URL(newUrl).openConnection();
					conn.setRequestProperty("Cookie", cookies);
					conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
					conn.addRequestProperty("User-Agent", "Mozilla");
					conn.addRequestProperty("Referer", "google.com");
											
					System.out.println("Redirect to URL : " + newUrl);

				}

				BufferedReader in = new BufferedReader(
			                              new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer html = new StringBuffer();

					while ((inputLine = in.readLine()) != null) 
					{
						html.append(inputLine);
					}
					in.close();
	
					System.out.println("Done");
					if(status>200)
					{
						getstatus = addHosturl+"fail" + status;
					}
			    } 
			catch (Exception e) 
			{
				e.printStackTrace();
				getstatus = "fail" + status;
			}

			
		return getstatus;
	}
	
	
	public ArrayList<String> verifyMicrosoftScourses()
	{
		ArrayList<String> processStatus = new ArrayList<String>();
		ArrayList<String> courseProcessStatus = new ArrayList<String>();
		ArrayList<String> pageProcessStatus = new ArrayList<String>();
		ArrayList<String> courseCardData = new ArrayList<String>();
		String statusOfURL = "pass";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String enrollmentStatusOncard = "";
		String courseCardStartsDate = "";
		try
		{
			js.executeScript("window.scrollBy(0, 1100)", "");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			WebElement clickShowMore = driver.findElement(By.cssSelector("div[class*='ManageCardsLimit_showMoreSection'] button"));
			wait.until(ExpectedConditions.visibilityOfAllElements(clickShowMore));
			js.executeScript("arguments[0].scrollIntoView();", clickShowMore);
			while(clickShowMore.isDisplayed() != clickShowMore.getText().equalsIgnoreCase("Show less"))
			{
				js.executeScript("arguments[0].click()", clickShowMore);
			}
			List<WebElement> listOfCourses = driver.findElements(By.xpath("//div[contains(@class,'container-fluid Courses_containerInner')]/div[@class='row'][2]/div[3]//div[@class='col-lg-3 col-md-4 col-sm-6 col-12']"));
			for(int i = 0; i < listOfCourses.size(); i++)
			{
				js.executeScript("arguments[0].scrollIntoView();", listOfCourses.get(i));
				
				String courseURL = listOfCourses.get(i).findElement(By.xpath(".//div[contains(@class, 'RegularCourseCard_RegularcardLinks')]/a")).getAttribute("href");
				
				String urlLink = this.checkCourseCode(courseURL);
				
				if(urlLink.contains("fail"))
				{
					statusOfURL = "fail";
					processStatus.add(courseURL);
				}
				if(!statusOfURL.equalsIgnoreCase("fail"))
				{
				
				WebElement imageOnCards = listOfCourses.get(i).findElement(By.xpath(".//img[@alt='Course Banner']"));
				js.executeScript("arguments[0].scrollIntoView();", imageOnCards);
				
				WebElement iconOnCards = listOfCourses.get(i).findElement(By.xpath(".//img[@alt='icon']"));
				js.executeScript("arguments[0].scrollIntoView();", iconOnCards);
				
				WebElement courseCards = listOfCourses.get(i).findElement(By.xpath(".//div[contains(@class,'RegularCourseCard_courseType')]//p"));
				js.executeScript("arguments[0].scrollIntoView();", courseCards);
				
				WebElement nameOnCards = listOfCourses.get(i).findElement(By.xpath(".//div[contains(@class,'RegularCourseCard_courseHeading')]/p"));
				js.executeScript("arguments[0].scrollIntoView();", nameOnCards);
				
				String courseCardName = nameOnCards.getText();
				
				WebElement levelsOnCards = listOfCourses.get(i).findElement(By.xpath(".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul"));
				js.executeScript("arguments[0].scrollIntoView();", levelsOnCards);
				
				WebElement partnerOnCards = listOfCourses.get(i).findElement(By.xpath(".//div[contains(@class,'RegularCourseCard_courseCompany')]"));
				js.executeScript("arguments[0].scrollIntoView();", partnerOnCards);
				
				List<WebElement> enrollStatusOnCards = listOfCourses.get(i).findElements(By.xpath(".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2"));
				if(enrollStatusOnCards.size()==1)
				{
					
					if(enrollStatusOnCards.get(0).getText().contains("Course starts on"))
					{
						enrollmentStatusOncard = "Open";
					}
					else if(enrollStatusOnCards.get(0).getText().contains("Coming Soon"))
					{
						enrollmentStatusOncard = "Close";
					}
					
				}
				else
				{
					System.out.println("no enrollment status");
				}
				
				WebElement courseCardPrice = listOfCourses.get(i).findElement(By.xpath(".//div[contains(@class,'RegularCourseCard_priceRight')]/p"));
				
				js.executeScript("arguments[0].scrollIntoView();", courseCardPrice);
				
				if(!courseCardPrice.isDisplayed())
				{
					courseProcessStatus.add(courseCardName.concat(" courseCardPrice not present from course card"));
				}
				else
				{
					String val = courseCardPrice.getText();
					Pattern pattern = Pattern.compile("\\d+");
					Matcher matcher = pattern.matcher(val);
					StringBuilder build = new StringBuilder();
					while(matcher.find())
					{
						build.append(matcher.group());
					}
					String result = build.toString();
					courseCardData.add(result);// card price
				}
					js. executeScript("window. open('"+courseURL+"');" );
					String parentWindow = driver.getWindowHandle();
					Set<String> childWnidow = driver.getWindowHandles();
					for(String windows : childWnidow)
					{
						driver.switchTo().window(windows);
						if(!parentWindow.equalsIgnoreCase(windows))
						{
							driver.switchTo().window(windows);
							if(driver.getCurrentUrl().contains(courseURL))
							{
								driver.switchTo().window(windows);
								String checkCourseTab = driver.getTitle();
								if(checkCourseTab.contains("undefined"))
								{
									processStatus.add(courseURL+" undefined word on tab");
								}
								else if(checkCourseTab.contains("null"))
								{
									processStatus.add(courseURL+" null word on tab");
								}
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
								if(driver.findElements(By.cssSelector("div[class='error-content'] p")).size()>0)
								{
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
									if(driver.findElement(By.cssSelector("div[class='error-content'] p")).getText().equalsIgnoreCase("404"))
									{
										processStatus.add(courseURL+" 404 ERROR");
									}
								}
								
								
								driver.close();
								driver.switchTo().window(parentWindow);
								
							}
						}
						driver.switchTo().window(parentWindow);
					}
					driver.switchTo().window(parentWindow);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			processStatus.add("MicrosoftScourses");
		}
		return processStatus;
	}
}
