package Gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Postreq {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void TestPostive(){
        Booking booking=new Booking();
        booking.setFirstname("Mohan");
        booking.setLastname("Krishna");
        booking.setTotalprice(123);
        booking.setAdditionalneeds("Breakfast");
        booking.setDepositpaid(true);

        Bookingdates bookingdates=new Bookingdates();
        bookingdates.setCheckin("12-07-2023");
        bookingdates.setCheckout("24-07-2023");
        System.out.println(booking);

        Gson gson=new Gson();
        String jsonStringBooking=gson.toJson(booking);
        System.out.println(jsonStringBooking);

        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response=requestSpecification.when().post();
        String jsonResponseString=response.asString();

        validatableResponse =response.then().log().all();
        System.out.println(jsonResponseString);
        validatableResponse.statusCode(200);

        Bookingresponse bookingresponseObj=gson.fromJson(jsonResponseString,Bookingresponse.class);

        Assert.assertEquals(bookingresponseObj.getBooking().getFirstname(), "Mohan");


    }
}
