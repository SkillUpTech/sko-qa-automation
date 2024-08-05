package com.palm.regressionTesting;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TNSDC_Phase1Locator
{
	WebDriver driver;
	public TNSDC_Phase1Locator(WebDriver driver) 
	{
		this.driver = driver;
		
	}
	public String verifyloginPage(String user, String pwd)
	{
		String result = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement clickLogin = driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickLogin);

			if(clickLogin.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickLogin);
				Set<String> windows = driver.getWindowHandles();
				for(String window : windows)
				{
					driver.switchTo().window(window);
					
					if(driver.getCurrentUrl().contains("login?"))
					{
						driver.switchTo().window(window);
						
						WebElement usernameLocator = driver.findElement(By.xpath("//input[@id='email']"));
						js.executeScript("arguments[0].scrollIntoView();", usernameLocator);
						usernameLocator.sendKeys(user);
						WebElement passwordLocator = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
						js.executeScript("arguments[0].scrollIntoView();", passwordLocator);
						passwordLocator.sendKeys(pwd);
						WebElement clickLoginIcon = driver.findElement(By.xpath("//input[@id='login_in']"));
						js.executeScript("arguments[0].scrollIntoView();", clickLoginIcon);
						js.executeScript("arguments[0].click()", clickLoginIcon);
						
					}
				}
				Set<String> allWindows = driver.getWindowHandles();
				for(String dashboardWindow : allWindows)
				{
					driver.switchTo().window(dashboardWindow);
					if(driver.getCurrentUrl().contains("dashboard"))
					{
						driver.switchTo().window(dashboardWindow);
						System.out.println("dashboard page");
					}
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public String verifyURL(String url)
	{
		String result = "";
		try
		{
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			String modifyURL = driver.getCurrentUrl();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			URL getUrl = new URL(modifyURL);
			String host = getUrl.getHost();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			driver.get("https://"+host+"/tnc-mentor/dashboard/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			Thread.sleep(1000);
			System.out.println("Mentor dashboard page");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<String> MentorDashboardProcess(ArrayList<String> data)
	{
		ArrayList<String> processStatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			ArrayList<String> getDataFromExcel = new ArrayList<String>();
			for(int i = 0; i < data.size(); i++)
			{
				if(i == 0)
				{
					continue;
				}
				String info[] = data.get(i).split("=");
				getDataFromExcel.add(info[1]);
			}
			System.out.println(getDataFromExcel);
			try
			{
				WebElement collegeNameLocator = driver.findElement(By.xpath("//span[@class='fw-bold mentorlanding_fWeight5__rBayU']"));
				js.executeScript("arguments[0].scrollIntoView();", collegeNameLocator);
				
				if(collegeNameLocator.isDisplayed())
				{
					if(!getDataFromExcel.get(0).equalsIgnoreCase(collegeNameLocator.getText()))
					{
						processStatus.add("collegeNameFail");
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in collegeName");
			}
			try
			{
				WebElement courseName = driver.findElement(By.xpath("//div[contains(@class,'projectName')]"));
				js.executeScript("arguments[0].scrollIntoView();", courseName);
				if(courseName.isDisplayed())
				{
					if(!getDataFromExcel.get(1).equalsIgnoreCase(courseName.getText()))
					{
						processStatus.add("courseNameFail");
					}
					else
					{
						js.executeScript("arguments[0].click()", courseName);
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in courseName");
			}
			try
			{
				boolean checkProjectNameStatus = false;
				List<WebElement> projectName = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
				for(int i = 0; i < projectName.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();", projectName.get(i));
					WebElement checkProjectName = projectName.get(i).findElement(By.xpath(".//td"));
					js.executeScript("arguments[0].scrollIntoView();", checkProjectName);
					if(checkProjectName.getText().equalsIgnoreCase(getDataFromExcel.get(2)))
					{
						checkProjectNameStatus = true;
						break;
					}
				}
				if(checkProjectNameStatus == false)
				{
					processStatus.add("projectNameFail");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in projectName");
			}
			try
			{
				boolean checkViewButtonStatus = false;
				List<WebElement> projectName = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr"));
				for(int i = 0; i < projectName.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();", projectName.get(i));
					WebElement checkProjectName = projectName.get(i).findElement(By.xpath(".//td"));
					js.executeScript("arguments[0].scrollIntoView();", checkProjectName);
					if(checkProjectName.getText().equalsIgnoreCase(getDataFromExcel.get(2)))
					{
						if(projectName.get(i).findElements(By.xpath(".//td//button[@class='globbtn terciarylightbg undefined']")).size()>0)
						{
							WebElement checkViewButton = projectName.get(i).findElement(By.xpath(".//td//button[@class='globbtn terciarylightbg undefined']"));
							if(checkViewButton.getText().equalsIgnoreCase("View Teams"))
							{
								js.executeScript("arguments[0].click()", checkViewButton);
								checkViewButtonStatus = true;
								break;
							}
						}
						
					}
				}
				if(checkViewButtonStatus == false)
				{
					processStatus.add("viewTeamFail");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in viewTeamButton");
			}
			try
			{
				if(driver.findElements(By.xpath("//div/button[@class='globbtn terciarylightbg undefined']")).size()>0)
				{
					WebElement checkCreateTeam = driver.findElement(By.xpath("//div/button[@class='globbtn terciarylightbg undefined']"));
					js.executeScript("arguments[0].scrollIntoView();", checkCreateTeam);
					if(checkCreateTeam.isDisplayed())
					{
						js.executeScript("arguments[0].click()", checkCreateTeam);
					}
				}
				else
				{
					processStatus.add("createTeamFail");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in createTeamButton");
			}
			try
			{
				List<WebElement> userList = driver.findElements(By.xpath("//div[contains(@class,'mb-2')]"));
				for(int i = 0; i < userList.size(); i++)
				{
					if(i == 0)
					{
						js.executeScript("arguments[0].scrollIntoView();", userList.get(i));
						if(userList.get(i).isDisplayed())
						{
							js.executeScript("arguments[0].click()", userList.get(i));
							if(driver.findElements(By.xpath("//div[@class='d-flex flex-column align-items-center mt-4 col-md-2 col-12']//img[contains(@srcset,'Right')]")).size()>0)
							{
								WebElement clickRightArrow = driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center mt-4 col-md-2 col-12']//img[contains(@srcset,'Right')]"));
								js.executeScript("arguments[0].scrollIntoView();", clickRightArrow);
								if(clickRightArrow.isDisplayed())
								{
									js.executeScript("arguments[0].click()", clickRightArrow);
									break;
								}
							}
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in selectUser");
			}
			try
			{
				List<WebElement> userList = driver.findElements(By.xpath("//div[contains(@class,'mb-2')]"));
				for(int i = 0; i < userList.size(); i++)
				{
					if(i == 0)
					{
						js.executeScript("arguments[0].scrollIntoView();", userList.get(i));
						if(userList.get(i).isDisplayed())
						{
							js.executeScript("arguments[0].click()", userList.get(i));
							if(driver.findElements(By.xpath("//div[@class='d-flex flex-column align-items-center mt-4 col-md-2 col-12']//img[contains(@srcset,'Right')]")).size()>0)
							{
								WebElement clickLeftArrow = driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center mt-4 col-md-2 col-12']//img[contains(@srcset,'Left')]"));
								js.executeScript("arguments[0].scrollIntoView();", clickLeftArrow);
								if(clickLeftArrow.isDisplayed())
								{
									js.executeScript("arguments[0].click()", clickLeftArrow);
									break;
								}
							}
						}
					}	
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in UnSelectUser");
			}
			try
			{
				List<WebElement> userList = driver.findElements(By.xpath("//div[contains(@class,'mb-2')]"));
				for(int i = 0; i < userList.size(); i++)
				{
					if(i == 0)
					{
						js.executeScript("arguments[0].scrollIntoView();", userList.get(i));
						if(userList.get(i).isDisplayed())
						{
							js.executeScript("arguments[0].click()", userList.get(i));
							if(driver.findElements(By.xpath("//div[@class='d-flex flex-column align-items-center mt-4 col-md-2 col-12']//img[contains(@srcset,'Right')]")).size()>0)
							{
								WebElement clickRightArrow = driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center mt-4 col-md-2 col-12']//img[contains(@srcset,'Right')]"));
								js.executeScript("arguments[0].scrollIntoView();", clickRightArrow);
								if(clickRightArrow.isDisplayed())
								{
									js.executeScript("arguments[0].click()", clickRightArrow);
									break;
								}
							}
						}
					}
				}
				WebElement clickSaveButton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
				js.executeScript("arguments[0].click()", clickSaveButton);
				if(clickSaveButton.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickSaveButton);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in saveButton");
			}
			try
			{
				List<WebElement> userList = driver.findElements(By.xpath("//div[contains(@class,'mb-2')]"));
				for(int i = 0; i < userList.size(); i++)
				{
					if(i == 0)
					{
						js.executeScript("arguments[0].scrollIntoView();", userList.get(i));
						if(userList.get(i).isDisplayed())
						{
							js.executeScript("arguments[0].click()", userList.get(i));
							if(driver.findElements(By.xpath("//div[@class='d-flex flex-column align-items-center mt-4 col-md-2 col-12']//img[contains(@srcset,'Right')]")).size()>0)
							{
								WebElement clickRightArrow = driver.findElement(By.xpath("//div[@class='d-flex flex-column align-items-center mt-4 col-md-2 col-12']//img[contains(@srcset,'Right')]"));
								js.executeScript("arguments[0].scrollIntoView();", clickRightArrow);
								if(clickRightArrow.isDisplayed())
								{
									js.executeScript("arguments[0].click()", clickRightArrow);
									break;
								}
							}
						}
					}
				}
				WebElement clickBackButton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
				js.executeScript("arguments[0].click()", clickBackButton);
				if(clickBackButton.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickBackButton);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in backButton");
			}
		//	js.executeScript("arguments[0].click()", clickDropdownIcon);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return processStatus;
	}
}
