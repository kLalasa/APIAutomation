package tests.crud.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePUT {
    RequestSpecification r;
    Response response;
    ValidatableResponse validatableResponse;
    String token="591419c347844a5";
    @Test
    public void testPUTREquest(){

        String Payload="{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/21");
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(Payload);

        response=r.when().put();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("James"));
        validatableResponse.body("lastname",Matchers.equalTo("Brown"));

    }



}
