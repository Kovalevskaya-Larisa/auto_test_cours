package Task5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Locators {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver ().setup ();
        driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();
        driver.manage ().deleteAllCookies ();
    }

    @AfterSuite
    public void teardown() {
        driver.quit ();
    }

    @Test
    public void testFillInWebForm() throws InterruptedException {

        driver.get ( "https://bonigarcia.dev/selenium-webdriver-java/" );
        WebElement buttonWebForm = driver.findElement ( By.xpath ( "//a[contains(@href, 'web-form.html')]" ) );
        buttonWebForm.click ();

        WebElement textInput = driver.findElement ( By.id ( "my-text-id" ) );
        textInput.sendKeys ( "Selenium" );

        WebElement inputPassword = driver.findElement ( By.xpath ( "//input[@name='my-password']" ) );
        inputPassword.sendKeys ( "555" );

        WebElement textArea = driver.findElement ( By.xpath ( "//textarea[@name='my-textarea']" ) );
        textArea.sendKeys ( "comment" );

        WebElement select = driver.findElement ( By.name ( "my-select" ) );
        select.click ();

        WebElement option1 = driver.findElement ( By.cssSelector ( "option[value='1']" ) );
        option1.click ();

        WebElement datalist = driver.findElement ( By.name ( "my-datalist" ) );
        datalist.click ();

        WebElement city = driver.findElement ( By.cssSelector ( ".col-md-4:nth-child(2) > .form-label:nth-child(2) > .form-control" ) );
        city.click ();

        WebElement checkboxChecked = driver.findElement ( By.id ( "my-check-1" ) );
        checkboxChecked.click ();

        WebElement checkboxDefault = driver.findElement ( By.id ( "my-check-2" ) );
        checkboxDefault.click ();

        WebElement radioButton2 = driver.findElement ( By.id ( "my-radio-2" ) );
        radioButton2.click ();

        WebElement radioButton1 = driver.findElement ( By.id ( "my-radio-1" ) );
        radioButton1.click ();

        WebElement dataInput = driver.findElement ( By.xpath ( "//input[@name='my-date']" ) );
        dataInput.click ();

        WebElement choiceData = driver.findElement ( By.cssSelector ( "tr:nth-child(2) > .day:nth-child(4)" ) );
        choiceData.click ();

        WebElement slider = driver.findElement ( By.xpath ( "//input[@name='my-range']" ) );
        slider.click ();

        WebElement submitButton = driver.findElement ( By.tagName ( "button" ) );
        submitButton.click ();

        Thread.sleep ( 1000 );

        WebElement message = driver.findElement ( By.cssSelector ( ".lead" ) );
        String title = message.getText ();
        Assert.assertEquals ( title , "Received!" );
    }
}
