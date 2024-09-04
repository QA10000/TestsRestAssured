package postapis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateFakerUser {
    @Test
    public void postFakerUser() throws JsonProcessingException {
        //1 create object for Faker class
        Faker faker = new Faker();
        //2 define base uri
        RestAssured.baseURI = "https://reqres.in/";

        // 3 Create request specification
        RequestSpecification request = RestAssured.given().log().all();
        request.contentType("application/json");
        ReqresCreateUserFaker reqresdata = new ReqresCreateUserFaker(faker.name().firstName(), (faker.job().field()));
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(reqresdata);
        request.body(payload);
        Response response = request.post("/api/users");
        response.prettyPrint();
    }
}



