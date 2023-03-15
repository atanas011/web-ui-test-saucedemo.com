package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class Home {

    private final WebDriver driver;

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCredentials(int userIndex) {
        driver.findElement(username).sendKeys(Utils.getUsername(userIndex));
        driver.findElement(password).sendKeys(Utils.getPassword(userIndex));
    }

    public Inventory clickLoginBtn() {
        driver.findElement(loginBtn).click();
        return new Inventory(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}