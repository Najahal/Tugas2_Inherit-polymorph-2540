package soal4;

/**
 * Kelas utama untuk menguji skenario Mini Project Toko Digital (Soal 4).
 */
public class TesSoal4 {

    /**
     * Method utama untuk eksekusi.
     *
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        Keranjang keranjang = new Keranjang();

        // Menambahkan produk standar sesuai soal
        keranjang.tambah(new ProdukFisik("F01", "Keyboard Mekanik", 500000, 1.5));
        keranjang.tambah(new ProdukDigital("D01", "Ebook Java", 100000, 20));
        keranjang.tambah(new Langganan("L01", "Kelas Online", 150000, 20, 12));

        // Menambahkan ProdukBundel SEBELUM mencetak struk
        ProdukBundel paketHemat = new ProdukBundel("B01", "Paket Belajar");
        paketHemat.tambahKeBundel(new ProdukFisik("F02", "Buku PBO", 100000, 0.5));
        paketHemat.tambahKeBundel(new ProdukDigital("D02", "Video Tutorial", 50000, 100));
        keranjang.tambah(paketHemat);

        // Mencetak struk dan hitung jenis
        keranjang.cetakStruk();
        keranjang.hitungPerJenis();

        // Menguji error handling pencegahan duplikasi data
        try {
            keranjang.tambah(new ProdukFisik("F01", "Mouse", 100000, 0.2));
        } catch (IllegalStateException e) {
            System.out.println("Gagal: " + e.getMessage());
        }
    }
}