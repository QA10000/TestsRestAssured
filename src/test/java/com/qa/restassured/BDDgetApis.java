package com.qa.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BDDgetApis {
    @Test
    public void getAllUsers() {
        RestAssured.baseURI = "https://gorest.co.in";
        given().log().all().contentType("application/json")
        .when().get("/public/v2/users")
        .then().statusCode(200)
        .header("server", "cloudflare")
        .header("Content-Encoding", "gzip");
     }
}
