package com.formValidation.testing;

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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpLocator
{
	WebDriver driver;
	String parentWindow = "";
	String getSignupURL = "";
	
	@FindBy(css = "div[class*='Header_signupBtn']>a")  
    List<WebElement> SignUpForFreeButton;
	
	@FindBy(css = "div[role='alert'][class*='status message submission-error ']")  
    List<WebElement> errorMessage;
	
	@FindBy(css = "input#name")  
    WebElement fullNameField;
	
	@FindBy(css = "input#email")  
	WebElement emailField;
	
	@FindBy(css = "input#password")  
	WebElement passwordField;
	
	@FindBy(css = "input#mobile_number")  
	WebElement phoneNumberField;
	
	@FindBy(css = "input#register_in")  
	WebElement signUpButton;
	
	@FindBy(css = "label[class='cbx'] svg")  
    WebElement checkBox;
	
	@FindBy(css = "select#country")  
	WebElement selectCountry;
	
	@FindBy(css = "li[class*='SigNUP'] img[alt='icon']")  
	WebElement clickDropDown;
	
	@FindBy(css = "li[class*='SigNUP'] ul[class*='dropdown-menu'] li:nth-child(1) a")  
	WebElement checkLoggedName;
	
	@FindBy(css = "div[class='headerRight']>ul:nth-child(4) ul[class*='dropdown-menu']>li:nth-child(5)>a")  
	WebElement signout;
	
	
	public SignUpLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifySignUpButton()
	{
		boolean status = false;
		try
		{
			if (SignUpForFreeButton.size() > 0)
			{
				parentWindow = driver.getWindowHandle();
				status = true;
			} 
			else
			{
				status = false;
			}
			 System.out.println("sign up  button verified successfully");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<Integer> checkValidationMessage()
	{
		ArrayList<Integer> errorMsgStatus = new ArrayList<Integer>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			Thread.sleep(500);
				if(errorMessage.size()>0)
				{
					for(int i = 0; i < errorMessage.size(); i++)
					{	
						WebElement error = errorMessage.get(i);
						js.executeScript("arguments[0].scrollIntoView();", error);
						switch(i)
						{
						case 0:
							String getNameMessage = error.getAttribute("class");
							if(getNameMessage.contains("error-name is-shown"))
							{
								errorMsgStatus.add(1);
								System.out.println("Name Error Message is displayed");
							}
							break;
						case 1:
							String getEmailMessage = error.getAttribute("class");
							if(getEmailMessage.contains("error-email is-shown") || getEmailMessage.contains("is-shown"))
							{
								errorMsgStatus.add(2);
								System.out.println("Email Error Message is displayed");
							}
							break;
						case 2:
							String getPasswordMessage = error.getAttribute("class");
							if(getPasswordMessage.contains("error-password is-shown") || getPasswordMessage.contains("is-shown"))
							{
								errorMsgStatus.add(3);
								System.out.println("Password Error Message is displayed");
							}
							break;
						case 3:
							String getCountryMessage = error.getAttribute("class");
							if(getCountryMessage.contains("error-country is-shown") || getCountryMessage.contains("is-shown"))
							{
								errorMsgStatus.add(4);
								System.out.println("Country Error Message is displayed");
							}
							break;
						case 4:
							String getMobileMessage = error.getAttribute("class");
							if(getMobileMessage.contains("error-mobile is-shown"))
							{
								errorMsgStatus.add(5);
								System.out.println("Mobile Error Message is displayed");
							}
							break;
						}
						Thread.sleep(500);
					}
					System.out.println("Validation message verified successfully");
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			errorMsgStatus.add(0);
		}
		return errorMsgStatus;
	}
	
	public ArrayList<Integer> signUpFunction(ArrayList<String> dataFromExcel) throws InterruptedException
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement clickSignup = SignUpForFreeButton.get(0);
			js.executeScript("arguments[0].scrollIntoView();", clickSignup);
			getSignupURL = clickSignup.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(getSignupURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			Set<String> checkWindow = driver.getWindowHandles();
			for (String windows : checkWindow) 
			{
				driver.switchTo().window(windows);
				if (driver.getCurrentUrl().contains("learner-dashboard"))
				{
					driver.switchTo().window(windows);

					System.out.println("Navigated to dashboard page");
					js.executeScript("arguments[0].scrollIntoView();", clickDropDown);
					if(clickDropDown.isDisplayed())
					{
						js.executeScript("arguments[0].click()", clickDropDown);
					}
					js.executeScript("arguments[0].scrollIntoView();", checkLoggedName);
					String checkText = checkLoggedName.getText();
					if(checkText.contains("Hello"))
					{
						System.out.println("logged in successfully");
						js.executeScript("arguments[0].scrollIntoView();", signout);
						if(signout.isDisplayed())
						{
							js.executeScript("arguments[0].click()", signout);
							System.out.println("logged out successfully");
						}
						else
						{
							statusOfTestCase.add(0);
						}
					}
					driver.close();
					driver.switchTo().window(parentWindow);
					WebElement clickSignup1 = SignUpForFreeButton.get(0);
					js.executeScript("arguments[0].scrollIntoView();", clickSignup1);
					getSignupURL = clickSignup.getAttribute("href");
					driver.switchTo().newWindow(WindowType.TAB);
					driver.get(getSignupURL);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					break;
				
				}
			}
			
			
			js.executeScript("arguments[0].scrollIntoView();", fullNameField);
			if(dataFromExcel.get(2).contains("empty"))
			{
				fullNameField.clear();
				fullNameField.sendKeys("");
			}
			else
			{
				fullNameField.clear();
				fullNameField.sendKeys(dataFromExcel.get(2));
			}
			js.executeScript("arguments[0].scrollIntoView();", emailField);
			if (dataFromExcel.get(3).contains("empty"))
			{
				emailField.clear();
				emailField.sendKeys("");
			}
			else
			{
				emailField.clear();
				emailField.sendKeys(dataFromExcel.get(3));
			}
			js.executeScript("arguments[0].scrollIntoView();", passwordField);
			if (dataFromExcel.get(4).contains("empty"))
			{
				passwordField.clear();
				passwordField.sendKeys("");
			} 
			else 
			{
				passwordField.clear();
				passwordField.sendKeys(dataFromExcel.get(4));
			}
			/*
			 * js.executeScript("arguments[0].scrollIntoView();", selectCountry); Select
			 * select = new Select(selectCountry);
			 * select.selectByVisibleText(dataFromExcel.get(5));
			 */
			
			js.executeScript("arguments[0].scrollIntoView();", phoneNumberField);
			if (dataFromExcel.get(6).contains("empty")) 
			{
				phoneNumberField.clear();
				phoneNumberField.sendKeys("");
			} 
			else 
			{
				phoneNumberField.clear();
				phoneNumberField.sendKeys(dataFromExcel.get(6));
			}
			
			js.executeScript("arguments[0].scrollIntoView();", checkBox);
			if(checkBox.isEnabled())
            {
                System.out.println("check box is enabled");
            }
            else
            {
                System.out.println("check box is not enabled");
                checkBox.click();
            }
			
			js.executeScript("arguments[0].scrollIntoView();", signUpButton);
			js.executeScript("arguments[0].click();", signUpButton);
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if(errorMessage.size()>0)
			{
				statusOfTestCase.addAll(this.checkValidationMessage());
			}
			Thread.sleep(500);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if (statusOfTestCase.size() <= 0)
			{
				Set<String> listOfWindow = driver.getWindowHandles();
				for(String windows : listOfWindow)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("dashboard/"))
					{
						driver.switchTo().window(windows);
						System.out.println("Navigated to dashboard page");
						js.executeScript("arguments[0].scrollIntoView();", clickDropDown);
						if(clickDropDown.isDisplayed())
						{
							js.executeScript("arguments[0].click()", clickDropDown);
						}
						js.executeScript("arguments[0].scrollIntoView();", checkLoggedName);
						String checkText = checkLoggedName.getText();
						if(checkText.contains("Hello"))
						{
							System.out.println("logged in successfully");
							js.executeScript("arguments[0].scrollIntoView();", signout);
							if(signout.isDisplayed())
							{
								js.executeScript("arguments[0].click()", signout);
								System.out.println("logged out successfully");
							}
							else
							{
								statusOfTestCase.add(0);
							}
						}
						break;
					}
				}
			}
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		
		return statusOfTestCase;
	}
	
	public ArrayList<Integer> verifySignUpTC001(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		this.verifySignUpButton();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC001 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC002(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC002 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	
	public ArrayList<Integer> verifySignUpTC003(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC003 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}


	public ArrayList<Integer> verifySignUpTC004(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC004 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC005(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC005 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC006(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC006 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC007(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC007 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC008(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC008 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC009(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC009 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC010(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC010 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC011(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC011 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC012(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC012 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC013(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC013 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC014(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC014 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC015(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC015 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC016(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC016 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC017(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC017 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC018(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC018 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC019(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC019 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC020(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC020 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	
	public ArrayList<Integer> verifySignUpTC021(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC021 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC022(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC022 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC023(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC023 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC024(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC024 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC025(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC025 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC026(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC026 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC027(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC027 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC028(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC028 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC029(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC029 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC030(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC030 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC031(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC031 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC032(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC032 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC033(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC033 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC034(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC034 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC035(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC035 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC036(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC036 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC037(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC037 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC038(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC038 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC039(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC039 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC040(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC040 executed	 successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC041(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC041 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC042(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC042 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC043(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC043 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC044(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC044 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC045(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC045 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC046(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC046 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC047(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC047 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC048(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC048 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC049(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC049 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC050(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC050 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC051(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC051 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC052(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC052 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC053(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC053 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC054(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC054 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC055(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC055 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC056(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC056 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
	public ArrayList<Integer> verifySignUpTC057(ArrayList<String> dataFromExcel)
	{
		ArrayList<Integer> statusOfTestCase = new ArrayList<Integer>();
		try
		{
			statusOfTestCase.addAll(this.signUpFunction(dataFromExcel));
			System.out.println("SignUpTC057 executed successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			statusOfTestCase.add(0);
		}
		return statusOfTestCase;
	}
}
