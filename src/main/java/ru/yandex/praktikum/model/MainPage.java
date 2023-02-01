package ru.yandex.praktikum.model;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

//класс главной страницы сайта Самокат
public class MainPage {

    // первая вкладка выпадающего списка в разделе «Вопросы о важном»
    private final By buttonOne = By.cssSelector("div#accordion__heading-0.accordion__button");

    // раскрытая первая вкладка
    private final By panelOne = By.cssSelector("div#accordion__panel-0.accordion__panel");

    // 2-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private final By buttonTwo = By.cssSelector("div#accordion__heading-1.accordion__button");

    // раскрытая 2-я вкладка
    private final By panelTwo = By.cssSelector("div#accordion__panel-1.accordion__panel");

    // 3-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private final By buttonThree = By.cssSelector("div#accordion__heading-2.accordion__button");

    // раскрытая 3-я вкладка
    private final By panelThree = By.cssSelector("div#accordion__panel-2.accordion__panel");

    // 4-я  вкладка выпадающего списка в разделе «Вопросы о важном»
    private final By buttonFour = By.cssSelector("div#accordion__heading-3.accordion__button");

    // раскрытая 4-я вкладка
    private final By panelFour = By.cssSelector("div#accordion__panel-3.accordion__panel");

    // 5-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private final By buttonFive = By.cssSelector("div#accordion__heading-4.accordion__button");

    // раскрытая 5-я вкладка
    private final By panelFive = By.cssSelector("div#accordion__panel-4.accordion__panel");

    // 6-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private final By buttonSix = By.cssSelector("div#accordion__heading-5.accordion__button");

    // раскрытая 6-я вкладка
    private final By panelSix = By.cssSelector("div#accordion__panel-5.accordion__panel");

    // 7-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private final By buttonSeven = By.cssSelector("div#accordion__heading-6.accordion__button");

    // раскрытая 7-я вкладка
    private final By panelSeven = By.cssSelector("div#accordion__panel-6.accordion__panel");

    // 8-я вкладка выпадающего списка в разделе «Вопросы о важном»
    private final By buttonEight = By.cssSelector("div#accordion__heading-7.accordion__button");

    // раскрытая 8-я вкладка
    private final By panelEight = By.cssSelector("div#accordion__panel-7.accordion__panel");

    //локатор для принятия куки, кнопка "Да все привыкли"
    private final By cookieButton = By.cssSelector("button#rcc-confirm-button.App_CookieButton__3cvqF");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    //метод открывающий главную страницу сайта
    public void open() { //метод открывающий страницу в браузере
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Метод принимает куки, нажимает на кнопку "Да все привыкли"
    public void clickCookie() {
        WebElement element = driver.findElement(cookieButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(cookieButton).click();
    }

    //проверка соответствию текста при нажатии на первую стрелку
    public void checkTextsInSubHeaderPanelOne() {
        driver.findElement(buttonOne).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(panelOne).getText();
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на вторую стрелку
    public void checkTextsInSubHeaderPanelTwo() {
        driver.findElement(buttonTwo).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(panelTwo).getText();
        String expectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                " можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на третью стрелку
    public void checkTextsInSubHeaderPanelThree() {
        driver.findElement(buttonThree).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(panelThree).getText();
        String expectedText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат" +
                " 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на четвертую стрелку
    public void checkTextsInSubHeaderPanelFour() {
        driver.findElement(buttonFour).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(panelFour).getText();
        String expectedText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на пятую стрелку
    public void checkTextsInSubHeaderPanelFive() {
        driver.findElement(buttonFive).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(panelFive).getText();
        String expectedText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому " +
                "номеру 1010.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на шестую стрелку
    public void checkTextsInSubHeaderPanelSix() {
        driver.findElement(buttonSix).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(panelSix).getText();
        String expectedText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на седьмую стрелку
    public void checkTextsInSubHeaderPanelSeven() {
        driver.findElement(buttonSeven).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(panelSeven).getText();
        String expectedText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals(expectedText, button);
    }

    //проверка соответствию текста при нажатии на восьмую стрелку
    public void checkTextsInSubHeaderPanelEight() {
        driver.findElement(buttonEight).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        String button = driver.findElement(panelEight).getText();
        String expectedText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals(expectedText, button);
    }
}

