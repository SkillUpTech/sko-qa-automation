package com.palm.regressionTesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class ExploreAllLocator
{
	WebDriver driver;
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
				if(driver.findElements(By.xpath("//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//span[contains(text(),'Explore All Courses')]")).size()>0)
				{
					WebElement clickExploreAllLink = driver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu dropdown-cat Header_dropdownMenu')]//span[contains(text(),'Explore All Courses')]"));
					js.executeScript("arguments[0].scrollIntoView();", clickExploreAllLink);
					if(clickExploreAllLink.isDisplayed())
					{
						js.executeScript("arguments[0].click()", clickExploreAllLink);
						driver.switchTo().newWindow(WindowType.TAB);
						String parentWindow = driver.getWindowHandle();
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
						js.executeScript("arguments[0].click()", clickExploreAllFromHomePage);
						driver.switchTo().newWindow(WindowType.TAB);
						Set<String> allWindows = driver.getWindowHandles();
						for(String window : allWindows)
						{
							driver.switchTo().window(window);
							
							if(driver.getCurrentUrl().contains("explore"))
							{
								driver.switchTo().window(window);
								System.out.println("Explore All Page");
								break;
							}
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				status.add("megaMenu_Fail");
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
			WebElement checkCategory = driver.findElement(By.xpath("//div[contains(@class,'d-lg-block')]//div[contains(@class,'CourseSection_topFilterItem')]/p"));
			js.executeScript("arguments[0].scrollIntoView();", checkCategory);
			if(checkCategory.isDisplayed())
			{
				String CategoryNameFromExploreAl = checkCategory.getText();
				System.out.println("active category from homepage : "+CategoryNameFromExploreAl);
				if(CategoryNameFromExploreAl.equalsIgnoreCase(activeCategory))
				{
					System.out.println("same category name : ");
				}
				else
				{
					process = "fail";
				}
			}
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
			if(driver.findElements(By.xpath("//div[contains(@class,'CourseSection_filterMain__t2i09') and not(@id='mobileFilter')]//button[contains(text(),'Clear All')]")).size()>0)
			{
				WebElement clickClearAll = driver.findElement(By.xpath("//div[contains(@class,'CourseSection_filterMain__t2i09') and not(@id='mobileFilter')]//button[contains(text(),'Clear All')]"));
				js.executeScript("arguments[0].scrollIntoView();", clickClearAll);
				if(clickClearAll.isDisplayed())
				{
					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
