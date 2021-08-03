package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebdriverMultitone;

public class Button extends AbstractElement{

    public Button(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        if(element.isEnabled()){
            element.click();
            System.out.println("Button custom");
        }
        else{
            new WebDriverWait(WebdriverMultitone.getMultiDriver(),50).until(ExpectedConditions.elementToBeClickable(element));
        }
    }
}
