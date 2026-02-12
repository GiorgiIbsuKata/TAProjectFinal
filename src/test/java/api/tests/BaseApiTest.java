package api.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://automationexercise.com/api";
    }

    protected JsonPath getJsonFromHtmlWrappedResponse(Response response) {
        String cleaned = response.asString()
                .replace("<html><body>", "")
                .replace("</body></html>", "")
                .trim();

        return new JsonPath(cleaned);
    }
}
