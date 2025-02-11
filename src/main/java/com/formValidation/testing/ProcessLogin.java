package com.formValidation.testing;

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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessLogin
{
	WebDriver driver;
	String url = "";
	String parentWindow = "";
	String getLoginURL = "";
	
	@FindBy(css = "div[class*='Header_loginBtn']>a")  
    List<WebElement> loginButton;
	
	@FindBy(css = "input#email")  
    WebElement email;
	
	@FindBy(css = "input#password")  
    WebElement password;
	
	@FindBy(css = "input[value='Log In']")  
    WebElement submitLogin;
	
	@FindBy(xpath = "//div[contains(@class,'status message submission-error is-shown')]")  
    List<WebElement> errorMessage;
	
	
	@FindBy(css = "li[class*='SigNUP'] img[alt='icon']")  
    WebElement clickDropDownFromDashboardPage;
	
	
	@FindBy(css = "div[class='headerRight']>ul:nth-child(4) ul[class*='dropdown-menu']>li:nth-child(5)>a")  
    WebElement clickSignOut;
	
	
	public ProcessLogin(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ArrayList<String> loginFunction(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> loginStatus=new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement clickLogin = loginButton.get(0);
			js.executeScript("arguments[0].scrollIntoView();", clickLogin);
			getLoginURL = clickLogin.getAttribute("href");
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(getLoginURL);
			js.executeScript("arguments[0].scrollIntoView();", email);
			
			if(data.get(2).contains("empty"))
			{
				email.clear(); 
				email.sendKeys("");
			}
			else 
			{
				email.clear(); 
				email.sendKeys(data.get(2));
			}
			
			js.executeScript("arguments[0].scrollIntoView();", password);
			if (data.get(3).contains("empty")) 
			{
				password.clear(); 
				password.sendKeys("");
			} 
			else 
			{
				password.clear(); 
				password.sendKeys(data.get(3));
			}
			js.executeScript("arguments[0].scrollIntoView();", submitLogin);
			  if(submitLogin.isDisplayed())
			  { 
				  js.executeScript("arguments[0].click()", submitLogin); 
				  String statusOfErrorMessage = this.ErrorMessage();
				  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				  if(!statusOfErrorMessage.contains("fail"))
				  {
					  loginStatus.add(this.checkUserAfterLoggedIn());
				  }
				  else
				  {
					  loginStatus.add("fail");
					  driver.close();
					  driver.switchTo().window(parentWindow);
				  }
				  System.out.println("login function executed successfully");
			  } 
			  
		}
		catch(Exception e)
		{
			e.printStackTrace();
			loginStatus.add("exception");
		}
		return loginStatus;
	}
	
	public String ErrorMessage()
	{
		String errorStatus = null;
		try
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if(errorMessage.size()>0)
			{
				errorStatus = "error message displayed";
				System.out.println("error message displayed");
			}
			else
			{
				System.out.println("no error message");
				errorStatus = "pass";
			}
			 System.out.println("error validation executed successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			errorStatus = "exception";
		}
		
		return errorStatus;
	}
	
	public String checkUserAfterLoggedIn()
	{
		String statusOfDashboardPage="fail";
		JavascriptExecutor js = (JavascriptExecutor) driver;
			try
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				Set<String> listOfWindow = driver.getWindowHandles();
				for(String windows : listOfWindow)
				{
					driver.switchTo().window(windows);
					if(driver.getCurrentUrl().contains("personalized/"))
					{
						driver.switchTo().window(windows);
						System.out.println("onboarding journey page");
						statusOfDashboardPage = "fail";
						break;
					 }
					else if(driver.getCurrentUrl().contains("dashboard"))
					{
						driver.switchTo().window(windows);
						System.out.println("Navigated to dashboard page");
						WebElement clickDropDown = driver.findElement(By.cssSelector("li[class*='SigNUP'] img[alt='icon']"));
						js.executeScript("arguments[0].scrollIntoView();", clickDropDown);
						if(clickDropDown.isDisplayed())
						{
							js.executeScript("arguments[0].click()", clickDropDown);
						}
						WebElement checkLoggedName = driver.findElement(By.cssSelector("li[class*='SigNUP'] ul[class*='dropdown-menu'] li:nth-child(1) a"));
						js.executeScript("arguments[0].scrollIntoView();", checkLoggedName);
						String checkText = checkLoggedName.getText();
						if(checkText.contains("Hello"))
						{
							statusOfDashboardPage = "pass";
							System.out.println("logged in successfully");
							WebElement clickSignOut = driver.findElement(By.cssSelector("div[class='headerRight']>ul:nth-child(4) ul[class*='dropdown-menu']>li:nth-child(5)>a"));
							js.executeScript("arguments[0].scrollIntoView();", clickSignOut);
							if(clickSignOut.isDisplayed())
							{
								js.executeScript("arguments[0].click()", clickSignOut);
								System.out.println("logged out successfully");
								statusOfDashboardPage = "pass";
							}
						}
						
						break;
					}
				}
				driver.close();
				driver.switchTo().window(parentWindow);
				 System.out.println("Dashboard page verification done");
			}
		catch(Exception e)
		{
			e.printStackTrace();
			statusOfDashboardPage = "exception";
		}
		return statusOfDashboardPage;
	}
	
	
	public String logOutFunction() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String logoutStatus = "";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			js.executeScript("arguments[0].scrollIntoView();", clickDropDownFromDashboardPage);
			if(clickDropDownFromDashboardPage.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickDropDownFromDashboardPage);
			}
			js.executeScript("arguments[0].scrollIntoView();", clickSignOut);
			if(clickSignOut.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickSignOut);
				System.out.println("logout successfully");
			}
			 System.out.println("logout executed successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return logoutStatus;
		
	}
	
	public boolean verifyLoginButton()
	{
		boolean status = false;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			if (loginButton.size() > 0)
			{
				parentWindow = driver.getWindowHandle();
				status = true;
			} 
			else
			{
				status = false;
			}
			 System.out.println("login button verified successfully");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<String> verifyLoginTC001(ArrayList<String> data)
	{
		ArrayList<String> status = new ArrayList<String>();
		try
		{
			status.addAll(this.loginFunction(data));
			System.out.println("LoginTC001 verified successfully");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
		
	}
	
	public ArrayList<String> verifyLoginTC002(ArrayList<String> data)
	{
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC002 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC003(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC003 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC004(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC004 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC005(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC005 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC006(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC006  verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC007(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC007 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC008(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC008  verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC009(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC009 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC010(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC010 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC011(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC011 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC012(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC012 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC013(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC013 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC014(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC014 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC015(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC015 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC016(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC016 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC017(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC017 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC018(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC018 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC019(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC019 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC020(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC020 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public ArrayList<String> verifyLoginTC021(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC021 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC022(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC022 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC023(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC023 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC024(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC024 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC025(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC025 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC026(ArrayList<String> data)
    {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC026 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC027(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC027 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC028(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC028 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC029(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC029 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public ArrayList<String> verifyLoginTC030(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC030 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public ArrayList<String> verifyLoginTC031(ArrayList<String> data) {
        ArrayList<String> status = new ArrayList<String>();
        try {
            status.addAll(this.loginFunction(data));
            System.out.println("LoginTC031 verified successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
	
}
