import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest {

    @Test
    public void actionsTest() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        //actions.contextClick(driver.findElement(By.id("myFile"))).perform();
        WebElement button = driver.findElement(By.id("bottom"));
        actions.doubleClick(button).perform();

        //driver.quit();
    }
}
