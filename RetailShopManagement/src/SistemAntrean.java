import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemAntrean {

    static class Pelanggan {
        private String nomorAntrean;
        private String nama;
        private String jenisLayanan;
        private String status;

        public Pelanggan(String nomorAntrean, String nama, String jenisLayanan) {
            this.nomorAntrean = nomorAntrean;
            this.nama = nama;
            this.jenisLayanan = jenisLayanan;
            this.status = "Menunggu";
        }

        public String getNomorAntrean() {
            return nomorAntrean;
        }

        public String getNama() {
            return nama;
        }

        public String getJenisLayanan() {
            return jenisLayanan;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    private static Queue<Pelanggan> antrean = new LinkedList<>();
    private static Scanner input = new Scanner(System.in);
    private static int nomorUrut = 1;

    public static void main(String[] args) {
        tampilkanMenuUtama();
    }

    public static void tampilkanMenuUtama() {
        int pilihan;

        do {
            garis();
            System.out.println("            SISTEM ANTREAN KASIR");
            garis();
            System.out.println("1. Tambah Antrean Pelanggan");
            System.out.println("2. Panggil Antrean Berikutnya");
            System.out.println("3. Lihat Daftar Antrean");
            System.out.println("4. Lihat Antrean Terdepan");
            System.out.println("5. Hitung Jumlah Antrean");
            System.out.println("6. Kosongkan Antrean");
            System.out.println("0. Keluar");
            garis();
            System.out.print("Pilih menu: ");

            while (!input.hasNextInt()) {
                System.out.print("Input harus berupa angka. Pilih menu: ");
                input.next();
            }

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahAntrean();
                    break;
                case 2:
                    panggilAntrean();
                    break;
                case 3:
                    lihatDaftarAntrean();
                    break;
                case 4:
                    lihatAntreanTerdepan();
                    break;
                case 5:
                    hitungJumlahAntrean();
                    break;
                case 6:
                    kosongkanAntrean();
                    break;
                case 0:
                    System.out.println("Program antrean selesai dijalankan.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }

            if (pilihan != 0) {
                tekanEnter();
            }

        } while (pilihan != 0);
    }

    public static void tambahAntrean() {
        garis();
        System.out.println("        TAMBAH ANTREAN PELANGGAN");
        garis();

        System.out.print("Masukkan nama pelanggan: ");
        String nama = input.nextLine();

        while (nama.trim().isEmpty()) {
            System.out.print("Nama tidak boleh kosong. Masukkan nama pelanggan: ");
            nama = input.nextLine();
        }

        String jenisLayanan = pilihJenisLayanan();
        String nomorAntrean = buatNomorAntrean(jenisLayanan);

        Pelanggan pelanggan = new Pelanggan(nomorAntrean, nama, jenisLayanan);
        antrean.add(pelanggan);

        System.out.println();
        System.out.println("Antrean berhasil ditambahkan.");
        System.out.println("Nomor Antrean : " + nomorAntrean);
        System.out.println("Nama Pelanggan: " + nama);
        System.out.println("Jenis Layanan : " + jenisLayanan);
    }

    public static String pilihJenisLayanan() {
        int pilihan;

        do {
            System.out.println();
            System.out.println("Jenis Layanan:");
            System.out.println("1. Belanja Reguler");
            System.out.println("2. Pengambilan Pesanan");
            System.out.println("3. Komplain atau Retur");
            System.out.print("Pilih jenis layanan: ");

            while (!input.hasNextInt()) {
                System.out.print("Input harus berupa angka. Pilih jenis layanan: ");
                input.next();
            }

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    return "Belanja Reguler";
                case 2:
                    return "Pengambilan Pesanan";
                case 3:
                    return "Komplain atau Retur";
                default:
                    System.out.println("Pilihan layanan tidak tersedia.");
            }

        } while (true);
    }

    public static String buatNomorAntrean(String jenisLayanan) {
        String kode;

        if (jenisLayanan.equalsIgnoreCase("Belanja Reguler")) {
            kode = "R";
        } else if (jenisLayanan.equalsIgnoreCase("Pengambilan Pesanan")) {
            kode = "P";
        } else {
            kode = "K";
        }

        return kode + String.format("%03d", nomorUrut++);
    }

    public static void panggilAntrean() {
        garis();
        System.out.println("        PANGGIL ANTREAN BERIKUTNYA");
        garis();

        if (antrean.isEmpty()) {
            System.out.println("Tidak ada pelanggan dalam antrean.");
        } else {
            Pelanggan pelanggan = antrean.poll();
            pelanggan.setStatus("Sedang Dilayani");

            System.out.println("Memanggil pelanggan...");
            System.out.println("Nomor Antrean : " + pelanggan.getNomorAntrean());
            System.out.println("Nama Pelanggan: " + pelanggan.getNama());
            System.out.println("Jenis Layanan : " + pelanggan.getJenisLayanan());
            System.out.println("Status        : " + pelanggan.getStatus());

            /*
             * Bagian ini bisa dihubungkan ke modul transaksi.
             * Contoh:
             * transaksi.mulaiTransaksi(pelanggan);
             */
        }
    }

    public static void lihatDaftarAntrean() {
        garis();
        System.out.println("            DAFTAR ANTREAN");
        garis();

        if (antrean.isEmpty()) {
            System.out.println("Belum ada pelanggan dalam antrean.");
        } else {
            int nomor = 1;

            System.out.printf("%-5s %-12s %-20s %-25s %-15s%n",
                    "No", "Antrean", "Nama", "Jenis Layanan", "Status");
            garis();

            for (Pelanggan pelanggan : antrean) {
                System.out.printf("%-5d %-12s %-20s %-25s %-15s%n",
                        nomor++,
                        pelanggan.getNomorAntrean(),
                        pelanggan.getNama(),
                        pelanggan.getJenisLayanan(),
                        pelanggan.getStatus());
            }
        }
    }

    public static void lihatAntreanTerdepan() {
        garis();
        System.out.println("            ANTREAN TERDEPAN");
        garis();

        if (antrean.isEmpty()) {
            System.out.println("Tidak ada antrean saat ini.");
        } else {
            Pelanggan pelanggan = antrean.peek();

            System.out.println("Nomor Antrean : " + pelanggan.getNomorAntrean());
            System.out.println("Nama Pelanggan: " + pelanggan.getNama());
            System.out.println("Jenis Layanan : " + pelanggan.getJenisLayanan());
            System.out.println("Status        : " + pelanggan.getStatus());
        }
    }

    public static void hitungJumlahAntrean() {
        garis();
        System.out.println("            JUMLAH ANTREAN");
        garis();

        System.out.println("Jumlah pelanggan yang sedang menunggu: " + antrean.size());

        if (antrean.size() == 0) {
            System.out.println("Kasir sedang kosong.");
        } else if (antrean.size() <= 3) {
            System.out.println("Antrean masih normal.");
        } else if (antrean.size() <= 6) {
            System.out.println("Antrean mulai ramai.");
        } else {
            System.out.println("Antrean padat, disarankan membuka kasir tambahan.");
        }
    }

    public static void kosongkanAntrean() {
        garis();
        System.out.println("            KOSONGKAN ANTREAN");
        garis();

        if (antrean.isEmpty()) {
            System.out.println("Antrean sudah kosong.");
            return;
        }

        System.out.print("Yakin ingin menghapus semua antrean? (y/n): ");
        String konfirmasi = input.nextLine();

        if (konfirmasi.equalsIgnoreCase("y")) {
            antrean.clear();
            System.out.println("Semua antrean berhasil dikosongkan.");
        } else {
            System.out.println("Pengosongan antrean dibatalkan.");
        }
    }

    public static void tekanEnter() {
        System.out.println();
        System.out.print("Tekan Enter untuk kembali ke menu...");
        input.nextLine();
    }

    public static void garis() {
        System.out.println("==================================================");
    }
}