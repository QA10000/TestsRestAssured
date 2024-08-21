package postapis;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class CreateUserUsingMap {
    @Test
    public void createUserUsingMap() {
        HashMap<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("name", "morpheus");
        map.put("job", "leader");
        ArrayList<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("Python");
        map.put("skills", list);
        System.out.println(map);

        HashMap<String, Object> detail = new LinkedHashMap<String, Object>();
        detail.put("company", "ABC");
        detail.put("email", "ish2234@@e343.com");
        map.put("details", detail);
        Response response = given().log().all()
                .contentType("application/json")
                .body(map)
                .post("https://reqres.in/api/users")
                .then().statusCode(201)
                .extract().response();
       // response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.statusLine());
    }
}