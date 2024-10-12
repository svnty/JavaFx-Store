public class Store {
  private CashRegister cashRegister;
  private Product product;

  public Store() {
      cashRegister = new CashRegister();
      product = new Product("Sticky tape", 200, 2.99);
      product.addProductObserver(cashRegister);
  }

  public void sellProduct(int amount) {
      product.sell(amount);
      cashRegister.handleSale(amount);
  }

  public boolean canSell(int amount) {
      return product.has(amount);
  }

  public String getStock() {
      return product.toString();
  }

  public final CashRegister getCashRegister() { return cashRegister; }  
  public final Product  getProduct() { return product; }
}            