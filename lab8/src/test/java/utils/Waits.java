package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    protected final static long WAIT_TIMEOUT_SECONDS = 10;


    public static WebElement getWebElementUntilWait(WebDriver driver, String elementPath){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                        .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(elementPath)));
    }

    public static boolean isElementAttributeNotEmpty(WebDriver driver, String attribute, WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                .attributeToBeNotEmpty(element,attribute));
    }

}
