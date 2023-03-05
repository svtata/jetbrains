package com.jetbrains;

import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static com.jetbrains.TestData.PASSWORD;
import static com.jetbrains.TestData.USERNAME;
import static io.restassured.RestAssured.given;

public class AuthApi {

    public Map<String, String> getCookiesFromLoginForm() {
        return given()
                .when()
                .get("https://account.jetbrains.com/login")
                .then()
                .statusCode(200)
                .extract().cookies();
    }

    public Map<String, String> getAuthorizationCookie() {
        Map<String, String> cookies = getCookiesFromLoginForm();
        Map<String, String> newCookies = given()
                .contentType(ContentType.URLENC)
                .queryParam("_st", cookies.get("_st-JBA"))
                .formParam("username", USERNAME)
                .formParam("password", PASSWORD)
                .cookies(cookies)
                .when()
                .post("https://account.jetbrains.com/authorize")
                .then()
                .log().all()
                .statusCode(302)
                .extract().cookies();
        HashMap<String, String> result = new HashMap<>();
        result.putAll(cookies);
        result.putAll(newCookies);
        return result;
    }

}
