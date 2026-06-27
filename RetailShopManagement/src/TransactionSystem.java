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
        this.cart = new HashMap<>();
        this.undo = new Stack<>();
    }
    public void AddToCart(String barcode, int quantity) {
        Product product = this.inventory.searchBarcode(barcode) ;

        if (product == null){
            System.out.println("Produk dengan barcode : " + barcode + " tidak ditemukan!");
            return;
        }

        if (product.getStock() < quantity) {
            System.out.println("Stok barang tidak mencukupi! Sisa stok : " + product.getStock());
            return;
        }

        int newStock = product.getStock() - quantity;
        product.setStock(newStock);

        if (cart.containsKey(barcode)){
            CartItem item = cart.get(barcode);
            item.quantity += quantity;
        } 
        else {
            cart.put(barcode, new CartItem(product, quantity));
        }

        undo.push(new TransactionAction(barcode, quantity));

        System.out.println("Barang " + product.getProductName() + " berhasil ditambahkan ke keranjang sebanyak : " + quantity + ".");
        }
        
        public void undoVoid(){
            if (undo.isEmpty()){
                System.out.println("Tidak ada transaksi!");
                return;
            }
            TransactionAction lastAction = undo.pop();

            Product product = this.inventory.searchBarcode(lastAction.barcode);

            if (product != null){
                product.setStock(product.getStock() + lastAction.quantity);
            }

            if (cart.containsKey(lastAction.barcode)){
                CartItem item = cart.get(lastAction.barcode);
                item.quantity -= lastAction.quantity;

                if (item.quantity <= 0){
                    cart.remove(lastAction.barcode);
                }
            }

            System.out.println("Berhasil membatalkan penambahan produk terakhir");
        }

        public void displayCart(){
            if (cart.isEmpty()){
                System.out.println("Keranjang belanjaan saat ini kosong.");
                return;
            }

            System.out.println("===ISI KERANJANG BELANJA===");
            System.out.printf("%-20s %-10s %-15s %-15s\n", "Nama Barang", "Kuantitas", "Harga Satuan", "Subtotal");
            System.out.println("---------------------------------------------------------");
            double totalBelanja = 0;
            for (CartItem item : cart.values()) {
                double subtotal = item.quantity * item.product.getPrice();
                totalBelanja += subtotal;
                System.out.printf("%-20s %-10d Rp%-13.2f Rp%-13.2f\n", 
                        item.product.getProductName(), 
                        item.quantity, 
                        item.product.getPrice(), 
                        subtotal);
            }
            System.out.println("---------------------------------------------------------");
            System.out.printf("TOTAL BELANJA: Rp%.2f\n", totalBelanja);
        }
}

