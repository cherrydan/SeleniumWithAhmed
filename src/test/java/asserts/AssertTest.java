package asserts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssertTest {

    @Test

    public static void assertTest() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();


        //устанавливаем неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get("https://avito.ru/rossiya");

        WebElement element1 = driver.findElement(By.cssSelector(".category-with-counters-item-HDr9u"));

        String text = element1.getText();

        Assert.assertEquals(text, "Личные вещи "); //именно с пробелом


        driver.quit();
    }
}
