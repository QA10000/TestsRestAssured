package postapis;
import org.testng.annotations.Test;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PuttingInfoUsingJsongObj {
    @Test
    public void puttingInfoUsingJsonObj() {
    JsonObject obj  = new JsonObject();
    obj.addProperty("name", "John");
    obj.addProperty("job", "Teacher");
    obj.addProperty("id", "562");
    String jsonString = obj.toString();

        Response response = given().log().all()
                .contentType("application/json")
                .body(jsonString)
                .put("https://reqres.in/api/users/2")
                .then().statusCode(200)
                .extract().response();
        System.out.println(response.getStatusCode());
        System.out.println(response.statusLine());


    }
}
