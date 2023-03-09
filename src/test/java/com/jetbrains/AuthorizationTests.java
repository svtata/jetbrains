package com.jetbrains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.jetbrains.TestData.PASSWORD;
import static com.jetbrains.TestData.USERNAME;


public class AuthorizationTests extends TestBase {

    @DisplayName("Login as user")
    @Test
    void LoginTest() {
        mainPage.openPage()
                .loginOpenPage()
                .setLogin(USERNAME)
                .setPassword(PASSWORD)
                .clickSignIn()
                .checkAccountPage();
    }

    @DisplayName("Logout")
    @Test
    void LogOutTest() {
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
    void ForgetPasswordTest() {
        mainPage.openPage()
                .loginOpenPage()
                .clickForgotPassword()
                .checkInputMail()
                .checkButtonSubmit();
    }

}
