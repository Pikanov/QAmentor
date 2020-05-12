package com.qamentor.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qamentor.page.ContactUsPage;
import com.qamentor.page.HomePage;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.qamentor.util.FileReader.readPropertiesFile;
import static org.testng.internal.Utils.copyFile;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;
    public WebElement element;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public HomePage homePage;
    public ContactUsPage contactUsPage;

    @BeforeClass
    public void initialization() {
        if (driver == null) {
            if (readPropertiesFile().getProperty("browserName").equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/chromedriver.exe");
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

    @BeforeTest
    public void extentReportSetup() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle("Automation Report"); // Tittle of Report
        htmlReporter.config().setReportName("QAmentor"); // Name of the report
        htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report

        // General information related to application
        extent.setSystemInfo("Application Name", "QAmentor test");
        extent.setSystemInfo("User Name", "Volodymyr Pikanov");
        extent.setSystemInfo("Envirnoment", "Production");
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            //MarkupHelper is used to display the output in different colors
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.

            //	String Screenshot=TakeScreenshot.captureScreenshot(driver,"TestCaseFailed");
            String screenshotPath = TakeScreenshot(driver, result.getName());
            //To add it in the extent report

            test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));

        } else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));

        } else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
    }

    public static String TakeScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        copyFile(source, finalDestination);
        return destination;
    }
}
