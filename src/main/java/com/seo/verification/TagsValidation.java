package com.seo.verification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;

import com.palm.regressionTesting.JiraTicketStatusUpdate;
import com.palm.regressionTesting.RegressionTesting;

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
			
			/*
			 * case "IBM_PartnerPage": IBM_PartnerPage(row.get(1)); break;
			 * 
			 * case "IBM_PartnerPage_Programs": IBM_PartnerPage_Programs(); break;
			 * 
			 * case "IBM_PartnerPage_Courses": IBM_PartnerPage_Courses(); break;
			 */
				
			/*
			 * case "Microsoft_PartnerPage": Microsoft_PartnerPage(row.get(1)); break;
			 * 
			 * case "Microsoft_PartnerPage_Programs": Microsoft_PartnerPage_Programs();
			 * break;
			 * 
			 * case "Microsoft_PartnerPage_Courses": Microsoft_PartnerPage_Courses(); break;
			 */
			  
			  case  "GoogleCloud_PartnerPage": GoogleCloud_PartnerPage(row.get(1)); break;
				/*
				 * case "GoogleCloud_PartnerPage_Programs": GoogleCloud_PartnerPage_Programs();
				 * break; case "GoogleCloud_PartnerPage_Courses":
				 * GoogleCloud_PartnerPage_Courses(); break;
				 */
			  case  "PLU_PartnerPage": PLU_PartnerPage(row.get(1)); break;
				/*
				 * case "PLU_PartnerPage_Programs": PLU_PartnerPage_Programs(); break; case
				 * "PLU_PartnerPage_Courses": PLU_PartnerPage_Courses(); break;
				 */
			  case  "FutureSkill_PartnerPage": FutureSkill_PartnerPage(row.get(1)); break; 
			  
			  case "FutureSkill_PartnerPage_Programs": FutureSkill_PartnerPage_Programs(); break;
			  
			  case "FutureSkill_PartnerPage_Courses": FutureSkill_PartnerPage_Courses(); break;
			  
			  case "AI_CategoryPage": AI_CategoryPage(row.get(1)); break; 
			  
			  case "AI_CategoryPage_Programs": AI_CategoryPage_Programs(); break;
			  
			  case "AI_CategoryPage_Courses": AI_CategoryPage_Courses(); break;
			  
			  case  "Azure_CategoryPage": Azure_CategoryPage(row.get(1)); break; 
				  
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
				  
				/*
				 * case "CompliancePOSH_CategoryPage_Programs":
				 * CompliancePOSH_CategoryPage_Programs(); break;
				 * 
				 * case "CompliancePOSH_CategoryPage_Courses":
				 * CompliancePOSH_CategoryPage_Courses(); break;
				 */
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
	public void updateExcelData(ArrayList<String> status, int rowIndex) 
	{
	    try 
	    {
	        if (status.size() > 0)
	        {
	            sheetStatus = "Fail"; // Set status to Fail if there are errors
	            Map<String, ArrayList<ArrayList<String>>> excelData = com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP;
	            
	            
	            if (!excelData.containsKey("TagsVerification")) {
	                excelData.put("TagsVerification", new ArrayList<>());
	            }
	            
	            List<ArrayList<String>> sheetData = excelData.get("TagsVerification");
	            
	            while (sheetData.size() <= rowIndex) {
	                sheetData.add(new ArrayList<>());  // Add new rows if missing
	            }

	            List<String> rowData = sheetData.get(rowIndex);

	            // **Ensure row has at least 16 columns**
	            
	            
	            for (int i = 0; i < status.size(); i++) { // Loop through issues
	                String issue = status.get(i);

	                // Define column mappings for each issue
	                int columnIndex = -1;
	                if (issue.contains("H1")) columnIndex = 2;
	                if (issue.contains("canonical")) columnIndex = 3;
	                if (issue.contains("ogURLInfo")) columnIndex = 5;
	                if (issue.contains("ogTypeInfo")) columnIndex = 4;
	                if (issue.contains("ogTitleInfo")) columnIndex = 7;
	                if (issue.contains("ogDesciptionInfo")) columnIndex = 6;
	                if (issue.contains("ogImageInfo")) columnIndex = 8;
	                if (issue.contains("twitterURLInfo")) columnIndex = 10;
	                if (issue.contains("twitterCardInfo")) columnIndex = 9;
	                if (issue.contains("twitterTitleInfo")) columnIndex = 13;
	                if (issue.contains("twitterDescriptionInfo")) columnIndex = 12;
	                if (issue.contains("twitterImageInfo")) columnIndex = 13;
	                if (issue.contains("twitterTypeInfo")) columnIndex = 11;
	                if (issue.contains("CourseSchema")) columnIndex = 14;
	                if (issue.contains("faq")) columnIndex = 15;
	                
	                while (rowData.size() <= columnIndex) {  
	                    rowData.add("");  // Ensure column exists
	                }

	                // Update the value at column 15 safely
	                rowData.set(columnIndex, rowData.get(columnIndex) + "; " + issue + " - failed");
	                }
	            }
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	String existingData = "";
	public void IBM_PartnerPage(String data)
	{
		try
		{
			/*
			 * ArrayList<String> status = tagsLocator.checkIBM_PartnerPage(data);
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(1).add(i+2, (status.get(i) + " - failed")); } }
			 */
			ArrayList<String> status = tagsLocator.checkIBM_PartnerPage(data);
		    updateExcelData(status, 1); 
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void IBM_PartnerPage_Programs()
	{
		try
		{
			
			/*
			 * ArrayList<String> status = tagsLocator.checkIBM_Partner_Programs();
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(2).add(i+1, (status.get(i) + " - failed")); } }
			 */
			ArrayList<String> status = tagsLocator.checkIBM_Partner_Programs();
		    updateExcelData(status, 2); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void IBM_PartnerPage_Courses()
	{
		try
		{
			
			/*
			 * ArrayList<String> status = tagsLocator.checkIBM_Partner_Courses();
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(3).add(i+1, (status.get(i) + " - failed")); } }
			 */
			ArrayList<String> status = tagsLocator.checkIBM_Partner_Courses();
		    updateExcelData(status, 3); 
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
			updateExcelData(status, 10); 
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(4).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void PLU_PartnerPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkPLU_PartnerPage_Programs();
			updateExcelData(status, 11);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(4).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void PLU_PartnerPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkPLU_PartnerPage_Courses();
			updateExcelData(status, 12);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(4).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 13);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(13).add(i+2, (status.get(i) + " - failed")); } }
			 */
			
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void FutureSkill_PartnerPage_Programs()
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkFutureSkill_PartnerPage_Programs();
			updateExcelData(status, 14);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(14).add(i+1, (status.get(i) + " - failed")); } }
			 */
			
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void FutureSkill_PartnerPage_Courses()
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkFutureSkill_PartnerPage_Courses();
			updateExcelData(status, 15);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(15).add(i+1, (status.get(i) + " - failed")); } }
			 */
			
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
			updateExcelData(status, 4);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(4).add(i+2, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 5);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(5).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 6);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(6).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 7);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(7).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void GoogleCloud_PartnerPage_Programs() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkGoogleCloud_PartnerPage_Programs();
			updateExcelData(status, 8);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(8).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void GoogleCloud_PartnerPage_Courses() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkGoogleCloud_PartnerPage_Courses();
			updateExcelData(status, 9);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(9).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 16);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(16).add(i+2, (status.get(i) + " - failed")); } }
			 */
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void AI_CategoryPage_Programs() {
		try {

			ArrayList<String> status = tagsLocator.checkAI_CategoryPage_Programs();
			updateExcelData(status, 17);
			/*
			 * if (status.size() > 0) {
			 * 
			 * for (int i = 0; i < status.size(); i++) { sheetStatus = "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(17).add(i+1, (status.get(i) + " - failed")); } }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void AI_CategoryPage_Courses() {
		try {

			ArrayList<String> status = tagsLocator.checkAI_CategoryPage_Courses();
			updateExcelData(status, 18);
			/*
			 * if (status.size() > 0) { for (int i = 0; i < status.size(); i++) {
			 * sheetStatus = "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(18).add(i+1, (status.get(i) + " - failed")); } }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Azure_CategoryPage(String data)
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkAzure_CategoryPage(data);
			updateExcelData(status, 19);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(19).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Azure_CategoryPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkAzure_CategoryPage_Programs();
			updateExcelData(status, 20);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(20).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Azure_CategoryPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkAzure_CategoryPage_Courses();
			updateExcelData(status, 21);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(21).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 22);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(22).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void BigData_CategoryPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkBigData_CategoryPage_Programs();
			updateExcelData(status, 23);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(23).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void BigData_CategoryPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkBigData_CategoryPage_Courses();
			updateExcelData(status, 24);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(24).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 25);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(25).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Blockchain_CategoryPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkBlockchain_CategoryPage_Programs();
			updateExcelData(status, 26);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(26).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Blockchain_CategoryPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkBlockchain_CategoryPage_Courses();
			updateExcelData(status, 27);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(27).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 28);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(28).add(i+2, (status.get(i) + " - failed")); } }
			 */
			
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void BusinessApplication_CategoryPage_Programs()
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkBusinessApplication_CategoryPage_Programs();
			updateExcelData(status, 29);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(29).add(i+1, (status.get(i) + " - failed")); } }
			 */
			
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void BusinessApplication_CategoryPage_Courses()
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkBusinessApplication_CategoryPage_Courses();
			updateExcelData(status, 30);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(30).add(i+1, (status.get(i) + " - failed")); } }
			 */
			
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
			updateExcelData(status, 31);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(31).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void CloudComputing_CategoryPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkCloudComputing_CategoryPage_Programs();
			updateExcelData(status, 32);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(32).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void CloudComputing_CategoryPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkCloudComputing_CategoryPage_Courses();
			updateExcelData(status, 33);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(33).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 34);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(34).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CompliancePOSH_CategoryPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkCompliancePOSH_CategoryPage_Programs();
			updateExcelData(status, 35);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(35).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void CompliancePOSH_CategoryPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkCompliancePOSH_CategoryPage_Courses();
			updateExcelData(status, 36);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(36).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 37);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(37).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Cybersecurity_CategoryPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkCybersecurity_CategoryPage_Programs();
			updateExcelData(status, 38);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(38).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Cybersecurity_CategoryPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkCybersecurity_CategoryPage_Courses();
			updateExcelData(status, 39);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(39).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 40);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(40).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DataAnalytics_CategoryPage_Programs() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDataAnalytics_CategoryPage_Programs();
			updateExcelData(status, 41);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(41).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DataAnalytics_CategoryPage_Courses() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDataAnalytics_CategoryPage_Courses();
			updateExcelData(status, 42);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(42).add(i+1, (status.get(i) + " - failed")); } }
			 */		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DataScience_CategoryPage(String data) 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDataScience_CategoryPage(data);
			updateExcelData(status, 43);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(43).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void DataScience_CategoryPage_Programs() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDataScience_CategoryPage_Programs();
			updateExcelData(status, 44);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(44).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void DataScience_CategoryPage_Courses() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDataScience_CategoryPage_Courses();
			updateExcelData(status, 45);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(45).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 46);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(46).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DevOps_CategoryPage_Programs() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDevOps_CategoryPage_Programs();
			updateExcelData(status, 47);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(47).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DevOps_CategoryPage_Courses() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkDevOps_CategoryPage_Courses();
			updateExcelData(status, 48);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(48).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 49);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(49).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void HumanSkills_CategoryPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkHumanSkills_CategoryPage_Programs();
			updateExcelData(status, 50);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(50).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void HumanSkills_CategoryPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkHumanSkills_CategoryPage_Courses();
			updateExcelData(status, 51);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(51).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 52);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(52).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void IOT_CategoryPage_Programs()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkIOT_CategoryPage_Programs();
			updateExcelData(status, 53);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(53).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void IOT_CategoryPage_Courses()
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkIOT_CategoryPage_Courses();
			updateExcelData(status, 54);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(54).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 55);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(55).add(i+2, (status.get(i) + " - failed")); } }
			 */
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ModernWorkplace_CategoryPage_Programs() 
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkModernWorkplace_CategoryPage_Programs();
			updateExcelData(status, 56);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(56).add(i+1, (status.get(i) + " - failed")); } }
			 */
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void ModernWorkplace_CategoryPage_Courses() 
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkModernWorkplace_CategoryPage_Courses();
			updateExcelData(status, 57);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(57).add(i+1, (status.get(i) + " - failed")); } }
			 */
			
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
			updateExcelData(status, 58);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(58).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void PowerBI_CategoryPage_Programs() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkPowerBI_CategoryPage_Programs();
			updateExcelData(status, 59);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(59).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
            e.printStackTrace();
		}
	}
	public void PowerBI_CategoryPage_Courses() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkPowerBI_CategoryPage_Courses();
			updateExcelData(status, 60);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(60).add(i+1, (status.get(i) + " - failed")); } }
			 */
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
			updateExcelData(status, 61);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(61).add(i+2, (status.get(i) + " - failed")); } }
			 */
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void PowerPlatform_CategoryPage_Programs() 
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkPowerPlatform_CategoryPage_Programs();
			updateExcelData(status, 62);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(62).add(i+1, (status.get(i) + " - failed")); } }
			 */
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void PowerPlatform_CategoryPage_Courses() 
	{
		try
		{
			ArrayList<String> status = tagsLocator.checkPowerPlatform_CategoryPage_Courses();
			updateExcelData(status, 63);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(63).add(i+1, (status.get(i) + " - failed")); } }
			 */
			
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
			updateExcelData(status, 64);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(64).add(i+2, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Productivity_CategoryPage_Programs() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkProductivity_CategoryPage_Programs();
			updateExcelData(status, 65);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(65).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void Productivity_CategoryPage_Courses() 
	{
		try
		{
			
			ArrayList<String> status = tagsLocator.checkProductivity_CategoryPage_Courses();
			updateExcelData(status, 66);
			/*
			 * if(status.size()>0) { for (int i = 0; i < status.size(); i++) { sheetStatus =
			 * "Fail";
			 * com.seo.verification.RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP
			 * .get("TagsVerification").get(66).add(i+1, (status.get(i) + " - failed")); } }
			 */
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}