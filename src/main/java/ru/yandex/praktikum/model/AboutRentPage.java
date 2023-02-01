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
    private final By datePickerField = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input");

    //поле/выпадающий список "Срок аренды"(стрелка)
    private final By chooseRentElementPeriodField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]");

    //элемент "трое суток" в выпадающем списке "Срок аренды"
    private final By chooseElementInDropdownMenuRentPeriod = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[3]");

    //чекбокс "Чёрная жемчужина"
    private final By blackScooterCheckbox = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[1]");

    //чекбокс "Серая безисходность"
    private final By grayScooterCheckbox = By.cssSelector("input#grey.Checkbox_Input__14A2w");

    //поле "Комментарий для курьера"
    private final By commentField = By.xpath("//input[@type='text'][@placeholder='Комментарий для курьера']"); //xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");

    //кнопка "Заказать" под формой заказа
    private final By orderButton = By.cssSelector("button.Button_Middle__1CSJM:nth-child(2)");

    //всплывающее окно "Хотите оформить заказ?"
    private final By wontYouPlaceAnOrderWindow = By.cssSelector("div.Order_Modal__YZ-d3");

    //кнопка "Да" в окошке "Хотите оформить заказ?"
    private final By yesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");

    //окошко "ЗАКАЗ ОФОРМЛЕН"
    private final By orderIsProcessedWindow = By.xpath("//*[text()='Заказ оформлен']");

    //текст в окошке "Заказ оформлен"
    private final By textInWindowOrderIsProcessed = By.xpath("//*[text()='Заказ оформлен']"); //cssSelector("div.Order_ModalHeader__3FDaJ");

    private final WebDriver driver;

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод, заполняющий  поле "Когда привезти самокат"
    public void inputDateField(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(datePickerField));
        WebElement inputDate = driver.findElement(datePickerField);
        inputDate.click();
        inputDate.clear();
        inputDate.sendKeys(date);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(datePickerField));
        inputDate.sendKeys(Keys.RETURN);
    }

    //метод заполняет поле "Срок аренды"
    public void chooseRentPeriod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(chooseRentElementPeriodField));
        WebElement chooseRentPeriod = driver.findElement(chooseRentElementPeriodField);
        chooseRentPeriod.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(chooseElementInDropdownMenuRentPeriod));
        WebElement rentPeriod = driver.findElement(chooseElementInDropdownMenuRentPeriod);
        rentPeriod.click();
    }

    // метод, выбирающий в самокат черного цвета в поле "Цвет самоката"
    public void chooseScooterColourBlack() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(blackScooterCheckbox));
        WebElement blackScooter = driver.findElement(blackScooterCheckbox);
        blackScooter.click();
    }

    // метод, выбирающий  самокат серого цвета в поле "Цвет самоката"
    public void chooseScooterColourGray() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(grayScooterCheckbox));
        WebElement grayScooter = driver.findElement(grayScooterCheckbox);
        grayScooter.click();
    }

    // метод заполняет поле "Комментарии для курьера"
    public void inputTextInCommentField(String comment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(commentField));
        WebElement commentText = driver.findElement(commentField);
        commentText.click();
        commentText.clear();
        commentText.sendKeys(comment);
    }

    // метод кликает на кнопку "Заказать" под формой заказа
    public void clickOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        driver.findElement(orderButton).click();
    }

    //проверить, что после нажатия на кнопку "Заказать" открылось окошко "Хотите оформить заказ"
    public void checkWontYouPlaceAnOrderWidowIsOpen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(wontYouPlaceAnOrderWindow));
        Assert.assertTrue(driver.findElement(wontYouPlaceAnOrderWindow).isDisplayed());
    }

    //метод кликает на кнопку "Да" в всплывающем окне "Хотите оформить заказ"
    public void clickYesButtonInOrderWindow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        driver.findElement(yesButton).click();
    }

    //проверяем открылось ли окошко "Заказ оформлен"
    public void checkOrderIsProcessedWindowIsOpen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderIsProcessedWindow));
        Assert.assertTrue(driver.findElement(orderIsProcessedWindow).isDisplayed());
    }

    // проверка соответствует ли текст в всплывающем окошке "Заказ оформлен", ожидаемому
    public void checkTextInOrderIsProcessedWindow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textInWindowOrderIsProcessed));
        final String expectedText = "^Заказ оформлен\\nНомер заказа: \\d*. Запишите его:\n" +
                "пригодится, чтобы отслеживать статус$";
        WebElement actualText = driver.findElement(textInWindowOrderIsProcessed);
        Assert.assertTrue (actualText.getText().matches(expectedText));
    }
}






