package TestngBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataProviderExampleTest {
    WebDriver driver;
    @BeforeTest
    @Parameters({"browser","url"})
    public void beforeTest(@Optional String browser, @Optional String url){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @Test
    @Parameters({"username","password"})
    public void dataProviderTest(@Optional String username,@Optional String password){
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
