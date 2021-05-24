package Pages;

import Lib.Support;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.switchTo;

public class BuyPage extends PageBase {

    WebDriver driver;
    public BuyPage(WebDriver driver) {
        this.driver = driver;
    }

    public String returnValueVehicle() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switchTo().window(1);

        this.clickModal();

        this.checkElement(elementBuyPrice());
        return Support.returnOnlyNumbers(getText(elementBuyPrice()));
    }

    public String elementBuyPrice(){
        return "#vehicleSendProposalPrice";
    }


    public void clickModal() {

        try {
            this.checkElement(".explanation-financing  button");
            this.clickElement(".explanation-financing  button");
        } catch (Exception e) {
        }
    }
}