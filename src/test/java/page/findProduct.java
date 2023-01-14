package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class findProduct {
    private WebDriver driver;

    public findProduct(WebDriver driver) {
        this.driver= driver;
    }

    public void findNewProduct(String productName) {
        WebElement searchOurCatalogInput = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"));
        searchOurCatalogInput.sendKeys(productName);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/button/i"));
        searchButton.click();
        WebElement imageOfProduct = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/img"));
        imageOfProduct.click();
    }
}
