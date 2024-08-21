package postapis;


import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Helpcode {
        @Test
        public void createRecordUsingJsonObj() {
            JsonObject obj = new JsonObject();
            obj.addProperty("name", "moriw");
            obj.addProperty("job", "leader");

            JsonArray skill = new JsonArray();
            skill.add("Python");
            skill.add("Java");
            skill.add("C++");
            obj.add("skills", skill);

            JsonObject detail = new JsonObject();
            detail.addProperty("company", "ABC");
            detail.addProperty("email", "myname1@345345.com");
            obj.add("details", detail);

            String jsonString = obj.toString();

            Response response = given().log().all()
                    .contentType("application/json")
                    .body(jsonString)
                    .post("https://reqres.in/api/users")
                    .then().statusCode(201)
                    .extract().response();
            response.prettyPrint();
            System.out.println(response.getStatusCode());
            System.out.println(response.statusLine());
        }
    }

