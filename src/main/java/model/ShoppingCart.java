package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
  private List<Product> items;

  public ShoppingCart() {
    this.items = new ArrayList<>();
  }

  public void addProduct(Product product) {
    if (product == null) {
      throw new IllegalArgumentException("Product cannot be null");
    }
    items.add(product);
  }

  public void removeProduct(Product product) {
    if (this.items.contains(product)) {
      this.items.remove(product);
    } else {
      throw new IllegalArgumentException("Product doesn't exist.");
    }
  }

  public double getTotalPrice() {
    return items.stream().mapToDouble(Product::getPrice).sum();
  }

  public int getItemCount() {
    return items.size();
  }

  public void clearCart() {
    items.clear();
  }
}
