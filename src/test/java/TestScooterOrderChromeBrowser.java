import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.model.AboutRentPage;
import ru.yandex.praktikum.model.WhoIsTheScooterForPage;

/* это тестовый класс для проверки функционала заказа самоката, с заполнением полей на страницах и испытанием кнопок на
 этих страницах, а также и кнопок на всплывающих окнах, браузер Chrome */
@RunWith(org.junit.runners.Parameterized.class) //аннотация для параметризации тестов
public class TestScooterOrderChromeBrowser {
    private final String firstNameUser;
    private final String lastNameUser;
    private final String addressUser;
    private final String metroStation;
    private final String phoneNumUser;
    private final String selectDate;
    private final String commentUser;
    private WebDriver driver;


    public TestScooterOrderChromeBrowser(String firstNameUser, String lastNameUser, String addressUser,
                                         String metroStation, String phoneNumUser, String selectDate,
                                         String commentUser) {
        this.firstNameUser = firstNameUser;
        this.lastNameUser = lastNameUser;
        this.addressUser = addressUser;
        this.metroStation = metroStation;
        this.phoneNumUser = phoneNumUser;
        this.selectDate = selectDate;
        this.commentUser = commentUser;
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    // 1-ый флоу сценарий, с кнопкой "Заказать" в хедере страницы
    @Test
    public void testHeaderOrderButton() {
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        WhoIsTheScooterForPage page = new WhoIsTheScooterForPage(driver);
        page.openMainPage();
        page.clickCookie();                                  //жмём на кнопку "ПРИНЯТЬ", чтобы скрыть окно пропринятия или нет куки
        page.clickHeaderOrderButton();                      //жмем на кнопку "ЗАКАЗАТЬ" в хедере страницы
        page.enterFirstNameInNameField(firstNameUser);      // в открывшемся окне начинаем заполнять форму заказа с поля "ИМЯ"
        page.enterLastNameInLastNameField(lastNameUser);
        page.enterAddressInAddressField(addressUser);
        page.select_MetroStationInMetroField(metroStation);
        page.enter_PhoneNumberInInputPhoneField(phoneNumUser);
        page.clickNextButton();
        aboutRentPage.inputDateField(selectDate);               //заполняем поле "КОГДА ПРИВЕЗТИ САМОКАТ"
        aboutRentPage.chooseRentPeriod();                       //выбираем в списке нужный срок аренды
        aboutRentPage.chooseScooterColourGray();                //выбираем Серый цвет самоката
        aboutRentPage.inputTextInCommentField(commentUser);     //пишем комментарий
        aboutRentPage.clickOrderButton();                        //жмем кнопку "ЗАКАЗАТЬ" внизу формы
        aboutRentPage.checkWontYouPlaceAnOrderWidowIsOpen();     //проверяем открылось ли окошко "Хотите оформить заказ"
        aboutRentPage.clickYesButtonInOrderWindow();             // жмем кнопку "ДА" в открывшемся окошке
        aboutRentPage.checkOrderIsProcessedWindowIsOpen();       //проверка: открылось ли окошко "Заказ оформлен"
        aboutRentPage.checkTextInOrderIsProcessedWindow();        //проверяем тот ли текст в окошке "Заказ оформлен"
    }

    // 2-ой флоу сценарий: тестирование с кнопкой "Заказать" в центре страницы
    @Test
    public void testMiddleOrderButton() {
        AboutRentPage aboutRentPage = new AboutRentPage(driver);
        WhoIsTheScooterForPage page = new WhoIsTheScooterForPage(driver);
        page.openMainPage();
        page.clickCookie();                                  //жмём на кнопку "ПРИНЯТЬ", чтобы скрыть окно пропринятия или нет куки
        page.clickMiddleOrderButton();                      //жмем на кнопку "ЗАКАЗАТЬ" в ЦЕНТРЕ страницы
        page.enterFirstNameInNameField(firstNameUser);      // в открывшемся окне начинаем заполнять форму заказа с поля "ИМЯ"
        page.enterLastNameInLastNameField(lastNameUser);
        page.enterAddressInAddressField(addressUser);
        page.select_MetroStationInMetroField(metroStation);
        page.enter_PhoneNumberInInputPhoneField(phoneNumUser);
        page.clickNextButton();
        aboutRentPage.inputDateField(selectDate);               //заполняем поле "КОГДА ПРИВЕЗТИ САМОКАТ"
        aboutRentPage.chooseRentPeriod();                       //выбираем в списке нужный срок аренды
        aboutRentPage.chooseScooterColourGray();                //выбираем Серый цвет самоката
        aboutRentPage.inputTextInCommentField(commentUser);     //пишем комментарий
        aboutRentPage.clickOrderButton();                        //жмем кнопку "ЗАКАЗАТЬ" внизу формы
        aboutRentPage.clickYesButtonInOrderWindow();             // жмем кнопку "ДА" в открывшемся окошке
        aboutRentPage.checkOrderIsProcessedWindowIsOpen();       //проверка: открылось ли окошко "Заказ оформлен"
        aboutRentPage.checkTextInOrderIsProcessedWindow();        //проверяем тот ли текст в окошке "Заказ оформлен"

    }

    @Parameterized.Parameters  //аннотация тестовые параметры
    public static Object[][] getStrings() {
        return new Object[][]{
                {"Иван", "Петров", "Садовая, 7", "Беляево", "89775554545", "12.03.2023", "Привет!"},
                {"Peter", "Ivanov", "Мира, 1", "Begovaya", "89265558778", "01.05.2023", "Привет, я тут!"},
                {"Вова", "Gucci", "5-avenue, 123", "ПРОСПЕКТ МИРА", "+14544545455474", "05.05.2023", "Подсказка: Тебе понадобится найти поле карточки по названию города."},
        };
    }

    @After
    public void close() {
        driver.quit();
    }
}


