import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.bcel.generic.Select;
import org.apache.bcel.generic.Visitor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LetscodeItTest {
    WebDriver driver;
    String baseurl;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseurl = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @Test
    public void mytest() throws InterruptedException {
        driver.get(baseurl);
        driver.findElement(By.id("bmwradio")).click();
        driver.findElement(By.id("benzradio")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"hondaradio\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("name")).sendKeys("savan bathani");
        Thread.sleep(2000);
        driver.findElement(By.id("alertbtn")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
