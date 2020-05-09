package com.qamentor.page;

import com.qamentor.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends TestBase {

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void click(By elementBy){
        driver.findElement(elementBy).click();
    }

    public void fillForm(By elementBy, String text){
        driver.findElement(elementBy).sendKeys(text);
    }

    public void selectForm(By elementBy, String request){
        new Select(driver.findElement(elementBy)).selectByVisibleText(request);
    }
}
