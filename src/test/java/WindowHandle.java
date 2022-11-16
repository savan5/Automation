import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {
    WebDriver driver;
    String baseUrl = "https://courses.letskodeit.com/practice";
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void mytest() throws InterruptedException {

        String parentwindow =  driver.getWindowHandle();
        System.out.println(parentwindow);
        driver.findElement(By.id("openwindow")).click();
       Set<String>handles = driver.getWindowHandles();
        for (String handle:handles) {
            if (!handle.equals(parentwindow)){
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id=\"navbar-inverse-collapse\"]/div/div/a")).click();
                Thread.sleep(2000);
                driver.close();
                break;
            }
        }
        Thread.sleep(3000);//wait 3 second
        driver.switchTo().window(parentwindow);
        Thread.sleep(3000);
        driver.findElement(By.id("name")).sendKeys("Jay Shree Ram");
        Thread.sleep(3000);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}