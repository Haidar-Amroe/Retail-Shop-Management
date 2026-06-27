import java.util.Stack;
import java.util.Map;
import java.util.HashMap;


public class TransactionSystem {
    private ModulInventory inventory;
    private Map<String, CartItem> cart;
    private Stack<TransactionAction> undo;

    static class CartItem{
        Product product;
        int quantity;

        public CartItem(Product product, int quantity){
            this.product = product;
            this.quantity = quantity;
        }
    }

    static class TransactionAction {
        String barcode; 
        int quantity;

        public TransactionAction(String barcode, int quantity){
            this.barcode = barcode;
            this.quantity = quantity;
        }
    }

    public TransactionSystem(ModulInventory inventory){
        this.inventory = inventory;
    }
    
}
