package com.jetbrains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChipsTests extends TestBase {
    @DisplayName("Checking the selected chip in filter tags")
    @Test
    void checkChosenChip() {
        mainPage.openPage()
                .chooseChip()
                .checkFilters();
    }
}
