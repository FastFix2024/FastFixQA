package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    boolean flag = false;
    @BeforeMethod
    public void setUp() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().clickOnLoginForm();
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
    @Test
    public void positiveLoginTest() {
        app.getUserHelper().fillLoginForm(user);
        String actualRes = app.getUserHelper().getLogoutBtnText();
        System.out.println(actualRes);
        Assert.assertEquals(actualRes, "Log Out");
        flag = true;
    }
    @Test
    public void negativeLoginWithoutEmail() {
        app.getUserHelper().fillPasswordOnLogin(user.getPassword());
        app.getUserHelper().clickSubmitLoginBtn();
        app.getUserHelper().pause(2000);
        Assert.assertEquals(app.getUserHelper().getTextAlert(),
                "Wrong email or password");
    }

    @Test
    public void negativeLoginWithoutPassword() {
        app.getUserHelper().fillEmailOnLogin(user.getEmail());
        app.getUserHelper().clickSubmitLoginBtn();
        app.getUserHelper().pause(2000);
        Assert.assertEquals(app.getUserHelper().getTextAlert(),
                "Wrong email or password");
    }
}
