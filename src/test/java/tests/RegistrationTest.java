package tests;

import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    @BeforeMethod
    public void setUp() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().clickRegisterForm();
    }
    @AfterMethod
    public static void tearDown() {
        app.getHomePageHelper().navigateToHomePage();
    }
    @Test
    public void positiveRegistrationTest(UserDTO userDTO) {
        app.getUserHelper().fillRegistrationForm(userDTO);
        app.getUserHelper().clickCheckbox();
        app.getUserHelper().clickSubmitRegisterBtn();
        app.getUserHelper().verifyRegistration(userDTO);
        app.getUserHelper().clickLogoutBtn();
    }
    @Test
    public void negativeRegistrationInvalidUsernameTest(UserDTO userDTO) {
        userDTO.setUsername("_username");
        app.getUserHelper().fillRegistrationForm(userDTO);
        app.getUserHelper().clickCheckbox();
        app.getUserHelper().clickSubmitRegisterBtn();
        app.getUserHelper().pause(2000);
        Assert.assertEquals(app.getUserHelper().getTextAlert(),
                "Invalid username, email or password");
    }
    @Test
    public void negativeRegistrationInvalidEmailTest(UserDTO userDTO) {
        userDTO.setEmail("invalid_email");
        app.getUserHelper().fillRegistrationForm(userDTO);
        app.getUserHelper().clickCheckbox();
        app.getUserHelper().clickSubmitRegisterBtn();
        app.getUserHelper().pause(2000);
        Assert.assertEquals(app.getUserHelper().getTextAlert(),
                "Invalid username, email or password");
    }
    @Test
    public void negativeRegistrationInvalidPassTest(UserDTO userDTO) {
        userDTO.setPassword("Qwa1!");
        app.getUserHelper().fillRegistrationForm(userDTO);
        app.getUserHelper().clickCheckbox();
        app.getUserHelper().clickSubmitRegisterBtn();
        app.getUserHelper().pause(2000);
        Assert.assertEquals(app.getUserHelper().getTextAlert(),
                "Invalid username, email or password");
    }
}

