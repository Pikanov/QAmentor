package com.qamentor.page;

import com.qamentor.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends TestBase {

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void click(By elementBy) {
        element = driver.findElement(elementBy);
        if (element.isDisplayed() || element.isEnabled()) {
            element.click();
        } else {
            System.out.println("Element not found");
        }
    }


    public void fillForm(By elementBy, String text) {
        element = driver.findElement(elementBy);

        if (element.isDisplayed() || element.isEnabled()) {
            element.sendKeys(text);
        } else {
            System.out.println("Input Form not found");
        }
    }

    public void selectForm(By elementBy, String request) {
        element = driver.findElement(elementBy);

        if (element.isDisplayed() || element.isEnabled()) {
            new Select(element).selectByVisibleText(request);
        } else {
            System.out.println("Select Form not found");
        }
    }
}
