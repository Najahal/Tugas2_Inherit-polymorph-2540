# Tugas 2 Praktikum PBO
* **Nama Lengkap:** Najahal Khaira
* **NPM:** 250810701100040
* **Kelas:** Praktikum PBO A

## Soal 1: Hierarki Perangkat Elektronik

**Pertanyaan Tambahan:**
Ubah harga menjadi `private` lalu kompilasi. Salin pesan error yang muncul dan jelaskan mengapa error tersebut muncul.

**Pesan Error:**
`error: harga has private access in soal1.Perangkat`

**Penjelasan:**
Saat modifier atribut `harga` diubah dari `protected` menjadi `private` pada kelas `Perangkat`, atribut tersebut dikapsulasi murni dan hanya dapat diakses dari dalam kelas `Perangkat` itu sendiri. Subclass seperti `Laptop` kehilangan hak akses langsung ke atribut tersebut. Akibatnya, saat method `hitungHargaPromo()` di kelas `Laptop` mencoba mengakses variabel `harga` untuk melakukan perhitungan diskon, *compiler* Java menolaknya dan menghasilkan error kompilasi.

## Soal 2: Analisis Output, Error, dan Polimorfisme

**1. Output Lengkap Program**
Berdasarkan eksekusi dengan penambahan *error handling* (`instanceof`), berikut adalah output program sampai berhenti:
```text
=== BAGIAN A ===
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
Peringatan: hewanGenerik bukan instansiasi dari Kucing, downcasting dibatalkan.

=== BAGIAN B ===
A dibuat
init B, nilai=0
B dibuat, nilai=5

=== BAGIAN C ===
78.53981633974483
0.0
0.0
```

**2. Error pada h.panjat()**
Jika komentar dihapus, akan terjadi error kompilasi (compile-time error) dengan pesan cannot find symbol method panjat(). Hal ini terjadi karena tipe referensi (tipe statis) dari variabel h adalah Hewan. Compiler Java hanya memeriksa ketersediaan method berdasarkan tipe statisnya, dan kelas Hewan tidak memiliki method panjat().

**3. Penyebab ClassCastException dan Perbaikannya**
Error terjadi pada baris Kucing k2 = (Kucing) h2; (sebelum diperbaiki). Objek h2 diinstansiasi langsung sebagai Hewan, bukan Kucing, sehingga tidak bisa di-downcast paksa. Perbaikannya dilakukan dengan mengecek instansiasi menggunakan instanceof tanpa mengubah tipe variabel h2:
```text
if (h2 instanceof Kucing) {
    Kucing k2 = (Kucing) h2;
    k2.panjat();
} else {
    System.out.println("Peringatan: h2 bukan Kucing, downcasting dibatalkan.");
}
```

**4. Konsep Tipe Statis dan Dinamis pada h.makan()**
Method suara() yang dijalankan adalah milik kelas Kucing. Pada variabel h, tipe statisnya adalah Hewan (yang dicek saat kompilasi), tetapi tipe dinamisnya (wujud objek aslinya di memori saat runtime) adalah Kucing. Java menggunakan mekanisme Dynamic Method Dispatch, sehingga method yang dipanggil adalah method yang telah di-override pada tipe dinamisnya.

**5. Analisis Output new B() dan Risiko Overriding di Constructor**
Nilai pada baris init B adalah 0, bukan 5.
Saat new B() dipanggil, constructor superclass (A) dieksekusi lebih dulu. Constructor A memanggil method init(). Karena objek aktualnya adalah B, method init() milik B yang dijalankan. Namun, atribut nilai di kelas B belum diinisialisasi (masih bernilai default int yaitu 0). Memanggil method yang bisa di-override dari dalam constructor berisiko karena method subclass dapat tereksekusi sebelum status objek subclass tersebut diinisialisasi sepenuhnya, yang berpotensi memicu NullPointerException atau logical error.

**6. Analisis Relasi is-a Titik dan Lingkaran**
Pemanggilan l3.luas() menghasilkan 0.0 karena tipe dinamis l3 adalah Titik, sehingga method luas() yang dijalankan adalah hasil override milik Titik.
Meskipun secara geometri "Titik adalah sebuah Lingkaran dengan jari-jari 0", dalam Pemrograman Berorientasi Objek (OOP) relasi is-a ini melanggar Liskov Substitution Principle (LSP). Konsekuensinya, jika sebuah sistem mengharapkan objek Lingkaran yang selalu memiliki luas lebih dari nol (misalnya sebagai pembagi dalam perhitungan kepadatan), memasukkan objek Titik akan merusak logika program dan memicu error seperti pembagian dengan nol (DivisionByZero). Subclass tidak boleh mengubah ekspektasi dasar dari superclass-nya.