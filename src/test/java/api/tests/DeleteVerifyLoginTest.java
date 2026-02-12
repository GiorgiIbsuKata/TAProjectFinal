package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteVerifyLoginTest extends BaseApiTest {

    @Test(priority = 9, description = "API 9: DELETE to verify login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that DELETE /verifyLogin is not supported and returns responseCode 405 with correct error message.")
    public void deleteVerifyLogin() {

        Response response = given()
                .when()
                .delete("/verifyLogin")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = getJsonFromHtmlWrappedResponse(response);

        Assert.assertEquals(jsonPath.getInt("responseCode"), 405, "Response code should be 405");
        Assert.assertEquals(
                jsonPath.getString("message"),
                "This request method is not supported.",
                "Error message mismatch"
        );
    }
}
