package ru.praktikum_services.qa_scooter.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    private final WebDriver webDriver;

    //локаторы для страницы данных аренды
    private By dateInputLocator =
            By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By rentPeriodInputLocator =
            By.xpath("//div[text()='* Срок аренды']");
    private By rentPeriodItemLocator =
            By.xpath("//div[text()='четверо суток']");
    private By scooterColorBlackCheckboxLocator =
            By.xpath("//input[@id='black']");
    private By commentInputLocator =
            By.xpath("//input[@placeholder='Комментарий для курьера']");
    private By createOrderButtonLocator =
            By.xpath("//div[contains(@class, 'Order')]//button[text()='Заказать']");
    private By orderYesButtonLocator =
            By.xpath("//div[contains(@class, 'Order')]//button[text()='Да']");

    //конструктор класса
    public RentPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //Метод заполнения данных аренды
    public void fillRentPageData(String inputDate, String inputComment){
        webDriver.findElement(dateInputLocator).sendKeys(inputDate, Keys.ENTER);
        webDriver.findElement(rentPeriodInputLocator).click();
        webDriver.findElement(rentPeriodItemLocator).click();
        webDriver.findElement(scooterColorBlackCheckboxLocator).click();
        webDriver.findElement(commentInputLocator).sendKeys(inputComment);

    }

    //метод клика по кнопке "Заказать"
    public void createOrderButtonClick(){
        webDriver.findElement(createOrderButtonLocator).click();
    }

    //метод клика по кнопке "Да"
    public void orderYesButtonClick(){
        webDriver.findElement(orderYesButtonLocator).click();
    }

}
