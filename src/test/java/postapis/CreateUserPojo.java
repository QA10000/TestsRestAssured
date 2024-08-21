package postapis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateUserPojo {
    @Test
    public void createUserByPojo() throws JsonProcessingException {
        // 1  Create base url
        RestAssured.baseURI = "https://gorest.co.in";
        // 2 create request specification
        RequestSpecification request = RestAssured.given().log().all();
        request.contentType("application/json");
        request.header("Authorization", "Bearer 6cea604168408a4b9a6654b5551458debbd4a818e7c85ba192e2f3749e6f60ca");
        // 3 passing the json file
        CreateUserForPojo createuserforpojo = new CreateUserForPojo("jona", "jenin@3434.com", "female", "active");
        //4 create an object of mapper class to convert objects to payload
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(createuserforpojo);
        //5  pass the payload to request
        request.body(payload);
        //6   make the post call
        Response response = request.post("/public/v2/users");
        // 7 print the response
        response.prettyPrint();

    }
}
