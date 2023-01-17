package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.addNewAddress;

import java.time.Duration;

public class AddAddressSteps {
    WebDriver driver;
    @Given("User is on main site and clicks in sign in")
    public void userIsOnMainSiteAndClicksInSignIn() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/");
        WebElement sigInButton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]"));
        sigInButton.click();
    }

    @And("User is logged in with email {string} and password {string}")
    public void userIsLoggedInWithEmailAndPassword(String email, String password) {
        WebElement emailAddressInput = driver.findElement(By.id("field-email"));
        emailAddressInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.sendKeys(password);
        driver.findElement(By.id("submit-login")).click();

    }

    @When("User clicks Addresses")
    public void userClicksAddresses() {
        WebElement addressButton = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span"));
        addressButton.click();
    }

    @When("User clicks Create new address")
    public void userClicksCreateNewAddress() {
        WebElement createNewAddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span"));
        createNewAddress.click();
    }

    @Then("User fills New address form with {string},{string},{string},{string},{string},{string}")
    public void userFillsNewAddressFormWith(String alias, String address, String city, String zip, String country, String phone)
    {
        addNewAddress addNewAddress = new addNewAddress(driver);
        addNewAddress.addNewAddressFillForm(alias,address,city,zip,country,phone);
    }


    @And("Check if form contains proper details {string},{string},{string},{string},{string},{string}")
    public void checkIfFormContainsProperDetails(String alias, String address, String city, String zip, String country, String phone)
    {
        String aliasText = driver.findElement(By.xpath("//section/div[2]/article/div[1]/h4")).getText();
        Assertions.assertEquals(alias,aliasText);
        String fullAddressText = driver.findElement(By.xpath("//section/div[2]/article/div[1]/address")).getText();
        Assertions.assertTrue(fullAddressText.contains(address)&& fullAddressText.contains(city)&&fullAddressText.contains(zip)
      && fullAddressText.contains(country)&& fullAddressText.contains(phone));

    }

    @And("User deletes added address")
    public void userDeletesAddedAddress() {
        WebElement deleteAddressButton = driver.findElement(By.xpath("//section/div[2]/article/div[2]/a[2]/span"));
        deleteAddressButton.click();
        String addressDeletedText = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li")).getText();
        Assertions.assertTrue(addressDeletedText.contains("Address successfully deleted!"));
    }
}
