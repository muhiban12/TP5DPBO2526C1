# TP5 DPBO 2025/2026 - PeopleData (MySQL Database & Back-End)

## Janji
Saya Muhiban Fadlan Nursaid dengan NIM 2400382 mengerjakan evaluasi Tugas Praktikum 5 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Deskripsi Program
Aplikasi desktop **PeopleData** berbasis Java Swing GUI yang terintegrasi penuh dengan **Database MySQL** via JDBC Driver (`mysql-connector-j`)[cite: 20]. Pada TP5 ini, penyimpanan data sementara (`ArrayList`) telah dihapus secara menyeluruh dan digantikan oleh *persistent storage* berbasis relasional database.

## Spesifikasi & Fitur TP5
1. **Full Integration Database CRUD**:
   - **Create**: Menambahkan data person/karyawan baru langsung ke tabel `person` di MySQL.
   - **Read**: Membaca seluruh rekord dari database menggunakan query `SELECT` dan menampilkannya pada `JTable`[cite: 24, 26].
   - **Update**: Mengubah data rekord pada database berdasarkan `id` (Primary Key).
   - **Delete**: Menghapus data dari database setelah konfirmasi `JOptionPane`[cite: 26].
2. **Penyimpanan Permanen (No ArrayList)**:
   - Variabel `ArrayList` dihapus penuh; seluruh manipulasi dan pembacaan data dilakukan secara *real-time* dari/ke database MySQL[cite: 24, 26].
3. **Validasi Input Kosong**:
   - Menampilkan pop-up dialog error `JOptionPane` apabila terdapat kolom input (ID, Nama, Tahun Lahir, Kategori, atau Jenis Kelamin) yang belum diisi saat proses Insert/Update[cite: 25, 26].
4. **Validasi Duplicate ID**:
   - Menampilkan pop-up dialog peringatan `JOptionPane` jika ID yang dimasukkan saat registrasi baru sudah terdaftar di database (mencegah bentrok Primary Key)[cite: 26].
5. **Bonus RadioButton (Mempertahankan Bonus TP4)**:
   - Atribut `jenis_kelamin` menggunakan komponen `JRadioButton` (`Laki-laki` / `Perempuan`) yang terikat dalam `ButtonGroup`.

## Struktur Repositori Proyek
```text
PeopleData/
├── src/
│   ├── Person.java
│   ├── Database.java
│   ├── PeopleMenu.java
│   └── PeopleMenu.form
├── lib/
│   └── mysql-connector-j-26.7.0.jar
├── Dokumentasi/
│   ├── read_data.png
│   ├── insert_data.png
│   ├── update_data.png
│   ├── update_data_permission.png
│   ├── delete_data.png
│   ├── error_empty_input.png
│   └── error_duplicate_id.png
├── db_people.sql
├── .gitignore
└── README.md

```

## Alur Kerja Aplikasi (Program Flow)
1. **Inisialisasi**:
   - Saat aplikasi berjalan, constructor PeopleMenu memanggil Database.java untuk membuka koneksi JDBC ke MySQL database db_people.
2. **Load Data (setTable())**:
   - Query SELECT * FROM person dieksekusi dan hasilnya dipetakan langsung ke baris JTable.
3. **Mekanisme Selection**:
   - Menekan salah satu baris pada tabel akan membaca nilai sel dari model tabel (getValueAt) tanpa bergantung pada ArrayList[cite: 26]. Field ID di-disable agar Primary Key tidak diubah secara sengaja saat mode update.
4. **Validasi & Eksekusi Query**:
   - Sebelum INSERT atau UPDATE dijalankan, sistem mengecek kelengkapan input dan mendeteksi apakah ID sudah ada di tabel person[cite: 25, 26].

## Skema Database (db_people.sql)
```text
CREATE DATABASE IF NOT EXISTS db_people;
USE db_people;

CREATE TABLE IF NOT EXISTS person (
   id VARCHAR(255) PRIMARY KEY,
   nama VARCHAR(255) NOT NULL,
   thn_lahir INT NOT NULL,
   kategori VARCHAR(255) NOT NULL,
   jenis_kelamin VARCHAR(255) NOT NULL
);
```