import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@RunWith(Parameterized.class)
public class testOrderPage {
    private WebDriver driver;
    private orderPage OrderPage;

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String rentDuration;
    private final String rentPeriod;

    public testOrderPage(String firstName, String lastName, String address, String subwayStation, String phoneNumber, String rentDuration, String rentPeriod) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.rentDuration = rentDuration;
        this.rentPeriod = rentPeriod;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                { "Максим", "Максимов", "Советская 19б", "Бульвар Рокоссовского", "78005553535", "28", "сутки" },
                { "Иван", "Иванов", "Комсомольская 19б", "Сокольники", "88005553535", "28", "сутки" },

        };
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru"); // Замените на URL вашего приложения
        OrderPage = new orderPage(driver);
    }

    @Test
    public void testOrderFormButtonOnTop() {
        OrderPage.clickOrderButtonOnTop();
        OrderPage.fillAndSubmitOrderForm(firstName, lastName, address, subwayStation, phoneNumber, rentDuration, rentPeriod);

    }

    @Test
    public void testOrderFormButtonBelow() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement buttonOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Home_FinishButton__1_cWm']//button[contains(text(), 'Заказать')]")));

        // Прокрутка к элементу
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonOrder);

        OrderPage.clickOrderButtonBellow();
        OrderPage.fillAndSubmitOrderForm(firstName, lastName, address, subwayStation, phoneNumber, rentDuration, rentPeriod);

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}