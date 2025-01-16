package com.palm.regressionTesting;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LogoTextChecker 
{
	public static void main(String[] args) 
	{
        // Path to the image
		 System.setProperty("TESSDATA_PREFIX", "C:\\Users\\Hemamalini\\AppData\\Local\\Programs\\Tesseract-OCR"); 
		 System.setProperty("webdriver.chrome.driver", RegressionTesting.driverPath);
		 ChromeOptions options = new ChromeOptions();
         options.addArguments("--remote-allow-origins=*");
         options.addArguments("--disable-notifications");
         WebDriver driver = new ChromeDriver(options);
         try 
         {
        	 driver.get("https://qa-in.skillup.online/");

             // Locate the image logo
             WebElement logoImage = driver.findElement(By.cssSelector("img[src*='Skillup_logo']"));

             // Capture a screenshot of the logo image
             JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
             String base64Image = (String) jsExecutor.executeScript(
                 "var canvas = document.createElement('canvas');" +
                 "var ctx = canvas.getContext('2d');" +
                 "var img = arguments[0];" +
                 "canvas.width = img.naturalWidth;" +
                 "canvas.height = img.naturalHeight;" +
                 "ctx.drawImage(img, 0, 0, canvas.width, canvas.height);" +
                 "return canvas.toDataURL('image/png').substring(22);", logoImage);

             byte[] imageBytes = Base64.getDecoder().decode(base64Image);
             ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
             BufferedImage bufferedImage = ImageIO.read(inputStream);

             // Initialize Tesseract
             Tesseract tesseract = new Tesseract();
             tesseract.setDatapath("C:/Users/Hemamalini/AppData/Local/Programs/Tesseract-OCR/tessdata"); // Path to tessdata folder

             // Perform OCR on the BufferedImage
             String extractedText = tesseract.doOCR(bufferedImage);

             // Print the extracted text
             System.out.println("Extracted Text: " + extractedText);

             // Check if the word 'online' is present in the extracted text
             String keyword = "online";
             if (extractedText.toLowerCase().contains(keyword.toLowerCase())) {
                 System.out.println("The word '" + keyword + "' is present in the logo text.");
             } else {
                 System.out.println("The word '" + keyword + "' is NOT present in the logo text.");
             }
         } 
         catch (Exception e)
         {
             e.printStackTrace();
         } 
         finally
         {
             // Close the WebDriver
             driver.quit();
         }
    }
}
