package testy;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("before suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("before class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("after suite");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("after class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("I'm running before test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I'm running before method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("I'm running after test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I'm running after method");
    }
}
