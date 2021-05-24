package Steps;

import Pages.RegisterPage;
import com.codeborne.selenide.Selenide;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegisterSteps extends AbstractSteps {
    WebDriver driver;
    RegisterPage registerPage = new RegisterPage(driver);

    @Given("^que acesso a página de login$")
    public void queAcessoAPáginaDeLogin() {
        Selenide.open("https://login.webmotors.com.br/");
    }

    @When("^realizo o cadastro com \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"$")
    public void realizoOCadastroComE(String name, String email, String password) throws Throwable {
        registerPage.clickRegister();
        registerPage.fillFormRegister(name, email, password);
    }

    @Then("^devo obter a mensagem \"([^\"]*)\"$")
    public void devoObterAMensagem(String message) throws Throwable {
        Assert.assertEquals(message, registerPage.elementTextError());
    }
}
