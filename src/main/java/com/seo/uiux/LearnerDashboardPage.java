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
	
	public ArrayList<String> programSectionVerification(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		String dashboardURL = driver.getCurrentUrl();
        String currentPageType = "";
        
		if (dashboardURL.contains("learner-dashboard")) 
		{
			currentPageType = "learner-dashboard";
		}
		
		String getProgramCardList = UILocators.getLocator(currentPageType, "programCardList");
		String getProgramCardImage = UILocators.getLocator(currentPageType, "programCardImage");
		String getProgramIcon = UILocators.getLocator(currentPageType, "programIcon");
		String getProgramNameLabel = UILocators.getLocator(currentPageType, "programNameLabel");
		String getProgramTitle = UILocators.getLocator(currentPageType, "programTitle");
		String getProgramPartner = UILocators.getLocator(currentPageType, "programPartner");
		String getProgramLevel = UILocators.getLocator(currentPageType, "programLevel");
		String getProgramStartNowButton = UILocators.getLocator(currentPageType, "programStartNowButton");
		String getProgramShareIcon = UILocators.getLocator(currentPageType, "programShareIcon");
		String getProgramIncludeCourses = UILocators.getLocator(currentPageType, "programIncludeCourses");
		String getProgramLinkedCourses = UILocators.getLocator(currentPageType, "programLinkedCourses");
		String getProgramGoToCourse = UILocators.getLocator(currentPageType, "programGoToCourse");
		
		int appWidth = driver.findElement(By.xpath(getProgramCardImage)).getSize().getWidth();
		int appHeight = driver.findElement(By.xpath(getProgramCardImage)).getSize().getHeight();
		
		//program icon
		String fontName = "";
		String fontSize = "";
		String fontWeight = "";
		String fontColor = "";
		
		if(driver.findElements(By.xpath(getProgramCardList)).size()>0)
		{
			
			if (driver.findElements(By.xpath(getProgramCardImage)).size() > 0) 
			{
				List<WebElement> image = driver.findElements(By.xpath(getProgramCardImage));
				String imageSrc = image.get(0).getAttribute("src");
				
				if (imageSrc.isEmpty() || imageSrc.equals(null))
				{
					status.add("Program Image is not displayed");
				}
				int responseCode = getHTTPResponse(imageSrc);
	            Assert.assertEquals(responseCode, 200, "Broken Image: " + imageSrc);
			}
			if (driver.findElements(By.xpath(getProgramIcon)).size() > 0)
			{
				
			}
		}
		
		return status;
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
	
	public ArrayList<String> checkImage()
	{
		ArrayList<String> status = new ArrayList<String>();
		
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return status;
	}
	public ArrayList<String> checkProgramIcon()
	{
		ArrayList<String> status = new ArrayList<String>();
		
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return status;
	}
	public ArrayList<String> checkProgramLabel()
	{
		ArrayList<String> status = new ArrayList<String>();
		
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return status;
	}
	public ArrayList<String> checkProgramName()
	{
		ArrayList<String> status = new ArrayList<String>();
		
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return status;
	}
	public ArrayList<String> checkProgramPartner()
	{
		ArrayList<String> status = new ArrayList<String>();
		
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return status;
	}
	public ArrayList<String> checkProgramLevel()
	{
		ArrayList<String> status = new ArrayList<String>();
		
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return status;
	}
	public ArrayList<String> checkStartNowButton()
	{
		ArrayList<String> status = new ArrayList<String>();
		
		try
		{
			
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return status;
	}

	public ArrayList<String> checkShareIcon()
	{
		ArrayList<String> status = new ArrayList<String>();

		try {

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return status;
	}

	public ArrayList<String> checkIncludeCourses() {
		ArrayList<String> status = new ArrayList<String>();

		try {

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return status;
	}

	public ArrayList<String> checkLinkedCourses() {
		ArrayList<String> status = new ArrayList<String>();

		try {

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return status;
	}

	public ArrayList<String> checkGoToCourse() {
		ArrayList<String> status = new ArrayList<String>();

		try {

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return status;
	}

	public ArrayList<String> checkCourseNameGoHere()
	{
		ArrayList<String> status = new ArrayList<String>();

		try {
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return status;
	}
}
