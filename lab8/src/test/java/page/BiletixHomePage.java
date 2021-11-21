package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BiletixHomePage extends AbstractPage{

    private static final String PAGE_URL = "http://biletix.ru/";
    private static final String HEADER_XPATH = "//*[@id=\"__next\"]/div[2]/div[4]/div[1]/div";
    private static final String DEPARTURE_FORM_XPATH = "//*[@id=\"departure\"]";
    private static final String ARRIVAL_FORM_XPATH = "//*[@id=\"arrival\"]";
    private static final String FIND_BUTTON_XPATH = "//*[@id=\"app-wl-avia\"]/div/div/div[4]/div[2]/div[1]/div[6]";
    private static final String ERROR_MESSAGE_XPATH = "//*[@id=\"tickets-no-found\"]";


    @FindBy(xpath = DEPARTURE_FORM_XPATH)
    private WebElement departureForm;

    @FindBy(xpath = ARRIVAL_FORM_XPATH)
    private WebElement arrivalForm;

    @FindBy (xpath = FIND_BUTTON_XPATH)
    private WebElement findButton;


    public BiletixHomePage(WebDriver driver) {
        super(driver);
    }

    public BiletixHomePage openPage(){
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(HEADER_XPATH)));
        return this;
    }

    public BiletixHomePage fillDepartureForm(String departurePoint){
        departureForm.sendKeys(departurePoint);
        return this;
    }

    public BiletixHomePage fillArrivalForm(String arrivalPoint){
        arrivalForm.sendKeys(arrivalPoint);
        return this;
    }

    public BiletixHomePage pressFindButton(){
        findButton.click();

        return this;
    }

    public boolean getErrorMessageText(){

            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ERROR_MESSAGE_XPATH)));
            return driver.findElements(By.xpath(ERROR_MESSAGE_XPATH)).size() > 0;
    }
}
