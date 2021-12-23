package page;

import model.SearchForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.nio.charset.StandardCharsets;


public class BiletixHomePage extends AbstractPage{

    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "http://biletix.ru/";
    private static final String BODY_XPATH = "//*[@id=\"__next\"]";
    private static final String DEPARTURE_FORM_XPATH = "//*[@id=\"departure\"]";
    private static final String ARRIVAL_FORM_XPATH = "//*[@id=\"arrival\"]";
    private static final String FIND_BUTTON_XPATH = "//div[@class=\"btn-search triangle\"]";
    private static final String ERROR_MESSAGE_XPATH = "//*[@id=\"tickets-no-found\"]/h6";
    private static final String FIND_RESULT_XPATH = "//*[@class=\"wl-offer\"]";


    @FindBy(xpath = DEPARTURE_FORM_XPATH)
    private WebElement departureForm;

    @FindBy(xpath = ARRIVAL_FORM_XPATH)
    private WebElement arrivalForm;

    @FindBy (xpath = FIND_BUTTON_XPATH)
    private WebElement findButton;



    public BiletixHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BiletixHomePage openPage(){
        driver.get(PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public BiletixHomePage fillSearchForm(SearchForm searchForm){
        departureForm.sendKeys(searchForm.getDepartureFormText());
        arrivalForm.sendKeys(searchForm.getArrivalFormText());
        return this;
    }

    public BiletixHomePage pressFindButton(){
        findButton.click();
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
