package api.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostProductsListTest extends BaseApiTest {
    @Test(priority = 2, description = "API 4: PUT To All Brands List")
    public void putToAllBrandsList() {

        Response response = given()
                .when()
                .put("/brandsList")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String jsonOnly = response.asString()
                .replace("<html><body>", "")
                .replace("</body></html>", "")
                .trim();

        JsonPath jsonPath = new JsonPath(jsonOnly);

        Assert.assertEquals(jsonPath.getInt("responseCode"), 405);
        Assert.assertEquals(jsonPath.getString("message"), "This request method is not supported.");
    }


}
