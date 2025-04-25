package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

import java.time.Duration;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By campoBusqueda = By.name("search");
    private By botonBuscar = By.cssSelector("button[class='btn btn-default btn-lg']");

    public void irPage() {
        driver.get("http://opencart.abstracta.us/");
    }

    public void buscarProducto(String producto) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(campoBusqueda));
        driver.findElement(campoBusqueda).sendKeys(producto);

        wait.until(ExpectedConditions.elementToBeClickable(botonBuscar));
        driver.findElement(botonBuscar).click();
    }

    public String obtenerResultadoBusqueda() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Search"));
        return driver.getTitle();
    }

}

