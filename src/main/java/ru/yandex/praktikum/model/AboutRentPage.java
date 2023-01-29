package ru.yandex.praktikum.model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/* Список необходимых локаторов для работы с этой страницей:
1. //*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input - поле выбора даты: "Когда привезти самокат";
2. //*[@id="root"]/div/div[2]/div[2]/div[2]                  - поле/выпадающий список "Срок аренды"(стрелка);
3. //*[@id="root"]/div/div[2]/div[2]/div[2]/div[2]/div[3]    - элемент "трое суток" в выпадающем списке "Срок аренды";
4. input#black.Checkbox_Input__14A2w                         - чекбокс "Чёрная жемчужина";
5. input#grey.Checkbox_Input__14A2w                          - чекбокс "Серая безисходность";
6. //*[@id="root"]/div/div[2]/div[2]/div[4]/input            - поле "Комментарий для курьера";
7. //*[@id="root"]/div/div[2]/div[3]/button[2]               - кнопка "Заказать" под формой заказа;
8. button.Button_Button__ra12g.Button_Middle__1CSJM.Button_Inverted__3IF-i - кнопка "Назад" под формой заказа;
9.  //*[@id="root"]/div/div[2]/div[5]                        - всплывающее окно "Хотите оформить заказ?"
10. //*[@id="root"]/div/div[2]/div[5]/div[2]/button[2]       - кнопка "Да" в окошке "Хотите оформить заказ?";
11. //*[@id="root"]/div/div[2]/div[5]/div[2]/button[1]       - кнопка "НЕТ" в окошке "Хотите оформить заказ?";
12. div.Order_Content__bmtHS                                 - локатор окна "Для кого самокат";
13. body                                                     - локатор страницы "Про аренду";
14. /html/body/div/div/div[2]/div[5]                         - окошко "ЗАКАЗ ОФОРМЛЕН";
15. /html/body/div/div/div[2]/div[5]/div[2]/button           - кнопка "ПОСМОТРЕТЬ СТАТУС" в окошке "Заказ оформлен";
 */

// страница: "Про аренду"
public class AboutRentPage {
    //поле выбора даты: "Когда привезти самокат"
    private static final By DATE_PICKER_FIELD = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input");

    //поле/выпадающий список "Срок аренды"(стрелка)
    private static final By CHOOSE_RENT_PERIOD_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]");

    //элемент "трое суток" в выпадающем списке "Срок аренды"
    private static final By CHOOSE_ELEMENT_IN_DROPDOWN_MENU_RENT_PERIOD =
            By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]");

    //чекбокс "Чёрная жемчужина"
    private static final By BLACK_SCOOTER_CHECKBOX = By.cssSelector("input#black.Checkbox_Input__14A2w");

    //чекбокс "Серая безисходность"
    private static final By GRAY_SCOOTER_CHECKBOX = By.cssSelector("input#grey.Checkbox_Input__14A2w");

    //поле "Комментарий для курьера"
    private static final By COMMENT_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");

    //кнопка "Заказать" под формой заказа
    private static final By ORDER_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    //кнопка "Назад" под формой заказа
    private static final By BACK_BUTTON = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM.Button_Inverted__3IF-i");

    //всплывающее окно "Хотите оформить заказ?"
    private static final By WONT_YOU_PLACE_AN_ORDER_WINDOW = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]");

    //кнопка "Да" в окошке "Хотите оформить заказ?"
    private static final By YES_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    //кнопка "Нет" в окошке "Хотите оформить заказ?"
    private static final By NO_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[1]");

    // локатор окна "Для кого самокат"
    private static final By ORDER_CONTENT = By.cssSelector("div.Order_Content__bmtHS");

    //локатор страницы "Про аренду"
    private static final By ABOUT_RENT_PAGE = By.cssSelector("body");

    //окошко "ЗАКАЗ ОФОРМЛЕН"
    private static final By ORDER_IS_PROCESSED = By.xpath("/html/body/div/div/div[2]/div[5]");

    //кнопка "ПОСМОТРЕТЬ СТАТУС" в окошке "Заказ оформлен"
    private static final By STATUS_ORDER_BUTTON = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button");

    private final WebDriver driver;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод, заполняющий  поле "Когда привезти самокат"
    public void checkInputDateField(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(DATE_PICKER_FIELD));
        WebElement inputDate = driver.findElement(DATE_PICKER_FIELD);
        inputDate.click();
        inputDate.clear();
        inputDate.sendKeys(date);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(DATE_PICKER_FIELD));
        inputDate.sendKeys(Keys.RETURN);
    }

    //метод заполняет поле "Срок аренды"
    public void chooseRentPeriod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(CHOOSE_RENT_PERIOD_FIELD));
        WebElement chooseRentPeriod = driver.findElement(CHOOSE_RENT_PERIOD_FIELD);
        chooseRentPeriod.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(CHOOSE_ELEMENT_IN_DROPDOWN_MENU_RENT_PERIOD));
        driver.findElement(CHOOSE_ELEMENT_IN_DROPDOWN_MENU_RENT_PERIOD).click();
    }

    // метод, выбирающий в самокат черного цвета в поле "Цвет самоката"
    public void chooseScooterColourBlack() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.elementToBeClickable(BLACK_SCOOTER_CHECKBOX));
        driver.findElement(BLACK_SCOOTER_CHECKBOX).click();
    }

    // метод, выбирающий  самокат серого цвета в поле "Цвет самоката"
    public void chooseScooterColourGray() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.elementToBeClickable(GRAY_SCOOTER_CHECKBOX));
        driver.findElement(GRAY_SCOOTER_CHECKBOX).click();
    }

    // метод заполняет поле "Комментарии для курьера"
    public void inputTextInCommentField(String comment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(COMMENT_FIELD));
        WebElement commentText = driver.findElement(COMMENT_FIELD);
        commentText.click();
        commentText.clear();
        commentText.sendKeys(comment);
        commentText.getText();
    }

    // метод кликает на кнопку "Заказать"
    public void clickOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON));
        driver.findElement(ORDER_BUTTON).click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.elementToBeClickable(WONT_YOU_PLACE_AN_ORDER_WINDOW));  //открывается окно "Хотите оформиь заказ?"
        driver.findElement(WONT_YOU_PLACE_AN_ORDER_WINDOW).isDisplayed();
    }

    // метод кликает на кнопку "Назад"
    public void clickBackButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(BACK_BUTTON));
        driver.findElement(BACK_BUTTON).click();
        driver.findElement(ORDER_CONTENT).isDisplayed(); //открывается окно "Для кого самокат"
    }

    //метод описывает работу кнопки "Да" в всплывающем окне "Хотите оформить заказ"
    public void clickYesButtonInOrderWindow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(YES_BUTTON));
        driver.findElement(YES_BUTTON).click();
    }

    //метод, описываеющий работу кнопки "НЕТ" в всплывающем окошке "Хотите оформить заказ"
    public void clickNoButtonInOrderWindow() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.elementToBeClickable(NO_BUTTON));
        driver.findElement(NO_BUTTON).click();
        driver.findElement(ABOUT_RENT_PAGE).isDisplayed();    // возврат на страницу "Про аренду"
    }

    // проверка открылось ли всплывающее окошко "Заказ оформлен"
    public void checkOrderIsProcessedWindowIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_IS_PROCESSED));
        WebElement orderStatusWindow = driver.findElement(ORDER_IS_PROCESSED);
        orderStatusWindow.isDisplayed();
    }

    //проверка работы кнопки "ПРОВЕРИТЬ СТАТУС" в окошке "Заказ оформлен"
    public void checkOrderStatusButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(STATUS_ORDER_BUTTON));
        WebElement orderStatusWindow = driver.findElement(STATUS_ORDER_BUTTON);
        orderStatusWindow.click();
    }
}






