package com.seo.card;

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
        aiLocators.put("programCardEnrollIsClose", "");
        aiLocators.put("programCardEnrollStartedStatus", "");
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
        
        aiLocators.put("coursePageImage", "//div[contains(@class,'CourseMain_mainSection')]/div[2]/div[@id='videoOrImage']//following-sibling::img|//div[contains(@class,'container-fluid CourseMain_containerInner')]/div/div[2]//following-sibling::img[@alt]");
        aiLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        aiLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        aiLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        aiLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        aiLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        aiLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        aiLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        aiLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        aiLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        aiLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        aiLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("Artificial", aiLocators);
        
        Map<String, String> azureLocators = new HashMap<>();
        azureLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        azureLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        azureLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
       
        
        azureLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        azureLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        azureLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        azureLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        azureLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        azureLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        azureLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        azureLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        azureLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        azureLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        azureLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        azureLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        azureLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        azureLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        azureLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        azureLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        azureLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        azureLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        azureLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        azureLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("Azure", azureLocators);
        
        Map<String, String> bigDataLocators = new HashMap<>();
        bigDataLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
       
        bigDataLocators.put("programCardImage", ".//img[@alt='course-image']");
        bigDataLocators.put("programCardIcon", ".//div[contains(@class,'FlatCourseCard_topRightSide')]//img[@alt='Course-Image']");
        bigDataLocators.put("programCardLabel", ".//h3[contains(@class,'FlatCourseCard_courseType')]");
        bigDataLocators.put("programCardName", ".//div[contains(@class,'FlatCourseCard_courseDescription')]/h2");
        bigDataLocators.put("programCardLevel", ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li");
        bigDataLocators.put("programCardPartner", ".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        bigDataLocators.put("programCardEnrollStatus", ".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Enrollment Status')]/following-sibling::p");
        bigDataLocators.put("programCardEnrollIsClose", "");
        bigDataLocators.put("programCardEnrollStartedStatus", "");
        bigDataLocators.put("programCardPrice", ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3[not(@span)]");

        
        bigDataLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        bigDataLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        bigDataLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[6]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        
        bigDataLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        bigDataLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        bigDataLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        bigDataLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        bigDataLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        bigDataLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        bigDataLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        bigDataLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        bigDataLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        bigDataLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        bigDataLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        bigDataLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        bigDataLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        bigDataLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        bigDataLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        bigDataLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        bigDataLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        bigDataLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        bigDataLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        bigDataLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("BigData", bigDataLocators);
        
        Map<String, String> businessApplicationLocators = new HashMap<>();
        businessApplicationLocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        businessApplicationLocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        businessApplicationLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        businessApplicationLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        businessApplicationLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        businessApplicationLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        businessApplicationLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        businessApplicationLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        businessApplicationLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        businessApplicationLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        businessApplicationLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        businessApplicationLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        businessApplicationLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        businessApplicationLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        businessApplicationLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        businessApplicationLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        businessApplicationLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        businessApplicationLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        businessApplicationLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        businessApplicationLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        businessApplicationLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        businessApplicationLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        businessApplicationLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("BusinessApplication", businessApplicationLocators);
        
        Map<String, String> blockchainLocators = new HashMap<>();
        blockchainLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]//a");
       
        blockchainLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        blockchainLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        blockchainLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        blockchainLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        blockchainLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        blockchainLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        blockchainLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        blockchainLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        blockchainLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        blockchainLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        blockchainLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        blockchainLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        blockchainLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        blockchainLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        blockchainLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        blockchainLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        blockchainLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        blockchainLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        blockchainLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        blockchainLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("Blockchain", blockchainLocators);
        
        Map<String, String> cloudComputingLocators = new HashMap<>();
        cloudComputingLocators.put("programShowmore", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show more')]");
        cloudComputingLocators.put("programShowless", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]//button[contains(text(),'Show less')]");
        cloudComputingLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        
        cloudComputingLocators.put("programCardImage", ".//img[@alt='course-image']");
        cloudComputingLocators.put("programCardIcon", ".//div[contains(@class,'FlatCourseCard_topRightSide')]//img[@alt='Course-Image']");
        cloudComputingLocators.put("programCardLabel", ".//h3[contains(@class,'FlatCourseCard_courseType')]");
        cloudComputingLocators.put("programCardName", ".//div[contains(@class,'FlatCourseCard_courseDescription')]/h2");
        cloudComputingLocators.put("programCardLevel", ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li");
        cloudComputingLocators.put("programCardPartner", ".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        cloudComputingLocators.put("programCardEnrollStatus", ".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Enrollment Status')]/following-sibling::p");
        cloudComputingLocators.put("programCardEnrollIsClose", "");
        cloudComputingLocators.put("programCardEnrollStartedStatus", "");
        cloudComputingLocators.put("programCardPrice", ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3[not(@span)]");

        cloudComputingLocators.put("coursePageImage", "//div[contains(@class,'CourseMain_mainSection')]/div[2]/div[@id='videoOrImage']//following-sibling::img|//div[contains(@class,'container-fluid CourseMain_containerInner')]/div/div[2]//following-sibling::img[@alt]");
        cloudComputingLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        cloudComputingLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        cloudComputingLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        cloudComputingLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        cloudComputingLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        cloudComputingLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        cloudComputingLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        cloudComputingLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        cloudComputingLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        cloudComputingLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        cloudComputingLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("CloudComputing", cloudComputingLocators);
        
        Map<String, String> cybersecurityLocators = new HashMap<>();
        cybersecurityLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
       
        cybersecurityLocators.put("programCardImage", ".//img[@alt='course-image']");
        cybersecurityLocators.put("programCardIcon", ".//div[contains(@class,'FlatCourseCard_topRightSide')]//img[@alt='Course-Image']");
        cybersecurityLocators.put("programCardLabel", ".//h3[contains(@class,'FlatCourseCard_courseType')]");
        cybersecurityLocators.put("programCardName", ".//div[contains(@class,'FlatCourseCard_courseDescription')]/h2");
        cybersecurityLocators.put("programCardLevel", ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li");
        cybersecurityLocators.put("programCardPartner", ".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        cybersecurityLocators.put("programCardEnrollStatus", ".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Enrollment Status')]/following-sibling::p");
        cybersecurityLocators.put("programCardPrice", ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3[not(@span)]");
        cybersecurityLocators.put("programCardEnrollIsClose", "");
        cybersecurityLocators.put("programCardEnrollStartedStatus", "");
        
        
        cybersecurityLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        cybersecurityLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        cybersecurityLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        cybersecurityLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        cybersecurityLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        cybersecurityLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        cybersecurityLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        cybersecurityLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        cybersecurityLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        cybersecurityLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        cybersecurityLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        cybersecurityLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        cybersecurityLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        cybersecurityLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        cybersecurityLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        cybersecurityLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        cybersecurityLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        cybersecurityLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        cybersecurityLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        cybersecurityLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        cybersecurityLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("CyberSecurity", cybersecurityLocators);
        
        Map<String, String> dataAnalyticsLocators = new HashMap<>();
        dataAnalyticsLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
       
        dataAnalyticsLocators.put("programCardImage", ".//img[@alt='course-image']");
        dataAnalyticsLocators.put("programCardIcon", ".//div[contains(@class,'FlatCourseCard_topRightSide')]//img[@alt='Course-Image']");
        dataAnalyticsLocators.put("programCardLabel", ".//h3[contains(@class,'FlatCourseCard_courseType')]");
        dataAnalyticsLocators.put("programCardName", ".//div[contains(@class,'FlatCourseCard_courseDescription')]/h2");
        dataAnalyticsLocators.put("programCardLevel", ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li");
        dataAnalyticsLocators.put("programCardPartner", ".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        dataAnalyticsLocators.put("programCardEnrollStatus", ".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Enrollment Status')]/following-sibling::p");
        dataAnalyticsLocators.put("programCardEnrollIsClose", "");
        dataAnalyticsLocators.put("programCardEnrollStartedStatus", "");
        dataAnalyticsLocators.put("programCardPrice", ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3[not(@span)]");

        
        dataAnalyticsLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        dataAnalyticsLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        dataAnalyticsLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        dataAnalyticsLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        dataAnalyticsLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        dataAnalyticsLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        dataAnalyticsLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        dataAnalyticsLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        dataAnalyticsLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        dataAnalyticsLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        dataAnalyticsLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        dataAnalyticsLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        dataAnalyticsLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        dataAnalyticsLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        dataAnalyticsLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        dataAnalyticsLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        dataAnalyticsLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        dataAnalyticsLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        dataAnalyticsLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        dataAnalyticsLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        dataAnalyticsLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        
        pageLocators.put("DataAnalytics", dataAnalyticsLocators);
        
        Map<String, String> dataScienceLocators = new HashMap<>();
        dataScienceLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        
        dataScienceLocators.put("programCardImage", ".//img[@alt='course-image']");
        dataScienceLocators.put("programCardIcon", ".//div[contains(@class,'FlatCourseCard_topRightSide')]//img[@alt='Course-Image']");
        dataScienceLocators.put("programCardLabel", ".//h3[contains(@class,'FlatCourseCard_courseType')]");
        dataScienceLocators.put("programCardName", ".//div[contains(@class,'FlatCourseCard_courseDescription')]/h2");
        dataScienceLocators.put("programCardLevel", ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li");
        dataScienceLocators.put("programCardPartner", ".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        dataScienceLocators.put("programCardEnrollStatus", ".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Enrollment Status')]/following-sibling::p");
        dataScienceLocators.put("programCardEnrollIsClose", "");
        dataScienceLocators.put("programCardEnrollStartedStatus", "");
        dataScienceLocators.put("programCardPrice", ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3[not(@span)]");

        
        dataScienceLocators.put("coursesShowmore", "//div[@id='learningCatalogCourses']//button[contains(text(),'Show more')]");
        dataScienceLocators.put("coursesShowless", "//div[@id='learningCatalogCourses']//button[contains(text(),'Show less')]");
        dataScienceLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        dataScienceLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        dataScienceLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        dataScienceLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        dataScienceLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        dataScienceLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        dataScienceLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        dataScienceLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        dataScienceLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        dataScienceLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        dataScienceLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        dataScienceLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        dataScienceLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        dataScienceLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        dataScienceLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        dataScienceLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        dataScienceLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        dataScienceLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        dataScienceLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        dataScienceLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        dataScienceLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        
        pageLocators.put("DataScience", dataScienceLocators);
        
        Map<String, String> devOpsLocators = new HashMap<>();
        devOpsLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
        
        devOpsLocators.put("programCardImage", ".//img[@alt='course-image']");
        devOpsLocators.put("programCardIcon", ".//div[contains(@class,'FlatCourseCard_topRightSide')]//img[@alt='Course-Image']");
        devOpsLocators.put("programCardLabel", ".//h3[contains(@class,'FlatCourseCard_courseType')]");
        devOpsLocators.put("programCardName", ".//div[contains(@class,'FlatCourseCard_courseDescription')]/h2");
        devOpsLocators.put("programCardLevel", ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li");
        devOpsLocators.put("programCardPartner", ".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        devOpsLocators.put("programCardEnrollStatus", ".//*[contains(text(),'Enrollment Status')]//following-sibling::h4");
        devOpsLocators.put("programCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]");
        devOpsLocators.put("programCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p");
        devOpsLocators.put("programCardPrice", ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3[not(@span)]");

        
        devOpsLocators.put("coursesShowmore", "//div[@id='learningCatalogCourses']//button[contains(text(),'Show more')]");
        devOpsLocators.put("coursesShowless", "//div[@id='learningCatalogCourses']//button[contains(text(),'Show less')]");
        devOpsLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        devOpsLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        devOpsLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        devOpsLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        devOpsLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        devOpsLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        devOpsLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        devOpsLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        devOpsLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        devOpsLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        devOpsLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        devOpsLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        devOpsLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        devOpsLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        devOpsLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        devOpsLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        devOpsLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        devOpsLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        devOpsLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        devOpsLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        devOpsLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        
        pageLocators.put("DevOps", devOpsLocators);
        
        Map<String, String> humanskillsLocators = new HashMap<>();
        humanskillsLocators.put("coursesShowmore", "//button[contains(text(),'Show more')]");
        humanskillsLocators.put("coursesShowless", "//button[contains(text(),'Show less')]");
        humanskillsLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        humanskillsLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        humanskillsLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        humanskillsLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        humanskillsLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        humanskillsLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        humanskillsLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        humanskillsLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        humanskillsLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 
        humanskillsLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        humanskillsLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        humanskillsLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        humanskillsLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        humanskillsLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        humanskillsLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        humanskillsLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        humanskillsLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        humanskillsLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        humanskillsLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        humanskillsLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        humanskillsLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        humanskillsLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("HumanSkills", humanskillsLocators);
        
        Map<String, String> IOTLocators = new HashMap<>();
        IOTLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div/div[3]//a");
       
        IOTLocators.put("programCardImage", ".//img[@alt='course-image']");
        IOTLocators.put("programCardIcon", ".//div[contains(@class,'FlatCourseCard_topRightSide')]//img[@alt='Course-Image']");
        IOTLocators.put("programCardLabel", ".//h3[contains(@class,'FlatCourseCard_courseType')]");
        IOTLocators.put("programCardName", ".//div[contains(@class,'FlatCourseCard_courseDescription')]/h2");
        IOTLocators.put("programCardLevel", ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li");
        IOTLocators.put("programCardPartner", ".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        IOTLocators.put("programCardEnrollStatus", ".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Enrollment Status')]/following-sibling::p");
        IOTLocators.put("programCardEnrollIsClose", "");
        IOTLocators.put("programCardEnrollStartedStatus", "");
        IOTLocators.put("programCardPrice", ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3[not(@span)]");

        IOTLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        IOTLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        IOTLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        IOTLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        IOTLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        IOTLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        IOTLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        IOTLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        IOTLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        IOTLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        IOTLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        IOTLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("IoT", IOTLocators);
        
        Map<String, String> modernWorkplaceLocators = new HashMap<>();
        modernWorkplaceLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
       
        modernWorkplaceLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        modernWorkplaceLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        modernWorkplaceLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        modernWorkplaceLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        modernWorkplaceLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        modernWorkplaceLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        modernWorkplaceLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        modernWorkplaceLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        modernWorkplaceLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        modernWorkplaceLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        modernWorkplaceLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        modernWorkplaceLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        modernWorkplaceLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        modernWorkplaceLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        modernWorkplaceLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        modernWorkplaceLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        modernWorkplaceLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        modernWorkplaceLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        modernWorkplaceLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        modernWorkplaceLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("ModernWorkplace", modernWorkplaceLocators);
        
        Map<String, String> powerBILocators = new HashMap<>();
        powerBILocators.put("coursesShowmore", "//section[@id='scrollToTop']//button[contains(text(),'Show more')]");
        powerBILocators.put("coursesShowless", "//section[@id='scrollToTop']//button[contains(text(),'Show less')]");
        powerBILocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[1]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        powerBILocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        powerBILocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        powerBILocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        powerBILocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        powerBILocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        powerBILocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        powerBILocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        powerBILocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        powerBILocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        powerBILocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        powerBILocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        powerBILocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        powerBILocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        powerBILocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        powerBILocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        powerBILocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        powerBILocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        powerBILocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        powerBILocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        powerBILocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("PowerBI", powerBILocators);
        
        Map<String, String> powerPlatformLocators = new HashMap<>();
        powerPlatformLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]//a");
      
        powerPlatformLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        powerPlatformLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        powerPlatformLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        powerPlatformLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        powerPlatformLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        powerPlatformLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        powerPlatformLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        powerPlatformLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        powerPlatformLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        powerPlatformLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        powerPlatformLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        powerPlatformLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        powerPlatformLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        powerPlatformLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        powerPlatformLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        powerPlatformLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        powerPlatformLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        powerPlatformLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        powerPlatformLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        powerPlatformLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("PowerPlatform", powerPlatformLocators);
        
        Map<String, String> futureSkillsLocators = new HashMap<>();
        futureSkillsLocators.put("coursesShowmore", "//button[contains(text(),'Show more')]");
        futureSkillsLocators.put("coursesShowless", "//button[contains(text(),'Show less')]");
        futureSkillsLocators.put("courses", "//div[contains(@class,'container-fluid')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]//a");
       
        futureSkillsLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        futureSkillsLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        futureSkillsLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        futureSkillsLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        futureSkillsLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        futureSkillsLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        futureSkillsLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        futureSkillsLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        futureSkillsLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        futureSkillsLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        futureSkillsLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        futureSkillsLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        futureSkillsLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        futureSkillsLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        futureSkillsLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        futureSkillsLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        futureSkillsLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        futureSkillsLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        futureSkillsLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        futureSkillsLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("FutureSkills", futureSkillsLocators);
        
        Map<String, String> ibmLocators = new HashMap<>();
        ibmLocators.put("programs", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[3]/div/div[contains(@class,'LearningCatalogibm_cardRow')]//a");
       
        ibmLocators.put("programCardImage", ".//img[@alt='course-image']");
        ibmLocators.put("programCardIcon", ".//div[contains(@class,'FlatCourseCard_topRightSide')]//img[@alt='Course-Image']");
        ibmLocators.put("programCardLabel", ".//h3[contains(@class,'FlatCourseCard_courseType')]");
        ibmLocators.put("programCardName", ".//div[contains(@class,'FlatCourseCard_courseDescription')]/h2");
        ibmLocators.put("programCardLevel", ".//div[contains(@class,'FlatCourseCard_propertiesList')]/ul/li");
        ibmLocators.put("programCardPartner", ".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        ibmLocators.put("programCardEnrollStatus", ".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2[contains(text(),'Enrollment Status')]/following-sibling::p");
        ibmLocators.put("programCardEnrollIsClose", "");
        ibmLocators.put("programCardEnrollStartedStatus", "");
        ibmLocators.put("programCardPrice", ".//div[contains(@class,'FlatCourseCard_priceSection')]/h3[not(@span)]");

        
        ibmLocators.put("coursesShowmore", "//button[contains(text(),'Show more')]");
        ibmLocators.put("coursesShowless", "//button[contains(text(),'Show less')]");
        ibmLocators.put("courses", "//div[contains(@class,'container-fluid Courses_containerInner')]/div[5]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        ibmLocators.put("CourseCardImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        ibmLocators.put("CourseCardIcon", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::img");
        ibmLocators.put("CourseCardLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//following-sibling::p");
        ibmLocators.put("CourseCardName", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        ibmLocators.put("CourseCardLevel", ".//div[contains(@class,'RegularCourseCard_courseHeading')]/ul/li");
        ibmLocators.put("CourseCardPartner", ".//h6[contains(@class,'FlatCourseCard_companyTitle')]");
        ibmLocators.put("CourseCardEnrollStatus", ".//h6[contains(text(),'Enrollment Status')]/following-sibling::h4");
        ibmLocators.put("CourseCardPrice", ".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[not(contains(@class,'exclude'))]/following-sibling::p[not(@span)]");

        ibmLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        ibmLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        ibmLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        ibmLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        ibmLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        ibmLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        ibmLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        ibmLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        ibmLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        ibmLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");
        ibmLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        ibmLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 

        pageLocators.put("IBM", ibmLocators);
        
        Map<String, String> microsoftLocators = new HashMap<>();
        microsoftLocators.put("coursesShowmore", "//button[contains(text(),'Show more')]");
        microsoftLocators.put("coursesShowless", "//button[contains(text(),'Show less')]");
        microsoftLocators.put("courses", "//div[contains(@class,'container-fluid')]/div[2]//div[contains(@class,'LearningCatalog_cardRow')]//a");
        
        microsoftLocators.put( "cardLocator", "//div[contains(@class,'LearningCatalog_cardRow')]//div[contains(@class,'LearningCatalog_customCard')]");
      
        microsoftLocators.put("CourseCardPartner",".//div[contains(@class,'RegularCourseCard_courseCompany')]");
        microsoftLocators.put("CourseCardcardURL ",".//div[contains(@class,'RegularCourseCard_RegularcardLinks')]/a");
        microsoftLocators.put("CourseCardcardCourseLabel", ".//div[contains(@class,'RegularCourseCard_courseType')]//p[contains(text(),'Course')]");
        microsoftLocators.put("CourseCardcardHeading",".//div[contains(@class,'RegularCourseCard_courseHeading')]/p");
        microsoftLocators.put("CourseCardcardLevel1",".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul/li[1]");
        microsoftLocators.put("CourseCardcardLevel2",".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul/li[2]");
        microsoftLocators.put("CourseCardcardLevel3",".//div[contains(@class,'RegularCourseCard_courseHeading')]//ul/li[3]");
        microsoftLocators.put("CourseCardenrollPriceSection", ".//div[contains(@class,'RegularCourseCard_priceSection')]");
        microsoftLocators.put("CourseCardcardprice",".//div[contains(@class,'RegularCourseCard_priceRight')]/h2[contains(text(),'From')]/following-sibling::p");
        microsoftLocators.put("CourseCardEnrollIsClose", ".//*[contains(text(),'Coming soon')]"); //closed
        microsoftLocators.put("CourseCardEnrollStartedStatus", ".//*[contains(text(),'Course started on')]/following-sibling::p"); 
        microsoftLocators.put("CourseCardEnrollStatus = ",".//div[contains(@class,'RegularCourseCard_priceLeft')]/h2");
        
        microsoftLocators.put("CoursePageImage", ".//div[contains(@class,'RegularCourseCard_customCard')]/span//following-sibling::img");
        microsoftLocators.put("coursePageIcon", "//section[contains(@class,'CourseDescription_mainSection')]//img[@alt='course-icon']");
        microsoftLocators.put("coursePageLabel", "//section[contains(@class,'CourseDescription_mainSection')]//h4[contains(@class,'CourseDescription_courseLabel')]");
        microsoftLocators.put("coursePagePartner", "//section[contains(@class,'CourseDescription_mainSection')]/div/div[2]//img[@alt='org-logo']");
        microsoftLocators.put("coursePageName", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_courseText')]/h1");
        microsoftLocators.put("coursePageLevels", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]");
        microsoftLocators.put("coursePageLevel1", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_levelSection')]/h2");
        microsoftLocators.put("coursePageLevel1Value", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[1]//descendant::h2");
        microsoftLocators.put("coursePagePrice", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_durationAndPriceSection')]/div[2]//child::h2/following-sibling::P[not(@span)]");
        microsoftLocators.put("coursePageEnrollStatus", "//section[contains(@class,'CourseDescription_mainSection')]//div[contains(@class,'CourseDescription_buttonsContent')]//button[contains(text(),'Enroll Now')]/ancestor::a");

        pageLocators.put("Microsoft", microsoftLocators);
	}
	
	public static String getLocator(String page, String element)
	{
        return pageLocators.getOrDefault(page, new HashMap<>()).get(element);
    }
}
