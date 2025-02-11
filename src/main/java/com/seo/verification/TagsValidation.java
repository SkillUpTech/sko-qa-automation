package com.seo.verification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

import com.palm.regressionTesting.IBMSkillBuildPageLocator;
import com.palm.regressionTesting.JiraTicketStatusUpdate;
import com.palm.regressionTesting.RegressionTesting;
import com.regression.utility.Utils;

public class TagsValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	String jiraProcess ="";
	TagsLocator tagsLocator;
	String sheetStatus = "Pass";
	WebDriver driver;
	
	public TagsValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData, String jiraProcessStatus)
	{
		this.sheetData = sheetData;
		this.jiraProcess = jiraProcessStatus;
		this.driver = driver;
	}
	
	@Override
	public String call() throws Exception
	{
		System.out.println("SEO Tag validation Process started");

		try
		{
		this.tagsLocator = new TagsLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
			
			  case "IBM_PartnerPage": IBM_PartnerPage(row.get(1)); break;
			  case "IBM_PartnerPage_Programs": IBM_PartnerPage_Programs(); break;
			  case "IBM_PartnerPage_Courses": IBM_PartnerPage_Courses(); break;
				
				  case "Microsoft_PartnerPage": Microsoft_PartnerPage(row.get(1)); break; 
				  case "Microsoft_PartnerPage_Programs": Microsoft_PartnerPage_Programs(); break;
				  case "Microsoft_PartnerPage_Courses": Microsoft_PartnerPage_Courses(); break;
				  case
				  "GoogleCloud_PartnerPage": GoogleCloud_PartnerPage(row.get(1)); break;
				  case "GoogleCloud_PartnerPage_Programs": GoogleCloud_PartnerPage_Programs(); break;
				  case "GoogleCloud_PartnerPage_Courses": GoogleCloud_PartnerPage_Courses(); break;
				  case
				  "PLU_PartnerPage": PLU_PartnerPage(row.get(1)); break;
				  case "PLU_PartnerPage_Programs": PLU_PartnerPage_Programs(); break;
				  case "PLU_PartnerPage_Courses": PLU_PartnerPage_Courses(); break;
				  case
				  "FutureSkill_PartnerPage": FutureSkill_PartnerPage(row.get(1)); break; 
				  case "FutureSkill_PartnerPage_Programs": FutureSkill_PartnerPage_Programs(); break;
				  case "FutureSkill_PartnerPage_Courses": FutureSkill_PartnerPage_Courses(); break;
				  case
				  "AI_CategoryPage": AI_CategoryPage(row.get(1)); break; 
				  case "AI_CategoryPage_Programs": AI_CategoryPage_Programs(); break;
				  case "AI_CategoryPage_Courses": AI_CategoryPage_Courses(); break;
				  case
				  "Azure_CategoryPage": Azure_CategoryPage(row.get(1)); break; 
				  case "AI_CategoryPage_Programs": Azure_CategoryPage_Programs(); break;
				  case "AI_CategoryPage_Courses": Azure_CategoryPage_Courses(); break;
				  case
				  "BigData_CategoryPage": BigData_CategoryPage(row.get(1)); break; 
				  case "BigData_CategoryPage_Programs": BigData_CategoryPage_Programs(); break;
				  case "BigData_CategoryPage_Courses": BigData_CategoryPage_Courses(); break;
				  case
				  "Blockchain_CategoryPage": Blockchain_CategoryPage(row.get(1)); break;
				  case "Blockchain_CategoryPage_Programs": Blockchain_CategoryPage_Programs(); break;
				  case "Blockchain_CategoryPage_Courses": Blockchain_CategoryPage_Courses(); break;
				  case
				  "BusinessApplication_CategoryPage":
				  BusinessApplication_CategoryPage(row.get(1)); break; 
				  case "BusinessApplication_CategoryPage_Programs": BusinessApplication_CategoryPage_Programs(); break;
				  case "BusinessApplication_CategoryPage_Courses": BusinessApplication_CategoryPage_Courses(); break;
				  case
				  "CloudComputing_CategoryPage": CloudComputing_CategoryPage(row.get(1));
				  break;
				  case "CloudComputing_CategoryPage_Programs": CloudComputing_CategoryPage_Programs(); break;
				  case "CloudComputing_CategoryPage_Courses": CloudComputing_CategoryPage_Courses(); break;
				  case "CompliancePOSH_CategoryPage":
				  CompliancePOSH_CategoryPage(row.get(1)); break;
				  case "CompliancePOSH_CategoryPage_Programs": CompliancePOSH_CategoryPage_Programs(); break;
				  case "CompliancePOSH_CategoryPage_Courses": CompliancePOSH_CategoryPage_Courses(); break;
				  case "Cybersecurity_CategoryPage": Cybersecurity_CategoryPage(row.get(1));
				  break; 
				  case "Cybersecurity_CategoryPage_Programs": Cybersecurity_CategoryPage_Programs(); break;
				  case "Cybersecurity_CategoryPage_Courses": Cybersecurity_CategoryPage_Courses(); break;
				  case "DataAnalytics_CategoryPage":
				  DataAnalytics_CategoryPage(row.get(1)); break;
				  case "DataAnalytics_CategoryPage_Programs": DataAnalytics_CategoryPage_Programs(); break;
				  case "DataAnalytics_CategoryPage_Courses": DataAnalytics_CategoryPage_Courses(); break;
				  case "IOT_CategoryPage":
				  IOT_CategoryPage(row.get(1)); break; 
				  case "IOT_CategoryPage_Programs": IOT_CategoryPage_Programs(); break;
				  case "IOT_CategoryPage_Courses": IOT_CategoryPage_Courses(); break;
				  case "HumanSkills_CategoryPage":
				  HumanSkills_CategoryPage(row.get(1)); break; 
				  case "HumanSkills_CategoryPage_Programs": HumanSkills_CategoryPage_Programs(); break;
				  case "HumanSkills_CategoryPage_Courses": HumanSkills_CategoryPage_Courses(); break;
				  case "DataScience_CategoryPage":
				  DataScience_CategoryPage(row.get(1)); break; 
				  case "DataScience_CategoryPage_Programs": DataScience_CategoryPage_Programs(); break;
				  case "DataScience_CategoryPage_Courses": DataScience_CategoryPage_Courses(); break;
				  case "Devops_CategoryPage":
				  DevOps_CategoryPage(row.get(1)); break; 
				  case "DevOps_CategoryPage_Programs": DevOps_CategoryPage_Programs(); break;
				  case "DevOps_CategoryPage_Courses": DevOps_CategoryPage_Courses(); break;
				  case "ModernWorkplace_CategoryPage":
				  ModernWorkplace_CategoryPage(row.get(1)); break; 
				  case "ModernWorkplace_CategoryPage_Programs": ModernWorkplace_CategoryPage_Programs(); break;
				  case "ModernWorkplace_CategoryPage_Courses": ModernWorkplace_CategoryPage_Courses(); break;
				  case "PowerBI_CategoryPage":
				  PowerBI_CategoryPage(row.get(1)); break; 
				  case "PowerBI_CategoryPage_Programs": PowerBI_CategoryPage_Programs(); break;
				  case "PowerBI_CategoryPage_Courses": PowerBI_CategoryPage_Courses(); break;
				  case "PowerPlatform_CategoryPage":
				  PowerPlatform_CategoryPage(row.get(1)); break; 
				  case "PowerPlatform_CategoryPage_Programs": PowerPlatform_CategoryPage_Programs(); break;
				  case "PowerPlatform_CategoryPage_Courses": PowerPlatform_CategoryPage_Courses(); break;
				  case
				  "Productivity_CategoryPage": Productivity_CategoryPage(row.get(1)); break;
				  case "Productivity_CategoryPage_Programs": Productivity_CategoryPage_Programs(); break;
				  case "Productivity_CategoryPage_Courses": Productivity_CategoryPage_Courses(); break;
				 
					
			}
		}
		
		
		if(jiraProcess.contains("Yes"))
		{
			HashMap<String, String> resultStatus = new HashMap<String, String>();
			ArrayList<String> sheetRow = sheetData.get(1);
			String getExecutionStatus = "";
			String getprocessStatus = "";
			JiraTicketStatusUpdate jiraTicketStatusUpdate = new JiraTicketStatusUpdate();
			
			if(sheetStatus == "fail")
			{
				getExecutionStatus = "FAIL";
				resultStatus.put(sheetRow.get(1), getExecutionStatus);
				getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
				System.out.println(getprocessStatus);
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ProgramURLandSlug").get(1).add(2, (getExecutionStatus + "failed"));
			}
			else
			{
				getExecutionStatus = "PASS";
				resultStatus.put(sheetRow.get(1), getExecutionStatus);
				getprocessStatus = jiraTicketStatusUpdate.updateStatus(getExecutionStatus);
				System.out.println(getprocessStatus);
				
			}
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
    }
	
	public void IBM_PartnerPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkIBM_PartnerPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(1).add(i+2, (status.get(i) + "HomePage - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void IBM_PartnerPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkIBM_Partner_Programs();
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(2).add(i+1, (status.get(i) + "HomePage - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void IBM_PartnerPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkIBM_Partner_Courses();
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(3).add(i+1, (status.get(i) + "HomePage - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void PLU_PartnerPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkPLU_PartnerPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(4).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void FutureSkill_PartnerPage(String data)
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkFutureSkill_PartnerPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(5).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
			
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void Microsoft_PartnerPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkMicrosoft_PartnerPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(2).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Microsoft_PartnerPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkMicrosoft_PartnerPage_Programs();
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(2).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Microsoft_PartnerPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkMicrosoft_PartnerPage_Courses();
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(2).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GoogleCloud_PartnerPage(String data) 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkGoogleCloud_PartnerPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(3).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void GoogleCloud_PartnerPage_Programs(String data) 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkGoogleCloud_PartnerPage_Programs(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(3).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void GoogleCloud_PartnerPage_Courses(String data) 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkGoogleCloud_PartnerPage_Courses(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(3).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	
	public void AI_CategoryPage(String data)
	{
		try
		{
			ArrayList<String> status = tagsLocator.AI_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(6).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void AI_CategoryPage_Programs() {
		try {

			ArrayList<String> status = tagsLocator.checkAI_CategoryPage_Programs();
			if (status.size() > 0) {
				for (int i = 0; i < status.size(); i++) {
					sheetStatus = "Fail";
					// com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(6).add(i+2,
					// (status.get(i) + "TagsVerification - failed"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void AI_CategoryPage_Programs() {
		try {

			ArrayList<String> status = tagsLocator.checkAI_CategoryPage_Courses();
			if (status.size() > 0) {
				for (int i = 0; i < status.size(); i++) {
					sheetStatus = "Fail";
					// com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(6).add(i+2,
					// (status.get(i) + "TagsVerification - failed"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Azure_CategoryPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkAzure_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(9).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void BigData_CategoryPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkBigData_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(12).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Blockchain_CategoryPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkBlockchain_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(15).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void BusinessApplication_CategoryPage(String data)
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkBusinessApplication_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(18).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
			
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}

	public void CloudComputing_CategoryPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkCloudComputing_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(21).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CompliancePOSH_CategoryPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkCompliancePOSH_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(24).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Cybersecurity_CategoryPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkCybersecurity_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(27).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void DataAnalytics_CategoryPage(String data) 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDataAnalytics_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(30).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DataScience_CategoryPage(String data) 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDataScience_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(33).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}

	public void DevOps_CategoryPage(String data) 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDevOps_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(36).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void HumanSkills_CategoryPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkHumanSkills_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(39).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void IOT_CategoryPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkIOT_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(42).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}

	public void ModernWorkplace_CategoryPage(String data) 
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkModernWorkplace_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(45).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PowerBI_CategoryPage(String data) 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkPowerBI_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(48).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}

	public void PowerPlatform_CategoryPage(String data) 
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkPowerPlatform_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(51).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Productivity_CategoryPage(String data) 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkProductivity_CategoryPage(data);
			if(status.size()>0)
			{
				for (int i = 0; i < status.size(); i++)
				{
					sheetStatus = "Fail";
					com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TagsVerification").get(54).add(i+2, (status.get(i) + "TagsVerification - failed"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}