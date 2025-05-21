package model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
  public ShoppingCart shoppingCart;

  @BeforeEach
  public void setUpShoppingCart(){
    this.shoppingCart = new ShoppingCart();
  }

  @Test
  public void testEmptyShoppingCart() {
    assertDoesNotThrow(() -> {
      new ShoppingCart();
    });

    ShoppingCart emptyShoppingCart = new ShoppingCart();
    assertEquals(0, emptyShoppingCart.getItemCount());
  }

  @Test
  public void testValidAddProduct(){
    assertDoesNotThrow(() -> {shoppingCart.addProduct(new Product("Nouveau produit", 10));});
    assertEquals(1, shoppingCart.getItemCount());
  }

  @Test
  public void testTotalPrice(){
    shoppingCart.addProduct(new Product("Nouveau produit 1", 20));
    shoppingCart.addProduct(new Product("Nouveau produit 2", 30));
    shoppingCart.addProduct(new Product("Nouveau produit 3", 100));

    assertEquals(150, shoppingCart.getTotalPrice());
  }

  @Test
  public void testInvalidAddProduct(){
    IllegalArgumentException exception =  assertThrows(IllegalArgumentException.class, () -> {shoppingCart.addProduct(null);});
    assertEquals("Product cannot be null", exception.getMessage());

    exception =  assertThrows(IllegalArgumentException.class, () -> {shoppingCart.addProduct(new Product("Produit prix négatif", -50));});
    assertEquals("Price cannot be negative", exception.getMessage());
  }

  @Test
  public void testValidRemoveProduct(){
    Product product = new Product("Nouveau produit", 10);
    shoppingCart.addProduct(product);

    assertDoesNotThrow(() -> { shoppingCart.removeProduct(product);});

    assertEquals(0, shoppingCart.getItemCount());
  }

  @Test
  public void testInvalidRemoveProduct() {
    Product product = new Product("Nouveau produit", 10);

    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> { shoppingCart.removeProduct(product);});
    assertEquals("Product doesn't exist.", exception.getMessage());
  }

  @Test
  public void testClearCart(){
    shoppingCart.addProduct(new Product("Nouveau produit 1", 20));
    shoppingCart.addProduct(new Product("Nouveau produit 2", 30));

    assertDoesNotThrow(() -> { shoppingCart.clearCart();});

    assertEquals(0, shoppingCart.getItemCount());
    assertEquals(0, shoppingCart.getTotalPrice());
  }
}
