package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.CarritoPage;
import utils.DriverFactory;

public class CarritoSteps {

    WebDriver driver = DriverFactory.getDriver();
    CarritoPage carritoPage = new CarritoPage(driver);

    @And("presiona View Cart")
    public void presionaBotonViewCart() {
        CarritoPage carritoPage = new CarritoPage(driver);
        carritoPage.presionaBotonViewCart();
        DriverFactory.takeScreenshot(driver, "CarritoSteps_boton_view.png");
    }

    @And("valida que el {string} seleccionado se encuentre en el carrito de compras")
    public void validarProductoEnCarrito(String producto) {
        CarritoPage carritoPage = new CarritoPage(driver);
        boolean estaPresente = carritoPage.validarProductoEnCarrito(producto);
        Assert.assertTrue("El producto " + producto + " no está en el carrito", estaPresente);
        DriverFactory.takeScreenshot(driver, "CarritoSteps_validar_producto.png");
    }

    @And("remueve el iPhone del carrito de compras")
    public void remueveProductoDelCarrito() {
        CarritoPage carritoPage = new CarritoPage(driver);
        carritoPage.eliminarProductoDelCarrito();
        DriverFactory.takeScreenshot(driver, "CarritoSteps_remueve.png");
    }

    @Then("entonces valido que no este el iPhone {string}")
    public void validoQueCarritoEsteVacio(String mensajeEsperado) {
        CarritoPage carritoPage = new CarritoPage(driver);
        String mensajeActual = carritoPage.obtenerMensajeCarritoVacio();
        Assert.assertEquals("El carrito no está vacío como se esperaba", mensajeEsperado, mensajeActual);
        DriverFactory.takeScreenshot(driver, "CarritoSteps_carrito_vacio.png");
    }



}
