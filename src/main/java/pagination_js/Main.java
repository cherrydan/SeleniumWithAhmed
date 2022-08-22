package pagination_js;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        //опять про ожидание
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://pagination.js.org/");
            Thread.sleep(2000);

            List<WebElement> elements = driver.findElements(
                    By.xpath("//div[@class='data-container']/ul/li"));

            List<WebElement> pages = driver.findElements(
                    By.xpath("//div[@class='paginationjs-pages']/ul/li"));

            //забираем текст 6-го элемента на странице 1 (6)
            String text = elements.get(5).getText();
            System.out.println(text);
            //прокликиваем страницу 2
            pages.get(2).click();
            //ждём исчезновения старой информации
            wait.until(ExpectedConditions.stalenessOf(elements.get(5)));

            List<WebElement> elements2 = driver.findElements(
                    By.xpath("//div[@class='data-container']/ul/li"));
            //берём текст 6-го элемент на странице 2 (16)
            String text2 = elements2.get(5).getText();
            System.out.println(text2);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            driver.quit();
        }


    }
}