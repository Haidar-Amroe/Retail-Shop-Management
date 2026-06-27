# Retail Shop Management Project

Sub-project ini berisi implementasi kode Java untuk aplikasi POS (Point of Sale) toko ritel. Aplikasi mengintegrasikan pengelolaan antrean kasir, proses transaksi kasir belanja, fitur pembatalan (Undo/Void) menggunakan Stack, dan manajemen persediaan barang (Inventaris).

---

## Daftar Barang Dummy Inventaris Toko
Berikut adalah daftar 28 barang dummy bawaan sistem yang dimuat dari berkas `InventoryData.java` untuk simulasi transaksi kasir:

| No | Barcode | Nama Barang | Stok Awal | Harga Satuan |
|:---|:---|:---|:---:|:---|
| 1 | 899001 | Mie Sedaap Korean Cheese Buldak | 80 | Rp3.500 |
| 2 | 899002 | Sponge Crunch Strawberry | 45 | Rp9.500 |
| 3 | 899003 | Biskuit Lexus Keju | 35 | Rp8.500 |
| 4 | 899004 | Biskuit Better Sandwich | 100 | Rp2.500 |
| 5 | 899005 | Mie Sedaap Goreng | 150 | Rp3.100 |
| 6 | 899006 | Indomie Goreng Spesial | 120 | Rp3.500 |
| 7 | 899007 | Chitato Sapi Panggang 68g | 60 | Rp11.500 |
| 8 | 899008 | Susu Ultra Milk Cokelat 250ml | 90 | Rp6.500 |
| 9 | 899009 | Cimory Squeeze Blueberry | 50 | Rp10.000 |
| 10 | 899010 | Yakult Pack (Isi 5) | 40 | Rp10.500 |
| 11 | 899011 | Le Minerale Air Mineral 600ml | 150 | Rp3.500 |
| 12 | 899012 | Teh Pucuk Harum 350ml | 100 | Rp4.000 |
| 13 | 899013 | Coca Cola Cans 330ml | 70 | Rp7.000 |
| 14 | 899014 | Ichitan Thai Milk Tea | 55 | Rp9.000 |
| 15 | 899015 | Sabun Cair Lifebuoy Refill | 50 | Rp22.500 |
| 16 | 899016 | Shampoo Biore Anti Dandruff | 40 | Rp28.000 |
| 17 | 899017 | Pasta Gigi Pepsodent 190g | 65 | Rp13.500 |
| 18 | 899018 | Sabun Muka Garnier Men 100ml | 30 | Rp32.000 |
| 19 | 899019 | Minyak Goreng Filma 2 Liter | 40 | Rp36.000 |
| 20 | 899020 | Gula Pasir Gulaku 1kg | 50 | Rp17.500 |
| 21 | 899021 | Deterjen Rinso Anti Noda 700g | 35 | Rp19.500 |
| 22 | 899022 | Tisu Wajah Paseo 250 Sheets | 55 | Rp14.000 |
| 23 | 899023 | Silverqueen Almond 62g | 50 | Rp16.500 |
| 24 | 899024 | Cadbury Dairy Milk 62g | 40 | Rp15.500 |
| 25 | 899025 | Pocky Chocolate Double | 45 | Rp9.000 |
| 26 | 899026 | Buku Tulis Kiky A5 Pack | 30 | Rp38.000 |
| 27 | 899027 | Pulpen Gel Kenko Black 0.5 | 150 | Rp3.500 |
| 28 | 899028 | Pensil 2B Faber Castell | 100 | Rp4.500 |
