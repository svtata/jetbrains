package com.jetbrains;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.jetbrains.configuration.WebConfig;
import com.jetbrains.helpers.Attach;
import com.jetbrains.pages.MainPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    static WebConfig driver;

    @BeforeAll
    static void beforeAll() {
        driver = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.baseUrl = driver.getBaseUrl();
        Configuration.browser = driver.getBrowser();
        Configuration.browserVersion = driver.getBrowserVersion();
        Configuration.browserSize = driver.getBrowserSize();

        if (driver.isRemote()) {
            System.out.println("Driver is remote. Configuring...");
            Configuration.remote = driver.getRemoteURL();
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

    MainPage mainPage = new MainPage();

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
