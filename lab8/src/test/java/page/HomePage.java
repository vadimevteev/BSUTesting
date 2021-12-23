package page;

import model.Travel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.nio.charset.StandardCharsets;


public class HomePage extends AbstractPage{

    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "http://biletix.ru/";
    private static final String RESULT_PAGE_URL = "https://biletix.ru/personal-data/";
    private static final String DEPARTURE_FORM_XPATH = "//*[@id=\"departure\"]";
    private static final String ARRIVAL_FORM_XPATH = "//*[@id=\"arrival\"]";
    private static final String FIND_BUTTON_XPATH = "//div[@class=\"btn-search triangle\"]";
    private static final String ERROR_MESSAGE_XPATH = "//*[@id=\"tickets-no-found\"]/h6";
    private static final String FIND_RESULT_XPATH = "//*[@class=\"wl-offer\"]";
    private static final String DATE_INPUT_XPATH = "//*[@id=\"date-departure-input\"]";
    private static final String RESULT_PAGE_BUTTON = " //button[contains(@class,'biletix-button')]";
    private static final String DATE_INPUT_DAY_XPATH = "//div[contains(@class,'react-datepicker__day')]/div/span";


    @FindBy(xpath = DEPARTURE_FORM_XPATH)
    private WebElement departureForm;

    @FindBy(xpath = ARRIVAL_FORM_XPATH)
    private WebElement arrivalForm;

    @FindBy (xpath = FIND_BUTTON_XPATH)
    private WebElement findButton;



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage(){
        driver.get(PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public HomePage fillSearchForm(Travel travelForm){
        departureForm.sendKeys(travelForm.getDepartureFormText());
        arrivalForm.sendKeys(travelForm.getArrivalFormText());
        return this;
    }

    public HomePage pressFindButton(){
        findButton.click();
        return this;
    }

    public PersonalDataPage selectResult() {
        Waits.getWebElementUntilWait(driver, RESULT_PAGE_BUTTON).click();
        Waits.isPageUrlToBe(driver, RESULT_PAGE_URL);
        logger.info("Redirected to page Personal DataPage");
        return new PersonalDataPage(driver);
    }

    public HomePage selectTomorrowDate(){
        Waits.getWebElementUntilWait(driver,DATE_INPUT_XPATH).click();
        Waits.getWebElementUntilWait(driver, "//*[@id=\"date-departure\"]/div[2]/div/div[2]/div[2]/div[4]/div[5]/div").click();
        return this;
    }

    public String getHintMessageForDeparture(){
        String message = "";

        if(Waits.isElementAttributeNotEmpty(driver,"value",departureForm))
            message = departureForm.getAttribute("value");

        return new String(message.getBytes(StandardCharsets.UTF_8));
    }

    public boolean isPageContainsAtLeastOneFindResult() {
        Waits.getWebElementUntilWait(driver, FIND_RESULT_XPATH);
        return driver.findElements(By.xpath(FIND_RESULT_XPATH)).size() > 0;
    }

    public String getErrorMessage(){
        return new String(Waits.getWebElementUntilWait(driver,ERROR_MESSAGE_XPATH)
                .getText()
                .getBytes(StandardCharsets.UTF_8));
    }

}
