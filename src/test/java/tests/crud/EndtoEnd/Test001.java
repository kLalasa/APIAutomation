package tests.crud.EndtoEnd;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test001 {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;
    @BeforeTest

    public  void getToken(){
        requestSpecification = RestAssured.given();

        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response=requestSpecification.post();
        validatableResponse =response.then();
        validatableResponse.body("token", Matchers.notNullValue());
        token=response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

        if(token.isEmpty()){
            Assert.assertTrue(false);
        }
        System.out.println(token);

    }
    @BeforeTest

    public void getBookingID(){

        System.out.println("Get Booking ID");
        requestSpecification= RestAssured.given();
        String payload="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");

        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        Response response= requestSpecification.when().post();
        String responseString= response.asString();
        response.then().statusCode(200);
        bookingId= response.then().log().all().extract().path("bookingid");
        System.out.println(bookingId);



    }
    @Test

    public void testPutRequest(){
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
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/" +bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(Payload);

        Response response=requestSpecification.when().put();

        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("James"));
        validatableResponse.body("lastname",Matchers.equalTo("Brown"));


    }

}
