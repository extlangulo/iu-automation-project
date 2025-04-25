package stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import utils.DriverFactory;
import org.openqa.selenium.By;
import utils.DriverFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class BusquedaSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);

    @When("busca el producto {string}")
    public void buscaElProducto(String producto) {
        homePage.buscarProducto(producto);
        DriverFactory.takeScreenshot(driver, "BusquedaSteps_busqueda_producto.png");
    }

    @Then("entonces validado el resultado de la busqueda {string}")
    public void validaResultadoBusqueda(String resultadoEsperado) {
        String resultadoActual = homePage.obtenerResultadoBusqueda();
        assertEquals("El resultado no coincide", resultadoEsperado, resultadoActual);
        DriverFactory.takeScreenshot(driver, "BusquedaSteps_validacion_busqueda.png");
    }

    @And("selecciona el primer producto")
    public void seleccionaElPrimerProducto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement primerProducto = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".product-layout .image a"))
        );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", primerProducto);
        primerProducto.click();
        DriverFactory.takeScreenshot(driver, "producto_seleccionado.png");
    }
}
