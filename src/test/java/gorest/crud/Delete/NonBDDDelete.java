package gorest.crud.Delete;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDDelete {
    @Test

    public void testDel(){

        RequestSpecification r= RestAssured.given();
        r.baseUri("https://gorest.co.in/");
        r.basePath("/public/v2/users/6805722");
        r.contentType(ContentType.JSON);
        r.header("Authorization","Bearer b8911997c283d2462abc4ba98888aa35032f95262d53445d68d0fc2c34d0fec2");
        Response response=r.when().delete();

        ValidatableResponse validatableResponse=response.then().log().all();
        validatableResponse.statusCode(204);

    }
}
