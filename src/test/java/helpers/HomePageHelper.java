package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    By textTitle = By.xpath("//div[@class='css-1ww912h']");

    public void navigateToHomePage() {
        driver.navigate().to("https://fastfix-app-jcage.ondigitalocean.app");
    }

    public String getTextTitleHomePage() {
        return getTextBaseByLocator(textTitle);
    }

}
