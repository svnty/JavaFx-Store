import javafx.fxml.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

public class StoreController {
  private Store store = new Store();
  @FXML private Button sellBtn;
  @FXML private Text stockTxt;
  @FXML private Text priceTxt;
  @FXML private TextField amountTf;
  @FXML private Text cashTxt;

  @FXML private void initialize() {
    amountTf.setText("0");
    stockTxt.textProperty().bind(store.getProduct().stockProperty().asString().concat(" items"));
    priceTxt.textProperty().bind(store.getProduct().priceProperty().asString("$%.2f"));
    cashTxt.textProperty().bind(store.getCashRegister().cashProperty().asString("$%.2f"));
  }

  public final Store getStadium() { return store; }
  private final int getAmount() { return Integer.parseInt(amountTf.getText()); }
  private final void setAmount(int amount) { amountTf.setText(""+amount); }

  public void handleSell(ActionEvent event) {
    int amount = getAmount();
    if (store.canSell(amount)) {
      store.sellProduct(amount);
      setAmount(0);
    }
  }
}
