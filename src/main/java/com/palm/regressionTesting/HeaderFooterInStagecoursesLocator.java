package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderFooterInStagecoursesLocator 
{
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'LOGIN')]")
	private List<WebElement> clickLoginIcon;
	
	
	@FindBy(xpath = "//a[contains(@href,'about')][contains(@href,'header')]")
	private List<WebElement> clickAboutSkillupIcon;
	
	@FindBy(xpath = "//a[contains(@href,'contact')][contains(@href,'header')]")
	private List<WebElement> clickContactUSIcon;
	
	@FindBy(xpath = "//a[contains(@href,'blog')][contains(@href,'header')]")
	private List<WebElement> clickBlogIcon;
	
	@FindBy(xpath = "//img[@alt='twitter']/parent::a")
	private List<WebElement> clickTwitter;
	
	@FindBy(xpath = "//img[@alt='facebook']/parent::a")
	private List<WebElement> clickFacebook;
	
	@FindBy(xpath = "//img[@alt='linkedin']/parent::a")
	private List<WebElement> clickLinkedIn;
	
	@FindBy(xpath = "//img[@alt='instagram']/parent::a")
	private List<WebElement> clickInstagram;
	
	@FindBy(xpath = "//img[@alt='youtube']/parent::a")
	private List<WebElement> clickYoutube;
	
	@FindBy(xpath = "//a[contains(@href,'contact')][contains(@href,'Footer')]")
	private List<WebElement> clickContactUSFooter;
	
	@FindBy(xpath = "//a[contains(@href,'about')][contains(@href,'Footer')]")
	private List<WebElement> clickAboutSkillupOnlineFooter;
	
	@FindBy(xpath = "//a[contains(@href,'enterprise')][contains(@href,'Footer')]")
	private List<WebElement> clickBusinessFooter;
	
	@FindBy(xpath = "//a[contains(@href,'faq')][contains(@href,'Footer')]")
	private List<WebElement> clickFAQFooter;
	
	@FindBy(xpath = "//a[contains(@href,'privacy')][contains(@href,'Footer')]")
	private List<WebElement> clickPrivacyFooter;
	
	@FindBy(xpath = "//a[contains(@href,'tos')][contains(@href,'Footer')]")
	private List<WebElement> clickTOSFooter;
	
	@FindBy(xpath = "//a[contains(@href,'blog?')][contains(@href,'Footer')]")
	private List<WebElement> clickBlogFooter;
	
	
	@FindBy(xpath = "//a[contains(@href,'prpage')][contains(@href,'Footer')]")
	private List<WebElement> clickPressReleaseFooter;
	
	
	@FindBy(xpath = "//a[contains(@href,'events')][contains(@href,'Footer')]")
	private List<WebElement> clickEventsFooter;
	
	@FindBy(xpath = "//a[contains(@href,'news')][contains(@href,'Footer')]")
	private List<WebElement> clickNewsLetterPageFooter;
	
	@FindBy(xpath = "//a[contains(@href,'place')][contains(@href,'Footer')]")
	private List<WebElement> clickPlacementFooter;
	
	String parentWindow = "";
	String baseWindow = "";
	
	public HeaderFooterInStagecoursesLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	String checkPageLink = "";
	
	public String AboutSkillupOnlineProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		baseWindow = driver.getWindowHandle();
		try
		{
			String getURL = driver.getCurrentUrl();
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(getURL);
			
			checkPageLink = driver.getWindowHandle();
			if ((clickLoginIcon).size() > 0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickLoginIcon.get(0));
				String loginURL = clickLoginIcon.get(0).getAttribute("href");
				if(clickLoginIcon.get(0).isDisplayed())
                {
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(loginURL);
					parentWindow = driver.getWindowHandle();
					status = "pass";
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
                }
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			if(clickAboutSkillupIcon.size() > 0)
			{
					js.executeScript("arguments[0].scrollIntoView();", clickAboutSkillupIcon.get(0));
					String getURL = clickAboutSkillupIcon.get(0).getAttribute("href");
					if (clickAboutSkillupIcon.get(0).isDisplayed()) 
					{
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getURL);
						status = "pass";
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" About Skillup icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" About Skillup icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
					}
	            }
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String ContactUsProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickContactUSIcon.size() > 0)
			{
				if(clickContactUSIcon.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickContactUSIcon.get(0));
					String contactURL = clickContactUSIcon.get(0).getAttribute("href");
					if(clickContactUSIcon.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(contactURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" ContactUs icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" ContactUs  icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
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
	public String BlogProcess(ArrayList<String> data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickBlogIcon.size() > 0)
			{
				if(clickBlogIcon.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickBlogIcon.get(0));
					String blogURL = clickBlogIcon.get(0).getAttribute("href");
					if(clickBlogIcon.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(blogURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data.get(1)))
						{
							status = "pass";
							System.out.println(" Blog icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" Blog  icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public String twitterProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickTwitter.size() > 0)
			{
				if(clickTwitter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickTwitter.get(0));
					String twitterURL = clickTwitter.get(0).getAttribute("href");
					if(clickTwitter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(twitterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" twitter icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" twitter  icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String facebookProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickFacebook.size() > 0)
			{
				if(clickFacebook.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickFacebook.get(0));
					String facebookURL = clickFacebook.get(0).getAttribute("href");
					if(clickFacebook.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(facebookURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" facebook icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" facebook  icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String linkedInProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickLinkedIn.size() > 0)
			{
				if(clickLinkedIn.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickLinkedIn.get(0));
					String linkedInURL = clickLinkedIn.get(0).getAttribute("href");
					if(clickLinkedIn.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(linkedInURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" linked in  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" linked in   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String instagramProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickInstagram.size() > 0)
			{
				if(clickInstagram.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickInstagram.get(0));
					String instagramURL = clickInstagram.get(0).getAttribute("href");
					if(clickInstagram.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(instagramURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" Instagram  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" Instagram   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String youtubeProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickYoutube.size() > 0)
			{
				if(clickYoutube.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickYoutube.get(0));
					String youtubeURL = clickYoutube.get(0).getAttribute("href");
					if(clickYoutube.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(youtubeURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" youtube  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" youtube   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String contactUSProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickContactUSFooter.size() > 0)
			{
				if(clickContactUSFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickContactUSFooter.get(0));
					String contactUsFooterURL = clickContactUSFooter.get(0).getAttribute("href");
					if(clickContactUSFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(contactUsFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" contactUsFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" contactUsFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String AboutSkillupOnlineFooterProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickAboutSkillupOnlineFooter.size() > 0)
			{
				if(clickAboutSkillupOnlineFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickAboutSkillupOnlineFooter.get(0));
					String AboutSkillupFromFooterURL = clickAboutSkillupOnlineFooter.get(0).getAttribute("href");
					if(clickAboutSkillupOnlineFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(AboutSkillupFromFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" AboutSkillupOnline  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" AboutSkillupOnline  icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String SkillupOnlineForBusinessProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickBusinessFooter.size() > 0)
			{
				if(clickBusinessFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickBusinessFooter.get(0));
					String businessFooterURL = clickBusinessFooter.get(0).getAttribute("href");
					if(clickBusinessFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(businessFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" BusinessFromFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" BusinessFromFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public String FAQProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickFAQFooter.size() > 0)
			{
				if(clickFAQFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickFAQFooter.get(0));
					String FAQFooterURL = clickFAQFooter.get(0).getAttribute("href");
					if(clickFAQFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(FAQFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" FAQFromFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" FAQFromFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String PrivacyPolicyProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickPrivacyFooter.size() > 0)
			{
				if(clickPrivacyFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickPrivacyFooter.get(0));
					String privacyFooterURL = clickPrivacyFooter.get(0).getAttribute("href");
					if(clickPrivacyFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(privacyFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" PrivacyFromFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" PrivacyFromFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public String TermsOfServiceProcess(String data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickTOSFooter.size() > 0)
			{
				if(clickTOSFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickTOSFooter.get(0));
					String TOSFooterURL = clickTOSFooter.get(0).getAttribute("href");
					if(clickTOSFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(TOSFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data))
						{
							status = "pass";
							System.out.println(" TOSFromFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" TOSFromFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public String BlogFooterProcess(ArrayList<String> data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickBlogFooter.size() > 0)
			{
				if(clickBlogFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickBlogFooter.get(0));
					String BlogFooterURL = clickBlogFooter.get(0).getAttribute("href");
					if(clickBlogFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(BlogFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data.get(1)))
						{
							status = "pass";
							System.out.println(" BlogFromFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" BlogFromFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	
	public String pressReleaseFooterProcess(ArrayList<String> data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickPressReleaseFooter.size() > 0)
			{
				if(clickBlogFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickPressReleaseFooter.get(0));
					String pressReleaseFooterURL = clickPressReleaseFooter.get(0).getAttribute("href");
					if(clickPressReleaseFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(pressReleaseFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data.get(1)))
						{
							status = "pass";
							System.out.println(" pressReleaseFromFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" pressReleaseFromFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String eventsFooterProcess(ArrayList<String> data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickEventsFooter.size() > 0)
			{
				if(clickEventsFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickEventsFooter.get(0));
					String EventsFooterURL = clickEventsFooter.get(0).getAttribute("href");
					if(clickEventsFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(EventsFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data.get(1)))
						{
							status = "pass";
							System.out.println(" EventsFromFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" EventsFromFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
		
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String newsLetterFooterProcess(ArrayList<String> data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickNewsLetterPageFooter.size() > 0)
			{
				if(clickNewsLetterPageFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickNewsLetterPageFooter.get(0));
					String newsLetterFooterURL = clickNewsLetterPageFooter.get(0).getAttribute("href");
					if(clickBlogFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(newsLetterFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data.get(1)))
						{
							status = "pass";
							System.out.println(" newLetterFromFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" newLetterFromFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
	                }
				}
			}
			Thread.sleep(500);
			driver.close();
			driver.switchTo().window(baseWindow);
			System.out.println("homepage and login page link comparision is done");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public String placementFooterProcess(ArrayList<String> data)
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickPlacementFooter.size() > 0)
			{
				if(clickPlacementFooter.get(0).isDisplayed())
				{
					js.executeScript("arguments[0].scrollIntoView();", clickPlacementFooter.get(0));
					String PlacementFooterURL = clickPlacementFooter.get(0).getAttribute("href");
					if(clickPlacementFooter.get(0).isDisplayed())
	                {
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(PlacementFooterURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
						if(driver.getCurrentUrl().contains(data.get(1)))
						{
							status = "pass";
							System.out.println(" BlogFromFooter  icon verified on header is pass");
						} 
						else
						{
							status = driver.getCurrentUrl();
							System.out.println(" BlogFromFooter   icon verified on header is fail");
						}
						driver.close();
						driver.switchTo().window(parentWindow);
						Thread.sleep(500);
						driver.close();
						driver.switchTo().window(baseWindow);
						System.out.println("homepage");
	                }
				}
			}
		
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
