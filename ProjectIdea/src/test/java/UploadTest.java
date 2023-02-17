import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class UploadTest {

    @Test
    public void UploadFile() throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        //int randomNumber = (int) (Math.random()*1000);

        //data do nawy pliku
        Date d = new Date();
        String randomNumber = d.toString().replace(":", "_").replace(" ", "_") + ".png";

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File before = screenshot.getScreenshotAs(OutputType.FILE);

        String fileName = "screenshot" + randomNumber;
        //kopiujemy naszego screenshota do nowego pliku do znanej nam sciezki
        FileUtils.copyFile(before, new File("src/test/resources/"+fileName));

        driver.findElement(By.id("myFile")).sendKeys("/Users/piotrek/Downloads/CV_Piotr_Lachowicz.pdf");


        driver.quit();
    }
}
