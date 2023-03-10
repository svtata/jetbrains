package com.jetbrains.configuration;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface WebDriverConfig extends Config {
    @Key("baseURL")
    @DefaultValue("https://jetbrains.com")
    String getBaseUrl();

    @Key("baseURL")
    @DefaultValue("https://account.jetbrains.com")
    String getAccountBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteURL();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}
