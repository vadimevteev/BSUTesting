package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.BiletixHomePage;

public class WebDriverBiletixTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp(){
        driver = new ChromeDriver();

    }

    @Test(description = "later")
    public void goodTest() {
        String destinationPoint = "Minsk";
        String errorMessageExpected = "Упс! А билетов и нет";

        BiletixHomePage homePage = new BiletixHomePage(driver)
                .openPage()
                .fillArrivalForm(destinationPoint)
                .fillDepartureForm(destinationPoint)
                .pressFindButton();

        String errorMessageActual = homePage.getErrorMessageText();
        Assert.assertEquals(errorMessageExpected,errorMessageActual);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
    }

}
