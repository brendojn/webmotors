package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInputSearch(String brand, String model ) {
        this.checkElement(elementInputSearchBar());
        fillElement(elementInputSearchBar(), brand + " " + model);
        clickElement(elementSelectSearch());
    }

    public String elementInputSearchBar() {
        return "#searchBar";
    }

    public String elementSelectSearch() {
        return ".SearchBar__results";
    }

}
