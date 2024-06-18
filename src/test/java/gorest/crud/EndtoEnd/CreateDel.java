package gorest.crud.EndtoEnd;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateDel {
    Integer id;
    @BeforeTest

    public void CreateTest(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://gorest.co.in/");
        r.basePath("/public/v2");
        r.contentType(ContentType.JSON); // Set content type to JSON
        r.header("Authorization","Bearer b8911997c283d2462abc4ba98888aa35032f95262d53445d68d0fc2c34d0fec2");

        String payload = "{\n" +
                "    \n" +
                "    \"name\":\"Gyanesh\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"email\":\"gyan@gmail.com\",\n" +
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
    @Test

    public void DelTest(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://gorest.co.in/");
        r.basePath("/public/v2/users/" + id);
        r.contentType(ContentType.JSON);
        r.header("Authorization","Bearer b8911997c283d2462abc4ba98888aa35032f95262d53445d68d0fc2c34d0fec2");
        Response response=r.when().delete();

        ValidatableResponse validatableResponse=response.then().log().all();
        validatableResponse.statusCode(204);

    }
}
