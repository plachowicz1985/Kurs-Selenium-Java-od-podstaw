import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    @Test
    public void performAction() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        basicPageLink.click();

        //driver.findElement(By.id("clickOnMe")).click();
        driver.findElement(By.id("fname")).sendKeys("Piotrek");

        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("admin");

        //pobranie wartości z pola tekstowego
        System.out.println(userNameInput.getAttribute("value"));
        userNameInput.sendKeys(Keys.ENTER);
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        driver.switchTo().alert().accept();
        //userNameInput.sendKeys(Keys.TAB);

        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
//        cars.selectByIndex(2);
//        cars.selectByVisibleText("Saab");
        cars.selectByValue("volvo");

        //wszystkie weelementy
        List <WebElement> options =  cars.getOptions();

        for (WebElement option: options) {
            System.out.println(option.getText());
        }

        //sprawdzenie SelectCheck
        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.checkOption("Audi", selectCar));
        System.out.println(selectCheck.checkOption("Jeep", selectCar));


        WebElement para = driver.findElement(By.xpath("//p[@class='topSecret']"));
        System.out.println("by text: "+para.getText());
        System.out.println("by attr value: "+para.getAttribute("value"));
        System.out.println("by attr text content: "+para.getAttribute("textContent"));


        //driver.quit();
    }
}
