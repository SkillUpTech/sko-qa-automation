package lamdaAutomation;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Sample
{
    public static void main(String[] args) throws MalformedURLException
    {
    	ChromeOptions browserOptions = new ChromeOptions();
    	browserOptions.setPlatformName("Windows 11");
    	browserOptions.setBrowserVersion("131");
    	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    	ltOptions.put("username", "malinim282");
    	ltOptions.put("accessKey", "ISoTYLKZYY4He5ymtDWmrSyPGmUWTGQzsXiWohl0KGtL63LPxc");
    	ltOptions.put("resolution", "1366x768");
    	ltOptions.put("project", "Untitled");
    	ltOptions.put("w3c", true);
    	ltOptions.put("plugin", "java-testNG");
    	ltOptions.put("video", true);
    	ltOptions.put("console", true);
    	ltOptions.put("seleniumLogs", true);
    	browserOptions.setCapability("LT:Options", ltOptions);

        String hubUrl = "https://malinim282:ISoTYLKZYY4He5ymtDWmrSyPGmUWTGQzsXiWohl0KGtL63LPxc@hub.lambdatest.com/wd/hub";
        RemoteWebDriver driver = new RemoteWebDriver(new URL(hubUrl), browserOptions);
        driver.get("https://qa-in.skillup.online/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}

