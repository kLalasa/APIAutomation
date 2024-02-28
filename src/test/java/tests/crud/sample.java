package tests.crud;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class sample {
    //@Test
    void getUsers(){
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .basePath("\n" +
                        "/api/users?page=2")
                .when().get()
                .then().log().all().body("page", Matchers.equalTo(1)).statusCode(200);

    }
    @Test
    void CreatUser(){

        String payload="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        RestAssured
                .given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .contentType(ContentType.JSON).log().all()
                .body(payload)
                .when().post()
                .then().statusCode(201).log().all();
    }
}
