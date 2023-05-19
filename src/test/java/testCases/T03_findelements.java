package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T03_findelements {

//    Don't apply Thread.sleep -> it is for you to see the execution ; remove it once you learn the script's purpose


    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        //1 - Define Bridge
        WebDriverManager.chromedriver().setup();

        // 2 - Create new object from chromedriver
        driver = new ChromeDriver();

        // 3 - Configuration
        //3.1 - Maximize browser
        driver.manage().window().maximize();

        //3.2 - Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 4- Navigate to website   url should be english  >> ?hl=en
        driver.get("https://www.google.com/?hl=en");

    }


    @Test
    public void findelements() throws InterruptedException {

        //1- search on "selenium"


        //2- loop on all results and make sure that they are all contains the word "selenium"




    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
