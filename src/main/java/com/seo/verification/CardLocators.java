package com.seo.verification;

import java.util.HashMap;
import java.util.Map;

public class CardLocators 
{
	private static final Map<String, Map<String, String>> pageLocators = new HashMap<String, Map<String, String>>();
	
	static
	{
		Map<String, String> aiLocators = new HashMap<>();
        aiLocators.put("programShowmore", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show more')]");
        aiLocators.put("programShowless", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show less')]");
        aiLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        aiLocators.put("programCardImage", ".//img[@alt='course-image']");
        aiLocators.put("programCardIcon", ".//div[contains(@class,'FlatCourseCard_topRightSide')]//img[@alt='Course-Image']");
        aiLocators.put("programCardLabel", ".//h3[contains(@class,'FlatCourseCard_courseType')]");
        aiLocators.put("programCardName", ".//div[contains(@class,'FlatCourseCard_courseDescription')]/h2");
        aiLocators.put("programCardLevel", ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li");
        aiLocators.put("programCardPartner", ".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        aiLocators.put("programCardEnrollStatus", ".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Enrollment Status')]/following-sibling::p");
        aiLocators.put("programCardPrice", ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3[not(@span)]");
      
        
        aiLocators.put("coursesShowmore", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//button[contains(text(),'Show more')]");
        aiLocators.put("coursesShowless", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//button[contains(text(),'Show less')]");
        aiLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        aiLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        aiLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        aiLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        aiLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        aiLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        aiLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        aiLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        aiLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");
        
        aiLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        aiLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        aiLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        aiLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        aiLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        aiLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        aiLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        aiLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        aiLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        pageLocators.put("Artificial", aiLocators);
        
        Map<String, String> azureLocators = new HashMap<>();
        azureLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        azureLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        azureLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
       
        azureLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        azureLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        azureLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        azureLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        azureLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        azureLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        azureLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        azureLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        azureLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        pageLocators.put("Azure", azureLocators);
        
        Map<String, String> bigDataLocators = new HashMap<>();
        bigDataLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        bigDataLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        bigDataLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        bigDataLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[6]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        bigDataLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        bigDataLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        bigDataLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        bigDataLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        bigDataLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        bigDataLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        bigDataLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        bigDataLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        bigDataLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");

        pageLocators.put("BigData", bigDataLocators);
        
        Map<String, String> businessApplicationLocators = new HashMap<>();
        businessApplicationLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        businessApplicationLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        businessApplicationLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        businessApplicationLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        businessApplicationLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        businessApplicationLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        businessApplicationLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        businessApplicationLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        businessApplicationLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        businessApplicationLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        businessApplicationLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        businessApplicationLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");

        pageLocators.put("BusinessApplication", businessApplicationLocators);
        
        Map<String, String> blockchainLocators = new HashMap<>();
        blockchainLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]//a");
       
        blockchainLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        blockchainLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        blockchainLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        blockchainLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        blockchainLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        blockchainLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        blockchainLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        blockchainLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        blockchainLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");

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
        
        humanskillsLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        humanskillsLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        humanskillsLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        humanskillsLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        humanskillsLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        humanskillsLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        humanskillsLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        humanskillsLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        humanskillsLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");

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
