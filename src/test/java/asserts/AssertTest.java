package asserts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssertTest {

    private static ChromeDriver driver;
    private static final String url = "https://avito.ru/rossiya";

    @BeforeTest
    public static void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //устанавливаем неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.get(url);
    }

    @Test

    public static void assertTest() {


        WebElement element1 = driver.findElement(By.cssSelector(".category-with-counters-item-HDr9u"));

        String text = element1.getText().trim(); //удаляем пробел в конце

        Assert.assertEquals(text, "Личные вещи");

    }

    @AfterTest
    public static void finish() {
        driver.quit();
    }
}
