package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class TNSDC_Phase2Validation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	TNSDC_Phase2Locator checkTNSDC_Phase2Locator;
	String sheetStatus = "Pass";

	public TNSDC_Phase2Validation(ArrayList<ArrayList<String>> sheetData) {
		this.sheetData = sheetData;
	}

	public WebDriver openDriver(String browserName) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", RegressionTesting.driverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Hemamalini\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		}
		return driver;
	}

	@Override
	public String call() throws Exception {
		System.out.println("TNSDC phase 2 verification");

		try {
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			this.checkTNSDC_Phase2Locator = new TNSDC_Phase2Locator(driver);
			for (int i = 0; i < this.sheetData.size(); i++) {
				ArrayList<String> row = this.sheetData.get(i);
				String firstColumn = row.get(0);
				switch (firstColumn){
				case "login":
					verifylogin(row.get(1), row.get(2));
					break;
				case "MentorDashoardPage":
					verifyMentorDashoardPage(row.get(1));
					break;
				
				/*
				 * case"CourseAssignment_PendingAssignment":
				 * CourseAssignment_PendingAssignment(row); break;
				 */
				  
				  case "CourseAssignment_AssignedStudent":
					CourseAssignment_AssignedStudent(row);
					break;
				case "TeamAllocation":
					TeamAllocation(row);
					break;
				}
			}

			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheetStatus;
	}

	public void verifylogin(String username, String password) {
		String status = checkTNSDC_Phase2Locator.verifyloginPage(username, password);
		if (status.contains("fail")) {
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(0).set(0, "TNSDC_1 - failed");
		}

	}

	public void verifyMentorDashoardPage(String url) {
		String status = checkTNSDC_Phase2Locator.verifyURL(url);
		if (status.contains("fail")) {
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_1").get(1).set(0, "TNSDC_1 - failed");
		}
	}

	public void CourseAssignment_PendingAssignment(ArrayList<String> data) {
		ArrayList<String> status = checkTNSDC_Phase2Locator.verifyCourseAssignment_PendingAssignment(data);
		if (status.contains("fail")) {
			if (status.contains("StudentscountFail")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(2).set(1,
						"TNSDC_2 - failed");
			} else if (status.contains("issue in Studentscount")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(2).add(1,
						("issue in Studentscount" + "failed"));

			} else if (status.contains("searchDataFail")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(2).set(2,
						"TNSDC_2	 - failed");

			} else if (status.contains("Issue in searchData")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(2).add(2,
						"TNSDC_2	 - failed");

			} else if (status.contains("ForwardBackwardFail")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(2).set(3,
						"TNSDC_2 - failed");

			} else if (status.contains("Issue in ForwardBackward")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(2).add(3,
						"TNSDC_2	 - failed");

			} else if (status.contains("AssignToCourseFail")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(2).set(4,
						"TNSDC_2 - failed");
			} else if (status.contains("Issue in AssignToCourse")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(2).add(4,
						"TNSDC_2 - failed");
			}
		} else if (status.contains("issue")) {
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(2).set(0, "TNSDC_2 - failed");

		}

	}

	public void CourseAssignment_AssignedStudent(ArrayList<String> data) {
		ArrayList<String> status = checkTNSDC_Phase2Locator.verifyCourseAssignment_AssignedStudent(data);
		if (status.contains("fail")) {
			if (status.contains("Issue in students")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(3).set(1,
						"TNSDC_2 - failed");
			} else if (status.contains("Issue in studentsRecord")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(3).add(1,
						("issue in Studentscount" + "failed"));

			} else if (status.contains("Issue in SelectStudent")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(3).set(3,
						"TNSDC_2	 - failed");

			} else if (status.contains("Issue in SelectCourse")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(3).set(4,
						"TNSDC_2	 - failed");

			} else if (status.contains("Issue in ReAssign")) {
				sheetStatus = "Fail";
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(3).set(5,
						"TNSDC_2	 - failed");

			}
		} else if (status.contains("issue")) {
			sheetStatus = "Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("TNSDC_2").get(3).set(0, "TNSDC_2 - failed");

		}

	}

	public void TeamAllocation(ArrayList<String> data) {
		ArrayList<String> status = checkTNSDC_Phase2Locator.verifyTeamAllocation(data);

	}
}
