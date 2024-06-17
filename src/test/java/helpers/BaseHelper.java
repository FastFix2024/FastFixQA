package helpers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class BaseHelper {
    WebDriver driver;

    static Logger logger = LoggerFactory.getLogger(BaseHelper.class);
    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }
    protected WebElement findElementBase(By by) {
        logger.info("Locator: findElement: " + by.toString());
        return driver.findElement(by);
    }
    protected void clickBase(By by) {
        findElementBase(by).click();
    }
    protected String getTextBaseByLocator(By by) {
        String text = findElementBase(by).getText().trim();
        logger.info("get text from element: " + text);
        return text;
    }
    protected void typeText(String text, By by) {
        WebElement element = findElementBase(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public String getTextAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText().trim();
    }
    public void clickOkAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
