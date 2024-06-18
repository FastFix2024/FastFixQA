package tests.api;

import dto.UserDTOLombok;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class BaseTestAPI {
    public static final String ENDPOINT_LOGIN = "/auth/login";
    public static final String ENDPOINT_LOGOUT = "/auth/logout";
    public static final String ENDPOINT_DELETE = "/users/my/profile";


    UserDTOLombok userAPI = UserDTOLombok.builder()
            .email("tt.test0880@gmail.com")
            .password("Qwadr2024$")
            .build();
    public static final String TOKEN1 = "";
    public String token = "";
    public static final String AUTH = "Authorization";
    @BeforeSuite
    public void initAPI() {
        RestAssured.baseURI = "https://fastfix-app-jcage.ondigitalocean.app";
        token = requestLoginApi(userAPI).then().extract().path("token");
    }
    public Response requestLoginApi(UserDTOLombok user) {
        return given()
                .body(userAPI)
                .when()
                .post(ENDPOINT_LOGIN);
    }
}
