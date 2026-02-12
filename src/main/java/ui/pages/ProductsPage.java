package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By allProductsHeader = By.xpath("//h2[contains(normalize-space(),'All Products')]");
    private final By productList = By.cssSelector(".features_items .product-image-wrapper");
    private final By firstProductViewButton = By.xpath("(//a[contains(text(),'View Product')])[1]");

    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By searchedProductsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    private final By searchedProductList = By.cssSelector(".features_items .product-image-wrapper");


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Verify ALL PRODUCTS page is visible")
    public boolean isAllProductsPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsHeader)).isDisplayed();
    }

    @Step("Verify product list is visible")
    public boolean isProductListVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productList)).isDisplayed();
    }

    @Step("Click 'View Product' on the first product")
    public void clickFirstProductView() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstProductViewButton)
        );

        scrollToElement(element);

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    @Step("Scroll to element")
    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element
        );
    }

    @Step("Search for product: {productName}")
    public void searchForProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    @Step("Verify 'SEARCHED PRODUCTS' header is visible")
    public boolean isSearchedProductsHeaderVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsHeader)).isDisplayed();
    }

    @Step("Verify all searched products are visible")
    public boolean areSearchedProductsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductList)).isDisplayed();
    }



}
