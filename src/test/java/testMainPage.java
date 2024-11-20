import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;





public class testMainPage {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru"); // Замените на URL вашего приложения
        mainPage = new MainPage(driver);
    }

    @Test
    public void checkTextHowMuch() {

        mainPage.scrollBeforeClick();

        mainPage.clickHowMuch(); // Клик по раскрывающемуся меню


        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой."; // Ожидаемый текст
        String actualText = mainPage.getTextHowMuch();

        // Проверка
        assertEquals(expectedText, actualText);

    }

    @Test
    public void checkTextSeveralScooters() {

        mainPage.scrollBeforeClick();

        mainPage.clickSeveralScooters(); // Клик по раскрывающемуся меню


        String expectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."; // Ожидаемый текст
        String actualText = mainPage.getTextSeveralScooters();

        // Проверка
        assertEquals(expectedText, actualText);

    }

    @Test
    public void checkTextRentTime() {

        mainPage.scrollBeforeClick();

        mainPage.clickRentTime(); // Клик по раскрывающемуся меню

        String expectedText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."; // Ожидаемый текст
        String actualText = mainPage.getTextRentTime();

        // Проверка
        assertEquals(expectedText, actualText);

    }

    @Test
    public void checkTextRentToday() {

        mainPage.scrollBeforeClick();

        mainPage.clickRentToday(); // Клик по раскрывающемуся меню

        String expectedText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее."; // Ожидаемый текст
        String actualText = mainPage.getTextRentToday();

        // Проверка
        assertEquals(expectedText, actualText);

    }

    @Test
    public void checkTextRntExtend() {

        mainPage.scrollBeforeClick();

        mainPage.clickRentExtend(); // Клик по раскрывающемуся меню

        String expectedText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."; // Ожидаемый текст
        String actualText = mainPage.getTextRentExtend();

        // Проверка
        assertEquals(expectedText, actualText);

    }

    @Test
    public void checkTextCharger() {

        mainPage.scrollBeforeClick();

        mainPage.clickCharger(); // Клик по раскрывающемуся меню

        String expectedText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."; // Ожидаемый текст
        String actualText = mainPage.getTextCharger();

        // Проверка
        assertEquals(expectedText, actualText);

    }

    @Test
    public void checkTextCancelOrder() {

        mainPage.scrollBeforeClick();

        mainPage.clickCancelOrder(); // Клик по раскрывающемуся меню

        String expectedText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."; // Ожидаемый текст
        String actualText = mainPage.getTextCancelOrder();

        // Проверка
        assertEquals(expectedText, actualText);

    }

    @Test
    public void checkMkadOrder() {

        mainPage.scrollBeforeClick();

        mainPage.clickMkadOrder(); // Клик по раскрывающемуся меню

        String expectedText = "Да, обязательно. Всем самокатов! И Москве, и Московской области."; // Ожидаемый текст
        String actualText = mainPage.getTextMkadOrder();

        // Проверка
        assertEquals(expectedText, actualText);

    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
