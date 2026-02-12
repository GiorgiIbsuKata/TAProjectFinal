package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostSearchProductWithoutParamTest extends BaseApiTest {

    @Test(priority = 6, description = "API 6: POST to search product without parameter")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that POST /searchProduct without search_product parameter returns responseCode 400 and correct error message.")
    public void postSearchProductWithoutParameter() {

        Response response = given()
                .when()
                .post("/searchProduct")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = getJsonFromHtmlWrappedResponse(response);

        Assert.assertEquals(jsonPath.getInt("responseCode"), 400, "Response code should be 400");
        Assert.assertEquals(
                jsonPath.getString("message"),
                "Bad request, search_product parameter is missing in POST request.",
                "Error message mismatch"
        );
    }
}
