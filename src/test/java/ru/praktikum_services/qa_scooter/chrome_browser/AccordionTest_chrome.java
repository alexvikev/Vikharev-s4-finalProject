package ru.praktikum_services.qa_scooter.chrome_browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.pageobject.AccordionPage;
import ru.praktikum_services.qa_scooter.pageobject.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AccordionTest_chrome {
    private WebDriver webDriver;
    private final int accordionListIndex;
    private final String expectedAnswer;

    public AccordionTest_chrome(int accordionListIndex, String expectedAnswer){
        this.accordionListIndex = accordionListIndex;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters (name = "{index}, accordionListIndex {0}, expectedAnswer {1}")
    public static Object[][] accordionData() {
        return new Object[][] {
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void accordionTest(){
        AccordionPage accordionPage = new AccordionPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);

        mainPage.confirmCoockieClick();
        accordionPage.openQuestion(accordionListIndex);
        Boolean actualAnswer = accordionPage.answerIsDisplayed(expectedAnswer);
        assertTrue(actualAnswer);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

}
