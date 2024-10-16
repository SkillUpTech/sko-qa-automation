package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class SignUpValidation implements Callable<String>
{
	String result = "failed";
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	SignUpLocator signUpLocator;
	String jiraProcess ="";
	String sheetStatus = "Pass";
	HashMap<String, String> TicketStatus = new HashMap<String, String>();
	public SignUpValidation(ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.jiraProcess = jiraProcessStatus;
		
	}
	
	
	public void signUPFreeButton(ArrayList<String> data)
	{
		String status = signUpLocator.verifySignUPFreeButton();
		String jiraStatus = "";
		if(status.contains("FAIL"))
		{
			if(jiraProcess.contains("Yes"))
			{
				jiraStatus = "FAIL";
				TicketStatus.put(data.get(1), jiraStatus);
			}
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).set(0, "signUPFreeButton - failed");
		}
		else
		{
			if(jiraProcess.contains("Yes"))
			{
				jiraStatus = "PASS";
				TicketStatus.put(data.get(1), status);
			}
		}
	}
	public void spaceOnMail(ArrayList<String> data)
	{
		ArrayList<String> status = signUpLocator.verifySpaceOnMail(data);
		String jiraStatus = "";
		for(int i = 0; i < status.size(); i++)
		{
			if(status.contains("FAIL"))
			{
				if(jiraProcess.contains("Yes"))
				{
					jiraStatus = "FAIL";
					TicketStatus.put(data.get(6), jiraStatus);
				}
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).set(0, "spaceOnMail - failed");
			}
			else
			{
				if(jiraProcess.contains("Yes"))
				{
					jiraStatus = "PASS";
					TicketStatus.put(data.get(6), jiraStatus);
				}
			}
		} 
	}
	public void spaceOnFullname(ArrayList<String> data)
	{
		ArrayList<String> status = signUpLocator.verifySpaceOnFullname(data);
		String jiraStatus = "";
		for(int i = 0; i < status.size(); i++)
		{
			if(status.contains("FAIL"))
			{
				if(jiraProcess.contains("Yes"))
				{
					jiraStatus = "FAIL";
					TicketStatus.put(data.get(6), jiraStatus);
				}
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(0, "spaceOnFullname - failed");
			}
			else
			{
				if(jiraProcess.contains("Yes"))
				{
					jiraStatus = "PASS";
					TicketStatus.put(data.get(6), jiraStatus);
				}
			}
		} 
	}
	public void spaceOnPassword(ArrayList<String> data)
	{
		ArrayList<String> status = signUpLocator.verifySpaceOnPassword(data);
		String jiraStatus = "";
		for(int i = 0; i < status.size(); i++)
		{
			if(status.contains("FAIL"))
			{
				if(jiraProcess.contains("Yes"))
				{
					
					jiraStatus = "FAIL";
					TicketStatus.put(data.get(6), jiraStatus);
				}
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(3).set(0, "spaceOnPassword - failed");
			}
			else
			{
				if(jiraProcess.contains("Yes"))
				{
					
					jiraStatus = "PASS";
					TicketStatus.put(data.get(6), jiraStatus);
				}
			}
		} 
	}
	
	public void invalidFullname(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> verifyFullName = signUpLocator.checkFullName(data);
		for(int i = 0; i < verifyFullName.size(); i++)
		{
			if(verifyFullName.contains("FAIL"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).set(0, "invalidFullname - failed");
			}
		} 
	}
	
	public void emailValidation(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = signUpLocator.checkEmail(data);
		for(int i = 0; i < status.size(); i++)
		{
			if(status.contains("FAIL"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).set(0, "invalidEmail - failed");
			}
		} 
	}
	
	public void passwordValidation(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = signUpLocator.checkPassword(data);
		for(int i = 0; i < status.size(); i++)
		{
			if(status.contains("FAIL"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).set(0, "invalidPassword - failed");
			}
		} 
	}
	
	
	public void validData(ArrayList<String> data)
	{
		ArrayList<String> status = signUpLocator.verifyValidDataOnSignUp(data);
		String jiraStatus = "";
		for(int i = 0; i < status.size(); i++)
		{
			if(status.contains("FAIL"))
			{
				if(jiraProcess.contains("Yes"))
				{
					jiraStatus = "FAIL";
					TicketStatus.put(data.get(6), jiraStatus);
				}
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).set(0, "validData - failed");
			}
			else
			{
				if(jiraProcess.contains("Yes"))
				{
					jiraStatus = "PASS";
					TicketStatus.put(data.get(6), jiraStatus);
				}
			}
		} 
	}
	public void verifyInsertedData(ArrayList<String> data, int index)
	{
		try
		{
			ArrayList<String> status = new ArrayList<String>();
			ArrayList<Integer> verifyValidData = signUpLocator.checkSignupWithValidData(data);
			for(int i = 0; i < verifyValidData.size(); i++)
			{
					if(verifyValidData.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).get(1);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).set(1, (cellValue + " - failed"));
						status.add("Failed");
					}
					else if(verifyValidData.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).set(2, (cellValue + " - failed"));
						status.add("Failed");
					}
					else if(verifyValidData.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).set(3, (cellValue + " - failed"));
						status.add("Failed");
					}
					else if(verifyValidData.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).set(4, (cellValue + " - failed"));
						status.add("Failed");
					}
					else if(verifyValidData.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).set(5, (cellValue + " - failed"));
						status.add("Failed");
					}	
				}
				if(status.contains("Failed"))
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(index).set(0, "validData - failed"); 
				}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void validDataProcess(ArrayList<String> dataFromExcel)
	{
		this.verifyInsertedData(sheetData.get(3), 3);
	}
	
	public void addUser(ArrayList<String> dataFromExcel, int index)
	{
		this.verifyInsertedData(dataFromExcel, index);
	}
	
	public WebDriver openDriver(String browserName)
	{
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", RegressionTesting.driverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Hemamalini\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver(); 
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		}
		return driver;
	}
	@Override
	public String call() throws Exception
	{
		System.out.println("Sign up validation begins");
		try {
		driver = this.openDriver(RegressionTesting.nameOfBrowser);
		OpenWebsite.openSite(driver);
		this.signUpLocator = new SignUpLocator(this.driver);
		String BaseWindow = driver.getWindowHandle();
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
			case "signUPFreeButton":
				signUPFreeButton(row);
				break;
			case "spaceOnMail":
				spaceOnMail(row);
				break;
			case "spaceOnFullname":
				spaceOnFullname(row);
				break;
			case "spaceOnPassword":
				spaceOnPassword(row);
				break;
			
			  case "invalidFullname": 
				  invalidFullname(row); 
				  break; 
			  case "invalidEmail":
				  emailValidation(row); 
				  break; 
			  case "invalidPassword": 
				  passwordValidation(row);
				  break; 
			  case "validData":
				  validData(row);
					break;
				/*
				 * case "addUser": addUser(row, i); break;
				 */
			}
		}
		Set<String> windows = driver.getWindowHandles();
		for(String win : windows)
		{
			driver.switchTo().window(win);
			if(!BaseWindow.equals(win))
			{
				driver.switchTo().window(win);
				if(driver.getCurrentUrl().equalsIgnoreCase(OpenWebsite.setURL+"/"))
				{
					driver.switchTo().window(win);
					driver.close();
					driver.switchTo().window(BaseWindow);
				}
				else if(driver.getCurrentUrl().contains("courses"))
				{
					driver.switchTo().window(win);
					driver.close();
					driver.switchTo().window(BaseWindow);
				}
				else if(!driver.getCurrentUrl().equalsIgnoreCase(OpenWebsite.setURL+"/"))
				{
					driver.switchTo().window(win);
					driver.close();
					driver.switchTo().window(BaseWindow);
				}
			}
		}
		driver.quit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	}
}
