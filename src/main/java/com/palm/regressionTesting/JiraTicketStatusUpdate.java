package com.palm.regressionTesting;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraTicketStatusUpdate 
{
	String ZEPHYR_API_URL = "";
	String ZEPHYR_API_TOKEN = "";
	String USERNAME = "";
	String EXECUTION_ID = "";  // Example execution ID
	String zephyrToken = System.getenv("ZEPHYR_API_TOKEN");
	public JiraTicketStatusUpdate()
	{
		this.ZEPHYR_API_URL = "https://prod-play.zephyr4jiracloud.com";
		this.ZEPHYR_API_TOKEN = zephyrToken;
		this.USERNAME = "Muruga";
		this.EXECUTION_ID = "SCRUM-E1";
	}
		//public static void main(String args[]) throws JSONException
		public String updateStatus(String status) throws JSONException
		{

			   System.out.println("Hello, Zephyr Integration!");
			   String token  = System.getenv("MY_AUTH_TOKEN");
		       RestAssured.baseURI = "https://prod-play.zephyr4jiracloud.com/connect/v2";

		       RequestSpecification request = RestAssured.given();

		       JSONObject requestParams = new JSONObject();
		       requestParams.put("statusName", status);
		       requestParams.put("actualEndDate", "2024-09-06T09:02:52Z");
		       requestParams.put("executionTime", 3000);
		       requestParams.put("comment", "Test Passed - Hemamalini");
		      
		       // Adding header
		       request.header("Content-Type", "application/json");
		       request.header("Authorization", "Bearer " + token);

		       // Adding body to the request
		       request.body(requestParams.toString());

		       // Making the PUT request to update the test execution
		       Response response = request.put("/testexecutions/SCRUM-E1");

		       // Printing response status and body
		       System.out.println(response.getStatusLine());   // Print HTTP status
		       System.out.println(response.getBody().asString()); // Print response body
			return response.getStatusLine();
		}
	
}
