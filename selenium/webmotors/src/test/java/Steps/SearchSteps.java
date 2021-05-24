package Steps;

import Pages.HomePage;
import Pages.SearchPage;
import com.codeborne.selenide.Selenide;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchSteps extends AbstractSteps {

    WebDriver driver;
    HomePage homePage = new HomePage(driver);
    SearchPage searchPage = new SearchPage(driver);


    @Given("^que acesso o site da webmotors$")
    public void queAcessoOSiteDaWebmotors() {
        Selenide.open("https://webmotors.com.br/");
    }

    @And("^preencho a \"([^\"]*)\" e \"([^\"]*)\" no formulário de pesquisa$")
    public void preenchoAENoFormulárioDePesquisa(String brand, String model) throws Throwable {
        homePage.fillInputSearch(brand, model);
    }

    @When("^preencho o \"([^\"]*)\" com o \"([^\"]*)\"$")
    public void preenchoOComO(String filter, String value) throws Throwable {
        searchPage.FillFilter(filter, value);
    }

    @Then("^deverá aparecer na descrição dos itens o \"([^\"]*)\"$")
    public void deveráAparecerNaDescriçãoDosItensO(String value) throws Throwable {
        Assert.assertEquals(value, searchPage.returnValueFiltered(value));
    }

}
