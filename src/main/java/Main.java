import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();



        //устанавливаем неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://avito.ru/rossiya");

        WebElement element = driver.findElement(By.xpath("(//a[text()='Личные вещи'])[1]"));

        String parameter = element.getAttribute("href");

        System.out.println('\n'  + parameter);

        WebElement element1 = driver.findElement(By.cssSelector(".category-with-counters-item-HDr9u"));

        String text = element1.getText();

        System.out.println(text);

        element1.click();

        WebElement element2 = driver.findElement(By.cssSelector(".page-title-count-wQ7pG"));

        String amount = element2.getText();

        System.out.printf("%d обьявление в категории %s\n", Integer.valueOf(amount.replaceAll(" ", "")),
        text);






    }
}
