import java.util.*;

public class main {
    
        public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) throws Exception {

        Scanner sh = new Scanner(System.in);
        
        ModulInventory inventory = new ModulInventory();
        
        InventoryData.loadInitialData(inventory);

        SistemAntrean antrean = new SistemAntrean();
        
        TransactionSystem transaction = new TransactionSystem(inventory);
        

        int menu = 0;
        
        do {
            System.out.println("=== RETAIL SHOP MANAGEMENT===");
            System.out.println("1. Kelola Antrean Kasir");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Cek Inventaris Toko");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan menu : ");
            menu = sh.nextInt();
            sh.nextLine();

            clearScreen();
            

            switch (menu) {
                case 1:
                    SistemAntrean.tampilkanMenuUtama();
                    clearScreen();
                    break;

                case 2:
                    SistemAntrean.Pelanggan pelanggan = SistemAntrean.panggilAntrean();

                    if (pelanggan != null){
                        int subMenu = 0;
                        do {
                            clearScreen();
                            System.out.println("=================================================");
                            System.out.println("Menu Belanja (" + pelanggan.getNama() + " - " + pelanggan.getNomorAntrean() + ") :");
                            System.out.println("=================================================");
                            System.out.println("1. Tambah Barang");
                            System.out.println("2. Batalkan Barang Terakhir");
                            System.out.println("3. Cek Keranjang");
                            System.out.println("4. Selesai & Checkout");
                            System.out.println("=================================================");
                            System.out.print("Pilih menu belanja: ");
                            
                            while (!sh.hasNextInt()) {
                                System.out.print("Input harus berupa angka. Pilih menu belanja: ");
                                sh.next();
                            }
                            subMenu = sh.nextInt();
                            sh.nextLine();

                            switch (subMenu) {
                                case 1:
                                    System.out.print("Masukkan Barcode Barang: ");
                                    String barcode = sh.nextLine().trim();
                                    System.out.print("Masukkan Jumlah Barang: ");
                                    while (!sh.hasNextInt()) {
                                        System.out.print("Jumlah harus berupa angka. Masukkan Jumlah Barang: ");
                                        sh.next();
                                    }
                                    int quantity = sh.nextInt(); 
                                    sh.nextLine();
                                    transaction.AddToCart(barcode, quantity);
                                    System.out.println("\nTekan Enter untuk melanjutkan...");
                                    sh.nextLine();
                                    break;
                                case 2:
                                    transaction.undoVoid();
                                    System.out.println("\nTekan Enter untuk melanjutkan...");
                                    sh.nextLine();
                                    break;
                                case 3:
                                    clearScreen();
                                    transaction.displayCart();
                                    System.out.println("\nTekan Enter untuk melanjutkan...");
                                    sh.nextLine();
                                    break;
                                case 4:
                                    clearScreen();
                                    System.out.println("=== STRUK PEMBAYARAN ===");
                                    transaction.displayCart();
                                    transaction.clearCart();
                                    System.out.println("\nTransaksi selesai. Tekan Enter untuk kembali ke menu utama...");
                                    sh.nextLine();
                                    break;
                                default:
                                    System.out.println("Pilihan tidak valid!");
                                    System.out.println("\nTekan Enter untuk melanjutkan...");
                                    sh.nextLine();
                                    break;
                            }
                        } while (subMenu != 4);
                    }
                    clearScreen();
                    break;

                case 3:
                    clearScreen();
                    System.out.println("================= INVENTARIS TOKO ==================");
                    System.out.printf("%-10s %-32s %-10s %-10s\n", "Barcode", "Nama Barang", "Stok", "Harga");
                    System.out.println("----------------------------------------------------");
                    for (Product p : inventory.getDatabaseItem().values()) {
                        System.out.printf("%-10s %-32s %-10d Rp%-10.2f\n", 
                                p.getBarcode(), p.getProductName(), p.getStock(), p.getPrice());
                    }
                    System.out.println("====================================================");
                    System.out.println("\nTekan Enter untuk kembali ke menu utama...");
                    sh.nextLine();
                    clearScreen();
                    break;
                
                case 0:
                    System.out.println("Terimakasih telah menggunakan jasa Retail Shop Management!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
                    }

            } while (menu != 0);
                }
            }
            