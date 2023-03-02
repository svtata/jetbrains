package com.jetbrains.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @Step("Enter login")
    public LoginPage setLogin(String value) {
        $("#username").sendKeys(value);
        return this;
    }

    @Step("Enter password")
    public LoginPage setPassword(String value) {
        $("[name=password]").sendKeys(value);
        return this;
    }

    @Step("Click on the Submit button")
    public AccountPage clickSignIn() {
        $(".login-submit-btn").click();
        return new AccountPage();
    }

    @Step("Click on the button \"Forgot Password?\"")
    public ForgotPasswordPage clickForgotPassword() {
        $(".btn-link").click();
        return new ForgotPasswordPage();
    }
}
