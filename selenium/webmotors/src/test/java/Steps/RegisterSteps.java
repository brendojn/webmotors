package Steps;

import Pages.RegisterPage;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegisterSteps extends AbstractSteps {
    WebDriver driver;
    RegisterPage registerPage = new RegisterPage(driver);

    @Dado("que acesso a página de login")
    public void que_acesso_a_página_de_login() {
        Selenide.open("https://login.webmotors.com.br/");
    }
    @Quando("realizo o cadastro com {string}, {string} e {string}")
    public void realizo_o_cadastro_com_e(String name, String email, String password) {
        registerPage.clickRegister();
        registerPage.fillFormRegister(name, email, password);
    }

    @Entao("devo obter a mensagem {string}")
    public void devo_obter_a_mensagem(String message) {
        Assert.assertEquals(message, registerPage.elementTextError());
    }

}
