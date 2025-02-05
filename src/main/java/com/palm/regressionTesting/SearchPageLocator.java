package com.palm.regressionTesting;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageLocator
{
	WebDriver driver;
	
	String searchPage = "";
	String parentPage = "";
	public SearchPageLocator(WebDriver driver) 
	{
		this.driver = driver;
	}

	String searchField = "div[class*='Header_headerRight'] input[id='contentSearch'],[class*='Header_searchInput']";
	String searchButton = "div[class*='Header_headerRight'] button[id='btnCheck'],[class*='Header_searchButton']";
	String listOfCourseCardInExploreAllPage = "//div[contains(@class,'CourseSection_courseResultContainer')]//div[contains(@class,'CourseSection_courseResult')]";


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
	           .sendKeys(Keys.ENTER)  // Press Enter key
	           .perform();

		    // Ensure the text is entered
		   // wait.until(ExpectedConditions.attributeToBe(searchBox, "value", text));
	    
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
			        	//Thread.sleep(3000);
			        	System.out.println("Successfully navigated to /explore page");
			        	WebElement topElement = driver.findElement(By.tagName("body")); // Or any top element
			        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", topElement);

			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			            System.out.println("Successfully navigated to /explore page");
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			            
			            
			            // Verify if searched text is present or not in explore all page
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			            if(driver.findElements(By.xpath("//p[contains(text(),'(0)')]")).size() > 0)
			            {
			                System.out.println("searched text not available in explore all - fail");
			                statusOfProcess.add("SearchedTextNotFound-fail");
			            }

			            // Verify "Help us find the right course for you" text
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			            if(driver.findElements(By.xpath("//h3[contains(text(),'Help us find the right course for you.')]")).size() > 0) {
			                System.out.println("Help us find the right course for you. text is displayed");
			                statusOfProcess.add("HelpTextFound-fail");
			            }

			            // Verify "Recommended Courses" text
			            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			            if(driver.findElements(By.xpath("//h2[contains(text(),'Recommended Courses')]")).size() > 0) {
			                System.out.println("Recommended Courses text is displayed");
			                statusOfProcess.add("recommendedTextFound-fail");
			            }
			        }
			    } 
			    else 
			    {
			        System.out.println("explore all page not faced - fail");
			        statusOfProcess.add("explorePageNotFound-fail");
			    }
			} 
			catch (Exception e)
			{
			    e.printStackTrace();
			    statusOfProcess.add("exception");
			}
		
	        return statusOfProcess;
	}
	
	
	public ArrayList<String> searchFunctionForBlankPage(String nameOfProcess)
	{
	 ArrayList<String> statusOfProcess = new ArrayList<String>();
	 ArrayList<String> status = new ArrayList<String>();
     JavascriptExecutor js = (JavascriptExecutor) driver;
	try
	{
		String ParentWindow  = "";
		if(nameOfProcess.equals("HomePage"))
 		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
			statusOfProcess.addAll(this.exploreAllPageProcess());
			
 	         WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a|//img[@alt='logo']"));
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
 	    		 status.add("Home page- fail: "+statusOfProcess.toString());
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
 	    	   status.add("course page fail: " +statusOfProcess.toString());
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
 	    	   status.add("program page fail : "+statusOfProcess.toString());
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
	    		status.add("FAQPage fail : "+statusOfProcess.toString());
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
	    		status.add("GOIPage fail : "+statusOfProcess.toString());
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
 	    		status.add("CategoryPage fail : "+statusOfProcess.toString());
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
 	    		status.add("PartnerPage fail : "+statusOfProcess.toString());
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
		statusOfProcess.add("exception");
	}
	return status;
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
                     if(driver.getCurrentUrl().contains("/explore")) 
           	        {
                    	 WebElement topElement = driver.findElement(By.tagName("body")); // Or any top element
                    	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", topElement);

                    	 System.out.println("Successfully navigated to /explore page");
                    	 WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a|//img[@alt='logo']|//header[@id='headerBody']//div[@class='navbar-brand']/a|//img[@alt='logo']"));
                    	 js.executeScript("arguments[0].scrollIntoView()", clickSkillupLogo);
                    	 if (clickSkillupLogo.isDisplayed())
                    	 {
                    		 js.executeScript("arguments[0].click()", clickSkillupLogo);
                    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
                    	 }
           	        }
                     else
                     {
                    	 statusOfProcess.add("explore all page not visible in - keyboard fail");
                     }
         		}
         		else if(nameOfProcess.equals("mouse"))
         		{
         			
         			 searchBox.sendKeys(dataFromExcel.get(i));
                     WebElement searchButtonElement = driver.findElement(By.cssSelector(searchButton));
                     js.executeScript("arguments[0].scrollIntoView()", searchButtonElement);
                     js.executeScript("arguments[0].click()", searchButtonElement);
                     wait.until(ExpectedConditions.urlContains("/explore"));
          			System.out.println("Invalid data search started");
          			
          			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
          	        if(driver.getCurrentUrl().contains("/explore")) 
          	        {
          	        	WebElement topElement = driver.findElement(By.tagName("body")); // Or any top element
          	        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", topElement);

          	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
          	            System.out.println("Successfully navigated to /explore page");
          	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
          	            js.executeScript("window.scrollTo(0, 0);");
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
         	            	System.out.println("searched text no available in explore all - fail in  search process");
         	            	statusOfProcess.add("noSearchedText");
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
 								System.out.println("No results found text is displayed ");
 							} 
         	            }
         	            else
 						{
 							System.out.println("No results found text is not displayed");
 							statusOfProcess.add("Help us find the right course for you. text not displayed ");
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
 							statusOfProcess.add("recommended courses text not displayed ");
 						}
          	        }
          	        else
          	        {
          	        	System.out.println("Navigation to /explore page failed");
          	            statusOfProcess.add("explore all page not faced  - mouse");
          	        }
         		}

         		}
         	       
         		if((dataFromExcel.size() - 1) == i)
         		{
         			break;
         		}
         	}
         WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a|//img[@alt='logo']"));
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
			statusOfProcess.add("exception ");
	}
	return statusOfProcess;
}

public ArrayList<String> searchCategoryProcess(ArrayList<String> dataFromExcel) 
{
	parentPage = driver.getWindowHandle();
	String getParentWindowURL = driver.getCurrentUrl();
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get(getParentWindowURL);
	searchPage = driver.getWindowHandle();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
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
					System.out.println("search category process done in keyboard");
					break;
				case "MouseEvent":
					System.out.println("MouseEvent Validation Started");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "mouse";
					validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
					System.out.println("search category process done in mouse");
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
				System.out.println("search course process done in keyboard");
				break;
			case "MouseEvent":
				System.out.println("MouseEvent Validation Started");
				//driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				nameOfEvent = "mouse";
				validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
				System.out.println("search course process done in mouse");
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
				System.out.println("search program process done in keyboard");
				break;
			case "MouseEvent":
				System.out.println("MouseEvent Validation Started");
				//driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				nameOfEvent = "mouse";
				validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
				System.out.println("search program process done in mouse");
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
					System.out.println("search invalid process done in keyboard");
					break;
				case "MouseEvent":
					System.out.println("MouseEvent Validation Started");
					//driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "mouse";
					validationStatus.addAll(this.searchFunction(dataFromExcel, nameOfEvent));
					System.out.println("search invalid process done in mouse");
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
					//driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "coursePage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "programPage":
					System.out.println("programPage Validation Started");
					//driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "programPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "FAQPage":
					System.out.println("FAQPage Validation Started");
					//driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "FAQPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "GOIPage":
					System.out.println("GOIPage Validation Started");
					//driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "GOIPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "CategoryPage":
					System.out.println("CategoryPage Validation Started");
					//driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "CategoryPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				case "PartnerPage":
					System.out.println("PartnerPage Validation Started");
					//driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "PartnerPage";
					validationStatus.addAll(this.searchFunctionForBlankPage(nameOfEvent));
					break;
				}
        	}
        	driver.switchTo().window(searchPage);
        	driver.close();
        	driver.switchTo().window(parentPage);
        }
        catch (Exception e) 
        {
        	e.printStackTrace();
        	validationStatus.add("exception");
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
				//	driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
					nameOfEvent = "searchCourseProgramByFullName";
					validationStatus.addAll(this.searchFunctionForBlog( nameOfEvent));
					break;
				case "selectFromSuggestionList":
					System.out.println("selectFromSuggestionList Validation Started");
				//	driver.findElement(By.cssSelector("div[class='navbar-brand']>a")).click();
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
				    	 

			        wait.until(ExpectedConditions.urlContains("/explore"));
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
			        if (driver.getCurrentUrl().contains("/explore"))
			        {
			        	System.out.println("explore page");
			        	js.executeScript("window.scrollTo(0, 0);");
			        	if(driver.findElements(By.xpath("//p[contains(text(),'Authorization and Identity Management in Azure')]")).size()>0)
			        	{
			        		System.out.println("searched course is available in blog page");
			        	}
			        	else
			        	{
                    		statusOfProcess.add("searched course is not available in blog page - fail");
			        	}
			        }
			        else
			        {
			        	statusOfProcess.add("explore page not facing in blog page when search letter - fail");
			        }
			    }
			     WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a|//img[@alt='logo']"));
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
				    	 

			        wait.until(ExpectedConditions.urlContains("/explore"));
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
			        if (driver.getCurrentUrl().contains("/explore"))
			        {
			        	System.out.println("explore page");
			        	js.executeScript("window.scrollTo(0, 0);");
			        	if(driver.findElements(By.xpath("//p[contains(text(),'Authorization and Identity Management in Azure')]")).size()>0)
			        	{
			        		System.out.println("searched course name is available in blog page");
			        	}
			        	else
			        	{
                   		statusOfProcess.add("searched course name is not available in blog page - fail");
			        	}
			        }
			        else
			        {
			        	statusOfProcess.add("explore page not facing in blog page when seach letter - fail");
			        }
			    }
			    WebElement clickSkillupLogo = driver.findElement(By.xpath("//header[@id='headerBody']//div[@class='navbar-brand']/a|//img[@alt='logo']"));
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
