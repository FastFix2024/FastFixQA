package tests;

import dto.UserDTO;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{
    @Test
    public void positiveSignUpTest(UserDTO userDTO) {
        app.getUserHelper().signUp(userDTO);
        app.getUserHelper().checkIfNewUserWasRegistered(userDTO);
        app.getUserHelper().clickLogoutBtn();
    }
}
