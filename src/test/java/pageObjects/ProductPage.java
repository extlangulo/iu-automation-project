package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By botonAgregar = By.id("button-cart");
    private By botonCarrito = By.id("cart-total");


    public void agregarAlCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonAgregarElement = wait.until(ExpectedConditions.elementToBeClickable(botonAgregar));
        botonAgregarElement.click();
    }

    public void irAlCarritoCompras() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonCarritoElement = wait.until(ExpectedConditions.elementToBeClickable(botonCarrito));
        botonCarritoElement.click();
    }

}
