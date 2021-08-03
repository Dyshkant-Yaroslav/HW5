package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverSingletone {
    private static WebDriver webDriver;
    private static PropertiesReader propertiesReader = new PropertiesReader();

    public static void setProperties(){
        System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
    }

    public static WebDriver getDriver(){
        if (webDriver == null) {
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.get(propertiesReader.getURL());
        }
        return webDriver;
    }
    public static void closeDriver(){
        webDriver.close();
        webDriver = null;
    }

}
