package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class BlogPageValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	BlogPageLocator blogPageLocator;
	String sheetStatus = "Pass";
	public BlogPageValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	public void BlogIcon_FromStage()
	{
		
	}
	public void BlogIcon_FromStagecourses()
	{
		
	}
	@Override
	public String call() throws Exception {
		System.out.println("HeaderFooterInStagecoursesValidation process started");

		try
		{
			/*
			 * driver = this.openDriver(RegressionTesting.nameOfBrowser);
			 * this.blogPageLocator = new BlogPageLocator(driver);
			 * OpenWebsite.openSite(driver);
			 */
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
			  case "BlogIcon_FromStage": 
				  BlogIcon_FromStage(); 
				  break; 
			  case "BlogIcon_FromStagecourses": 
				  BlogIcon_FromStagecourses(); 
				  break; 
			}
		}
	//	DriverManager.quitDriver();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	
	}
}
