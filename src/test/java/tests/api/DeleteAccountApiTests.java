package tests.api;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAccountApiTests extends BaseTestAPI{

    @BeforeMethod
    public void precondition() {
        if (token.isEmpty()) {
            token = requestLoginApi(userAPI).then().extract().path("token");
        }
    }
    @Test(description = "assert status code 200 for positive delete account")
    public void positiveDeleteAccountTestStatusCode() {
        given()
                .header(AUTH, token)
                .when()
                .delete(ENDPOINT_DELETE)
                .then()
                .assertThat().statusCode(200);
    }

    @Test(description = "assert we get a success message for positive delete account")
    public void positiveDeleteAccountTestMessage() {
        given()
                .header(AUTH, token)
                .when()
                .delete(ENDPOINT_DELETE)
                .then()
                .body("message", equalTo("Account successfully deleted"));
    }
}
