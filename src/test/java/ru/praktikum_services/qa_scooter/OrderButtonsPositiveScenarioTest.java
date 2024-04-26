package ru.praktikum_services.qa_scooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum_services.qa_scooter.main.WebDriverFactory;
import ru.praktikum_services.qa_scooter.pageobject.MainPage;
import ru.praktikum_services.qa_scooter.pageobject.OrderPage;
import ru.praktikum_services.qa_scooter.pageobject.RentPage;

public class OrderButtonsPositiveScenarioTest {
    private static final String BROWSER = "chrome";
    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void createOrderHeaderButtonTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.confirmCoockieClick();
        mainPage.headerOrderButtonClick();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerInfo(
                "Филлип",
                "Киркоров",
                "Кутузовский, 47к2, 12",
                "Кутузовская",
                "89124567733");
        orderPage.nextButtonClick();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentPageData(
                "22.04.2024",
                "Вперед самокаты!");

        rentPage.createOrderButtonClick();
        rentPage.orderYesButtonClick();
        rentPage.checkOrderCreation();
    }

    @Test
    public void createOrderButtonTest(){
        MainPage mainPage = new MainPage(webDriver);
        mainPage.confirmCoockieClick();
        mainPage.orderButtonClick();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerInfo(
                "Летун",
                "Космический",
                "Ленина, 23к1, 12",
                "Аэропорт",
                "89115673445");
        orderPage.nextButtonClick();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.fillRentPageData(
                "25.04.2024",
                "Если б мишки были пчелами...");

        rentPage.createOrderButtonClick();
        rentPage.orderYesButtonClick();
        rentPage.checkOrderCreation();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
}
