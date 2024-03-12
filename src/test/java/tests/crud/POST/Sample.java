package tests.crud.POST;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Sample {

    @Test
    public void reqres(){

        RequestSpecification r= RestAssured.given();

        String payload="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        r.baseUri("https://reqres.in/");
        r.basePath("/api/users");
        r.body(payload);

        Response response=r.when().post();

        ValidatableResponse validatableResponse=response.then().log().all();
        String responseString=response.asString();
        System.out.println(responseString);
        validatableResponse.statusCode(201);
    }
}
