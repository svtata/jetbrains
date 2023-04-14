package com.jetbrains.tests;

import com.jetbrains.pages.MainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.jetbrains.tests.TestData.PASSWORD;
import static com.jetbrains.tests.TestData.USERNAME;

@Feature("Authorization")
public class AuthorizationTests extends TestBase {

    MainPage mainPage = new MainPage();

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
                .checkErrorMessageIsVisible();
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
                .checkReturnToMainPage();
    }

    @DisplayName("Going to password recovery page")
    @Test
    void forgetPasswordTest() {
        mainPage.openPage()
                .loginOpenPage()
                .clickForgotPassword()
                .checkInputMail()
                .checkSubmitButton();
    }

}
