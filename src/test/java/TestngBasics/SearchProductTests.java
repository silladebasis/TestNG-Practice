package TestngBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchProductTests {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Before Test execution begins ......");
    }
    @Test(groups = {"Title"})
    public void getSearchProductTitleTest(){
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Title of page is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Search - My Shop");
    }
    @AfterTest
    public void tearDown(){
        System.out.println("After test is executing .....");
        driver.quit();
    }
}
