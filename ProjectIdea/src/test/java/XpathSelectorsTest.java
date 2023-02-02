import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathSelectorsTest {

    @Test
    public void findElements() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        //clickOnMe
        By buttonId = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(buttonId);

        //fname
        By firstName = By.xpath("//input[@name='fname']");
        driver.findElement(firstName);

        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());

        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        driver.findElement(linkText);

        By partialLink = By.xpath("//a[contains(text(), 'Visit')]");
        driver.findElement(partialLink);

        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementWithAttribute = By.xpath("//*[@name]");
        driver.findElement(elementWithAttribute);

        By attrEq = By.xpath("//button[@id='clickOnMe']");
        By attrNotEq = By.xpath("//*[@id!='clickOnMe']");
        By attrCont = By.xpath("//*[contains(@name, 'ame')]");
        By startsWith = By.xpath("//*[starts-with(@name, 'user')]");
        //By endsWith = By.xpath("//*[ends-with(@name, 'name')]");

        driver.findElement(attrEq);
        driver.findElement(attrNotEq);
        driver.findElement(attrCont);
        driver.findElement(startsWith);
        //driver.findElement(endsWith);

        By child = By.xpath("//div/child::ul");
        By desc = By.xpath("//div/descendant::ul");
        By parent = By.xpath("//div/../..");
        By asc = By.xpath("//div/ancestor::*");
        By fall = By.xpath("//img//following::*");
        By fallSib = By.xpath("//img//following-sibling::*");
        By pre = By.xpath("//img/preceding::*");
        By preSib = By.xpath("//img/preceding-sibling::*");

        driver.findElement(child);
        driver.findElement(desc);
        driver.findElement(parent);
        driver.findElement(asc);
        driver.findElement(fall);
        driver.findElement(fallSib);
        driver.findElement(pre);
        driver.findElement(preSib);

        By divsAndLinks = By.xpath("//a | //div");
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");
        By orOp = By.xpath("//input[@name='fname' or @id='fname']");

        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOp);
//
//        By cssClass2 = By.cssSelector("[class='topSecret']");
//        driver.findElement(cssClass2);
//
//        By all = By.cssSelector("*");
//        driver.findElement(all);
//
//        By ulInDiv = By.cssSelector("div ul");
//        By trInTable = By.cssSelector("table tr");
//        By trInBody = By.cssSelector("tbody > tr");
//
//        By firstChildUlinDiv = By.cssSelector("div > ul");
//        By firstChildTrInTbody = By.cssSelector("tbody > tr");
//        driver.findElement(firstChildUlinDiv);
//        driver.findElement(firstChildTrInTbody);
//
//        By firstFromAfterLabel = By.cssSelector("label + form");
//        By allformAfterLabel = By.cssSelector("label ~ form");
//        driver.findElement(firstFromAfterLabel);
//        driver.findElement(allformAfterLabel);
//
//        By attrTag = By.cssSelector("input[name='fname']");
//        By attrContains = By.cssSelector("[name*='name']");
//        By attrStarts = By.cssSelector("[name^='f']");
//        By attrEnds = By.cssSelector("[name$='name']");
//
//        driver.findElement(attrTag);
//        driver.findElement(attrContains);
//        driver.findElement(attrStarts);
//        driver.findElement(attrEnds);
//
//        By firstChild = By.cssSelector("li:first-child");
//        By lastChild = By.cssSelector("li:last-child");
//        By thirdChild = By.cssSelector("li:nth-child(3)");
//
//        driver.findElement(firstChild);
//        driver.findElement(lastChild);
//        driver.findElement(thirdChild);

        driver.quit();

    }
}
