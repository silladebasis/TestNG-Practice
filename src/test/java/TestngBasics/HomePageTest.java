package TestngBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;
    @BeforeSuite
    @Parameters({"browserName"})
    public void beforeSuite(@Optional String browserName){
        System.out.println("Browser name is : " + browserName);
    }
    @Test(enabled = true,groups = {"Title"})
    public void getTitleTest(){
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        System.out.println("Home page title is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"My Shop");
        driver.quit();
    }
    @Test(groups = {"Title"})
    public void getSearchProductTitleTest(){
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.id("search_query_top")).sendKeys("T-Shirts");
        driver.findElement(By.name("submit_search")).click();
        System.out.println("Title of page is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Search - My Shop");
        driver.quit();
    }
    @Test
    public void loginToAppTest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys("testautomation1@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("test@12345");
        driver.findElement(By.cssSelector("#SubmitLogin")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"My account - My Shop");
        driver.quit();
    }

    @Test
    @Parameters({"email","password"})
    public void loginToAppTestUsingParameters(@Optional String email, @Optional String password){
        System.out.println("Email and Password fetched from xml : " + email + " : " + password);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys("test@12345");
        driver.findElement(By.cssSelector("#SubmitLogin")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"My account - My Shop");
        driver.quit();
    }
}
