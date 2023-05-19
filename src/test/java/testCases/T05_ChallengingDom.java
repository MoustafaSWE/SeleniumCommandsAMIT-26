package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class T05_ChallengingDom {

//  We need to build our Logic by using For loop and If condition

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

        //3.2 - Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 4- Navigate to website
        driver.navigate().to("https://the-internet.herokuapp.com/challenging_dom");

    }


    @Test()
    public void selectElementFromDOM() throws InterruptedException {

        List<WebElement> namesOfTable = driver.findElements(By.cssSelector("tbody tr"));

        for (int i=1; i < namesOfTable.size() ;i++){


            System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[1]")).getText());
            if ( namesOfTable.get(i).getText().contains("Iuvaret7")){

                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr["+i+"]/td[7]/a[1]")).click();
                break;


            }

        }

        Assert.assertTrue(driver.getCurrentUrl().contains("edit"));

    }




    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
