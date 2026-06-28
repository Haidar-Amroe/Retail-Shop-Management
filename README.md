# Retail Shop Management - Point of Sale (POS) System

Aplikasi Kasir Ritel (Point of Sale) modern terintegrasi dengan Sistem Manajemen Antrean Pelanggan (*Queue*) dan Pemulihan Stok Barang secara Otomatis (*Undo/Void*).

---

## i. Judul dan Deskripsi Singkat Proyek
* **Judul Proyek**: **Retail Shop Management (POS System)**
* **Deskripsi Singkat**: Proyek ini merupakan aplikasi POS (Point of Sale) ritel berbasis konsol yang dirancang untuk mengelola antrean pembayaran pelanggan secara dinamis di meja kasir (*Queue Management*), melakukan pencarian informasi harga dan data barang instan berbasis barcode (*Inventory System*), serta menangani pencatatan transaksi belanja yang mendukung pembatalan item belanjaan terakhir (*Undo/Void*) dengan pemulihan sisa stok gudang secara *real-time*.

---

## ii. Nama Anggota Kelompok (SDA-06)
1. **Muhammad Haidar Amru** - NIM. L0125025
2. **Nadhira Kamalia Athiya Rifa'i** - NIM. L0125057
3. **Gilda Tabitha Hadinaba** - NIM. L0125081

---

## iii. Penjelasan Fitur-Fitur Utama Program
1. **Kelola Antrean Kasir (*Queue*)**:
   * Menambahkan pelanggan baru ke barisan antrean kasir. Setiap pelanggan mendapatkan tiket antrean terformat otomatis sesuai kategori layanan (R untuk Belanja Reguler, P untuk Pengambilan Pesanan, K untuk Komplain/Retur).
   * Menampilkan seluruh daftar antrean pelanggan aktif yang sedang menunggu pelayanan.
   * Menghitung kepadatan antrean kasir secara aktual dan memberikan rekomendasi operasional loket.
2. **Layani Pelanggan & Transaksi Belanja**:
   * Melakukan pemanggilan pelanggan terdepan secara otomatis (*First In First Out*) untuk dilayani.
   * Membuka sub-menu transaksi kasir khusus untuk pelanggan aktif tersebut.
   * Mendukung penambahan belanjaan (*Scan Barang*) dengan pencarian otomatis dan validasi ketersediaan stok inventaris gudang.
3. **Pembatalan Item Belanja Terakhir (*Undo/Void*)**:
   * Fitur pembatalan (*void*) yang menghapus data barang yang paling terakhir dimasukkan ke dalam keranjang belanja pelanggan apabila terjadi kesalahan *scan*.
   * Sistem secara otomatis mengembalikan kuantitas barang yang dibatalkan tersebut ke stok inventaris utama sehingga data persediaan tetap sinkron secara instan.
4. **Cek Inventaris Toko (*Real-Time*)**:
   * Menampilkan tabel persediaan gudang saat ini (berisi 28 produk bawaan toko yang dimuat dari database awal) beserta sisa stok terupdate dan harganya.

---

## iv. Struktur Data dan Algoritma yang Digunakan Beserta Alasan Pemilihannya

1. **Queue (Interface) & LinkedList (Implementasi)**
   * **Kegunaan**: Menyimpan barisan pelanggan di meja kasir.
   * **Alasan Pemilihan**: Antrean loket pembayaran kasir secara alami mengikuti prinsip **FIFO (First In First Out)**, di mana pelanggan yang datang pertama harus dilayani terlebih dahulu. `LinkedList` di Java mengimplementasikan interface `Queue` dan menyediakan operasi penyisipan (*enqueue*) serta pengambilan (*dequeue* / `poll`) dengan kompleksitas waktu $O(1)$, menjamin performa optimal bahkan saat antrean sangat panjang.

2. **Stack**
   * **Kegunaan**: Menyimpan riwayat log tindakan transaksi belanja untuk fitur pembatalan (*Undo/Void*).
   * **Alasan Pemilihan**: Fitur pembatalan transaksi terakhir mengikuti prinsip **LIFO (Last In First Out)**. Objek yang paling terakhir masuk keranjang belanja adalah objek yang harus dikeluarkan pertama kali saat terjadi *void*. Kelas `Stack` di Java menyediakan operasi `push` dan `pop` dengan kompleksitas waktu $O(1)$, menjadikannya sangat efisien untuk menyimpan dan mengambil riwayat aksi transaksi.

3. **Map (Interface) & HashMap (Implementasi)**
   * **Kegunaan**: Digunakan di dua modul, yaitu untuk memetakan barcode ke objek barang (*Inventaris Toko*) dan memetakan barcode ke item keranjang belanja (*Keranjang Dinamis*).
   * **Alasan Pemilihan**: Kasir membutuhkan proses pencarian data harga dan stok barang secara instan ketika barcode di-scan. `HashMap` menyediakan pencarian berbasis kunci (*key-value*) dengan kompleksitas waktu rata-rata $O(1)$ untuk operasi `get`, `put`, dan `remove`. Hal ini memastikan bahwa kecepatan sistem pencarian harga tetap konstan dan sangat cepat tanpa dipengaruhi oleh banyaknya jumlah produk di dalam gudang.

---

## v. Panduan Instalasi dan Menjalankan Program

### Persyaratan Sistem
* Java Development Kit (JDK) versi 11 atau yang lebih baru terinstal pada sistem.

### Langkah-Langkah Menjalankan Aplikasi
1. **Clone Repositori**:
   ```bash
   git clone https://github.com/Haidar-Amroe/Retail-Shop-Management.git
   cd Retail-Shop-Management
   ```
2. **Kompilasi Seluruh Berkas Java**:
   Kompilasi semua file kode sumber dari root direktori proyek:
   ```bash
   javac -d RetailShopManagement/bin RetailShopManagement/src/*.java
   ```
3. **Jalankan Program**:
   Jalankan file biner utama `main`:
   ```bash
   java -cp RetailShopManagement/bin main
   ```

---

## vi. Penggunaan Library Eksternal
Proyek ini dikembangkan **murni menggunakan library standar bawaan Java (Java Standard Library / JDK)** tanpa memanfaatkan *library* atau dependensi eksternal tambahan. 

* **Library JDK yang Digunakan**:
  * `java.util.Queue` dan `java.util.LinkedList` (untuk sistem antrean)
  * `java.util.Stack` (untuk riwayat transaksi undo/void)
  * `java.util.Map` dan `java.util.HashMap` (untuk sistem database produk & keranjang belanja)
  * `java.util.Scanner` (untuk membaca input interaktif di terminal)
* **Konfigurasi Tambahan**: Tidak diperlukan instalasi atau konfigurasi *library* luar apa pun.
