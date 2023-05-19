package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.util.encoders.Hex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class T07_Yousef_Color {
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
        driver.navigate().to("https://the-internet.herokuapp.com/login");

    }

    @Test
    public void testCase (){

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("i[class=\"fa fa-2x fa-sign-in\"]")).click();

        WebElement successMessage = driver.findElement(By.id("flash"));
        driver.findElement(By.id("flash")).getCssValue("background-color");

        System.out.println(successMessage.getCssValue("background-color"));

        String colorRGB =  driver.findElement(By.id("flash")).getCssValue("background-color");

        String colorHex = Color.fromString(colorRGB).asHex();

        System.out.println(colorHex);
    }
    @AfterMethod
    public void tearDown () throws Exception{
        Thread.sleep(5000);
        driver.quit();
    }
}
