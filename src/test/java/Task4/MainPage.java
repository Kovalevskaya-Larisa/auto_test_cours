package Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class MainPage {
    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeTest
    void setup() {
        driver = new ChromeDriver ();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterTest
    void tearDown() {
        driver.getPageSource();
        driver.quit();
    }

    @Test
    void openHomePageTest() {
        String actualTitle = driver.getTitle ();

        assertEquals ( "Hands-On Selenium WebDriver with Java" , actualTitle );
    }

    @Test
    void openWebFormTest1() {
        String webFormUrl = "web-form.html";
//      driver.findElement(By.linkText("Web form")).click();
        driver.findElement ( By.xpath ( "//h5[text() = 'Chapter 3. WebDriver Fundamentals']/../a[contains(@href, 'web-form')]" ) ).click ();
        String currentUrl = driver.getCurrentUrl ();
        WebElement title = driver.findElement ( By.className ( "display-6" ) );

        assertEquals ( BASE_URL + webFormUrl , currentUrl );
        assertEquals ( "Web form" , title.getText () );
    }

    @Test
    void openAllLinksTest() {
        int qtyLinks = 0;
        List<WebElement> chapters = driver.findElements ( By.cssSelector ( "h5.card-title" ) );
        for (WebElement chapter : chapters) {
            List<WebElement> links = chapter.findElements ( By.xpath ( "./../a" ) );
            qtyLinks += links.size ();
            System.out.println ( chapter.getText () );
            for (WebElement link : links) {
                System.out.println ( link.getText () );
                link.click ();
                driver.navigate ().back ();
            }
        }
        assertEquals ( 6 , chapters.size () );
        assertEquals ( 27 , qtyLinks );
    }

    @Test
    void classesTest() {
        List<WebElement> links = driver.findElements ( By.cssSelector ( ".btn.btn-outline-primary.mb-2" ) );
        assertEquals ( 27 , links.size () );
    }
}
