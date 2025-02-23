package com.seo.uiux;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LearnerDashboardPage
{
	
	WebDriver driver;
	
	public LearnerDashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	String dashboardURL = driver.getCurrentUrl();
	String currentPageType = "";
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
	public ArrayList<String> checkImage(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		int width = Integer.valueOf(data.get(4));
		int height = Integer.valueOf(data.get(5));
		try
		{
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramCardImage = UILocators.getLocator(currentPageType, "programCardImage");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			
			
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					if(card.findElements(By.xpath(getProgramCardImage)).size()>0)
					{
						
						WebElement image = card.findElement(By.xpath(getProgramCardImage));
						int appWidth = image.getSize().getWidth();
						int appHeight = image.getSize().getHeight();
						
						String imageSrc = image.getAttribute("src");
						
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						
						programName = getProgramName.getText();
						
						
						
						if (imageSrc.isEmpty() || imageSrc.equals(null))
						{
							status.add("Program Image is Broken : "+programName);
						}
						int responseCode = getHTTPResponse(imageSrc);
						Assert.assertEquals(responseCode, 200, "Broken Image: " + imageSrc);
						if (appWidth != width || appHeight != height) 
						{
							status.add("Image size not match for "+programName+ " /n "
									+ "app image width is "+appWidth+ " , "+"app image height is "+appWidth);
							
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
		catch(Exception e)
		{
			status.add("fail- on Program image verification");
		}
		return status;
	}
	public ArrayList<String> checkProgramIcon(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		int width = Integer.valueOf(data.get(4));
		int height = Integer.valueOf(data.get(5));
		try
		{
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			String getProgramIcon = UILocators.getLocator(currentPageType, "programIcon");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					if(card.findElements(By.xpath(getProgramIcon)).size()>0)
					{
						WebElement checkProgramIcon = card.findElement(By.xpath(getProgramIcon));
						int appWidth = checkProgramIcon.getSize().getWidth();
						int appHeight = checkProgramIcon.getSize().getHeight();
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
									+ "app program icon width is "+appWidth+ " , "+"app program icon height is "+appWidth);
							
							System.out.println("Bug: program icon size mismatch. App: " + appWidth + "x" + appHeight  +"y");
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
		int width = Integer.valueOf(data.get(4));
		int height = Integer.valueOf(data.get(5));
		try
		{
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			String getProgramNameLabel = UILocators.getLocator(currentPageType, "programNameLabel");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					if(card.findElements(By.xpath(getProgramNameLabel)).size()>0)
					{
						WebElement checkProgramNameLabel = card.findElement(By.xpath(getProgramNameLabel));
						int appWidth =checkProgramNameLabel.getSize().getWidth();
						int appHeight = checkProgramNameLabel.getSize().getHeight();
						String fontName = checkProgramNameLabel.getCssValue("font-family");
						String fontSize = checkProgramNameLabel.getCssValue("font-size");
						String fontColor = checkProgramNameLabel.getCssValue("color");
						String fontThickness = checkProgramNameLabel.getCssValue("font-weight");
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						
				        
						if (appWidth != width || appHeight != height) 
						{
							status.add("program label size not match for "+programName+ " /n "
									+ "app program label width is "+appWidth+ " , "+"app program label height is "+appWidth);
							
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
		catch(Exception e)
		{
			status.add("fail - program label verification");
		}
		return status;
	}
	public ArrayList<String> checkProgramName(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		int width = Integer.valueOf(data.get(4));
		int height = Integer.valueOf(data.get(5));
		
		try
		{
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					if(card.findElements(By.xpath(getProgramTitle)).size()>0)
					{
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						
						int appWidth =getProgramName.getSize().getWidth();
						int appHeight = getProgramName.getSize().getHeight();
						String fontName = getProgramName.getCssValue("font-family");
				        String fontSize = getProgramName.getCssValue("font-size");
				        String fontColor = getProgramName.getCssValue("color");
				        String fontThickness = getProgramName.getCssValue("font-weight");
				        
						if (appWidth != width || appHeight != height) 
						{
							status.add("program name size not match for "+programName+ " /n "
									+ "app program name  width is "+appWidth+ " , "+"app program name  height is "+appWidth);
							
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
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			String getProgramPartner = UILocators.getLocator(currentPageType, "programPartner");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
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
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			String getProgramLevel = UILocators.getLocator(currentPageType, "programLevel");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
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
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return status;
	}
	public ArrayList<String> checkStartNowButton(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		int width = Integer.valueOf(data.get(4));
		int height = Integer.valueOf(data.get(5));
		try
		{
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			String getProgramStartNowButton = UILocators.getLocator(currentPageType, "programStartNowButton");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					if(card.findElements(By.xpath(getProgramStartNowButton)).size()>0)
					{
						WebElement checkProgramStartNowButton = card.findElement(By.xpath(getProgramStartNowButton));
						String fontName = checkProgramStartNowButton.getCssValue("font-family");
						String fontSize = checkProgramStartNowButton.getCssValue("font-size");
						String fontColor = checkProgramStartNowButton.getCssValue("color");
						String fontThickness = checkProgramStartNowButton.getCssValue("font-weight");
						int appWidth =checkProgramStartNowButton.getSize().getWidth();
						int appHeight = checkProgramStartNowButton.getSize().getHeight();
						WebElement getProgramName = card.findElement(By.xpath(getProgramTitle));
						programName = getProgramName.getText();
						if (appWidth != width || appHeight != height) 
						{
							status.add("ProgramStartNowButton size not match for "+programName+ " /n "
									+ "app ProgramStartNowButton width is "+appWidth+ " , "+"app label height is "+appWidth);
							
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
		catch(Exception e)
		{
			status.add("fail - startNow verification");
		}
		return status;
	}

	public ArrayList<String> checkShareIcon(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		int width = Integer.valueOf(data.get(4));
		int height = Integer.valueOf(data.get(5));
		try 
		{
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			String getProgramShareIcon = UILocators.getLocator(currentPageType, "programShareIcon");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					if(card.findElements(By.xpath(getProgramShareIcon)).size()>0)
					{
						WebElement checkProgramShareIcon = card.findElement(By.xpath(getProgramShareIcon));
						int appWidth =checkProgramShareIcon.getSize().getWidth();
						int appHeight = checkProgramShareIcon.getSize().getHeight();
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
									+ "app share icon width is "+appWidth+ " , "+"app label height is "+appWidth);
							
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
		catch (Exception e) {
			status.add("fail - share icon verification");
		}
		return status;
	}

	public ArrayList<String> checkIncludeCourses(ArrayList<String> data) {
		ArrayList<String> status = new ArrayList<String>();
		int width = Integer.valueOf(data.get(4));
		int height = Integer.valueOf(data.get(5));
		try 
		{
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			String getProgramIncludeCourses = UILocators.getLocator(currentPageType, "programIncludeCourses");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					if(card.findElements(By.xpath(getProgramIncludeCourses)).size()>0)
					{
						WebElement checkIncludeCourses = card.findElement(By.xpath(getProgramIncludeCourses));
						int appWidth =checkIncludeCourses.getSize().getWidth();
						int appHeight = checkIncludeCourses.getSize().getHeight();
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
									+ "app include courses width is "+appWidth+ " , "+"app label height is "+appWidth);
							
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
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			String getProgramLinkedCourses = UILocators.getLocator(currentPageType, "programLinkedCourses");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
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
		catch(Exception e)
		{
			status.add("fail - program - course Name verification");
		}
		return status;
	}

	public ArrayList<String> checkGoToCourse(ArrayList<String> data) {
		ArrayList<String> status = new ArrayList<String>();
		int width = Integer.valueOf(data.get(4));
		int height = Integer.valueOf(data.get(5));
		try {
			if (dashboardURL.contains("learner-dashboard")) 
			{
				currentPageType = "learner-dashboard";
			}
			String getProgramGoToCourse = UILocators.getLocator(currentPageType, "programGoToCourse");
			String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
			String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
			if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
			{
				List<WebElement> listOfProgramCards = driver.findElements(By.xpath(getProgramCardList));
				
				for(WebElement card : listOfProgramCards)
				{
					if(card.findElements(By.xpath(getProgramGoToCourse)).size()>0)
					{
						WebElement checkProgramGoToCourses = card.findElement(By.xpath(getProgramGoToCourse));
						int appWidth =checkProgramGoToCourses.getSize().getWidth();
						int appHeight = checkProgramGoToCourses.getSize().getHeight();
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
									+ "app Go To Course width is "+appWidth+ " , "+"app label height is "+appWidth);
							
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
		} catch (Exception e) {
			status.add("fail - Go To Course link verification");
		}
		return status;
	}

}
