package ru.praktikum_services.qa_scooter.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final WebDriver webDriver;

    //локаторы полей страницы заполнения данных пользователя
    private final By nameInputLocator =
            By.xpath("//input[@placeholder='* Имя']");
    private final By lastnameInputLocator =
            By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInputLocator =
            By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subwayInputLocator =
            By.xpath("//div/input[@placeholder='* Станция метро']");
    private final String subwayStationTitleLocator = "//div[text()='%s']";
    private final By phoneInputLocator =
            By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButtonLocator =
            By.xpath("//div[contains(@class, 'NextButton')]/button[text()='Далее']");

    //конструктор класса
    public OrderPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //Метод заполнения данных пользователя
    public void fillCustomerInfo(String customerName, String customerLastname,
                                 String customerAddress, String stationTitle, String customerPhone){
        webDriver.findElement(nameInputLocator).sendKeys(customerName);
        webDriver.findElement(lastnameInputLocator).sendKeys(customerLastname);
        webDriver.findElement(addressInputLocator).sendKeys(customerAddress);
        webDriver.findElement(subwayInputLocator).click();
        WebElement subwayDropdown = webDriver.findElement(By.xpath(String.format(subwayStationTitleLocator, stationTitle)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", subwayDropdown);
        subwayDropdown.click();
        webDriver.findElement(phoneInputLocator).sendKeys(customerPhone);
    }

    //Клик по кнопке "Далее"
    public void nextButtonClick() {
        webDriver.findElement(nextButtonLocator).click();
    }



}
