package tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStylePost {
    @Test
    public void testBDDStylePost() {
        String Payload= "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth").contentType(ContentType.JSON).log().all()
                .body(Payload).when().post().then().log().all().statusCode(200);

    }
}
