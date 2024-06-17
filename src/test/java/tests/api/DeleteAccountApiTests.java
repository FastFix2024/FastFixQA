package tests.api;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAccountApiTests extends BaseTestAPI{
    @Test(description = "assert status code 200 for positive delete account")
    public void positiveDeleteAccountTestStatusCode() {
        given()
                .header(AUTH, "Bearer " + token)
                .when()
                .delete(ENDPOINT_DELETE)
                .then()
                .assertThat().statusCode(200);
    }

    @Test(description = "assert we get a success message for positive delete account")
    public void positiveDeleteAccountTestMessage() {
        given()
                .header(AUTH, "Bearer " + token)
                .when()
                .delete(ENDPOINT_DELETE)
                .then()
                .body("message", equalTo("Account successfully deleted"));
    }
}
