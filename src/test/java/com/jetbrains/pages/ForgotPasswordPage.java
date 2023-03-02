package com.jetbrains.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    @Step("Check that the input field for email is visible")
    public ForgotPasswordPage checkInputMail() {
        $("[name=\"username\"]").shouldBe(Condition.visible);
        return this;
    }

    @Step("Check that the button Submit is visible")
    public ForgotPasswordPage checkButtonSubmit() {
        $(".btn-lg").shouldBe(Condition.visible);
        return this;
    }
}
