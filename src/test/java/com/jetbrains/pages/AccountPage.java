package com.jetbrains.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    @Step("Check that the account page is open")
    public void checkAccountPage() {
        $("ul li:nth-child(2)").shouldBe(Condition.visible);
    }

    @Step("Click on the username")
    public AccountPage clickOnUsername() {
        $(".dropdown-toggle").click();
        return this;
    }

    @Step("Click on the logout button")
    public AccountPage logOut() {
        $(".icon-signout").click();
        return this;
    }

    @Step("Check that main page is open")
    public void checkReturnToMainPage() {
        $(".login-submit-btn").shouldBe(visible);
    }

}
