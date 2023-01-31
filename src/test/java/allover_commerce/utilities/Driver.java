package allover_commerce.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //  Driver.getDriver(); -> driver
    private static WebDriver driver;
    //  getDriver() is used to instantiate the driver object
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
            }


            // driver = WebDriverManager.chromedriver().create(); // NOTE===>>>new method after Selenium 4.5.

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));    // Whenever we call the driver it is going to be triggered
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));   // coming from Selenium;
        driver.manage().window().maximize();
        return driver;
    }
    //  closeDriver() is used to close the driver
    public static void closeDriver(){

//      if driver is already being used(pointing an object)
//      then quit the driver
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
