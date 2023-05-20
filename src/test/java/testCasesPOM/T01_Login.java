package testCasesPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_LoginPage;

import java.time.Duration;

public class T01_Login {
    WebDriver driver;
    P01_LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        loginPage = new P01_LoginPage(driver);
    }

    @Test
    public void userLoginWithValidData () throws Exception{

        loginPage.enterUserName1("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
    }

    @Test (dependsOnMethods = "userLoginWithValidData")
    public void userLoginWithInvalidData (){
        loginPage.enterUserName1("standard_user");
        loginPage.enterPassword("ssss");
        loginPage.clickOnLoginButton();


        Assert.assertFalse(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
    }

    @AfterMethod
    public void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
