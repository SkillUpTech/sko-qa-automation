package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

public class CoursePurchaseActivationHandlerValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	CoursePurchaseActivationHandlerLocator coursePurchaseActivationHandlerLocator;
	String sheetStatus = "Pass";
	
	public CoursePurchaseActivationHandlerValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
		this.driver = driver;
		
	}
	
	@Override
	public String call() throws Exception 
	{
		System.out.println("Course Purchase Activation Handler Validation");
		try
		{
			this.coursePurchaseActivationHandlerLocator = new CoursePurchaseActivationHandlerLocator(driver);
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				ArrayList<String> row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
					case "lanuchUrl":
						checkLanuchUrl(row.get(1));
						break;
					case "clickEnroll":
						checkClickEnroll();
						break;
					case "signup":
						checkSignup(row);
						break;
					case "enrollmentProcess":
						checkEnrollmentProcess(row);
						break;
					case "checkDashboard":
						checkDashboard();
						break;
					case "login":
						checkLogin(row.get(1), row.get(2));
						break;
					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	
	}
	String checkURLStatus = "";
	
	public void checkLanuchUrl(String url) 
	{
		checkURLStatus = coursePurchaseActivationHandlerLocator.checkLanuchUrl(url);
		if(checkURLStatus.equalsIgnoreCase("fail"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(0).set(0, " - failed");
		}
	}
	
	public void checkClickEnroll()
	{
		if(!checkURLStatus.equalsIgnoreCase("fail"))
		{
			String status = coursePurchaseActivationHandlerLocator.verifyEnrollButton();
			if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(1).set(0, " - failed");
			}
		}
    }
	
	public void checkSignup(ArrayList<String> data)
	{
		if(!checkURLStatus.equalsIgnoreCase("fail"))
		{
			ArrayList<String> status = new ArrayList<String>();
			
			ArrayList<Integer> verifyValidData = coursePurchaseActivationHandlerLocator.verifySignupProcess(data);
			
			for(int i = 0; i < verifyValidData.size(); i++)
			{
					if(verifyValidData.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(1);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(1, (cellValue + " - failed"));
						status.add("Failed");
					}
					else if(verifyValidData.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(2, (cellValue + " - failed"));
						status.add("Failed");
					}
					else if(verifyValidData.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(3, (cellValue + " - failed"));
						status.add("Failed");
					}
					else if(verifyValidData.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(4, (cellValue + " - failed"));
						status.add("Failed");
					}
					else if(verifyValidData.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(5, (cellValue + " - failed"));
						status.add("Failed");
					}	
				}
				if(status.contains("Failed"))
				{
					sheetStatus = "Fail";
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(0, "validData - failed"); 
				}
		}
    }
	
	public void checkEnrollmentProcess(ArrayList<String> enrollDataFromExcel)
	{
		if(!checkURLStatus.equalsIgnoreCase("fail"))
		{
			ArrayList<String> verifyEnrollmentProcess = new ArrayList<String>();
			if(!checkURLStatus.equalsIgnoreCase("fail"))
			{
				verifyEnrollmentProcess = coursePurchaseActivationHandlerLocator.enroll(enrollDataFromExcel);
				
				for(int i = 0; i < verifyEnrollmentProcess.size(); i++)
				{
					 if (i == 0 && verifyEnrollmentProcess.get(i).contains("razorpayFail")) {
		                    sheetStatus = "Fail";
		                    String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(3).get(1);
		                    RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(3).set(1, (cellValue + " - failed"));
		                }
		                if (i == 1 && verifyEnrollmentProcess.get(i).contains("paymentFail")) {
		                    sheetStatus = "Fail";
		                    String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(3).get(2);
		                    RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(3).set(2, (cellValue + " - failed"));
		                }
		                if (i == 2 && verifyEnrollmentProcess.get(i).contains("orderDetailFail")) {
		                    sheetStatus = "Fail";
		                    String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(3).get(3);
		                    RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(3).set(3, (cellValue + " - failed"));
		                }
				}
			}
		}
    }
	
	public void checkDashboard()
	{
		if (!checkURLStatus.equalsIgnoreCase("fail")) 
		{
			String status = coursePurchaseActivationHandlerLocator.verifyDashboard();
			if (status.equalsIgnoreCase("fail")) 
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(4).set(0, " - failed");
			}
		}
	}
	
	public void checkLogin(String userName, String passWord)
	{
		if(!checkURLStatus.equalsIgnoreCase("fail"))
		{
			String status = coursePurchaseActivationHandlerLocator.verifyLoginProcess(userName, passWord);
			if(status.equalsIgnoreCase("fail"))
			{
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("CoursePurchaseActivationHandler").get(4).set(0, " - failed");
			}
			
		}
    }
	
	
	
}
