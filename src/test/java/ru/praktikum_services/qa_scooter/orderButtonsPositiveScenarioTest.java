package ru.praktikum_services.qa_scooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.pageobject.MainPage;
import ru.praktikum_services.qa_scooter.pageobject.OrderPage;
import ru.praktikum_services.qa_scooter.pageobject.RentPage;

public class OrderButtonsPositiveScenarioTest {
    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void createOrderHeaderButtonTest() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.headerOrderButtonClick();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustomerInfo(
                "Филлип",
                "Киркоров",
                "Абельмана, 47к2",
                "Кутузовская",
                "89124567733");
        orderPage.nextButtonClick();
        orderPage.fillCustomerInfo();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.


        orderPage.fillDatePeriodInfo("02.05.2035","двое суток");
        orderPage.createOrder();
        assertTrue(orderPage.successOrderCreated());
    }

    @Test
    public void createOrderButtonTest(){

    }


    @After
    public void tearDown(){
        webDriver.quit();
    }
}
