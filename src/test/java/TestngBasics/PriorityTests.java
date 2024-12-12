package TestngBasics;

import org.testng.annotations.Test;

public class PriorityTests {
    @Test(priority = 1)
    public void LoginTest(){
        System.out.println("Login Test .....");
    }
    @Test()
    public void RegistrationTest(){
        System.out.println("Registration Test ....");
    }
    @Test(priority = 1)
    public void ContactUsTest(){
        System.out.println("Contact us Test ...");
    }
}
