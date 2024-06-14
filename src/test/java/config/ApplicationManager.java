package config;

import helpers.HomePageHelper;
import helpers.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    String browser;
    HomePageHelper homePageHelper;
    UserHelper userHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public void init() {
        if (browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--lang=en");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser != null && browser != "chrome"
                && browser != "firefox") {
            throw new IllegalArgumentException("browser entered not correct");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("");

        homePageHelper = new HomePageHelper(driver);
        userHelper = new UserHelper(driver);
    }
    public void quit() {
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
