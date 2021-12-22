package test;

import model.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BiletixHomePage;
import service.SearchFormCreator;

public class WebDriverBiletixTest extends CommonConditions{

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

//    @Test
//    public void findTicketsWithoutData(){
//        String errorMessageExpected = "Укажите город вылета";
//
//        SearchForm searchForm = SearchFormCreator.createFormWithData();
//
//        String errorMessageActual = new BiletixHomePage(driver)
//                .openPage()
//                .fillSearchForm(searchForm)
//                .pressFindButton()
//
//    }

}
