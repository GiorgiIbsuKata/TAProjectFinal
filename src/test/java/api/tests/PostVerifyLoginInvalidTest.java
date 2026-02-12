package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostVerifyLoginInvalidTest extends BaseApiTest {

    @Test(priority = 10, description = "API 10: POST to verify login with invalid details")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that POST /verifyLogin with invalid email and password returns responseCode 404 and message 'User not found!'.")
    public void postVerifyLoginInvalid() {

        Response response = given()
                .formParam("email", "sdasdas@dsasda.sads")
                .formParam("password", "dsfgdfsdffdsd")
                .when()
                .post("/verifyLogin")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath js = new JsonPath(response.asString());

        Assert.assertEquals(js.getInt("responseCode"), 404, "Response code should be 404");
        Assert.assertEquals(js.getString("message"), "User not found!", "Message should indicate user not found");
    }
}
