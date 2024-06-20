package tests.api;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LogoutApiTests extends BaseTestAPI{

    @Test(description = "assert status code 200 for positive logout")
    public void positiveLogoutTestStatusCode() {
        given()
                .header(AUTH, token)
                .when()
                .post(ENDPOINT_LOGOUT)
                .then()
                .assertThat().statusCode(200);
    }
}
