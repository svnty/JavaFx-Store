import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class CashRegister implements ProductObserver {
  private DoubleProperty cash = new SimpleDoubleProperty();
  public final double getCash() { return cash.get(); }
    public final DoubleProperty cashProperty() { return cash; }

  public CashRegister() {
      cash.set(0.0);
  }

  public void add(double money) {
      cash.set(getCash() + money);
  }

  @Override
  public void handleSale(double amount) {
      add(amount);
  }
}
          