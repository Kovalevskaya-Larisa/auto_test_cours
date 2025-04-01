package Task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Chapter {
    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver ();
        driver.get ( BASE_URL );
        driver.manage ().window ().maximize ();
    }

    @AfterTest
    public void teardown() {
        driver.quit ();
    }

    @Test(priority = 1)
    public void openWebFormTest() throws InterruptedException {
        WebElement buttonWebForm = driver.findElement ( By.xpath ( "//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[@href='web-form.html']" ) );
        buttonWebForm.click ();
        String webFormUrl = "web-form.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + webFormUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Web form" );
        driver.navigate ().back ();
    }

    @Test(priority = 2)
    public void openNavigationTest() {
        WebElement buttonNavigation = driver.findElement ( By.xpath ( "//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[@href='navigation1.html']" ) );
        buttonNavigation.click ();
        String navigationUrl = "navigation1.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + navigationUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value1 = example.getText ();

        assertEquals ( value1 , "Navigation example" );
        driver.navigate ().back ();
    }

    @Test(priority = 3)
    public void openDropdownMenuTest() {
        WebElement buttonDropdownMenu = driver.findElement ( By.xpath ( "//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[@href='dropdown-menu.html']" ) );
        buttonDropdownMenu.click ();
        String dropDownMenuUrl = "dropdown-menu.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + dropDownMenuUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Dropdown menu" );
        driver.navigate ().back ();
    }

    @Test(priority = 4)
    public void openMouseOverTest() {
        WebElement buttonMouseOver = driver.findElement ( By.xpath ( "//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[@href='mouse-over.html']" ) );
        buttonMouseOver.click ();
        String mouseOverUrl = "mouse-over.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + mouseOverUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Mouse over" );
        driver.navigate ().back ();
    }

    @Test(priority = 5)
    public void openDragAndDropTest() {
        WebElement buttonDragAndDrop = driver.findElement ( By.xpath ( "//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[@href='drag-and-drop.html']" ) );
        buttonDragAndDrop.click ();
        String dragAndDropUrl = "drag-and-drop.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + dragAndDropUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Drag and drop" );
        driver.navigate ().back ();
    }

    @Test(priority = 6)
    public void openDrawInCanvasTest() {
        WebElement buttonDrawInCanvas = driver.findElement ( By.xpath ( "//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[@href='draw-in-canvas.html']" ) );
        buttonDrawInCanvas.click ();
        String drawInCanvasUrl = "draw-in-canvas.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + drawInCanvasUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Drawing in canvas" );
        driver.navigate ().back ();
    }

    @Test(priority = 7)
    public void openLoadingImagesTest() {
        WebElement buttonLoadingImages = driver.findElement ( By.xpath ( "//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[@href='loading-images.html']" ) );
        buttonLoadingImages.click ();
        String loadingImagesUrl = "loading-images.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + loadingImagesUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Loading images" );
        driver.navigate ().back ();
    }

    @Test(priority = 8)
    public void openSlowCalculatorTest() {
        WebElement buttonSlowCalculator = driver.findElement ( By.xpath ( "//h5[text()='Chapter 3. WebDriver Fundamentals']/../a[@href='slow-calculator.html']" ) );
        buttonSlowCalculator.click ();
        String slowCalculatorUrl = "slow-calculator.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + slowCalculatorUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Slow calculator" );
        driver.navigate ().back ();
    }

    @Test(priority = 9)
    public void openLongPageTest() {
        driver.get ( BASE_URL );
        WebElement buttonLongPage = driver.findElement ( By.xpath ( "//h5[text()='Chapter 4. Browser-Agnostic Features']/../a[@href='long-page.html']" ) );
        buttonLongPage.click ();
        String longPageUrl = "long-page.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + longPageUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "This is a long page" );
        driver.navigate ().back ();
    }

    @Test(priority = 10)
    public void openInfiniteScrollTest() {
        driver.get ( BASE_URL );
        WebElement buttonInfiniteScroll = driver.findElement ( By.xpath ( "//h5[text()='Chapter 4. Browser-Agnostic Features']/../a[@href='infinite-scroll.html']" ) );
        buttonInfiniteScroll.click ();
        String infiniteScrollUrl = "infinite-scroll.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + infiniteScrollUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value1 = example.getText ();

        assertEquals ( value1 , "Infinite scroll" );
        driver.navigate ().back ();
    }

    @Test(priority = 11)
    public void openShadowDomTest() {
        driver.get ( BASE_URL );
        WebElement buttonShadowDom = driver.findElement ( By.xpath ( "//h5[text()='Chapter 4. Browser-Agnostic Features']/../a[@href='shadow-dom.html']" ) );
        buttonShadowDom.click ();
        String shadowDomUrl = "shadow-dom.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + shadowDomUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Shadow DOM" );
        driver.navigate ().back ();
    }

    @Test(priority = 12)
    public void openCookiesTest() {
        driver.get ( BASE_URL );
        WebElement buttonCookies = driver.findElement ( By.xpath ( "//h5[text()='Chapter 4. Browser-Agnostic Features']/../a[@href='cookies.html']" ) );
        buttonCookies.click ();
        String cookiesUrl = "cookies.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + cookiesUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Cookies" );
        driver.navigate ().back ();
    }


    @Test(priority = 13)
    public void openIFramesTest() {
        driver.get ( BASE_URL );
        WebElement buttonIFrames = driver.findElement ( By.xpath ( "//h5[text()='Chapter 4. Browser-Agnostic Features']/../a[@href='iframes.html']" ) );
        buttonIFrames.click ();
        String iFramesUrl = "iframes.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + iFramesUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "IFrame" );
        driver.navigate ().back ();
    }

    @Test(priority = 14)
    public void openDialogBoxesTest() {
        driver.get ( BASE_URL );
        WebElement buttonDialogBoxes = driver.findElement ( By.xpath ( "//h5[text()='Chapter 4. Browser-Agnostic Features']/../a[@href='dialog-boxes.html']" ) );
        buttonDialogBoxes.click ();
        String dialogBoxesUrl = "dialog-boxes.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + dialogBoxesUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Dialog boxes" );
        driver.navigate ().back ();
    }

    @Test(priority = 15)
    public void openWebStorageTest() {
        driver.get ( BASE_URL );
        WebElement buttonWebStorage = driver.findElement ( By.xpath ( "//h5[text()='Chapter 4. Browser-Agnostic Features']/../a[@href='web-storage.html']" ) );
        buttonWebStorage.click ();
        String webStorageUrl = "web-storage.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + webStorageUrl , currentUrl );

        WebElement example = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String value = example.getText ();

        assertEquals ( value , "Web storage" );
        driver.navigate ().back ();
    }

    @Test(priority = 16)
    public void openGeolocationTest() {
        driver.get ( BASE_URL );
        WebElement buttonGeolocation = driver.findElement ( By.xpath ( "//h5[text()='Chapter 5. Browser-Specific Manipulation']/../a[@href='geolocation.html']" ) );
        buttonGeolocation.click ();
        String longPageUrl = "geolocation.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + longPageUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Geolocation" );
        driver.navigate ().back ();
    }

    @Test(priority = 17)
    public void openNotificationsTest() {
        driver.get ( BASE_URL );
        WebElement buttonNotifications = driver.findElement ( By.xpath ( "//h5[text()='Chapter 5. Browser-Specific Manipulation']/../a[@href='notifications.html']" ) );
        buttonNotifications.click ();
        String longPageUrl = "notifications.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + longPageUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Notifications" );
        driver.navigate ().back ();
    }

    @Test(priority = 18)
    public void openGetUserMediaTest() {
        driver.get ( BASE_URL );
        WebElement buttonGetUserMedia = driver.findElement ( By.xpath ( "//h5[text()='Chapter 5. Browser-Specific Manipulation']/../a[@href='get-user-media.html']" ) );
        buttonGetUserMedia.click ();
        String longPageUrl = "get-user-media.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + longPageUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Get user media" );
        driver.navigate ().back ();
    }

    @Test(priority = 19)
    public void openMultilanguageTest() {
        driver.get ( BASE_URL );
        WebElement buttonMultilanguage = driver.findElement ( By.xpath ( "//h5[text()='Chapter 5. Browser-Specific Manipulation']/../a[@href='multilanguage.html']" ) );
        buttonMultilanguage.click ();
        String longPageUrl = "multilanguage.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + longPageUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "" );
        driver.navigate ().back ();
    }

    @Test(priority = 20)
    public void openConsoleLogsTest() {
        driver.get ( BASE_URL );
        WebElement buttonConsoleLogs = driver.findElement ( By.xpath ( "//h5[text()='Chapter 5. Browser-Specific Manipulation']/../a[@href='console-logs.html']" ) );
        buttonConsoleLogs.click ();
        String longPageUrl = "console-logs.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + longPageUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Console logs" );
        driver.navigate ().back ();
    }

    @Test(priority = 21)
    public void openLoginFormTest() {
        driver.get ( BASE_URL );
        WebElement buttonLoginForm = driver.findElement ( By.xpath ( "//h5[text()='Chapter 7. The Page Object Model (POM)']/../a[@href='login-form.html']" ) );
        buttonLoginForm.click ();
        String longPageUrl = "login-form.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + longPageUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Login form" );
        driver.navigate ().back ();
    }

    @Test(priority = 22)
    public void openSlowLoginTest() {
        driver.get ( BASE_URL );
        WebElement buttonSlowLogin = driver.findElement ( By.xpath ( "//h5[text()='Chapter 7. The Page Object Model (POM)']/../a[@href='login-slow.html']" ) );
        buttonSlowLogin.click ();
        String longPageUrl = "login-slow.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + longPageUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Slow login form" );
        driver.navigate ().back ();
    }

    @Test(priority = 23)
    public void openRandomCalculatorTest() {
        driver.get ( BASE_URL );
        WebElement buttonRandomCalculator = driver.findElement ( By.xpath ( "//h5[text()='Chapter 8. Testing Framework Specifics']/../a[@href='random-calculator.html']" ) );
        buttonRandomCalculator.click ();
        String longPageUrl = "random-calculator.html";

        String currentUrl = driver.getCurrentUrl ();
        assertEquals ( BASE_URL + longPageUrl , currentUrl );

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Random calculator" );
        driver.navigate ().back ();
    }
    @Test(priority = 24)
    public void openDownloadFilesTest() {
        driver.get ( BASE_URL );
        WebElement buttonDownloadFiles = driver.findElement ( By.xpath ( "//h5[text()='Chapter 9. Third-Party Integrations']/../a[@href='download.html']" ) );
        buttonDownloadFiles.click ();
        String longPageUrl = "download.html";

        String currentUrl = driver.getCurrentUrl();
        assertEquals(BASE_URL + longPageUrl, currentUrl);

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Download files" );
        driver.navigate ().back ();
    }
    @Test(priority = 25)
    public void openABTestingTest() {
        driver.get ( BASE_URL );
        WebElement buttonABTesting = driver.findElement ( By.xpath ( "//h5[text()='Chapter 9. Third-Party Integrations']/../a[@href='ab-testing.html']" ) );
        buttonABTesting.click ();
        String longPageUrl = "ab-testing.html";

        String currentUrl = driver.getCurrentUrl();
        assertEquals(BASE_URL + longPageUrl, currentUrl);

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "A/B Testing" );
        driver.navigate ().back ();
    }
    @Test(priority = 26)
    public void openDataTypesTest() {
        driver.get ( BASE_URL );
        WebElement buttonDataTypes = driver.findElement ( By.xpath ( "//h5[text()='Chapter 9. Third-Party Integrations']/../a[@href='data-types.html']" ) );
        buttonDataTypes.click ();
        String longPageUrl = "data-types.html";

        String currentUrl = driver.getCurrentUrl();
        assertEquals(BASE_URL + longPageUrl, currentUrl);

        WebElement message = driver.findElement ( By.cssSelector ( ".display-6" ) );
        String text = message.getText ();
        assertEquals ( text , "Data types" );
        driver.navigate ().back ();
    }

}
