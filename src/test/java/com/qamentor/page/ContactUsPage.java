package com.qamentor.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.qamentor.util.Locator.*;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage nameForm(String text) {
        fillForm(By.xpath(CONTACT_US_FNAME_FORM), text);
        return this;
    }

    public ContactUsPage lastNameForm(String text) {
        fillForm(By.xpath(CONTACT_US_LNAME_FORM), text);
        return this;
    }

    public ContactUsPage mailForm(String text) {
        fillForm(By.xpath(CONTACT_US_MAIL_FORM), text);
        return this;
    }

    public ContactUsPage phoneNumberForm(String text) {
        fillForm(By.xpath(CONTACT_US_PHONE_FORM), text);
        return this;
    }

    public ContactUsPage messageForm(String text) {
        fillForm(By.xpath(CONTACT_US_MESSAGE_FORM), text);
        return this;
    }

    public ContactUsPage selectQuestions(String request) {
        selectForm(By.xpath(CONTACT_US_SELECT_FORM), request);
        return this;
    }

    public ContactUsPage reCaptchaClick() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(By.xpath(CONTACT_US_CAPTCHA_FRAME)));
        new WebDriverWait(driver, 20).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(CONTACT_US_CAPTCHA_CHECK_BOX))).click();
        return this;
    }

    public ContactUsPage clickButtonSend() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(CONTACT_US_SEND_BUTTON)));
        return this;
    }
}
