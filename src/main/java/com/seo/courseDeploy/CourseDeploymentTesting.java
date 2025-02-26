package com.seo.courseDeploy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.regression.utility.ProcessExcel;
import com.regression.utility.Utils;
import com.seo.regression.testing.OpenWebsite;
import com.seo.regression.testing.RegressionTestLogin;

public class CourseDeploymentTesting 
{
	String CURRENT_SHEET = "";
	int CURRENT_ROW = 0;
	String startTime = "";
	String endTime = "";
	String duration = "";
	
	public static LinkedHashMap<String, ArrayList<ArrayList<String>>> EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP;
	private HashMap<String, String> sheetsResult = new HashMap<String, String>();
	public static String ENV_TO_USE = "";
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browserName) throws Exception
	{
		System.out.println("welcome");
	    if (browserName.equalsIgnoreCase("Firefox"))
	    {
	    	driver = OpenWebsite.openDriver(browserName);
	    }
	    else if (browserName.equalsIgnoreCase("Chrome"))
	    {
	    	driver = OpenWebsite.openDriver(browserName);
	    }
	    else
	    {
	    	throw new Exception("Browser is not correct");
	    }
	}
	
	@Test
	public void startTest()
	{
		System.out.println(driver);
		this.startTesting();
		driver.quit();
	}
	
	public void startTesting()
	{
		String excelPath = "D:\\Doc\\CourseDeploySheet.xlsx";
		EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP = new LinkedHashMap<String, ArrayList<ArrayList<String>>>();
		startTime = new SimpleDateFormat(Utils.DEFAULT_DATA_FORMAT).format(Calendar.getInstance().getTime());
		try
		{
			LinkedHashMap<String, ArrayList<ArrayList<String>>> data = ProcessExcel.readExcelFileAsRows(excelPath);
			EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP = ProcessExcel.readExcelFileAsRows(excelPath);
			
			ArrayList<ArrayList<String>> master = data.get("Master");// Master sheet in excel
			ArrayList<String> environment = master.get(1);// Environment row in excel
			ENV_TO_USE = environment.get(1);//Use envToUse appropriately
			ArrayList<String> browser = master.get(1);
			ArrayList<String> pages = master.get(0);// Pages row in excel
			for(int j = 0; j < pages.size(); j++)// iterating the pages row
			{
				String sheetName = pages.get(j);// getting the cell values of pages row eg. Pages, Login-ignore, ErrorCodeValidation, etc,.
				if(data.containsKey(sheetName))// checking whether the excel is having the sheet
				{
					ArrayList<ArrayList<String>> sheetData = data.get(sheetName);// reading the sheet data
					try
					{
						String sheetStatus = "Pass";
						//Get Started
						switch(sheetName)
						{
							case "Login":
								sheetStatus = new RegressionTestLogin(driver, sheetData).start();
							break;
							default:
								System.out.println("Not class found to work with the sheet");
						}
						sheetsResult.put(sheetName, sheetStatus);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			endTime = new SimpleDateFormat(Utils.DEFAULT_DATA_FORMAT).format(Calendar.getInstance().getTime());
			duration = Utils.findDifference(startTime, endTime);
			prepareConsolidatedSheet();
			ProcessExcel.writeExcelFileAsRows(EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP, "D:\\", "result.xlsx");
		}
	}
		private void prepareConsolidatedSheet() 
		{
			ArrayList<ArrayList<String>> consolidatedSheedData = new ArrayList<ArrayList<String>>();

			ArrayList<String> testEnvRow = new ArrayList<>();
			testEnvRow.add("Test environment" + Utils.DELIMITTER + "bold" + Utils.DELIMITTER + "backgroundlime"
					+ Utils.DELIMITTER + "border");
			testEnvRow.add(ENV_TO_USE + Utils.DELIMITTER + "backgroundLT" + Utils.DELIMITTER
					+ "border");

			ArrayList<String> executionStartsOn = new ArrayList<>();
			executionStartsOn.add("Test execution starts on" + Utils.DELIMITTER + "bold" + Utils.DELIMITTER
					+ "backgroundlime" + Utils.DELIMITTER + "border");
			executionStartsOn.add(startTime + Utils.DELIMITTER + "backgroundLT" + Utils.DELIMITTER + "border");

			ArrayList<String> executionEndsOn = new ArrayList<>();
			executionEndsOn.add("Test execution ends on" + Utils.DELIMITTER + "bold" + Utils.DELIMITTER
					+ "backgroundlime" + Utils.DELIMITTER + "border");
			executionEndsOn.add(endTime + Utils.DELIMITTER + "backgroundLT" + Utils.DELIMITTER + "border");

			ArrayList<String> executionDuration = new ArrayList<>();
			executionDuration.add("Execution time" + Utils.DELIMITTER + "bold" + Utils.DELIMITTER
					+ "backgroundlime" + Utils.DELIMITTER + "border");
			executionDuration.add(duration + Utils.DELIMITTER + "backgroundLT" + Utils.DELIMITTER + "border");

			ArrayList<String> emptyRow = new ArrayList<>();
			emptyRow.add("");

			ArrayList<String> courseResultHeader = new ArrayList<>();
			courseResultHeader.add("Courses" + Utils.DELIMITTER + "bold" + Utils.DELIMITTER + "backgroundLT"
					+ Utils.DELIMITTER + "border");
			courseResultHeader.add("Result" + Utils.DELIMITTER + "bold" + Utils.DELIMITTER + "backgroundLT"
					+ Utils.DELIMITTER + "border");

			consolidatedSheedData.add(testEnvRow);
			consolidatedSheedData.add(executionStartsOn);
			consolidatedSheedData.add(executionEndsOn);
			consolidatedSheedData.add(executionDuration);
			consolidatedSheedData.add(emptyRow);
			consolidatedSheedData.add(courseResultHeader);
			boolean hasFailedSheets = false;
			for (Entry<String, String> entry : sheetsResult.entrySet()) {
				String sheetName = entry.getKey();
				String sheetStatus = entry.getValue();
				ArrayList<String> sheetResult = new ArrayList<String>();
				sheetResult.add(sheetName + Utils.DELIMITTER + "backgroundlime" + Utils.DELIMITTER + "border");

				if (sheetStatus.equalsIgnoreCase("Fail")) {
					hasFailedSheets = true;
				}

				sheetResult.add(sheetStatus + Utils.DELIMITTER + "color"
						+ (sheetStatus.equalsIgnoreCase("Pass") ? "Green" : "Red") + Utils.DELIMITTER
						+ "backgroundlime" + Utils.DELIMITTER + "border");

				consolidatedSheedData.add(sheetResult);
			}
			EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.put(
					"Consolidated Result" + Utils.DELIMITTER + (hasFailedSheets ? "red" : "green"),
					consolidatedSheedData);
		}
		
}
