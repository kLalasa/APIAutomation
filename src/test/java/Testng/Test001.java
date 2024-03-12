package Testng;

import org.testng.annotations.*;

public class Test001 {
    @BeforeSuite
    void  demo1(){
        System.out.println("Before suit");
    }
    @BeforeTest
    void demo2(){
        System.out.println("Before Test");
    }
    @BeforeClass
    void demo3(){
        System.out.println("Before class");
    }
    @BeforeMethod
    void demo4(){
        System.out.println("Before Method");
    }
    @Test
    void demo5(){
        System.out.println("Test");
    }
    @AfterMethod
    void demo6(){
        System.out.println("After method");
    }
    @AfterClass
    void demo7(){
        System.out.println("After class");
    }
    @AfterTest
    void demo8(){
        System.out.println("After test");
    }
    @AfterSuite
    void demo9(){
        System.out.println("After suite");
    }
}
