package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BiletixHomePage extends AbstractPage{

    private static final String PAGE_URL = "http://biletix.ru/";
    private static final String BODY_XPATH = "//*[@id=\"__next\"]";
    private static final String DEPARTURE_FORM_XPATH = "//*[@id=\"departure\"]";
    private static final String ARRIVAL_FORM_XPATH = "//*[@id=\"arrival\"]";
    private static final String FIND_BUTTON_XPATH = "//div[@class=\"btn-search triangle\" and starts-with(text(),\"Найти\")]";
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
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BODY_XPATH)));
        return this;
    }

    public BiletixHomePage fillDepartureForm(String departurePoint){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(DEPARTURE_FORM_XPATH)));
        departureForm.sendKeys(departurePoint);
        return this;
    }

    public BiletixHomePage fillArrivalForm(String arrivalPoint){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ARRIVAL_FORM_XPATH)));
        arrivalForm.sendKeys(arrivalPoint);
        return this;
    }

    public BiletixHomePage pressFindButton(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(FIND_BUTTON_XPATH)));
        findButton.click();

        return this;
    }

    public boolean getErrorMessageText(){

            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ERROR_MESSAGE_XPATH)));
            return driver.findElements(By.xpath(ERROR_MESSAGE_XPATH)).size() > 0;
    }
}
