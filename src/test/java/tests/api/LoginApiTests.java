package tests.api;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginApiTests extends BaseTestAPI{
    @Test(description = "assert status code 200 for positive login")
    public void positiveLoginTestStatusCode() {
        requestLoginApi(userAPI)
                .then()
                .assertThat().statusCode(200);
    }

    @Test(description = "assert we get token for positive login")
    public void positiveLoginTestToken() {
        String pathToken = given()
                .body(userAPI)
                .when()
                .post(ENDPOINT_LOGIN)
                .then()
                .body(Matchers.containsString("token"))
                .extract().path("token");
        System.out.println(pathToken);
    }
}
