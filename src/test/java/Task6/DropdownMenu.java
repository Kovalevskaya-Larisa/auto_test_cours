package Task6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DropdownMenu {
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
    void mouseClickTests() throws InterruptedException {
        driver.get ( "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html" );
        Thread.sleep ( 2000 );

        WebElement leftClick = driver.findElement ( By.id ( "my-dropdown-1" ) );
        new Actions ( driver )
                .click ( leftClick )
                .perform ();
        Thread.sleep ( 2000 );

        WebElement rightClick = driver.findElement ( By.id ( "my-dropdown-2" ) );
        new Actions ( driver )
                .contextClick ( rightClick )
                .perform ();
        Thread.sleep ( 2000 );

        WebElement doubleClick = driver.findElement ( By.id ( "my-dropdown-3" ) );
        new Actions ( driver )
                .doubleClick ( doubleClick )
                .perform ();
        Thread.sleep ( 2000 );
    }
}
