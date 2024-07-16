package com.palm.sanityTesting;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.palm.regressionTesting.RegressionTestLogin;
import com.regression.utility.ProcessExcel;
import com.regression.utility.Utils;

public class RegressionTesting 
{
	String CURRENT_SHEET = "";
	int CURRENT_ROW = 0;
	String startTime = "";
	String endTime = "";
	String duration = "";
	
	public static LinkedHashMap<String, ArrayList<ArrayList<String>>> EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP;
	private HashMap<String, String> sheetsResult = new HashMap<String, String>();
	
	public static String ENV_TO_USE = "";
	String getEnvironment = "";
	WebDriver driver;
	public static String  driverPath = "C:\\Users\\Hemamalini\\Downloads\\125driver\\chromedriver-win64\\chromedriver.exe";
	
	@BeforeTest
	@Parameters({"browser","env"})
	public void setup(String browserName, String env) throws Exception
	{
		System.out.println("welcome");
	    if (browserName.equalsIgnoreCase("firefox"))
	    {
	    	driver = OpenWebsite.openDriver(browserName);
	    }
	    else if (browserName.equalsIgnoreCase("Chrome"))
	    {
	    	driver = OpenWebsite.openDriver(browserName);
	    	if(env.equalsIgnoreCase("stage"))
	    	{
	    		getEnvironment = "stage";
	    	}
	    	else if(env.equalsIgnoreCase("stage-in"))
	    	{
	    		getEnvironment = "stage-in";
	    	}
	    	else if(env.equalsIgnoreCase("prod-in"))
	    	{
	    		getEnvironment = "prod-in";
	    	}
	    	else if(env.equalsIgnoreCase("prod"))
	    	{
	    		getEnvironment = "prod";
	    	}
	    	else if(env.equalsIgnoreCase("dev-in"))
	    	{
	    		getEnvironment = "dev-in";
	    	}
	    	else if(env.equalsIgnoreCase("dev"))
	    	{
	    		getEnvironment = "dev";
	    	}
	    	else if(env.equalsIgnoreCase("qa-in"))
	    	{
	    		getEnvironment = "qa-in";
	    	}
	    	else if(env.equalsIgnoreCase("qa"))
	    	{
	    		getEnvironment = "qa";
	    	}
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
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		CompletionService<String> completionService = new ExecutorCompletionService<>(service);
		String excelPath = "D:\\Doc\\SanityTesting.xlsx";
		EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP = new LinkedHashMap<String, ArrayList<ArrayList<String>>>();
		startTime = new SimpleDateFormat(Utils.DEFAULT_DATA_FORMAT).format(Calendar.getInstance().getTime());
		try
		{
			LinkedHashMap<String, ArrayList<ArrayList<String>>> data = ProcessExcel.readExcelFileAsRows(excelPath);
			EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP = ProcessExcel.readExcelFileAsRows(excelPath);
			
			ArrayList<ArrayList<String>> master = data.get("Master");// Master sheet in excel
			ArrayList<String> environment = master.get(1);// Environment row in excel
			if(master.get(1).toString().contains(getEnvironment))
			{
				ENV_TO_USE = environment.get(1);//Use envToUse appropriately
			}
			ENV_TO_USE = getEnvironment;
			ArrayList<String> pages = master.get(0);
			HashMap<String, Callable<String>> taskMap = new HashMap<String, Callable<String>>();
			for(int j = 0; j < pages.size(); j++)// iterating the pages row
			{
				String sheetName = pages.get(j);// getting the cell values of pages row eg. Pages, Login-ignore, ErrorCodeValidation, etc,.
				
				if (data.containsKey(sheetName))// checking whether the excel is having the sheet
				{
					ArrayList<ArrayList<String>> sheetData = data.get(sheetName);// reading the sheet data
					try
					{
						String sheetStatus = "Pass";
						switch(sheetName)
						{
							
							case "Login":
								taskMap.put(sheetName,  new RegressionTestLogin(sheetData));
								break;
							case "URLValidation":
								sheetStatus = new ErrorCodeValidation(sheetData, driver).start();
								break;
							case"SignUp":
								sheetStatus = new SignUpValidation(sheetData, driver).start();
								break;
							case"FooterSection":
								sheetStatus = new FooterSectionValidation(sheetData, driver).start();
								break;
							case"HeaderSection":
								sheetStatus = new HeaderSectionValidation(sheetData, driver).start();
								break;
							case"HomePage":
								sheetStatus = new HomePageValidator(driver, sheetName, sheetData).start();
								break;
							case "MicrosoftPage":
								sheetStatus =new MicrosoftCourseValidation(sheetData, driver).start();
								break;
							case "PLU":
								sheetStatus = new PLUValidation(sheetData, driver).start();
								break;
							case "LoginPageLinks":
								sheetStatus = new LoginPageLinksValidation(sheetData, driver).start();
								break;
							 case "IBM":
								 sheetStatus = new IBMPageValidation(sheetData, driver).start(); 
								 break;
							 case "Fluideducation":
								 sheetStatus = new FluidEducationValidation(sheetData, driver).start(); 
								 break;
							 case "GLX":
								 sheetStatus = new GLXValidation(sheetData, driver).start(); 
								 break;
							 case "SignUpPageLinks":
								 sheetStatus = new SignUpPageLinksValidation(sheetData, driver).start(); 
								 break;
							 case "HeaderFeature":
								 sheetStatus = new HeaderFeatureValidation(sheetData, driver).start(); 
								 break;
							 case "ReimbursedProcess":
								 sheetStatus = new ReimbursedValidation(sheetData, driver).start(); 
								 break;
							 case "OnboardingJourney":
								 sheetStatus = new OnboardingValidation(sheetData, driver).start(); 
								 break;
							 case "FutureSkill":
								 sheetStatus = new FutureSkillValidation(sheetData, driver).start(); 
								 break;
							 case "CategoryBanner":
								 sheetStatus = new CategoryBannerValidation(sheetData, driver).start(); 
								 break;
							 case "purchaseCourse":
								 sheetStatus = new PurchaseCourseValidation(sheetData, driver).start(); 
								 break;
							default:
								System.out.println("Not class found to work with the sheet");
						}//end of swtich case
						sheetsResult.put(sheetName, sheetStatus);//st
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
			// Map to store the results
	        // Create a list to keep the tasks in order
	        List<Map.Entry<String, Callable<String>>> taskList = new ArrayList<>(taskMap.entrySet());

	        // Submit the initial set of tasks up to the pool size (3)
	        int submittedTasks = 0;
	        for (int i = 0; i < Math.min(5, taskList.size()); i++)
	        {
	            Map.Entry<String, Callable<String>> entry = taskList.get(i);
	            completionService.submit(entry.getValue());
	            System.out.println("Submitting task: " + entry.getKey());
	            submittedTasks++;
	        }
	     // Process the tasks as they complete and submit new ones until all tasks are done
	        for (int i = 0; i < taskList.size(); i++)
	        {
	            try
	            {
	                Future<String> completedFuture = completionService.take(); // This will block until a task completes
	                String result = completedFuture.get();
	                System.out.println("Result: " + result); // Handle potential exceptions here
	                Map.Entry<String, Callable<String>> completedEntry = taskList.get(i);
	                sheetsResult.put(completedEntry.getKey(), result);

	                // Submit the next task if there are remaining tasks to be submitted
	                if (submittedTasks < taskList.size())
	                {
	                    Map.Entry<String, Callable<String>> nextEntry = taskList.get(submittedTasks);
	                    completionService.submit(nextEntry.getValue());
	                    System.out.println("Submitting task: " + nextEntry.getKey());
	                    submittedTasks++;
	                }
	                
	            } 
	            catch (Exception e)
	            {
	                e.printStackTrace();
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
			LocalDateTime currentDateTime = LocalDateTime.now();

	        // Define a custom date and time format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

	        // Format the current date and time using the formatter
	        String formattedDateTime = currentDateTime.format(formatter);
	        
			if (/*
				 * driver.getCurrentUrl().contains("stage-in")||driver.getCurrentUrl().contains(
				 * "stage-in")||
				 */ENV_TO_USE.contains("stage-in"))
			{
				ProcessExcel.writeExcelFileAsRows(EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP, "D:\\", "stage_in_result_" + formattedDateTime + ".xlsx");
			}
			else if (/* !driver.getCurrentUrl().contains("stage")|| */ENV_TO_USE.contains("stage"))
			{
				ProcessExcel.writeExcelFileAsRows(EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP, "D:\\", "prod_result_" + formattedDateTime + ".xlsx");
			}
			else if (/* !driver.getCurrentUrl().contains("qa-in")|| */ENV_TO_USE.contains("qa-in"))
			{
				ProcessExcel.writeExcelFileAsRows(EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP, "D:\\", "qa_India_result_" + formattedDateTime + ".xlsx");
			}
			else if (/* !driver.getCurrentUrl().contains("dev-in")|| */ENV_TO_USE.contains("dev-in"))
			{
				ProcessExcel.writeExcelFileAsRows(EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP, "D:\\", "dev_India_result_" + formattedDateTime + ".xlsx");
			}
			else if (/* !driver.getCurrentUrl().contains("dev-in")|| */ENV_TO_USE.contains("prod-in"))
			{
				ProcessExcel.writeExcelFileAsRows(EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP, "D:\\", "prodIndia_result_" + formattedDateTime + ".xlsx");
			}
			else if (/* !driver.getCurrentUrl().contains("dev-in")|| */ENV_TO_USE.contains("dev"))
			{
				ProcessExcel.writeExcelFileAsRows(EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP, "D:\\", "Dev_US_result_" + formattedDateTime + ".xlsx");
			}
			else if(/* !driver.getCurrentUrl().contains("dev-in")|| */ENV_TO_USE.contains("qa"))
			{
				ProcessExcel.writeExcelFileAsRows(EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP, "D:\\", "qa_US_result_" + formattedDateTime + ".xlsx");
			}
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
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
	    try
	 {
	    if(result.getStatus() == ITestResult.SUCCESS)
	    {

	        //Do something here
	        System.out.println("passed **********");
	    }

	    else if(result.getStatus() == ITestResult.FAILURE)
	    {
	         //Do something here
	        System.out.println("Failed ***********");
	    }

	     else if(result.getStatus() == ITestResult.SKIP ){

	        System.out.println("Skiped***********");

	    }
	}
	   catch(Exception e)
	   {
	     e.printStackTrace();
	   }

	}
}