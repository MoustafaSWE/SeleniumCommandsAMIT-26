package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T02_Dynamic_Dropdown {

//    Static dropdown list:	dropdowns having tagName "Select"
//    Dynamic dropdown list:	dropdowns having different tagName other than "Select"
//    Don't apply Thread.sleep -> it is for you to see the execution ; remove it once you learn the script's purpose


    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        //1- Define Bridge
        WebDriverManager.chromedriver().setup();

        // 2- Create new object from chromedriver

        driver = new ChromeDriver();

        // config
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        // 3- Configuration
        //3.1- Maximize browser
        driver.manage().window().maximize();

        //3.2- Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 4- Navigate to website
        driver.get("https://www.google.com/");


    }


    @Test
    public void dynamicDropdown() throws InterruptedException {

        //1- search on "selenium"
        driver.findElement(By.name("q")).sendKeys("selenium");

        // 2- dynamic dropdown list
        // We couldn't use Select class with dynamic lists, instead we could handle it with findElements() method
        driver.findElements(By.cssSelector("ul[jsname=\"bw4e9b\"] li")).get(2).click();

    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
