package tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAccountTests extends BaseTest {
    @BeforeMethod
    public void setUp() {
        if (!app.getUserHelper().isUserLoggedIn()) {
            app.getUserHelper().clickLoginOnNavBar();
            app.getUserHelper().clickOnLoginForm();
            app.getUserHelper().fillLoginForm(user);
            app.getUserHelper().clickSubmitLoginBtn();
        }
    }
    @AfterMethod
    public static void tearDown() {
        app.getHomePageHelper().navigateToHomePage();
    }
    @Test
    public void positiveAccountDeletionTest() {
        app.getUserHelper().clickDeleteAccountBtn();
        app.getUserHelper().clickToConfirmDeleteAccountBtn();

        Assert.assertTrue(app.getUserHelper().isAccountDeleted(), "Account was not deleted successfully");
    }
    @Test
    public void negativeAccountDeletionTest() {
        app.getUserHelper().clickDeleteAccountBtn();
        app.getUserHelper().clickToConfirmDeleteAccountBtn();

        String alertText = app.getUserHelper().getTextAlert();
        Assert.assertEquals(alertText,  "Unexpected alert text");
    }
}
