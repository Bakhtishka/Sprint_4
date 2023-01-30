import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.MainPage;

//тестовый класс, проверяющий соответствие текста при нажатии на стрелку. Браузер Chrome.
@RunWith(Parameterized.class)
public class TestSubHeaderPanelInChromeBrowser {
    private final String expectedText;
    private final String buttonLocation;
    private final String panelLocation;
    private WebDriver driver;

    public TestSubHeaderPanelInChromeBrowser(
            String buttonLocation,
            String panelLocation,
            String expectedText
    ) {
        this.buttonLocation = buttonLocation;
        this.panelLocation = panelLocation;
        this.expectedText = expectedText;
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }


    @Parameterized.Parameters
    public static Object[][] getTextInSubPanel() {
        return new Object[][]{
                {"div#accordion__heading-0.accordion__button", "div#accordion__panel-0.accordion__panel", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"div#accordion__heading-1.accordion__button", "div#accordion__panel-1.accordion__panel", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"div#accordion__heading-2.accordion__button", "div#accordion__panel-2.accordion__panel", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"div#accordion__heading-3.accordion__button", "div#accordion__panel-3.accordion__panel", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"div#accordion__heading-4.accordion__button", "div#accordion__panel-4.accordion__panel", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"div#accordion__heading-5.accordion__button", "div#accordion__panel-5.accordion__panel", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"div#accordion__heading-6.accordion__button", "div#accordion__panel-6.accordion__panel", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"div#accordion__heading-7.accordion__button", "div#accordion__panel-7.accordion__panel", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }


    // проверка: когда нажимаешь по стрелке открывается
    // соответствующий текст в панели
    @Test
    public void checkThat() {
        MainPage page = new MainPage(driver);
        page.open();
        page.clickCookie();
        page.checkTextsInSubHeaderPanels(buttonLocation, panelLocation, expectedText);
    }


    @After
    public void cleanUp() {
        driver.quit();
    }
}