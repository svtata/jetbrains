package com.jetbrains.pages;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.exactTextsCaseSensitiveInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.jetbrains.TestData.TABS;

public class MainPage {

    @Step("Open main page jetbrains.com")
    public MainPage openPage() {
        Selenide.open(Configuration.baseUrl);
        return this;
    }

    @Step("Go to login page")
    public LoginPage loginOpenPage() {
        $("[aria-label=\"Navigate to profile\"]").click();
        return new LoginPage();
    }

    @Step("Check tabs on the main page")
    public MainPage checkTab() {
        $$("[data-test=\"main-menu-item\"]")
                .shouldHave(exactTextsCaseSensitiveInAnyOrder(TABS));
        return this;
    }

    @Step("Click on the chip")
    public ProductsPage chooseChip() {
        $$("[data-test=\"button\"]").find(text("JavaScript")).click();
        return new ProductsPage();
    }

}
