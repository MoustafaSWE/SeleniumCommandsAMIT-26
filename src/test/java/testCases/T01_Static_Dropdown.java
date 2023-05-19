package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T01_Static_Dropdown {

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

        // 3- Configuration
        //3.1- Maximize browser
        driver.manage().window().maximize();

        //3.2- Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 4- Navigate to website
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }


    @Test
    public void StaticDropdown() throws InterruptedException {

        // 1- Define webEelement for the list


        // 2- Create new object from Select class in selenium
        //you should make sure about this >> import org.openqa.selenium.support.ui.Select;


        //3- Select options using 3 methods
        //3.1- SelectByIndex


        //3.2- SelectByValue
        //Note SelectByValue input value is String but SelectByIndex is Integer


        //3.3- SelectByVisibleText


    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}