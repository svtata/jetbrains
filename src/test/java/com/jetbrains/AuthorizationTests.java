package com.jetbrains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.jetbrains.TestData.PASSWORD;
import static com.jetbrains.TestData.USERNAME;


public class AuthorizationTests extends TestBase {

    @DisplayName("Successful login")
    @Test
    void loginTest() {
        mainPage.openPage()
                .loginOpenPage()
                .setLogin(USERNAME)
                .setPassword(PASSWORD)
                .clickSignIn()
                .checkAccountPage();
    }

    @DisplayName("Unsuccessful login (wrong password)")
    @Test
    void unsuccessfulLoginTest() {
        mainPage.openPage()
                .loginOpenPage()
                .setLogin(USERNAME)
                .setPassword("1234")
                .clickSignInWithWrongData()
                .checkErrorMessage();
    }

    @DisplayName("Logout")
    @Test
    void logOutTest() {
        mainPage.openPage()
                .loginOpenPage()
                .setLogin(USERNAME)
                .setPassword(PASSWORD)
                .clickSignIn()
                .clickOnUsername()
                .logOut()
                .checkLogOut();
    }

    @DisplayName("Going to password recovery page")
    @Test
    void forgetPasswordTest() {
        mainPage.openPage()
                .loginOpenPage()
                .clickForgotPassword()
                .checkInputMail()
                .checkButtonSubmit();
    }

}
