package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import page.findProduct;
import page.addToBasket;
import java.io.File;

import java.io.IOException;
import java.time.Duration;


public class BayingSweaterSteps {

    WebDriver driver;

    @Given("User is on the home page and clicks sign in")
    public void userIsOnMainSiteAndSignIn() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/");
        WebElement sigInButton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[1]"));
        sigInButton.click();
    }

    @And("User logs in with email {string} and password {string}")
    public void userLogsInWithEmailAndPassword(String email, String password) {
        WebElement emailAddressInput = driver.findElement(By.id("field-email"));
        emailAddressInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.id("field-password"));
        passwordInput.sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }

    @When("User searches for a product {string}")
    public void userSearchesForAProduct(String productName) {
        findProduct findProduct = new findProduct(driver);
        findProduct.findNewProduct(productName);
        String discountText = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li")).getText();
        Assertions.assertTrue(discountText.contains("-20%"));


    }


    @And("User selects the size {string}, quantity {string} of first product and adds it to the basket")
    public void userSelectsTheSizeQuantityOfFirstProductAndAddsItToTheBasket(String size, String quantity1) {
        addToBasket addToBasket = new addToBasket(driver);
        addToBasket.selectSizeAndQuantityAndAddToCart(size,quantity1);


//        @And("User selects the size {string}, quantity of first product and adds it to the basket")
//        public void userSelectsTheSizeQuantityOfFirstProductAndAddsItToTheBasket(String size) {
//            WebElement sizeInput = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
//            sizeInput.sendKeys(size);
//
////        WebElement spinUpButton  = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i"));
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
////        spinUpButton.click();
////        spinUpButton.click();
////        spinUpButton.click();
////        spinUpButton.click();
//
//            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
//            addToCartButton.click();


        }

    @And("User accepts proceed to checkout")
    public void userAcceptsProceedToCheckout() {
        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        proceedToCheckoutButton.click();
        WebElement proceedToCheckOutAgainButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        proceedToCheckOutAgainButton.click();
    }

    @Then("User accepts the address and selects the method of delivery, payment")
    public void userAcceptsTheAddressAndSelectsTheMethodOfDeliveryPayment()  {
        WebElement myAddressContinueButton = driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        myAddressContinueButton.click();
        WebElement prestaShopCheckBox = driver.findElement(By.id("delivery_option_1"));
        prestaShopCheckBox.submit();
        WebElement acceptPaymentButton = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
        acceptPaymentButton.click();
        WebElement payByCheckCheckBox = driver.findElement(By.xpath("//*[@id=\"payment-option-1\"]"));
        payByCheckCheckBox.click();



    }

    @And("User places an order")
    public void userPlacesAnOrder()  {
        WebElement agreeToTheTermsCheckBox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        agreeToTheTermsCheckBox.click();
        WebElement placeOrderButton = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        placeOrderButton.click();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("c:\\prtscr\\screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}


