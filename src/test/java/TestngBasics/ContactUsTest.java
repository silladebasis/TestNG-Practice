package TestngBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest {
    WebDriver driver;
    @Test(groups = {"Title"})
    public void getContactTitleTest(){
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Contact us")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Contact us - My Shop");
        driver.quit();
    }

    @Test(dependsOnMethods = "getContactTitleTest")
    public void sendMessageTest() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Contact us")).click();
        Select select = new Select(driver.findElement(By.id("id_contact")));
        select.selectByVisibleText("Customer service");
        driver.findElement(By.id("email")).sendKeys("testautomation1@gmail.com");
        driver.findElement(By.id("message")).sendKeys("Test Automation");
        driver.findElement(By.id("submitMessage")).click();
        Thread.sleep(2000);
        String successMessage = driver.findElement(By.className("alert-success")).getText();
        System.out.println("Success Message is : " + successMessage);
        Assert.assertEquals(successMessage,"Your message has been successfully sent to our team.");
        driver.quit();
    }
}
