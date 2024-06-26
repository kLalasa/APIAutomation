package gorest.crud.Create;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NonBDDStyle {
    @Test
    public void NonBDDTest() {
        Integer id;
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://gorest.co.in/");
        r.basePath("/public/v2");
        r.contentType(ContentType.JSON); // Set content type to JSON
        r.header("Authorization","Bearer b8911997c283d2462abc4ba98888aa35032f95262d53445d68d0fc2c34d0fec2");

        String payload = "{\n" +
                "    \n" +
                "    \"name\":\"Viaan\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"email\":\"vian@gmail.com\",\n" +
                "    \"status\":\"inactive\"\n" +
                "}";

        r.body(payload);

        Response response = r.when().post("/users");
        ValidatableResponse validatableResponse = response.then();

        String responseString = response.asString();
        System.out.println(responseString);
        validatableResponse.statusCode(201);

        id=response.then().log().all().extract().path("id");
        System.out.println(id);

    }
}