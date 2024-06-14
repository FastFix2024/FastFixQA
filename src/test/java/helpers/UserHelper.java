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
        WebElement fillUsername = driver.findElement(By
                .xpath("//input[contains(@name,'username')]"));
        fillUsername.click();
        fillUsername.clear();
        fillUsername.sendKeys(username);
    }
    public void fillEmailToRegister(String email) {
        WebElement fillEmail = driver.findElement(By
                .xpath("//input[contains(@name,'email')]"));
        fillEmail.click();
        fillEmail.clear();
        fillEmail.sendKeys(email);
    }
    public void fillPasswordToRegister(String password) {
        WebElement fillPassword = driver.findElement(By
                .xpath("//input[@name='password']"));
        fillPassword.click();
        fillPassword.clear();
        fillPassword.sendKeys(password);
    }
    public void confirmPasswordToRegister(String password) {
        WebElement confirmPassword = driver.findElement(By
                .xpath("//input[@name='passwordRetype']"));
        confirmPassword.click();
        confirmPassword.clear();
        confirmPassword.sendKeys(password);
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
