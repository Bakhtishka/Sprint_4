package ru.yandex.praktikum.model;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* Список локаторов для страницы: "ДЛЯ КОГО САМОКАТ"
    1. button.Button_Button__ra12g                              -  кнопка "Заказать" в хедере;
    2. button.Button_Button__ra12g.Button_Middle__1CSJM         - кнопка "Заказать" в центре страницы;
    3. //input[@placeholder='* Имя']                            - поле "Имя";
    6. //input[@placeholder='* Фамилия']                        - поле "Фамилия";
    5. //input[@placeholder='* Адрес: куда привезти заказ']     - поле "Адрес куда привезти заказ";
    6. //input[@placeholder='* Станция метро']                  - поле "Станция метро";
    7. //input[@placeholder='* Телефон: на него позвонит курьер'] - поле "Телефон: на него позвонит курьер";
    8. //button[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Далее'] - кнопка "Далее";
    9.  div.Order_Content__bmtHS                                   - страница "Про заказ";
    10. button#rcc-confirm-button.App_CookieButton__3cvqF          - кнопка принятия куки "Да все привыкли";
 */

// страница: "Для кого самокат"
public class WhoIsTheScooterForPage {

    // кнопка "Заказать" в хедере
    private  final By headerOrderButton = By.cssSelector("button.Button_Button__ra12g");

    //кнопка "Заказать" в центре страницы
    private  final By middleOrderButton = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");

    // локатор для поля "Имя"
    private  final By inputFirstNameField = By.xpath("//input[@placeholder='* Имя']");
    // локатор для поля "Фамилия"
    private  final By inputLastNameField = By.xpath("//input[@placeholder='* Фамилия']");

    // локатор для поля "Адрес куда привезти заказ"
    private  final By inputAddressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор для поля "Станция метро"
    private  final By inputMetroField = By.xpath("//input[@placeholder='* Станция метро']");

    // локатор для поля "Телефон: на него позвонит курьер"
    private  final By inputPhoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор для кнопки "Далее"
    private  final By nextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Далее']");

    //локатор страницы "Про заказ"
    private  final By aboutRentPageOrderForm = By.cssSelector("div.Order_Content__bmtHS");

    //кнопка принятия куки
    private  final By cookieButton = By.cssSelector("button#rcc-confirm-button.App_CookieButton__3cvqF");
    private final WebDriver driver;

    public WhoIsTheScooterForPage(WebDriver driver) { // класс страницы "Для кого самокат"
        this.driver = driver;
    }

    //метод открывает главную страницу сайта
    public void openMainPage() {
        //урл главной страницы
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //метод принимающий куки на морде сайта
    public void clickCookie() {
        WebElement element = driver.findElement(cookieButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(cookieButton).click();
    }

    //метод, кликающий на верхнюю кнопку "Заказать"
    public void clickHeaderOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(headerOrderButton));
        driver.findElement(headerOrderButton).click();
    }

    //метод, кликающий на среднюю кнопку "Заказать"
    public void clickMiddleOrderButton() {
        WebElement element = driver.findElement(middleOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(middleOrderButton));
        driver.findElement(middleOrderButton).click();
    }

    // метод заполняющий поле "Имя"
    public void enterFirstNameInNameField(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(inputFirstNameField));
        final WebElement firstNameField = driver.findElement(inputFirstNameField);
        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }

    //метод заполняет поле "Фамилия"
    public void enterLastNameInLastNameField(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(inputLastNameField));
        final WebElement lastNameField = driver.findElement(inputLastNameField);
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    //метод заполняет поле "Адрес куда привезти заказ"
    public void enterAddressInAddressField(String address) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(inputAddressField));
        final WebElement addressField = driver.findElement(inputAddressField);
        addressField.click();
        addressField.clear();
        addressField.sendKeys(address);
    }

    //метод выбирает станцию в поле "Станция метро"
    public void select_MetroStationInMetroField(String station) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputMetroField));
        final WebElement metroInput = driver.findElement(inputMetroField);
        metroInput.click();
        metroInput.clear();
        new WebDriverWait(driver, Duration.ofSeconds(5));
        metroInput.sendKeys(station);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementValue(metroInput, station));
        metroInput.sendKeys(Keys.DOWN);
        metroInput.sendKeys(Keys.RETURN);
    }

    //метод заполняет поле "Телефон: на него позвонит курьер"
    public void enter_PhoneNumberInInputPhoneField(String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(inputPhoneNumberField));
        final WebElement phoneNum = driver.findElement(inputPhoneNumberField);
        phoneNum.clear();
        phoneNum.sendKeys(phoneNumber);
    }

    //метод кликает на кнопку "Далее"
    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        final WebElement buttonNext = driver.findElement(nextButton);
        buttonNext.click();
    }
}
