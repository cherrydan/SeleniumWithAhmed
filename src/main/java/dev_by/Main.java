package dev_by;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://devby.io/");

        //устанавливаем неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement element = driver.findElement(By.xpath("(//a[text()='Вход'])"));

        String par = element.getCssValue("color");

        System.out.printf("Цвет элемента %s\n", par);

        String par2 = element.getCssValue("transition");

        System.out.printf("Составной элемент выдаётся Chromedriver в нормальном виде: %s\n", par2);

    }
}