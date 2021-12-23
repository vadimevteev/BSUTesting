package test;

import model.Passenger;
import model.Travel;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.PassengerCreator;
import service.TravelCreator;

public class PersonalDataTest extends CommonConditions{

    private static final String ERROR_INPUT_NAME = "Введите имя";
    private static final String ERROR_INPUT_DATA = "Некорректные данные пассажира.";

    @Test
    public void registrationWithoutDataTest()  {

        Travel travelForm = TravelCreator.createFormWithData();
        HomePage homePage = new HomePage(driver);
        String actualError = homePage
                .openPage()
                .fillSearchForm(travelForm)
                .pressFindButton()
                .selectResult()
                .pressPayButton()
                .getErrorNameMessage();

        Assert.assertEquals(ERROR_INPUT_NAME, actualError);
    }

    @Test
    public void registrationWithIncorrectDataTest() {
        Travel travel = TravelCreator.createFormWithData();
        Passenger passenger = PassengerCreator.createPassengerWithData();
        HomePage homePage = new HomePage(driver);
        String actualError = homePage
                .openPage()
                .fillSearchForm(travel)
                .pressFindButton()
                .selectResult()
                .fillPassengerForm(passenger)
                .pressPayButton()
                .getErrorDataMessage();

        Assert.assertEquals(actualError, ERROR_INPUT_DATA);
    }
}
