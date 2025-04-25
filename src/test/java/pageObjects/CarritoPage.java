package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CarritoPage {

    WebDriver driver;

    // Constructor
    public CarritoPage(WebDriver driver) {
        this.driver = driver;
    }

    private By viewCartButton = By.cssSelector("ul.dropdown-menu.pull-right a[href*='route=checkout/cart']");
    private By tablaCarrito = By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(2) > a");
    private By botonEliminar = By.cssSelector("button[data-original-title='Remove']");
    private By mensaje = By.id("cart-total");

    public void presionaBotonViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCartButtonElement = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartButtonElement.click();
    }

    public boolean validarProductoEnCarrito(String nombreProducto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tablaCarritoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tablaCarrito));
        return tablaCarritoElement.getText().contains(nombreProducto);
    }

    public void eliminarProductoDelCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonEliminarElement = wait.until(ExpectedConditions.elementToBeClickable(
                botonEliminar));
        botonEliminarElement.click();
    }

    public String obtenerMensajeCarritoVacio() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mensaje));
        return mensajeElement.getText().trim();
    }

}
