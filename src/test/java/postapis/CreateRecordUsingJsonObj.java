package postapis;
import io.restassured.response.Response;

import org.json.JSONArray;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;

public class CreateRecordUsingJsonObj {
@Test
    public void createRecordUsingJsonObj() {
        JSONObject obj = new JSONObject();
        //obj.put("empty", true);
       // obj.put("mapType", "java.util.HashMap");
        obj.put("name", "mori");
        obj.put("job", "leader");
        //System.out.println(obj);

        JSONArray skill = new JSONArray();
        skill.put("Python");
        skill.put("Java");
        skill.put("C++");
        obj.put("skills", skill);

        JSONObject detail = new JSONObject();
        detail.put("company", "ABC");
        detail.put("email", "myname@345345.com");
        obj.put("details", detail);
    String jsonString = obj.toString();


    Response response = given().log().all()
                .contentType("application/json")
                .body(jsonString)
                .post("https://reqres.in/api/users")
                .then().statusCode(201)
               .extract().response();
        //response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.statusLine());
    }

    }

