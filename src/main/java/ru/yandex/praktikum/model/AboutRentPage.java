package ru.yandex.praktikum.model;

import org.junit.Assert;
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
6. //input[@type='text'][@placeholder='Комментарий для курьера'] - поле "Комментарий для курьера";
7. //*[@id="root"]/div/div[2]/div[3]/button[2]               - кнопка "Заказать" под формой заказа;
8. //*[@id="root"]/div/div[2]/div[5]                        - всплывающее окно "Хотите оформить заказ?"
9. //*[@id="root"]/div/div[2]/div[5]/div[2]/button[2]       - кнопка "Да" в окошке "Хотите оформить заказ?";
10. //*[@id="root"]/div/div[2]/div[5]/div[2]/button[1]       - кнопка "НЕТ" в окошке "Хотите оформить заказ?";
11. div.Order_Content__bmtHS                                 - локатор окна "Для кого самокат";
12. div.Order_Modal__YZ-d3                                   - окошко "ЗАКАЗ ОФОРМЛЕН";
 */

// страница: "Про аренду"
public class AboutRentPage {
    //поле выбора даты: "Когда привезти самокат"
    private final By DATE_PICKER_FIELD = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input");

    //поле/выпадающий список "Срок аренды"(стрелка)
    private final By CHOOSE_RENT_PERIOD_FIELD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]");

    //элемент "трое суток" в выпадающем списке "Срок аренды"
    private final By CHOOSE_ELEMENT_IN_DROPDOWN_MENU_RENT_PERIOD = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]");

    //чекбокс "Чёрная жемчужина"
    private final By BLACK_SCOOTER_CHECKBOX = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[1]");

    //чекбокс "Серая безисходность"
    private final By GRAY_SCOOTER_CHECKBOX = By.cssSelector("input#grey.Checkbox_Input__14A2w");

    //поле "Комментарий для курьера"
    private final By COMMENT_FIELD = By.xpath("//input[@type='text'][@placeholder='Комментарий для курьера']"); //xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");

    //кнопка "Заказать" под формой заказа
    private final By ORDER_BUTTON = By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");

    //всплывающее окно "Хотите оформить заказ?"
    private final By WONT_YOU_PLACE_AN_ORDER_WINDOW = By.cssSelector("div.Order_Modal__YZ-d3");

    //кнопка "Да" в окошке "Хотите оформить заказ?"
    private final By YES_BUTTON = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM"); //cssSelector("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

    //окошко "ЗАКАЗ ОФОРМЛЕН"
    private final By ORDER_IS_PROCESSED = By.cssSelector("div.Order_Modal__YZ-d3");

    private final WebDriver driver;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод, заполняющий  поле "Когда привезти самокат"
    public void inputDateField(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(DATE_PICKER_FIELD));
        WebElement inputDate = driver.findElement(DATE_PICKER_FIELD);
        inputDate.click();
        inputDate.clear();
        inputDate.sendKeys(date);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(DATE_PICKER_FIELD));
        inputDate.sendKeys(Keys.RETURN);
        Assert.assertEquals(date, inputDate.getAttribute("value"));
    }

    //метод заполняет поле "Срок аренды"
    public void chooseRentPeriod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(CHOOSE_RENT_PERIOD_FIELD));
        WebElement chooseRentPeriod = driver.findElement(CHOOSE_RENT_PERIOD_FIELD);
        chooseRentPeriod.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(CHOOSE_ELEMENT_IN_DROPDOWN_MENU_RENT_PERIOD));
        WebElement rentPeriod = driver.findElement(CHOOSE_ELEMENT_IN_DROPDOWN_MENU_RENT_PERIOD);
        rentPeriod.click();
    }

    // метод, выбирающий в самокат черного цвета в поле "Цвет самоката"
    public void chooseScooterColourBlack() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(BLACK_SCOOTER_CHECKBOX));
        WebElement blackScooter = driver.findElement(BLACK_SCOOTER_CHECKBOX);
        blackScooter.click();
      //  Assert.assertTrue(blackScooter.isSelected());
    }

    // метод, выбирающий  самокат серого цвета в поле "Цвет самоката"
    public void chooseScooterColourGray() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(GRAY_SCOOTER_CHECKBOX));
        WebElement grayScooter = driver.findElement(GRAY_SCOOTER_CHECKBOX);
        grayScooter.click();
        Assert.assertTrue(grayScooter.isSelected());
    }

    // метод заполняет поле "Комментарии для курьера"
    public void inputTextInCommentField(String comment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(COMMENT_FIELD));
        WebElement commentText = driver.findElement(COMMENT_FIELD);
        commentText.click();
        commentText.clear();
        commentText.sendKeys(comment);
        Assert.assertEquals(comment, commentText.getAttribute("value"));
    }

    // метод кликает на кнопку "Заказать" под формой заказа
    public void clickOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON));
        driver.findElement(ORDER_BUTTON).click();
    }

    //проверить, что после нажатия на кнопку "Заказать" открылось окошко "Хотите оформить заказ"
    public void checkWontYouPlaceAnOrderWidowIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(WONT_YOU_PLACE_AN_ORDER_WINDOW));
        Assert.assertTrue(driver.findElement(WONT_YOU_PLACE_AN_ORDER_WINDOW).isDisplayed());
    }

    //метод кликает на кнопку "Да" в всплывающем окне "Хотите оформить заказ"
    public void clickYesButtonInOrderWindow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(YES_BUTTON));
        driver.findElement(YES_BUTTON).click();
    }

    // проверка открылось ли всплывающее окошко "Заказ оформлен"
    public void checkOrderIsProcessedWindowIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ORDER_IS_PROCESSED));
        Assert.assertTrue(driver.findElement(ORDER_IS_PROCESSED).isDisplayed());
    }
}






