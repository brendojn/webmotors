package Pages;

import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

import Configuration.DriverFactory;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageBase {

    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegister(){
        this.checkElement("#btnNovaConta");
        this.clickElement("#btnNovaConta");
    }

    public void fillFormRegister(String name, String email, String password) {
        this.checkElement(elementInputName());
        this.fillElement(elementInputName(), name);
        this.fillElement(elementInputEmail(), email);
        this.fillElement(elementInputPassword(), password);
    }

    public String elementInputName(){
        return "#nome";
    }

    public String elementInputEmail(){
        return "#email";
    }

    public String elementInputPassword(){
        return "#senha";
    }

    public String elementTextError(){
        this.checkElement("span[class*='error show']");
        return this.getText("span[class*='error show']");
    }

}
