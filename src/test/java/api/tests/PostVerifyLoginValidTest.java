package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostVerifyLoginValidTest extends BaseApiTest {

    @Test(priority = 7, description = "API 7: POST to verify login with valid details")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that POST /verifyLogin with valid email and password returns responseCode 200 and message 'User exists!'.")
    public void postVerifyLoginValid() {

        Response response = given()
                .formParam("email", "emailfortest@email.email")
                .formParam("password", "12345")
                .when()
                .post("/verifyLogin")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath js = new JsonPath(response.asString());

        Assert.assertEquals(js.getInt("responseCode"), 200, "Response code should be 200");
        Assert.assertEquals(js.getString("message"), "User exists!", "Message should confirm user exists");
    }
}
