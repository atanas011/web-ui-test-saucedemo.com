package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Inventory {

    private final WebDriver driver;

    private final By sortClass = By.className("product_sort_container");
    private final By itemPrice = By.className("inventory_item_price");

    public Inventory(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void sortByPrice(String txt) {
        driver.findElement(sortClass).click();
        new Select(driver.findElement(sortClass))
                .selectByVisibleText(txt);
    }

    public boolean verifySortAsc() {
        var prices = driver.findElements(itemPrice);
        List<Double> values = new ArrayList<>();
        for (WebElement price : prices) {
            values.add(Double.parseDouble(price.getText().substring(1)));
        }

        var tmp = new ArrayList<>(values);
        Collections.sort(tmp);

        return tmp.equals(values);
    }
}