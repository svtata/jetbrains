package com.jetbrains.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProductsPage {

    @Step("Check that filter contains selected language")
    public void checkNameInFilters(String names) {
        $(".filter__tags").shouldHave(Condition.text(names));
    }
}

