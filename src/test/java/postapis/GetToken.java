package postapis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;

public class GetToken {

    @Test
    public void getTokenByPojo() throws JsonProcessingException {
        // 1 define base url
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        // 2 Create request specification
        RequestSpecification request = RestAssured.given().log().all();
        request.contentType("application/json");
        //3 passing the json file
        Credentials credentials = new Credentials("admin", "password123");
        //4 create an object of mapper class to convert objects to payload
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(credentials);
        //5  pass the payload to request
        request.body(payload);
        //6   make the post call
        Response response = request.post("/auth");
        // 7 print the response
        response.prettyPrint();
    }


    @Test
    public void getToken() {
        // 1 define base url
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        // 2 Create request specification
        RequestSpecification request = RestAssured.given().log().all();
        request.contentType("application/json");
        //3 passing the json file
        File payload = new File("./src/test/resources/payloads/gettoken.json");
        // 4 pass the payload to request
        request.body(payload);
        //5  make the post call
        Response response = request.post("/auth");
        // 6 print the response
        response.prettyPrint();
    }
}