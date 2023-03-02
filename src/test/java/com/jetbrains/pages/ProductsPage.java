package com.jetbrains.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    @Step("Check that filter contains selected language")
    public ProductsPage checkFilters() {
        $(".filter__tags").shouldHave(Condition.text("JavaScript, TypeScript"));
        return this;
    }
}

