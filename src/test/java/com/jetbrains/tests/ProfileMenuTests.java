package com.jetbrains.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Feature("Tabs in profile menu")
public class ProfileMenuTests extends TestBase {

    private static Stream<Arguments> checkTabsInProfileMenu() {
        return Stream.of(
                Arguments.of("Password", "Security Settings"),
                Arguments.of("Privacy", "Privacy Settings"),
                Arguments.of("Linked emails", "Link other emails to this account"),
                Arguments.of("Notifications", "Notification Settings"),
                Arguments.of("Newsletters", "Newsletters")
        );
    }

    @DisplayName("Check tabs in profile menu")
    @MethodSource(value = "checkTabsInProfileMenu")
    @ParameterizedTest(name = "Menu item {0} contains title {1}")
    void checkProfileMenu(String menuItem, String title) {
        profilePage.openProfilePageWithAuthorization()
                .openMenuItem(menuItem)
                .checkTitle(title);
    }
}
