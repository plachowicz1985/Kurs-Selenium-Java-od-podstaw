//napisz metodę, która przyjmie String jako parametr i zwraca typ boolean
//metoda sprawdza czy parametr String jest jedną z opcji w Select

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectCheck {

    //metoda checkOption
    public boolean checkOption (String optionText, WebElement element) {

        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for(WebElement option : options) {
            if(option.getText().equals(optionText))

                return true;
        }
        return false;
    }

}
