package com.palm.regressionTesting;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLinksLocator {

	String url ;
	WebDriver driver;
	String parentWindow = "";
	//OpenWebsite openWebsite;
	
	@FindBy(css = "ul[class='list-unstyled navbar-nav nav Header_navButtons__3h4Rp']>li[class='Header_loginBtn__3Xv3A']>a")
	private List<WebElement> clickLoginIcon;
	
	@FindBy(css = "div[class='form-group spacing-mb40'] a")
	private List<WebElement> clickForgotLink;
	
	@FindBy(css = "div[class='col-md-8 col-sm-12'] div[class='singupV2-form']>p>a")
	private List<WebElement> clickSignUpLink;
	
	@FindBy(css = "span[class='Bodycopy-Link Neutral_01-text spacing-mt20']>a:nth-child(1)")
	private List<WebElement> clickTermAndService;
	
	@FindBy(css = "span[class='Bodycopy-Link Neutral_01-text spacing-mt20']>a:nth-child(2)")
	private List<WebElement> clickPrivacyAndPolicy;
	
	@FindBy(css = "div[class='social-section']>a:nth-child(1)")
	private List<WebElement> clickFacebookLink;
	
	@FindBy(css = "div[class='social-section']>a:nth-child(2)")
	private List<WebElement> clickGoogleLink;
	
	@FindBy(css = "div[class='social-section']>a:nth-child(3)")
	private List<WebElement> clickLinkedInLink;
	
	@FindBy(css = "div[class='social-section']>a:nth-child(4)")
	private List<WebElement> clickMicrosoftLink;
	
	@FindBy(css = "ul[class='nav sinup-tabs']>li[id='signuplink']>a")
	private List<WebElement> clickSignUpTab;
	
	public LoginPageLinksLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String checkLoginIconLink()
	{
		String status = "fail";
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickLoginIcon.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickLoginIcon.get(0));
				String getURL = clickLoginIcon.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				parentWindow = driver.getWindowHandle();
				System.out.println("Parent Window : login page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	
	public String checkForgotPasswordLink()
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickForgotLink.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickForgotLink.get(0));
				String getURL = clickForgotLink.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				System.out.println("forgot pwd page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}
	public String checkSignUpLink()
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickSignUpLink.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickSignUpLink.get(0));
				String getURL = clickSignUpLink.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				System.out.println("sign up  page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "fail";
			// TODO: handle exception
		}
		return status;
	}
	public String checkTermOfServiceLink()
	{
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickTermAndService.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickTermAndService.get(0));
				String getURL = clickTermAndService.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				System.out.println("TOS page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "fail";
			// TODO: handle exception
		}
		return status;
	}
	public String checkPrivacyPolicyLink()
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String status = "fail";
		try
		{
			if(clickPrivacyAndPolicy.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickPrivacyAndPolicy.get(0));
				String getURL = clickPrivacyAndPolicy.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				System.out.println("privacy policy page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			status = "fail";
			// TODO: handle exception
		}
		return status;
	}
	public String checkFacebookLink()
	{
		
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickFacebookLink.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickFacebookLink.get(0));
				String getURL = clickFacebookLink.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				System.out.println("fb page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "fail";
			// TODO: handle exception
		}
		return status;
	}
	public String checkGoogleLink()
	{
		
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickGoogleLink.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickGoogleLink.get(0));
				String getURL = clickGoogleLink.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				System.out.println("google page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "fail";
			// TODO: handle exception
		}
		return status;
	}
	public String checkLinkedInLink()
	{
		
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickLinkedInLink.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickLinkedInLink.get(0));
				String getURL = clickLinkedInLink.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				System.out.println("linkedin page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "fail";
			// TODO: handle exception
		}
		return status;
	}
	public String checkMicrosoftLink()
	{
		
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickMicrosoftLink.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickMicrosoftLink.get(0));
				String getURL = clickMicrosoftLink.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				System.out.println("microsoft link page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "fail";
			// TODO: handle exception
		}
		return status;
	}
	public String checkSignUpTab()
	{
		
		String status = "fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if(clickSignUpTab.size()>0)
			{
				js.executeScript("arguments[0].scrollIntoView();", clickSignUpTab.get(0));
				String getURL = clickSignUpTab.get(0).getAttribute("href");
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(getURL);
				System.out.println("signup tab page");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
				status = "pass";
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			status = "fail";
			// TODO: handle exception
		}
		return status;
	}
}
