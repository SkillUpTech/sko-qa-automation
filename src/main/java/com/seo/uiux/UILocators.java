package com.seo.uiux;

import java.util.HashMap;
import java.util.Map;

public class UILocators 
{
	private static final Map<String, Map<String, String>> pageLocators = new HashMap<String, Map<String, String>>();
	
	static
	{
		Map<String, String> learnerDashboard_ProgramSection = new HashMap<>();
		learnerDashboard_ProgramSection.put("programCardList", "//div[@class='program-list']/div[@data-testid='ProgramCard']");
		learnerDashboard_ProgramSection.put("programCardImage", ".//img[@class='pgn__card-image-cap show']");
		learnerDashboard_ProgramSection.put("programIcon", ".//div[@class='program-icon']/img[@alt='icon']");
		learnerDashboard_ProgramSection.put("programNameLabel", ".//div[@class='program-icon']/p[contains(text(),'Program')]");
		learnerDashboard_ProgramSection.put("programTitle", ".//div[@class='program-title']//span[contains(@class,'program-card-title')]");
		learnerDashboard_ProgramSection.put("programPartner", ".//div[@class='course-content']//a");
		learnerDashboard_ProgramSection.put("programLevel", ".//div[@class='course-end-date']/div[@class='dataOthers'][1]/p");
		learnerDashboard_ProgramSection.put("programStartNowButton", ".//button[contains(@class,'program-start-button')]");
		learnerDashboard_ProgramSection.put("programShareIcon", ".//div[@class='share-program']/button");
		learnerDashboard_ProgramSection.put("programIncludeCourses", ".//div[@class='course-list-header']");
		learnerDashboard_ProgramSection.put("programLinkedCourses", ".//div[@class='course-list course-list-expanded']/div//p[@class='program-course-name']");
		learnerDashboard_ProgramSection.put("programGoToCourse", "//div[@class='course-list course-list-expanded']/div//a[@class='go-to-course-link sko-font']");
		pageLocators.put("leanerDashboard_Program", learnerDashboard_ProgramSection);
	}
	
	public static String getLocator(String page, String element)
	{
        return pageLocators.getOrDefault(page, new HashMap<>()).get(element);
    }
}
