package api.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllProductsTest extends BaseApiTest {

    @Test
    public void getAllProducts() {
        Response response = given()
                .when()
                .get("/productsList")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath js = new JsonPath(response.asString());

        Assert.assertEquals(js.getInt("responseCode"), 200);
        Assert.assertNotNull(js.getList("products"));
    }

}
