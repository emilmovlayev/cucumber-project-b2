package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    /*
        Creating the private constructor so this class object is not reachable from outside
     */

    private Driver(){

    }
      /*
        making driver instance private
        static - run before everything else and also in static method
         */
    private static WebDriver driver;


    /**
     * singleton pattern
     * @return driver
     * @author Emil
     */
    public static WebDriver getdriver(){
        if (driver==null) {
            String browserType = ConfigurationReader.getproperty("browser");
            switch (browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
    /**
     * closing driver
     * @author Emil
     */
    public static void closedriver(){
        if (driver!=null) {
            driver.quit();
            driver = null;
        }
    }

}
