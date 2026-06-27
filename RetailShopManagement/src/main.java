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
        
        //penambahan barang awal
        inventory.addItem("B025", "Sarden ABC", 50, 10900.0);
        inventory.addItem("B001", "Sari Roti Gandum", 67, 14500.0);
        inventory.addItem("B010", "Whiskas Kitten", 17, 9500.0);
        inventory.addItem("B999", "Indomie Cabe Ijo", 2, 3400.0);


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
                    if(SistemAntrean.getAntrean().isEmpty()){
                        System.out.println("Antrian masih kosong saat ini.");
                    }
                    else {
                        SistemAntrean.getAntrean().poll();
                    }
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
            