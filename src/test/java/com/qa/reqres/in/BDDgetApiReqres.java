package com.qa.reqres.in;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BDDgetApiReqres {
    @Test(priority = 1)
    public void getAllUsers() {
        RestAssured.baseURI = "https://reqres.in/";
        given().log().all().contentType("application/json")
                .when().get("api/users?page=2")
                .then().statusCode(200)
                .header("server", "cloudflare")
                .header("Content-Encoding", "gzip");
    }

    @Test(priority = 3)
    public void getSingleUser() {
        RestAssured.baseURI = "https://reqres.in";
        given().log().all().contentType("application/json")
                .when().get("/api/users/2")
                .then().statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

    }

    @Test(priority = 3)
    public void getUserNotFound() {
        RestAssured.baseURI = "https://reqres.in";
        given().log().all().contentType("application/json")
                .when().get("/api/users/23")
                .then().statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found");



    }

    @Test(priority = 4)
    public void getlistResourcss() {
        RestAssured.baseURI = "https://reqres.in";
        given().log().all().contentType("application/json")
                .when().get("/api/unknown")
                .then().statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

    }

    @Test(priority = 5)
    public void getSingleResource() {
        RestAssured.baseURI = "https://reqres.in";
        given().log().all().contentType("application/json")
                .when().get("/api/unknown/2")
                .then().statusCode(200)
                .statusLine("HTTP/1.1 200 OK");

    }
    @Test(priority = 6)
    public void getResourcesNotFound() {
       RestAssured.baseURI = "https://reqres.in";
       given().log().all().contentType("application/json")
               .when().get("/api/unknown/23")
               .then().statusCode(404)
               .statusLine("HTTP/1.1 404 Not Found");

    }

}