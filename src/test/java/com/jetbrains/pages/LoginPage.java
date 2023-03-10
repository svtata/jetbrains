package com.jetbrains.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.SetValueOptions.withText;
import static io.qameta.allure.Allure.step;

public class LoginPage {

    //Annotation @Step shows password and login in the Allure report
    public LoginPage setLogin(String value) {
        step("Enter login", () -> {
            $("#username").setValue(withText(value).sensitive());
        });
        return this;
    }

    public LoginPage setPassword(String value) {
        step("Enter password", () -> {
            $("[name=password]").setValue(withText(value).sensitive());
        });
        return this;
    }

    @Step("Click on the Submit button")
    public AccountPage clickSignIn() {
        $(".login-submit-btn").click();
        return new AccountPage();
    }

    @Step("Click on the Submit button with wrong username/password")
    public LoginPage clickSignInWithWrongData() {
        $(".login-submit-btn").click();
        return this;
    }

    @Step("Check  error message")
    public void checkErrorMessage() {
        $(" .js-auth-dialog-form").shouldBe(text("Incorrect username and/or password")).shouldBe(visible);
    }

    @Step("Click on the button \"Forgot Password?\"")
    public ForgotPasswordPage clickForgotPassword() {
        $(".btn-link").click();
        return new ForgotPasswordPage();
    }
}
