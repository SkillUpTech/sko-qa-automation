package com.palm.regressionTesting;

public class WorkoutCode
{
	public static void main(String args[])
	{
		 String zephyrToken = System.getenv("ZEPHYR_API_TOKEN");
	     String authToken = System.getenv("MY_AUTH_TOKEN");

        System.out.println("ZEPHYR_API_TOKEN: " + zephyrToken);
        System.out.println("MY_AUTH_TOKEN: " + authToken); 
	}
}
