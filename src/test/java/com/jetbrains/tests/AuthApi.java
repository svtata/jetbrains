package com.jetbrains.tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static com.jetbrains.tests.TestBase.driverConfig;
import static com.jetbrains.tests.TestData.PASSWORD;
import static com.jetbrains.tests.TestData.USERNAME;
import static io.restassured.RestAssured.given;

public class AuthApi {

    public Map<String, String> getAuthorizationCookies() {
        Map<String, String> cookies = getCookiesFromLoginForm();
        Map<String, String> newCookies = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.URLENC)
                .queryParam("_st", cookies.get("_st-JBA"))
                .formParam("username", USERNAME)
                .formParam("password", PASSWORD)
                .cookies(cookies)
                .when()
                .post(driverConfig.getAccountBaseUrl() + "/authorize")
                .then()
                .log().all()
                .statusCode(302)
                .extract().cookies();

        HashMap<String, String> result = new HashMap<>();
        result.putAll(cookies);
        result.putAll(newCookies);
        return result;
    }

    private Map<String, String> getCookiesFromLoginForm() {
        return given()
                .filter(new AllureRestAssured())
                .when()
                .get("https://account.jetbrains.com/login")
                .then()
                .statusCode(200)
                .extract().cookies();
    }

}
