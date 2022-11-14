import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class NewTest {
    WebDriver driver;
    String baseurl;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseurl = "https://jqueryui.com/droppable/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void mytest() throws InterruptedException {
        driver.get(baseurl);
        driver.switchTo().frame(0);
        WebElement fromElement = driver.findElement(By.id("draggable"));
        Thread.sleep(1000);
        WebElement toElement = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        //.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
        action.dragAndDrop(fromElement,toElement).build().perform();
        Thread.sleep(1000);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
