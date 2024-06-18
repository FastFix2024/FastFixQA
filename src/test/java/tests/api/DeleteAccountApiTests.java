package tests.api;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAccountApiTests extends BaseTestAPI{
    private String id = "";
    @BeforeMethod
    public void precondition() {
        if (token.isEmpty()) {
            token = requestLoginApi(userAPI).then().extract().path("token");
        }
    }
    @Test
    public void deleteAccountPositiveTest() {
        String message = given()
                .header(AUTH, token)
                .delete(ENDPOINT_DELETE + "/" + id)
                .then()
                .assertThat().statusCode(200)
                .extract().path("message");
    }
    @Test(description = "negative delete account with non existed ID")
    public void deleteAccountNegativeTest() {
        String nonExistedId = "76";
        String errorMessage = given()
                .header(AUTH, token)
                .delete(ENDPOINT_DELETE + "/" + nonExistedId)
                .then()
                .assertThat().statusCode(400)
                .extract().path("message");
    }
}
