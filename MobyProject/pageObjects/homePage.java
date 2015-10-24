package pageObjects;

/**
 * Created by mmdul on 10/23/2015.
 * Home page registration objects mapped
 */

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

public class homePage {

    private static WebElement element = null;

    public static WebElement firstNameField(WebDriver driver){

        element = driver.findElement(By.name("data[FirstName]"));

        return element;
    }
    public static WebElement lastNameField(WebDriver driver){

        element = driver.findElement(By.name("data[LastName]"));

        return element;
    }
    public static WebElement teacherRadioButton(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"register-element-form\"]/div[3]/div[1]"));

        return element;
    }
    public static WebElement intTeacherRadioButton(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"register-element-form\"]/div[3]/div[2]"));

        return element;
    }
    public static WebElement homeschoolRadioButton(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"register-element-form\"]/div[4]/div[1]"));

        return element;
    }
    public static WebElement adminRadioButton(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"register-element-form\"]/div[4]/div[2]"));

        return element;
    }
    public static WebElement zipField(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"register-element-form\"]/div[8]/input"));

        return element;
    }
    public static WebElement schoolSelect(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"register-element-form\"]/div[9]/input[1]"));

        return element;
    }
    public static WebElement schoolSelectItem(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"111095\"]"));

        return element;
    }
    public static WebElement emailField(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"register-element-form\"]/div[13]/input"));

        return element;
    }
    public static WebElement passwordField(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"register-element-form\"]/div[14]/div/input"));

        return element;
    }
    public static WebElement submitButton(WebDriver driver){

        element = driver.findElement(By.xpath("//*[@id=\"register-button\"]"));

        return element;
    }

}
