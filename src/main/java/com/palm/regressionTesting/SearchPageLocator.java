package com.palm.regressionTesting;

import java.awt.Image;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageLocator
{
	WebDriver driver;
	int respCode = 200;
	HttpURLConnection huc = null;

	public SearchPageLocator(WebDriver driver) 
	{
		this.driver = driver;
	}

	String searchField = "div[class*='Header_headerRight'] input[id='contentSearch']";
	String searchButton = "div[class*='Header_headerRight'] button[id='btnCheck']";
	
	
	
	public void checkURL(String urlLink) {
		try {
			String addHosturl = urlLink;
			huc = (HttpURLConnection) (new URL(addHosturl).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			respCode = huc.getResponseCode();
			System.out.println("status code : " + respCode + " " + addHosturl);
			if (respCode > 200) {
				System.out.println("broken link" + addHosturl);
				System.exit(0);
			} else {
				System.out.println("un broken link" + addHosturl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> validDataSearchProcess(ArrayList<String> dataFromExcel)
	{
		ArrayList<String> statusOfProcess = new ArrayList<String>();
		try
		{
			System.out.println("valid data search started");
			for(int i = 1; i < dataFromExcel.size(); i++)
			{
				if(i == 1)
				{
					
				WebElement searchBox = driver.findElement(By.cssSelector("ul[class*='Header_headSearch_'] input#contentSearch[value]"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchBox);
				
				WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
				wb.until(ExpectedConditions.elementToBeClickable(searchBox)).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				//Thread.sleep(2000);
				searchBox.sendKeys(dataFromExcel.get(i));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				if(driver.findElements(By.xpath("//ul[contains(@class,'Header_headSearch_')]/descendant::ul/li")).size()>0)
				{
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					List<WebElement> checkListOfCourse = driver.findElements(By.xpath("//ul[contains(@class,'Header_headSearch_')]/descendant::ul/li"));
					if(checkListOfCourse.size()>0)
					{
						for(int j = 0; j < checkListOfCourse.size(); j++)
						{
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
							if(checkListOfCourse.get(j).getText().equalsIgnoreCase(dataFromExcel.get(i)))
							{
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
								System.out.println("Entered course available");
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
								checkListOfCourse.get(j).click();
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
								
								String parent = driver.getWindowHandle();
								Set<String> windows = driver.getWindowHandles();
								for(String window : windows)
								{
									driver.switchTo().window(window);
									if(driver.getCurrentUrl().contains("search="))
									{
										driver.switchTo().window(window);
										System.out.println("results found window");
										ArrayList<Integer> getHeaderStatus = new ArrayList<Integer>();
										ArrayList<Integer> getFooterStatus = new ArrayList<Integer>();
										//getProcessStatus.addAll(this.verifyHeader());
										getHeaderStatus = this.verifyHeader();
										driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
										
										//getProcessStatus.addAll(this.verifyFooter());
										getFooterStatus = this.verifyFooter();
										for(int k = 0; k < getHeaderStatus.size(); k++)
										{
											if(getHeaderStatus.get(0) != getFooterStatus.get(0))
											{
												statusOfProcess.add("category not same");	
											}
											if(getHeaderStatus.get(2) != getFooterStatus.get(2))
											{
												statusOfProcess.add("popular courses not same");
											}
											if(getHeaderStatus.get(1) != 5)
											{
												statusOfProcess.add("popular learning partner count not correct in header");
											}
											if(getFooterStatus.get(1) != 3)
											{
												statusOfProcess.add("blog count not correct in footer");
											}
										}
										JavascriptExecutor js = (JavascriptExecutor) driver;
										js.executeScript("window.scrollBy(0, -700)", "");
										WebElement getCourse = driver.findElement(By.cssSelector("div[class*='RegularCourseCard_courseHeading__1Ohrn'] p"));
										if(getCourse.getText().equalsIgnoreCase(dataFromExcel.get(i)))
										{
											//getCourse.click();
											js.executeScript("arguments[0].click()", getCourse);
											driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
											Thread.sleep(1000);
											String parent1 = driver.getWindowHandle();
											Set<String> windows1 = driver.getWindowHandles();
											for(String window1 : windows1)
											{
												driver.switchTo().window(window1);
												Thread.sleep(3000);
												if(driver.getCurrentUrl().contains("/courses/") && driver.getCurrentUrl().contains(RegressionTesting.ENV_TO_USE))
												{
													Thread.sleep(3000);
													driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
													driver.switchTo().window(window1);
													driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
													System.out.println("course is opened");
													driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
													Thread.sleep(1000);
													String courseURL = driver.getCurrentUrl();
													System.out.println("course Link : "+courseURL);
													String result = OpenWebsite.setHost;//.substring(0, courseURL.indexOf("/Courses"));
													System.out.println("homepage url : "+result);
													driver.get(result);
													Thread.sleep(1000);
													driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
													break;
												}
											}
											
										}
									}
								}
							}
							else
							{
								System.out.println("course is not available");
								statusOfProcess.add("fail");
							}
						}
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				}
			System.out.println("valid data search completed");
			break;
			}
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
				statusOfProcess.add("fail");
			}
		return statusOfProcess;
	}

	public ArrayList<String> invalidDataSearchProcess(ArrayList<String> dataFromExcel) {
		ArrayList<String> statusOfProcess = new ArrayList<String>();
		try {
			System.out.println("In valid data search started");
			for (int i = 1; i < dataFromExcel.size(); i++)
			{
				if(i == 1)
				{
					
				WebElement searchBox = driver.findElement(By.cssSelector(
						"ul[class='nav navbar-nav Header_headSearch___BeK7'] form#searchForm input#contentSearch"));
				WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
				wb.until(ExpectedConditions.elementToBeClickable(searchBox)).click();
				searchBox.sendKeys(dataFromExcel.get(i));
				String getValue = searchBox.getAttribute("value");
				System.out.println(getValue);
				WebElement clickSearchIcon = driver.findElement(
						By.cssSelector("ul[class='nav navbar-nav Header_headSearch___BeK7'] button#btnCheck"));
				clickSearchIcon.click();
				String parentWindow = driver.getWindowHandle();
				Set<String> windows = driver.getWindowHandles();
				for (String window : windows) {
					driver.switchTo().window(window);
					if (driver.getCurrentUrl().contains("?search")) {
						driver.switchTo().window(window);
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						if (driver.findElements(By.cssSelector("div[class='Course_NotiFicaTIon__Anb5F'] li"))
								.size() > 0) {
							WebElement checkListOfCourse = driver
									.findElement(By.cssSelector("div[class='Course_NotiFicaTIon__Anb5F'] li"));
							if (checkListOfCourse.isDisplayed()) {
								System.out.println(checkListOfCourse.getText());
							}
						} else {
							System.out.println("zero result found");
							break;
						}
					}
				}
				ArrayList<Integer> getHeaderStatus = new ArrayList<Integer>();
				ArrayList<Integer> getFooterStatus = new ArrayList<Integer>();
				//getProcessStatus.addAll(this.verifyHeader());
				getHeaderStatus = this.verifyHeader();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				
				//getProcessStatus.addAll(this.verifyFooter());
				getFooterStatus = this.verifyFooter();
				for(int k = 0; k < getHeaderStatus.size(); k++)
				{
					if(getHeaderStatus.get(0) != getFooterStatus.get(0))
					{
						statusOfProcess.add("category not same");	
					}
					if(getHeaderStatus.get(2) != getFooterStatus.get(2))
					{
						statusOfProcess.add("popular courses not same");
					}
					if(getHeaderStatus.get(1) != 5)
					{
						statusOfProcess.add("popular learning partner count not correct in header");
					}
					if(getFooterStatus.get(1) != 3)
					{
						statusOfProcess.add("blog count not correct in footer");
					}
				}
				Thread.sleep(1000);
				// String courseURL = driver.getCurrentUrl();
				String result = OpenWebsite.setHost;// courseURL.substring(0, courseURL.indexOf("/Courses"));
				System.out.println("homepage url : " + result);
				driver.get(result);
				Thread.sleep(1000);
			}
			System.out.println("Invalid data search completed");
			break;
			}
		} 
			catch (Exception e) {
			e.printStackTrace();
		}
		return statusOfProcess;
	}

	public ArrayList<String> emptySearchProcess(ArrayList<String> dataFromExcel)
	{
		ArrayList<String> statusOfProcess = new ArrayList<String>();
		try {
			System.out.println("empty search started");
			for(int i = 0; i < dataFromExcel.size(); i++)
			{
				if(i == 1)
				{
					WebElement searchBox = driver.findElement(By.cssSelector(
							"ul[class='nav navbar-nav Header_headSearch___BeK7'] form#searchForm input#contentSearch"));
					WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
					wb.until(ExpectedConditions.elementToBeClickable(searchBox)).click();
					Thread.sleep(3000);
					searchBox.sendKeys(dataFromExcel.get(i));
					String getValue = searchBox.getAttribute("value");
					System.out.println(getValue);
					if (dataFromExcel.get(i).equalsIgnoreCase("empty")) {
						searchBox.sendKeys("");
						WebElement clickSearchIcon = driver.findElement(
								By.cssSelector("ul[class='nav navbar-nav Header_headSearch___BeK7'] button#btnCheck"));
						clickSearchIcon.click();
						String parentWindow = driver.getWindowHandle();
						Set<String> windows = driver.getWindowHandles();
						for (String window : windows) {
							driver.switchTo().window(window);
							if (driver.getCurrentUrl().contains("?search")) {
								driver.switchTo().window(window);
								if (driver.findElements(By.cssSelector("div[class='Course_NotiFicaTIon__Anb5F'] li"))
										.size() > 0) {
									WebElement checkListOfCourse = driver
											.findElement(By.cssSelector("div[class='Course_NotiFicaTIon__Anb5F'] li"));
									if (checkListOfCourse.isDisplayed()) {
										System.out.println(checkListOfCourse.getText());
									}
								} else {
									System.out.println("zero result found");
									break;
								}
							}
						}
					}
					ArrayList<Integer> getHeaderStatus = new ArrayList<Integer>();
					ArrayList<Integer> getFooterStatus = new ArrayList<Integer>();
					//getProcessStatus.addAll(this.verifyHeader());
					getHeaderStatus = this.verifyHeader();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					
					//getProcessStatus.addAll(this.verifyFooter());
					getFooterStatus = this.verifyFooter();
					for(int k = 0; k < getHeaderStatus.size(); k++)
					{
						if(getHeaderStatus.get(0) != getFooterStatus.get(0))
						{
							statusOfProcess.add("category not same");	
						}
						if(getHeaderStatus.get(2) != getFooterStatus.get(2))
						{
							statusOfProcess.add("popular courses not same");
						}
						if(getHeaderStatus.get(1) != 5)
						{
							statusOfProcess.add("popular learning partner count not correct in header");
						}
						if(getFooterStatus.get(1) != 3)
						{
							statusOfProcess.add("blog count not correct in footer");
						}
					}
					Thread.sleep(1000);
					// String courseURL = driver.getCurrentUrl();
					String result = OpenWebsite.setHost;// courseURL.substring(0, courseURL.indexOf("/Courses"));
					System.out.println("homepage url : " + result);
					driver.get(result);
					Thread.sleep(1000);
					System.out.println("empty data search completed");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusOfProcess;
	}

	public ArrayList<Integer> verifyHeader()
	{
		ArrayList<Integer> process = new ArrayList<Integer>();
		try
		{
			WebElement dropDown = driver.findElement(By.cssSelector("a#navbarDropdown img[alt=icon]"));
			dropDown.click();
			List<WebElement> categories = driver.findElements(By.cssSelector(
					"ul[class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show'] ul[class='categorylist customscroll dropdown-submenu']>li"));
			int sizeOfCategories = categories.size();
			process.add(sizeOfCategories);
			
			List<WebElement> learningPartners = driver.findElements(By.cssSelector(
					"ul[class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show'] div[class='LearningPartners catcolumn divbox2'] ul[class='learning-Partners']>li"));
			int sizeOfLearningPartner = learningPartners.size();
			process.add(sizeOfLearningPartner);

			List<WebElement> popularCourses = driver.findElements(By.cssSelector(
					"ul[class='dropdown-menu dropdown-cat Header_dropdownMenu__oDZ7V show'] div[class='PolularCourSE catcolumn divbox3'] ul[class='MegaMenu_PopularCourse']>li"));
			int sizeOfPopularCourse = popularCourses.size();
			process.add(sizeOfPopularCourse);
			dropDown.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return process;
	}

	public ArrayList<Integer> verifyFooter() 
	{
		ArrayList<Integer> getStatus = new ArrayList<Integer>();
		try
		{
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, -200)", "");
			
			//List<WebElement> shareSocialLink = driver.findElements(By.cssSelector("ul[class=' Footer_socialIconsSection__5DztA d-flex'] li a"));

		//	List<WebElement> company = driver.findElements(By.cssSelector("div[class='Footer_FootMenu__4fwEE'] ul li a"));
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			List<WebElement> popularCategory = driver
					.findElements(By.cssSelector("div[class='Footer_PopularCategories__23uL0'] ul li a"));
			getStatus.add(popularCategory.size());
			
						List<WebElement> blog = driver.findElements(
					By.cssSelector("div[class='Footer_LatestBlogs__QZ7i4'] div[class='Footer_LatestBlogsRepT__F2CHs'] a"));
			getStatus.add(blog.size());
			
			List<WebElement> popularCoursesLink = driver
					.findElements(By.cssSelector("div[class='Footer_PopularCourses__Yc9Ft'] ul li"));
			
			getStatus.add(popularCoursesLink.size());


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return getStatus;
	}

	public void enterTextInSearchBox(WebElement searchBox, String text) {
	    Actions actions = new Actions(driver);
	    searchBox.clear();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	    actions.moveToElement(searchBox).sendKeys(Keys.ENTER).pause(Duration.ofMillis(500))
	           .sendKeys(text).pause(Duration.ofMillis(500)).sendKeys(Keys.ENTER).perform();
	    
	}
	
public ArrayList<String> searchFunction(ArrayList<String> dataFromExcel, String nameOfProcess)
{
	 ArrayList<String> statusOfProcess = new ArrayList<String>();
     JavascriptExecutor js = (JavascriptExecutor) driver;
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
     
	 try 
     {
         System.out.println("search category started");
         
         for (int i = 1; i < dataFromExcel.size(); i++) 
         {
         	WebElement searchBox = driver.findElement(By.cssSelector(searchField));
         	js.executeScript("arguments[0].scrollIntoView()", searchBox);
         	wait.until(ExpectedConditions.visibilityOf(searchBox));
         	if(searchBox.isDisplayed())
         	{
         		if(nameOfProcess.equals("keyboard"))
         		{
         			 enterTextInSearchBox(searchBox, dataFromExcel.get(i));
                     wait.until(ExpectedConditions.urlContains("/explore"));
         		}
         		else if(nameOfProcess.equals("mouse"))
         		{
         			
         			 searchBox.sendKeys(dataFromExcel.get(i));
                     WebElement searchButtonElement = driver.findElement(By.cssSelector(searchButton));
                     wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
                     searchButtonElement.click();
                     wait.until(ExpectedConditions.urlContains("/explore"));
         		}
         		
         		if(dataFromExcel.get(i).contains("invalid"))
         		{
         			System.out.println("Invalid data search started");
         			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         	        if (driver.getCurrentUrl().contains("/explore")) 
         	        {
         	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
         	            System.out.println("Successfully navigated to /explore page");
         	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
         	            WebElement checkTextFromExplorePage = driver.findElement(By.cssSelector("div[class*='CourseSection_courseResultContainer'] div[class*='CourseSection_topFilterResults']"));
        	            js.executeScript("arguments[0].scrollIntoView()", checkTextFromExplorePage);
        	            wait.until(ExpectedConditions.visibilityOf(checkTextFromExplorePage));

        	            if(checkTextFromExplorePage.isDisplayed())
        	            {
        	            	if(checkTextFromExplorePage.getText().contains(dataFromExcel.get(i)))
        	            	{
        	            		System.out.println("Text is displayed on Explore All page" + checkTextFromExplorePage.getText());
        	            	}
        	            	else
        	            	{
								System.out.println("Text is not displayed on Explore All page");
								statusOfProcess.add("searched text no available - fail");
        	            	}
        	            }
        	            else
        	            {
        	            	System.out.println("searched text no available in explore all - fail");
        	            	statusOfProcess.add("fail");
        	            }
        	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        	            if(driver.findElements(By.cssSelector("div[class*='CourseSection_containerInnerFilter']>div:nth-child(4) div[class*='CourseSection_checkbox'] input[checked]")).size()>0)
        	            {
        	            	System.out.println("search text is selected");
        	            	System.out.println("searched text is available in explore all - fail");
        	            }
        	            if(driver.findElements(By.cssSelector("div[class*='CourseSection_alertContent'] h3")).size()>0)
        	            {
        	            	WebElement checkAlertText = driver.findElement(By.cssSelector("div[class*='CourseSection_alertContent'] h3"));
        	            	 js.executeScript("arguments[0].scrollIntoView()", checkAlertText);
        	            	 wait.until(ExpectedConditions.visibilityOf(checkAlertText));
        	            	if (checkAlertText.getText().contains("Help us find the right course for you."))
							{
								System.out.println("No results found text is displayed");
							} 
							else
							{
								System.out.println("No results found text is not displayed");
								statusOfProcess.add("no results found text not displayed - fail");
							}
        	            }
        	            if(driver.findElements(By.cssSelector("div[class*='CourseSection_RecommCourse']>h2")).size()>0)
        	            {
        	            	
        	            	WebElement checkRecommendCourseText = driver.findElement(By.cssSelector("div[class*='CourseSection_RecommCourse']>h2"));
        	            	 js.executeScript("arguments[0].scrollIntoView()", checkRecommendCourseText);
        	            	 wait.until(ExpectedConditions.visibilityOf(checkRecommendCourseText));
        	            	if (checkRecommendCourseText.getText().contains("Recommended Courses"))
							{
								System.out.println("Recommended Courses text is displayed");
							}
							else 
							{
								System.out.println("Recommended Courses text is not displayed");
								statusOfProcess.add("recommended courses text not displayed - fail");
							}
        	            }
         	        }
         	        else
         	        {
         	        	System.out.println("Navigation to /explore page failed");
         	            statusOfProcess.add("explore all page not faced - fail");
         	        }
         		}
         		else
         		{
         			 // Verify if the URL is as expected
         			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         	        if (driver.getCurrentUrl().contains("/explore")) 
         	        {
         	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
         	            System.out.println("Successfully navigated to /explore page");
         	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
         	            WebElement checkTextFromExplorePage = driver.findElement(By.cssSelector("div[class*='CourseSection_courseResultContainer'] div[class*='CourseSection_topFilterResults']"));
         	            js.executeScript("arguments[0].scrollIntoView()", checkTextFromExplorePage);
         	            wait.until(ExpectedConditions.visibilityOf(checkTextFromExplorePage));

         	            if(checkTextFromExplorePage.isDisplayed())
         	            {
         	            	if(checkTextFromExplorePage.getText().contains(dataFromExcel.get(i)))
         	            	{
         	            		System.out.println("Text is displayed on Explore All page" + checkTextFromExplorePage.getText());
         	            	}
         	            	else
         	            	{
								System.out.println("Text is not displayed on Explore All page");
								statusOfProcess.add("searched text no available - fail");
         	            	}
         	            }
         	            else
         	            {
         	            	System.out.println("searched text no available in explore all - fail");
         	            	statusOfProcess.add("fail");
         	            }
         	            
         	            List<WebElement> checkCategory = driver.findElements(By.cssSelector("div[class*='CourseSection_containerInnerFilter']>div:nth-child(4) div[class*='CourseSection_checkbox']"));
         	            
         	            for(int j = 0; j < checkCategory.size(); j++)
         	            {
         	            	js.executeScript("arguments[0].scrollIntoView()", checkCategory.get(j));
         	            	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
         	            	WebElement checkCategoryEnabled = checkCategory.get(j).findElement(By.cssSelector(" input[checked]"));
         	            	 wait.until(ExpectedConditions.visibilityOf(checkCategoryEnabled));
         	            	WebElement checkCategoryText = checkCategory.get(j).findElement(By.cssSelector(" label"));
         	            	 wait.until(ExpectedConditions.visibilityOf(checkCategoryText));
         	            	
         	            	String getEnabledText = checkCategoryText.getText();
         	            	if(checkCategoryEnabled.isSelected())
         	            	{
         	            		System.out.println("search text  is selected");
         	            		
									if (dataFromExcel.get(i).equals(getEnabledText))
									{
										System.out.println("search text  is selected");
										break;
									}
									else
									{
										System.out.println("search text  is not selected");
										statusOfProcess.add("search text is not selected - fail");
										break;
									}
         	            	}
         	            	else
         	            	{
         	            		System.out.println("search text is not selected");
         	            		statusOfProcess.add("search text not selected - fail");
         	            		break;
         	            	}
         	            }
         	        } 
         	        else 
         	        {
         	            System.out.println("Navigation to /explore page failed");
         	            statusOfProcess.add("explore all page not faced - fail");
         	        }
         		}
         	       
         		if((dataFromExcel.size() - 1) == i)
         		{
         			break;
         		}
         	}
         }
         
     }
		catch (Exception e) 
     {
			e.printStackTrace();
			statusOfProcess.add("exception");
	}
	return statusOfProcess;
}

public ArrayList<String> searchCategoryProcess(ArrayList<String> dataFromExcel) 
{
	System.out.println("search category process started");
		String nameOfEvent = "";
        ArrayList<String> validationStatus = new ArrayList<String>();
        validationStatus.add("KeyBoardEvent");
        validationStatus.add("MouseEvent");
        try
        {
        	for(int i = 0; i < validationStatus.size(); i++)
        	{
				switch (validationStatus.get(i))
				{
				case "KeyBoardEvent":
					System.out.println("KeyBoardEvent Validation Started");
					nameOfEvent = "keyboard";
					validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
					break;
				case "MouseEvent":
					System.out.println("MouseEvent Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "mouse";
					validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
					break;
				default:
					System.out.println("Validation End");
					break;
				}
        	}
        }
		catch (Exception e) 
        {
			e.printStackTrace();
			validationStatus.add("exception");
		}
        
		return validationStatus;
}

public ArrayList<String> searchCourseProcess(ArrayList<String> dataFromExcel)
{
	System.out.println("search course process started");
	String nameOfEvent = "";
    ArrayList<String> validationStatus = new ArrayList<String>();
    validationStatus.add("KeyBoardEvent");
    validationStatus.add("MouseEvent");
    try
    {
    	for(int i = 0; i < validationStatus.size(); i++)
    	{
			switch (validationStatus.get(i))
			{
			case "KeyBoardEvent":
				System.out.println("KeyBoardEvent Validation Started");
				nameOfEvent = "keyboard";
				validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
				break;
			case "MouseEvent":
				System.out.println("MouseEvent Validation Started");
				driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				nameOfEvent = "mouse";
				validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
				break;
			default:
				System.out.println("Validation End");
				break;
			}
    	}
    }
	catch (Exception e) 
    {
		e.printStackTrace();
		validationStatus.add("exception");
	}
    
	return validationStatus;
}

public ArrayList<String> searchProgramProcess(ArrayList<String> dataFromExcel)
{
	System.out.println("search program process started");
	String nameOfEvent = "";
    ArrayList<String> validationStatus = new ArrayList<String>();
    validationStatus.add("KeyBoardEvent");
    validationStatus.add("MouseEvent");
    try
    {
    	for(int i = 0; i < validationStatus.size(); i++)
    	{
			switch (validationStatus.get(i))
			{
			case "KeyBoardEvent":
				System.out.println("KeyBoardEvent Validation Started");
				nameOfEvent = "keyboard";
				validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
				break;
			case "MouseEvent":
				System.out.println("MouseEvent Validation Started");
				driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				nameOfEvent = "mouse";
				validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
				break;
			default:
				System.out.println("Validation End");
				break;
			}
    	}
    }
	catch (Exception e) 
    {
		e.printStackTrace();
		validationStatus.add("exception");
	}
    
	return validationStatus;
}

	public ArrayList<String> searchInvalidDataProcess(ArrayList<String> dataFromExcel) 
	{
		System.out.println("search Invalid process started");
		String nameOfEvent = "";
        ArrayList<String> validationStatus = new ArrayList<String>();
        validationStatus.add("KeyBoardEvent");
        validationStatus.add("MouseEvent");
        try
        {
        	for(int i = 0; i < validationStatus.size(); i++)
        	{
				switch (validationStatus.get(i))
				{
				case "KeyBoardEvent":
					System.out.println("KeyBoardEvent Validation Started");
					nameOfEvent = "keyboard";
					validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
					break;
				case "MouseEvent":
					System.out.println("MouseEvent Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "mouse";
					validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
					break;
				default:
					System.out.println("Validation End");
					break;
				}
        	}
        }
		catch (Exception e) 
        {
			e.printStackTrace();
			validationStatus.add("exception");
		}
        
		return validationStatus;
	}
}
