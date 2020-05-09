package com.qamentor.util;

import com.qamentor.page.ContactUsPage;
import com.qamentor.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import static com.qamentor.util.FileReader.readPropertiesFile;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage homePage;
    public ContactUsPage contactUsPage;

    @BeforeClass
    public void initialization() {
        if (driver == null) {
            if (readPropertiesFile().getProperty("browserName").equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("start-maximized");
//                options.addArguments("disable-infobars");
//                options.addArguments("--disable-extensions");

                driver = new ChromeDriver();

            } else if (readPropertiesFile().getProperty("browserName").equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/webdrivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (readPropertiesFile().getProperty("browserName").equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "src/main/resources/webdrivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else if (readPropertiesFile().getProperty("browserName").equalsIgnoreCase("Opera")) {
                System.setProperty("webdriver.opera.driver", "src/main/resources/webdrivers/operadriver.exe");
                driver = new OperaDriver();
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        homePage = PageFactory.initElements(driver, HomePage.class);
        contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
