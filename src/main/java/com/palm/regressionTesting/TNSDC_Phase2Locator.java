package com.palm.regressionTesting;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TNSDC_Phase2Locator
{
	WebDriver driver;
	ArrayList<String> studentData = new ArrayList<String>();
	public TNSDC_Phase2Locator(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public String verifyloginPage(String user, String pwd)
	{
		String result = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			WebElement clickLogin = driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]"));
			js.executeScript("arguments[0].scrollIntoView();", clickLogin);

			if(clickLogin.isDisplayed())
			{
				js.executeScript("arguments[0].click()", clickLogin);
				Set<String> windows = driver.getWindowHandles();
				for(String window : windows)
				{
					driver.switchTo().window(window);
					
					if(driver.getCurrentUrl().contains("login?"))
					{
						driver.switchTo().window(window);
						
						WebElement usernameLocator = driver.findElement(By.xpath("//input[@id='email']"));
						js.executeScript("arguments[0].scrollIntoView();", usernameLocator);
						usernameLocator.sendKeys(user);
						WebElement passwordLocator = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
						js.executeScript("arguments[0].scrollIntoView();", passwordLocator);
						passwordLocator.sendKeys(pwd);
						WebElement clickLoginIcon = driver.findElement(By.xpath("//input[@id='login_in']"));
						js.executeScript("arguments[0].scrollIntoView();", clickLoginIcon);
						js.executeScript("arguments[0].click()", clickLoginIcon);
						
					}
				}
				Set<String> allWindows = driver.getWindowHandles();
				for(String dashboardWindow : allWindows)
				{
					driver.switchTo().window(dashboardWindow);
					if(driver.getCurrentUrl().contains("dashboard"))
					{
						driver.switchTo().window(dashboardWindow);
						System.out.println("dashboard page");
					}
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public String verifyURL(String url)
	{
		String result = "";
		try
		{
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			String modifyURL = driver.getCurrentUrl();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			URL getUrl = new URL(modifyURL);
			String host = getUrl.getHost();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			driver.get("https://"+host+"/tnsdc-mentor/homepage/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			Thread.sleep(1000);
			System.out.println("TNSDC Phase 2 Mentor dashboard page ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<String> verifyCourseAssignment_PendingAssignment(ArrayList<String> data)
	{
		ArrayList<String> processStatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			try
			{
				WebElement courseAssignmentSectionLocator = driver.findElement(By.xpath("//li[contains(text(),'Course assignment')]"));
				js.executeScript("arguments[0].scrollIntoView();", courseAssignmentSectionLocator);
				if(courseAssignmentSectionLocator.isDisplayed())
				{
					js.executeScript("arguments[0].click()", courseAssignmentSectionLocator);
					WebElement checkCourseAssignmentPage = driver.findElement(By.xpath("//p[contains(text(),'Course Assignment')]"));
					js.executeScript("arguments[0].scrollIntoView();", checkCourseAssignmentPage);
					if(checkCourseAssignmentPage.isDisplayed())
					{
						System.out.println("course assignment page");
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue");
			}
			try
			{
				WebElement checkPendingAssignmentSection = driver.findElement(By.xpath("//p[contains(text(),'Pending Assignments')]"));
				js.executeScript("arguments[0].scrollIntoView();", checkPendingAssignmentSection);
				if(checkPendingAssignmentSection.isDisplayed())
				{
					js.executeScript("arguments[0].click()", checkPendingAssignmentSection);
					if(checkPendingAssignmentSection.isDisplayed())
					{
						System.out.println("pending Assignment section");
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue");
			}
			try
			{
				WebElement listOfTablesInput = driver.findElement(By.xpath("//select[@class='tableTnsdc_displayInput__18POl']"));
				js.executeScript("arguments[0].scrollIntoView();", listOfTablesInput);
				if(listOfTablesInput.isDisplayed())
				{
					//js.executeScript("arguments[0].click()", listOfTablesInput);
					Select selectDisplayCount = new Select(listOfTablesInput);
					List<WebElement> listOfDataFromDropDown = selectDisplayCount.getOptions();
					for(int i = 0; i < listOfDataFromDropDown.size(); i++)
					{
						String dropDownText = listOfDataFromDropDown.get(i).getText();//number of data to display on table
						selectDisplayCount.selectByVisibleText(dropDownText);
						int getcountValue = Integer.valueOf(dropDownText);
						List<WebElement> checkStudentDataFromTable = driver.findElements(By.xpath("//table[contains(@class,'tableTnsdc_containerTable')]//tbody/tr"));
						for(int j = 0; j < checkStudentDataFromTable.size(); j++)
						{
							//list of data displayed on Table
							int getStudentSize = checkStudentDataFromTable.size();
							if(getStudentSize <= getcountValue)
							{
								System.out.println("student records displayed correctly based on count");
								break;
							}
							else
							{
								processStatus.add("StudentscountFail");
							}
						}
					}
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("issue in Studentscount");
			}
			try
			{
				String getData[] = data.get(2).split("=");
				ArrayList<String> searchDataInfo = new ArrayList<String>();
				for(String info : getData)
				{
					if(info.contains("search"))
					{
						continue;
					}
					searchDataInfo.add(info);
				}
				
				WebElement searchField = driver.findElement(By.xpath("//input[contains(@class,'tableTnsdc_searchBar')]"));
				js.executeScript("arguments[0].scrollIntoView();", searchField);
				if(searchField.isDisplayed())
				{
					for(int k = 0; k < searchDataInfo.size(); k++)
					{
						searchField.sendKeys(searchDataInfo.get(k));
						if(driver.findElements(By.xpath("//tr[contains(@class,'tableTnsdc_bodyRowItem__kk0L4 tableTnsdc_bodyRowSelection')]/td")).size()>0)
						{
							System.out.println(searchDataInfo.get(k) + " : Is Present");
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
							searchField.clear();
						}
						else
						{
							System.out.println("search data not found");
							searchField.clear();
						}
						
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("Issue in searchData");
			}
			try
			{
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
				if(driver.findElements(By.xpath("//p[@id='next'][contains(@class,'Active')]")).size()>0)
				{
					WebElement checkNextPage = driver.findElement(By.xpath("//p[@id='next'][contains(@class,'Active')]"));
					js.executeScript("arguments[0].scrollIntoView();", checkNextPage);
					if(checkNextPage.isDisplayed())
					{
						js.executeScript("arguments[0].click()", checkNextPage);
						System.out.println("verifying Next Page button");
					}
				}
				else
				{
					System.out.println("next page is not enabled");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("Issue in ForwardBackward");
			}
			try
			{
				//search students and enable the student row
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			
				String getData[] = data.get(4).split("=");
				for(int i = 0; i < getData.length; i++)
				{
					if(getData[i].contains("students"))
					{
						continue;
					}
					studentData.add(getData[i]);
				}
				
				WebElement searchField = driver.findElement(By.xpath("//input[contains(@class,'tableTnsdc_searchBar')]"));
				js.executeScript("arguments[0].scrollIntoView();", searchField);
				if(searchField.isDisplayed())
				{
					for(int m = 0; m < studentData.size(); m++)
					{
						searchField.sendKeys(studentData.get(m));
						if(driver.findElements(By.xpath("//tr[contains(@class,'tableTnsdc_bodyRowItem__kk0L4 tableTnsdc_bodyRowSelection')]/td")).size()>0)
						{
							WebElement selectData = driver.findElement(By.xpath("//th[contains(@class,'tableTnsdc_headerRowItemSelect')]//img[@alt='table']"));
							//js.executeScript("arguments[0].scrolIntoView();", selectData);
							if(selectData.isDisplayed())
							{
								js.executeScript("arguments[0].click()", selectData);
								System.out.println("selecting students");
							}
						}
						else
						{
							System.out.println("search data not found");
							searchField.clear();
						}
					}
				}
				js.executeScript("arguments[0].scrollIntoView();", searchField);
				searchField.clear();
				WebElement AssignCourse = driver.findElement(By.xpath("//button[contains(text(),'Assign to Course')]"));
				js.executeScript("arguments[0].scrollIntoView();", AssignCourse);
				if(AssignCourse.isDisplayed())
				{
					js.executeScript("arguments[0].click()", AssignCourse);
					System.out.println("clicking Assign course button");
				}
				
				ArrayList<String> courseData = new ArrayList<String>();
				String getCourse[] = data.get(5).split("=");
				for(int i = 0; i < getCourse.length; i++)
				{
					if(getCourse[i].contains("course"))
					{
						continue;
					}
					courseData.add(getCourse[i]);
				}
				//driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
				
				List<WebElement> listOfCourse = driver.findElements(By.xpath("//div[contains(@class,'postOrPutCourse_contentOptions')]/div[contains(@class,'postOrPutCourse_optionsItem')]//label"));
				for(int n = 0; n < listOfCourse.size(); n++)
				{
					js.executeScript("arguments[0].scrollIntoView();", listOfCourse.get(n));
					for(int c = 0; c < courseData.size(); c++)
					{
						if(listOfCourse.get(n).getText().equalsIgnoreCase(courseData.get(c)))
						{
							js.executeScript("arguments[0].click()", listOfCourse.get(n));
							System.out.println("selecting course for students");
							break;
						}
					}
				}
				WebElement clickAssignCourse = driver.findElement(By.xpath("//button[contains(text(),'Assign Course')]"));
				js.executeScript("arguments[0].scrollIntoView();", clickAssignCourse);
				if(clickAssignCourse.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickAssignCourse);
					System.out.println("clicked assign course button");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("Issue in AssignToCourse");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			processStatus.add("issue");
		}
		return processStatus;
	}
	//verifyCourseAssignment_AssignedStudent . ReAssign the course for assigned students
	public ArrayList<String> verifyCourseAssignment_AssignedStudent(ArrayList<String> data)
	{
		ArrayList<String> processStatus = new ArrayList<String>();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try
		{
			//verifying assigned students are available in Reassigned section
			try
			{
				if(driver.findElements(By.xpath("//p[contains(text(),'Pending Assignments')][contains(@class,'courseAssignment_tabItemSelected')]")).size()>0)
				{
					WebElement clickAssignedStudent = driver.findElement(By.xpath("//p[contains(text(),'Assigned Students')]"));
					js.executeScript("arguments[0].scrollIntoView();", clickAssignedStudent);
					if(clickAssignedStudent.isDisplayed())
					{
						js.executeScript("arguments[0].click()", clickAssignedStudent);	
						System.out.println("Assigned section page");
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			try
			{
				studentData.add("hema6@gmail.com");
				if(driver.findElements(By.xpath("//button[contains(text(),'Re-assign New Course')]")).size()>0)
				{
					System.out.println("ReAssign course Page");
					
					for(int i = 0; i < studentData.size(); i++)
					{
						WebElement searchField = driver.findElement(By.xpath("//input[contains(@class,'tableTnsdc_searchBar')]"));
						
						js.executeScript("arguments[0].scrollIntoView();", searchField);
						
						if(searchField.isDisplayed())
						{
							searchField.sendKeys(studentData.get(i));
							
							if(driver.findElements(By.xpath("//table[contains(@class,'tableTnsdc_containerTable')]/tbody/tr[contains(@class,'tableTnsdc_bodyRowItem')]")).size()>0)
							{
								System.out.println("Assigned students presented");
								for(int j = 0; j < studentData.get(i).length(); j++)
								{
									searchField.sendKeys(Keys.BACK_SPACE);
								}
							}
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("Issue in students");
			}
			
			//driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			
			try
			{
				//verifying student records based on count 
				WebElement listOfTablesInput = driver.findElement(By.xpath("//select[@class='tableTnsdc_displayInput__18POl']"));
				js.executeScript("arguments[0].scrollIntoView();", listOfTablesInput);
				if(listOfTablesInput.isDisplayed())
				{
					//js.executeScript("arguments[0].click()", listOfTablesInput);
					Select selectDisplayCount = new Select(listOfTablesInput);
					List<WebElement> listOfDataFromDropDown = selectDisplayCount.getOptions();
					for(int i = 0; i < listOfDataFromDropDown.size(); i++)
					{
						String dropDownText = listOfDataFromDropDown.get(i).getText();//number of data to display on table
						selectDisplayCount.selectByVisibleText(dropDownText);
						int getcountValue = Integer.valueOf(dropDownText);
						List<WebElement> checkStudentDataFromTable = driver.findElements(By.xpath("//table[contains(@class,'tableTnsdc_containerTable')]//tbody/tr"));
						for(int j = 0; j < checkStudentDataFromTable.size(); j++)
						{
							//list of data displayed on Table
							int getStudentSize = checkStudentDataFromTable.size();
							if(getStudentSize <= getcountValue)
							{
								System.out.println("student records displayed correctly based on count");
								break;
							}
							else
							{
								processStatus.add("StudentscountFail");
							}
						}
					}
				}
				
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("Issue in studentsRecord");
			}
			//driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			
			try
			{
				//verifying able to re assign the students
				String selectStudent[] = data.get(3).split("=");
				ArrayList<String> reAssignStudent = new ArrayList<String>();
				for(int i = 0; i < selectStudent.length; i++)
				{
					if(selectStudent[i].contains("students"))
					{
						continue;
					}
					reAssignStudent.add(selectStudent[i]);
				}
				//search student and enable the student row
				WebElement searchField = driver.findElement(By.xpath("//input[contains(@class,'tableTnsdc_searchBar')]"));
				js.executeScript("arguments[0].scrollIntoView();", searchField);
				if(searchField.isDisplayed())
				{
					for(int m = 0; m < reAssignStudent.size(); m++)
					{
						searchField.sendKeys(reAssignStudent.get(m));
						if(driver.findElements(By.xpath("//tr[contains(@class,'tableTnsdc_bodyRowItem__kk0L4 tableTnsdc_bodyRowSelection')]/td")).size()>0)
						{
							WebElement selectData = driver.findElement(By.xpath("//th[contains(@class,'tableTnsdc_headerRowItemSelect')]//img[@alt='table']"));
							//js.executeScript("arguments[0].scrolIntoView();", selectData);
							if(selectData.isDisplayed())
							{
								js.executeScript("arguments[0].click()", selectData);
								
							}
						}
						else
						{
							System.out.println("search data not found");
							searchField.clear();
						}
					}
				}
				js.executeScript("arguments[0].scrollIntoView();", searchField);
				searchField.clear();
				WebElement clickReAssignButton = driver.findElement(By.xpath("//button[contains(text(),'Re-assign New Course')]"));
				js.executeScript("arguments[0].scrollIntoView();", clickReAssignButton);
				if(clickReAssignButton.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickReAssignButton);
					if(driver.findElements(By.xpath("//span[contains(text(),'Attention Mentor:')]")).size()>0)
					{
						WebElement clickAcknowledge = driver.findElement(By.xpath("//img[contains(@alt,'putAgree')]"));
						js.executeScript("arguments[0].scrollIntoView();", clickAcknowledge);
						if(clickAcknowledge.isDisplayed())
						{
							js.executeScript("arguments[0].click()", clickAcknowledge);
							
							WebElement clickProceed = driver.findElement(By.xpath("//button[contains(text(),'Proceed')]"));
							js.executeScript("arguments[0].scrollIntoView();", clickReAssignButton);
							if(clickProceed.isDisplayed())
							{
								js.executeScript("arguments[0].click()", clickProceed);
							}
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("Issue in SelectStudent");
			}
			try
			{
				String dataFromExcel[] = data.get(4).split("=");
				ArrayList<String> courseData = new ArrayList<String>();
				for(int i = 0 ; i < dataFromExcel.length; i++)
				{
					if(dataFromExcel[i].contains("course"))
					{
						continue;
					}
					courseData.add(dataFromExcel[i]);
				}
				List<WebElement> listOfCourse = driver.findElements(By.xpath("//div[contains(@class,'postOrPutCourse_contentOptions')]/div[contains(@class,'postOrPutCourse_optionsItem')]//label"));
				for(int n = 0; n < listOfCourse.size(); n++)
				{
					js.executeScript("arguments[0].scrollIntoView();", listOfCourse.get(n));
					for(int c = 0; c < courseData.size(); c++)
					{
						if(listOfCourse.get(n).getText().equalsIgnoreCase(courseData.get(c)))
						{
							js.executeScript("arguments[0].click()", listOfCourse.get(n));
							System.out.println("selecting course for students");
							break;
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("Issue in SelectCourse");
			}
			try
			{
				WebElement clickAssignCourse = driver.findElement(By.xpath("//button[contains(text(),'Re-assign')]"));
				js.executeScript("arguments[0].scrollIntoView();", clickAssignCourse);
				if(clickAssignCourse.isDisplayed())
				{
					js.executeScript("arguments[0].click()", clickAssignCourse);
					System.out.println("clicked assign course button");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				processStatus.add("Issue in ReAssign");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return processStatus;
	}
	
	public ArrayList<String> verifyTeamAllocation(ArrayList<String> data)
	{
		ArrayList<String> processStatus = new ArrayList<String>();
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return processStatus;
	}
}
