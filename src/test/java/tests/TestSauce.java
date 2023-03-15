package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home;
import pages.Inventory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestSauce {

    private WebDriver driver;
    private Home home;
    private Inventory inventory;

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        home = new Home(driver);
    }

    @Test
    public void gotoPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void invalidLogin() {
        int invalidUserIndex = 0;
        home.enterCredentials(invalidUserIndex);
        home.clickLoginBtn();
        assertEquals(driver.getCurrentUrl(), home.getUrl());
        driver.navigate().refresh();
    }

    @Test
    public void validLogin() {
        int validUserIndex = 1;
        home.enterCredentials(validUserIndex);
        inventory = home.clickLoginBtn();
        assertEquals(driver.getCurrentUrl(), inventory.getUrl());
    }

    @Test(priority = 1)
    public void sortByPriceAsc() {
        inventory.sortByPrice("Price (low to high)");
    }

    @Test(dependsOnMethods = "sortByPriceAsc")
    public void verifySortAsc() {
        assertTrue(inventory.verifySortAsc());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}