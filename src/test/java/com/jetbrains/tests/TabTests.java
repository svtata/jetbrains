package com.jetbrains.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Tabs on the main page")
public class TabTests extends TestBase {

    @DisplayName("Checking tabs on the main page")
    @Test
    void checkMainPageTabsTest() {
        mainPage.openPage()
                .checkTab();
    }

}
