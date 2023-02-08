package com.testinium;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;

import static com.testinium.helper.Constants.*;

public class NegativeTestMethods extends StepImpl {


    @Step("Checking Phone Number Validation <key>")
    public void loginPhoneNoError(String phone) throws Exception {
     MobileElement error = findElementByKey(phone);
     if (error.isDisplayed()){
         logger.info("Test Pass : Getting validation error: " +error.getText());
     }
     else {

         logger.info("Test Fail : Doesn't Get validation error: ");
     }
    }

    @Step("Checking Password Validation <key>")
    public void loginPasswordError(String pass) throws Exception {
        MobileElement error = findElementByKey(pass);
        if (error.isDisplayed()){
            logger.info("Test Passed : Getting validation error: " +error.getText());
        }
        else {

            logger.info("Test Failed : Doesn't Get validation error: ");
        }
    }

    @Step("Enter Special Characters <key> and Getting an Error <key>")
    public void enterSpecialChar(String phoneField,String validation){

        MobileElement element = findElementByKey(phoneField);
        element.sendKeys(SPECIAL_CHARACTER);
        logger.info("Special Character is: "+SPECIAL_CHARACTER);
        waitBySecond(5);

        MobileElement error = findElementByKey(validation);
        if (error.isDisplayed()){
            logger.info("Test Passed - Enter Special characters and getting error validation: " + error.getText());
        }
        else {
            logger.info("Test Failed - Special Characters are accepted: ");
        }

    }

    @Step("Enter password less than minimum length <key> and Getting an Error <key>")
    public void passLength(String passlength,String validation){

        MobileElement element = findElementByKey(passlength);
        element.sendKeys(PASSWORD_LENGTH);
        logger.info("Password less than minimum value: "+PASSWORD_LENGTH);
        waitBySecond(5);

        MobileElement error = findElementByKey(validation);
        if (error.isDisplayed()){
            logger.info("Test Passed - Password Less than minimum length and getting error validation: " + error.getText());
        }
        else {
            logger.info("Test Failed - Password Less than minimum length are accepted: ");
        }

    }


    @Step("Enter password without letter <key> and Getting an Error <key>")
    public void passRequiremt(String pass,String validation){

        MobileElement element = findElementByKey(pass);
        element.sendKeys(PASSWORD_WITHOUT_LETTER);
        logger.info("Password without Letter: "+PASSWORD_WITHOUT_LETTER);
        waitBySecond(5);

        MobileElement error = findElementByKey(validation);
        if (error.isDisplayed()){
            logger.info("Test Passed - Password without Letter and getting error validation: " + error.getText());
        }
        else {
            logger.info("Test Failed - Password without Letter are accepted: ");
        }

    }

    @Step("Clear Input Field <key>")
    public void clearElement(String key) {
        MobileElement element = findElementByKey(key);
        element.clear();
    }
}
