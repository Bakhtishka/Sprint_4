package ru.yandex.praktikum.model;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
/*Список необходимых локаторов для главной страницы сайта:
1.  //*[@id="accordion__heading-0"] - первая вкладка выпадающего списка в разделе «Вопросы о важном»;
2.  //*[@id="accordion__panel-0"] - раскрытая вкладка после клика на стрелку
3.  //*[@id="accordion__heading-1"] - 2-я вкладка выпадающего списка в разделе «Вопросы о важном»;
4.  //*[@id="accordion__panel-1"]  - раскрытая 2-я вкладка;
5.  //*[@id="accordion__heading-2"] - 3-я вкладка выпадающего списка в разделе «Вопросы о важном»;
6.  //*[@id="accordion__panel-2"] - раскрытая 3-я вкладка;
7.  //*[@id="accordion__heading-3"] -  4-я  вкладка выпадающего списка в разделе «Вопросы о важном»;
8.  //*[@id="accordion__panel-3"] -  раскрытая 4-я вкладка;
9.  //*[@id="accordion__heading-4"] -  5-я вкладка выпадающего списка в разделе «Вопросы о важном»;
10.  //*[@id="accordion__panel-4"] - раскрытая 5-я вкладка;
11.  //*[@id="accordion__heading-5"] - 6-я вкладка выпадающего списка в разделе «Вопросы о важном»;
12.  //*[@id="accordion__panel-5"] - раскрытая 6-я вкладка;
13.  //*[@id="accordion__heading-6"] - 7-я вкладка выпадающего списка в разделе «Вопросы о важном»;
14.  //*[@id="accordion__panel-6"] - раскрытая 7-я вкладка;
15.  //*[@id="accordion__heading-7"] - 8-я вкладка выпадающего списка в разделе «Вопросы о важном»;
16.  button#rcc-confirm-button.App_CookieButton__3cvqF - локатор для принятия куки, кнопка "Да все привыкли";
 */

//класс главной страницы сайта Самокат
public class MainPage {
    private static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    // первая вкладка выпадающего списка в разделе «Вопросы о важном»
    private static final By BUTTON_ONE = By.xpath("//*[@id=\"accordion__heading-0\"]");

    // раскрытая первая вкладка
    private static final By PANEL_BUTTON_ONE = By.xpath("//*[@id=\"accordion__panel-0\"]");

    // 2-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private static final By BUTTON_TWO = By.xpath("//*[@id=\"accordion__heading-1\"]");

    // раскрытая 2-я вкладка
    private static final By PANEL_BUTTON_TWO = By.xpath("//*[@id=\"accordion__panel-1\"]");

    // 3-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private static final By BUTTON_THREE = By.xpath("//*[@id=\"accordion__heading-2\"]");

    // раскрытая 3-я вкладка
    private static final By PANEL_BUTTON_THREE = By.xpath("//*[@id=\"accordion__panel-2\"]");

    // 4-я  вкладка выпадающего списка в разделе «Вопросы о важном»
    private static final By BUTTON_FOUR = By.xpath("//*[@id=\"accordion__heading-3\"]");

    // раскрытая 4-я вкладка
    private static final By PANEL_BUTTON_FOUR = By.xpath("//*[@id=\"accordion__panel-3\"]");

    // 5-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private static final By BUTTON_FIVE = By.xpath("//*[@id=\"accordion__heading-4\"]");

    // раскрытая 5-я вкладка
    private static final By PANEL_BUTTON_FIVE = By.xpath("//*[@id=\"accordion__panel-4\"]");

    // 6-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private static final By BUTTON_SIX = By.xpath("//*[@id=\"accordion__heading-5\"]");

    // раскрытая 6-я вкладка
    private static final By PANEL_BUTTON_SIX = By.xpath("//*[@id=\"accordion__panel-5\"]");

    // 7-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private static final By BUTTON_SEVEN = By.xpath("//*[@id=\"accordion__heading-6\"]");

    // раскрытая 7-я вкладка
    private static final By PANEL_BUTTON_SEVEN = By.xpath("//*[@id=\"accordion__panel-6\"]");

    // 8-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private static final By BUTTON_EIGHT = By.xpath("//*[@id=\"accordion__heading-7\"]");

    // раскрытая 8-я вкладка
    private static final By PANEL_BUTTON_EIGHT = By.xpath("//*[@id=\"accordion__panel-7\"]");                                        //cssSelector("div#accordion__panel-7.accordion__panel");

    //локатор для принятия куки, кнопка "Да все привыкли"
    private static final By COOKIE_BUTTON = By.cssSelector("button#rcc-confirm-button.App_CookieButton__3cvqF");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    //метод открывающий главную страницу сайта
    public void open() { //метод открывающий страницу в браузере
        driver.get(MAIN_PAGE_URL);
    }

    //Метод принимает куки, нажимает на кнопку "Да все привыкли"
    public void clickCookie() {
        WebElement element = driver.findElement(COOKIE_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(COOKIE_BUTTON).click();
    }

    //проверка соответствию текста при нажатии на первую стрелку
    public void checkTextsInSubHeaderPanelOne() {
        driver.findElement(BUTTON_ONE).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(PANEL_BUTTON_ONE).getText();
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на вторую стрелку
    public void checkTextsInSubHeaderPanelTwo() {
        driver.findElement(BUTTON_TWO).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(PANEL_BUTTON_TWO).getText();
        String expectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                " можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на третью стрелку
    public void checkTextsInSubHeaderPanelThree() {
        driver.findElement(BUTTON_THREE).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(PANEL_BUTTON_THREE).getText();
        String expectedText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат" +
                " 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на четвертую стрелку
    public void checkTextsInSubHeaderPanelFour() {
        driver.findElement(BUTTON_FOUR).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(PANEL_BUTTON_FOUR).getText();
        String expectedText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на пятую стрелку
    public void checkTextsInSubHeaderPanelFive() {
        driver.findElement(BUTTON_FIVE).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(PANEL_BUTTON_FIVE).getText();
        String expectedText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому " +
                "номеру 1010.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на шестую стрелку
    public void checkTextsInSubHeaderPanelSix() {
        driver.findElement(BUTTON_SIX).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(PANEL_BUTTON_SIX).getText();
        String expectedText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на седьмую стрелку
    public void checkTextsInSubHeaderPanelSeven() {
        driver.findElement(BUTTON_SEVEN).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(PANEL_BUTTON_SEVEN).getText();
        String expectedText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на восьмую стрелку
    public void checkTextsInSubHeaderPanelEight() {
        driver.findElement(BUTTON_EIGHT).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(PANEL_BUTTON_EIGHT).getText();
        String expectedText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals(expectedText, button);
    }
}