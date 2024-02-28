package tests.crud.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStyleTestNG {
    @Test
    public void GetAllBookingPositive(){
    RequestSpecification r= RestAssured.given();
    r.baseUri("https://restful-booker.herokuapp.com");
    r.basePath("/booking/728").log().all();
    r.when().get();
    r.then().log().all().statusCode(200);
}
    @Test
    public void GetAllBookingNegative(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);

    }
    @Test(enabled = false)
    public void GetAllBookingNegative2(){
        RequestSpecification r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/abc").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);


    }





}
