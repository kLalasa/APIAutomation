package tests.crud.DELTE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyleDelete {

    RequestSpecification r;
    Response response;
    ValidatableResponse validatableResponse;
    String token="dac689ca0648c7e";
    @Test
    public void testDelReq(){

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/49");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);

        response=r.when().delete();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(201);

    }
}
