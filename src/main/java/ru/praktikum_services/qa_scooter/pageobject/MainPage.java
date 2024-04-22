package ru.praktikum_services.qa_scooter.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver webDriver;

    //локаторы кнопок "Заказать"
    private By headerOrderButtonLocator =
            By.xpath("//div[contains(@class,'Header')]/button[text()='Заказать']");
    private By oderButtonLocator =
            By.xpath("//div[contains(@class, 'FinishButton')/button[text()='Заказать']]");

    //конструктор класса
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //клик по кнопке заказать из хедера
    public void headerOrderButtonClick() {
        webDriver.findElement(headerOrderButtonLocator).click();
    }

    //клик по кнопке заказать
    public void orderButtonClick() {
        WebElement element = webDriver.findElement(oderButtonLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(oderButtonLocator).click();
    }




}

