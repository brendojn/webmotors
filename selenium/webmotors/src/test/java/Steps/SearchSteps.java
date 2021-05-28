package Steps;

import Pages.HomePage;
import Pages.SearchPage;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.E;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchSteps extends AbstractSteps {

    WebDriver driver;
    HomePage homePage = new HomePage(driver);
    SearchPage searchPage = new SearchPage(driver);

    @Dado("que acesso o site da webmotors")
    public void que_acesso_o_site_da_webmotors() {
        Selenide.open("https://webmotors.com.br/");
    }

    @E("preencho a {string} e {string} no formulário de pesquisa")
    public void preencho_a_e_no_formulário_de_pesquisa(String brand, String model) {
        homePage.fillInputSearch(brand, model);
    }

    @Quando("preencho o {string} com o {string}")
    public void preencho_o_com_o(String filter, String value) {
        searchPage.FillFilter(filter, value);
    }

    @Entao("deverá aparecer na descrição dos itens o {string}")
    public void deveráAparecerNaDescriçãoDosItensO(String value) {
        Assert.assertEquals(value, searchPage.returnValueFiltered(value));
    }
}
