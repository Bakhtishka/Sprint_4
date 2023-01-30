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
    //("div#accordion__heading-0.accordion__button");

    // раскрытая первая вкладка
    //("div#accordion__panel-0.accordion__panel");

    // 2-я вкладка выпадающего списка в разделе «Вопросы о важном»
    //("div#accordion__heading-1.accordion__button");

    // раскрытая 2-я вкладка
    //("div#accordion__panel-1.accordion__panel");

    // 3-я вкладка выпадающего списка в разделе «Вопросы о важном»
    //("div#accordion__heading-2.accordion__button");

    // раскрытая 3-я вкладка
    //("div#accordion__panel-2.accordion__panel");

    // 4-я  вкладка выпадающего списка в разделе «Вопросы о важном»
    //("div#accordion__heading-3.accordion__button");

    // раскрытая 4-я вкладка
    //("div#accordion__panel-3.accordion__panel");

    // 5-я вкладка выпадающего списка в разделе «Вопросы о важном»
    //("div#accordion__heading-4.accordion__button");

    // раскрытая 5-я вкладка
    //("div#accordion__panel-4.accordion__panel");

    // 6-я вкладка выпадающего списка в разделе «Вопросы о важном»
    //("div#accordion__heading-5.accordion__button");

    // раскрытая 6-я вкладка
    //("div#accordion__panel-5.accordion__panel");

    // 7-я вкладка выпадающего списка в разделе «Вопросы о важном»
    //("div#accordion__heading-6.accordion__button");

    // раскрытая 7-я вкладка
    //("div#accordion__panel-6.accordion__panel");

    // 8-я вкладка выпадающего списка в разделе «Вопросы о важном»
    //("div#accordion__heading-7.accordion__button");

    // раскрытая 8-я вкладка
    //("div#accordion__panel-7.accordion__panel");

    //локатор для принятия куки, кнопка "Да все привыкли"
    private final By COOKIE_BUTTON = By.cssSelector("button#rcc-confirm-button.App_CookieButton__3cvqF");
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
        WebElement element = driver.findElement(COOKIE_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(COOKIE_BUTTON).click();
    }

    public void checkTextsInSubHeaderPanels(
            String buttonLocation,
            String panelLocation,
            String expectedText
    ) {
        final By buttonSelector = By.cssSelector(buttonLocation);
        driver.findElement(buttonSelector).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        final By panelSelector = By.cssSelector(panelLocation);
        String actualText = driver.findElement(panelSelector).getText();
        Assert.assertEquals(expectedText, actualText);
    }
}

