package tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStylePost {
    @Test
    public void TestNonBDDStyle() {

        RequestSpecification r = RestAssured.given();

        String Payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.body(Payload);
        r.contentType(ContentType.JSON);

        Response response = r.when().post();

        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse.statusCode(200);
    }
}
