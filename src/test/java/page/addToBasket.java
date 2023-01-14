package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addToBasket {

    private WebDriver driver;

    public addToBasket(WebDriver driver){
        this.driver =driver;
    }

    public void selectSizeAndQuantityAndAddToCart(String size, String quantity){
        WebElement sizeInput = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
        sizeInput.sendKeys(size);
        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
        quantityInput.click();
        quantityInput.sendKeys(Keys.CONTROL + "a");
        quantityInput.sendKeys(Keys.DELETE);
        quantityInput.sendKeys(quantity);
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCartButton.click();
    }


}
