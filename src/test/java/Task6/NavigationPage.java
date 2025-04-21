package Task6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NavigationPage {
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
    void navigationTest() {
        driver.get ( BASE_URL );
        WebElement navigation = driver.findElement ( By.xpath ( "//a[contains(text(),'Navigation')]" ) );
        navigation.click ();
        WebElement navigationNumber = driver.findElement ( By.xpath ( "//a[contains(text(),'2')]" ) );
        navigationNumber.click ();
        WebElement textNavigation = driver.findElement ( By.xpath ( "//h1[contains(.,'Navigation example')]" ) );
        Assert.assertEquals ( "Navigation example" , textNavigation.getText () );
    }
}
