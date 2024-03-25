package gorest.crud.Update;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePatch {
    @Test
    public void NonBDDPatchTest(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://gorest.co.in/");
        r.basePath("/public/v2/users/6805375");
        r.contentType(ContentType.JSON);
        String payload = "{\n" +
                "    \"name\":\"Vasi\",\n" +
                "    \"email\":\"vasi@gmail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";
        r.body(payload);
        r.header("Authorization","Bearer b8911997c283d2462abc4ba98888aa35032f95262d53445d68d0fc2c34d0fec2");
        Response response=r.when().patch();

        ValidatableResponse validatableResponse= response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("name", Matchers.equalTo("Vasi"));
        validatableResponse.body("email",Matchers.equalTo("vasi@gmail.com"));

    }
}
