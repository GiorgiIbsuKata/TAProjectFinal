package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllBrandsTest extends BaseApiTest {

    @Test(priority = 3, description = "API 3: GET all brands list")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that GET /brandsList returns 200 and contains a list of brands.")
    public void getAllBrands() {

        Response response = given()
                .when()
                .get("/brandsList")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath js = new JsonPath(response.asString());

        Assert.assertEquals(js.getInt("responseCode"), 200, "Response code should be 200");
        Assert.assertNotNull(js.getList("brands"), "Brands list should not be null");
    }
}
