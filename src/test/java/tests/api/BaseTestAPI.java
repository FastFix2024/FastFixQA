package tests.api;

import dto.UserDTOLombok;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class BaseTestAPI {
    public static final String ENDPOINT_LOGIN = "/user/login/usernamepassword";
    public static final String ENDPOINT_CONTACTS = "/contacts";

    UserDTOLombok userAPI = UserDTOLombok.builder()
            .username("tt.test0880@gmail.com")
            .password("Qwadr2024$")
            .build();
    public static final String TOKEN1 = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJrYXRla2F0ZSIsImV4cCI6MTcxODI3NTIyNiwicm9sZXMiOltdLCJuYW1lIjoia2F0ZWthdGUifQ.akIyWNAUCIMngl3yeRdJ3wNI7bpLCTwHFmRRuisKszo";
    public String token = "";
    public static final String AUTH = "Authorization";
    @BeforeSuite
    public void initAPI() {
        RestAssured.baseURI = "https://fastfix-app-jcage.ondigitalocean.app";
        RestAssured.basePath = "/v1";
        token = requestLoginApi(userAPI).then().extract().path("token");
    }
    public Response requestLoginApi(UserDTOLombok user) {
        return given()
                .body(userAPI)
                .when()
                .post(ENDPOINT_LOGIN);
    }
}
