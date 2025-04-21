package Task6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.List;

public class WebForm {
    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

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
    public void checkInputTextTest() {
        driver.get ( BASE_URL );
        driver.findElement ( By.xpath ( "//a[contains(@href, 'web-form.html')]" ) ).click ();
        WebElement inputText = driver.findElement ( By.id ( "my-text-id" ) );
        inputText.sendKeys ( "Selenium" );
        Assert.assertEquals ( "Selenium" , inputText.getDomProperty ( "value" ) );
    }

    @Test
    public void checkPasswordTextTest() {
        driver.get ( BASE_URL );
        driver.findElement ( By.xpath ( "//a[contains(@href, 'web-form.html')]" ) ).click ();
        WebElement inputText = driver.findElement ( By.name ( "my-password" ) );
        inputText.sendKeys ( "12345" );
        Assert.assertEquals ( "12345" , inputText.getDomProperty ( "value" ) );
    }

    @Test
    public void checkAreaTest() {
        driver.get ( BASE_URL );
        driver.findElement ( By.xpath ( "//a[contains(@href, 'web-form.html')]" ) ).click ();
        WebElement inputText = driver.findElement ( By.name ( "my-textarea" ) );
        inputText.sendKeys ( "comment" );
        Assert.assertEquals ( "comment" , inputText.getDomProperty ( "value" ) );
    }

    @Test
    void selectFromListTest() throws InterruptedException {
        driver.get ( BASE_URL );
        driver.findElement ( By.xpath ( "//a[contains(@href, 'web-form.html')]" ) ).click ();

        WebElement dropdownList = driver.findElement ( By.name ( "my-select" ) );
        Select select = new Select ( dropdownList );
        Thread.sleep ( 2000 );

        select.selectByIndex ( 1 );
        Thread.sleep ( 2000 );
        select.selectByIndex ( 0 );
        Thread.sleep ( 2000 );
        select.selectByIndex ( 2 );
        Thread.sleep ( 3000 );
        select.selectByIndex ( 3 );
        Thread.sleep ( 2000 );

        select.selectByValue ( "2" );
        Thread.sleep ( 3000 );
        select.selectByValue ( "1" );
        Thread.sleep ( 2000 );
        select.selectByValue ( "3" );
        Thread.sleep ( 2000 );

        select.selectByVisibleText ( "One" );
        Thread.sleep ( 2000 );
        select.selectByVisibleText ( "Two" );
        Thread.sleep ( 2000 );
        select.selectByVisibleText ( "Three" );

        Assert.assertEquals ( "Three" , select.getFirstSelectedOption ().getText () );
        Assert.assertTrue ( select.getFirstSelectedOption ().isSelected () );
    }

    @Test
    public void checkDropDownListTest() {
        driver.get ( BASE_URL );
        driver.findElement ( By.xpath ( "//a[contains(@href, 'web-form.html')]" ) ).click ();

        WebElement dropdownList = driver.findElement ( By.name ( "my-select" ) );
        Select select = new Select ( dropdownList );

        List<WebElement> selectedOptions = select.getAllSelectedOptions ();
        for (WebElement selectedOption : selectedOptions) {
            Assert.assertEquals ( "Open this select menu" , selectedOption.getText () );
        }
    }

    @Test
    void disabledInputTests() {
        driver.get ( BASE_URL );
        WebElement webFormButton = driver.findElement ( By.xpath ( "//a[contains(@href, 'web-form.html')]" ) );
        Assert.assertTrue ( webFormButton.isDisplayed () );
        webFormButton.click ();

        WebElement disabledInput = driver.findElement ( By.name ( "my-disabled" ) );
        Assert.assertFalse ( disabledInput.isEnabled () );
        Assert.assertThrows ( ElementNotInteractableException.class , () -> disabledInput.sendKeys ( "test" ) );
        Assert.assertEquals ( "input" , disabledInput.getTagName () );

        Assert.assertEquals ( "Disabled input" , disabledInput.findElement ( By.xpath ( ".." ) ).getText () );
        Assert.assertEquals ( "Disabled input" , disabledInput.getDomProperty ( "placeholder" ) );
    }

    @Test
    void uploadFailTest() {
        URL url = WebForm.class.getClassLoader ().getResource ( "text.txt" );

        String absolutePath = null;
        if (url != null) {
            absolutePath = new File ( url.getPath () ).getAbsolutePath ();
        }
        driver.get ( "https://bonigarcia.dev/selenium-webdriver-java/web-form.html" );
        WebElement fileUpload = driver.findElement ( By.name ( "my-file" ) );
        fileUpload.sendKeys ( absolutePath );
        WebElement submit = driver.findElement ( By.xpath ( "//button[text()='Submit']" ) );
        submit.click ();

        Assert.assertTrue ( driver.getCurrentUrl ().contains ( "text.txt" ) , "URL не содержит text.txt" );
    }

    @Test
    void checkboxAndRadioButtonTest(){
        driver.get ( "https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement checkboxDefault = driver.findElement ( By.id ( "my-check-2" ) );
        checkboxDefault.click ();

        WebElement radioButton2 = driver.findElement ( By.id ( "my-radio-2" ) );
        radioButton2.click ();

        WebElement radioButton1 = driver.findElement ( By.id ( "my-radio-1" ) );
        radioButton1.click ();
        Assert.assertTrue ( checkboxDefault.isDisplayed () );
        Assert.assertTrue ( radioButton2.isDisplayed () );
    }
}
