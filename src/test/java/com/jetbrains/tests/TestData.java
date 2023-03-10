package com.jetbrains.tests;

import java.util.List;

public class TestData {

    public final static String USERNAME = System.getenv("USERNAME");
    public final static String PASSWORD = System.getenv("PASSWORD");
    public final static List<String> TABS = List.of("Developer Tools", "Team Tools",
            "Education", "Solutions", "Support",
            "Store");

}
