package crossbrowsertesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();



        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);
            WebElement element1 = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));
            Actions actions = new Actions(driver);
            //не забывать вызывать метод perform()

            actions.dragAndDrop(element1, element2).pause(1000).perform();
            // Использование метода pause()
            actions.dragAndDropBy(element1, 300, 300).pause(1000).perform();



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            Thread.sleep(10000);
            driver.quit();
        }


    }
}
