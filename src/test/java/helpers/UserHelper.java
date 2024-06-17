package helpers;

import config.ApplicationManager;
import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    By btnLoginNB = By.xpath("//button[contains(@class,'css-1xrb8ai')and(text()='LOGIN')]");
    By btnRegisterForm = By.xpath("//button[contains(@class,'css-h94xtx')]");
    By btnLoginForm = By.xpath("//button[contains(@class,'css-117zi8f')]");
    By btnSubmitReg = By.xpath("//button[contains(@class,'css-dqj9az')and(text()='SUBMIT')]");
    By checkbox = By.xpath("//input[@id='agreement-id']");
    By btnSubmitLogin = By.xpath("//button[contains(@class,'css-1xrb8ai')and(text()='SUBMIT')]");
    By btnLogout = By.xpath("");
    By btnDeleteAccount = By.xpath("");
    By btnConfirmDeleteAccount = By.xpath("");
    By deleteSuccessMessage = By.xpath("");

    public void fillRegistrationForm(UserDTO userDTO) {
        fillUsernameToRegister(userDTO.getUsername());
        fillEmailToRegister(userDTO.getEmail());
        fillPasswordToRegister(userDTO.getPassword());
        confirmPasswordToRegister(userDTO.getConfirmPassword());
    }
    public void clickLoginOnNavBar() {
        clickBase(btnLoginNB);
    }
    public void clickRegisterForm() {
        clickBase(btnRegisterForm);
    }
    public void fillUsernameToRegister(String username) {
        typeText(username,By
                .xpath("//input[contains(@name,'username')]"));
    }
    public void fillEmailToRegister(String email) {
        typeText(email,By.xpath("//input[contains(@name,'email')]"));
    }
    public void fillPasswordToRegister(String password) {
        typeText(password,By.xpath("//input[@name='password']"));
    }
    public void confirmPasswordToRegister(String password) {
        typeText(password,By
                .xpath("//input[@name='passwordRetype']"));
    }
    public void clickCheckbox() {clickBase(checkbox);}
    public void clickSubmitRegisterBtn() {
        clickBase(btnSubmitReg);
    }
    public void verifyRegistration(UserDTO userDTO) {
        Assert.assertEquals(
                ApplicationManager.getDriver().findElement(
                                By.xpath(""))
                        .getText().trim(),
                userDTO.getEmail().trim());
    }
    public String getLogoutBtnText() {
        return getTextBaseByLocator(btnLogout);
    }
    public void fillLoginForm(UserDTO user) {
        fillEmailOnLogin(user.getEmail());
        fillPasswordOnLogin(user.getPassword());
    }
    public void clickOnLoginForm() {
        clickBase(btnLoginForm);
    }
    public void fillEmailOnLogin(String email) {
        typeText(email,By
                .xpath("//input[@name='email']"));
    }
    public void fillPasswordOnLogin(String password) {
        typeText(password,By
                .xpath("//input[@name='password']"));
    }
    public void clickSubmitLoginBtn() {
       clickBase(btnSubmitLogin);
    }
    public boolean isUserLoggedIn() {
        // Логика для проверки, залогинен ли пользователь
        try {
            return driver.findElement(btnLogout).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickLogoutBtn() {
        clickBase(btnLogout);
    }

    public void clickToConfirmDeleteAccountBtn() {
        clickBase(btnConfirmDeleteAccount);
    }

    public void clickDeleteAccountBtn(){
        clickBase(btnDeleteAccount);
    }

    public boolean isAccountDeleted() {
        String expectedMessage = "Account deleted successfully";
        String actualMessage = getDeleteSuccessMessage();
        return expectedMessage.equals(actualMessage);
    }
    public String getDeleteSuccessMessage() {
        return getTextBaseByLocator(deleteSuccessMessage);
    }
}
