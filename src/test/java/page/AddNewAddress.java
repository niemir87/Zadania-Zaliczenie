package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewAddress {
    private WebDriver driver;

    public AddNewAddress (WebDriver driver){
        this.driver = driver;

    }
    public void AddNewAddressFillForm ( String alias, String address, String city, String zip, String country,String phone){
        WebElement aliasInput = driver.findElement(By.id("field-alias"));
        aliasInput.sendKeys(alias);
        WebElement addressInput = driver.findElement(By.id("field-address1"));
        addressInput.sendKeys(address);
        WebElement cityInput = driver.findElement(By.id("field-city"));
        cityInput.sendKeys(city);
        WebElement zipInput = driver.findElement(By.id("field-postcode"));
        zipInput.sendKeys(zip);
        WebElement countryInput = driver.findElement(By.id("field-id_country"));
        countryInput.sendKeys(country);
        WebElement phoneInput = driver.findElement(By.id("field-phone"));
        phoneInput.sendKeys(phone);
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        saveButton.click();

    }

}
