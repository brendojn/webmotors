package Steps;

import Pages.BuyPage;
import Pages.SearchPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BuySteps extends AbstractSteps{

    WebDriver driver;
    SearchPage searchPage = new SearchPage(driver);
    BuyPage buyPage = new BuyPage(driver);


    @When("^seleciono um veículo$")
    public void selecionoUmVeículo() {
        searchPage.cardVehicleClick();
    }

    @Then("^o valor que consta na página de pesquisa deverá ser igual da página de compra$")
    public void oValorQueConstaNaPáginaDePesquisaDeveráSerIgualDaPáginaDeCompra() {
        Assert.assertEquals(searchPage.getValueVehicle(), buyPage.returnValueVehicle());
    }
}
