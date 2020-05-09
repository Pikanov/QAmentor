package com.qamentor.test;


import com.qamentor.util.TestBase;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void shouldFindAndClickButtonContactUs() {
        homePage.openHomePage().clickButtonContactUs();
    }

}
