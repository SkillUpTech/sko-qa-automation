package com.seo.regression.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPageLocator 
{
	WebDriver driver;
	ProcessLogin processLogin;
	
	public AccountPageLocator(WebDriver driver)
	{
		this.driver = driver;
		this.processLogin = new ProcessLogin(this.driver);
	}
	
	
	public ArrayList<String> checkInitial(ArrayList<String> data)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ArrayList<String> status = new ArrayList<String>();
		String initialText = "";
		try
		{
			String parentWindow = driver.getWindowHandle();
			
			Set<String> allWindow = driver.getWindowHandles();
			for(String window : allWindow)
			{
				driver.switchTo().window(window);
				
				if(driver.getCurrentUrl().contains(OpenWebsite.setHost+"/"))
				{
					driver.switchTo().window(window);
					
					WebElement clickLogin = driver.findElement(By.cssSelector("ul[class='list-unstyled navbar-nav nav Header_navButtons__3h4Rp'] li[class='Header_loginBtn__3Xv3A'] a"));
					js.executeScript("arguments[0].scrollIntoView();", clickLogin);
					if(clickLogin.isDisplayed())
					{
						js.executeScript("arguments[0].click()", clickLogin);
					}
					
					if(driver.getCurrentUrl().contains("login"))
					{
						driver.switchTo().window(window);
						
						if(driver.getCurrentUrl().contains("login?"))
						{
							driver.switchTo().window(window);
							
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
							js.executeScript("window.scrollBy(0, 200)", "");
							WebElement userNameElement = driver.findElement(By.cssSelector("input#email"));
							js.executeScript("arguments[0].scrollIntoView();", userNameElement);
							userNameElement.clear();
							userNameElement.sendKeys("Hemamalini@skillup.tech");
							WebElement passwordElement = driver.findElement(By.cssSelector("input#password"));
							js.executeScript("arguments[0].scrollIntoView();", passwordElement);
							passwordElement.clear();
							passwordElement.sendKeys("Test@123");
							js.executeScript("window.scrollBy(0, 100)", "");
							WebElement clickSubmit = driver.findElement(By.cssSelector("input[value='Log In']"));
							js.executeScript("arguments[0].scrollIntoView();", clickSubmit);
							
							if(clickSubmit.isDisplayed())
							{
								js.executeScript("arguments[0].click()", clickSubmit);
							}
							
							driver.switchTo().window(window);
							
							if(driver.getCurrentUrl().contains("dashboard"))
							{
								driver.switchTo().window(window);
								
								WebElement checkInitial = driver.findElement(By.cssSelector("li[class*='Header_SigNUP'] span[class*='NOLoginDSKTXT']"));
								js.executeScript("arguments[0].scrollIntoView();", checkInitial);
								
								if(checkInitial.isDisplayed())
								{
									initialText = checkInitial.getText();
								}
								
								WebElement clickDropdown = driver.findElement(By.cssSelector("li[class*='Header_SigNUP'] img[alt='icon']"));
								js.executeScript("arguments[0].scrollIntoView();", clickDropdown);
								if(clickDropdown.isDisplayed())
								{
									js.executeScript("arguments[0].click()", clickDropdown);
									
									WebElement clickAccount = driver.findElement(By.cssSelector("ul[class*='dropdown-menu Header_Primary02_Blue']>li:nth-child(4)>a"));
									js.executeScript("arguments[0].scrollIntoView();", clickAccount);
									if(clickAccount.isDisplayed())
									{
										js.executeScript("arguments[0].click()", clickAccount);
									}
								}
								
								if(driver.getCurrentUrl().contains("account"))
								{
									driver.switchTo().window(window);
									WebElement checkInitialOnAccount = driver.findElement(By.cssSelector("li[class*='Header_SigNUP'] span[class*='NOLoginDSKTXT'], span[class*='NOLoginDSKTXT']"));
									js.executeScript("arguments[0].scrollIntoView();", checkInitialOnAccount);
									if(checkInitialOnAccount.isDisplayed())
									{
										String initialTextOnAccount = checkInitialOnAccount.getText();
										if(initialText.equalsIgnoreCase(initialTextOnAccount))
										{
											status.add("true");
										}
										else
										{
											status.add("AccountPage");
										}
									}
								}
								String orderPage = driver.getWindowHandle();
								WebElement orderHistory = driver.findElement(By.cssSelector("button[id='orders-tab']"));
								js.executeScript("arguments[0].scrollIntoView();", orderHistory);
								if(orderHistory.isDisplayed())
								{
									js.executeScript("arguments[0].click()", orderHistory);
									
									WebElement orderDetailPage = driver.findElement(By.cssSelector("div[class='account-settings-section-body ordersTabSections-section-body'] div[class*='SKILLUP-105634'] span[class*='u-field-order-link']>a[href*='receipt']"));
									js.executeScript("arguments[0].scrollIntoView();", orderDetailPage);
									if(orderDetailPage.isDisplayed())
									{
										js.executeScript("arguments[0].click()", orderDetailPage);
										
									}
								}
									Set<String> windows = driver.getWindowHandles();
									for(String win : windows)
									{
										driver.switchTo().window(win);
										if(driver.getCurrentUrl().contains("receipt"))
										{
											driver.switchTo().window(win);
											WebElement checkInitialOnReceipt = driver.findElement(By.cssSelector("li[class='SigNUP'] span[class*='NOLoginDSKTXT']"));
											js.executeScript("arguments[0].scrollIntoView();", checkInitialOnReceipt);
											if(checkInitialOnReceipt.isDisplayed())
											{
												String initialTextOnReceipt = checkInitialOnReceipt.getText();
												if(initialText.equalsIgnoreCase(initialTextOnReceipt))
												{
													status.add("true");
													driver.close();
													driver.switchTo().window(orderPage);
													break;
												}
												else
												{
													status.add("ReceiptPage");
												}
											}
										}
										driver.switchTo().window(orderPage);
									}
									driver.switchTo().window(orderPage);	
									
												WebElement invoiceDetailPage = driver.findElement(By.cssSelector("div[class='account-settings-section-body ordersTabSections-section-body'] div[class*='SKILLUP-105634'] span[class*='u-field-order-link']>a[href*='invoice']"));
												js.executeScript("arguments[0].scrollIntoView();", invoiceDetailPage);
												if(invoiceDetailPage.isDisplayed())
												{
													js.executeScript("arguments[0].click()", invoiceDetailPage);
													
												}
												Set<String> windowsPage = driver.getWindowHandles();
												for(String wind : windowsPage)
												{
													driver.switchTo().window(wind);
													if(driver.getCurrentUrl().contains("invoice"))
													{
														driver.switchTo().window(wind);
														status.add("true");
														driver.close();
														driver.switchTo().window(orderPage);
												   }
													driver.switchTo().window(orderPage);
											   }
											
											
										}
									}
									
							     }
							}
					
				driver.switchTo().window(parentWindow);
			}
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String checkAccount()
	{
		String status = "";
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
