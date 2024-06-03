package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    By textTitle = By.cssSelector("");

    public void navigateToHomePage() {
        driver.navigate().to("");
    }

    public String getTextTitleHomePage() {
        return getTextBaseByLocator(textTitle);
    }
}
