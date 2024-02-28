package tests.crud.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePatch {

        RequestSpecification r;
        Response response;
        ValidatableResponse validatableResponse;
        String token="ac68cf1f9fe44b0";
        @Test
        public void testPatchREquest(){

            String Payload="{\n" +
                    "    \"firstname\" : \"Bhagya\",\n" +
                    "    \"lastname\" : \"Lalasa\"\n" +
                    "}";
            r= RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/1");
            r.contentType(ContentType.JSON);
            r.cookie("token",token);
            r.body(Payload);

            response=r.when().patch();

            validatableResponse=response.then().log().all();
            validatableResponse.statusCode(200);
            validatableResponse.body("firstname", Matchers.equalTo("Bhagya"));
            validatableResponse.body("lastname",Matchers.equalTo("Lalasa"));

        }
    }


