package postapis;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class CreateUser {
    @Test
    public void createUser() {
        // 1 define base url
        RestAssured.baseURI = "https://gorest.co.in";
        // 2 create request specification
        RequestSpecification request = RestAssured.given().log().all();
        request.contentType("application/json");
        request.header("Authorization", "Bearer 6cea604168408a4b9a6654b5551458debbd4a818e7c85ba192e2f3749e6f60ca");
        // 3 passing the json file
        File payload= new File("./src/test/resources/payloads/user.json");
        // 4 pass the payload to request
        request.body(payload);
        // 5  make the post call
        Response response = request.post("/public/v2/users");
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);
        Assert.assertTrue(statusLine.contains("201"));
        // 6 print the response
        response.prettyPrint();
    }
}
