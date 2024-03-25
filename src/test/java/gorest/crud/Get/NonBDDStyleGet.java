package gorest.crud.Get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStyleGet {
    @Test
    public void NonBDDGet(){
        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in/");
        requestSpecification.basePath("/public/v2/users/6805375");
        requestSpecification.contentType(ContentType.JSON);

        Response response=requestSpecification.when().get();

        ValidatableResponse validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("name", Matchers.equalTo("Shashi Varma"));
        validatableResponse.body("email",Matchers.equalTo("shashi_varma@torphy.example"));
    }
}
