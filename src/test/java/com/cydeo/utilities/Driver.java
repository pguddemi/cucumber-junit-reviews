package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove access to this object

    private Driver(){}

    /*
    We make the WebDriver private, because we want to close access from outside the class.
    We are making it static, because we will use it in a static method
     */

    private static WebDriver driver; //default value is null

        /*
        Create a re-usable utility method which will return the same driver instance once we call it.
        - If an instance doesn't exit, it will create first, and then it will always return same instance
         */

    public static WebDriver getDriver(){


        if(driver==null){

            /*
            We will read our browser type from Configuration.properties file
            This way, we can control which browser is opened from outside our code
             */
            String browserType = ConfigurationReader.getProperty("browser");
            browserType.trim().toLowerCase();

            /*
            Depending on the browserType returned from the configuration properties
            switch statement will determine the "case", and open the matching browser
             */

            switch (browserType){
                case "chrome":
                  //  WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                 //   WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }

        return driver;

    }

    public static void closeDriver(){
        if (driver != null) {
            /*
            this line will terminate the currently existing driver completely
            it will not exist going forward
             */
            driver.quit();
            /*
            we assign the value back to "null" so that my Singleton can create a newer one if needed
             */
            driver=null;
        }
    }
}
