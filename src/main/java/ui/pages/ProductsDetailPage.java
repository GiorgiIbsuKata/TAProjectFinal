package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsDetailPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By productName = By.xpath("//div[@class='product-information']/h2");
    private final By category = By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]");
    private final By price = By.xpath("//div[@class='product-information']//span/span");
    private final By availability = By.xpath("//b[text()='Availability:']");
    private final By condition = By.xpath("//b[text()='Condition:']");
    private final By brand = By.xpath("//b[text()='Brand:']");

    public ProductsDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Verify product detail page elements are visible")
    public boolean areProductDetailsVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(category));
        wait.until(ExpectedConditions.visibilityOfElementLocated(price));
        wait.until(ExpectedConditions.visibilityOfElementLocated(availability));
        wait.until(ExpectedConditions.visibilityOfElementLocated(condition));
        wait.until(ExpectedConditions.visibilityOfElementLocated(brand));
        return true;
    }

}
