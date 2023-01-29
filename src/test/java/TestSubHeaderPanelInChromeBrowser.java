import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.MainPage;

//тестовый класс, проверяющий соответствие текста при нажатии на стрелку. Браузер Chrome.
public class TestSubHeaderPanelInChromeBrowser {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }
    // проверка: когда нажимаешь по стрелке открывается
    // соответствующий текст в панели
    @Test
    public void checkThatClickOnTheArrowOpensCorrespondingText() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanelOne();
        page.checkTextsInSubHeaderPanelTwo();
        page.checkTextsInSubHeaderPanelThree();
        page.checkTextsInSubHeaderPanelFour();
        page.checkTextsInSubHeaderPanelFive();
        page.checkTextsInSubHeaderPanelSix();
        page.checkTextsInSubHeaderPanelSeven();
        page.checkTextsInSubHeaderPanelEight();
    }
    @After
    public void cleanUp() {
        driver.quit();
    }
}