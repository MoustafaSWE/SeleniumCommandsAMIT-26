package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_LoginPage {
    private WebDriver driver;

    // Constructor
    public P01_LoginPage (WebDriver driver){
        this.driver = driver;
    }

    // Elements
    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    // action
    public void enterUserName1 (String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }

    public WebElement userName () {
        return driver.findElement(userNameField);
    }

    public void enterPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnLoginButton (){
        driver.findElement(loginButton).click();
    }
}
