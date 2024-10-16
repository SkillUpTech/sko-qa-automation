package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpLocator
{
	String url ;
	WebDriver driver;
	
	public SignUpLocator(WebDriver driver)
	{
		this.driver = driver;
	}
	public String signUpPage() throws InterruptedException
	{
		String status = "FAIL";
		try
		{
			WebElement clickSignUp = driver.findElement(By.cssSelector("ul[class*='list-unstyled navbar-nav nav Header_navButtons__3h4Rp'] li:nth-child(3) a"));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			String n = Keys.chord(Keys.CONTROL, Keys.ENTER);
			clickSignUp.sendKeys(n);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			status = "PASS";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "FAIL";
		}
		return status;
	}
	
	public String verifySignUPFreeButton()
	{
		String status = "FAIL";
		try
		{
			status = this.signUpPage();
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("register"))
				{
					driver.switchTo().window(window);
					System.out.println("sign up page");
					driver.close();
					break;
				}
			}
			driver.switchTo().window(parentWindow);//home page
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public ArrayList<String> verifySpaceOnMail(ArrayList<String> data)
	{
		ArrayList<String> getSignupStatus = new ArrayList<String>();
		ArrayList<String> statusOfTestCase = new ArrayList<String>();
		try
		{
			System.out.println("space on mail validation started");
			statusOfTestCase.add(this.signUpPage());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			Thread.sleep(1000);
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("register"))
				{
					System.out.println("sign up page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					getSignupStatus.addAll(this.signUpFunction(data));
					if(getSignupStatus.contains("validation message in full name "))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("no validation message for full name"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("No validation message"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("exception"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("email"))
					{
						statusOfTestCase.add("PASS");
					}
					else if(getSignupStatus.contains("password"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("country"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("mobile"))
					{
						statusOfTestCase.add("FAIL");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					System.out.println("space on mail Validation process done");
					driver.close();
					break;
				}
			}
			driver.switchTo().window(parentWindow);//homepage
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add("FAIL");
		}
		return statusOfTestCase;
	}
	public ArrayList<String> verifySpaceOnFullname(ArrayList<String> data)
	{

		ArrayList<String> getSignupStatus = new ArrayList<String>();
		ArrayList<String> statusOfTestCase = new ArrayList<String>();
		try
		{
			System.out.println("space on Full Name validation started");
			statusOfTestCase.add(this.signUpPage());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			Thread.sleep(1000);
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("register"))
				{
					System.out.println("sign up page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					getSignupStatus.addAll(this.signUpFunction(data));
					if(getSignupStatus.contains("validation message in full name "))
					{
						statusOfTestCase.add("PASS");
					}
					else if(getSignupStatus.contains("no validation message for full name"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("No validation message"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("exception"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("email"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("password"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("country"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("mobile"))
					{
						statusOfTestCase.add("FAIL");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					System.out.println("space on mail Validation process done");
					driver.close();
					break;
				}
			}
			driver.switchTo().window(parentWindow);//homepage
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add("FAIL");
		}
		return statusOfTestCase;
	
	}
	public ArrayList<String> verifySpaceOnPassword(ArrayList<String> data)
	{

		ArrayList<String> getSignupStatus = new ArrayList<String>();
		ArrayList<String> statusOfTestCase = new ArrayList<String>();
		try
		{
			System.out.println("space on Password validation started");
			statusOfTestCase.add(this.signUpPage());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			Thread.sleep(1000);
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("register"))
				{
					System.out.println("sign up page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					getSignupStatus.addAll(this.signUpFunction(data));
					if(getSignupStatus.contains("validation message in full name "))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("no validation message for full name"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("No validation message"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("exception"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("email"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("password"))
					{
						statusOfTestCase.add("PASS");
					}
					else if(getSignupStatus.contains("country"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("mobile"))
					{
						statusOfTestCase.add("FAIL");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					System.out.println("space on Password Validation process done");
					driver.close();
					break;
				}
			}
			driver.switchTo().window(parentWindow);//homepage
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add("FAIL");
		}
		return statusOfTestCase;
	
	}
	public String verifySubmitButtonForValidData()
	{
		String status = "FAIL";
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public ArrayList<String> checkValidationMessage()
	{
		ArrayList<String> errorMsgStatus = new ArrayList<String>();
		try
		{
			if(driver.findElements(By.cssSelector("div[role='alert'][class*='status message submission-error ']")).size()>0)
			{
				List<WebElement> errorMessage = driver.findElements(By.cssSelector("div[role='alert'][class*='status message submission-error ']"));
				
					for(int i = 0; i < errorMessage.size(); i++)
					{	
						switch(i)
						{
						case 0:
							System.out.println("Error message in name field");
							String getNameMessage = errorMessage.get(i).getAttribute("class");
							if(getNameMessage.contains("error-name is-shown"))
							{
								errorMsgStatus.add("validation message in full name ");
							}
							else
							{
								System.out.println("no validation message for full name");
							}
							break;
						case 1:
							System.out.println("Error message in email field");
							String getEmailMessage = errorMessage.get(i).getAttribute("class");
							if(getEmailMessage.contains("error-email is-shown") && getEmailMessage.contains("is-shown"))
							{
								errorMsgStatus.add("validation message in email ");
							}
							else
							{
								System.out.println("no validation message for email");
							}
							break;
						case 2:
							System.out.println("Error message in password field");
							String getPasswordMessage = errorMessage.get(i).getAttribute("class");
							if(getPasswordMessage.contains("error-password is-shown") && getPasswordMessage.contains("is-shown"))
							{
								errorMsgStatus.add("validation message in password ");
							}
							else
							{
								System.out.println("no validation message for password");
							}
							break;
						case 3:
							System.out.println("Error message in country field");
							String getCountryMessage = errorMessage.get(i).getAttribute("class");
							if(getCountryMessage.contains("error-country is-shown")&& getCountryMessage.contains("is-shown"))
							{
								errorMsgStatus.add("validation message in country ");
							}
							else
							{
								System.out.println("no validation message for country");
							}
							break;
						case 4:
							System.out.println("Error message in mobile field");
							String getMobileMessage = errorMessage.get(i).getAttribute("class");
							if(getMobileMessage.contains("error-mobile is-shown"))
							{
								errorMsgStatus.add("validation message in mobile ");
							}
							else
							{
								System.out.println("no validation message for mobile");
							}
							break;
						}
					}
				}
				else
				{
					errorMsgStatus.add("No validation message");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			errorMsgStatus.add("exception");
		}
		return errorMsgStatus;
	}
	
	public ArrayList<String> checkFullName(ArrayList<String> dataFromExcel) throws InterruptedException
	{
		ArrayList<String> getSignupStatus = new ArrayList<String>();
		ArrayList<String> statusOfTestCase = new ArrayList<String>();
		try
		{
			System.out.println("FullName validation started");
			statusOfTestCase.add(this.signUpPage());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			Thread.sleep(1000);
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("register"))
				{
					System.out.println("sign up page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					getSignupStatus.addAll(this.signUpFunction(dataFromExcel));
					if(getSignupStatus.contains("validation message in full name "))
					{
						statusOfTestCase.add("PASS");
					}
					else if(getSignupStatus.contains("no validation message for full name"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("No validation message"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("exception"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("email"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("password"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("country"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("mobile"))
					{
						statusOfTestCase.add("FAIL");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					Thread.sleep(1000);
					System.out.println("Invalid FullName Validation process done");
					Thread.sleep(1000);
					driver.close();
					break;
				}
			}
			driver.switchTo().window(parentWindow);//homepage
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add("FAIL");
		}
		return statusOfTestCase;
	}
	public ArrayList<String> checkEmail(ArrayList<String> data) throws InterruptedException
	{

		ArrayList<String> getSignupStatus = new ArrayList<String>();
		ArrayList<String> statusOfTestCase = new ArrayList<String>();
		try
		{
			System.out.println("Invalid Email validation started");
			statusOfTestCase.add(this.signUpPage());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			Thread.sleep(1000);
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("register"))
				{
					System.out.println("sign up page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					getSignupStatus.addAll(this.signUpFunction(data));
					if(getSignupStatus.contains("validation message in full name "))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("no validation message for full name"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("No validation message"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("exception"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("email"))
					{
						statusOfTestCase.add("PASS");
					}
					else if(getSignupStatus.contains("password"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("country"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("mobile"))
					{
						statusOfTestCase.add("FAIL");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					System.out.println("Invalid mail Validation process done");
					driver.close();
					break;
				}
			}
			driver.switchTo().window(parentWindow);//homepage
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add("FAIL");
		}
		return statusOfTestCase;
	
	}
	public ArrayList<String> checkPassword(ArrayList<String> data) throws InterruptedException
	{

		ArrayList<String> getSignupStatus = new ArrayList<String>();
		ArrayList<String> statusOfTestCase = new ArrayList<String>();
		try
		{
			System.out.println("Invalid Password validation started");
			statusOfTestCase.add(this.signUpPage());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			Thread.sleep(1000);
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("register"))
				{
					System.out.println("sign up page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					getSignupStatus.addAll(this.signUpFunction(data));
					if(getSignupStatus.contains("validation message in full name "))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("no validation message for full name"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("No validation message"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("exception"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("email"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("password"))
					{
						statusOfTestCase.add("PASS");
					}
					else if(getSignupStatus.contains("country"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("mobile"))
					{
						statusOfTestCase.add("FAIL");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					System.out.println("Invalid Password Validation process done");
					driver.close();
					break;
				}
			}
			driver.switchTo().window(parentWindow);//homepage
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add("FAIL");
		}
		return statusOfTestCase;
	
	}
	
	public ArrayList<Integer> checkSignupWithValidData(ArrayList<String> dataFromExcel) throws InterruptedException
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			System.out.println("sign up validation started with valid data");
			
			this.signUpPage();//click sign up icon
			
			String parentWindow = driver.getWindowHandle();
			
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("register"))
				{
					driver.switchTo().window(window);
					
					//statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));//enter all data in text box
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					break;
				}
			}
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			System.out.println("Sign up with Valid Data Verification process done");
			String parentWindow1 = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			for(String allwindows : windows)
			{
				driver.switchTo().window(allwindows);
				if(driver.getCurrentUrl().contains("verify"))
				{
					driver.switchTo().window(allwindows);
					//driver.findElement(By.cssSelector("div[class='sectionContent'] a span")).click();
					driver.navigate().back();
					Thread.sleep(1000);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					String parentWindow2 = driver.getWindowHandle();
					Set<String> windows1 = driver.getWindowHandles();
					for(String allwindows1 : windows1)
					{
						driver.switchTo().window(allwindows1);
						if(driver.getCurrentUrl().contains("dashboard"))
						{
							driver.switchTo().window(allwindows1);
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
							driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
							WebElement clickdropdown = driver.findElement(By.cssSelector("li[class*='Header_SigNUP'] img[alt='icon']"));
							WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0, 40));
							wait.until(ExpectedConditions.elementToBeClickable(clickdropdown));
							if(clickdropdown.isDisplayed())
							{
								clickdropdown.click();
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
								driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
							}
							Thread.sleep(1000);
							WebElement clickSignOut = driver.findElement(By.cssSelector("ul[class*='dropdown-menu Header_Primary']>li:nth-child(5)>a"));
							if(clickSignOut.isDisplayed())
							{
								clickSignOut.click();
							}
							Thread.sleep(1000);
						}
					}
					break;
				}
			}
			System.out.println("signout is done");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			System.out.println("sign up process done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return statusOfTestCase;
	}
	
	public ArrayList<String> verifyValidDataOnSignUp(ArrayList<String> data)
	{
		
		ArrayList<String> getSignupStatus = new ArrayList<String>();
		ArrayList<String> statusOfTestCase = new ArrayList<String>();
		try
		{
			System.out.println("Signup using valid  data validation started");
			statusOfTestCase.add(this.signUpPage());
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			Thread.sleep(1000);
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for(String window : allWindows)
			{
				driver.switchTo().window(window);
				if(driver.getCurrentUrl().contains("register"))
				{
					System.out.println("sign up page");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					getSignupStatus.addAll(this.signUpFunction(data));
					if(getSignupStatus.contains("validation message in full name "))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("no validation message for full name"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("No validation message"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("exception"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("email"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("password"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("country"))
					{
						statusOfTestCase.add("FAIL");
					}
					else if(getSignupStatus.contains("mobile"))
					{
						statusOfTestCase.add("FAIL");
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
					System.out.println("signup using valid data Validation process done");
					driver.close();
					break;
				}
			}
			driver.switchTo().window(parentWindow);//homepage
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add("FAIL");
		}
		return statusOfTestCase;
	}
	
	public ArrayList<String> signUpFunction(ArrayList<String> dataFromExcel) throws InterruptedException
	{
		ArrayList<String> statusOfTestCase = new ArrayList<String>();
		try
		{
			WebElement fullName = driver.findElement(By.cssSelector("input#name"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)", "");
			fullName.clear();
			fullName.sendKeys(dataFromExcel.get(1));
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)", "");
			WebElement email = driver.findElement(By.cssSelector("input#email"));
			email.clear();
			email.sendKeys(dataFromExcel.get(2));
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)", "");
			WebElement password = driver.findElement(By.cssSelector("input#password"));
			password.clear();
			password.sendKeys(dataFromExcel.get(3));
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			Select select = new Select(driver.findElement(By.cssSelector("select#country"))); 
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,400)","");
			select.selectByVisibleText(dataFromExcel.get(4));
			Thread.sleep(2000);
			WebElement phoneNumber = driver.findElement(By.cssSelector("input#mobile_number"));
			phoneNumber.clear();
			phoneNumber.sendKeys(dataFromExcel.get(5));
			WebElement clickCheckbox = driver.findElement(By.cssSelector("label[class='cbx'] svg"));
			if(clickCheckbox.isEnabled())
			{
				System.out.println("check box is enabled");
			}
			else
			{
				System.out.println("check box is not enabled");
				clickCheckbox.click();
			}
			Thread.sleep(2000);
			WebElement clickSignUp = driver.findElement(By.cssSelector("input#register_in"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(clickSignUp));
			clickSignUp.click();
			if(driver.findElements(By.cssSelector("div[role='alert'][class*='status message submission-error ']")).size()>0)
			{
				statusOfTestCase.addAll(this.checkValidationMessage());
			}
			else
			{
				System.out.println("no error msg");
				statusOfTestCase.add("No Validation message");
			}
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add("Fail");
		}
		
		return statusOfTestCase;
	}
}
