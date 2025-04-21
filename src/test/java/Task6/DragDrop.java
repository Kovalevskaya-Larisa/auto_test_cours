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

public class DragDrop {
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
    void checkDragAndDropTheTest() throws InterruptedException {
        driver.get ( "https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html" );
        Thread.sleep ( 2000 );

        WebElement draggable = driver.findElement ( By.id ( "draggable" ) );
        WebElement droppable = driver.findElement ( By.id ( "target" ) );
        new Actions ( driver )
                .dragAndDrop ( draggable , droppable )
                .perform ();
        Thread.sleep ( 2000 );
    }
}
