@Compra_OpenCart
Feature: Comprar un producto en OpenCart

  Scenario: Agregar y remover iPhone del carrito
    Given usuario abre la web de OpenCart
    When busca el producto "iPhone"
    Then entonces validado el resultado de la busqueda "Search - iPhone"
    And selecciona el primer producto
    And agrega el producto al carrito de compras
    And ingresa al boton del carrito de compras
    And presiona View Cart
    And valida que el "iPhone" seleccionado se encuentre en el carrito de compras
    And remueve el iPhone del carrito de compras
    Then entonces valido que no este el iPhone "0 item(s) - $0.00"
