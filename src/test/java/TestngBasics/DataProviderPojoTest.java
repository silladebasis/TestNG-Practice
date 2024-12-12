package TestngBasics;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojos.ReservationPojo;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataProviderPojoTest {
    WebDriver driver;
    @Test(dataProvider = "getData")
    public void dataProviderExample(String firstName,String lastName,String email,String pass){
        System.out.println(firstName);
        System.out.println(lastName);
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
    public Object[][] getData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ReservationPojo> reservation = objectMapper.readValue(new File("src/test/resources/testData/reservationData.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, ReservationPojo.class));
        Object[][] data = new Object[reservation.size()][];
        for (int i = 0;i<reservation.size();i++){
           data[i] =  new Object[]{
                    reservation.get(i).getFirstName(),reservation.get(i).getLastName(),reservation.get(i).getEmail(),reservation.get(i).getPassword()
            };
        }
        return data;
    }
}
