package com.formValidation.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

import com.palm.regressionTesting.JiraTicketStatusUpdate;

public class RegressionTestLogin implements Callable<String>
{
	WebDriver driver;
	String result = "failed";
	String jiraProcess ="";
	ArrayList<ArrayList<String>> sheetData = null;
	ProcessLogin processLogin;
	String sheetStatus = "Pass";
	String browser = "";
	RegressionTesting regressionTesting;
	ArrayList<String> row = new ArrayList<String>();
	ArrayList<String> ticketStatus = new ArrayList<String>();
	
	public RegressionTestLogin(WebDriver driver, ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus) throws Exception
	{		
			this.driver = driver;
			this.sheetData = sheetData;
		 	this.jiraProcess = jiraProcessStatus;
	}
	
	public boolean checkLoginButton()
	{
		boolean loginStatus = processLogin.verifyLoginButton();
		
		if(loginStatus == false)
        {
            sheetStatus = "Fail";
            RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(0).set(0, "checkLoginButton - failed");
        }
		return loginStatus;
	}
	
	public void checkLoginTC001(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC001(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(2).set(0, "LoginTC001 - failed");
		}
	}
	
	public void checkLoginTC002(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC002(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(3).set(0, "LoginTC002 - failed");
		}
	}
	
	public void checkLoginTC003(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC003(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(4).set(0, "LoginTC003 - failed");
		}
	}
	public void checkLoginTC004(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC004(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(5).set(0, "LoginTC004 - failed");
		}
	}
	public void checkLoginTC005(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC005(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(6).set(0, "LoginTC005 - failed");
		}
	}
	public void checkLoginTC006(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC006(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(7).set(0, "LoginTC006 - failed");
		}
	}
	public void checkLoginTC007(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC007(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(8).set(0, "LoginTC007 - failed");
		}
	}
	public void checkLoginTC008(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC008(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(9).set(0, "LoginTC008 - failed");
		}
	}
	public void checkLoginTC009(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC009(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(10).set(0, "LoginTC009 - failed");
		}
	}
	public void checkLoginTC010(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC010(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(11).set(0, "LoginTC010 - failed");
		}
	}
	public void checkLoginTC011(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC011(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(12).set(0, "LoginTC011 - failed");
		}
	}
	public void checkLoginTC012(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC012(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(13).set(0, "LoginTC012 - failed");
		}
	}
	public void checkLoginTC013(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC013(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(14).set(0, "LoginTC013 - failed");
		}
	}
	public void checkLoginTC014(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC014(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(16).set(0, "LoginTC014 - failed");
		}
	}
	public void checkLoginTC015(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC015(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(17).set(0, "LoginTC015 - failed");
		}
	}
	public void checkLoginTC016(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC016(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(18).set(0, "LoginTC016 - failed");
		}
	}
	public void checkLoginTC017(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC017(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(19).set(0, "LoginTC017 - failed");
		}
	}
	public void checkLoginTC018(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC018(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(20).set(0, "LoginTC018 - failed");
		}
	}
	public void checkLoginTC019(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC019(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(21).set(0, "LoginTC019 - failed");
		}
	}
	public void checkLoginTC020(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC020(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(22).set(0, "LoginTC020 - failed");
		}
	}
	public void checkLoginTC021(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC021(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(23).set(0, "LoginTC021 - failed");
		}
	}
	public void checkLoginTC022(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC022(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(24).set(0, "LoginTC022 - failed");
		}
	}
	public void checkLoginTC023(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC023(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(25).set(0, "LoginTC023d - failed");
		}
	}
	public void checkLoginTC024(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC024(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(26).set(0, "LoginTC024 - failed");
		}
	}
	public void checkLoginTC025(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC025(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(27).set(0, "LoginTC025 - failed");
		}
	}
	public void checkLoginTC026(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC026(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(28).set(0, "LoginTC026 - failed");
		}
	}
	public void checkLoginTC027(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC027(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(29).set(0, "LoginTC027 - failed");
		}
	}
	public void checkLoginTC028(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC028(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(30).set(0, "LoginTC028 - failed");
		}
	}
	public void checkLoginTC029(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC029(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(31).set(0, "LoginTC029 - failed");
		}
	}
	public void checkLoginTC030(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC030(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(32).set(0, "LoginTC030 - failed");
		}
	}
	
	public void checkLoginTC031(ArrayList<String> data) throws InterruptedException
	{
		ArrayList<String> status = processLogin.verifyLoginTC031(data);
		if(status.contains("fail") || status.contains("exception"))
		{
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("Login").get(33).set(0, "LoginTC031 - failed");
		}
	}

	@Override
	public String call() throws Exception
	{
		System.out.println("login process started");
		try
		{
	        this.processLogin = new ProcessLogin(driver);
			for(int i = 0; i < this.sheetData.size(); i++)
			{
				row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch(firstColumn)
				{
					
				case "checkLoginButton":
					boolean isCase1Success = checkLoginButton();
					 if (!isCase1Success)
					 {
		                System.out.println("Case 1 failed. Stopping execution.");
		                return firstColumn; // Stops further execution
			         }
				break;
				case "LoginTC001":
			        checkLoginTC001(row);
			        break;
			    case "LoginTC002":
			        checkLoginTC002(row);
			        break;
			    case "LoginTC003":
			        checkLoginTC003(row);
			        break;
			    case "LoginTC004":
			        checkLoginTC004(row);
			        break;
			    case "LoginTC005":
			        checkLoginTC005(row);
			        break;
			    case "LoginTC006":
			        checkLoginTC006(row);
			        break;
			    case "LoginTC007":
			        checkLoginTC007(row);
			        break;
			    case "LoginTC008":
			        checkLoginTC008(row);
			        break;
			    case "LoginTC009":
			        checkLoginTC009(row);
			        break;
			    case "LoginTC010":
			        checkLoginTC010(row);
			        break;
			    case "LoginTC011":
			        checkLoginTC011(row);
			        break;
			    case "LoginTC012":
			        checkLoginTC012(row);
			        break;
			    case "LoginTC013":
			        checkLoginTC013(row);
			        break;
			    case "LoginTC014":
			        checkLoginTC014(row);
			        break;
			    case "LoginTC015":
			        checkLoginTC015(row);
			        break;
			    case "LoginTC016":
			        checkLoginTC016(row);
			        break;
			    case "LoginTC017":
			        checkLoginTC017(row);
			        break;
			    case "LoginTC018":
			        checkLoginTC018(row);
			        break;
			    case "LoginTC019":
			        checkLoginTC019(row);
			        break;
			    case "LoginTC020":
			        checkLoginTC020(row);
			        break;
			    case "LoginTC021":
			        checkLoginTC021(row);
			        break;
			    case "LoginTC022":
			        checkLoginTC022(row);
			        break;
			    case "LoginTC023":
			        checkLoginTC023(row);
			        break;
			    case "LoginTC024":
			        checkLoginTC024(row);
			        break;
			    case "LoginTC025":
			        checkLoginTC025(row);
			        break;
			    case "LoginTC026":
			        checkLoginTC026(row);
			        break;
			    case "LoginTC027":
			        checkLoginTC027(row);
			        break;
			    case "LoginTC028":
			        checkLoginTC028(row);
			        break;
			    case "LoginTC029":
			        checkLoginTC029(row);
			        break;
			    case "LoginTC030":
			        checkLoginTC030(row);
			        break;
			    case "LoginTC031":
			        checkLoginTC031(row);
			        break;
			    default:
			        System.out.println("test case: " );
				break; 
				}
			}
			
			if(jiraProcess.contains("Yes"))
			{
				HashMap<String, String> resultStatus = new HashMap<String, String>();
				ArrayList<String> sheetRow = sheetData.get(4);
				String getExecutionStatus = "";
				String getprocessStatus = "";
				JiraTicketStatusUpdate jiraTicketStatusUpdate = new JiraTicketStatusUpdate();
				
				if(sheetStatus == "fail")
				{
					getExecutionStatus = "FAIL";
					resultStatus.put(sheetRow.get(1), getExecutionStatus);
					getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
					System.out.println(getprocessStatus);
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ProgramURLandSlug").get(4).add(2, (getExecutionStatus + "failed"));
				}
				else
				{
					getExecutionStatus = "PASS";
					resultStatus.put(sheetRow.get(1), getExecutionStatus);
					getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
					System.out.println(getprocessStatus);
					
				}
				/*
				 * RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get(
				 * "ProgramURLandSlug").get(4).add(2, (getExecutionStatus)+ Utils.DELIMITTER +
				 * "bold" + Utils.DELIMITTER + "color" +
				 * (getExecutionStatus.equalsIgnoreCase("Pass") ? "Green" : "Red"));
				 */			
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	}
}
