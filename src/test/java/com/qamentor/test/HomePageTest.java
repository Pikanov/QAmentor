package com.qamentor.test;


import com.qamentor.util.TestBase;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void shouldFindAndClickButtonContactUs() {
        test = extent.createTest("Should find 'Contact US' button and click");
        homePage.openHomePage().clickButtonContactUs();
    }
}
