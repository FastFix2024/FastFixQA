package tests;

import dto.UserDTO;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{
    @Test
    public void positiveRegistrationTest(UserDTO userDTO) {
        app.getUserHelper().register(userDTO);
        app.getUserHelper().verifyRegistration(userDTO);
        app.getUserHelper().clickLogoutBtn();
    }
}

