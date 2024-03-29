package com.jetbrains.tests;

import com.jetbrains.pages.MainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Chips for going to filters")
public class ChipsTests extends TestBase {

    MainPage mainPage = new MainPage();

    @DisplayName("Checking the selected chip in filter tags")
    @Test
    void checkChosenChip() {
        mainPage.openPage()
                .chooseChip("JavaScript")
                .checkNameInFilters("JavaScript, TypeScript");
    }

}

