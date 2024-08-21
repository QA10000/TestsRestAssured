package com.qa.restassured.NonBDDGetApis;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GoRestApi {
    @Test
    public void getUsers() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RequestSpecification request = given().log().all();
        Response response = request.get("/public/v2/users");
        System.out.println("=========ResponseSection============");
        //System.out.println("Response Body  \n"+ response.getBody().asString());
        System.out.println(response.prettyPrint());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("======ValidateStatusLine======");
        String statusLine = response.getStatusLine();
        System.out.println("statusLine " + statusLine);
        Assert.assertTrue(statusLine.contains("200 OK"));
        System.out.println("=========GetSingleHeader============");
        String dateHeader = response.header("Date");
        Assert.assertTrue(dateHeader.contains("GMT"));
        System.out.println(dateHeader);
        Headers headers = response.getHeaders();
        System.out.println("Print all headers" + headers);
    }
    @Test
    public void getAllInactiveUsers() {
        System.out.println("=========RequestSection============");
        RestAssured.baseURI = "https://gorest.co.in/";
        RequestSpecification request = given().log().all();
        request.queryParam("status", "inactive");
        System.out.println("=========ResponseSection============");
        Response response = request.get("/public/v2/users");
        System.out.println(response.prettyPrint());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println(statusCode);
        String statusLine = response.getStatusLine();
        Assert.assertTrue(statusLine.contains("200 OK"));
    }
    @Test
    public void getAllPosts() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RequestSpecification request = given().log().all();
        Response response = request.get("/public/v2/posts");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("======ValidateStatusLine======");
        String statusLine = response.getStatusLine();
        System.out.println("statusLine " + statusLine);
        Assert.assertTrue(statusLine.contains("200 OK"));
        System.out.println("=========GetSingleHeader============");
        String dateHeader = response.header("Date");
        Assert.assertTrue(dateHeader.contains("GMT"));
        System.out.println(dateHeader);
        Headers headers = response.getHeaders();
        System.out.println("Print all headers" + headers);
    }
    @Test
    public void getAllComments() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RequestSpecification request = given().log().all();
        Response response = request.get("/public/v2/comments");
        System.out.println("=========ResponseSection============");
        //System.out.println("Response Body  \n"+ response.getBody().asString());
        System.out.println(response.prettyPrint());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("======ValidateStatusLine======");
        String statusLine = response.getStatusLine();
        System.out.println("statusLine " + statusLine);
        Assert.assertTrue(statusLine.contains("200 OK"));
        System.out.println("=========GetSingleHeader============");
        String dateHeader = response.header("Date");
        Assert.assertTrue(dateHeader.contains("GMT"));
        System.out.println(dateHeader);

        Headers headers = response.getHeaders();
        System.out.println("Print all headers" + headers);

    }
    @Test
    public void getAllTodos() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RequestSpecification request = given().log().all();
        Response response = request.get("/public/v2/todos");
        System.out.println("=========ResponseSection============");
        //System.out.println("Response Body  \n"+ response.getBody().asString());
        System.out.println(response.prettyPrint());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("======ValidateStatusLine======");
        String statusLine = response.getStatusLine();
        System.out.println("statusLine " + statusLine);
        Assert.assertTrue(statusLine.contains("200 OK"));
        System.out.println("=========GetSingleHeader============");
        String dateHeader = response.header("Date");
        Assert.assertTrue(dateHeader.contains("GMT"));
        System.out.println(dateHeader);
        String header = response.getHeader("Content-Encoding");
        System.out.println(header);
        Assert.assertTrue(header.contains("gzip"));
        Headers headers = response.getHeaders();
        System.out.println("Print all headers" + headers);
    }
}