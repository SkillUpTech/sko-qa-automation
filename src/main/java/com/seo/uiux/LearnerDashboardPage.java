package com.seo.uiux;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;

public class LearnerDashboardPage
{
	
	WebDriver driver;
	String dashboardURL = "";
	String currentPageType = "";
	String parentWindow = "";
	public LearnerDashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public int getHTTPResponse(String urlString)
	{
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode(); // Returns HTTP status code
        } catch (IOException e) {
            System.out.println("Error checking URL: " + urlString);
            return -1; // Return -1 if an error occurs
        }
    }
	String programName = "";
	
	public void checkDashboardPage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			
			parentWindow = driver.getCurrentUrl();
			currentPageType = "";
			WebElement clickLogin = driver.findElement(By.xpath("//a[normalize-space()='LOGIN']"));
			js.executeScript("arguments[0].scrollIntoView();", clickLogin);
			String loginURL = clickLogin.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(loginURL);
			dashboardURL = driver.getWindowHandle();
			
			WebElement enterMail = driver.findElement(By.xpath("//input[@id='email']"));
			js.executeScript("arguments[0].scrollIntoView();", enterMail);
			enterMail.sendKeys("Hemamalini@skillup.tech");
			WebElement enterPassword = driver.findElement(By.xpath("//input[@id='password']"));
			js.executeScript("arguments[0].scrollIntoView();", enterPassword);
			enterPassword.sendKeys("Test@123");
			WebElement clickLoginButton = driver.findElement(By.xpath("//input[@id='login_in']"));
			js.executeScript("arguments[0].scrollIntoView();", clickLoginButton);
			js.executeScript("arguments[0].click();", clickLoginButton);
			Thread.sleep(2000);
		}
		catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		
	}
	public ArrayList<String> checkImage(ArrayList<String> data)
	{
		this.checkDashboardPage();
		ArrayList<String> status = new ArrayList<String>();
		String width = data.get(4);
		String height = data.get(5);
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
				String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
				String getProgramCardImage = UILocators.getLocator(currentPageType, "programCardImage");
				String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
				{
					List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
					
					for(WebElement card : listOfProgramCards)
					{
						if(card.findElements(By.xpath(getProgramCardImage)).size()>0)
						{
							
							WebElement image = card.findElement(By.xpath(getProgramCardImage));
							String appWidth = image.getCssValue("width");
							String appHeight = image.getCssValue("height");
							
							String imageSrc = image.getAttribute("src");
							
							WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
							
							programName = getProgramName.getText();
							
							
							
							if (imageSrc.isEmpty() || imageSrc.equals(null))
							{
								status.add("Program Image is Broken : "+programName);
							}
							int respStringCode = getHTTPResponse(imageSrc);
							Assert.assertEquals(respStringCode, 200, "Broken Image: " + imageSrc);
							if (appWidth != width || appHeight != height) 
							{
								status.add("Image size not match for "+programName+ " /n "
										+ "app image width is "+appWidth+ " , "+"app image height is "+appHeight);
								
								System.out.println("Bug: Image size mismatch. App: " + appWidth + "x" + appHeight  +"y");
							} 
						}
						else
						{
							status.add("no image "+programName);
						}
					}
					
				}
			}
			
			
			
			
		}
		catch(Exception e)
		{
			status.add("fail- on Program image verification");
		}
		return status;
	}
	public ArrayList<String> checkProgramIcon(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String width = data.get(4);
		String height = data.get(5);
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			String getProgramIcon = UILocators.getLocator(currentPageType, "programIcon");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramIcon)).size()>0)
					{
						WebElement checkProgramIcon = card.findElement(By.xpath(getProgramIcon));
						String appWidth = checkProgramIcon.getCssValue("width");
						String appHeight = checkProgramIcon.getCssValue("height");
						String imageSrc = checkProgramIcon.getAttribute("src");
						
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						
						
						if (imageSrc.isEmpty() || imageSrc.equals(null))
						{
							status.add("Program icon is Broken : "+programName);
						}
						int responseCode = getHTTPResponse(imageSrc);
						Assert.assertEquals(responseCode, 200, "Broken Image: " + imageSrc);
						if (appWidth != width || appHeight != height) 
						{
							status.add("program icon size not match for "+programName+ " /n "
									+ "app program icon width is "+appWidth+ " , "+"app program icon height is "+appHeight);
							
							System.out.println("Bug: program icon size mismatch. App: " + appWidth + "x" + appHeight  +"y");
						} 
					}
				}
			}
		}
		}
		catch(Exception e)
		{
			status.add("fail - program icon verification");
		}
		return status;
	}
	public ArrayList<String> checkProgramLabel(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String width = data.get(4);
		String height = data.get(5);
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			
			String getProgramNameLabel = UILocators.getLocator(currentPageType, "programNameLabel");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramNameLabel)).size()>0)
					{
						WebElement checkProgramNameLabel = card.findElement(By.xpath(getProgramNameLabel));
						String appWidth =checkProgramNameLabel.getCssValue("width");
						String appHeight = checkProgramNameLabel.getCssValue("height");
						String fontName = checkProgramNameLabel.getCssValue("font-family");
						String fontSize = checkProgramNameLabel.getCssValue("font-size");
						String fontColor = checkProgramNameLabel.getCssValue("color");
						String fontThickness = checkProgramNameLabel.getCssValue("font-weight");
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						
				        
						if (appWidth != width || appHeight != height) 
						{
							status.add("program label size not match for "+programName+ " /n "
									+ "app program label width is "+appWidth+ " , "+"app program label height is "+appHeight);
							
							System.out.println("Bug: label size mismatch. App: " + appWidth + "x" + appHeight  +"y");
						} 
						if(!fontName.equalsIgnoreCase(data.get(6)))
						{
							status.add("program name label fontname is not match with doc : "+programName);
						}
						if(!fontSize.equalsIgnoreCase(data.get(7)))
						{
							status.add("program name label fontSize is not match with doc : "+programName);
						}
						if(!fontColor.equalsIgnoreCase(data.get(8)))
						{
							status.add("program name label fontColor is not match with doc : "+programName);
						}
						if(!fontThickness.equalsIgnoreCase(data.get(9)))
						{
							status.add("program name label fontThickness is not match with doc : "+programName);
						}
					}
				}
			}
			}
		}
		catch(Exception e)
		{
			status.add("fail - program label verification");
		}
		return status;
	}
	public ArrayList<String> checkProgramName(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String width = data.get(4);
		String height = data.get(5);
		
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramTitle)).size()>0)
					{
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						
						String appWidth =getProgramName.getCssValue("width");
						String appHeight = getProgramName.getCssValue("height");
						String fontName = getProgramName.getCssValue("font-family");
				        String fontSize = getProgramName.getCssValue("font-size");
				        String fontColor = getProgramName.getCssValue("color");
				        String fontThickness = getProgramName.getCssValue("font-weight");
				        
						if (appWidth != width || appHeight != height) 
						{
							status.add("program name size not match for "+programName+ " /n "
									+ "app program name  width is "+appWidth+ " , "+"app program name  height is "+appHeight);
							
							System.out.println("Bug: program name  size mismatch. App: " + appWidth + "x" + appHeight  +"y");
						} 
						
						if(!fontName.equalsIgnoreCase(data.get(6)))
						{
							status.add("ProgramName fontname is not match with doc : "+programName);
						}
						if(!fontSize.equalsIgnoreCase(data.get(7)))
						{
							status.add("ProgramName fontSize is not match with doc : "+programName);
						}
						if(!fontColor.equalsIgnoreCase(data.get(8)))
						{
							status.add("ProgramName fontColor is not match with doc : "+programName);
						}
						if(!fontThickness.equalsIgnoreCase(data.get(9)))
						{
							status.add("ProgramName fontThickness is not match with doc : "+programName);
						}
					}
				}
			}
			}
		}
		catch(Exception e)
		{
			status.add("fail - program name verification");
		}
		return status;
	}
	public ArrayList<String> checkProgramPartner(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			String getProgramPartner = UILocators.getLocator(currentPageType, "programPartner");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramPartner)).size()>0)
					{
						WebElement checkProgramPartner = card.findElement(By.xpath(getProgramPartner));
						String fontName = checkProgramPartner.getCssValue("font-family");
						String fontSize = checkProgramPartner.getCssValue("font-size");
						String fontColor = checkProgramPartner.getCssValue("color");
						String fontThickness = checkProgramPartner.getCssValue("font-weight");
						String hrefValue = checkProgramPartner.getAttribute("href");
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						
						programName = getProgramName.getText();
				        
				        if (hrefValue != null && !hrefValue.trim().isEmpty()) 
				        {
				        	status.add("partner link is not available : "+programName);
				        }
				        
				        if(!fontName.equalsIgnoreCase(data.get(6)))
						{
							status.add("Program Partner fontname is not match with doc : "+programName);
						}
						if(!fontSize.equalsIgnoreCase(data.get(7)))
						{
							status.add("Program Partner fontSize is not match with doc : "+programName);
						}
						if(!fontColor.equalsIgnoreCase(data.get(8)))
						{
							status.add("Program Partner fontColor is not match with doc : "+programName);
						}
						if(!fontThickness.equalsIgnoreCase(data.get(9)))
						{
							status.add("Program Partner fontThickness is not match with doc : "+programName);
						}
					}
				}
			}
			}
		}
		catch(Exception e)
		{
			status.add("fail - Program Partner verification");
		}
		return status;
	}
	public ArrayList<String> checkProgramLevel(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			String getProgramLevel = UILocators.getLocator(currentPageType, "programLevel");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramLevel)).size()>0)
					{
						WebElement checkProgramLevel = card.findElement(By.xpath(getProgramLevel));
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						String fontName = checkProgramLevel.getCssValue("font-family");
				        String fontSize = checkProgramLevel.getCssValue("font-size");
				        String fontColor = checkProgramLevel.getCssValue("color");
				        String fontThickness = checkProgramLevel.getCssValue("font-weight");
				        
				        
				        if(!fontName.equalsIgnoreCase(data.get(6)))
						{
							status.add("Program Level fontname is not match with doc : "+programName);
						}
						if(!fontSize.equalsIgnoreCase(data.get(7)))
						{
							status.add("Program Level fontSize is not match with doc : "+programName);
						}
						if(!fontColor.equalsIgnoreCase(data.get(8)))
						{
							status.add("Program Level fontColor is not match with doc : "+programName);
						}
						if(!fontThickness.equalsIgnoreCase(data.get(9)))
						{
							status.add("Program Level fontThickness is not match with doc : "+programName);
						}
					}
				}
			}
		}
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return status;
	}
	public ArrayList<String> checkStartNowButton(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String width = data.get(4);
		String height = data.get(5);
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			String getProgramStartNowButton = UILocators.getLocator(currentPageType, "programStartNowButton");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramStartNowButton)).size()>0)
					{
						WebElement checkProgramStartNowButton = card.findElement(By.xpath(getProgramStartNowButton));
						String fontName = checkProgramStartNowButton.getCssValue("font-family");
						String fontSize = checkProgramStartNowButton.getCssValue("font-size");
						String fontColor = checkProgramStartNowButton.getCssValue("color");
						String fontThickness = checkProgramStartNowButton.getCssValue("font-weight");
						String appWidth =checkProgramStartNowButton.getCssValue("width");
						String appHeight = checkProgramStartNowButton.getCssValue("height");
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						if (appWidth != width || appHeight != height) 
						{
							status.add("ProgramStartNowButton size not match for "+programName+ " /n "
									+ "app ProgramStartNowButton width is "+appWidth+ " , "+"app label height is "+appHeight);
							
							System.out.println("Bug: ProgramStartNowButton size mismatch. App: " + appWidth + "x" + appHeight  +"y");
						} 
						if(!fontName.equalsIgnoreCase(data.get(6)))
						{
							status.add("startNow Button fontname is not match with doc : "+programName);
						}
						if(!fontSize.equalsIgnoreCase(data.get(7)))
						{
							status.add("startNow Button fontSize is not match with doc : "+programName);
						}
						if(!fontColor.equalsIgnoreCase(data.get(8)))
						{
							status.add("startNow Button fontColor is not match with doc : "+programName);
						}
						if(!fontThickness.equalsIgnoreCase(data.get(9)))
						{
							status.add("startNow Button fontThickness is not match with doc : "+programName);
						}
					}
				}
			}
		}
		}
		catch(Exception e)
		{
			status.add("fail - startNow verification");
		}
		return status;
	}

	public ArrayList<String> checkShareIcon(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String width = data.get(4);
		String height = data.get(5);
		try 
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			String getProgramShareIcon = UILocators.getLocator(currentPageType, "programShareIcon");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramShareIcon)).size()>0)
					{
						WebElement checkProgramShareIcon = card.findElement(By.xpath(getProgramShareIcon));
						String appWidth =checkProgramShareIcon.getCssValue("width");
						String appHeight = checkProgramShareIcon.getCssValue("height");
						String fontName = checkProgramShareIcon.getCssValue("font-family");
						String fontSize = checkProgramShareIcon.getCssValue("font-size");
						String fontColor = checkProgramShareIcon.getCssValue("color");
						String fontThickness = checkProgramShareIcon.getCssValue("font-weight");
						String hrefValue = checkProgramShareIcon.getAttribute("href");
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						
						if (appWidth != width || appHeight != height) 
						{
							status.add("share icon size not match for "+programName+ " /n "
									+ "app share icon width is "+appWidth+ " , "+"app label height is "+appHeight);
							
							System.out.println("Bug: share icon size mismatch. App: " + appWidth + "x" + appHeight  +"y");
						} 
					        
					        if (hrefValue != null && !hrefValue.trim().isEmpty()) 
					        {
					        	status.add("share icon link is not available : "+programName);
					        }
					        
					        if(!fontName.equalsIgnoreCase(data.get(6)))
							{
								status.add("share icon fontname is not match with doc : "+programName);
							}
							if(!fontSize.equalsIgnoreCase(data.get(7)))
							{
								status.add("share icon fontSize is not match with doc : "+programName);
							}
							if(!fontColor.equalsIgnoreCase(data.get(8)))
							{
								status.add("share icon fontColor is not match with doc : "+programName);
							}
							if(!fontThickness.equalsIgnoreCase(data.get(9)))
							{
								status.add("share icon fontThickness is not match with doc : "+programName);
							}
					}
				}
			}
		}
		} 
		catch (Exception e) {
			status.add("fail - share icon verification");
		}
		return status;
	}

	public ArrayList<String> checkIncludeCourses(ArrayList<String> data) {
		ArrayList<String> status = new ArrayList<String>();
		String width = data.get(4);
		String height = data.get(5);
		try 
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			String getProgramIncludeCourses = UILocators.getLocator(currentPageType, "programIncludeCourses");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramIncludeCourses)).size()>0)
					{
						WebElement checkIncludeCourses = card.findElement(By.xpath(getProgramIncludeCourses));
						String appWidth =checkIncludeCourses.getCssValue("width");
						String appHeight = checkIncludeCourses.getCssValue("height");
						String fontName = checkIncludeCourses.getCssValue("font-family");
						String fontSize = checkIncludeCourses.getCssValue("font-size");
						String fontColor = checkIncludeCourses.getCssValue("color");
						String fontThickness = checkIncludeCourses.getCssValue("font-weight");
						String hrefValue = checkIncludeCourses.findElement(By.xpath("./img")).getAttribute("src");

						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						
						if (appWidth != width || appHeight != height) 
						{
							status.add("include courses size not match for "+programName+ " /n "
									+ "app include courses width is "+appWidth+ " , "+"app label height is "+appHeight);
							
							System.out.println("Bug: include courses size mismatch. App: " + appWidth + "x" + appHeight  +"y");
						} 
						 
					        
					        if (hrefValue != null && !hrefValue.trim().isEmpty()) 
					        {
					        	status.add("include courses link is not available : "+programName);
					        }
					        
					        if(!fontName.equalsIgnoreCase(data.get(6)))
							{
								status.add("include courses fontname is not match with doc : "+programName);
							}
							if(!fontSize.equalsIgnoreCase(data.get(7)))
							{
								status.add("include courses fontSize is not match with doc : "+programName);
							}
							if(!fontColor.equalsIgnoreCase(data.get(8)))
							{
								status.add("include courses fontColor is not match with doc : "+programName);
							}
							if(!fontThickness.equalsIgnoreCase(data.get(9)))
							{
								status.add("include courses fontThickness is not match with doc : "+programName);
							}
					}
				}
			}
			}
		} catch (Exception e) {
			status.add("fail - include courses link verification");
		}
		return status;
	}

	public ArrayList<String> checkLinkedCourses(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			String getProgramLinkedCourses = UILocators.getLocator(currentPageType, "programLinkedCourses");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramLinkedCourses)).size()>0)
					{
						WebElement checkProgramLinkedCourses = card.findElement(By.xpath(getProgramLinkedCourses));
						
						String fontName = checkProgramLinkedCourses.getCssValue("font-family");
						String fontSize = checkProgramLinkedCourses.getCssValue("font-size");
						String fontColor = checkProgramLinkedCourses.getCssValue("color");
						String fontThickness = checkProgramLinkedCourses.getCssValue("font-weight");
						
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						
						programName = getProgramName.getText();
				        
				        
				        if(!fontName.equalsIgnoreCase(data.get(6)))
						{
							status.add("program - course Name fontname is not match with doc : "+programName);
						}
						if(!fontSize.equalsIgnoreCase(data.get(7)))
						{
							status.add("program - course Name fontSize is not match with doc : "+programName);
						}
						if(!fontColor.equalsIgnoreCase(data.get(8)))
						{
							status.add("program - course Name fontColor is not match with doc : "+programName);
						}
						if(!fontThickness.equalsIgnoreCase(data.get(9)))
						{
							status.add("program - course Name fontThickness is not match with doc : "+programName);
						}
					}
				}
			}
		}
		}
		catch(Exception e)
		{
			status.add("fail - program - course Name verification");
		}
		return status;
	}

	public ArrayList<String> checkGoToCourse(ArrayList<String> data) {
		ArrayList<String> status = new ArrayList<String>();
		String width = data.get(4);
		String height = data.get(5);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if (driver.getCurrentUrl().contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			String getProgramGoToCourse = UILocators.getLocator(currentPageType, "programGoToCourse");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					if(card.findElements(By.xpath(getProgramGoToCourse)).size()>0)
					{
						WebElement checkProgramGoToCourses = card.findElement(By.xpath(getProgramGoToCourse));
						String appWidth =checkProgramGoToCourses.getCssValue("width");
						String appHeight = checkProgramGoToCourses.getCssValue("height");
						String fontName = checkProgramGoToCourses.getCssValue("font-family");
						String fontSize = checkProgramGoToCourses.getCssValue("font-size");
						String fontColor = checkProgramGoToCourses.getCssValue("color");
						String fontThickness = checkProgramGoToCourses.getCssValue("font-weight");
						String hrefValue = checkProgramGoToCourses.getAttribute("href");
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						
						if (appWidth != width || appHeight != height) 
						{
							status.add("Go To Course size not match for "+programName+ " /n "
									+ "app Go To Course width is "+appWidth+ " , "+"app label height is "+appHeight);
							
							System.out.println("Bug: Go To Course size mismatch. App: " + appWidth + "x" + appHeight  +"y");
						} 
						 
					        
					        if (hrefValue != null && !hrefValue.trim().isEmpty()) 
					        {
					        	status.add("Go To courses link is not available : "+programName);
					        }
					        
					        if(!fontName.equalsIgnoreCase(data.get(6)))
							{
								status.add("Go To  courses fontname is not match with doc : "+programName);
							}
							if(!fontSize.equalsIgnoreCase(data.get(7)))
							{
								status.add("Go To  courses fontSize is not match with doc : "+programName);
							}
							if(!fontColor.equalsIgnoreCase(data.get(8)))
							{
								status.add("Go To  courses fontColor is not match with doc : "+programName);
							}
							if(!fontThickness.equalsIgnoreCase(data.get(9)))
							{
								status.add("Go To  courses fontThickness is not match with doc : "+programName);
							}
					}
				}
			}
		}
		} catch (Exception e) {
			status.add("fail - Go To Course link verification");
		}
		return status;
	}

}
