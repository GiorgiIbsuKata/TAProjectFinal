package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.ProductsPage;
import ui.pages.ProductsDetailPage;

public class ProductsTest extends BaseUiTest {

    @Test
    public void verifyAllProductsAndProductDetailPage() {
        HomePage home = new HomePage(driver);
        ProductsPage products = new ProductsPage(driver);
        ProductsDetailPage detail = new ProductsDetailPage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible");

        home.clickProducts();
        Assert.assertTrue(products.isAllProductsPageVisible(), "ALL PRODUCTS page is not visible");

        Assert.assertTrue(products.isProductListVisible(), "Product list is not visible");

        products.clickFirstProductView();
        Assert.assertTrue(detail.areProductDetailsVisible(),
                "Product detail information is not fully visible");
    }
}
