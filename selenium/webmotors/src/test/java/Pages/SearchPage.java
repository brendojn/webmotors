package Pages;

import Lib.Support;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends PageBase {

    WebDriver driver;

    private String filter = null;
    private String valueVehicle = null;

    public String getValueVehicle() {
        return valueVehicle;
    }

    public void setValueVehicle(String valueVehicle) {
        this.valueVehicle = valueVehicle;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void FillFilter(String filter, String value) {
        try {
            this.closeLocalSearch();
        } catch (Exception e) {
        }

        this.setFilter(filter);

        String elementYear = elementInputFilterYear();
        String[] elementsYear = Support.breakString(elementYear, " ");
        String valuesYear = Support.returnOnlyNumbers(value);

        this.fillInputYear(valuesYear, elementsYear);

    }


    public String elementInputFilterFuel() {
        return "input[id*='Gasolina e álcool']";
    }

    public String elementInputFilterYear() {
        return "input[name=anode]" + " " + "input[name=anoate]";
    }

    public String elementInputFilterPrice() {
        return "input[name=precode]" + " " + "input[name=precoate]";
    }

    public String elementInputFilterKm() {
        return "input[name=kmde]" + " " + "input[name=kmate]";
    }

    public String elementCheckNewUsed(String type) {
        return "label.Checkbox input[id=usados]";
    }

    public String elementCheckColor(String color) {
        return "#" + color;
    }

    public void fillInputYear(String values, String[] elements) {
        String value1 = values.substring(0, 4);
        String value2 = values.substring(4, 8);
        this.checkElement(elements[0]);
        this.checkElement(elements[1]);
        this.fillElement(elements[0], value1);
        this.fillElement(elements[1], value2);
    }

    public void fillInputPrice(String values, String[] elements) {
        String value1 = values.substring(0, 4);
        String value2 = values.substring(4, 10);

        this.checkElement(elements[0]);
        this.checkElement(elements[1]);
        this.fillElement(elements[0], value1);
        this.fillElement(elements[1], value2);
    }

    public String returnValueFiltered(String value) {
        String text = value.replaceAll("\\s", "-").toLowerCase();
        text = text.replaceAll("[zà-ú]", "e");

        if (this.getFilter().equals("preco")) {
            this.checkElement("a[id*='" + text + "']");
            return this.getText("a[id*='" + text + "']");
        }

        this.checkElement("#" + text);
        return this.getText("#" + text);
    }

    public String textValueVehicle() {
        return "a[rel='nofollow']:nth-child(2) strong";
    }

    public void cardVehicleClick() {
        Configuration.timeout = 20000;
        this.checkElement(textValueVehicle());
        this.setValueVehicle(Support.returnOnlyNumbers(this.getText(textValueVehicle())));

        this.clickElement(textValueVehicle());
    }
}
