import java.util.*;

public class main {
    
        public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) throws Exception {

        Scanner sh = new Scanner(System.in);
        
        ModulInventory inventory = new ModulInventory();
        TransactionSystem transaction = new TransactionSystem(inventory);
        SistemAntrean antrean = new SistemAntrean();
        
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
                    antrean.tampilkanMenuUtama();
                    
                    clearScreen();
                    break;

                case 2:
                
                    break;

                case 3:
                
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
            