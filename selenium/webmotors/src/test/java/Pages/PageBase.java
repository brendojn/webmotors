package Pages;

import static com.codeborne.selenide.Selenide.$;

import Configuration.DriverFactory;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {

    public void checkElement(String element) {
        Selenide.$(By.cssSelector(element)).shouldBe(Condition.visible);
    }

    public void clickElement(String element) {
        Selenide.$(By.cssSelector(element)).click();
    }

    public void fillElement(String element, String value) {
        Selenide.$(By.cssSelector(element)).setValue(value);
    }

    public String getText(String element) {
        return Selenide.$(By.cssSelector(element)).text();
    }

    public void closeLocalSearch() {
            this.checkElement("div[class*=close]");
            this.clickElement("div[class*=close]");

    }
}
