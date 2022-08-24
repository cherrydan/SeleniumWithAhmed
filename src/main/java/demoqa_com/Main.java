package demoqa_com;
//смог ПОКА прожать только 6 элементов(
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
            Thread.sleep(1000);
            WebElement element2 = driver.findElement(By.id("lastName"));
            element2.sendKeys("CHEREPUKHIN", Keys.TAB);
            Thread.sleep(1000);
            WebElement element3 = driver.findElement(By.id("userEmail"));
            element3.sendKeys("cherrydan.1999@gmail.com");
            WebElement element4 = driver.findElement(By.xpath("//label[text()='Male']"));
            element4.click();
            Thread.sleep(1000);
            WebElement element5 = driver.findElement(By.id("userNumber"));
            element5.sendKeys("+79999999");
            Thread.sleep(1000);

            Thread.sleep(5000);

        } catch (Exception e) {
           e.printStackTrace();
        }
        finally {
            driver.quit();
        }

    }
}
