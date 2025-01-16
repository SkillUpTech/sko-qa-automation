package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
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
	String listOfCourseCardInExploreAllPage = "//div[contains(@class,'CourseSection_courseResultContainer')]//div[contains(@class,'CourseSection_courseResult')]";
   
	
	
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
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
													
													String courseURL = driver.getCurrentUrl();
													System.out.println("course Link : "+courseURL);
													String result = OpenWebsite.setHost;//.substring(0, courseURL.indexOf("/Courses"));
													System.out.println("homepage url : "+result);
													driver.get(result);
													
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
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
				
				// String courseURL = driver.getCurrentUrl();
				String result = OpenWebsite.setHost;// courseURL.substring(0, courseURL.indexOf("/Courses"));
				System.out.println("homepage url : " + result);
				driver.get(result);
				
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
					
					// String courseURL = driver.getCurrentUrl();
					String result = OpenWebsite.setHost;// courseURL.substring(0, courseURL.indexOf("/Courses"));
					System.out.println("homepage url : " + result);
					driver.get(result);
					
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

	public void enterTextInSearchBox(WebElement searchBox, String text) 
	{
		 Actions actions = new Actions(driver);
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		    // Clear the search box
		    wait.until(ExpectedConditions.elementToBeClickable(searchBox)).clear();

		    // Move to the search box and enter text
		    actions.moveToElement(searchBox)
		           .click()
		           .sendKeys(text)
		           .perform();

		    // Ensure the text is entered
		    wait.until(ExpectedConditions.attributeToBe(searchBox, "value", text));
	    
	}

	
	
	public String checkURLStatus(String data)
	{
		  String status = "fail";
	        HttpURLConnection connection = null;
	        int responseCode = 200;
			 try 
			 {
		            connection = (HttpURLConnection) (new URL(data).openConnection());
		            connection.setRequestMethod("GET");
		            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		            connection.connect();
		            responseCode = connection.getResponseCode();
		            System.out.println("Status code: " + responseCode + " URL: " + data);
		            if (responseCode >= 400 && responseCode <= 405 || responseCode == 410 || responseCode == 429 || responseCode >=500 && responseCode <= 505) 
		            {
		                System.out.println("Broken link: " + data);
		                status = "fail: " + responseCode;
		            } 
		            else 
		            {
		                System.out.println("Unbroken link: " + data + " " + responseCode);
		                status = "success";
		            }
		        } 
			 catch (Exception e) 
			 {
		            e.printStackTrace();
		     }
			 finally
			 {
		            if (connection != null)
		            {
		                connection.disconnect();
		            }
			 }
			return status;
	}
	
	public ArrayList<String> exploreAllPageProcess() throws InterruptedException
	{
		 ArrayList<String> statusOfProcess = new ArrayList<String>();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
	     try {
			    WebElement searchBox = driver.findElement(By.cssSelector(searchField));
			    js.executeScript("arguments[0].scrollIntoView()", searchBox);

			    if (searchBox.isDisplayed()) 
			    {
			        searchBox.sendKeys("A");
			        WebElement searchButtonElement = driver.findElement(By.cssSelector(searchButton));
                 wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
                 searchButtonElement.click();

			        wait.until(ExpectedConditions.urlContains("/explore"));
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			        if (driver.getCurrentUrl().contains("/explore"))
			        {
			        	Thread.sleep(3000);
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			            System.out.println("Successfully navigated to /explore page");
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			            
			            
			            // Verify if searched text is present or not in explore all page
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			            if(driver.findElements(By.xpath("//p[contains(text(),'(0)')]")).size() > 0)
			            {
			                System.out.println("searched text not available in explore all - fail");
			                statusOfProcess.add("SearchedTextNotFound");
			            }

			            // Verify "Help us find the right course for you" text
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			            if(driver.findElements(By.xpath("//h3[contains(text(),'Help us find the right course for you.')]")).size() > 0) {
			                System.out.println("Help us find the right course for you. text is displayed");
			                statusOfProcess.add("HelpTextFound");
			            }

			            // Verify "Recommended Courses" text
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			            if(driver.findElements(By.xpath("//h2[contains(text(),'Recommended Courses')]")).size() > 0) {
			                System.out.println("Recommended Courses text is displayed");
			                statusOfProcess.add("recommendedTextFound");
			            }
			        }
			    } 
			    else 
			    {
			        System.out.println("explore all page not faced - fail");
			        statusOfProcess.add("explorePageNotFound");
			    }
			} 
			catch (Exception e)
			{
			    e.printStackTrace();
			}
		
	        return statusOfProcess;
	}
	
	
	public ArrayList<String> searchFunctionForBlankPage(String nameOfProcess)
	{
	 ArrayList<String> statusOfProcess = new ArrayList<String>();
	 ArrayList<String> status = new ArrayList<String>();
     JavascriptExecutor js = (JavascriptExecutor) driver;
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
	try
	{
		String ParentWindow  = "";
		if(nameOfProcess.equals("HomePage"))
 		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			statusOfProcess.addAll(this.exploreAllPageProcess());
			
 	         WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a"));
 	    	 js.executeScript("arguments[0].scrollIntoView()", clickSkillupLogo);
 	    	 if (clickSkillupLogo.isDisplayed())
 	    	 {
 	    		 js.executeScript("arguments[0].click()", clickSkillupLogo);
 	    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
 	    		ParentWindow = driver.getWindowHandle();
 	    	 }
 	    	 if(statusOfProcess.contains("HelpTextFound")||statusOfProcess.contains("recommendedTextFound")||statusOfProcess.contains("explorePageFound")||statusOfProcess.contains("SearchedTextFound"))
 	    	 {
 	    		 System.out.println("Home page search process failed");
 	    		 status.add("Home page : "+statusOfProcess.toString());
 	    	 }
 	    	 else
 	    	 {
 	    		 System.out.println("Home page search process done");
 	    	 }
 	    	 statusOfProcess.clear();
 	    }
		else if (nameOfProcess.equals("coursePage")) 
		{
			
			String courseURL = driver.getCurrentUrl()+"/courses/deep-learning-fundamentals/?id=course-v1:IBM+ML0115EN+v2";
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(courseURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			statusOfProcess.addAll(this.exploreAllPageProcess());
 	        driver.close();
 	        driver.switchTo().window(ParentWindow);
 	       if(statusOfProcess.contains("HelpTextFound")||statusOfProcess.contains("recommendedTextFound")||statusOfProcess.contains("explorePageFound")||statusOfProcess.contains("SearchedTextFound"))
	    	 {
 	    	   System.out.println("course page search process failed");
 	    	   status.add("course page : " +statusOfProcess.toString());
	    	 }
	    	 else
	    	 {
	    		 System.out.println("course page search process done");
	    	 }
	    	 statusOfProcess.clear();
 		
		}
		else if (nameOfProcess.equals("programPage")) 
		{
			String courseURL = driver.getCurrentUrl()+"/applied-ai-ibm-professional-certificate/";
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(courseURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			statusOfProcess.addAll(this.exploreAllPageProcess());
 	        driver.close();
 	        driver.switchTo().window(ParentWindow);
 	       if(statusOfProcess.contains("HelpTextFound")||statusOfProcess.contains("recommendedTextFound")||statusOfProcess.contains("explorePageFound")||statusOfProcess.contains("SearchedTextFound"))
	    	 {
 	    	   System.out.println("program page search process failed");
 	    	   status.add("program page : "+statusOfProcess.toString());
	    	 }
	    	 else
	    	 {
	    		 System.out.println("program page search process done");
	    	 }
	    	 statusOfProcess.clear();

		}
		else if (nameOfProcess.equals("FAQPage")) 
		{

			String courseURL = driver.getCurrentUrl()+"/faq/?utm_source=websiteinternal&utm_medium=Footer&utm_campaign=NA";
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(courseURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			statusOfProcess.addAll(this.exploreAllPageProcess());
 	        driver.close();
 	        driver.switchTo().window(ParentWindow);
 	       if(statusOfProcess.contains("HelpTextFound")||statusOfProcess.contains("recommendedTextFound")||statusOfProcess.contains("explorePageFound")||statusOfProcess.contains("SearchedTextFound"))
	    	 {
	    		System.out.println("FAQ page search process failed");
	    		status.add("FAQPage : "+statusOfProcess.toString());
	    	 }
	    	 else
	    	 {
	    		 System.out.println("FAQ page search process done");
	    	 }
	    	 statusOfProcess.clear();
		}
		else if (nameOfProcess.equals("GOIPage")) 
		{

			String courseURL = driver.getCurrentUrl()+"/applied-ai-ibm-professional-certificate/";
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get(courseURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
            statusOfProcess.addAll(this.exploreAllPageProcess());
 	        driver.close();
 	        driver.switchTo().window(ParentWindow);
 	       if(statusOfProcess.contains("HelpTextFound")||statusOfProcess.contains("recommendedTextFound")||statusOfProcess.contains("explorePageFound")||statusOfProcess.contains("SearchedTextFound"))
	    	 {
	    		System.out.println("GOI page search process failed");
	    		status.add("GOIPage "+statusOfProcess.toString());
	    	 }
	    	 else
	    	 {
	    		 System.out.println("GOI page search process done");
	    	 }
	    	 statusOfProcess.clear();
 		
		}
		else if (nameOfProcess.equals("CategoryPage")) 
		{

			if(driver.findElements(By.xpath("//div[contains(@class,'TechCategories_exCollaborationInner')]//ul/li/a")).size()>0)
			{
				List<WebElement> getCategories = driver.findElements(By.xpath("//div[contains(@class,'TechCategories_exCollaborationInner')]//ul/li/a"));
				for (int i = 0; i < getCategories.size(); i++)
				{
					String getLink = getCategories.get(i).getAttribute("href");
					String checkStatus = this.checkURLStatus(getLink);
					if (!checkStatus.contains("fail")) 
					{
						System.out.println("Category page search verification started");
						String courseURL = driver.getCurrentUrl()+"/applied-ai-ibm-professional-certificate/";
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(courseURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						statusOfProcess.addAll(this.exploreAllPageProcess());
			 	        driver.close();
			 	        driver.switchTo().window(ParentWindow);
					}
				}
			}
			
			 if(statusOfProcess.contains("HelpTextFound")||statusOfProcess.contains("recommendedTextFound")||statusOfProcess.contains("explorePageFound")||statusOfProcess.contains("SearchedTextFound"))
 	    	 {
 	    		System.out.println("Category page search process failed");
 	    		status.add("CategoryPage : "+statusOfProcess.toString());
 	    	 }
 	    	 else
 	    	 {
 	    		 System.out.println("Category page search process done");
 	    	 }
 	    	 statusOfProcess.clear();
		}
		else if (nameOfProcess.equals("PartnerPage")) 
		{
			if(driver.findElements(By.xpath("//div[contains(@class,'Collaborate_excollaborationInner')]//ul/li/a")).size()>0)
			{
				List<WebElement> getCategories = driver.findElements(By.xpath("//div[contains(@class,'Collaborate_excollaborationInner')]//ul/li/a"));
				for (int i = 0; i < getCategories.size(); i++)
				{
					String getLink = getCategories.get(i).getAttribute("href");
					String checkStatus = this.checkURLStatus(getLink);
					if (!checkStatus.contains("fail")) 
					{
						System.out.println("partner page search verification started");
						String courseURL = driver.getCurrentUrl()+"/applied-ai-ibm-professional-certificate/";
						driver.switchTo().newWindow(WindowType.TAB);
						driver.get(courseURL);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
						driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
						statusOfProcess.addAll(this.exploreAllPageProcess());
			 	        driver.close();
			 	        driver.switchTo().window(ParentWindow);
					}
				}
			}
			 if(statusOfProcess.contains("HelpTextFound")||statusOfProcess.contains("recommendedTextFound")||statusOfProcess.contains("explorePageFound")||statusOfProcess.contains("SearchedTextFound"))
 	    	 {
 	    		System.out.println("Partner page search process failed");
 	    		status.add("PartnerPage : "+statusOfProcess.toString());
 	    	 }
 	    	 else
 	    	 {
 	    		 System.out.println("Partner page search process done");
 	    	 }
 	    	 statusOfProcess.clear();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return status;
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
         			 WebElement searchButtonElement = driver.findElement(By.cssSelector(searchButton));
         			 wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement)).click();
                     wait.until(ExpectedConditions.urlContains("/explore"));
                     if(driver.getCurrentUrl().contains("/explore")) 
           	        {
                    	 System.out.println("Successfully navigated to /explore page");
                    	 WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a"));
                    	 js.executeScript("arguments[0].scrollIntoView()", clickSkillupLogo);
                    	 if (clickSkillupLogo.isDisplayed())
                    	 {
                    		 js.executeScript("arguments[0].click()", clickSkillupLogo);
                    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
                    	 }
           	        }
         		}
         		else if(nameOfProcess.equals("mouse"))
         		{
         			
         			 searchBox.sendKeys(dataFromExcel.get(i));
                     WebElement searchButtonElement = driver.findElement(By.cssSelector(searchButton));
                     wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
                     searchButtonElement.click();
                     wait.until(ExpectedConditions.urlContains("/explore"));
          			System.out.println("Invalid data search started");
          			
          			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
          	        if(driver.getCurrentUrl().contains("/explore")) 
          	        {
          	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
          	            System.out.println("Successfully navigated to /explore page");
          	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
          	            
          	            //to verify searched test is present or not in explore all page
          	           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
          	            if(driver.findElements(By.cssSelector("div[class*='CourseSection_courseResultContainer'] div[class*='CourseSection_topFilterResults']")).size()>0)
          	            {
          	            	 WebElement checkTextFromExplorePage = driver.findElement(By.cssSelector("div[class*='CourseSection_courseResultContainer'] div[class*='CourseSection_topFilterResults']"));
              	            js.executeScript("arguments[0].scrollIntoView()", checkTextFromExplorePage);
              	            wait.until(ExpectedConditions.visibilityOf(checkTextFromExplorePage));

              	            if(checkTextFromExplorePage.isDisplayed())
              	            {
              	            	if(checkTextFromExplorePage.getText().contains(dataFromExcel.get(i)))
              	            	{
              	            		System.out.println("Text is displayed on Explore All page" + checkTextFromExplorePage.getText());
              	            	}
              	            }
          	            }
         	            else
         	            {
         	            	System.out.println("searched text no available in explore all - fail");
         	            	statusOfProcess.add("noSearchedText");
         	            }
          	            
          	            //to verify whether data is enabled or not on leftern side
         	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         	            if(driver.findElements(By.cssSelector("div[class*='CourseSection_containerInnerFilter']>div:nth-child(4) div[class*='CourseSection_checkbox'] input[checked]")).size()>0)
         	            {
         	            	System.out.println("search text is selected");
         	            	System.out.println("searched text is available in explore all - fail");
         	            }
         	            else
         	            {
 							System.out.println("search text is not selected");
 							statusOfProcess.add("notEnabled");
         	            }
         	            
         	            //to verify the sentance "Help us find the right course for you."
         	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         	            if(driver.findElements(By.cssSelector("div[class*='CourseSection_alertContent'] h3")).size()>0)
         	            {
         	            	WebElement checkAlertText = driver.findElement(By.cssSelector("div[class*='CourseSection_alertContent'] h3"));
         	            	 js.executeScript("arguments[0].scrollIntoView()", checkAlertText);
         	            	 wait.until(ExpectedConditions.visibilityOf(checkAlertText));
         	            	if (checkAlertText.getText().contains("Help us find the right course for you."))
 							{
 								System.out.println("No results found text is displayed");
 							} 
         	            }
         	            else
 						{
 							System.out.println("No results found text is not displayed");
 							statusOfProcess.add("Help us find the right course for you. text not displayed");
 						}
         	            
         	            //Recommended Courses text verification
         	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         	            if(driver.findElements(By.cssSelector("div[class*='CourseSection_RecommCourse']>h2")).size()>0)
         	            {
         	            	
         	            	WebElement checkRecommendCourseText = driver.findElement(By.cssSelector("div[class*='CourseSection_RecommCourse']>h2"));
         	            	 js.executeScript("arguments[0].scrollIntoView()", checkRecommendCourseText);
         	            	 wait.until(ExpectedConditions.visibilityOf(checkRecommendCourseText));
         	            	if (checkRecommendCourseText.getText().contains("Recommended Courses"))
 							{
 								System.out.println("Recommended Courses text is displayed");
 							}
         	            }
         	            else 
 						{
 							System.out.println("Recommended Courses text is not displayed");
 							statusOfProcess.add("recommended courses text not displayed");
 						}
          	        }
          	        else
          	        {
          	        	System.out.println("Navigation to /explore page failed");
          	            statusOfProcess.add("explore all page not faced");
          	        }
         		}

         		}
         	       
         		if((dataFromExcel.size() - 1) == i)
         		{
         			break;
         		}
         	}
         WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a"));
    	 js.executeScript("arguments[0].scrollIntoView()", clickSkillupLogo);
    	 if (clickSkillupLogo.isDisplayed())
    	 {
    		 js.executeScript("arguments[0].click()", clickSkillupLogo);
    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
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
        	
        	System.out.println("search category process done");
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
    	System.out.println("search course process done");
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
	
	public ArrayList<String> searchBlankResultValidationProcess(ArrayList<String> dataFromExcel)
	{
		System.out.println("search Invalid process started");
		String nameOfEvent = "";
        ArrayList<String> validationStatus = new ArrayList<String>();
        validationStatus.add("HomePage");
        validationStatus.add("coursePage");
        validationStatus.add("programPage");
        validationStatus.add("FAQPage");
        validationStatus.add("GOIPage");
        validationStatus.add("CategoryPage");
        validationStatus.add("PartnerPage");
        
        try
        {
        	for(int i = 0; i < validationStatus.size(); i++)
        	{
				switch (validationStatus.get(i))
				{
				case "HomePage":
					System.out.println("HomePage Validation Started");
					nameOfEvent = "HomePage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "coursePage":
					System.out.println("coursePage Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "coursePage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "programPage":
					System.out.println("programPage Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "programPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "FAQPage":
					System.out.println("FAQPage Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "FAQPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "GOIPage":
					System.out.println("GOIPage Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "GOIPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "CategoryPage":
					System.out.println("CategoryPage Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "CategoryPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "PartnerPage":
					System.out.println("PartnerPage Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "PartnerPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				}
        	}
        }
        catch (Exception e) 
        {
        	e.printStackTrace();
        }
		return validationStatus;
	}
	
	public ArrayList<String> searchBlogPageProcess()
	{
		System.out.println("search blog page process started");
		String nameOfEvent = "";
        ArrayList<String> validationStatus = new ArrayList<String>();
        validationStatus.add("searchCourseProgramByLetter");
        validationStatus.add("searchCourseProgramByFullName");
        validationStatus.add("selectFromSuggestionList");
        try
        {
        	for(int i = 0; i < validationStatus.size(); i++)
        	{
				switch (validationStatus.get(i))
				{
				case "searchCourseProgramByLetter":
					System.out.println("searchCourseProgramByLetter  Validation Started");
					nameOfEvent = "searchCourseProgramByLetter";
					validationStatus.addAll(this.searchFunctionForBlog(nameOfEvent));
					break;
				case "searchCourseProgramByFullName":
					System.out.println("searchCourseProgramByFullName Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "searchCourseProgramByFullName";
					validationStatus.addAll(this.searchFunctionForBlog( nameOfEvent));
					break;
				case "selectFromSuggestionList":
					System.out.println("selectFromSuggestionList Validation Started");
					driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "selectFromSuggestionList";
					validationStatus.addAll(this.searchFunctionForBlog( nameOfEvent));
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
        }
		return validationStatus;
	}
	
	public ArrayList<String> searchFunctionForBlog(String nameOfProcess)
	{
		 ArrayList<String> statusOfProcess = new ArrayList<String>();
		 ArrayList<String> status = new ArrayList<String>();
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		try
		{
			
			if(nameOfProcess.equals("searchCourseProgramByLetter"))
	 		{
				if(driver.findElements(By.xpath("//ul[contains(@class,'list-unstyled navbar-nav nav Header_navLinks')]/li/a[contains(text(),'Blog')]")).size()>0)
				{
					WebElement clickBlog = driver.findElement(By.xpath("//ul[contains(@class,'list-unstyled navbar-nav nav Header_navLinks')]/li/a[contains(text(),'Blog')]"));
					js.executeScript("arguments[0].scrollIntoView()", clickBlog);
					wait.until(ExpectedConditions.elementToBeClickable(clickBlog)).click();
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
				
				 WebElement searchBox = driver.findElement(By.cssSelector(searchField));
				 js.executeScript("arguments[0].scrollIntoView()", searchBox);

			    if (searchBox.isDisplayed()) 
			    {
				     searchBox.sendKeys("az");
				     if(driver.findElements(By.xpath("//ul[@id='suggestions']/li/a")).size()>0)
				     {
				    	 List<WebElement> checkSuggestions = driver.findElements(By.xpath("//ul[@id='suggestions']/li/a"));
				    	 for(WebElement suggestions : checkSuggestions)
                    	 {
				    		 String getCourse = suggestions.getText();
				    		 if(getCourse.contains("Authorization and Identity Management in Azure"))
				    		 {
									suggestions.click();
									break;
				    		 }
                    	 }
				     }
				    	 
						/*
						 * WebElement searchButtonElement =
						 * driver.findElement(By.cssSelector(searchButton));
						 * wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
						 * searchButtonElement.click();
						 */

			        wait.until(ExpectedConditions.urlContains("/explore"));
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
			        if (driver.getCurrentUrl().contains("/explore"))
			        {
			        	System.out.println("explore page");
			        	if(driver.findElements(By.xpath("//p[contains(text(),'Authorization and Identity Management in Azure')]")).size()>0)
			        	{
			        		System.out.println("searched course is available in blog page");
			        	}
			        	else
			        	{
                    		statusOfProcess.add("searched course is not available in blog page");
			        	}
			        }
			        else
			        {
			        	statusOfProcess.add("explore page not facing in blog page when seach letter");
			        }
			    }
			     WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a"));
	 	    	 js.executeScript("arguments[0].scrollIntoView()", clickSkillupLogo);
	 	    	 if (clickSkillupLogo.isDisplayed())
	 	    	 {
	 	    		 js.executeScript("arguments[0].click()", clickSkillupLogo);
	 	    	 }
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
	 		}
			else if(nameOfProcess.equals("searchCourseProgramByFullName"))
			{
				if(driver.findElements(By.xpath("//ul[contains(@class,'list-unstyled navbar-nav nav Header_navLinks')]/li/a[contains(text(),'Blog')]")).size()>0)
				{
					WebElement clickBlog = driver.findElement(By.xpath("//ul[contains(@class,'list-unstyled navbar-nav nav Header_navLinks')]/li/a[contains(text(),'Blog')]"));
					js.executeScript("arguments[0].scrollIntoView()", clickBlog);
					wait.until(ExpectedConditions.elementToBeClickable(clickBlog)).click();
				}
				WebElement searchBox = driver.findElement(By.cssSelector(searchField));
				js.executeScript("arguments[0].scrollIntoView()", searchBox);

			    if (searchBox.isDisplayed()) 
			    {
				     searchBox.sendKeys("Deep Learning Fundamentals");
				     if(driver.findElements(By.xpath("//ul[@id='suggestions']/li/a")).size()>0)
				     {
				    	 List<WebElement> checkSuggestions = driver.findElements(By.xpath("//ul[@id='suggestions']/li/a"));
				    	 for(WebElement suggestions : checkSuggestions)
                   	 {
				    		 String getCourse = suggestions.getText();
				    		 if(getCourse.contains("Deep Learning Fundamentals"))
				    		 {
									suggestions.click();
									break;
				    		 }
                   	 }
				     }
				    	 
						/*
						 * WebElement searchButtonElement =
						 * driver.findElement(By.cssSelector(searchButton));
						 * wait.until(ExpectedConditions.elementToBeClickable(searchButtonElement));
						 * searchButtonElement.click();
						 */

			        wait.until(ExpectedConditions.urlContains("/explore"));
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
			        if (driver.getCurrentUrl().contains("/explore"))
			        {
			        	System.out.println("explore page");
			        	if(driver.findElements(By.xpath("//p[contains(text(),'Authorization and Identity Management in Azure')]")).size()>0)
			        	{
			        		System.out.println("searched course name is available in blog page");
			        	}
			        	else
			        	{
                   		statusOfProcess.add("searched course name is not available in blog page");
			        	}
			        }
			        else
			        {
			        	statusOfProcess.add("explore page not facing in blog page when seach letter");
			        }
			    }
			    WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a"));
	 	    	 js.executeScript("arguments[0].scrollIntoView()", clickSkillupLogo);
	 	    	 if (clickSkillupLogo.isDisplayed())
	 	    	 {
	 	    		 js.executeScript("arguments[0].click()", clickSkillupLogo);
	 	    	 }
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
