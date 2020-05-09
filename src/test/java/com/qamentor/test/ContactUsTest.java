package com.qamentor.test;

import com.qamentor.util.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase {

    @Test(dataProvider="getData")
    public void shouldFillTextInputForm(String fName, String lName, String mail, String phone, String message, String select) {
        homePage            .openHomePage().clickButtonContactUs();
        contactUsPage       .nameForm(fName)
                            .lastNameForm(lName)
                            .mailForm(mail)
                            .phoneNumberForm(phone)
                            .messageForm(message)
                            .selectQuestions(select)
                            .clickButtonSend();
//                            .reCaptchaClick();
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {{"Volodymyr", "Pikanov", "test@qamentor.com", "+380632773351", "test", "Request a Call Back"},
                               {"Antony", "Malkov", "test@qamentor.com", "+380632773351", "test", "Request a Quote"},
                               {"Andrew", "Simons", "test@qamentor.com", "+380632773351", "test", "Request Online Presentation"},
                               {"Ben", "Jonson", "test@qamentor.com", "+380632773351", "test", "Request for Free Proof of Concept"},
                               {"Alex", "Orlov", "test@qamentor.com", "+380632773351", "test", "Request for Free Pilot Project"},
                               {"Rick", "Hoffman", "test@qamentor.com", "+380632773351", "test", "Request for Functional Testing"},
                               {"Sarah", "Rafferty", "test@qamentor.com", "+380632773351", "test", "Request for QA Services"},
                               {"Patrick", "Adams", "test@qamentor.com", "+380632773351", "test", "Request for QA Packages"},
                               {"Jessica", "Pirson", "test@qamentor.com", "+380632773351", "test", "Request for Non-Functional Testing"}};
    }
}
