package Steps;

import Configuration.DriverFactory;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class AbstractSteps {

    @Before
    public void open(){
        WebDriver driver = DriverFactory.getDriver();
    }

    @After
    public void quit(){
        DriverFactory.kill();
    }

}
