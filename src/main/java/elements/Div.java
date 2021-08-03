package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebdriverMultitone;

public class Div extends AbstractElement{
    public Div(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        if(!element.isDisplayed()){
            new WebDriverWait(WebdriverMultitone.getMultiDriver(),50).until(ExpectedConditions.visibilityOf(element));
        }
        element.click();
    }
}
