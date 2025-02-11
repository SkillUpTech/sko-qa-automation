
package lamdaAutomation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;


public class DriverManager
{
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(String browserName, String env) throws MalformedURLException 
    {
        if (driverThreadLocal.get() == null)
        {
			
			/*
			 * ChromeOptions browserOptions = new ChromeOptions();
			 * browserOptions.setPlatformName("Windows 11");
			 * browserOptions.setBrowserVersion("131"); HashMap<String, Object> ltOptions =
			 * new HashMap<String, Object>(); ltOptions.put("username", "malinim282");
			 * ltOptions.put("accessKey",
			 * "ISoTYLKZYY4He5ymtDWmrSyPGmUWTGQzsXiWohl0KGtL63LPxc");
			 * ltOptions.put("resolution", "1366x768"); ltOptions.put("project",
			 * "Untitled"); ltOptions.put("w3c", true); ltOptions.put("plugin",
			 * "java-testNG"); ltOptions.put("video", true); ltOptions.put("console", true);
			 * ltOptions.put("seleniumLogs", true);
			 * browserOptions.setCapability("LT:Options", ltOptions);
			 * 
			 * String hubUrl =
			 * "https://malinim282:ISoTYLKZYY4He5ymtDWmrSyPGmUWTGQzsXiWohl0KGtL63LPxc@hub.lambdatest.com/wd/hub";
			 * RemoteWebDriver driver = new RemoteWebDriver(new URL(hubUrl),
			 * browserOptions); driver.get("https://qa-in.skillup.online/");
			 * System.out.println(driver.getTitle()); driverThreadLocal.set(driver);
			 */
			 
        	//Mac os safari browser
        	SafariOptions browserOptions = new SafariOptions();
        	browserOptions.setPlatformName("MacOS Sequoia");
        	browserOptions.setBrowserVersion("18");
        	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        	ltOptions.put("username", "malinim282");
        	ltOptions.put("accessKey", "ISoTYLKZYY4He5ymtDWmrSyPGmUWTGQzsXiWohl0KGtL63LPxc");
        	ltOptions.put("geoLocation", "IN");
        	ltOptions.put("video", true);
        	ltOptions.put("resolution", "1024x768");
        	ltOptions.put("build", "MacOSTesting");
        	ltOptions.put("project", "FooterSection");
        	ltOptions.put("selenium_version", "4.23.0");
        	ltOptions.put("w3c", true);
        	ltOptions.put("plugin", "java-testNG");
        	browserOptions.setCapability("LT:Options", ltOptions);
        	
        	String hubUrl =
      			  "https://malinim282:ISoTYLKZYY4He5ymtDWmrSyPGmUWTGQzsXiWohl0KGtL63LPxc@hub.lambdatest.com/wd/hub";
      			  RemoteWebDriver driver = new RemoteWebDriver(new URL(hubUrl),
      			  browserOptions); 
      			  driver.get("https://qa-in.skillup.online/");
      			  System.out.println(driver.getTitle());
      			  driverThreadLocal.set(driver);
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
