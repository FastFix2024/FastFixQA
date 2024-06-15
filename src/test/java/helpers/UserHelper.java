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
    By btnLoginNB = By.xpath("//button[contains(@class,'css-1xrb8ai')and(text()='LOGIN')]");
    By btnRegisterForm = By.xpath("//button[contains(@class,'css-h94xtx')]");
    By btnLoginForm = By.xpath("//button[contains(@class,'css-117zi8f')]");
    By btnSubmitReg = By.xpath("//button[contains(@class,'css-dqj9az')and(text()='SUBMIT')]");
    By checkbox = By.xpath("//input[@id='agreement-id']");
    By btnSubmitLogin = By.xpath("//button[contains(@class,'css-1xrb8ai')and(text()='SUBMIT')]");
    By btnLogout = By.xpath("");
    By btnDeleteAccount = By.xpath("");
    By btnConfirmDeleteAccount = By.xpath("");

    public void register(UserDTO userDTO) {
        clickLoginOnNavBar();
        pause(5000);
        clickRegister();
        fillUsernameToRegister(userDTO.getUsername());
        fillEmailToRegister(userDTO.getEmail());
        fillPasswordToRegister(userDTO.getPassword());
        confirmPasswordToRegister(userDTO.getConfirmPassword());
        clickCheckbox();
        clickSubmitRegisterBtn();
    }
    public void clickLoginOnNavBar() {
        clickBase(btnLoginNB);
    }
    public void clickRegister() {
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
    public void login(UserDTO user) {
        fillEmailOnLogin(user.getEmail());
        fillPasswordOnLogin(user.getPassword());
        clickSubmitLoginBtn();
    }
    public void verifyRegistration(UserDTO userDTO) {
        Assert.assertEquals(
                ApplicationManager.getDriver().findElement(
                                By.xpath(""))
                        .getText().trim(),
                userDTO.getEmail().trim());
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

    public void clickLogoutBtn() {
        clickBase(btnLogout);
    }

    public void deleteAccount(){
        clickDeleteAccountBtn();
        clickToConfirmDeleteAccountBtn();
    }

    public void clickToConfirmDeleteAccountBtn() {
        clickBase(btnConfirmDeleteAccount);
    }

    public void clickDeleteAccountBtn(){
        clickBase(btnDeleteAccount);
    }

}
