package com.palm.regressionTesting;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkoutCode
{
	public static void main(String args[])
	{
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2,  "two");
		
		for(Map.Entry<Integer, String> entry : map.entrySet())
		{
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : "+ value);
		}
	}
}
