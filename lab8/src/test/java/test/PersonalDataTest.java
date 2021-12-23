package test;

import model.Search;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.SearchFormCreator;

public class PersonalDataTest extends CommonConditions{

    private static final String ERROR_INPUT_NAME = "Введите имя";

    @Test
    public void registrationWithoutDataTest()  {

        Search searchForm = SearchFormCreator.createFormWithData();
        HomePage homePage = new HomePage(driver);
        String actualError = homePage
                .openPage()
                .fillSearchForm(searchForm)
                .selectTomorrowDate()
                .pressFindButton()
                .selectResult()
                .pressPayButton()
                .getErrorMessage();

        Assert.assertEquals(ERROR_INPUT_NAME, actualError);
    }
}
