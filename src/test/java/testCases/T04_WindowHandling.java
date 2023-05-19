package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class T04_WindowHandling {

//    Don't apply Thread.sleep -> it is for you to see the execution ; remove it once you learn the script's purpose
//    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//    driver.switchTo().window(tabs.get(1));

    public WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        //1- Define Bridge
        WebDriverManager.chromedriver().setup();

        // 2- Create new object from chromedriver
        driver = new ChromeDriver();

        // 3- Configuration
        //3.1- Maximize browser
        driver.manage().window().maximize();

        //3.2 - Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 4- Navigate to website
        driver.navigate().to("https://demo.nopcommerce.com/");

    }


    @Test()
    public void HandlingTwoTabs() throws InterruptedException {



    }




    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
