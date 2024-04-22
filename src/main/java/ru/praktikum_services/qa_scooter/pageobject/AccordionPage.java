package ru.praktikum_services.qa_scooter.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class AccordionPage {
    private final WebDriver webDriver;

    //локаторы для раздела "Вопросы о важном"
    private final String questionsLocator = "accordion__heading-%s";
    //Локтор для ответа раздела "Вопросы о важном"
    private final String answersLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    //конструктор класса
    public AccordionPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //метод раскрытия вопроса
    public void openQuestion(int accordionListIndex) {
        WebElement element = webDriver.findElement(By.id(String.format(questionsLocator, accordionListIndex)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    //метод проверки появления ответа
    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(String.format(answersLocator, expectedAnswer)));
        new WebDriverWait(webDriver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
        return element.isDisplayed();
    }

}
