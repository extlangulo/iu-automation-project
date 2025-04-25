package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import utils.DriverFactory;

public class ShopSteps {
    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("usuario abre la web de OpenCart")
    public void usuarioAbreLaWebDeOpenCart() {
        homePage.irPage();
    }
}
