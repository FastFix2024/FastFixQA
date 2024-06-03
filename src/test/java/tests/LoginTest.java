package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    boolean flag = false;
    @Test
    public void positiveLoginTest() {

    }
    @AfterMethod
    public void methodPostCondition() {
        if(flag) {
            app.getUserHelper().clickLogoutBtn();
            flag = false;
        } else {
            app.getUserHelper().clickOkAlert();
        }
        app.getHomePageHelper().navigateToHomePage();
    }
}
