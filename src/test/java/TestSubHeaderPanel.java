import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.MainPage;

//тестовый класс, проверяющий соответствие текста при нажатии на стрелку.
public class TestSubHeaderPanel{

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    // проверка: когда нажимаешь по стрелке открывается
    // соответствующий текст в панели
    @Test
    public void checkPanelOne() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanelOne();
    }
    @Test
    public void checkPanelTwo() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanelTwo();
    }
    @Test
    public void checkPanelThree() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanelThree();
    }
    @Test
    public void checkPanelFour() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanelFour();
    }
    @Test
    public void checkPanelFive() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanelFive();
    }
    @Test
    public void checkPanelSix() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanelSix();
    }
    @Test
    public void checkPanelSeven() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanelSeven();
    }
    @Test
    public void checkPanelEight() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanelEight();
    }


    @After
    public void cleanUp() {
        driver.quit();
    }
}