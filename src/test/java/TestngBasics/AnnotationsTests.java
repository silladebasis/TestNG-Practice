package TestngBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTests {
    WebDriver driver;
    @BeforeSuite
    @Parameters({"browserName"})
    public void beforeSuite(@Optional String browserName){
        System.out.println("First thing to execute in entire suite");
        System.out.println("Browser name is : " + browserName);
    }
    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Before Test execution begins ......");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class is executing .....");
    }
    @BeforeMethod
    public void navigateToApp(){
        System.out.println("Executes everytime before @Test Annotation");
        driver.get("http://www.automationpractice.pl/index.php");
    }
    @Test
    public void searchProduct() throws InterruptedException {
        driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts");
        driver.findElement(By.name("submit_search")).click();
        Thread.sleep(2500);
        String productText = driver.findElement(By.cssSelector(".product-container .product-name")).getText();
        System.out.println("Prints the product text : " + productText);
    }
    @Test(groups = {"Title"})
    public void getSearchProductTitleTest(){
        driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Title of page is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Search - My Shop");
    }
    @AfterMethod
    public void closeTest(){
        System.out.println("Executes after every @Test annotation completion");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class is executing ....");
    }
    @AfterTest
    public void tearDown(){
        System.out.println("After test is executing .....");
        driver.quit();
    }
}
