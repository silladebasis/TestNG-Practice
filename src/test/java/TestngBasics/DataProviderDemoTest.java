package TestngBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoTest {
    WebDriver driver;
    @Test(dataProvider = "getData")
    public void dataProviderExample(String firstName,String lastName,String email,String pass){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(pass);
        //driver.quit();
    }
    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"Debasis","Silla","debasis@gmail.com","test@12345"},
                {"Rohini","Patro","rohini@gmail.com","test@123"},
        };
    }
}
