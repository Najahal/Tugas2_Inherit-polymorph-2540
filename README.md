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

## Soal 3: Titik dan Garis

**1. Prediksi Output Baris Kedua (Sebelum Perbaikan / Konsep Aliasing)**
Jika *defensive copy* belum diterapkan pada constructor `Garis`, pengubahan nilai `t.setX(100)` akan memicu efek *aliasing*. Karena `Garis g2` dan variabel `t` merujuk pada alamat memori objek yang sama, perubahan pada `t` akan "bocor" ke dalam `g2`. 
Output yang diprediksi dan tercetak pada baris kedua adalah: `(100.0, 1.0) - (5.0, 5.0)`.

**2. Output Setelah Perbaikan (Penerapan Defensive Copy)**
Setelah constructor `Garis` diubah menggunakan *defensive copy* (menginstansiasi objek `Titik` baru dengan nilai yang disalin, bukan sekadar menyalin referensi memori), perubahan pada objek `t` di luar kelas tidak lagi memengaruhi status internal `Garis g2`. 
Output yang tercetak menjadi: `(1.0, 1.0) - (5.0, 5.0)`.

**3. Kapan masing-masing perilaku lebih tepat?**
*   **Sebelum Perbaikan (Aliasing / Shallow Copy):** Lebih tepat digunakan jika sistem membutuhkan sinkronisasi data *real-time* atau *shared state*. Contohnya, pada sistem visualisasi *live tracking* rute taksi online; jika posisi mobil (Titik) bergerak, rute (Garis) di layar harus otomatis ikut bergeser mengikuti titik tersebut tanpa perlu pembaruan manual.
*   **Sesudah Perbaikan (Defensive Copy / Deep Copy):** Lebih tepat digunakan jika integritas dan keamanan data menjadi prioritas (objek bersifat *immutable*). Contohnya, sistem pemetaan batas sertifikat tanah; koordinat batas (Titik) tidak boleh berubah secara tak sengaja hanya karena objek di luar sistem memodifikasi nilainya.

**4. Masalah Desain jika Garis extends Titik (Relasi is-a vs has-a)**
Jika `Garis` dibuat dengan melakukan `extends Titik`, kita memaksakan relasi *is-a* ("Garis adalah sebuah Titik"). Secara logika geometri umum dan desain berorientasi objek (OOP), hal ini salah arah dan melanggar aturan dasar. Garis tidak berwujud sebagai satu titik tunggal, melainkan **dibentuk oleh** dua titik, yang mana ini adalah ranah relasi *has-a* (Komposisi). 
Secara teknis, jika di-*extends*, `Garis` akan mewarisi atribut tunggal `x` dan `y` milik `Titik`, padahal sebuah garis mutlak membutuhkan dua set koordinat (titik awal dan titik akhir) untuk dapat eksis dan dihitung panjangnya.

## Bagian Analisis Konsep

**1. Perbedaan Method Overriding dan Method Overloading**
Method *overriding* terjadi ketika subclass mendefinisikan ulang method dari superclass dengan nama dan parameter yang sama persis untuk mengubah perilakunya, yang merupakan bentuk polimorfisme *runtime*. Contohnya pada kode adalah method `hitungHargaAkhir()` di kelas `ProdukFisik` yang menimpa logika method bawaan dari kelas `Produk` untuk menambahkan ongkos kirim. Sebaliknya, method *overloading* terjadi ketika terdapat beberapa method dengan nama yang sama namun parameter yang berbeda di dalam sebuah kelas, yang mewakili polimorfisme *compile-time*. Contoh *overloading* di tugas ini adalah ketersediaan dua *constructor* pada kelas `Garis`, di mana satu menerima dua objek `Titik` dan yang lainnya menerima empat nilai *double*.

**2. Pemilihan Inheritance dan Composition**
*Inheritance* dipilih ketika dua objek murni memiliki relasi *is-a* ("adalah sebuah"), di mana subclass mewarisi karakteristik inti dari superclass untuk kemudian dikembangkan lebih spesifik. Contohnya pada tugas ini adalah `ProdukDigital extends Produk`, karena sebuah *ebook* (produk digital) sudah pasti "adalah sebuah" produk yang memiliki nama dan harga. Sementara itu, *composition* dipilih ketika terdapat relasi *has-a* ("memiliki sebuah"), di mana suatu objek disusun oleh satu atau beberapa objek lain tanpa mewarisi sifatnya. Contoh *composition* di tugas ini adalah kelas `Garis` yang memiliki komponen objek `Titik` (awal dan akhir), karena secara logika garis bukanlah sebuah titik, melainkan dibentuk oleh titik.

**3. Penggunaan instanceof dan Keamanan Downcasting (Soal 4)**
Method `cetakStruk()` tidak memerlukan `instanceof` karena murni memanfaatkan polimorfisme dinamis, di mana Java secara otomatis memanggil versi *override* dari method `hitungHargaAkhir()` dan `deskripsi()` sesuai wujud asli masing-masing objek. Sebaliknya, `hitungPerJenis()` wajib menggunakan `instanceof` karena method tersebut butuh membedakan identitas kelas secara spesifik untuk dikelompokkan dan dihitung jumlahnya, bukan untuk menjalankan perilakunya. Terkait *downcasting* (memaksa referensi objek turun menjadi tipe subclass tertentu), hal ini tidak selalu aman karena jika objek aslinya bukan merupakan instansiasi dari subclass yang dituju, Java akan melemparkan *error* `ClassCastException`. Oleh karena itu, kita selalu harus memastikan kecocokannya dengan `instanceof` sebelum melakukan *downcasting* agar program tidak hancur saat *runtime*.