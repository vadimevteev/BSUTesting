package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.nio.charset.StandardCharsets;

public class PersonalDataPage extends AbstractPage{

    private static final String PAY_BUTTON_XPATH = "//*[@id=\"btnGoToPayment\"]";
    private static final String ERROR_NAME_XPATH = "//div[@class=\"passenger__error\"]";

    @FindBy(xpath = PAY_BUTTON_XPATH)
    private WebElement payButton;
    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public PersonalDataPage(WebDriver driver){super(driver);}

    public PersonalDataPage pressPayButton() {
        js.executeScript("arguments[0].click();",payButton);
        return this;
    }

    public String getErrorMessage(){
        return new String(Waits.getWebElementUntilWait(driver,ERROR_NAME_XPATH)
                .getText()
                .getBytes(StandardCharsets.UTF_8));
    }


}
