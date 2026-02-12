package api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutBrandsListTest extends BaseApiTest {

    @Test(priority = 4, description = "API 4: PUT to all brands list")
    @Severity(SeverityLevel.NORMAL)
    @Description("PUT to /brandsList is not supported. Verify JSON body contains responseCode 405 and correct message.")
    public void putToAllBrandsList() {

        Response response = given()
                .when()
                .put("/brandsList")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = getJsonFromHtmlWrappedResponse(response);

        Assert.assertEquals(jsonPath.getInt("responseCode"), 405);
        Assert.assertEquals(jsonPath.getString("message"), "This request method is not supported.");
    }
}
