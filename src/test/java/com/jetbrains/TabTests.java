package com.jetbrains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TabTests extends TestBase {

    @DisplayName("Checking tabs on the main page")
    @Test
    void checkMainPageTabsTest() {
        mainPage.openPage()
                .checkTab();
    }

}
