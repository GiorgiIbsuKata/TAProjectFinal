package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostSearchProductTest extends BaseApiTest {

    @Test(priority = 5, description = "API 5: POST to search product")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that POST /searchProduct returns 200 and returns a list of products matching the search query.")
    public void postSearchProduct() {

        Response response = given()
                .formParam("search_product", "top")
                .when()
                .post("/searchProduct")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath js = new JsonPath(response.asString());

        Assert.assertEquals(js.getInt("responseCode"), 200, "Response code should be 200");
        Assert.assertNotNull(js.getList("products"), "Products list should not be null");
        Assert.assertTrue(js.getList("products").size() > 0, "Search should return at least one product");
    }
}
