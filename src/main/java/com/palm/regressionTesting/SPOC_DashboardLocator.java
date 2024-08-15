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

public class SPOC_DashboardLocator
{
	WebDriver driver;
	ArrayList<String> studentData = new ArrayList<String>();
	public SPOC_DashboardLocator(WebDriver driver) 
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
			driver.get("https://"+host+"/tnsdc/spoc-home/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			Thread.sleep(1000);
			System.out.println("TNSDC Phase 2 Mentor dashboard page ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<String> checkMentorCreation(ArrayList<String> data)
	{
		ArrayList<String> dataFromExcel = new ArrayList<String>();
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0; i < data.size(); i++)
		{
			if(i == 0)
			{
				continue;
			}
			else
			{
				String word[] = data.get(i).split("=");
				dataFromExcel.add(word[1]);
			}
		}
		try
		{
			WebElement clickAddMentor = driver.findElement(By.xpath("//button[contains(text(),'+ Add Mentor')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickAddMentor);
			if(clickAddMentor.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickAddMentor);
			}
			WebElement enterFirstName = driver.findElement(By.xpath("//input[@id='first_name']"));
			js.executeScript("arguments[0].scrollIntoView();", enterFirstName);
			if(enterFirstName.isDisplayed())
			{
				enterFirstName.sendKeys(dataFromExcel.get(0));
			}
			WebElement enterLastName = driver.findElement(By.xpath("//input[@id='last_name']"));
			js.executeScript("arguments[0].scrollIntoView();", enterLastName);
			if(enterLastName.isDisplayed())
			{
				enterLastName.sendKeys(dataFromExcel.get(1));
			}
			WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
			js.executeScript("arguments[0].scrollIntoView();", email);
			if(email.isDisplayed())
			{
				email.sendKeys(dataFromExcel.get(2));
			}
			//String labelXpath = "//label[contains(text(), '"+data.get(4)+"')]";
			
			List<WebElement> labelElement = driver.findElements(By.xpath("//label[contains(@style,'cursor: pointer')]"));
			for(int j = 0; j < labelElement.size(); j++)
			{
				js.executeScript("arguments[0].scrollIntoView();", labelElement.get(j));
				
				if(labelElement.get(j).getText().equalsIgnoreCase(dataFromExcel.get(3)))
				{
					WebElement enableCourse = labelElement.get(j).findElement(By.xpath("./preceding-sibling::input[@type='checkbox']"));
					js.executeScript("arguments[0].scrollIntoView();", enableCourse);
					if(enableCourse.isDisplayed())
					{
						js.executeScript("arguments[0].click()", enableCourse);
						break;
					}
				}
			}
			
			WebElement clickAdd = driver.findElement(By.xpath("//div[contains(@class,'postOrPutUser_btnRightside')]//button[contains(text(),'Add')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickAdd);
			if(clickAdd.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickAdd);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	
	public ArrayList<String> checkUpdateMentor(ArrayList<String> data)
	{
		ArrayList<String> dataFromExcel = new ArrayList<String>();
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0; i < data.size(); i++)
		{
			if(i == 0)
			{
				continue;
			}
			else
			{
				String word[] = data.get(i).split("=");
				dataFromExcel.add(word[1]);
			}
		}
		try
		{
			List<WebElement> locateRow = driver.findElements(By.xpath("//tbody[contains(@class,'tableContent_tableBody')]/tr"));
			for(int j = 0; j < locateRow.size(); j++)
			{
				js.executeScript("arguments[0].scrollIntoView();", locateRow.get(j));
				if(locateRow.get(j).isDisplayed())
				{
					List<WebElement> locateUpdateRow = locateRow.get(j).findElements(By.xpath("./td[contains(@class,'tableContent_rowItem')]"));
					for(int k = 0; k < locateUpdateRow.size(); k++)
					{
						js.executeScript("arguments[0].scrollIntoView();", locateUpdateRow.get(k));
						if(locateUpdateRow.get(k).isDisplayed())
						{
							if(locateUpdateRow.get(k).getText().equalsIgnoreCase(dataFromExcel.get(0)))
							{
								WebElement updateRow = locateRow.get(j).findElement(By.xpath("]//span[contains(@class,'tableContent_itemUpdate')]"));
								js.executeScript("arguments[0].scrollIntoView();", updateRow);
								if(updateRow.isDisplayed())
								{
									js.executeScript("arguments[0].click()", updateRow);
								}
							}
						}
					}
				}
			}
			WebElement enterFirstName = driver.findElement(By.xpath("//input[@id='first_name']"));
			js.executeScript("arguments[0].scrollIntoView();", enterFirstName);
			if(enterFirstName.isDisplayed())
			{
				enterFirstName.clear();
				enterFirstName.sendKeys(dataFromExcel.get(1));
			}
			WebElement enterLastName = driver.findElement(By.xpath("//input[@id='last_name']"));
			js.executeScript("arguments[0].scrollIntoView();", enterLastName);
			if(enterLastName.isDisplayed())
			{
				enterLastName.clear();
				
				enterLastName.sendKeys(dataFromExcel.get(2));
			}
			WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
			js.executeScript("arguments[0].scrollIntoView();", email);
			if(email.isDisplayed())
			{
				email.clear();
				email.sendKeys(dataFromExcel.get(3));
			}
			//String labelXpath = "//label[contains(text(), '"+data.get(4)+"')]";
			
			List<WebElement> labelElement = driver.findElements(By.xpath("//label[contains(@style,'cursor: pointer')]"));
			for(int j = 0; j < labelElement.size(); j++)
			{
				js.executeScript("arguments[0].scrollIntoView();", labelElement.get(j));
				
				if(labelElement.get(j).getText().equalsIgnoreCase(dataFromExcel.get(4)))
				{
					WebElement enableCourse = labelElement.get(j).findElement(By.xpath("./preceding-sibling::input[@type='checkbox']"));
					js.executeScript("arguments[0].scrollIntoView();", enableCourse);
					if(enableCourse.isDisplayed())
					{
						js.executeScript("arguments[0].click()", enableCourse);
						break;
					}
				}
			}
			
			WebElement clickUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickUpdate);
			if(clickUpdate.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickUpdate);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	
	public ArrayList<String> checkDeleteMentor(ArrayList<String> data)
	{
		ArrayList<String> dataFromExcel = new ArrayList<String>();
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0; i < data.size(); i++)
		{
			if(i == 0)
			{
				continue;
			}
			else
			{
				String word[] = data.get(i).split("=");
				dataFromExcel.add(word[1]);
			}
		}
		try
		{
			List<WebElement> locateRow = driver.findElements(By.xpath("//tbody[contains(@class,'tableContent_tableBody')]/tr"));
			for(int j = 0; j < locateRow.size(); j++)
			{
				js.executeScript("arguments[0].scrollIntoView();", locateRow.get(j));
				if(locateRow.get(j).isDisplayed())
				{
					List<WebElement> locateUpdateRow = locateRow.get(j).findElements(By.xpath("./td[contains(@class,'tableContent_rowItem')]"));
					for(int k = 0; k < locateUpdateRow.size(); k++)
					{
						js.executeScript("arguments[0].scrollIntoView();", locateUpdateRow.get(k));
						if(locateUpdateRow.get(k).isDisplayed())
						{
							if(locateUpdateRow.get(k).getText().equalsIgnoreCase(dataFromExcel.get(0)))
							{
								WebElement deleteRow = locateRow.get(j).findElement(By.xpath("//span[contains(@class,'tableContent_itemDelete')]"));
								js.executeScript("arguments[0].scrollIntoView();", deleteRow);
								if(deleteRow.isDisplayed())
								{
									js.executeScript("arguments[0].click()", deleteRow);
									
									WebElement confirmDelete = locateRow.get(j).findElement(By.xpath("//button[contains(text(),'Confirm role removal')]"));
									js.executeScript("arguments[0].scrollIntoView();", confirmDelete);
									if(confirmDelete.isDisplayed())
									{
										js.executeScript("arguments[0].click()", confirmDelete);
									}
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
	
	public ArrayList<String> checkEvaluatorCreation(ArrayList<String> data)
	{
		ArrayList<String> dataFromExcel = new ArrayList<String>();
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0; i < data.size(); i++)
		{
			if(i == 0)
			{
				continue;
			}
			else
			{
				String word[] = data.get(i).split("=");
				dataFromExcel.add(word[1]);
			}
		}
		try
		{
			WebElement clickAddEvaluator = driver.findElement(By.xpath("//button[contains(text(),'+ Add Evaluator')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickAddEvaluator);
			if(clickAddEvaluator.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickAddEvaluator);
			}
			WebElement enterFirstName = driver.findElement(By.xpath("//input[@id='first_name']"));
			js.executeScript("arguments[0].scrollIntoView();", enterFirstName);
			if(enterFirstName.isDisplayed())
			{
				enterFirstName.sendKeys(dataFromExcel.get(0));
			}
			WebElement enterLastName = driver.findElement(By.xpath("//input[@id='last_name']"));
			js.executeScript("arguments[0].scrollIntoView();", enterLastName);
			if(enterLastName.isDisplayed())
			{
				enterLastName.sendKeys(dataFromExcel.get(1));
			}
			WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
			js.executeScript("arguments[0].scrollIntoView();", email);
			if(email.isDisplayed())
			{
				email.sendKeys(dataFromExcel.get(2));
			}
			//String labelXpath = "//label[contains(text(), '"+data.get(4)+"')]";
			
			List<WebElement> labelElement = driver.findElements(By.xpath("//label[contains(@style,'cursor: pointer')]"));
			for(int j = 0; j < labelElement.size(); j++)
			{
				js.executeScript("arguments[0].scrollIntoView();", labelElement.get(j));
				
				if(labelElement.get(j).getText().equalsIgnoreCase(dataFromExcel.get(3)))
				{
					WebElement enableCourse = labelElement.get(j).findElement(By.xpath("./preceding-sibling::input[@type='checkbox']"));
					js.executeScript("arguments[0].scrollIntoView();", enableCourse);
					if(enableCourse.isDisplayed())
					{
						js.executeScript("arguments[0].click()", enableCourse);
						break;
					}
				}
			}
			
			WebElement clickAdd = driver.findElement(By.xpath("//div[contains(@class,'postOrPutUser_btnRightside')]//button[contains(text(),'Add')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickAdd);
			if(clickAdd.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickAdd);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	public ArrayList<String> checkUpdateEvaluator(ArrayList<String> data)
	{
		ArrayList<String> dataFromExcel = new ArrayList<String>();
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0; i < data.size(); i++)
		{
			if(i == 0)
			{
				continue;
			}
			else
			{
				String word[] = data.get(i).split("=");
				dataFromExcel.add(word[1]);
			}
		}
		try
		{
			List<WebElement> locateRow = driver.findElements(By.xpath("//tbody[contains(@class,'tableContent_tableBody')]/tr"));
			for(int j = 0; j < locateRow.size(); j++)
			{
				js.executeScript("arguments[0].scrollIntoView();", locateRow.get(j));
				if(locateRow.get(j).isDisplayed())
				{
					List<WebElement> locateUpdateRow = locateRow.get(j).findElements(By.xpath("./td[contains(@class,'tableContent_rowItem')]"));
					for(int k = 0; k < locateUpdateRow.size(); k++)
					{
						js.executeScript("arguments[0].scrollIntoView();", locateUpdateRow.get(k));
						if(locateUpdateRow.get(k).isDisplayed())
						{
							if(locateUpdateRow.get(k).getText().equalsIgnoreCase(dataFromExcel.get(0)))
							{
								WebElement updateRow = locateRow.get(j).findElement(By.xpath("]//span[contains(@class,'tableContent_itemUpdate')]"));
								js.executeScript("arguments[0].scrollIntoView();", updateRow);
								if(updateRow.isDisplayed())
								{
									js.executeScript("arguments[0].click()", updateRow);
								}
							}
						}
					}
				}
			}
			WebElement enterFirstName = driver.findElement(By.xpath("//input[@id='first_name']"));
			js.executeScript("arguments[0].scrollIntoView();", enterFirstName);
			if(enterFirstName.isDisplayed())
			{
				enterFirstName.clear();
				enterFirstName.sendKeys(dataFromExcel.get(1));
			}
			WebElement enterLastName = driver.findElement(By.xpath("//input[@id='last_name']"));
			js.executeScript("arguments[0].scrollIntoView();", enterLastName);
			if(enterLastName.isDisplayed())
			{
				enterLastName.clear();
				enterLastName.sendKeys(dataFromExcel.get(2));
			}
			WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
			js.executeScript("arguments[0].scrollIntoView();", email);
			if(email.isDisplayed())
			{
				email.clear();
				email.sendKeys(dataFromExcel.get(3));
			}
			//String labelXpath = "//label[contains(text(), '"+data.get(4)+"')]";
			
			List<WebElement> labelElement = driver.findElements(By.xpath("//label[contains(@style,'cursor: pointer')]"));
			for(int j = 0; j < labelElement.size(); j++)
			{
				js.executeScript("arguments[0].scrollIntoView();", labelElement.get(j));
				
				if(labelElement.get(j).getText().equalsIgnoreCase(dataFromExcel.get(4)))
				{
					WebElement enableCourse = labelElement.get(j).findElement(By.xpath("./preceding-sibling::input[@type='checkbox']"));
					js.executeScript("arguments[0].scrollIntoView();", enableCourse);
					if(enableCourse.isDisplayed())
					{
						js.executeScript("arguments[0].click()", enableCourse);
						break;
					}
				}
			}
			
			WebElement clickUpdate = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickUpdate);
			if(clickUpdate.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickUpdate);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("fail");
		}
		return status;
	}
	
	public ArrayList<String> checkDeleteEvaluator(ArrayList<String> data)
	{
		ArrayList<String> dataFromExcel = new ArrayList<String>();
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for(int i = 0; i < data.size(); i++)
		{
			if(i == 0)
			{
				continue;
			}
			else
			{
				String word[] = data.get(i).split("=");
				dataFromExcel.add(word[1]);
			}
		}
		try
		{
			List<WebElement> locateRow = driver.findElements(By.xpath("//tbody[contains(@class,'tableContent_tableBody')]/tr"));
			for(int j = 0; j < locateRow.size(); j++)
			{
				js.executeScript("arguments[0].scrollIntoView();", locateRow.get(j));
				if(locateRow.get(j).isDisplayed())
				{
					List<WebElement> locateUpdateRow = locateRow.get(j).findElements(By.xpath("./td[contains(@class,'tableContent_rowItem')]"));
					for(int k = 0; k < locateUpdateRow.size(); k++)
					{
						js.executeScript("arguments[0].scrollIntoView();", locateUpdateRow.get(k));
						if(locateUpdateRow.get(k).isDisplayed())
						{
							if(locateUpdateRow.get(k).getText().equalsIgnoreCase(dataFromExcel.get(0)))
							{
								WebElement deleteRow = locateRow.get(j).findElement(By.xpath("//span[contains(@class,'tableContent_itemDelete')]"));
								js.executeScript("arguments[0].scrollIntoView();", deleteRow);
								if(deleteRow.isDisplayed())
								{
									js.executeScript("arguments[0].click()", deleteRow);
									
									WebElement confirmDelete = locateRow.get(j).findElement(By.xpath("//button[contains(text(),'Confirm role removal')]"));
									js.executeScript("arguments[0].scrollIntoView();", confirmDelete);
									if(confirmDelete.isDisplayed())
									{
										js.executeScript("arguments[0].click()", confirmDelete);
									}
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
