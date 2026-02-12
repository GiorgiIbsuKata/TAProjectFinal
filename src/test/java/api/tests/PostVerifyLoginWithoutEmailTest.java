package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostVerifyLoginWithoutEmailTest extends BaseApiTest {

    @Test(priority = 8, description = "API 8: POST to verify login without email parameter")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that POST /verifyLogin without email parameter returns responseCode 400 and correct error message.")
    public void postVerifyLoginWithoutEmail() {

        Response response = given()
                .formParam("password", "12345")
                .when()
                .post("/verifyLogin")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = getJsonFromHtmlWrappedResponse(response);

        Assert.assertEquals(jsonPath.getInt("responseCode"), 400, "Response code should be 400");
        Assert.assertEquals(
                jsonPath.getString("message"),
                "Bad request, email or password parameter is missing in POST request.",
                "Error message mismatch"
        );
    }
}
