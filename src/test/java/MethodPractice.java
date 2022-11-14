import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodPractice {
    String baseurl;
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseurl = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.get(baseurl);
    }
    @Test
    public void mymethod() throws InterruptedException {
        driver.findElement(By.id("benzcheck")).click();
        Thread.sleep(2000);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
