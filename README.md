# 📒 Sistem Ledger & Mutasi Keuangan

## Deskripsi Proyek

Sistem Ledger & Mutasi Keuangan merupakan aplikasi desktop berbasis JavaFX yang dirancang untuk membantu pencatatan mutasi keuangan dan pengelolaan data ledger secara sederhana.

Aplikasi ini dikembangkan sebagai proyek mata kuliah Pemrograman Berorientasi Objek (PBO) dengan menerapkan konsep:

* Object Oriented Programming (OOP)
* JavaFX GUI
* MVC (Model View Controller)
* Multithreading
* Runnable & Thread
* Validasi Data
* Navigasi Antar Halaman

---

## Fitur Utama

### 🔐 Login

* Autentikasi pengguna
* Validasi username dan password
* Notifikasi login gagal

### 📊 Dashboard

* Menampilkan jumlah akun
* Menampilkan jumlah mutasi
* Menampilkan total debit
* Menampilkan total kredit
* Jam digital realtime

### 💸 Mutasi Keuangan

* Input tanggal transaksi
* Pilih akun asal
* Pilih akun tujuan
* Input nominal transaksi
* Input keterangan
* Validasi data wajib diisi

### 📒 Ledger

* Menampilkan data transaksi
* Total debit dan kredit
* Fitur pencarian data
* Refresh data
* Simulasi export CSV

### ⚙ Multithreading

* Implementasi Thread
* Implementasi Runnable
* Background monitoring service
* Jam digital realtime

---

## Struktur Project

src
├── controller
│ ├── LoginController.java
│ ├── DashboardController.java
│ ├── MutasiController.java
│ └── LedgerController.java
│
├── model
│ ├── User.java
│ ├── Akun.java
│ ├── Mutasi.java
│ ├── Ledger.java
│ └── DetailLedger.java
│
├── service
│ ├── BackgroundService.java
│ ├── DashboardService.java
│ ├── MutasiService.java
│ ├── LedgerService.java
│ └── ExportTask.java
│
├── jdatabase
│ └── DataBaseConnection.java
│
└── resources
├── login.fxml
├── dashboard.fxml
├── mutasi.fxml
└── ledger.fxml

---

## Teknologi yang Digunakan

* Java 26
* JavaFX 21
* Maven
* IntelliJ IDEA
* MySQL (opsional)
* Git & GitHub

---

## Cara Menjalankan Project

1. Clone repository:

git clone https://github.com/username/repository.git

2. Buka menggunakan IntelliJ IDEA.

3. Tunggu Maven melakukan download dependency.

4. Jalankan aplikasi melalui:

HelloApplication.java

atau

Main.java

sesuai konfigurasi project.

---

## Implementasi OOP

### Encapsulation

Digunakan pada class model seperti:

* User
* Mutasi
* Ledger
* Akun

### Inheritance

Digunakan pada struktur class sesuai kebutuhan pengembangan.

### Polymorphism

Digunakan pada method yang memiliki implementasi berbeda sesuai objek.

### Abstraction

Digunakan melalui pemisahan Controller, Model, dan Service.

---

## Tim Pengembang

Proyek ini dikembangkan sebagai tugas kelompok mata kuliah Pemrograman Berorientasi Objek.

### Anggota Tim

* Intan Retno Anjani (202510370110176)
* Nur Hatifah Hasanah (202510370110189)
* Kusmawati (202510370110177)
---

## Lisensi

Proyek ini dibuat untuk kebutuhan akademik dan pembelajaran.
