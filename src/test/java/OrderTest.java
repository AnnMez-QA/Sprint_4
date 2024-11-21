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
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AboutCustomerPage;
import pages.AboutRentPage;
import pages.ConfirmationWindow;
import pages.MainPage;

@RunWith(Parameterized.class)
public class OrderTest {
    WebDriver driver;

    private String name;
    private String surname;
    private String address;
    private String number;
    private String comment;
    private String nameOfOrderButton;

    public OrderTest (String name, String surname, String address, String number, String comment, String nameOfOrderButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.comment = comment;
        this.nameOfOrderButton = nameOfOrderButton;


    }

    @Before
    public void setUp() {
        //driver = new FirefoxDriver(); // для Firefox
        driver = new ChromeDriver(); // для Chrome
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                { "Пуп", "Иванович", "ул.Дежурная, 4", "89056778999", "привезите быстро", "Вверхняя кнопка Заказать"},
                { "Инесса", "Гнидова", "пр.Буденного 12", "89056778991", "не звоните", "Нижняя кнопка Заказать"},
        };
    }

    @Test
    public void orderTest () {
        MainPage objMainPage = new MainPage(driver);

        if ("Вверхняя кнопка Заказать".equals(nameOfOrderButton)) {
            objMainPage.clickOnUpOrderButton();
        } else if ("Нижняя кнопка Заказать".equals(nameOfOrderButton)) {
            objMainPage.acceptCookie();
            WebElement element = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            objMainPage.clickOnMiddleOrderButton();
        }

        AboutCustomerPage objAboutCustomerPage = new AboutCustomerPage(driver);
        objAboutCustomerPage.waitForPageTitleToBeVisible();
        objAboutCustomerPage.fillCustomerData(name, surname, address, number);
        objAboutCustomerPage.fillMetroData();
        objAboutCustomerPage.clickOnNextButton();

        AboutRentPage objAboutRentPage = new AboutRentPage(driver);
        objAboutRentPage.waitForPageTitleToBeVisible();
        objAboutRentPage.fillRentData(comment);
        objAboutRentPage.clickOnOrderButton();

        ConfirmationWindow objConfirmationWindow = new ConfirmationWindow(driver);
        objConfirmationWindow.waitForWindowToBeVisible();
        objConfirmationWindow.clickOnYesButton();
        objConfirmationWindow.waitForTextOfSuccessToBeVisible();
        objConfirmationWindow.verifyOrderSuccess();
    }

    @After
    public void teardown() {
        // Закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
