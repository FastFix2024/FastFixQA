package helpers;

import config.ApplicationManager;
import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }
    By btnLoginNB = By.xpath("");
    By btnSignUpForm = By.xpath("");
    By btnSignUp = By.xpath("");
    By btnLogin = By.xpath("");
    By btnLogout = By.xpath("//div[contains(@class,'navbar-logged')]//button");

    public void signUp(UserDTO userDTO) {
        clickLoginOnNavBar();
        pause(5000);
        clickSignUp();
        fillUsernameToSignUp(userDTO.getUsername());
        fillEmailToSignup(userDTO.getEmail());
        fillPasswordToSignUp(userDTO.getPassword());
        confirmPasswordToSignUp(userDTO.getPassword());
        clickOnSignUpBtn();
    }
    public void clickLoginOnNavBar() {
        clickBase(btnLoginNB);
    }
    public void clickSignUp() {
        clickBase(btnSignUpForm);
    }
    public void fillUsernameToSignUp(String username) {
        WebElement fillUsername = driver.findElement(By
                .xpath(""));
        fillUsername.click();
        fillUsername.clear();
    }
    public void fillEmailToSignup(String email) {
        WebElement fillEmail = driver.findElement(By
                .xpath(""));
        fillEmail.click();
        fillEmail.clear();
    }
    public void fillPasswordToSignUp(String password) {
        WebElement fillPassword = driver.findElement(By
                .xpath(""));
        fillPassword.click();
        fillPassword.clear();
    }
    public void confirmPasswordToSignUp(String password) {
        WebElement confirmPassword = driver.findElement(By
                .xpath(""));
        confirmPassword.click();
        confirmPassword.clear();
    }
    public void clickOnSignUpBtn() {
        clickBase(btnSignUp);
    }
    public void login(UserDTO user) {
        fillEmailOnLogin(user.getEmail());
        fillPasswordOnLogin(user.getPassword());
        clickLoginBtn();
    }
    public void fillEmailOnLogin(String email) {
        WebElement inputEmail = driver.findElement(By
                .xpath("//input[@name='email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }
    public void fillPasswordOnLogin(String password) {
        WebElement inputPassword = driver.findElement(By
                .xpath("//input[@name='password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }
    public void clickLoginBtn() {
       clickBase(btnLogin);
    }
    public void checkIfNewUserWasRegistered(UserDTO userDTO) {
        Assert.assertEquals(
                ApplicationManager.getDriver().findElement(
                                By.xpath("//a[@href='/customer/info']"))
                        .getText().trim(),
                userDTO.getEmail().trim());
    }
    public void clickLogoutBtn() {
        clickBase(btnLogout);
    }

}
