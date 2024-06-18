package tests.api;

import dto.ErrorDTO;
import dto.UserDTOLombok;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
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
    @Test(description = "negative login test wrong email")
    public void negativeLoginTestWrongEmail() {
        UserDTOLombok userWrongEmail = UserDTOLombok.builder()
                .email("tt.test08@gmail.com")
                .password("Qwadr2024$")
                .build();
        given()
                .body(userWrongEmail)
                .when()
                .post(ENDPOINT_LOGIN)
                .then()
                .assertThat().statusCode(401);
    }
    @Test(description = "negative login test wrong password")
    public void negativeLoginTestWrongPassword() {
        UserDTOLombok userWrongPass = UserDTOLombok.builder()
                .email("tt.test0880@gmail.com")
                .password("Qwadr2024")
                .build();

        ErrorDTO errorDTO = given()
                .body(userWrongPass)
                .when()
                .post(ENDPOINT_LOGIN)
                .then()
                .assertThat().body("error",equalTo("Unauthorized"))
                .assertThat().body("message",equalTo("Login or Password incorrect"))
                .assertThat().body("status",equalTo(401))
                .extract().response().as(ErrorDTO.class);
    }
}
