package Ser_example;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeSer {

    @Test
    public void DeserializationTest(){
        String jsonstring="{\n" +
                "  \"firstname\": \"Kiran\",\n" +
                "  \"lastname\": \"Krishna\",\n" +
                "  \"age\": 50,\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"married\": false\n" +
                "}\n";

        Gson gson=new Gson();
        example exmobj=gson.fromJson(jsonstring, example.class);
        String firstname=exmobj.getFirstname();
        String lastname=exmobj.getLastname();

        Assert.assertEquals(firstname,"Kiran");

    }
}
