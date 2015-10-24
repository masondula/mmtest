/**
 * Created by mmdul on 10/23/2015.
 * Testing registration happy path of MobyMax.com
 */


import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.lang.String;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

//Page objects import
import pageObjects.homePage;

public class registration {
    private static WebDriver driver = null;

    public static void main(String[] args) {

        driver = new FirefoxDriver();

        //Navigate to MobyMax.com
        driver.get("http://www.mobymax.com");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Timestamp for unique user and test traceability
        Date date = new Date();
        long time = date.getTime();

        //Test registration happy path
        //Enter first/last name
        homePage.firstNameField(driver).sendKeys("ima" + time);
        homePage.lastNameField(driver).sendKeys("teacher" + time);

        //Clear check boxes to ensure default is cleared and only the desired box is checked
        boolean checked = false;

        //Check teacher checkbox if not checked
        selectRadioButton(homePage.teacherRadioButton(driver));

        /*I'd like to be able to read from datasheet for testing
         *this in order to check several combinations... etc...
         *but I assume just a single zip/school entry will suffice
         *for this test
         */
        //Enter zip
        homePage.zipField(driver).sendKeys("30096");
        //Click school item
        homePage.schoolSelect(driver).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.id("111095")));
        homePage.schoolSelectItem(driver).click();

        //Enter Email
        homePage.emailField(driver).sendKeys("email" + time + "@testfake.com");
        //Enter Password
        homePage.passwordField(driver).sendKeys("pass" + time);

        //Submit registration
        homePage.submitButton(driver).click();

        //Verify completed registration takes to you welcome page/dashboard
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        WebElement element2 = wait2.until(ExpectedConditions.presenceOfElementLocated(By.className("standard-dialog-blue-title")));

        if(driver.getCurrentUrl().contains("http://www.mobymax.com/MM/MT/Welcome?")) {
            System.out.println("REGISTRATION SUCCESS!");
        }
        else {
            System.out.println("Registration Failure :(... (or url has changed)");
        }


        //driver.quit();
    }

    public static void selectRadioButton(WebElement rb){
        boolean checked = false;
        checked = rb.isSelected();


        if(checked == false) {
            rb.click();
        }
    }

}
