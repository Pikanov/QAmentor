package com.qamentor.util;

public class Locator {

    public static final String HOME_PAGE_BUTTON_CONTACT_US = "//a[contains(text(),'Contact Us')]";

    public static final String CONTACT_US_FNAME_FORM = "//input[@id='yourfname']";
    public static final String CONTACT_US_LNAME_FORM = "//input[@id='yourlname']";
    public static final String CONTACT_US_MAIL_FORM = "//input[@id='yourmail']";
    public static final String CONTACT_US_PHONE_FORM = "//input[@id='yourphone']";
    public static final String CONTACT_US_MESSAGE_FORM = "//textarea[@id='yourmessage']";
    public static final String CONTACT_US_SELECT_FORM = "//select[@id='yourselect']";

    public static final String CONTACT_US_CAPTCHA_FRAME = "//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]";
    public static final String CONTACT_US_CAPTCHA_CHECK_BOX = "#recaptcha-anchor > div.recaptcha-checkbox-border";
    public static final String CONTACT_US_SEND_BUTTON = "//input[@class='wpcf7-form-control wpcf7-submit']";
}
