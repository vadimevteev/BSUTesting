package test;

import model.SearchForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BiletixHomePage;
import service.SearchFormCreator;

public class WebDriverBiletixTest extends CommonConditions{



    @Test
    public void findTicketsWithoutData(){
        String errorMessageExpected = "Укажите город вылета";

        SearchForm searchForm = SearchFormCreator.createFormWithoutData();
        String errorMessageActual = new BiletixHomePage(driver)
                .openPage()
                .fillSearchForm(searchForm)
                .pressFindButton()
                .getHintMessageForDeparture();

        Assert.assertEquals(errorMessageExpected, errorMessageActual);
    }

    @Test
    public void findTicketsWithSameDepartureAndArrivalTest() {

        String errorMessageExpected = "Упс! А билетов и нет";

        SearchForm searchForm = SearchFormCreator.createFormWithSamePoints();
        String errorMessageActual = new BiletixHomePage(driver)
                .openPage()
                .fillSearchForm(searchForm)
                .pressFindButton()
                .getErrorMessage();
        Assert.assertEquals(errorMessageExpected, errorMessageActual);

    }

    @Test
    public void findTicketsForSpecifiedCity() {

        SearchForm searchForm = SearchFormCreator.createFormWithData();
        boolean isContainsResults = new BiletixHomePage(driver)
                .openPage()
                .fillSearchForm(searchForm)
                .pressFindButton()
                .isPageContainsAtLeastOneFindResult();
        Assert.assertTrue(isContainsResults);
    }

    @Test
    public void findTicketsToDistantTown() {
        String errorMessageExpected = "Упс! А билетов и нет";

        SearchForm searchForm = SearchFormCreator.createFormWithDistantTown();
        String errorMessageActual = new BiletixHomePage(driver)
                .openPage()
                .fillSearchForm(searchForm)
                .pressFindButton()
                .getErrorMessage();
        Assert.assertEquals(errorMessageExpected, errorMessageActual);

    }

//    @Test
//    public void ticketsBuyRegistrationWithoutData(){
//
//    }


}
