# Retail Shop Management - Point of Sale (POS) System

Proyek ini adalah implementasi dari sistem **Point of Sale (POS)** ritel modern yang dirancang untuk mengelola antrean loket pembayaran kasir secara terintegrasi dengan transaksi keranjang belanja dinamis dan manajemen stok inventaris secara *real-time*.

## Tema Proyek: POS (Point of Sale) System
* **Konteks Masalah**: Sistem Kasir dan Manajemen Stok Toko/Kafe.
* **Deskripsi**: Aplikasi kasir ritel yang mampu menangani transaksi penjualan secara *real-time*, melakukan pencarian harga dan data barang secara instan berdasarkan ID/Barcode, mengelola antrean pembayaran pelanggan di meja kasir, serta memproses pembatalan item belanjaan terakhir (*Void/Undo*).

---

## Anggota Kelompok (SDA-06)
1. **Muhammad Haidar Amru** - NIM. L0125025
2. **Nadhira Kamalia Athiya Rifa'i** - NIM. L0125057
3. **Gilda Tabitha Hadinaba** - NIM. L0125081

---

## Fitur Utama Program
1. **Sistem Antrean Kasir (*Queue*)**:
   * Menambahkan pelanggan baru ke antrean dengan nomor tiket terformat otomatis berdasarkan jenis layanan (Belanja Reguler, Pengambilan Pesanan, Komplain/Retur).
   * Memanggil pelanggan berikutnya (*FIFO*) untuk dilayani secara langsung oleh kasir.
   * Menghitung kuantitas antrean saat ini dan memberikan notifikasi kepadatan antrean.
2. **Sistem Transaksi Keranjang Dinamis**:
   * Melakukan transaksi belanja dinamis yang dipasangkan langsung dengan pelanggan yang dipanggil dari antrean.
   * Mendukung penambahan produk dengan validasi barcode dan ketersediaan stok inventaris gudang.
3. **Fitur Batal Barang Terakhir (*Undo/Void* - Stack)**:
   * Memungkinkan kasir membatalkan pemindaian item barang terakhir jika terjadi kesalahan input (*LIFO*).
   * Secara otomatis mengembalikan (memulihkan) jumlah stok barang yang dibatalkan tersebut ke dalam inventaris toko.
4. **Cek Inventaris Toko (*Real-Time*)**:
   * Menampilkan daftar 28 barang bawaan (dummy data awal) beserta sisa stok dan harga terupdate.

---

## Struktur Modul Kode (Java)
Seluruh kode sumber Java disimpan di dalam direktori `RetailShopManagement/src/`:
* [main.java](file:///d:/haidar/GitRepo/Retail-Shop-Management/RetailShopManagement/src/main.java): Program portal utama kasir yang menghubungkan seluruh alur modul secara interaktif.
* [ModulInventory.java](file:///d:/haidar/GitRepo/Retail-Shop-Management/RetailShopManagement/src/ModulInventory.java): Struktur data barang (*Product*) dan database penampung item (*ModulInventory*).
* [SistemAntrean.java](file:///d:/haidar/GitRepo/Retail-Shop-Management/RetailShopManagement/src/SistemAntrean.java): Logika antrean loket pembayaran kasir menggunakan struktur data `Queue` (`LinkedList`).
* [TransactionSystem.java](file:///d:/haidar/GitRepo/Retail-Shop-Management/RetailShopManagement/src/TransactionSystem.java): Logika transaksi keranjang belanja dan pembatalan item terakhir memanfaatkan struktur data `Stack`.
* [InventoryData.java](file:///d:/haidar/GitRepo/Retail-Shop-Management/RetailShopManagement/src/InventoryData.java): Kelas pembantu khusus untuk mengisi database inventaris awal dengan 28 jenis barang siap jual.

---

## Panduan Menjalankan Program
Untuk mengompilasi dan menjalankan program secara manual melalui terminal:

1. **Kompilasi Seluruh Program**:
   ```bash
   javac -d RetailShopManagement/bin RetailShopManagement/src/*.java
   ```
2. **Jalankan Aplikasi**:
   ```bash
   java -cp RetailShopManagement/bin main
   ```
