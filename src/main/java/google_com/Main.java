package google_com;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://google.com/");

        WebElement element = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));

        element.sendKeys("Курсы по Java", Keys.ENTER);

        Actions action = new Actions(driver);




    }
}