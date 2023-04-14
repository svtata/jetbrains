package com.jetbrains.tests;

import com.jetbrains.pages.MainPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Feature("Tabs on the main page")
public class TabTests extends TestBase {

    MainPage mainPage = new MainPage();

    @ValueSource(strings = {"Developer Tools", "Team Tools",
            "Education", "Solutions", "Support",
            "Store"})
    @ParameterizedTest(name="Checking tab {0} on the main page")
    void checkMainPageTabsTest(String tab) {
        mainPage.openPage()
                .checkTab(tab);
    }

}
