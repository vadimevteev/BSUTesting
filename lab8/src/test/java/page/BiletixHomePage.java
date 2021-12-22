package page;

import model.SearchForm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class BiletixHomePage extends AbstractPage{

    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "http://biletix.ru/";
    private static final String BODY_XPATH = "//*[@id=\"__next\"]";
    private static final String DEPARTURE_FORM_XPATH = "//*[@id=\"departure\"]";
    private static final String ARRIVAL_FORM_XPATH = "//*[@id=\"arrival\"]";
    private static final String FIND_BUTTON_XPATH = "//div[@class=\"btn-search triangle\"]";
    private static final String ERROR_MESSAGE_XPATH = "//*[@id=\"tickets-no-found\"]/h6";


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
        arrivalForm.sendKeys(searchForm.getArrivalFormText());
        departureForm.sendKeys(searchForm.getDepartureFormText());
        return this;
    }

    public BiletixHomePage pressFindButton(){
        findButton.click();
        return this;
    }

    public String getErrorMessage(){

        return new String(new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(ERROR_MESSAGE_XPATH)))
                    .getText()
                    .getBytes(StandardCharsets.UTF_8));
    }
}
