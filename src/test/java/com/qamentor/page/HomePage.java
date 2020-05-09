package com.qamentor.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qamentor.util.FileReader.readPropertiesFile;
import static com.qamentor.util.Locator.HOME_PAGE_BUTTON_CONTACT_US;
import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() {
        driver.get(readPropertiesFile().getProperty("homePage"));
        assertEquals(driver.getCurrentUrl(), readPropertiesFile().getProperty("homePage"));
        return this;
    }

    public HomePage clickButtonContactUs() {
        click(By.xpath(HOME_PAGE_BUTTON_CONTACT_US));
        return this;
    }
}
