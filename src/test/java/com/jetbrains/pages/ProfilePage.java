package com.jetbrains.pages;

import com.jetbrains.tests.AuthApi;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.jetbrains.tests.TestBase.driverConfig;

public class ProfilePage {

    private final AuthApi authApi = new AuthApi();

    @Step("Open profile page as authorized user")
    public ProfilePage openProfilePageWithAuthorization() {
        setAuthorizationCookies();
        open(driverConfig.getAccountBaseUrl() + "/profile-details");
        return this;
    }

    private void setAuthorizationCookies() {
        Map<String, String> authorizationCookies = authApi.getAuthorizationCookies();
        open(driverConfig.getAccountBaseUrl() + "/static/images/oauth2/github.svg");
        authorizationCookies.forEach((cookieName, cookieValue) ->
                getWebDriver()
                        .manage()
                        .addCookie(new Cookie(cookieName, cookieValue))
        );
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
