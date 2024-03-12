package Testng.DDT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT01 {
    @Test( dataProvider = "getData",dataProviderClass = UtilExcel.class)
    public void testLoginData(String username,String password){
        System.out.println("Username=" +username);
        System.out.println("Password=" +password);

        String payload="{\n" +
                "  \"username\": \"contact+atb5x@thetestingacademy.com\",\n" +
                "  \"password\": \"ATBx@1234\",\n" +
                "  \"remember\": false,\n" +
                "  \"recaptcha_response_field\": \"\"\n" +
                "}\n";

        RequestSpecification r= RestAssured.given();
        r.baseUri("https://app.vwo.com");
        r.basePath("/login");
        r.body(payload);
        r.contentType(ContentType.JSON);
        Response response = r.when().post();

        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
         validatableResponse.statusCode(200);

    }
}
