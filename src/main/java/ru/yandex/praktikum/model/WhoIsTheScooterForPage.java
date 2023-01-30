package ru.yandex.praktikum.model;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* Список локаторов для страницы: "ДЛЯ КОГО САМОКАТ"
1. button.Button_Button__ra12g                                                    -  кнопка "Заказать" в хедере;
2. button.Button_Button__ra12g.Button_Middle__1CSJM                               - кнопка "Заказать" в центре страницы;
3. //*[@id="root"]/div/div[2]/div[2]/div[1]/input                                                          - поле "Имя";
6. //*[@id="root"]/div/div[2]/div[2]/div[2]/input                                                     - поле "Фамилия";
5. .//*[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @type = 'text' or text() = " * Адрес: куда привезти заказ'] - поле "Адрес куда привезти заказ";
6. .//*[@class = 'select-search__input']                                                         - поле "Станция метро";
7. //*[@id="root"]/div/div[2]/div[2]/div[5]/input                             - поле "Телефон: на него позвонит курьер";
8.  button.Button_Button__ra12g.Button_Middle__1CSJM                                                  - кнопка "Далее";
9.  div.Order_Content__bmtHS                                                                    - страница "Про заказ";
10. button#rcc-confirm-button.App_CookieButton__3cvqF                         - кнопка принятия куки "Да все привыкли";
 */

// страница: "Для кого самокат"
public class WhoIsTheScooterForPage {

    // кнопка "Заказать" в хедере
    private  final By HEADER_ORDER_BUTTON = By.cssSelector("button.Button_Button__ra12g");

    //кнопка "Заказать" в центре страницы
    private  final By MIDDLE_ORDER_BUTTON = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");

    // локатор для поля "Имя"
    private  final By INPUT_FIELD_FIRST_NAME =
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");

    // локатор для поля "Фамилия"
    private  final By INPUT_FIELD_LAST_NAME =
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");

    // локатор для поля "Адрес куда привезти заказ"
    private  final By INPUT_FIELD_ADDRESS =
            By.xpath(".//*[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN' and @type = 'text' or text() = " +
                    "'* Адрес: куда привезти заказ']");

    // локатор для поля "Станция метро"
    private  final By INPUT_FIELD_METRO = By.xpath(".//*[@class = 'select-search__input']");

    // локатор для поля "Телефон: на него позвонит курьер"
    private  final By INPUT_FIELD_PHONE =
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");

    // локатор для кнопки "Далее"
    private  final By NEXT_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    //локатор страницы "Про заказ"
    private  final By ABOUT_RENT_PAGE_FORM = By.cssSelector("div.Order_Content__bmtHS");

    //кнопка принятия куки
    private  final By COOKIE_BUTTON = By.cssSelector("button#rcc-confirm-button.App_CookieButton__3cvqF");
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
        WebElement element = driver.findElement(COOKIE_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(COOKIE_BUTTON).click();
    }

    //метод, кликающий на верхнюю кнопку "Заказать"
    public void clickHeaderOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(HEADER_ORDER_BUTTON));
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }

    //метод, кликающий на среднюю кнопку "Заказать"
    public void clickMiddleOrderButton() {
        WebElement element = driver.findElement(MIDDLE_ORDER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(MIDDLE_ORDER_BUTTON));
        driver.findElement(MIDDLE_ORDER_BUTTON).click();
    }

    // метод заполняющий поле "Имя"
    public void enterFirstNameInNameField(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_FIELD_FIRST_NAME));
        final WebElement firstNameField = driver.findElement(INPUT_FIELD_FIRST_NAME);
        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys(name);
        wait.until(ExpectedConditions.textToBePresentInElementValue(firstNameField, name));
        Assert.assertEquals (name, firstNameField.getAttribute("value"));
    }

    //метод заполняет поле "Фамилия"
    public void enterLastNameInLastNameField(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_FIELD_LAST_NAME));
        final WebElement lastNameField = driver.findElement(INPUT_FIELD_LAST_NAME);
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        Assert.assertEquals (lastName, lastNameField.getAttribute("value"));
    }

    //метод заполняет поле "Адрес куда привезти заказ"
    public void enterAddressInAddressField(String address) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_FIELD_ADDRESS));
        final WebElement addressField = driver.findElement(INPUT_FIELD_ADDRESS);
        addressField.click();
        addressField.clear();
        addressField.sendKeys(address);
        Assert.assertEquals (address, addressField.getAttribute("value"));
    }

    //метод выбирает станцию в поле "Станция метро"
    public void select_MetroStationInMetroField(String station) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_FIELD_METRO));
        final WebElement metroInput = driver.findElement(INPUT_FIELD_METRO);
        metroInput.click();
        metroInput.clear();
        new WebDriverWait(driver, Duration.ofSeconds(5));
        metroInput.sendKeys(station);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElementValue(metroInput, station));
        metroInput.sendKeys(Keys.DOWN);
        metroInput.sendKeys(Keys.RETURN);
        Assert.assertEquals (station, metroInput.getAttribute("value"));
    }

    //метод заполняет поле "Телефон: на него позвонит курьер"
    public void enter_PhoneNumberInInputPhoneField(String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_FIELD_PHONE));
        final WebElement phoneNum = driver.findElement(INPUT_FIELD_PHONE);
        phoneNum.clear();
        phoneNum.sendKeys(phoneNumber);
        Assert.assertEquals (phoneNumber, phoneNum.getAttribute("value"));
    }

    //метод кликает на кнопку "Далее"
    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
        final WebElement nextButton = driver.findElement(NEXT_BUTTON);
        nextButton.click();
    }

    //проверка, что окно "Про аренду" открылось
    public void checkAboutRentPageIsOpen() {
        Assert.assertTrue(driver.findElement(ABOUT_RENT_PAGE_FORM).isDisplayed());
    }
}
