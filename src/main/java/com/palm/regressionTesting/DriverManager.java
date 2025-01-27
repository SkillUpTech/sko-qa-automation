package com.palm.regressionTesting;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.palm.utility.TestUtil;
public class DriverManager
{
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(String browserName) 
    {
        if (driverThreadLocal.get() == null)
        {
            WebDriver driver;
            if (browserName.equalsIgnoreCase("Chrome"))
            {
                System.setProperty("webdriver.chrome.driver", RegressionTesting.driverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-infobars");
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                options.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(options);
            }
            else if (browserName.equalsIgnoreCase("firefox"))
            {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hemamalini\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
            } 
            else
            {
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));

            driverThreadLocal.set(driver); // Assign the driver to the current thread
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() 
    {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null)
        {
            driver.quit();
            driverThreadLocal.remove(); // Remove driver from the current thread
        }
    }  
}
