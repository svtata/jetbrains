package com.jetbrains.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.jetbrains.configuration.WebDriverConfig;
import com.jetbrains.helpers.Attach;
import com.jetbrains.pages.MainPage;
import com.jetbrains.pages.ProfilePage;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    public static WebDriverConfig driverConfig;

    @BeforeAll
    static void beforeAll() {
        driverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        Configuration.baseUrl = driverConfig.getBaseUrl();
        Configuration.browser = driverConfig.getBrowser();
        Configuration.browserVersion = driverConfig.getBrowserVersion();
        Configuration.browserSize = driverConfig.getBrowserSize();

        if (driverConfig.isRemote()) {
            Configuration.remote = driverConfig.getRemoteURL();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }

}
