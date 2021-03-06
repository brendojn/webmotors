package Steps;

import Pages.BuyPage;
import Pages.SearchPage;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BuySteps extends AbstractSteps{

    WebDriver driver;
    SearchPage searchPage = new SearchPage(driver);
    BuyPage buyPage = new BuyPage(driver);

    @Quando("seleciono um veículo")
    public void seleciono_um_veículo() {
        searchPage.cardVehicleClick();
    }

    @Entao("o valor que consta na página de pesquisa deverá ser igual da página de compra")
    public void o_valor_que_consta_na_página_de_pesquisa_deverá_ser_igual_da_página_de_compra() {
        Assert.assertEquals(searchPage.getValueVehicle(), buyPage.returnValueVehicle());
        Selenide.closeWindow();
    }
}
