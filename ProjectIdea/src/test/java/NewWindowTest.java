import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {

    @Test
    public void testNewWindow() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        Set<String> windowsName = driver.getWindowHandles();
        for(String window : windowsName) {
            if(!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//button/div[contains(text(), 'Zaakceptuj wszystko')]")).click();
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Selenium");

        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Piotrek");

    }
}
