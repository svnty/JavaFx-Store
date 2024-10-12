import java.util.LinkedList;
import javafx.beans.property.*;

public class Product {
  private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

  private StringProperty name = new SimpleStringProperty();
  private IntegerProperty stock = new SimpleIntegerProperty();
  private DoubleProperty price = new SimpleDoubleProperty(); 

  public final String getName() { return this.name.get(); }
  public final StringProperty nameProperty() { return this.name; }
  public final int getStock() { return this.stock.get(); }
  public final IntegerProperty stockProperty() { return this.stock; }
  public final double getPrice() { return this.price.get(); }
  public final DoubleProperty priceProperty() { return this.price; }

  public Product(String name, int stock, double price) {
      this.name.set(name);
      this.stock.set(stock);
      this.price.set(price);
  }

  public void sell(int n) {
      stock.set(getStock() - n);
      double money = n * getPrice();
      for (ProductObserver observer : observers)
          observer.handleSale(money);
  }

  public void restock(int n) {
      stock.set(getStock() + n);
  }

  public boolean has(int n) {
      return getStock() >= n;
  }

  public void addProductObserver(ProductObserver observer) {
      observers.add(observer);
  }

  @Override
  public String toString() {
      return stock + " " + name + " at $" + price;
  }
}
