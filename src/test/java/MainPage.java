import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


class MainPage {
    private WebDriver driver;
    private By howMuch = By.id("accordion__heading-0");
    private By severalScooters = By.id("accordion__heading-1");
    private By rentTime = By.id("accordion__heading-2");
    private By rentToday = By.id("accordion__heading-3");
    private By rentExtend = By.id("accordion__heading-4");
    private By charger = By.id("accordion__heading-5");
    private By cancelOrder = By.id("accordion__heading-6");
    private By mkadOrder = By.id("accordion__heading-7");
    private By textHowMuch = By.xpath("//div[@id='accordion__panel-0']/p");
    private By textSeveralScooters = By.xpath("//div[@id='accordion__panel-1']/p");
    private By textRentTime = By.xpath("//div[@id='accordion__panel-2']/p");
    private By textRentToday = By.xpath("//div[@id='accordion__panel-3']/p");
    private By textRentExtend = By.xpath("//div[@id='accordion__panel-4']/p");
    private By textCharger = By.xpath("//div[@id='accordion__panel-5']/p");
    private By textCancelOrder = By.xpath("//div[@id='accordion__panel-6']/p");
    private By textMkadOrder = By.xpath("//div[@id='accordion__panel-7']/p");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickHowMuch() {
        driver.findElement(howMuch).click();
    }

    public void clickSeveralScooters() {
        driver.findElement(severalScooters).click();
    }

    public void clickRentTime() {
        driver.findElement(rentTime).click();
    }

    public void clickRentToday() {
        driver.findElement(rentToday).click();
    }

    public void clickRentExtend() {
        driver.findElement(rentExtend).click();
    }

    public void clickCharger() {
        driver.findElement(charger).click();
    }

    public void clickCancelOrder() {
        driver.findElement(cancelOrder).click();
    }

    public void clickMkadOrder() {
        driver.findElement(mkadOrder).click();
    }

    public String getTextHowMuch() {
        return driver.findElement(textHowMuch).getText();

    }

    public String getTextSeveralScooters() {
        return driver.findElement(textSeveralScooters).getText();
    }

    public String getTextRentTime() {
        return driver.findElement(textRentTime).getText();
    }

    public String getTextRentToday() {
        return driver.findElement(textRentToday).getText();
    }

    public String getTextRentExtend() {
        return driver.findElement(textRentExtend).getText();
    }

    public String getTextCharger() {
        return driver.findElement(textCharger).getText();
    }

    public String getTextCancelOrder() {
        return driver.findElement(textCancelOrder).getText();
    }

    public String getTextMkadOrder() {
        return driver.findElement(textMkadOrder).getText();
    }
    public void scrollBeforeClick() {
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }



}



