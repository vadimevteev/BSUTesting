package test;

import model.Search;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.PersonalDataPage;
import service.SearchFormCreator;

public class HomePageTest extends CommonConditions{

    private static final String ERROR_FORM_WITHOUT_DATA = "Укажите город вылета";
    private static final String ERROR_TICKETS_NOT_FOUND = "Упс! А билетов и нет";

    @Test
    public void findTicketsWithoutData(){

        Search searchForm = SearchFormCreator.createFormWithoutData();
        String errorMessageActual = new HomePage(driver)
                .openPage()
                .fillSearchForm(searchForm)
                .pressFindButton()
                .getHintMessageForDeparture();

        Assert.assertEquals(ERROR_FORM_WITHOUT_DATA, errorMessageActual);
    }

    @Test
    public void findTicketsWithSameDepartureAndArrivalTest() {

        Search searchForm = SearchFormCreator.createFormWithSamePoints();
        String errorMessageActual = new HomePage(driver)
                .openPage()
                .fillSearchForm(searchForm)
                .pressFindButton()
                .getErrorMessage();
        Assert.assertEquals(ERROR_TICKETS_NOT_FOUND, errorMessageActual);

    }

    @Test
    public void findTicketsForSpecifiedCity() {

        Search searchForm = SearchFormCreator.createFormWithData();
        boolean isContainsResults = new HomePage(driver)
                .openPage()
                .fillSearchForm(searchForm)
                .selectTomorrowDate()
                .pressFindButton()
                .isPageContainsAtLeastOneFindResult();
        Assert.assertTrue(isContainsResults);
    }

    @Test
    public void findTicketsToDistantTown() {

        Search searchForm = SearchFormCreator.createFormWithDistantTown();
        String errorMessageActual = new HomePage(driver)
                .openPage()
                .fillSearchForm(searchForm)
                .pressFindButton()
                .getErrorMessage();
        Assert.assertEquals(ERROR_TICKETS_NOT_FOUND, errorMessageActual);

    }



}

