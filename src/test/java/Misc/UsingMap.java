package Misc;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UsingMap {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    @Test
    public void testPostreq(){

        Map<String,Object>jsonbodyUsingMap= new LinkedHashMap<>();
        Faker faker=new Faker();
        String name=faker.name().fullName();

        jsonbodyUsingMap.put("firstname",faker.name().firstName());

        jsonbodyUsingMap.put("lastname",faker.name().lastName());
        jsonbodyUsingMap.put("totalprice",faker.random().nextInt(1000));
        jsonbodyUsingMap.put("depositpaid",faker.random().nextBoolean());
        Map<String,Object> bookingDatesMap=new HashMap<>();
        bookingDatesMap.put("checkin" ,"2018-01-01");
        bookingDatesMap.put("checkout","019-01-01");
        jsonbodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonbodyUsingMap.put("additionalneeds","Breakfast");
        System.out.println(jsonbodyUsingMap);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonbodyUsingMap).log().all();
        Response response=requestSpecification.when().post();
        Integer bookingId=response.then().extract().path("bookingid");

        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your booking id is" +bookingId);
    }
}
