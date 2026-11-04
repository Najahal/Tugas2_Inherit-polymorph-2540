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