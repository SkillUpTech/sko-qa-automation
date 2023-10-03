package com.seo.regression.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FAQLocator
{
	WebDriver driver;
	ProcessLogin processLogin;
	
	public FAQLocator(WebDriver driver)
	{
		this.driver = driver;
		this.processLogin = new ProcessLogin(this.driver);
	}
	
	public String loginProcess(String email, String pwd)
	{
		String status = "fail";
		try
		{
			this.processLogin.checkValidCredentials(email, pwd);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> FAQProcess()
	{
		ArrayList<String> failedFAQ = new ArrayList<String>();
		try
		{
			WebElement clickFAQ = driver.findElement(By.cssSelector("div[class*='Footer_FootMenuiNNr'] ul>li:nth-child(4)>a"));
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", clickFAQ);
			Thread.sleep(1000);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-200)", "");
			Thread.sleep(1000);
			clickFAQ.click();
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("faq"))
				{
					driver.switchTo().window(window);
					
					List<WebElement> faqLocator = driver.findElements(By.cssSelector("div[class*='container-fluid Card_containerInner'] div[class='row gx-3 gy-2'] div[class*='undefined']"));
					for(int i = 0; i < faqLocator.size(); i++)
					{
						String faqHeading = faqLocator.get(i).findElement(By.cssSelector(" h2")).getText();
						
						WebElement faqLink = faqLocator.get(i).findElement(By.cssSelector(" a:not([href])"));
						if(faqLink.isDisplayed())
						{
							JavascriptExecutor js = (JavascriptExecutor) driver;
							js.executeScript("arguments[0].click()", faqLink);
						}
						List<WebElement> faqVerification = driver.findElements(By.cssSelector("div[class*='container-fluid Accordion_containerInner']>div>div[class='col-lg-7 col-12']>div[class='col-12']"));
						for(int j = 0; j < faqVerification.size(); j++)
						{
							if(i == j)
							{
								String checkFaqHeading = faqVerification.get(j).findElement(By.cssSelector(" h2[class*='Accordion_FAQtopHeading']")).getText();
								if(!faqHeading.equals(checkFaqHeading))
								{
									failedFAQ.add(faqHeading.concat(" is not same when compare heading"));
								}
								else
								{
									System.out.println("FAQ : "+faqHeading+ "working fine");
								}
								List<WebElement> checkFaq =faqVerification.get(j).findElements(By.cssSelector(" div>div[class='border-0 my-1 accordion-item']>h2>button"));
								for(int k = 0; k < checkFaq.size(); k++)
								{
									JavascriptExecutor js = (JavascriptExecutor) driver;
									js.executeScript("arguments[0].click()", checkFaq.get(k));
									//checkFaq.get(k).click();
									if(faqVerification.get(j).findElement(By.cssSelector(" div[class='accordion-collapse collapse show']")).isDisplayed())
									{
										JavascriptExecutor js1 = (JavascriptExecutor) driver;
										js1.executeScript("arguments[0].click()", checkFaq.get(k));
										//checkFaq.get(k).click();
									}
									if(k==checkFaq.size()-1)
									{
										((JavascriptExecutor) driver)
									    .executeScript("window.scrollTo(0, -document.body.scrollHeight)");
										break;
									}
								}
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
		}
		return failedFAQ;
	}
	
	public String verifyInvalidFullname()
	{
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public String EmptyFullname()
	{
		return null;
	}
	public String validFullname()
	{
		return null;
	}
	public String invalidEmail()
	{
		return null;
	}
	public String EmptyEmail()
	{
		return null;
	}
	public String validEmail()
	{
		return null;
	}
	public String InvalidContact()
	{
		return null;
	}
	public String EmptyContact()
	{
		return null;
	}
	public String validContact()
	{
		return null;
	}
	public String EmptyQuery()
	{
		return null;
	}
}
