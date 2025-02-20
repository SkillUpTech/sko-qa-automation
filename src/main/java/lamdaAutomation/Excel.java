package lamdaAutomation;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	public static void main(String[] args) throws InvalidFormatException, IOException 
	{
		System.out.println("Excel");
		
		File file = new File("C:\\Users\\malin\\Desktop\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFRow row; 
		XSSFCell cell;
		
	}
}
