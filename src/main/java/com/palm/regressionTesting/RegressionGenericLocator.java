package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegressionGenericLocator
{
	
	WebDriver driver;
	WebDriverWait wait;
	URL parentURL;
	String setHost;
	String setLoginURL;
	String setMetaHost;
	String imageHost;
	String courseCode;
	String orderNumber = "";
	String getEnrolledCourseName = "";
	String amountWithTax;
	String amountWithOutTax;
	String checkPaymentProcess;
	String coursePage = "";
	public WebDriver getDriver()
	{
		return driver;
	}
	public RegressionGenericLocator(WebDriver driver)
	{
		this.driver = driver;
	}

	

	public String checkURLStatus(String getURL) {
	    String URLStatus = "failed";
	    HttpURLConnection huc = null;
	    int respCode = 200;
	    try {
	    	URI uri = new URI(getURL);
	    	URL url = uri.toURL();
	        huc = (HttpURLConnection) url.openConnection();
	        huc.setRequestMethod("HEAD");
	        huc.connect();
	        respCode = huc.getResponseCode();
	        System.out.println("status code : " + respCode + " " + getURL);
	        if (respCode == 403) {
	            System.out.println("restricted link : " + getURL);
	            URLStatus = "restricted";
	        } else if (respCode == 502) {
	            System.out.println("temporary issue link : " + getURL);
	            URLStatus = "temporary issue";
	        } else if (respCode > 200) {
	            System.out.println("broken link : " + getURL);
	            System.out.println("response code : " + respCode);
	            URLStatus = "fail" + respCode;
	        } else {
	            System.out.println("unbroken link : " + getURL + " " + respCode);
	            URLStatus = "pass";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        URLStatus = "failed";
	    }
	    return URLStatus;
	}
	public String getCourseCodeText(String code) 
	{
		String CourseCodeStatus = "fail";
		try
		{
			String addHosturl = driver.getCurrentUrl() + code;
			String checkURL = this.checkURLStatus(addHosturl);
			if(checkURL.contains("fail"))
			{
				CourseCodeStatus = "fail";
			}
			else
			{
				CourseCodeStatus = "success";
				driver.switchTo().newWindow(WindowType.TAB);
				driver.get(addHosturl);
				coursePage = driver.getWindowHandle();
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			CourseCodeStatus = "fail";
		}
		return CourseCodeStatus;
	}

	/*
	 * public String navigateProcess() { String navigationStatus = "fail";
	 * JavascriptExecutor js = (JavascriptExecutor) driver; // div[@class='d-flex
	 * try { //
	 * CourseDescription_navigationBar__Zg6b3']//button[contains(text(),'Overview')]
	 * js.executeScript("window.scrollBy(0,800)"); List<WebElement>
	 * navigateFunctions = driver .findElements(By.
	 * cssSelector("div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button"
	 * )); WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
	 * wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy( By.
	 * cssSelector("div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button"
	 * ))); for (int i = 0; i < navigateFunctions.size(); i++) { if (i == 0) {
	 * WebElement overview = driver.findElement(By.cssSelector(
	 * "div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button:nth-child(1)"
	 * )); js.executeScript("arguments[0].scrollIntoView();", overview);
	 * if(overview.isDisplayed()) {
	 * 
	 * js.executeScript("arguments[0].click(), overview"); } Thread.sleep(1000);
	 * System.out.println("Overview is displayed"); navigationStatus = "pass"; }
	 * driver.navigate().refresh(); Thread.sleep(1000); if (i == 1) { WebElement
	 * detailsNavigation = driver.findElement(By.cssSelector(
	 * "div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button:nth-child(2)"
	 * )); js.executeScript("arguments[0].scrollIntoView();", detailsNavigation);
	 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
	 * if(detailsNavigation.isDisplayed()) {
	 * wait.until(ExpectedConditions.elementToBeClickable(detailsNavigation));
	 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(700));
	 * Thread.sleep(1000); js.executeScript("arguments[0].click();",
	 * detailsNavigation); } Thread.sleep(1000);
	 * System.out.println("Details content is displayed"); navigationStatus =
	 * "pass"; } if (i == 2) { WebElement whySkillupNavigation =
	 * driver.findElement(By.cssSelector(
	 * "div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button:nth-child(3)"
	 * )); js.executeScript("arguments[0].scrollIntoView();", whySkillupNavigation);
	 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
	 * if(whySkillupNavigation.isDisplayed()) {
	 * wait.until(ExpectedConditions.elementToBeClickable(whySkillupNavigation));
	 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(700));
	 * Thread.sleep(1000); js.executeScript("arguments[0].click();",
	 * whySkillupNavigation); } Thread.sleep(1000);
	 * System.out.println("WhySkillUpOnline? content is displayed");
	 * navigationStatus = "pass"; } if (i == 3) { WebElement FAQNavigation =
	 * driver.findElement(By.cssSelector(
	 * "div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button:nth-child(4)"
	 * )); js.executeScript("arguments[0].scrollIntoView();", FAQNavigation);
	 * if(FAQNavigation.isDisplayed()) {
	 * wait.until(ExpectedConditions.elementToBeClickable(FAQNavigation)); }
	 * js.executeScript("arguments[0].click();", FAQNavigation); Thread.sleep(1000);
	 * System.out.println("FAQ is displayed"); navigationStatus = "pass"; } } }
	 * catch (Exception e) { e.printStackTrace(); navigationStatus = "fail"; }
	 * return navigationStatus; }
	 */

public String navigateProcess() {
    String navigationStatus = "fail";
    JavascriptExecutor js = (JavascriptExecutor) driver;
    try {
        js.executeScript("window.scrollBy(0,800)");
        List<WebElement> navigateFunctions = driver.findElements(By.cssSelector("div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button")));

        for (int i = 0; i < navigateFunctions.size(); i++) {
            if (i == 0) {
                WebElement overview = driver.findElement(By.cssSelector("div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button:nth-child(1)"));
                js.executeScript("arguments[0].scrollIntoView();", overview);
                if (overview.isDisplayed()) {
                    js.executeScript("arguments[0].click();", overview);
                }
                Thread.sleep(1000);
                System.out.println("Overview is displayed");
                navigationStatus = "pass";
            }
            driver.navigate().refresh();
            Thread.sleep(1000);
            if (i == 1) {
                WebElement detailsNavigation = driver.findElement(By.cssSelector("div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button:nth-child(2)"));
                js.executeScript("arguments[0].scrollIntoView();", detailsNavigation);
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
                if (detailsNavigation.isDisplayed()) {
                    wait.until(ExpectedConditions.elementToBeClickable(detailsNavigation));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(700));
                    Thread.sleep(1000);
                    js.executeScript("arguments[0].click();", detailsNavigation);
                }
                Thread.sleep(1000);
                System.out.println("Details content is displayed");
                navigationStatus = "pass";
            }
            if (i == 2) {
                WebElement whySkillupNavigation = driver.findElement(By.cssSelector("div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button:nth-child(3)"));
                js.executeScript("arguments[0].scrollIntoView();", whySkillupNavigation);
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
                if (whySkillupNavigation.isDisplayed()) {
                    wait.until(ExpectedConditions.elementToBeClickable(whySkillupNavigation));
                    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(700));
                    Thread.sleep(1000);
                    js.executeScript("arguments[0].click();", whySkillupNavigation);
                }
                Thread.sleep(1000);
                System.out.println("WhySkillUpOnline? content is displayed");
                navigationStatus = "pass";
            }
            if (i == 3) {
                WebElement FAQNavigation = driver.findElement(By.cssSelector("div[class='d-flex FixedContentBar_navigationBar__GFCDl'] button:nth-child(4)"));
                js.executeScript("arguments[0].scrollIntoView();", FAQNavigation);
                if (FAQNavigation.isDisplayed()) {
                    wait.until(ExpectedConditions.elementToBeClickable(FAQNavigation));
                    js.executeScript("arguments[0].click();", FAQNavigation);
                }
                Thread.sleep(1000);
                System.out.println("FAQ is displayed");
                navigationStatus = "pass";
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        navigationStatus = "fail";
    }
    return navigationStatus;
}

	public ArrayList<String> freeConsultationProcess(ArrayList<String> getFreeConsultation)
	{
		ArrayList<String> freeConsultationStatus = new ArrayList<String>();
		LinkedHashMap<String, String> kv = new LinkedHashMap<String, String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String key = null, value = null;
			String data = getFreeConsultation.get(1);
			String[] separateData = data.split("-split-");
			for (int i = 0; i < separateData.length; i++)
			{
				System.out.println("data stored in array : " + separateData[i]);
				String[] keyValue = separateData[i].split("=");
				for (int j = 0; j < keyValue.length; j++)
				{

					if (j == 0)
					{
						key = keyValue[j];
					} 
					else if (j == 1)
					{
						value = keyValue[j];
					}
					kv.put(key, value);
				}
			}
			System.out.println(kv);
			System.out.println(kv.get("name"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,400)");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			
			WebElement clickbutton = driver.findElement(By.cssSelector("div[class*='CourseDescription_buttonsContent']>button[class*='CourseDescription_getFreeConsultationBtn']"));
			js.executeScript("arguments[0].scrollIntoView();", clickbutton);
			if(clickbutton.isDisplayed()) 
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
				wait.until(ExpectedConditions.elementToBeClickable(clickbutton));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickbutton);
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				
				WebElement fullName = driver.findElement(By.cssSelector("input[name='fullname']"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='fullname']")));
				wait.until(ExpectedConditions.elementToBeClickable(fullName));
				fullName.clear();
				fullName.sendKeys(kv.get("name"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				
				WebElement email = driver.findElement(
						By.cssSelector("div[class='GetConsultationForm_formContent__Q7Cwa'] input[name='email']"));
				email.clear();
				email.sendKeys(kv.get("mail"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				Select select = new Select(driver.findElement(By.cssSelector("select[name='country']")));
				select.selectByVisibleText(kv.get("country"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				
				WebElement mbl = driver.findElement(By.cssSelector(
						"div[class='GetConsultationForm_formContent__Q7Cwa'] input[name='contactnumber']"));
				mbl.clear();
				mbl.sendKeys(kv.get("mbl"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", mbl);
				
				Select currentStatus = new Select(driver.findElement(By.cssSelector("select[name*='user']")));
				currentStatus.selectByVisibleText(kv.get("status"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				WebElement message = driver.findElement(By.cssSelector("#message"));
				message.clear();
				message.sendKeys(kv.get("msg"));
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				Thread.sleep(1000);
				
				List<WebElement> shareConsultationForm = driver.findElements(By.cssSelector("div[class*='GetConsultationForm_bySharing']>a"));
				
				for (int i = 0; i < shareConsultationForm.size(); i++) 
				{
					WebElement clickConsultation = shareConsultationForm.get(i);
					js.executeScript("arguments[0].scrollIntoView();", clickConsultation);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					Thread.sleep(1000);
					if (clickConsultation.isDisplayed())
					{
						String getURL = clickConsultation.getAttribute("href");
						
					//	js.executeScript("arguments[0].click()", clickConsultation);
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						
						String parentwindow = driver.getWindowHandle();
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(getURL);
						driver.close();
						driver.switchTo().window(parentwindow);
						/*
						 * Set<String> allWindows = driver.getWindowHandles(); for (String handle :
						 * allWindows) { if (!handle.equals(parentwindow)) {
						 * driver.switchTo().window(handle); System.out.println(driver.getCurrentUrl());
						 * if (driver.getCurrentUrl().contains("/privacy/")) {
						 * driver.switchTo().window(handle);
						 * System.out.println("privacy policy window");
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						 * Thread.sleep(1000);
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						 * driver.close();
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						 * driver.switchTo().window(parentwindow);
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); } else if
						 * (driver.getCurrentUrl().contains( "/tos/")) {
						 * driver.switchTo().window(handle); System.out.println("terms of service");
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						 * Thread.sleep(1000);
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						 * driver.close();
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						 * driver.switchTo().window(parentwindow);
						 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); } } }
						 */
					}
				}
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
				WebElement submit = driver.findElement(By.cssSelector("div[class*='GetConsultationForm_ButtonSection'] button[type='submit']"));
				js.executeScript("arguments[0].scrollIntoView();", submit);
				if(submit.isDisplayed())
				{
					js.executeScript("arguments[0].click()", submit);
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
				try 
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					List<WebElement> checkValidation = driver
							.findElements(By.cssSelector("p[class='text-danger mb-0 mt-2']"));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					if(checkValidation.size() > 0) 
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						freeConsultationStatus.add("Fail");
						WebElement closePopUp = driver
								.findElement(By.xpath("(//button[@class='btn-close shadow-none'])[2]"));
						js.executeScript("arguments[0].scrollIntoView();", closePopUp);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						if (closePopUp.isDisplayed()) 
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
							js.executeScript("arguments[0].click()", closePopUp);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						}
					} 
					else 
					{
						WebElement closePopUp = driver
								.findElement(By.xpath("(//button[@class='btn-close shadow-none'])"));//(//button[@class='btn-close shadow-none'])[2]
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						js.executeScript("arguments[0].scrollIntoView();", closePopUp);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						if (closePopUp.isDisplayed()) 
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
							js.executeScript("arguments[0].click()", closePopUp);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
							freeConsultationStatus.add("pass");
						}
					}
				} 
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return freeConsultationStatus;
	}

	public String checkOutRazorpay(String amountFromExcel)
	{
		System.out.println("payment gateway process started");
		String checkRazorpay = "razorpayFail";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try 
		{
		String amountWithTax[] = amountFromExcel.split("=");
		String amt = amountWithTax[1].replaceAll("\\s", "");
		String value = amt.replace(",", "").toString();
		int excelValue = Integer.parseInt(value);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			Set<String> allWindows = driver.getWindowHandles();
			for (String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("/basket/"))
				{
					driver.switchTo().window(window);
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(500));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					try
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						WebElement checkoutAmount = driver.findElement(By.cssSelector("div[class='selected-plan'] span"));
						wait.until(ExpectedConditions.visibilityOf(checkoutAmount));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						if(checkoutAmount.isDisplayed())
						{
							String getCheckoutAmount = checkoutAmount.getText();
							Thread.sleep(1000);
							System.out.println("checkout Razorpay amount from Browser :" + getCheckoutAmount);
							String val[] = getCheckoutAmount.split("\\.");
							String editVal = val[0].replaceAll("[^a-zA-Z0-9]", " ").replaceAll("\\s", "").toString();
							
							int browserValue = Integer.parseInt(editVal);
							
							System.out.println("amountWithGST From Browser in Razorpay : " + browserValue);
							if (browserValue == excelValue) 
							{
								System.out.println("both Razorpay amount and excel amount are same");
								checkRazorpay = "razorpayPass";
							} 
							else 
							{
								System.out.println(" amount with GST from Excel : " + amountWithTax[1]);
								checkRazorpay = "razorpayFail";
							}
							try
							{
								
								js.executeScript("window.scrollBy(0,200)");
								Thread.sleep(400);
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
								WebElement completePayment = driver
										.findElement(By.cssSelector("div[class='payment-buttons']>button[id='razorpay']"));
								wait.until(ExpectedConditions.visibilityOf(completePayment));
								js.executeScript("arguments[0].click()", completePayment);
								checkRazorpay = "razorpayPass";
							}
							catch(Exception e)
							{
								e.printStackTrace();
								checkRazorpay = "razorpayFail";
							}
							
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(700));
						}
						else
						{
							System.out.println("amount not shown in Razorpay screen");
							try
							{
								js.executeScript("window.scrollBy(0,200)");
								Thread.sleep(400);
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
								WebElement completePayment = driver
										.findElement(By.cssSelector("div[class='payment-buttons']>button[id='razorpay']"));
								//completePayment.click();
								wait.until(ExpectedConditions.visibilityOf(completePayment));
								js.executeScript("arguments[0].click()", completePayment);
								checkRazorpay = "razorpayPass";
							}
							catch(Exception e)
							{
								e.printStackTrace();
								checkRazorpay = "razorpayFail";
							}
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(700));
						}
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkRazorpay = "razorpayFail";
		}
		
		return checkRazorpay;
	}

	public String login(String loginCredential) {
		String checkLoginProcess = "false";
		try {
			String[] getData = loginCredential.split("-split-");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			WebElement clickLoginIcon = driver.findElement(By.cssSelector("li#signinlink"));
			if (clickLoginIcon.isDisplayed()) {
				clickLoginIcon.click();
				System.out.println("After clicking login icon : " + driver.getCurrentUrl());
				WebElement enterEmail = driver.findElement(By.cssSelector("input#email"));
				enterEmail.sendKeys(getData[0]);
				WebElement enterPassword = driver.findElement(By.cssSelector("input#password"));
				enterPassword.sendKeys(getData[1]);
				WebElement clickLogin = driver.findElement(By.cssSelector("input#login_in"));
				if (clickLogin.isDisplayed()) {
					clickLogin.click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					checkLoginProcess = "true";
				} else {
					checkLoginProcess = "false";
				}
			} else {
				checkLoginProcess = "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkLoginProcess = "false";
		}
		return checkLoginProcess;
	}

	public ArrayList<String> netBanking(String bankName, String orderAmount)
	{
		ArrayList<String> paymentAndOrderStatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		boolean statusOfbankSelection = false;
		try 
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			if(driver.findElements(By.cssSelector(".razorpay-checkout-frame")).size()>0)
			{
				WebElement iFrame = driver.findElement(By.cssSelector(".razorpay-checkout-frame"));
				wait.until(ExpectedConditions.visibilityOf(iFrame));
				js.executeScript("arguments[0].scrollIntoView();", iFrame);
				
				driver.switchTo().frame(iFrame);
				
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
				//js.executeScript("window.scrollBy(0,100)");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			}
			
			if(driver.findElements(By.xpath("//div[@id='main-stack-container']//label[@class='relative cursor-pointer'][3]")).size()>0)
			{
				
				WebElement label = driver.findElement(By.xpath("//div[@id='main-stack-container']//label[@class='relative cursor-pointer'][3]//div[@data-value='netbanking']"));////label[@class='relative cursor-pointer']//span[@class='truncate font-medium']
				wait.until(ExpectedConditions.visibilityOf(label));
				js.executeScript("arguments[0].scrollIntoView();", label);
				System.out.println(label.getText());
				if(label.isDisplayed())
				{
					 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				        wait1.until(ExpectedConditions.elementToBeClickable(label));
				        js.executeScript("arguments[0].click();", label);
				        System.out.println("netbanking option is clicked");
				        Thread.sleep(1000);
				        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));				
				}
			}
			
				//to select bank
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			if(driver.findElements(By.xpath("//div[@data-main-screen='netbanking']//form[2]//div[@data-value]")).size()>0)
			{
				List<WebElement> chooseBank = driver.findElements(By.xpath("//div[@data-main-screen='netbanking']//form[2]//div[@data-value]"));
				for (int i = 0; i < chooseBank.size(); i++) 
				{
					wait.until(ExpectedConditions.visibilityOf(chooseBank.get(i)));
					js.executeScript("arguments[0].scrollIntoView();", chooseBank.get(i));
					
					System.out.println("net banking name : " + chooseBank.get(i).getAttribute("data-value"));
					String netbankingName = chooseBank.get(i).getAttribute("data-value");
					if(!netbankingName.equalsIgnoreCase(bankName))
					{
                        continue;
					}
					if(netbankingName.contains(bankName))
					{
						System.out.println("bank is selected : "+netbankingName);
						statusOfbankSelection = true;
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
						wait.until(ExpectedConditions.elementToBeClickable(chooseBank.get(i)));
						js.executeScript("arguments[0].click()", chooseBank.get(i));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(370));
						System.out.println("amount paid through netbanking");
						String parentWindow = driver.getWindowHandle();//https://stage-ecomm-in.skillup.online/basket/
						Set<String> nextWindow = driver.getWindowHandles();
						for(String window : nextWindow)
						{
							 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
							 driver.switchTo().window(window);
							 Thread.sleep(1000);
								if(driver.getCurrentUrl().contains("https://api.razorpay.com/"))
								{
									 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
									driver.switchTo().window(window);
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
									WebElement clickSuccess = driver.findElement(By.cssSelector("button[class='success']"));
									wait.until(ExpectedConditions.visibilityOf(clickSuccess));
									js.executeScript("arguments[0].scrollIntoView();", clickSuccess);
									js.executeScript("arguments[0].click()", clickSuccess);
									Thread.sleep(1000);
									driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
									driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(370));
									paymentAndOrderStatus.add("paymentPass");
									System.out.println("success button clicked");
									break;
								}
						}
						driver.switchTo().window(parentWindow);
						System.out.println("parent window : "+driver.getCurrentUrl());
						if(driver.findElements(By.xpath("//h4[contains(text(),'Payment successful. You are now enrolled!')]")).size()>0)
						{
							System.out.println("order details window");
							Thread.sleep(1000);
						}
						paymentAndOrderStatus.add(this.indiaOrderDetails(orderAmount));
						break;
					}
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			checkPaymentProcess = "fail";
			System.out.println("netbanking is fail");
			paymentAndOrderStatus.add("paymentFail");
		}
		return paymentAndOrderStatus;
	}

	public String diffBank(String bank)
	{
		try
		{
			WebElement selectBank = driver.findElement(By.cssSelector("button#bank-select"));
			selectBank.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(170));
			List<WebElement> enterBank = driver.findElements(By.cssSelector("div[id='netbanking_bank_select_search_results'] div[class='list svelte-15q0kle'] img[alt]"));
			for(int i = 0; i < enterBank.size(); i++) 
			{
				if(enterBank.get(i).getAttribute("alt").equalsIgnoreCase(bank))
				{
					System.out.println("bank name is : " + enterBank.get(i).getAttribute("alt"));
					enterBank.get(i).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(370));
					WebElement clickPayNow = driver.findElement(By.cssSelector("button[id*='redesign']"));
					clickPayNow.click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(370));
					break;
				} 
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			checkPaymentProcess = "fail";
			System.out.println("problem in diffBank selection in the netbanking ");
		}
		return bank;
	}

	public String moreBank(String bank)
	{
		try
		{
			WebElement clickMoreBank = driver.findElement(By.cssSelector("div[class='emi-bank-item'] div[class*='more-bank-icon']"));
			clickMoreBank.click();
			List<WebElement> bankName = driver.findElements(By.cssSelector("div[id='emi_bank_select_search_results'] div[id*='emi_bank'] div[class*='search-bank-name']"));
			for (int i = 0; i < bankName.size(); i++)
			{
				if (bankName.get(i).getText().contains(bank))
				{
					System.out.println("bank name is : " + bankName.get(i).getText());
					bankName.get(i).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					break;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bank;
	}

	public String card()
    {
		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			WebElement iFrame = driver.findElement(By.cssSelector(".razorpay-checkout-frame"));
			driver.switchTo().frame(iFrame);
			List<WebElement> buttons = driver.findElements(By.cssSelector(".border-list button"));
			for (WebElement button : buttons) {
				WebElement label = button.findElement(By.cssSelector("div.title > div"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println(label.getText());
				if (label.getText().equalsIgnoreCase("Pay using Card")) {
					System.out.println("card name is : " + label.getText());
					label.click();
					if (driver.findElement(By.cssSelector("button#otp-sec")).isDisplayed()) {
						WebElement skipOTP = driver.findElement(By.cssSelector("button#otp-sec"));
						skipOTP.click();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						WebElement cardNumber = driver.findElement(By.cssSelector("input#card_number"));
						cardNumber.sendKeys("5267 3181 8797 5449");
						WebElement cardExpiry = driver.findElement(By.cssSelector("input#card_expiry"));
						cardExpiry.sendKeys("12/22");
						WebElement cardName = driver.findElement(By.cssSelector("input#card_name"));
						cardName.sendKeys("testing");
						WebElement cvv = driver.findElement(By.cssSelector("input#card_cvv"));
						cvv.sendKeys("234");
						WebElement payNowButton = driver
								.findElement(By.cssSelector("form#form button[id='redesign-v15-cta']"));
						payNowButton.click();
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(270));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(370));
						System.out.println("pay now button clicked");
						WebElement payWOSavingCard = driver.findElement(By.cssSelector("button#redesign-v15-cta"));
						payWOSavingCard.click();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(470));
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
						checkPaymentProcess = "cardPass";
					} else {
						WebElement cardNumber = driver.findElement(By.cssSelector("input#card_number"));
						cardNumber.sendKeys("5267 3181 8797 5449");
						WebElement cardExpiry = driver.findElement(By.cssSelector("input#card_expiry"));
						cardExpiry.sendKeys("12/23");
						WebElement cardName = driver.findElement(By.cssSelector("input#card_name"));
						cardName.sendKeys("testing");
						WebElement cvv = driver.findElement(By.cssSelector("input#card_cvv"));
						cvv.sendKeys("234");
						WebElement payNowButton = driver.findElement(By.cssSelector("button#redesign-v15-cta"));
						payNowButton.click();
						System.out.println("Pay now button is clicked");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(470));
						checkPaymentProcess = "cardPass";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkPaymentProcess = "cardFail";
			System.out.println("card payment is fail");
		}

		return checkPaymentProcess;
	}

	public String indiaOrderDetails(String priceWOGSTFromExcel)
	{
		String checkOrderDetails = "orderDetailFail";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		try {
			int digit = Integer.parseInt(priceWOGSTFromExcel.replace(",", "").toString());
			  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(570));
			  System.out.println("checkout page");
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
			
			  WebElement getOrderDetails = driver.findElement(By.cssSelector("table[class=' spacing-pl8 spacing-pr8 spacing-pl20 spacing-pr20 mb table_border'] tr td"));
			  
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
				Thread.sleep(1000);
			  System.out.println("order details : " + getOrderDetails.getText());
			  String amountOrderDetails = driver.findElement(By.cssSelector("table[class=' spacing-pl8 spacing-pr8 spacing-pl20 spacing-pr20 mb table_border'] tr[class='first_3_rows'] td[class='row_text spacing-pr20 spacing-pl20  spacing-pb8 spacing-pt8  table_border_bottom text_table']"))
					.getText().replace(",", "");
			  double n = Double.parseDouble(amountOrderDetails);
			  int v = (int) n;
			  System.out.println("amount order details : " + amountOrderDetails.toString());
			 
			  WebElement getOrderNumber = driver.findElement(By.cssSelector("div[class*='order_info']:nth-child(2) div:nth-child(3) h4"));
			  wait.until(ExpectedConditions.visibilityOf(getOrderNumber));
			  orderNumber = getOrderNumber.getText();
			  System.out.println("OrderNumber: " + orderNumber);
			  
			  WebElement nameOfcourse = driver.findElement(By.cssSelector("table[class=' spacing-pl8 spacing-pr8 spacing-pl20 spacing-pr20 mb table_border'] tr td>p"));
			  wait.until(ExpectedConditions.visibilityOf(nameOfcourse));
			  getEnrolledCourseName = nameOfcourse.getText();
			  System.out.println("Enrolled course name : "+getEnrolledCourseName);
			  if(digit == v)
			  {
				checkOrderDetails = "orderDetailPass";
				System.out.println("both price without GST from excel and ordered amount values are same : " + amountOrderDetails);
			  } 
			  else 
			  {
				checkOrderDetails = "orderDetailFail";
			  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			checkOrderDetails = "orderDetailFail";
		}
		return checkOrderDetails;
	}

	public void USOrderDetails() {
		try {
			Set<String> windows = driver.getWindowHandles();
			for (String win : windows) {
				driver.switchTo().window(win);
				System.out.println(driver.getCurrentUrl());
				System.out.println("checkout page");
				WebElement clickDashBoard = driver
						.findElement(By.xpath("//a[contains(text(),'Continue to your Dashboard')]"));
				clickDashBoard.click();
				WebElement getOrderDetails = driver.findElement(By.cssSelector(
						"table[class=' spacing-pl8 spacing-pr8 spacing-pl20 spacing-pr20 mb table_border'] tr td"));
				System.out.println(getOrderDetails.getText());
				String amountOrderDetails = driver.findElement(By.cssSelector(
						"table[class=' spacing-pl8 spacing-pr8 spacing-pl20 spacing-pr20 mb table_border'] tr td[class='spacing-pl8 spacing-pr20 spacing-pl20  spacing-pt8 table_lastrow last_prize table_border_bottom text_table']"))
						.getText();
				System.out.println(amountOrderDetails);
				if (amountWithTax.equalsIgnoreCase(amountOrderDetails)) {
					System.out.println("both are same amount ");
				} else {
					errorCells.add(5);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String wallet() {
		try {
			WebElement iFrame = driver.findElement(By.cssSelector(".razorpay-checkout-frame"));
			driver.switchTo().frame(iFrame);
			List<WebElement> buttons = driver.findElements(By.cssSelector(".border-list button"));
			for (WebElement button : buttons) {
				WebElement label = button.findElement(By.cssSelector("div.title > div"));
				System.out.println(label.getText());
				if (label.getText().equalsIgnoreCase("Pay using Wallet")) {
					label.click();
					WebElement phonePe = driver.findElement(By.cssSelector("div#wallet-radio-phonepe"));
					phonePe.click();
					WebElement payNowButton = driver.findElement(By.cssSelector("button#redesign-v15-cta"));
					payNowButton.click();
					checkPaymentProcess = "true";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkPaymentProcess = "false";
		}
		return checkPaymentProcess;
	}

	public String emi(String bankName) {
		String getData[] = bankName.split("_");
		try {
			WebElement iFrame = driver.findElement(By.cssSelector(".razorpay-checkout-frame"));
			driver.switchTo().frame(iFrame);
			List<WebElement> buttons = driver.findElements(By.cssSelector(".border-list button"));
			for (WebElement button : buttons) {
				WebElement label = button.findElement(By.cssSelector("div.title > div"));
				System.out.println(label.getText());
				if (label.getText().equalsIgnoreCase("Pay using EMI")) {
					label.click();
					List<WebElement> clickEMIBank = driver.findElements(By.cssSelector("div[id*='bank-item']"));
					for (int i = 0; i < clickEMIBank.size(); i++) {
						if (clickEMIBank.get(i).getText().contains(getData[0])) {
							clickEMIBank.get(i).click();
							WebElement clickContinue = driver.findElement(By.cssSelector("button#redesign-v15-cta"));
							clickContinue.click();
							checkPaymentProcess = "pass";
							break;
						}
					}
					if (checkPaymentProcess != "pass") {
						this.moreBank(getData[0]);
					}
					List<WebElement> selectEMIPlan = driver
							.findElements(By.cssSelector("div[class='plan-amount svelte-1ooipi6']"));
					for (int j = 0; j < selectEMIPlan.size(); j++)
					{
						selectEMIPlan.get(j).click();
						break;
					}

					WebElement selectPlanButton = driver.findElement(By.cssSelector("button#redesign-v15-cta"));
					selectPlanButton.click();
					WebElement enterCardNumber = driver.findElement(By.cssSelector(
							"div#container div[tab='emi'] div[id='root'] div[id='add-card-container'] input#card_number"));
					enterCardNumber.sendKeys("5241 8100 0000 0000");
					WebElement enterExpiry = driver.findElement(By.cssSelector(
							"div#container div[tab='emi'] div[id='root'] div[id='add-card-container'] input#card_expiry"));
					enterExpiry.sendKeys("12/23");
					WebElement enterCardName = driver.findElement(By.cssSelector(
							"div#container div[tab='emi'] div[id='root'] div[id='add-card-container'] input#card_name"));
					enterCardName.sendKeys("hemamalini-murugesan");
					WebElement enterCVV = driver.findElement(By.cssSelector(
							"div#container div[tab='emi'] div[id='root'] div[id='add-card-container'] input#card_cvv"));
					enterCVV.sendKeys("234");
					WebElement payViaEMI = driver.findElement(By.cssSelector("button#redesign-v15-cta"));
					payViaEMI.click();
					WebElement clickContinue = driver.findElement(By.cssSelector("button#redesign-v15-cta"));
					clickContinue.click();
					checkPaymentProcess = "pass";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkPaymentProcess = "fail";
			System.out.println("problem in emi process");
		}
		return checkPaymentProcess;
	}

	public String upi() {
		try {
			WebElement iFrame = driver.findElement(By.cssSelector(".razorpay-checkout-frame"));
			driver.switchTo().frame(iFrame);
			List<WebElement> buttons = driver.findElements(By.cssSelector(".border-list button"));
			for (WebElement button : buttons) {
				WebElement label = button.findElement(By.cssSelector("div.title > div"));
				System.out.println(label.getText());
				if (label.getText().equalsIgnoreCase("Pay using UPI")) {
					label.click();
					WebElement clickUPITab = driver.findElement(By.cssSelector("div#new-vpa-field-upi"));
					clickUPITab.click();
					WebElement upiID = driver.findElement(By.cssSelector("input#vpa-upi"));
					upiID.sendKeys("success@razorpay");
					WebElement payNow = driver.findElement(By.cssSelector("button#redesign-v15-cta"));
					payNow.click();
					checkPaymentProcess = "pass";
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
						checkPaymentProcess = "fail";
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkPaymentProcess = "fail";
			System.out.println("UPI payment fail");
		}
		return checkPaymentProcess;
	}

	public ArrayList<String> indiaPaymentProcess(String paymentModeFromExcel, String orderDetailsInfo)
	{
		ArrayList<String> getPaymentStatusFromIndia = new ArrayList<String>();
		String getData[] = paymentModeFromExcel.split("_");
		String getOrderAmount[] = orderDetailsInfo.split("=");
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String window : allWindows) {
				driver.switchTo().window(window);
				if (driver.getCurrentUrl().contains("basket"))
				{
					driver.switchTo().window(window);
					switch (getData[0]) {
					case "card":
						getPaymentStatusFromIndia.add(card());
						break;
					case "netBanking":
						getPaymentStatusFromIndia.addAll(netBanking(getData[1], getOrderAmount[1]));
						break;
					case "wallet":
						wallet();
						break;
					case "upi":
						upi();
						break;
					case "emi":
						emi(getData[1]);
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getPaymentStatusFromIndia.add("fail");
		}
		return getPaymentStatusFromIndia;
	}

	ArrayList<Integer> errorCells;
	boolean checkEnrollStatus;

	public String loginProcess(String getData)
	{
		String status = "loginFail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		try
		{
			String[] splitData = getData.split("-split-", 2);
			String parentWindow1 = driver.getWindowHandle();
			Set<String> allWindows1 = driver.getWindowHandles();
			for (String window1 : allWindows1) 
			{
				driver.switchTo().window(window1);
				if (driver.getCurrentUrl().contains("login?")) 
				{
					driver.switchTo().window(window1);
					status = "loginPass";
					Thread.sleep(1000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					WebElement email = driver.findElement(By.cssSelector("input#email"));
					wait.until(ExpectedConditions.visibilityOf(email));
					js.executeScript("arguments[0].scrollIntoView()", email);
					if(email.isDisplayed())
					{
						
						email.sendKeys(splitData[0]);
					}
					WebElement pwd = driver.findElement(By.cssSelector("input#password"));
					wait.until(ExpectedConditions.visibilityOf(pwd));
					js.executeScript("arguments[0].scrollIntoView()", pwd);
					if(pwd.isDisplayed())
					{
						
						pwd.sendKeys(splitData[1]);
					}
					WebElement loginButton = driver.findElement(By.cssSelector("input#login_in"));
					wait.until(ExpectedConditions.visibilityOf(loginButton));
					js.executeScript("arguments[0].scrollIntoView()", loginButton);
					if(loginButton.isDisplayed())
					{

						js.executeScript("arguments[0].click()", loginButton);
						Thread.sleep(1000);
					}
					Thread.sleep(1000);
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(400));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
				}
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
			status = "loginFail";
		}
		return status;
	}

	public String choosePlan(String plan)
	{
		String getPlan[] = plan.split("=");
		String checkPlanStatus = "choosePlanFail";
		boolean checkProcess = false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(!plan.contains("No"))
		{
			try {
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				String parentWindow2 = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for (String windows : allWindows)
				{
					driver.switchTo().window(windows);
					js.executeScript("window.scrollBy(0,300)");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					if (driver.getCurrentUrl().contains("choose-subscription"))
					{
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						List<WebElement> listOfPlan = driver.findElements(By.cssSelector("div[id='custom-plans1'] div[class*='owl-item']"));// div[class=\"bttn\"]
						for (int i = 0; i < listOfPlan.size(); i++)
						{
							wait.until(ExpectedConditions.visibilityOf(listOfPlan.get(i)));
							js.executeScript("arguments[0].scrollIntoView()", listOfPlan.get(i));																						// a
							WebElement selectPlan = listOfPlan.get(i)
									.findElement(By.cssSelector(" div[class*='plan_heading']"));
							wait.until(ExpectedConditions.visibilityOf(selectPlan));
							js.executeScript("arguments[0].scrollIntoView()", selectPlan);
							if(selectPlan.isDisplayed())
							{
								String getPlanText = selectPlan.getText();
								
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
							
								if (getPlanText.contains(getPlan[0]))
								{
									System.out.println("Plan is : " + getPlanText);
									WebElement clickPlan = listOfPlan.get(i)
											.findElement(By.cssSelector(" div[class='bttn'] a"));
									wait.until(ExpectedConditions.visibilityOf(clickPlan));
									if (clickPlan.isDisplayed())
									{
										js.executeScript("arguments[0].click()", clickPlan);
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(400));
										driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(800));
										checkPlanStatus = "choosePlanPass";
										checkProcess = true;
										break;
									} 
									else
									{
										if (listOfPlan.get(i).findElement(By.cssSelector(" button[disabled]")).isDisplayed())
										{
											System.out.println("button is disabled");
											checkPlanStatus = "choosePlanFail";
											break;
										}
									}
								}
							}
						}
						if(checkProcess != false)
						{
							checkPlanStatus = "choosePlanPass";
							break;
						}
					}
					driver.switchTo().window(parentWindow2);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				checkPlanStatus= "choosePlanFail";
			}
		}
		else
		{
			System.out.println("no plan is available");
			checkPlanStatus = "choosePlanPass";
		}

		return checkPlanStatus;
	}

	public String loginForEnrollment(String getData)
	{
	String checkLogin = "";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	try
	{
		String[] splitData = getData.split("-split-", 2);
		WebElement email = driver.findElement(By.cssSelector("input#email"));
		wait.until(ExpectedConditions.visibilityOf(email));
		js.executeScript("arguments[0].scrollIntoView()", email);
		if(email.isDisplayed())
		{
			
			email.sendKeys(splitData[0]);
		}
		WebElement pwd = driver.findElement(By.cssSelector("input#password"));
		wait.until(ExpectedConditions.visibilityOf(pwd));
		js.executeScript("arguments[0].scrollIntoView()", pwd);
		if(pwd.isDisplayed())
		{
			
			pwd.sendKeys(splitData[1]);
		}
		WebElement loginButton = driver.findElement(By.cssSelector("input#login_in"));
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		js.executeScript("arguments[0].scrollIntoView()", loginButton);
		if(loginButton.isDisplayed())
		{

			js.executeScript("arguments[0].click()", loginButton);
			Thread.sleep(1000);
			checkLogin = "pass";
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		checkLogin = "fail";
	}
	return amountWithOutTax;
}
	
	public ArrayList<String> enroll(ArrayList<String> enrollDataFromExcel)
	{
		ArrayList<String> statusOfProcess = new ArrayList<String>();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try 
		{
			js.executeScript("window.scrollBy(0,200)");
			String getCurrentURL = driver.getCurrentUrl();
			if(getCurrentURL.contains("in"))// india site
			{
				WebElement checkEnrollButton = driver.findElement(By.cssSelector("button[class*='CourseDescription_enrollNowBtn']"));
				wait.until(ExpectedConditions.visibilityOf(checkEnrollButton));
				js.executeScript("arguments[0].scrollIntoView()", checkEnrollButton);
				
				String enrollButtonURL = checkEnrollButton.getAttribute("href");
				if(checkEnrollButton.isDisplayed())
				{
					if(checkEnrollButton.getText().equalsIgnoreCase("Enroll Now"))
					{
						System.out.println("Enroll Button is displayed");
						Thread.sleep(1000);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						wait.until(ExpectedConditions.elementToBeClickable(checkEnrollButton));
						
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(enrollButtonURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						
					}
				}
				
				
				statusOfProcess.add(this.loginProcess(enrollDataFromExcel.get(1)));
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				statusOfProcess.add(this.choosePlan(enrollDataFromExcel.get(2)));
				Thread.sleep(500);
				statusOfProcess.add(this.checkOutRazorpay(enrollDataFromExcel.get(3)));
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				statusOfProcess.addAll(this.indiaPaymentProcess(enrollDataFromExcel.get(4), enrollDataFromExcel.get(5)));
				Thread.sleep(1000);
				Thread.sleep(100);	
			}
			else
			{
				System.out.println("US Enroll Process");
			}
			
			driver.close();
			driver.switchTo().window(coursePage);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			statusOfProcess.add("fail");
		}
		return statusOfProcess;
	}

	public ArrayList<String> skillupOnlineLocator(ArrayList<String> skillupOnlineFromExcel)
	{
		String checkSkillupOnlineText = "";
		ArrayList<String> status = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1300)");
		try
		{
			for (int i = 1; i < skillupOnlineFromExcel.size(); i++)
			{
				if (i == 1) 
				{
					WebElement navigationButton = driver
							.findElement(By.cssSelector("div#whySkillUp h2[class*='_titleText']"));
					js.executeScript("arguments[0].scrollIntoView();", navigationButton);
					String question = navigationButton.getText().replaceAll("\\s", "").replaceAll("\u00A0", "")
							.replaceAll("[^\\p{ASCII}]", "");
					if (question.equals(skillupOnlineFromExcel.get(i).replaceAll("\\s", "").replaceAll("\u00A0", "")
							.replaceAll("[^\\p{ASCII}]", ""))) {
						System.out.println("Why skill up from Browser : " + question);
						System.out.println("question is same");
						checkSkillupOnlineText = "pass";
					} else {
						System.out.println("question is not same");
						checkSkillupOnlineText = "fail";
					}
					status.add(checkSkillupOnlineText);
				} 
				else if (i == 2) 
				{
					WebElement answer = driver.findElement(By.cssSelector(
							"section[class='WhyLearnSkillUp_mainSection__pNbU3'] div[class='WhyLearnSkillUp_mainContent__x3c7x']:not([class='WhyLearnSkillUp_titleText__N8j59'])"));
					js.executeScript("window.scrollBy(0,100)");
					String removeText = "Why Learn with SkillUp Online?";
					String answerText = answer.getText().replaceAll("[^a-zA-Z0-9]", " ").replaceAll(removeText, "")
							.replaceAll("\\s", "").replaceAll("\u00A0", "").replaceAll("[^\\p{ASCII}]", "");
					System.out.println(answerText);
					if (answerText.equals(skillupOnlineFromExcel.get(i).replaceAll("[^a-zA-Z0-9]", " ")
							.replaceAll("\\s", "").replaceAll("\u00A0", "").replaceAll("[^\\p{ASCII}]", ""))) {
						System.out.println("answer is same");
						checkSkillupOnlineText = "pass";
					} else {
						System.out.println("answer is not same");
						checkSkillupOnlineText = "fail";
					}
					status.add(checkSkillupOnlineText);
				}
			}
			List<WebElement> listOfImages = driver.findElements(
					By.cssSelector("div[class='WhyLearnSkillUp_profitPointsSection__YTA82'] img[alt='icon']"));
			if (listOfImages.size() == 4) {
				System.out.println("image icons are available");
			} else {
				System.out.println("image icon is not available");
			}
			WebElement fontColor = driver
					.findElement(By.cssSelector("div[class='WhyLearnSkillUp_profitPointsSection__YTA82'] h2"));
			String color = fontColor.getCssValue("color");
			String str = Color.fromString(color).asHex();
			if (str.equals("#8f191f")) {
				System.out.println("Dark red color");
			} else {
				System.out.println("invalid color");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public String shareLocator(String shareFromExcel)
	{
		String checkShareProcess ="";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		try
		{
			js.executeScript("window.scrollBy(0,-2000)", "");
			WebElement clickShareLink = driver.findElement(By.cssSelector("button[class*='CourseDescription_shareBtn']"));
			wait.until(ExpectedConditions.elementToBeClickable(clickShareLink));
			js.executeScript("arguments[0].scrollIntoView();", clickShareLink);
			if (clickShareLink.isDisplayed()) 
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				js.executeScript("arguments[0].click()", clickShareLink);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			}
			
			WebElement copyLink = driver.findElement(By.cssSelector("button[class*='btn shadow-none shareSocialMedia_copyButton']"));
			js.executeScript("arguments[0].scrollIntoView();", copyLink);
			if(copyLink.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickShareLink);
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			List<WebElement> share = driver.findElements(By.cssSelector("div[class*='shareSocialMedia_sociallist'] a[class*='shareSocialMedia_socialIcon']"));
			for (int i = 0; i < share.size(); i++)
			{
				WebElement shareLink = share.get(i);
				js.executeScript("arguments[0].scrollIntoView();", shareLink);
				
				if(shareLink.isDisplayed())
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
					String getShareURL = shareLink.getAttribute("href");
					System.out.println("Share URL is : " + getShareURL);
					if(getShareURL.contains("mailto:?"))
					{
						System.out.println("microsoft mail");
					}
					else if(getShareURL.contains("whatsapp://send"))
                    {
                        System.out.println("whatsapp");
                        driver.switchTo().newWindow(WindowType.TAB);
                        driver.get(getShareURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
						driver.close();
						driver.switchTo().window(coursePage);
						
                    }
                    else if(getShareURL.contains("twitter"))
					{
                    	 System.out.println("whatsapp");
                         driver.switchTo().newWindow(WindowType.TAB);
                         driver.get(getShareURL);
 						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
 						driver.close();
 						driver.switchTo().window(coursePage);
					}
                    else if(getShareURL.contains("twitter"))
                    {
                    	 System.out.println("whatsapp");
                         driver.switchTo().newWindow(WindowType.TAB);
                         driver.get(getShareURL);
 						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
 						driver.close();
 						driver.switchTo().window(coursePage);
                    }
                    else if(getShareURL.contains("linkedin"))
                    {
	                	 System.out.println("whatsapp");
	                     driver.switchTo().newWindow(WindowType.TAB);
	                     driver.get(getShareURL);
 						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
 						driver.close();
 						driver.switchTo().window(coursePage);
                    }
                    else if(getShareURL.contains("facebook"))
                    {
                    	 System.out.println("whatsapp");
	                     driver.switchTo().newWindow(WindowType.TAB);
	                     driver.get(getShareURL);
 						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
 						driver.close();
 						driver.switchTo().window(coursePage);
                    }
						
					}
				}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			checkShareProcess="fail";
		}
		return checkShareProcess;
	}

	public String downloadLocator(String downloadFromExcel) {
		String checkDownloadProcess = "";
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checkDownloadProcess;
	}

	public ArrayList<String> programLocator(ArrayList<String> programFromExcel) {
		ArrayList<String> checkProgramProcess = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try 
		{
			// js.executeScript("window.scrollBy(0,-150)");
			String programText = driver
					.findElement(By.cssSelector("div[class='CourseDescription_infoBoxText__w49c3'] a[href]"))
					.getAttribute("href");
			if (!programText.isEmpty() || programText.isBlank())
			{
				WebElement programLocator = driver
						.findElement(By.cssSelector("div[class='CourseDescription_infoBoxText__w49c3'] a"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
				if (programLocator.isDisplayed())
				{
					Thread.sleep(400);
					wait.until(ExpectedConditions.elementToBeClickable(
							By.cssSelector("div[class='CourseDescription_infoBoxText__w49c3'] a")));
					// jse2.executeScript("arguments[0].scrollIntoView()", programLocator);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", programLocator);
					String parentWindow = driver.getWindowHandle();
					Set<String> nextWindow = driver.getWindowHandles();
					for (String handle : nextWindow)
					{
						driver.switchTo().window(handle);
						if (driver.getCurrentUrl().contains(programText))
						{
							driver.switchTo().window(handle);
							System.out.println("Program window");
							checkProgramProcess.add("pass");
							break;
						}
					}
					driver.close();
					driver.switchTo().window(parentWindow);
				}
			}
			else 
			{
				System.out.println("program is not available");
				checkProgramProcess.add("fail");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			checkProgramProcess.add("fail");
		}
		return checkProgramProcess;
	}

	public String validationProcess()
	{
		String status = "fail";
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			List<WebElement> errorMsg = driver
					.findElements(By.cssSelector("div[class*='Footer_FootFormInR'] span[class*='commonFormFields_errorMessage']"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			if (errorMsg.size() > 0)
			{
				System.out.println("validation message shown");
				status = "fail";
			} 
			else
			{
				System.out.println("no validation message is displayed");
				status = "pass";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}

	public ArrayList<String> subscribeLocator(ArrayList<String> subscribeFromExcel)
	{
		ArrayList<String> checkSubscribeProcess = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			String getValue = subscribeFromExcel.get(1);
			String splitDetails[] = getValue.split("-split-");
			String key = splitDetails[0];
			System.out.println(key);
			String value = splitDetails[1];
			System.out.println(value);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			
			WebElement fullName = driver.findElement(By.cssSelector("form[class*='NewsAndUpdates_formSection'] input[placeholder='Full Name']"));
			js.executeScript("arguments[0].scrollIntoView();", fullName);
			if (fullName.isDisplayed())
			{
				System.out.println("Full Name is displayed");
				fullName.clear();
				fullName.sendKeys(key);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			checkSubscribeProcess.add(this.validationProcess());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			WebElement email = driver.findElement(By.cssSelector("form[class*='NewsAndUpdates_formSection'] input[placeholder='Email']"));
			js.executeScript("arguments[0].scrollIntoView();", email);
			if (fullName.isDisplayed())
			{
				System.out.println("email is displayed");
				email.clear();
				email.sendKeys(value);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			checkSubscribeProcess.add(this.validationProcess());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
			WebElement clickSubscribe = driver.findElement(By.cssSelector("form[class*='NewsAndUpdates_formSection'] button"));
			js.executeScript("arguments[0].scrollIntoView();", clickSubscribe);
			if (clickSubscribe.isDisplayed())
			{
				try 
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
					js.executeScript("arguments[0].scrollIntoView()", clickSubscribe);
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
					wait.until(ExpectedConditions.elementToBeClickable(clickSubscribe));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickSubscribe);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				} 
				catch (Exception e)
				{
					e.printStackTrace();
					checkSubscribeProcess.add("fail");
				}
				List<WebElement> checkValidationLocator = driver.findElements(By.cssSelector("p[class='mt-2  NewsAndUpdates_inputMessage___Y1G_ mt-1']"));
				if (checkValidationLocator.size() > 0)
				{
					System.out.println("validation message shown");
					checkSubscribeProcess.add("fail");
				} 
				else
				{
					checkSubscribeProcess.add("pass");
				}
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return checkSubscribeProcess;
	}
	
	public ArrayList<String> programLocator()
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			String getInitialsOnDropDown = driver.findElement(By.cssSelector("li[class='SigNUP'] span[class='NOLoginDSKTXT']")).getText();
			System.out.println("Initial on DropDown : "+getInitialsOnDropDown);
			WebElement clickDropdownIcon = driver.findElement(By.cssSelector("li[class='SigNUP']>a"));
			if(clickDropdownIcon.isDisplayed())
			{
				clickDropdownIcon.click();
				status.add("pass");
			}
			
			WebElement clickDashboard = driver.findElement(By.cssSelector("ul[class*='dropdown-menu Primary']>li:nth-child(2)>a"));
			if(clickDashboard.isDisplayed())
			{
				clickDashboard.click();
				
				String parentWindow = driver.getWindowHandle();
				Set<String> windows = driver.getWindowHandles();
				for(String window : windows)
				{
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("dashboard"))
					{
						driver.switchTo().window(window);
						System.out.println("dashboard page");
						status.add("pass");
					}
				}
			}
			
			WebElement clickDropdownIcon2 = driver.findElement(By.cssSelector("li[class*='Header_SigNUP'] img[alt='icon']"));
			if(clickDropdownIcon2.isDisplayed())
			{
				clickDropdownIcon2.click();
				status.add("pass");
			}
			
			
			WebElement clickProfile = driver.findElement(By.cssSelector("ul[class*='dropdown-menu']>li:nth-child(3)>a"));
			if(clickProfile.isDisplayed())
			{
				clickProfile.click();
				
				String parentWindow = driver.getWindowHandle();
				Set<String> windows = driver.getWindowHandles();
				for(String window : windows)
				{
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("/u/"))
					{
						driver.switchTo().window(window);
						System.out.println("profile page");
						status.add("pass");
					}
				}
			}
			
			WebElement clickDropdownIcon3 = driver.findElement(By.cssSelector("li[class='SigNUP'] img[class='dPaRoW']"));
			if(clickDropdownIcon3.isDisplayed())
			{
				clickDropdownIcon3.click();
				status.add("pass");
			}
			
			WebElement clickAccount = driver.findElement(By.cssSelector("ul[class*='dropdown-menu Primary']>li:nth-child(4)>a"));
			if(clickAccount.isDisplayed())
			{
				clickAccount.click();
				
				String parentWindow = driver.getWindowHandle();
				Set<String> windows = driver.getWindowHandles();
				for(String window : windows)
				{
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("settings"))
					{
						driver.switchTo().window(window);
						System.out.println("dashboard page");
						status.add("pass");
					}
				}
			}
			WebElement clickDropdownIcon4 = driver.findElement(By.cssSelector("li[class*='SigNUP'] img[class='dPaRoW']"));
			if(clickDropdownIcon4.isDisplayed())
			{
				clickDropdownIcon4.click();
				status.add("pass");
			}
			Thread.sleep(2000);
			WebElement clickSignOut = driver.findElement(By.cssSelector("ul[class*='dropdown-menu Primary02_Blue'] li:nth-child(5) a"));
			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			if(clickSignOut.isDisplayed())
			{
				js3.executeScript("arguments[0].click()", clickSignOut);
				status.add("pass");
			}
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status.add("Fail");
		}
		return status;
	}
}
