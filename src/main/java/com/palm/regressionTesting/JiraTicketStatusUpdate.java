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
	public JiraTicketStatusUpdate()
	{
		this.ZEPHYR_API_URL = "https://prod-play.zephyr4jiracloud.com";
		//this.ZEPHYR_API_TOKEN = "ATATT3xFfGF07MyGom3BvuerhOtCWLcGF98i7QUHrKY5mQto7fpnTJIJBd7qjnKAw20GAlGq8XDq5T-9Tta0GjzNyRV2avXAda6WbKSZmN_3Rcmn8tvrWSX3xJ-QySK_LnCVpi6sC_9Lvh9A2SFc_RRNVZgAwkzHptveKx5Y8ZE3oj_dEnFfEDA=F1510C69";
		this.ZEPHYR_API_TOKEN = System.getenv("ZEPHYR_API_TOKEN");
		this.USERNAME = "Muruga";
		this.EXECUTION_ID = "SCRUM-E1";
	}
		//public static void main(String args[]) throws JSONException
		public String updateStatus(String status) throws JSONException
		{

			   System.out.println("Hello, Zephyr Integration!");
		       RestAssured.baseURI = "https://prod-play.zephyr4jiracloud.com/connect/v2";

		       RequestSpecification request = RestAssured.given();

		       JSONObject requestParams = new JSONObject();
		       requestParams.put("statusName", status);
		       requestParams.put("actualEndDate", "2024-09-06T09:02:52Z");
		       requestParams.put("executionTime", 3000);
		       requestParams.put("executedById", "712020:2d1fbaf0-5117-4050-b5aa-90164d728914");
		       requestParams.put("assignedToId", "712020:2d1fbaf0-5117-4050-b5aa-90164d728914");
		       requestParams.put("comment", "Test Passed - Hemamalini");

		       // Adding header
		       request.header("Content-Type", "application/json");
		       request.header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL20zNDIyMDA0Ny5hdGxhc3NpYW4ubmV0IiwidXNlciI6eyJhY2NvdW50SWQiOiI3MTIwMjA6MmQxZmJhZjAtNTExNy00MDUwLWI1YWEtOTAxNjRkNzI4OTE0In19LCJpc3MiOiJjb20udGhlZC56ZXBoeXIuamUiLCJzdWIiOiI4ZjFmNDVhMy00MTc5LTNlYzgtOWVlMi0zM2MxN2U5ZDZhZmIiLCJleHAiOjE3NTcwNjMxOTYsImlhdCI6MTcyNTUyNzE5Nn0.lku6htc7vYYSnWzrtMdGRaAqzL2d7hDhKVhsYEH_bQw"); // Use your Zephyr API token here

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
