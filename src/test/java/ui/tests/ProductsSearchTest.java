package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.ProductsPage;

public class ProductsSearchTest extends BaseUiTest {

    @Test
    public void searchProductTest() {
        HomePage home = new HomePage(driver);
        ProductsPage products = new ProductsPage(driver);

        home.open();
        Assert.assertTrue(home.isHomePageVisible(), "Home page is not visible");

        home.clickProducts();
        Assert.assertTrue(products.isAllProductsPageVisible(), "ALL PRODUCTS page is not visible");

        products.searchForProduct("dress");

        Assert.assertTrue(products.isSearchedProductsHeaderVisible(),
                "'SEARCHED PRODUCTS' header is not visible");

        Assert.assertTrue(products.areSearchedProductsVisible(),
                "Searched products are not visible");
    }
}
