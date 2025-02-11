package com.formValidation.testing;

import java.time.Duration;
import java.util.ArrayList;
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
	String sheetStatus = "Pass";
	
	public SignUpValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData) throws InterruptedException
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	
	public void checkSignUpTC001()
	{
		boolean status = signUpLocator.verifySignUpButton();
		if(status == false)
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).set(0, "SignUpTC001 - failed");
		}
	}
	
	public void checkSignUpTC001(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC001(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(0).set(0, "SignUpTC002 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC002(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC002(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(1).set(0, "SignUpTC002 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC003(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC003(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(2).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void checkSignUpTC004(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC004(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(4).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void checkSignUpTC005(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC005(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(5).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void checkSignUpTC006(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC006(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(6).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void checkSignUpTC007(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC007(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void checkSignUpTC008(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC008(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(8).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(8).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(8).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(8).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(8).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(8).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(8).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(8).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(7).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC009(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC008(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(9).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC010(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC010(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC011(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC011(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(10).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(11).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC012(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC012(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(12).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC013(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC013(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(13).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC014(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC014(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(14).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC015(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC015(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC016(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC016(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(16).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC017(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC017(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(15).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(17).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC018(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC018(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(18).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC019(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC019(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(19).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC020(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC020(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(20).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC021(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC021(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(21).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC022(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC022(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(22).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC023(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC023(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(23).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC024(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC024(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(25).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC025(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC025(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(26).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC026(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC026(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(27).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC027(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC027(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(28).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC028(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC028(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(29).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC029(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC029(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(30).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC030(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC030(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(31).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC031(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC031(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(32).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC032(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC032(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(33).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC033(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC033(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(34).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC034(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC034(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(35).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC035(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC035(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(36).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC036(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC036(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(37).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC037(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC037(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(38).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC038(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC038(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(39).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC039(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC039(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(40).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC040(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC040(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(42).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC041(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC041(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(43).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC042(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC042(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(44).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC043(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC043(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(45).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC044(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC044(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(46).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC045(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC045(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(47).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC046(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC046(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(48).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC047(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC047(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(49).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC048(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC048(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(50).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC049(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC049(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(51).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC050(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC050(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(52).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC051(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC051(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(53).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC052(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC052(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(54).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC053(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC053(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(55).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC054(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC054(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(56).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC055(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC055(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(57).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC056(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC056(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(58).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void checkSignUpTC057(ArrayList<String> dataFromExcel)
	{
		try
		{
			ArrayList<Integer> fieldValidationValue = signUpLocator.verifySignUpTC057(dataFromExcel);
			if(fieldValidationValue.size()>0)
			{
				for(int i = 0; i < fieldValidationValue.size(); i++)
				{
					if(fieldValidationValue.get(i).equals(1))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).get(2);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).set(2, (cellValue + " - failed"));
						
					}
					else if(fieldValidationValue.get(i).equals(2))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).get(3);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).set(3, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(3))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).get(4);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).set(4, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(4))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).get(5);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).set(5, (cellValue + " - failed"));
					}
					else if(fieldValidationValue.get(i).equals(5))
					{
						sheetStatus = "Fail";
						String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).get(6);
						RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).set(6, (cellValue + " - failed"));
					}
					
				}
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("SignUp").get(59).set(0, "SignUpTC003 - failed");
			}
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public String call() throws Exception
	{
		System.out.println("Sign up validation begins");
		try 
		{
	
		this.signUpLocator = new SignUpLocator(this.driver);
		
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
			/*
			 * case "SignUpTC001": checkSignUpTC001(); break; case "SignUpTC002":
			 * checkSignUpTC002(row); break; case "SignUpTC003": checkSignUpTC003(row);
			 * break;
			 */
				
				  case "SignUpTC004": checkSignUpTC004(row); break; 
				  case "SignUpTC005":
				  checkSignUpTC005(row); break; 
				  case "SignUpTC006": checkSignUpTC006(row);
				  break; case "SignUpTC007": checkSignUpTC007(row); break; 
				  case "SignUpTC008":
				  checkSignUpTC008(row); break; 
				  case "SignUpTC009": checkSignUpTC009(row);
				  break; case "SignUpTC010": checkSignUpTC010(row); break; 
				  case "SignUpTC011":
				  checkSignUpTC011(row); break; 
				  case "SignUpTC012": checkSignUpTC012(row);
				  break; 
				  case "SignUpTC013": checkSignUpTC013(row); break; 
				  case "SignUpTC014":
				  checkSignUpTC014(row); break; 
				  case "SignUpTC015": checkSignUpTC015(row);
				  break; case "SignUpTC016": checkSignUpTC016(row); break; 
				  case "SignUpTC017":
				  checkSignUpTC017(row); break; case "SignUpTC018": checkSignUpTC018(row);
				  break; case "SignUpTC019": checkSignUpTC019(row); break; case "SignUpTC020":
				  checkSignUpTC020(row); break; case "SignUpTC021": checkSignUpTC021(row);
				  break; case "SignUpTC022": checkSignUpTC022(row); break; case "SignUpTC023":
				  checkSignUpTC023(row); break; case "SignUpTC024": checkSignUpTC024(row);
				  break; case "SignUpTC025": checkSignUpTC025(row); break; case "SignUpTC026":
				  checkSignUpTC026(row); break; case "SignUpTC027": checkSignUpTC027(row);
				  break; case "SignUpTC028": checkSignUpTC028(row); break; case "SignUpTC029":
				  checkSignUpTC029(row); break; case "SignUpTC030": checkSignUpTC030(row);
				  break; case "SignUpTC031": checkSignUpTC031(row); break; case "SignUpTC032":
				  checkSignUpTC032(row); break; case "SignUpTC033": checkSignUpTC033(row);
				  break; case "SignUpTC034": checkSignUpTC034(row); break; case "SignUpTC035":
				  checkSignUpTC035(row); break; case "SignUpTC036": checkSignUpTC036(row);
				  break; case "SignUpTC037": checkSignUpTC037(row); break; case "SignUpTC038":
				  checkSignUpTC038(row); break; case "SignUpTC039": checkSignUpTC039(row);
				  break; case "SignUpTC040": checkSignUpTC040(row); break; case "SignUpTC041":
				  checkSignUpTC041(row); break; case "SignUpTC042": checkSignUpTC042(row);
				  break; case "SignUpTC043": checkSignUpTC043(row); break; case "SignUpTC044":
				  checkSignUpTC044(row); break; case "SignUpTC045": checkSignUpTC045(row);
				  break; case "SignUpTC046": checkSignUpTC046(row); break; case "SignUpTC047":
				  checkSignUpTC047(row); break; case "SignUpTC048": checkSignUpTC048(row);
				  break; case "SignUpTC049": checkSignUpTC049(row); break; case "SignUpTC050":
				  checkSignUpTC050(row); break; case "SignUpTC051": checkSignUpTC051(row);
				  break; case "SignUpTC052": checkSignUpTC052(row); break; case "SignUpTC053":
				  checkSignUpTC053(row); break; case "SignUpTC054": checkSignUpTC054(row);
				  break; case "SignUpTC055": checkSignUpTC055(row); break; case "SignUpTC056":
				  checkSignUpTC056(row); break; case "SignUpTC057": checkSignUpTC057(row);
				  break;
				 
			}
		}
		 DriverManager.quitDriver();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	}
}
