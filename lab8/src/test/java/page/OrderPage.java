package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.nio.charset.StandardCharsets;

public class OrderPage extends AbstractPage{

    private static final String FIND_BUTTON_XPATH = "//input[@type=\"submit\"]";
    private static final String ERROR_MESSAGE_XPATH = "//div[@class=\"error\"]";

    @FindBy(xpath = FIND_BUTTON_XPATH)
    private WebElement findButton;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage pressFindButton(){
        findButton.click();
        return this;
    }

    public String getErrorMessage(){

        String message = "";
        WebElement errorMessage = Waits.getWebElementUntilWait(driver, ERROR_MESSAGE_XPATH);
        if(Waits.isElementAttributeNotEmpty(driver,"style",errorMessage))
        {
            message = errorMessage.getText();
        }
        return new String(message.getBytes(StandardCharsets.UTF_8));
    }


}
