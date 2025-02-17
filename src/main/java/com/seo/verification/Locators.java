package com.seo.verification;

import java.util.HashMap;
import java.util.Map;

public class Locators 
{
	private static final Map<String, Map<String, String>> pageLocators = new HashMap<String, Map<String, String>>();
	
	static
	{
		Map<String, String> aiLocators = new HashMap<>();
        aiLocators.put("programShowmore", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show more')]");
        aiLocators.put("programShowless", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show less')]");
        aiLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        aiLocators.put("coursesShowmore", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//button[contains(text(),'Show more')]");
        aiLocators.put("coursesShowless", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//button[contains(text(),'Show less')]");
        aiLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("Artificial", aiLocators);
        
        Map<String, String> azureLocators = new HashMap<>();
        azureLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        azureLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        azureLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("Azure", azureLocators);
        
        Map<String, String> bigDataLocators = new HashMap<>();
        bigDataLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        bigDataLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        bigDataLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        bigDataLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[6]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("BigData", bigDataLocators);
        
        Map<String, String> businessApplicationLocators = new HashMap<>();
        businessApplicationLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        businessApplicationLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        businessApplicationLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("BusinessApplication", businessApplicationLocators);
        
        Map<String, String> blockchainLocators = new HashMap<>();
        blockchainLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("Blockchain", blockchainLocators);
        
        Map<String, String> cloudComputingLocators = new HashMap<>();
        cloudComputingLocators.put("programShowmore", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show more')]");
        cloudComputingLocators.put("programShowless", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show less')]");
        cloudComputingLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        pageLocators.put("CloudComputing", cloudComputingLocators);
        
        Map<String, String> cybersecurityLocators = new HashMap<>();
        cybersecurityLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        cybersecurityLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("CyberSecurity", cybersecurityLocators);
        
        Map<String, String> dataAnalyticsLocators = new HashMap<>();
        dataAnalyticsLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        dataAnalyticsLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("DataAnalytics", dataAnalyticsLocators);
        
        Map<String, String> dataScienceLocators = new HashMap<>();
        dataScienceLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        dataScienceLocators.put("coursesShowmore", "//div[@id='learningCatalogCourses']//button[contains(text(),'Show more')]");
        dataScienceLocators.put("coursesShowless", "//div[@id='learningCatalogCourses']//button[contains(text(),'Show less')]");
        dataScienceLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        pageLocators.put("DataScience", dataScienceLocators);
        
        Map<String, String> humanskillsLocators = new HashMap<>();
        humanskillsLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        humanskillsLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        humanskillsLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("HumanSkills", humanskillsLocators);
        
        Map<String, String> IOTLocators = new HashMap<>();
        IOTLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        pageLocators.put("IoT", IOTLocators);
        
        Map<String, String> modernWorkplaceLocators = new HashMap<>();
        modernWorkplaceLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("ModernWorkplace", modernWorkplaceLocators);
        
        Map<String, String> powerBILocators = new HashMap<>();
        powerBILocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        powerBILocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        powerBILocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("PowerBI", powerBILocators);
        
        Map<String, String> powerPlatformLocators = new HashMap<>();
        powerPlatformLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("PowerPlatform", powerPlatformLocators);
        
        Map<String, String> futureSkillsLocators = new HashMap<>();
        futureSkillsLocators.put("coursesShowmore", "//button[contains(text(),'Show more')]");
        futureSkillsLocators.put("coursesShowless", "//button[contains(text(),'Show less')]");
        futureSkillsLocators.put("courses", "//div[contains(@class,'container-fluid')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("FutureSkills", futureSkillsLocators);
        
        Map<String, String> ibmLocators = new HashMap<>();
        ibmLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]/div/div[contains(@class,'LearningCatalogibm_cardRow')]//a");
        ibmLocators.put("coursesShowmore", "//button[contains(text(),'Show more')]");
        ibmLocators.put("coursesShowless", "//button[contains(text(),'Show less')]");
        ibmLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        pageLocators.put("IBM", ibmLocators);
        
        Map<String, String> microsoftLocators = new HashMap<>();
        microsoftLocators.put("coursesShowmore", "//button[contains(text(),'Show more')]");
        microsoftLocators.put("coursesShowless", "//button[contains(text(),'Show less')]");
        microsoftLocators.put("courses", "//div[contains(@class,'container-fluid')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        microsoftLocators.put( "cardLocator", "//div[contains(@class,'LearningCatalog_cardRow')]//div[contains(@class,'LearningCatalog_customCard')]");
        microsoftLocators.put("cardPartner ",".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        microsoftLocators.put(" cardURL  ",".//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a");
        microsoftLocators.put(" cardCourseLabel ", ".//div[contains(@class,'RegularCourseCard_courseType')]//p[contains(text(),'Course')]");
        microsoftLocators.put(" cardHeading ",".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        microsoftLocators.put(" cardLevel1  ",".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul/li[1]");
        microsoftLocators.put(" cardLevel2 ",".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul/li[2]");
        microsoftLocators.put(" cardLevel3 ",".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul/li[3]");
        microsoftLocators.put(" enrollPriceSection ", ".//div[contains(@class,'RegularCourseCard_priceSection')]");
        microsoftLocators.put(" cardprice  ",".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[contains(text(),'From')]/following-sibling::p");
        microsoftLocators.put(" EnrollStatus = ",".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2");
        
        pageLocators.put("Microsoft", microsoftLocators);
	}
	
	public static String getLocator(String page, String element)
	{
        return pageLocators.getOrDefault(page, new HashMap<>()).get(element);
    }
}
