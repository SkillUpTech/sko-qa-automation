package com.palm.regressionTesting;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnboardingLocator
{
WebDriver driver;
	
	public OnboardingLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	String parentWindow = "";
	
	String checkTestcasestatus = "";
	public String checkLogin(String email, String pwd)
	{
		String status = "";
		parentWindow = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement loginPage = driver.findElement(By.cssSelector("li[class*='Header_loginBtn']>a"));
			String loginURL = loginPage.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(loginURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			
			
			
			WebElement enterEmail = driver.findElement(By.cssSelector("input#email"));
			js.executeScript("arguments[0].scrollIntoView();", enterEmail);
			if(enterEmail.isDisplayed())
			{
				enterEmail.sendKeys(email);
			}
			WebElement enterPwd = driver.findElement(By.cssSelector("input#password"));
			js.executeScript("arguments[0].scrollIntoView();", enterPwd);
			if(enterEmail.isDisplayed())
			{
				enterPwd.sendKeys(pwd);
			}
			WebElement submit = driver.findElement(By.cssSelector("input#login_in"));
			js.executeScript("arguments[0].scrollIntoView();", submit);
			if(submit.isDisplayed())
			{
				js.executeScript("arguments[0].click()", submit);
				status = "pass";
			}
			System.out.println("Login success");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			checkTestcasestatus = "exception";
		}
		return status;
	}
	
	public String checkPersonalPage()
	{
		String status = "";
		if (!checkTestcasestatus.equalsIgnoreCase("exception"))
		{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.xpath("//a[contains(text(),'Begin your profile')]")).size()>0)
			{
				WebElement checkPage = driver.findElement(By.xpath("//a[contains(text(),'Begin your profile')]"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Begin your profile')]")));
				js.executeScript("arguments[0].scrollIntoView();", checkPage);
				if(checkPage.isDisplayed())
				{
					System.out.println(checkPage.getText());
					WebElement submit = driver.findElement(By.xpath("//div[contains(@class,'Personalized_PersContent')]//a[contains(text(),'Begin your profile')]"));
					wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'Personalized_PersContent')]//a[contains(text(),'Begin your profile')]")));
					js.executeScript("arguments[0].scrollIntoView();", submit);
					if(submit.isDisplayed())
					{
						js.executeScript("arguments[0].click()", submit);
						status = "pass";
					}
				}
				System.out.println("check Begin profile success");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		}
		return status;
	}
	
	public String checkInterestedPage()
	{
		String status = "";
		if (!checkTestcasestatus.equalsIgnoreCase("exception"))
		{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.cssSelector("div[class='Interested_navmenuDiv__5amle']>ul>li input")).size()>0)
			{
				List<WebElement> selectData = driver.findElements(By.cssSelector("div[class='Interested_navmenuDiv__5amle']>ul>li input"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='Interested_navmenuDiv__5amle']>ul>li input")));
				for(int i = 0; i < selectData.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();", selectData.get(i));
					if(selectData.get(i).getAttribute("id").equalsIgnoreCase("Artificial Intelligence"))
					{
						System.out.println(selectData.get(i).getText());
						js.executeScript("arguments[0].click()", selectData.get(i));
						status = "pass";
						break;
					}
					
				}
				WebElement submit = driver.findElement(By.cssSelector("div[class*='Interested_buttonBottom']>button"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Interested_buttonBottom']>button")));
				js.executeScript("arguments[0].scrollIntoView();", submit);
				if(submit.isDisplayed())
				{
					js.executeScript("arguments[0].click()", submit);
					Thread.sleep(1000);
				}
				System.out.println("Interested selection success");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		return status;
	}
	
	public String checkWorkstatusPage()
	{
		String status = "";
		if (!checkTestcasestatus.equalsIgnoreCase("exception"))
		{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.cssSelector("div[class*='Workstatus_currentWork']>ul>li>input")).size()>0)
			{
				List<WebElement> selectData = driver.findElements(By.cssSelector("div[class*='Workstatus_currentWork']>ul>li>input"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Workstatus_currentWork']>ul>li>input")));
				for(int i = 0; i < selectData.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();", selectData.get(i));
					if(selectData.get(i).getAttribute("id").equalsIgnoreCase("Working full time"))
					{
						System.out.println(selectData.get(i).getText());
						js.executeScript("arguments[0].click()", selectData.get(i));
						
						status = "pass";
						break;
					}
					
				}
				WebElement submit = driver.findElement(By.cssSelector("div[class*='Workstatus_buttonBottom']>button"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Workstatus_buttonBottom']>button")));
				js.executeScript("arguments[0].scrollIntoView();", submit);
				if(submit.isDisplayed())
				{
					js.executeScript("arguments[0].click()", submit);
				}
				System.out.println("work status selection  success");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		}
		return status;
	}
	public String checkWorkExperience()
	{
		String status = "";
		if (!checkTestcasestatus.equalsIgnoreCase("exception"))
		{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.cssSelector("div[class*='Workexperience_currentWork']>ul>li>input")).size()>0)
			{
				List<WebElement> selectData = driver.findElements(By.cssSelector("div[class*='Workexperience_currentWork']>ul>li>input"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Workexperience_currentWork']>ul>li>input")));
				for(int i = 0; i < selectData.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();", selectData.get(i));
					if(selectData.get(i).getAttribute("value").equalsIgnoreCase("2-5 Years"))
					{
						System.out.println(selectData.get(i).getText());
						js.executeScript("arguments[0].click()", selectData.get(i));
						status = "pass";
						break;
					}
					
				}
				WebElement submit = driver.findElement(By.cssSelector("div[class*='Workexperience_buttonBottom']>button"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Workexperience_buttonBottom']>button")));
				js.executeScript("arguments[0].scrollIntoView();", submit);
				if(submit.isDisplayed())
				{
					js.executeScript("arguments[0].click()", submit);
				}
				System.out.println("work experience selection success");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		}
		return status;
	}
	public String checkAboutYouPage()
	{
		String status = "";
		if (!checkTestcasestatus.equalsIgnoreCase("exception"))
		{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.cssSelector("div[class*='Aboutyou_currentWork']>ul>li>input")).size()>0)
			{
				List<WebElement> selectData = driver.findElements(By.cssSelector("div[class*='Aboutyou_currentWork']>ul>li>input"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Aboutyou_currentWork']>ul>li>input")));
				for(int i = 0; i < selectData.size(); i++)
				{
					js.executeScript("arguments[0].scrollIntoView();", selectData.get(i));
					if(selectData.get(i).getAttribute("value").equalsIgnoreCase("f"))
					{
						System.out.println(selectData.get(i).getText());
						js.executeScript("arguments[0].click()", selectData.get(i));
						
						status = "pass";
						break;
					}
					
				}
				WebElement selectYear = driver.findElement(By.cssSelector("select#year_of_birth"));
				Select dropdown = new Select(selectYear);
				dropdown.selectByVisibleText("1991");
				WebElement submit = driver.findElement(By.cssSelector("div[class*='Aboutyou_buttonBottom']>button"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Aboutyou_buttonBottom']>button")));
				js.executeScript("arguments[0].scrollIntoView();", submit);
				if(submit.isDisplayed())
				{
					js.executeScript("arguments[0].click()", submit);
				}
				System.out.println("about you selection success");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		}
		return status;
	}
	
	public String checkEducationPage()
	{
		String status = "";
		if (!checkTestcasestatus.equalsIgnoreCase("exception"))
		{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{		
			if(driver.findElements(By.id("year_of_birth")).size()>0)
			{
				WebElement dropdownElement = driver.findElement(By.cssSelector("select[id='year_of_birth']"));
				js.executeScript("arguments[0].scrollIntoView();", dropdownElement);
				if(dropdownElement.isDisplayed())
				{
					Select dropdown = new Select(dropdownElement);
					dropdown.selectByVisibleText("Master's or professional degree");
				}
				
				WebElement submit = driver.findElement(By.cssSelector("div[class*='Education_buttonBottom']>button"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Education_buttonBottom']>button")));
				js.executeScript("arguments[0].scrollIntoView();", submit);
				if(submit.isDisplayed())
				{
					js.executeScript("arguments[0].click()", submit);
				}
				System.out.println("education selection success");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		}
		return status;
	}
	
	public String checkJobOpportunites()
	{
		String status = "";
		if (!checkTestcasestatus.equalsIgnoreCase("exception"))
		{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(driver.findElements(By.cssSelector("div[class*='Jobopportunities_currentWork']>ul>li>input[value='1']")).size()>0)
			{
				WebElement selectData = driver.findElement(By.cssSelector("div[class*='Jobopportunities_currentWork']>ul>li>input[value='1']"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Jobopportunities_currentWork']>ul>li>input[value='1']")));
				js.executeScript("arguments[0].scrollIntoView();", selectData);
				if(selectData.getAttribute("value").equalsIgnoreCase("1"))
				{
					System.out.println(selectData.getText());
					js.executeScript("arguments[0].click()", selectData);
					status = "pass";
				}
				WebElement submit = driver.findElement(By.cssSelector("div[class*='Jobopportunities_buttonBottom']>button"));
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class*='Jobopportunities_buttonBottom']>button")));
				js.executeScript("arguments[0].scrollIntoView();", submit);
				if(submit.isDisplayed())
				{
					js.executeScript("arguments[0].click()", submit);
					status = "pass";
				}
				System.out.println("job opportunities selection success");
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		}
		return status;
	}
}
