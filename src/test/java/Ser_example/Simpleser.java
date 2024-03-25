package Ser_example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

public class Simpleser {
    @Test
    public void test1(){
        example empobj=new example();
        empobj.setFirstname("Kiran");
        empobj.setLastname("Krishna");
        empobj.setAge(50);
        empobj.setGender("Male");
        empobj.setMarried(false);
        Gson gson=new Gson();
        String jsonEmp= gson.toJson(empobj);
        System.out.println(jsonEmp);

        Gson gsonBuilder=new GsonBuilder().setPrettyPrinting().create();
        String employeeJsonStringGsonBuilder=gsonBuilder.toJson(empobj);
        System.out.println(employeeJsonStringGsonBuilder);
    }
}
