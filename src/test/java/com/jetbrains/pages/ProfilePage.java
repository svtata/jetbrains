package com.jetbrains.pages;

import com.jetbrains.AuthApi;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.jetbrains.TestData.ACCOUNT_URL;

public class ProfilePage {
    @Step("Open profile page as authorized user")
    public ProfilePage openProfilePageWithAuthorization() {
        AuthApi authApi = new AuthApi();
        Map<String, String> authorizationCookie = authApi.getAuthorizationCookie();
        open(ACCOUNT_URL + "/static/images/oauth2/github.svg");
        authorizationCookie.forEach((cookieName, cookieValue) -> {
            getWebDriver().manage().addCookie(new Cookie(cookieName, cookieValue));
        });
        open(ACCOUNT_URL + "/profile-details");
        return this;
    }

    @Step("Open menu item {value}")
    public ProfilePage openMenuItem(String value) {
        $$(".list-group-item a")
                .find(text(value))
                .click();
        return this;
    }

    @Step("Check title of menu item")
    public void checkTitle(String value) {
        $(".col-sm-12").shouldHave(text(value));
    }
}
