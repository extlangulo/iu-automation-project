package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pageObjects.ProductPage;
import utils.DriverFactory;

public class ProductoSteps {

    WebDriver driver = DriverFactory.getDriver();
    ProductPage productoPage = new ProductPage(driver);

    @And("agrega el producto al carrito de compras")
    public void agregaElProductoAlCarritoDeCompras() {
        productoPage.agregarAlCarrito();
    }

    @And("ingresa al boton del carrito de compras")
    public void ingresaAlBotonDelCarritoDeCompras() {
        productoPage.irAlCarritoCompras();
    }

}
