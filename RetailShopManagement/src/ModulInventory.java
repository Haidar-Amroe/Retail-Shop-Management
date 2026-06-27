import java.util.HashMap;
import java.util.Map;

class Product {
  private String barcode;
  private String productname;
  private int stock;
  private double price;
  
  public Product(String barcode, String productname, int stock, double price) {
    this.barcode = barcode;
    this.productname = productname;
    this.stock = stock;
    this.price = price;
  }
  public String getBarcode() { return barcode; }
  public String getProductName() { return productname; }
  public int getStock() { return stock; }
  public double getPrice() { return price; }
  public void setStock (int stock) { this.stock = stock; }
}
public class ModulInventory {
    
    private Map<String, Product> databaseItem;

    public ModulInventory() {
        this.databaseItem = new HashMap<>();
    }

    
    public void addItem(String barcode, String productname, int stock, double price) {
        Product newProduct = new Product(barcode, productname, stock, price);
        databaseItem.put(barcode, newProduct);
    }

    // 
    public Product searchBarcode(String barcode) {
        if (databaseItem.containsKey(barcode)) {
            return databaseItem.get(barcode); 
        }
        return null; 
    }

    public Map<String, Product> getDatabaseItem() {
        return databaseItem;
    }
}
