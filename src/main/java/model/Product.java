package model;

public class Product {
  private String name;
  private double price;

  public Product(String name, double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String toString() {
    return this.name + ": " + this.price + "€";
  }
}
