package demoqa_com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    private static final String url = "https://demoqa.com/automation-practice-form";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();


        try {
            driver.get(url);
            WebElement element = driver.findElement(By.id("firstName"));
            element.sendKeys("DANIL", Keys.TAB);
            Thread.sleep(3000);
            WebElement element2 = driver.findElement(By.xpath("//label[text()='Male']"));
            element2.click();
            Thread.sleep(2000);



        } catch (Exception e) {
           e.printStackTrace();
        }
        finally {
            driver.quit();
        }

    }
}
