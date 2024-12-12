package TestngBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//ITestListener interface which implements Testng listeners
//@Listeners(listeners.Listeners.class)
public class ListenersExampleTest {
    WebDriver driver;
    @Test
    public void listenersDemo(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys("testautomation1@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("test@12345");
        driver.findElement(By.cssSelector("#SubmitLogin")).click();
        driver.quit();
    }
}
