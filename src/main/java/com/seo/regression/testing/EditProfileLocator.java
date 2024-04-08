package com.seo.regression.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditProfileLocator
{
	WebDriver driver;
	
	public EditProfileLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	public ArrayList<String> checkLogin(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			WebElement clickLogin = driver.findElement(By.cssSelector("li[class*='Header_loginBtn'] a"));
			if(clickLogin.isDisplayed())
			{
				Thread.sleep(2000);
				clickLogin.click();
				Thread.sleep(2000);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("login?"))
				{
					driver.switchTo().window(window);
					Thread.sleep(3000);
					WebElement uname = driver.findElement(By.cssSelector("input#email"));
					uname.sendKeys(data.get(1));
					WebElement pwd = driver.findElement(By.cssSelector("input#password"));
					pwd.sendKeys(data.get(2));
					WebElement submit = driver.findElement(By.cssSelector("input#login_in"));
					if(submit.isDisplayed())
					{
						Thread.sleep(2000);
						submit.click();
						Thread.sleep(2000);
						status.add("pass");
						String parentWindow1 = driver.getWindowHandle();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(150));
						Set<String> allWindows1 = driver.getWindowHandles();
						for(String window1 : allWindows1)
						{
							driver.switchTo().window(window1);
							if(driver.getCurrentUrl().contains("dashboard"))
							{
								driver.switchTo().window(window1);
								Thread.sleep(2000);
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
								status.add("pass");
								System.out.println("dashboard page");//dashboard page (1)
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(150));
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
			System.out.println("issue in login page");
		}
		return status;
	}
	public String checkProfile()
	{
		
		String dataFromExcel = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/dashboard"))
				{
					driver.switchTo().window(window);
					WebElement clickDropDown = driver.findElement(By.cssSelector("div[class*='Header_headerRight'] ul[class*='Header_navButtons']>li:nth-child(2) img[alt='icon']"));
					if(clickDropDown.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickDropDown);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(150));
					WebElement clickProfile = driver.findElement(By.cssSelector("ul[class*='dropdown-menu']>li:nth-child(3)>a"));
					if(clickProfile.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickProfile);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(150));
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("/u/"))
					{
						driver.switchTo().window(window);//profile page(1)
						Thread.sleep(2000);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						System.out.println("profile page");
						dataFromExcel = "pass";
						System.out.println("profile page navigated ");
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			dataFromExcel = "fail";
			System.out.println("issue in profile page ");
		}
		
		return dataFromExcel;
	}
	public String checkUpdateIcon() throws InterruptedException
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					Thread.sleep(2000);
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("div[class='ProfileContent_main'] div[class='EditUpdateButton'] a button"));
					//String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
					//clickUpdateFromContacts.sendKeys(selectLinkOpeninNewTab); //new tab for update screen opened
					//System.out.println("new tab");
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickUpdateFromContacts);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
						driver.switchTo().window(window1);
						Thread.sleep(2000);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						if(driver.getCurrentUrl().contains("update/"))
						{
							driver.switchTo().window(window1);//(2)
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							System.out.println("update page");
							status = "pass";
							System.out.println("contact update page process done ");
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
			status = "fail";
		}
		return status;
	}
	public String checkSubmitWithoutDataForMobile() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("update/"))
				{
					Thread.sleep(2000);
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0, 100)","");
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("button#update_profile"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromContacts);
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickUpdateFromContacts);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					int errorSize = driver.findElements(By.cssSelector("div#mobileErr")).size();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					if(errorSize>0)
					{
						System.out.println("error shown for mobile number");
						status = "pass";
						Thread.sleep(2000);
						System.out.println("contact without data process done");
					}
					else
					{
						status = "fail";
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	public String checkSubmitInvalidDataForMobile(String data) throws InterruptedException
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("update/"))
				{
					Thread.sleep(2000);
					WebElement enterMbl = driver.findElement(By.cssSelector("input#mobile_number"));
					js.executeScript("arguments[0].scrollIntoView();", enterMbl);
					enterMbl.sendKeys(data);
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0, 100)","");
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("button#update_profile"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromContacts);
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(2000);
						clickUpdateFromContacts.click();
						Thread.sleep(2000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					int errorSize = driver.findElements(By.cssSelector("div#mobileErr")).size();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					if(errorSize>0)
					{
						Thread.sleep(2000);
						System.out.println("error shown for mobile number");
						status = "pass";
						Thread.sleep(2000);
						System.out.println("contact with invalid data process done");
					}
					else
					{
						status = "fail";
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	public String checkCancelIcon() throws InterruptedException
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("update/"))
				{
					driver.switchTo().window(window);
					WebElement clickCancel = driver.findElement(By.cssSelector("p[class='CancelButton']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Set<String> a = driver.getWindowHandles();
					for(String win : a)
					{
						driver.switchTo().window(win);
						if(driver.getCurrentUrl().contains("/update/"))
						{
							
							driver.switchTo().window(win);//pop up
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							WebElement getTextFromAlert = driver.findElement(By.cssSelector("div[class='modal-body']"));
							System.out.println(getTextFromAlert.getText());
						}
					}
					status = "pass";
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		System.out.println("cancel icon process done for contact");
		return status;
	}
	public String checkContactsAlertClose()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("update/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					WebElement closeAlert = driver.findElement(By.cssSelector("button[class='close']"));
					js.executeScript("arguments[0].scrollIntoView();", closeAlert);
					if(closeAlert.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", closeAlert);
						Thread.sleep(2000);
						status = "pass";
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					System.out.println(driver.getCurrentUrl());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		System.out.println("contact alert close process done");
		return status;
	}
	public String checkSubmitValidDataForMobile(String data) throws InterruptedException
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("update/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					WebElement enterMobileNum = driver.findElement(By.cssSelector("input#mobile_number"));
					js.executeScript("arguments[0].scrollIntoView();", enterMobileNum);
					enterMobileNum.clear();
					enterMobileNum.sendKeys(data);
					Thread.sleep(2000);
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("button#update_profile"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromContacts);
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickUpdateFromContacts);
						Thread.sleep(2000);
						status = "pass";
					}
					Thread.sleep(2000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("/u/"))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						Thread.sleep(2000);
						WebElement mblNum = driver.findElement(By.cssSelector("div[class='UserProfilemain'] div[class='userProfileDetails'] p:nth-child(3)"));
						js.executeScript("arguments[0].scrollIntoView();", mblNum);
						String modifiedData = mblNum.getText();
						if(modifiedData.replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim().equalsIgnoreCase(data))
						{
							System.out.println("mbl number updated correctly");							
							status = "pass";
							Thread.sleep(2000);
						}
						System.out.println(driver.getCurrentUrl());
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		System.out.println("contact with valid process done");
		return status;
	}
	public String checkAlertYesButton() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0, -100)","");
					
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("div[class='ProfileContent_main'] div[class='EditUpdateButton'] a button"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromContacts);
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickUpdateFromContacts);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
					driver.switchTo().window(window1);
					if(driver.getCurrentUrl().contains("/update/"))
					{
						driver.switchTo().window(window1);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						jse1.executeScript("window.scrollBy(0, 100)","");
						WebElement clickCancel = driver.findElement(By.cssSelector("p[class='CancelButton']"));
						js.executeScript("arguments[0].scrollIntoView();", clickCancel);
						if(clickCancel.isDisplayed())
						{
							Thread.sleep(2000);
							js.executeScript("arguments[0].click()", clickCancel);
							Thread.sleep(2000);
						}
						driver.switchTo().window(window1);
						if(driver.getCurrentUrl().contains("/update/"))
						{
							driver.switchTo().window(window1);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							WebElement clickYesFromAlert = driver.findElement(By.cssSelector("button[class='btn updateButton']"));
							js.executeScript("arguments[0].scrollIntoView();", clickYesFromAlert);
							if(clickYesFromAlert.isDisplayed())
							{
								Thread.sleep(2000);
								js.executeScript("arguments[0].click()", clickYesFromAlert);
								status = "pass";
								Thread.sleep(2000);
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						}
					}
				}
			}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		System.out.println("alert yes process done for contact");
		return status;
	}
	public String checkAlertGoBackButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("update/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0, 100)","");
					WebElement clickCancel = driver.findElement(By.cssSelector("p[class='CancelButton']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("/update/"))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						WebElement clickGoBackFromAlert = driver.findElement(By.cssSelector("a[class='btn cancelButton']"));
						js.executeScript("arguments[0].scrollIntoView();", clickGoBackFromAlert);
						if(clickGoBackFromAlert.isDisplayed())
						{
							Thread.sleep(2000);
							js.executeScript("arguments[0].click()", clickGoBackFromAlert);
							Thread.sleep(2000);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						driver.switchTo().window(window);
						if(driver.getCurrentUrl().contains("/u/"))
						{
							driver.switchTo().window(window);
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							System.out.println("Profile page");
							status = "pass";
							Thread.sleep(2000);
							driver.switchTo().window(window);
						}
					}
					}
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		System.out.println("alert go back process done for conatct");
		return status;
	}
	public String checkAreasOfInterestUpdateIcon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(0, 100)","");
					WebElement updateIcon = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(2) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", updateIcon);
					if(updateIcon.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", updateIcon);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
						driver.switchTo().window(window1);
						Thread.sleep(2000);
						if(driver.getCurrentUrl().contains("interestedUpdate/"))
						{
							driver.switchTo().window(window1);
							Thread.sleep(2000);
							System.out.println("update page");
							status = "pass";
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
			status = "fail";
		}
		System.out.println("AreasOfInterestUpdateIcon process done");
		return status;
	}
	public String checkAreasOfInterestCancelIcon()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("interestedUpdate/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(0, 600)","");
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class='row gy-3']>div[class='col-md-12']:nth-child(2) div[class*='Interested_buttonBottom'] div[class='Interested_skipButonDesk__sc5lk']>button"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(2000);
					}
						
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Set<String> a = driver.getWindowHandles();
					for(String win : a)
					{
						driver.switchTo().window(win);
						Thread.sleep(2000);
						if(driver.getCurrentUrl().contains("interestedUpdate/"))
						{
							driver.switchTo().window(win);
							Thread.sleep(2000);
							WebElement getTextFromAlert = driver.findElement(By.cssSelector("div[class='modelPopup_popupmain__Rs7vT'] div[class='modelPopup_popupTop__yPF_N'] p"));
							js.executeScript("arguments[0].scrollIntoView();", getTextFromAlert);
							System.out.println(getTextFromAlert.getText());
							System.out.println("Alert from Area of interest");
							status = "pass";
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			status = "fail";
		}
		System.out.println("AreasOfInterestCancelIcon process done");
		return status;
	}
	public String checkAreasOfInterestAlertClose()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				Thread.sleep(2000);
				if(driver.getCurrentUrl().contains("interestedUpdate/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					WebElement closeAlert = driver.findElement(By.cssSelector("button[class='btn-close']"));
					js.executeScript("arguments[0].scrollIntoView();", closeAlert);
					if(closeAlert.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", closeAlert);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					status = "pass";
					System.out.println(driver.getCurrentUrl());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	public ArrayList<String> checkAreasOfInterestSubmitValidData(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("interestedUpdate"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, -200)","");
					List<WebElement> selectInterestedTopics = driver.findElements(By.cssSelector("div[class='Interested_navmenuDiv__5amle']>ul>li>input"));
					for(int i = 0; i < selectInterestedTopics.size(); i++)
					{
						js.executeScript("arguments[0].scrollIntoView();", selectInterestedTopics.get(i));
						String getDataFromBrowser = selectInterestedTopics.get(i).getAttribute("id");
						Thread.sleep(2000);
						for(int k = 0 ; k < data.size(); k++)
						{
							String getDataFromExcel = data.get(k);
							Thread.sleep(2000);
							if(getDataFromBrowser.equalsIgnoreCase(getDataFromExcel))
							{
								Thread.sleep(2000);
								js.executeScript("arguments[0].click()", selectInterestedTopics.get(i));
								Thread.sleep(2000);
								System.out.println(selectInterestedTopics.get(i)+" is selected");
								if(k == data.size()-1)
								{
									break;
								}
							}
						}
					}
					Thread.sleep(3000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					js.executeScript("window.scrollBy(0, 400)","");
					Thread.sleep(2000);
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("div[class='row gy-3']>div[class='col-md-12']:nth-child(2) div[class*='Interested_buttonBottom'] button[type='submit']"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromContacts);
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickUpdateFromContacts);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					Thread.sleep(2000);
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("/u/"))
					{
						driver.switchTo().window(window);
						Thread.sleep(2000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						js.executeScript("window.scrollBy(0, 200)","");
						List<WebElement> selectInterestedTopicsFromHome = driver.findElements(By.cssSelector("div[class='profileheadLeft']>div:nth-child(2) div[class='ProfileUserDetails']>ul>li>a"));
						for(int j = 0; j < selectInterestedTopicsFromHome.size(); j++)
						{
							for(int k = 0; k < data.size(); k++)
							{
								if(selectInterestedTopicsFromHome.get(j).getText().replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim().equalsIgnoreCase(data.get(k).replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim()))
								{
									Thread.sleep(2000);
									status.add(data.get(k));
									Thread.sleep(2000);
								}
							}
					    }
				  }
					Thread.sleep(2000);
			}
		
		}
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			status.add("fail");
		}
		System.out.println("AreasOfInterestSubmitValidData process done");
		return status;
	}
	public String checkAreasOfInterestAlertGoBackButton()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows1 = driver.getWindowHandles();
			for(String window1 : allWindows1)
			{
				driver.switchTo().window(window1);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window1);
					WebElement updateIcon = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(2) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", updateIcon);
					if(updateIcon.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", updateIcon);
						Thread.sleep(2000);
					}
				}
			}
				Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("interestedUpdate/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
				
					js.executeScript("window.scrollBy(0, 100)","");
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class='row gy-3']>div[class='col-md-12']:nth-child(2) div[class*='Interested_buttonBottom'] div[class='Interested_skipButonDesk__sc5lk']>button"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(2000);
					}

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("interestedUpdate/"))
					{
						driver.switchTo().window(window);
						Thread.sleep(2000);
						WebElement clickGoBackFromAlert = driver.findElement(By.cssSelector("div[class*='modelPopup_popupBottom'] a"));
						js.executeScript("arguments[0].scrollIntoView();", clickGoBackFromAlert);
						if(clickGoBackFromAlert.isDisplayed())
						{
							Thread.sleep(2000);
							js.executeScript("arguments[0].click()", clickGoBackFromAlert);
							Thread.sleep(2000);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						driver.switchTo().window(window);
						if(driver.getCurrentUrl().contains("/u/"))
						{
							driver.switchTo().window(window);
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							System.out.println("Profile page");
							status = "pass";
							Thread.sleep(2000);
							driver.switchTo().window(window);
							System.out.println("AreasOfInterest_Alert_Back Button process done");
							Thread.sleep(2000);
						}
					}
					}
				}
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	}
	public String checkAreasOfInterestAlertyesButton()
	{
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					
					jse1.executeScript("window.scrollBy(0, -100)","");
					Thread.sleep(3000);
					WebElement clickUpdateFromAreaOfInterest = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(2) div[class='EditUpdate'] a"));
					jse1.executeScript("arguments[0].scrollIntoView();", clickUpdateFromAreaOfInterest);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					if(clickUpdateFromAreaOfInterest.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickUpdateFromAreaOfInterest);
						Thread.sleep(3000);
					}
					Thread.sleep(3000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
					driver.switchTo().window(window1);
					if(driver.getCurrentUrl().contains("interestedUpdate"))
					{
						driver.switchTo().window(window1);
						Thread.sleep(2000);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						jse1.executeScript("window.scrollBy(0, 100)","");
						Thread.sleep(3000);
						WebElement clickCancel = driver.findElement(By.cssSelector("div[class='row gy-3']>div[class='col-md-12']:nth-child(2) div[class*='Interested_buttonBottom'] div[class='Interested_skipButonDesk__sc5lk']>button"));
						
						jse1.executeScript("arguments[0].scrollIntoView();", clickCancel);
						JavascriptExecutor js2 = (JavascriptExecutor) driver;
						if(clickCancel.isDisplayed())
						{
							Thread.sleep(2000);
							js2.executeScript("arguments[0].click()", clickCancel);
							Thread.sleep(3000);
						}
						Thread.sleep(3000);
						driver.switchTo().window(window1);
						if(driver.getCurrentUrl().contains("interestedUpdate"))
						{
							driver.switchTo().window(window1);
							Thread.sleep(2000);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
							WebElement clickYesFromAlert = driver.findElement(By.xpath("//a[contains(text(),'Yes, continue')]"));
							js.executeScript("arguments[0].scrollIntoView();", clickYesFromAlert);
							if(clickYesFromAlert.isDisplayed())
							{
								Thread.sleep(2000);
								js2.executeScript("arguments[0].click()", clickYesFromAlert);
								Thread.sleep(2000);
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
							if(driver.getCurrentUrl().contains("/u/"))
							{
								status = "pass";
								Thread.sleep(2000);
								System.out.println("AreasOfInterest_Alert_yes Button process done");
								Thread.sleep(3000);
							}
							Thread.sleep(3000);
						}
						Thread.sleep(3000);
					}
				}
			}
				
			}
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	
	}
	public String checkCurrentWorkUpdateIcon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(3000);
					WebElement updateIcon = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(3) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", updateIcon);
					if(updateIcon.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", updateIcon);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
						driver.switchTo().window(window1);
						Thread.sleep(3000);
						if(driver.getCurrentUrl().contains("workstatusUpdate/"))
						{
							Thread.sleep(3000);
							driver.switchTo().window(window1);
							Thread.sleep(2000);
							System.out.println("workstatusUpdate page");
							status = "pass";
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
			status = "fail";
		}
		System.out.println("current work UpdateIcon process done");
		return status;
	
	}
	public String checkCurrentWorkCancelIcon()
	{
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("workstatusUpdate/"))
				{
					driver.switchTo().window(window);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, 500)","");
					Thread.sleep(2000);
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class='row gy-3'] div[class='col-md-12']:nth-child(2) div[class='Workstatus_buttonBottom__gah5Y'] div[class='Workstatus_skipButonDesk__2yAQW']>button[class='Workstatus_skipButton__vZu4F']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(2000);
					}
					Thread.sleep(2000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					Set<String> a = driver.getWindowHandles();
					for(String win : a)
					{
						driver.switchTo().window(win);
						if(driver.getCurrentUrl().contains("workstatusUpdate/"))
						{
							driver.switchTo().window(win);
							Thread.sleep(3000);
							WebElement getTextFromAlert = driver.findElement(By.xpath("//p[contains(text(),'Are you sure to cancel the updates?')]"));
							System.out.println(getTextFromAlert.getText());
							Thread.sleep(3000);
							System.out.println("Alert from work experience");
						}
					}
					status = "pass";
				}
			}
		}
		catch(Exception e)
		{
			status = "fail";
		}
		System.out.println("current work cancelIcon process done");
		return status;
	}
	
	public String checkCurrentWorkAlertClose()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("workstatusUpdate/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					WebElement closeAlert = driver.findElement(By.cssSelector("button[class='btn-close']"));
					js.executeScript("arguments[0].scrollIntoView();", closeAlert);
					if(closeAlert.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", closeAlert);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);
					status = "pass";
					System.out.println("Alert close process done");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		System.out.println("alert close from current work");
		return status;
	}
	public ArrayList<String> checkCurrentWorkSubmitValidData(ArrayList<String> data)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("workstatusUpdate"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					Thread.sleep(3000);
					js.executeScript("window.scrollBy(0, -200)","");
					Thread.sleep(3000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					List<WebElement> selectWorkExperience = driver.findElements(By.cssSelector("div[class='Workstatus_currentWork__9e8wr'] ul li input"));
					for(int i = 0; i < selectWorkExperience.size(); i++)
					{
						js.executeScript("arguments[0].scrollIntoView();", selectWorkExperience.get(i));
						String getDataFromBrowser = selectWorkExperience.get(i).getAttribute("id");
						for(int k = 0 ; k < data.size(); k++)
						{
							String getDataFromExcel = data.get(k);
							if(getDataFromBrowser.equalsIgnoreCase(getDataFromExcel))
							{
								Thread.sleep(3000);
								js.executeScript("arguments[0].click()", selectWorkExperience.get(i));
								Thread.sleep(3000);
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
								System.out.println(selectWorkExperience.get(i).getText()+" is selected");
								if(k == data.size()-1)
								{
									Thread.sleep(2000);
									break;
								}
							}
						}
					}
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(0, 500)","");
					Thread.sleep(3000);
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("div[class='row gy-3'] div[class='col-md-12']:nth-child(2) div[class='Workstatus_buttonBottom__gah5Y'] button[type='submit']"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromContacts);
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickUpdateFromContacts);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					Thread.sleep(2000);
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("/u/"))
					{
						driver.switchTo().window(window);
						Thread.sleep(2000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						js.executeScript("window.scrollBy(0, 200)","");
						Thread.sleep(2000);
						List<WebElement> selectInterestedTopicsFromHome = driver.findElements(By.cssSelector("div[class='profileheadLeft'] div[class='ProfileJourny_main']:nth-child(3) div[class='ProfileUserDetails'] ul>li a"));
						for(int j = 0; j < selectInterestedTopicsFromHome.size(); j++)
						{
							for(int k = 0; k < data.size(); k++)
							{
								if(selectInterestedTopicsFromHome.get(j).getText().replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim().equalsIgnoreCase(data.get(k).replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim()))
								{
									Thread.sleep(2000);
									status.add(data.get(k));
									Thread.sleep(2000);
									System.out.println("current work SubmitValidData process done");
									Thread.sleep(2000);
								}
							}
					    }
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						Thread.sleep(2000);
					}
					System.out.println("submit process done for current work status");
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					Thread.sleep(2000);
			}
		
		}
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			status.add("fail");
		}
		return status;
	}
	public String checkCurrentWorkAlertGoBackButton()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window1 : allWindows)
			{
				driver.switchTo().window(window1);
			if(driver.getCurrentUrl().contains("/u/"))
			{
			driver.switchTo().window(window1);
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			JavascriptExecutor jse1 = (JavascriptExecutor) driver;
			jse1.executeScript("window.scrollBy(0, 400)","");
			Thread.sleep(2000);
			jse1.executeScript("window.scrollBy(0, -200)","");
			Thread.sleep(2000);
			WebElement clickUpdateFromCurrentWork = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(3) div[class='EditUpdate'] a"));
			js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromCurrentWork);
			if(clickUpdateFromCurrentWork.isDisplayed())
			{
				Thread.sleep(2000);
				js.executeScript("arguments[0].click()", clickUpdateFromCurrentWork);
				System.out.println("update icon clicked from profile");
				Thread.sleep(2000);
			}
			Set<String> allWindows2 = driver.getWindowHandles();
			for(String window : allWindows2)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("workstatusUpdate/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					jse1.executeScript("window.scrollBy(0, 100)","");
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class='row gy-3'] div[class='col-md-12']:nth-child(2) div[class='Workstatus_buttonBottom__gah5Y'] div[class='Workstatus_skipButonDesk__2yAQW']>button[class='Workstatus_skipButton__vZu4F']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickCancel);
						System.out.println("clicked cancel icon from work status page");
						Thread.sleep(2000);
					}

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("workstatusUpdate/"))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(2000);
						WebElement clickGoBackFromAlert = driver.findElement(By.xpath("//button[contains(text(),' like to go back')]"));
						js.executeScript("arguments[0].scrollIntoView();", clickGoBackFromAlert);
						if(clickGoBackFromAlert.isDisplayed())
						{
							Thread.sleep(2000);
							status = "pass";
							js.executeScript("arguments[0].click()", clickGoBackFromAlert);
							System.out.println("go back  icon clicked from work status page");
							Thread.sleep(2000);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(2000);
						/*
						 * driver.switchTo().window(window); if(driver.getCurrentUrl().contains("/u/"))
						 * { driver.switchTo().window(window);
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						 * System.out.println("Profile page"); Thread.sleep(3000); status = "pass";
						 * driver.switchTo().window(window);
						 * System.out.println("current work_Alert_goBackButton process done"); }
						 */
					}
					}
				}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
			Thread.sleep(2000);

			}
			}
			WebElement clickCancel = driver.findElement(By.cssSelector("div[class='row gy-3'] div[class='col-md-12']:nth-child(2) div[class='Workstatus_buttonBottom__gah5Y'] div[class='Workstatus_skipButonDesk__2yAQW']>button[class='Workstatus_skipButton__vZu4F']"));
			js.executeScript("arguments[0].scrollIntoView();", clickCancel);
			if(clickCancel.isDisplayed())
			{
				Thread.sleep(2000);
				js.executeScript("arguments[0].click()", clickCancel);
				Thread.sleep(2000);
			}
			WebElement clickYesFromAlert = driver.findElement(By.xpath("//a[contains(text(),'Yes, continue')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickYesFromAlert);
			if(clickYesFromAlert.isDisplayed())
			{
				Thread.sleep(2000);
				js.executeScript("arguments[0].click()", clickYesFromAlert);
				System.out.println("Current Work process done");
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	}
	public String checkCurrentWorkAlertYesButton()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(2000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0, 400)","");
					Thread.sleep(2000);
					jse1.executeScript("window.scrollBy(0, -200)","");
					Thread.sleep(2000);
					WebElement clickUpdateFromCurrentWork = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(3) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromCurrentWork);
					if(clickUpdateFromCurrentWork.isDisplayed())
					{
						
						js.executeScript("arguments[0].click()", clickUpdateFromCurrentWork);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
					driver.switchTo().window(window1);
					if(driver.getCurrentUrl().contains("workstatusUpdate"))
					{
						driver.switchTo().window(window1);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0, 100)","");
						WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Workstatus_skipButonDesk']>button[class*='Workstatus_skipButton']"));
						js.executeScript("arguments[0].scrollIntoView();", clickCancel);
						JavascriptExecutor js2 = (JavascriptExecutor) driver;
						if(clickCancel.isDisplayed())
						{
							Thread.sleep(3000);
							js2.executeScript("arguments[0].click()", clickCancel);
							Thread.sleep(3000);
						}
						driver.switchTo().window(window1);
						if(driver.getCurrentUrl().contains("workstatusUpdate"))
						{
							driver.switchTo().window(window1);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
							WebElement clickYesFromAlert = driver.findElement(By.xpath("//a[contains(text(),'Yes, continue')]"));
							js.executeScript("arguments[0].scrollIntoView();", clickYesFromAlert);
							if(clickYesFromAlert.isDisplayed())
							{
								Thread.sleep(3000);
								js2.executeScript("arguments[0].click()", clickYesFromAlert);
								Thread.sleep(3000);
								status = "pass";
								System.out.println("Alert yes from current work process done");
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
						}
					}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	
	}
	public String checkworkExperienceUpdateIcon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(3000);
					WebElement updateIcon = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(4) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", updateIcon);
					if(updateIcon.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", updateIcon);
						System.out.println("update icon clicked to land work experience ");
						Thread.sleep(3000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
						driver.switchTo().window(window1);
						Thread.sleep(3000);
						if(driver.getCurrentUrl().contains("workexperienceUpdate/"))
						{
							Thread.sleep(3000);
							driver.switchTo().window(window1);
							System.out.println("workstatusUpdate page");
							status = "pass";
							Thread.sleep(3000);
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
			status = "fail";
		}
		System.out.println("work experience UpdateIcon process done");
		return status;
	
	}
	public String checkworkExperienceCancelIcon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("workexperienceUpdate/"))
				{
					driver.switchTo().window(window);
					js.executeScript("window.scrollBy(0, 400)","");
					Thread.sleep(2000);//
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Workexperience_skipButonDesk']>button[class*='Workexperience_skipButton']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(2000);
					}
					Thread.sleep(2000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Set<String> a = driver.getWindowHandles();
					for(String win : a)
					{
						driver.switchTo().window(win);
						if(driver.getCurrentUrl().contains("workexperienceUpdate/"))
						{
							driver.switchTo().window(win);
							Thread.sleep(3000);
							WebElement getTextFromAlert = driver.findElement(By.xpath("//p[contains(text(),'Are you sure to cancel the updates?')]"));
							System.out.println(getTextFromAlert.getText());
							System.out.println("Alert from work experience");
							System.out.println("WorkExperience cancelIcon process done");
						}
					}
					status = "pass";
				}
			}
		}
		catch(Exception e)
		{
			status = "fail";
		}
		return status;
	}
	
	public String checkworkExperienceAlertClose()
	{
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("workexperienceUpdate/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0, 100)", "");
					WebElement closeAlert = driver.findElement(By.cssSelector("button[class='btn-close']"));
					js.executeScript("arguments[0].scrollIntoView();", closeAlert);
					if(closeAlert.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", closeAlert);
						Thread.sleep(3000);
					}
					Thread.sleep(3000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);
					status = "pass";
					System.out.println(driver.getCurrentUrl());
				}
			}
			System.out.println("alert close from work experience");
			Thread.sleep(3000);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	public ArrayList<String> checkworkExperienceSubmitValidData(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("workexperienceUpdate"))
				{
					driver.switchTo().window(window);
					Thread.sleep(3000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);
					js.executeScript("window.scrollBy(0, -200)","");
					Thread.sleep(3000);
					List<WebElement> selectWorkExperience = driver.findElements(By.cssSelector("div[class*='Workexperience_currentWork']>ul>li input"));
					for(int i = 0; i < selectWorkExperience.size(); i++)
					{
						js.executeScript("arguments[0].scrollIntoView();", selectWorkExperience.get(i));
						String getDataFromBrowser = selectWorkExperience.get(i).getAttribute("value");
						for(int k = 0 ; k < data.size(); k++)
						{
							String getDataFromExcel = data.get(k);
							if(getDataFromBrowser.equalsIgnoreCase(getDataFromExcel))
							{
								Thread.sleep(3000);
								js.executeScript("arguments[0].click()", selectWorkExperience.get(i));
								Thread.sleep(3000);
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
								Thread.sleep(3000);
								System.out.println(selectWorkExperience.get(i).getText()+" is selected");
								if(k == data.size()-1)
								{
									Thread.sleep(3000);
									break;
								}
							}
						}
					}
					Thread.sleep(3000);
					js.executeScript("window.scrollBy(0, 200)","");
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("button[class*='Workexperience_button']"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromContacts);
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickUpdateFromContacts);
						System.out.println("work experience selected");
						Thread.sleep(3000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					Thread.sleep(2000);
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("/u/"))
					{
						driver.switchTo().window(window);
						Thread.sleep(3000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0, 400)","");
						Thread.sleep(3000);
						List<WebElement> selectInterestedTopicsFromHome = driver.findElements(By.cssSelector("div[class='profileheadLeft'] div[class='ProfileJourny_main']:nth-child(4) div[class='ProfileUserDetails'] ul>li a"));
						for(int j = 0; j < selectInterestedTopicsFromHome.size(); j++)
						{
							for(int k = 0; k < data.size(); k++)
							{
								Thread.sleep(3000);
								if(selectInterestedTopicsFromHome.get(j).getText().replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim().equalsIgnoreCase(data.get(k).replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim()))
								{
									System.out.println("work experience updates verified on Profile page");
									Thread.sleep(3000);
									status.add(data.get(k));
									Thread.sleep(3000);
								}
							}
					    }
						System.out.println("work experience SubmitValidData process done");
						Thread.sleep(3000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
						Thread.sleep(3000);
				  }
			}
		
		}
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			status.add("fail");
		}
		return status;
	}
	public String checkworkExperienceAlertGoBackButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			if(driver.getCurrentUrl().contains("/u/"))
			{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			WebElement clickUpdateFromHome = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(4) div[class='EditUpdate'] a"));
			js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromHome);
			if(clickUpdateFromHome.isDisplayed())
			{
				Thread.sleep(3000);
				js.executeScript("arguments[0].click()", clickUpdateFromHome);
				Thread.sleep(3000);
			}
			Thread.sleep(3000);
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("workexperienceUpdate/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					
					js.executeScript("window.scrollBy(0, 100)","");
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Workexperience_skipButonDesk'] button[class*='Workexperience_skipButton']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(3000);
					}

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("workexperienceUpdate/"))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						WebElement clickGoBackFromAlert = driver.findElement(By.xpath("//button[contains(text(),'like to go back')]"));
						js.executeScript("arguments[0].scrollIntoView();", clickGoBackFromAlert);
						if(clickGoBackFromAlert.isDisplayed())
						{
							Thread.sleep(3000);
							js.executeScript("arguments[0].click()", clickGoBackFromAlert);
							status = "pass";
							System.out.println("WorkExperience_Alert_goBackButton process done");
							Thread.sleep(3000);
							WebElement clickCancel1 = driver.findElement(By.cssSelector("div[class*='Workexperience_skipButonDesk'] button[class*='Workexperience_skipButton']"));
							js.executeScript("arguments[0].scrollIntoView();", clickCancel1);
							JavascriptExecutor js2 = (JavascriptExecutor) driver;
							if(clickCancel1.isDisplayed())
							{
								Thread.sleep(3000);
								js2.executeScript("arguments[0].click()", clickCancel1);
								Thread.sleep(3000);
							}
							driver.switchTo().window(window);
							if(driver.getCurrentUrl().contains("workexperienceUpdate"))
							{
								driver.switchTo().window(window);
								Thread.sleep(3000);
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
								Thread.sleep(3000);
								WebElement clickYesFromAlert = driver.findElement(By.xpath("//a[contains(text(),'Yes, continue')]"));
								js.executeScript("arguments[0].scrollIntoView();", clickYesFromAlert);
								if(clickYesFromAlert.isDisplayed())
								{
									Thread.sleep(3000);
									js2.executeScript("arguments[0].click()", clickYesFromAlert);
									status = "pass";
									Thread.sleep(3000);
								}
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						
						 
					}
					}
				}
			
		}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	}
	public String checkWorkExperienceAlertYesButton()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			Thread.sleep(3000);
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				Thread.sleep(3000);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0, -100)","");//
					
					WebElement clickUpdateFromAreaOfInterest = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(4) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromAreaOfInterest);
					if(clickUpdateFromAreaOfInterest.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickUpdateFromAreaOfInterest);
						Thread.sleep(3000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
					driver.switchTo().window(window1);
					if(driver.getCurrentUrl().contains("workexperienceUpdate"))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0, 100)","");
						WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Workexperience_skipButonDesk'] button[class*='Workexperience_skipButton']"));
						js.executeScript("arguments[0].scrollIntoView();", clickCancel);
						JavascriptExecutor js2 = (JavascriptExecutor) driver;
						if(clickCancel.isDisplayed())
						{
							Thread.sleep(3000);
							js2.executeScript("arguments[0].click()", clickCancel);
							Thread.sleep(3000);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						driver.switchTo().window(window);
						if(driver.getCurrentUrl().contains("workexperienceUpdate"))
						{
							driver.switchTo().window(window);
							Thread.sleep(3000);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
							WebElement clickYesFromAlert = driver.findElement(By.xpath("//a[contains(text(),'Yes, continue')]"));
							js.executeScript("arguments[0].scrollIntoView();", clickYesFromAlert);
							if(clickYesFromAlert.isDisplayed())
							{
								Thread.sleep(3000);
								js2.executeScript("arguments[0].click()", clickYesFromAlert);
								status = "pass";
								Thread.sleep(3000);
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
							if(driver.getCurrentUrl().contains("workexperienceUpdate"))
							{
								Thread.sleep(3000);
								status = "pass";
								Thread.sleep(3000);
								System.out.println("Alert yes from work experience process done");
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
			status = "fail";
		}
		
		return status;
	
	}
	public String checkPersonalDetailsUpdateIcon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");

		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(3000);
					WebElement updateIcon = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(5) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", updateIcon);
					if(updateIcon.isDisplayed())
					{
						//js.executeScript("window.scrollBy(0, 100)","");
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", updateIcon);
						System.out.println("update icon clicked from personal Details section");
						Thread.sleep(3000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
						driver.switchTo().window(window1);
						Thread.sleep(3000);
						if(driver.getCurrentUrl().contains("aboutyouUpdate/"))
						{
							Thread.sleep(3000);
							driver.switchTo().window(window1);
							System.out.println("personal details update page");
							status = "pass";
							Thread.sleep(3000);
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
			status = "fail";
		}
		System.out.println("personal detail UpdateIcon process done");
		return status;
	
	}
	public String checkPersonalDetailsCancelIcon()
	{
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("aboutyouUpdate/"))
				{
					driver.switchTo().window(window);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, 500)","");
					Thread.sleep(3000);
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Aboutyou_skipButonDesk'] button[class*='Aboutyou_skipButton']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(3000);
					}
					Thread.sleep(3000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Set<String> a = driver.getWindowHandles();
					for(String win : a)
					{
						driver.switchTo().window(win);
						if(driver.getCurrentUrl().contains("aboutyouUpdate/"))
						{
							driver.switchTo().window(win);
							Thread.sleep(3000);
							WebElement getTextFromAlert = driver.findElement(By.xpath("//p[contains(text(),'Are you sure to cancel the updates?')]"));
							js.executeScript("arguments[0].scrollIntoView();", getTextFromAlert);
							System.out.println(getTextFromAlert.getText());
							status = "pass";
							System.out.println("Alert from personal detail");
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			status = "fail";
		}
		System.out.println("personal details cancelIcon process done");
		return status;
	}
	public String checkPersonalDetailsAlertClose()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("aboutyouUpdate/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					WebElement closeAlert = driver.findElement(By.cssSelector("button[class='btn-close']"));
					js.executeScript("arguments[0].scrollIntoView();", closeAlert);
					if(closeAlert.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", closeAlert);
						status = "pass";
						Thread.sleep(3000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);
					System.out.println(driver.getCurrentUrl());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		System.out.println("alert close from personal detail");
		return status;
	}
	public ArrayList<String> checkPersonalDetailsSubmitValidData(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("aboutyouUpdate"))
				{
					driver.switchTo().window(window);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, -200)","");
					Thread.sleep(2000);
					List<WebElement> selectPersonalDetails = driver.findElements(By.cssSelector("div[class='Aboutyou_currentWork__RD6fb'] ul li input"));
					for(int i = 0; i < selectPersonalDetails.size(); i++)
					{
						js.executeScript("arguments[0].scrollIntoView();", selectPersonalDetails.get(i));
						String getDataFromBrowser = selectPersonalDetails.get(i).getAttribute("value");
						for(int k = 0 ; k < data.size(); k++)
						{
							String getDataFromExcel = data.get(k);
							if(getDataFromBrowser.equalsIgnoreCase(getDataFromExcel))
							{
								Thread.sleep(3000);
								js.executeScript("arguments[0].click()", selectPersonalDetails.get(i));
								if(getDataFromExcel.equalsIgnoreCase("f"))
								{
									Thread.sleep(3000);
									status.add("f");
								}
								if(k == data.size()-1)
								{
									Thread.sleep(3000);
									break;
								}
							}
						}
					}
					Thread.sleep(3000);
					Select select = new Select(driver.findElement(By.cssSelector("select#year_of_birth")));
					select.selectByValue(data.get(2));
					js.executeScript("window.scrollBy(0, 400)","");
					Thread.sleep(2000);
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("div[class='row gy-3'] div[class='col-md-12']:nth-child(2) div[class='Aboutyou_buttonBottom___Uhqg'] button[type='submit']"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromContacts);
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickUpdateFromContacts);
						Thread.sleep(2000);
					}
					Thread.sleep(3000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
					Thread.sleep(3000);
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("/u/"))
					{
						driver.switchTo().window(window);
						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0, 600)","");
						Thread.sleep(3000);
						List<WebElement> selectInterestedTopicsFromHome = driver.findElements(By.cssSelector("div[class='profileheadLeft'] div[class='ProfileJourny_main']:nth-child(5) div[class='PersonalDetails'] ul li span"));
						for(int j = 0; j < selectInterestedTopicsFromHome.size(); j++)
						{
							for(int k = 0; k < data.size(); k++)
							{
								if(selectInterestedTopicsFromHome.get(j).getText().replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim().equalsIgnoreCase(data.get(k).replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim()))
								{
									Thread.sleep(3000);
									status.add(data.get(k));
									Thread.sleep(3000);
								}
							}
					    }
						System.out.println("personal details SubmitValidData process done");
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						Thread.sleep(3000);
				  }
			}
		
		}
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			status.add("fail");
		}
		return status;
	}
	public String checkPersonalDetailsAlertGoBackButton()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(3000);
					WebElement updateIcon = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(5) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", updateIcon);
					if(updateIcon.isDisplayed())
					{Thread.sleep(3000);
						js.executeScript("arguments[0].click()", updateIcon);
						Thread.sleep(3000);
					}
				}
			}
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
			Set<String> allWindows1 = driver.getWindowHandles();
			for(String window : allWindows1)
			{
				driver.switchTo().window(window);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				Thread.sleep(3000);
				if(driver.getCurrentUrl().contains("aboutyouUpdate/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0, 300)","");
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Aboutyou_skipButonDesk'] button[class*='Aboutyou_skipButton']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(3000);
					}

					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("aboutyouUpdate/"))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						WebElement clickGoBackFromAlert = driver.findElement(By.xpath("//button[contains(text(),'like to go back')]"));
						js.executeScript("arguments[0].scrollIntoView();", clickGoBackFromAlert);
						if(clickGoBackFromAlert.isDisplayed())
						{
							Thread.sleep(3000);
							js.executeScript("arguments[0].click()", clickGoBackFromAlert);
							System.out.println("personal details_Alert_goBackButton process done");
							status = "pass";
							Thread.sleep(3000);
						}
						/*
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						 * Thread.sleep(3000); driver.switchTo().window(window);
						 * if(driver.getCurrentUrl().contains("/u/")) {
						 * driver.switchTo().window(window);
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						 * jse1.executeScript("window.scrollBy(0, 500)","");
						 * System.out.println("Profile page"); Thread.sleep(3000);
						 * 
						 * driver.switchTo().window(window);
						 * 
						 * }
						 */
					}
					}
				}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	}
	public String checkPersonalDetailsAlertYesButton()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			/*Set<String> allWindows1 = driver.getWindowHandles();
			for(String window : allWindows1)
			{
				driver.switchTo().window(window);
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				Thread.sleep(3000);
				if(driver.getCurrentUrl().contains("aboutyouUpdate/"))
				{
					driver.switchTo().window(window);
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Aboutyou_skipButonDesk'] button[class*='Aboutyou_skipButton']"));
					
					if(clickCancel.isDisplayed())
					{
						
						jse1.executeScript("arguments[0].click()", clickCancel);
					}
				}
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Thread.sleep(3000);
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);
					
					jse1.executeScript("window.scrollBy(0, 500)","");
					Thread.sleep(3000);
					WebElement clickUpdateFromAreaOfInterest = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(5) div[class='EditUpdate'] a"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
				if(clickUpdateFromAreaOfInterest.isDisplayed())
				{
					
					js.executeScript("arguments[0].click()", clickUpdateFromAreaOfInterest);
				}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);*/
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);
					
					js.executeScript("window.scrollBy(0, 500)","");
					Thread.sleep(3000);
					WebElement clickUpdateFromPersonalDetail = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(5) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", clickUpdateFromPersonalDetail);
					if(clickUpdateFromPersonalDetail.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickUpdateFromPersonalDetail);
						Thread.sleep(3000);
					}
				}
			}
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
					driver.switchTo().window(window1);
					if(driver.getCurrentUrl().contains("aboutyouUpdate"))
					{
						driver.switchTo().window(window1);
						Thread.sleep(3000);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0, 300)","");
						WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Aboutyou_skipButonDesk'] button[class*='Aboutyou_skipButton']"));
						js.executeScript("arguments[0].scrollIntoView();", clickCancel);
						if(clickCancel.isDisplayed())
						{
							Thread.sleep(3000);
							js.executeScript("arguments[0].click()", clickCancel);
							Thread.sleep(3000);
						}
						driver.switchTo().window(window1);
						if(driver.getCurrentUrl().contains("aboutyouUpdate"))
						{
							driver.switchTo().window(window1);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
							WebElement clickYesFromAlert = driver.findElement(By.xpath("//a[contains(text(),'Yes, continue')]"));
							js.executeScript("arguments[0].scrollIntoView();", clickYesFromAlert);
							if(clickYesFromAlert.isDisplayed())
							{
								Thread.sleep(3000);
								js.executeScript("arguments[0].click()", clickYesFromAlert);
								status = "pass";
								Thread.sleep(3000);
								System.out.println("Alert yes from personal details process done");
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
						}
					}
				}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	
	}
	
	public String checkEducation_updateIcon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");

		String status = "";
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/aboutyouUpdate/"))
				{
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Aboutyou_skipButonDesk'] button[class*='Aboutyou_skipButton']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(3000);
					}
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("aboutyouUpdate"))
					{
						driver.switchTo().window(window);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						WebElement clickYesFromAlert = driver.findElement(By.xpath("//a[contains(text(),'Yes, continue')]"));
						js.executeScript("arguments[0].scrollIntoView();", clickYesFromAlert);
						if(clickYesFromAlert.isDisplayed())
						{
							Thread.sleep(3000);
							js.executeScript("arguments[0].click()", clickYesFromAlert);
							status = "pass";
							Thread.sleep(3000);
							System.out.println("Alert yes from personal details process done");
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
					}
				}
				if(driver.getCurrentUrl().contains("/u/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(3000);
					WebElement updateIcon = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(6) div[class='EditUpdate'] a"));
					js.executeScript("arguments[0].scrollIntoView();", updateIcon);
					Thread.sleep(1000);
					if(updateIcon.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", updateIcon);
						status = "pass";
						Thread.sleep(3000);
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
						driver.switchTo().window(window1);
						Thread.sleep(3000);
						if(driver.getCurrentUrl().contains("educationUpdate/"))
						{
							Thread.sleep(3000);
							driver.switchTo().window(window1);
							System.out.println("education details update page");
							status = "pass";
							Thread.sleep(3000);
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
			status = "fail";
		}
		System.out.println("personal detail UpdateIcon process done");
		return status;
	
	}
	public String checkEducation_cancelIcon()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("educationUpdate/"))
				{
					driver.switchTo().window(window);
					
					js.executeScript("window.scrollBy(0, 400)","");
					Thread.sleep(3000);
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Education_skipButonDesk'] button[class*='Education_skipButton']"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					Thread.sleep(1000);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(3000);
					}
					Thread.sleep(3000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					Set<String> a = driver.getWindowHandles();
					for(String win : a)
					{
						driver.switchTo().window(win);
						if(driver.getCurrentUrl().contains("educationUpdate/"))
						{
							driver.switchTo().window(win);
							Thread.sleep(3000);
							WebElement getTextFromAlert = driver.findElement(By.xpath("//p[contains(text(),'Are you sure to cancel the updates?')]"));
							System.out.println(getTextFromAlert.getText());
							status = "pass";
							System.out.println("Alert from personal detail");
							Thread.sleep(3000);
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			status = "fail";
		}
		System.out.println("education details cancelIcon process done");
		return status;
	}
	public String checkEducation_Alert_close()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("educationUpdate/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					WebElement closeAlert = driver.findElement(By.cssSelector("button[class='btn-close']"));
					js.executeScript("arguments[0].scrollIntoView();", closeAlert);
					Thread.sleep(1000);
					if(closeAlert.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", closeAlert);
						Thread.sleep(3000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					Thread.sleep(3000);
					status = "pass";
					System.out.println(driver.getCurrentUrl());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		System.out.println("alert close from education detail");
		return status;
	}
	public ArrayList<String> checkEducation_submitValidData(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("educationUpdate"))
				{
					driver.switchTo().window(window);
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, -200)","");
					Thread.sleep(2000);
					Select select = new Select(driver.findElement(By.cssSelector("select#year_of_birth")));
					select.selectByVisibleText(data.get(1));
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(0, 100)","");
					WebElement clickUpdateFromContacts = driver.findElement(By.cssSelector("div[class*='Education_buttonBottom']>button"));
					Thread.sleep(1000);
					if(clickUpdateFromContacts.isDisplayed())
					{
						Thread.sleep(2000);
						js.executeScript("arguments[0].click()", clickUpdateFromContacts);
						Thread.sleep(2000);
					}
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					Thread.sleep(2000);
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("/u/"))
					{
						driver.switchTo().window(window);
						Thread.sleep(3000);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0, 500)","");
						Thread.sleep(1000);
						List<WebElement> selectInterestedTopicsFromHome = driver.findElements(By.cssSelector("div[class='ProfileJourny_main']:nth-child(6) div[class='ProfileUserDetails']>ul>li>a"));
						for(int j = 0; j < selectInterestedTopicsFromHome.size(); j++)
						{
							for(int k = 0; k < data.size(); k++)
							{
								if(!selectInterestedTopicsFromHome.get(j).getText().replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim().equalsIgnoreCase(data.get(k).replaceAll("[^a-zA-Z0-9]", " ").replace(" ","").trim()))
								{
									Thread.sleep(3000);
									status.add(data.get(k));
									Thread.sleep(3000);
									break;
								}
							}
					    }
				  }
			}
		
		}
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			status.add("fail");
		}
		System.out.println("education details SubmitValidData process done");
		return status;
	}
	public String checkEducation_Alert_goBackButton()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/u/"))
				{
					WebElement updateFromProfile = driver.findElement(By.cssSelector("div[class='ProfileJourny_main']:nth-child(6) button[class='btn Updatebtn']"));
					js.executeScript("arguments[0].scrollIntoView();", updateFromProfile);
					if(updateFromProfile.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", updateFromProfile);
						Thread.sleep(3000);
					}
				}
				if(driver.getCurrentUrl().contains("educationUpdate/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0, 300)","");
					Thread.sleep(3000);
					
					Thread.sleep(1000);
					WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Education_buttonBottom']>div[class*='Education_skipButonDesk']>button"));
					js.executeScript("arguments[0].scrollIntoView();", clickCancel);
					Thread.sleep(1000);
					if(clickCancel.isDisplayed())
					{
						Thread.sleep(3000);
						js.executeScript("arguments[0].click()", clickCancel);
						Thread.sleep(3000);
					}
					Thread.sleep(3000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
					Thread.sleep(3000);
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("educationUpdate/"))
					{
						driver.switchTo().window(window);
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						WebElement clickGoBackFromAlert = driver.findElement(By.xpath("//button[contains(text(),' like to go back')]"));
						js.executeScript("arguments[0].scrollIntoView();", clickGoBackFromAlert);
						if(clickGoBackFromAlert.isDisplayed())
						{
							Thread.sleep(3000);
							js.executeScript("arguments[0].click()", clickGoBackFromAlert);
							status = "pass";
							Thread.sleep(3000);
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						System.out.println("personal details_Alert_back Button process done");
						/*
						 * driver.switchTo().window(window); if(driver.getCurrentUrl().contains("/u/"))
						 * { driver.switchTo().window(window);
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						 * System.out.println("Profile page");
						 * js.executeScript("window.scrollBy(0, 600)",""); Thread.sleep(3000); status =
						 * "pass";
						 * System.out.println("personal details_Alert_back Button process done"); }
						 */
						WebElement clickCancelButton = driver.findElement(By.cssSelector("div[class*='Education_skipButonDesk'] button[class='Education_skipButton__AN_lA']"));
						js.executeScript("arguments[0].scrollIntoView();", clickCancelButton);
						if(clickCancelButton.isDisplayed())
						{
							js.executeScript("arguments[0].click()", clickCancelButton);
						}
						/*
						 * WebElement againClickGoBackFromAlert =
						 * driver.findElement(By.xpath("//button[contains(text(),' like to go back')]"))
						 * ; js.executeScript("arguments[0].scrollIntoView();",
						 * againClickGoBackFromAlert); againClickGoBackFromAlert.click();
						 */
						WebElement clickContinue = driver.findElement(By.xpath("//a[contains(text(),'Yes, continue')]"));
						js.executeScript("arguments[0].scrollIntoView();", clickContinue);
						if(clickCancelButton.isDisplayed())
						{
							js.executeScript("arguments[0].click()", clickContinue);
						}
						driver.switchTo().window(window);
						if(driver.getCurrentUrl().contains("/u/"))
						{
							driver.switchTo().window(window);
							WebElement clickDropdown = driver.findElement(By.cssSelector("li[class='SigNUP']>a"));
							js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
							if(clickDropdown.isDisplayed())
							{
								js.executeScript("arguments[0].click()", clickDropdown);
								WebElement signout = driver.findElement(By.cssSelector("ul[class='dropdown-menu Primary02_Blue']>li:nth-child(5)>a"));
								if(signout.isDisplayed())
								{
									js.executeScript("arguments[0].click()", signout);
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
			status = "fail";
		}
		
		return status;
	}
	public String checkEducation_Alert_yesButton()
	{
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			js.executeScript("window.scrollBy(0, 800)","");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			
			  Set<String> allWindows = driver.getWindowHandles();
			  for(String window : allWindows)
			  {
				  driver.switchTo().window(window);
				  Thread.sleep(1000);
			  if(driver.getCurrentUrl().contains("/u/")) 
			  {
			  driver.switchTo().window(window);
			  Thread.sleep(1000);
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			  Thread.sleep(2000); 
			  WebElement clickUpdateFromEducation = driver.findElement(By.cssSelector("div[class='profileheadLeft']>div[class='ProfileJourny_main']:nth-child(6) div[class='EditUpdate'] a")); 
			  Thread.sleep(1000);
			  if(clickUpdateFromEducation.isDisplayed())
			  {
				  Thread.sleep(3000);
				  js.executeScript("window.scrollBy(0, -100)","");
				  js.executeScript("arguments[0].click()", clickUpdateFromEducation);
				  Thread.sleep(3000);
			  }
			  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			  Thread.sleep(3000);
			 
					Set<String> allWindows1 = driver.getWindowHandles();
					for(String window1 : allWindows1)
					{
					driver.switchTo().window(window1);
					if(driver.getCurrentUrl().contains("educationUpdate"))
					{
						driver.switchTo().window(window1);
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0, 300)","");
						JavascriptExecutor js2 = (JavascriptExecutor) driver;
						WebElement clickCancel = driver.findElement(By.cssSelector("div[class*='Education_buttonBottom']>div[class*='Education_skipButonDesk']>button"));
						js.executeScript("arguments[0].scrollIntoView();", clickCancel);
						Thread.sleep(1000);
						if(clickCancel.isDisplayed())
						{
							Thread.sleep(3000);
							js2.executeScript("arguments[0].click()", clickCancel);
							Thread.sleep(3000);
						}
						driver.switchTo().window(window1);
						if(driver.getCurrentUrl().contains("educationUpdate"))
						{
							driver.switchTo().window(window1);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
							WebElement clickYesFromAlert = driver.findElement(By.xpath("//a[contains(text(),'Yes, continue')]"));
							js.executeScript("arguments[0].scrollIntoView();", clickYesFromAlert);
							Thread.sleep(1000);
							if(clickYesFromAlert.isDisplayed())
							{
								Thread.sleep(3000);
								js2.executeScript("arguments[0].click()", clickYesFromAlert);
								status = "pass";
								Thread.sleep(3000);
								System.out.println("Alert yes from education details process done");
							}
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
							Thread.sleep(3000);
						}
					}
					}
			  }
			  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		return status;
	
	}
	
	
}
