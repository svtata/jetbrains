package com.jetbrains;

import java.util.List;

public class TestData {

    public final static String USERNAME = System.getenv("TEST_USERNAME");
    public final static String PASSWORD = System.getenv("TEST_PASSWORD");
    public final static List<String> TABS = List.of("Developer Tools", "Team Tools",
            "Education", "Solutions", "Support",
            "Store");

}
