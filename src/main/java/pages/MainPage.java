package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class MainPage extends BasePage {

    private final String cookieAcceptButton = ".//button[@id='rcc-confirm-button']";
    private final String upOrderButton = ".//button[@class='Button_Button__ra12g']";
    private final String middleOrderButton = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']";
    private String question = ".//div[@id = 'accordion__heading-%d']";
    private String answer = ".//div[@data-accordion-component = 'AccordionItemPanel']/p[text()='%s']";

   public void getClickOnQuestion (int questionIndex) {
        driver.findElement(By.xpath(String.format(question, questionIndex))).click();
   }

   public String getTextOfAnswer (String answerValue) {
       return driver.findElement(By.xpath(String.format(answer, answerValue))).getText();
   }


    public MainPage(WebDriver driver) {
        super(driver);
    }


   public void acceptCookie () {
       driver.findElement(By.xpath(cookieAcceptButton)).click();

   }


    public void clickOnUpOrderButton () {
        driver.findElement(By.xpath(upOrderButton)).click();
    }

    public void clickOnMiddleOrderButton () {
        driver.findElement(By.xpath(middleOrderButton)).click();
    }


}
