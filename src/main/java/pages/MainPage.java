import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage extends BasePage {

    private final String clickButton = ".//div[@class='accordion__button']";
    private final String answers = ".//div[@class='accordion__panel']";
    private final String cookieAcceptButton = ".//button[@id='rcc-confirm-button']";
    private final String allQuestions = ".//div[@class='accordion__item']";
    private final String upOrderButton = ".//button[@class='Button_Button__ra12g']";
    private final String middleOrderButton = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']";



    public MainPage(WebDriver driver) {
        super(driver);
    }


   public void acceptCookie () {
       driver.findElement(By.xpath(cookieAcceptButton)).click();

   }

    public List<WebElement> getQuestions() {
        return driver.findElements(By.xpath(allQuestions));
    }


    public String clickAndGetText (WebElement question) {
        WebElement arrow = question.findElement(By.xpath(clickButton));
        arrow.click();

        WebElement answer = question.findElement(By.xpath(answers));
        return answer.getText();

    }

    public boolean isAnswerDisplayed(WebElement question) {
        WebElement answer = question.findElement(By.xpath(answers));
        return answer.isDisplayed();
    }

    public void clickOnUpOrderButton () {
        driver.findElement(By.xpath(upOrderButton)).click();
    }

    public void clickOnMiddleOrderButton () {
        driver.findElement(By.xpath(middleOrderButton)).click();
    }


}
