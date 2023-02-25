package testy;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

@Listeners(value = SampleTestListener.class)
public class NewFirstTest extends BaseTest {

    WebDriver driver;

    @Test
    public void firstTest() {

        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementExist(By.cssSelector("p"));

        WebElement para = driver.findElement(By.cssSelector("p"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(para.isDisplayed(), true);
        softAssert.assertTrue(para.isDisplayed(), "Element is not desplayed");
        softAssert.assertEquals(para.getText(), "Dopiero","Teksty są różne");
        softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        softAssert.assertFalse(para.getText().startsWith("Pojawiłem"));
        softAssert.assertEquals(para.getText(), "Dopiero się", "Druga asercja");

        driver.quit();

        softAssert.assertAll();
    }

    @Test @Ignore
    public void secondTest() {

        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementExist(By.cssSelector("p"));

        String paraText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");
        driver.quit();
    }

    public void waitForElementExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until((driver) ->{
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Elemntu nie ma na stronie");
                return false;
            }
        });

    }

}
