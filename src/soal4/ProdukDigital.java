package soal4;

/**
 * Merepresentasikan produk digital yang dapat diunduh, dengan diskon khusus.
 */
public class ProdukDigital extends Produk {
    protected static final double DISKON_DIGITAL_PERSEN = 0.10;
    protected double ukuranMb;

    /**
     * Constructor untuk membuat objek ProdukDigital.
     *
     * @param kode       kode unik produk
     * @param nama       nama produk
     * @param hargaDasar harga dasar produk
     * @param ukuranMb   ukuran file produk dalam Megabyte
     * @throws IllegalArgumentException jika ukuran MB negatif
     */
    public ProdukDigital(String kode, String nama, double hargaDasar, double ukuranMb) {
        super(kode, nama, hargaDasar);
        if (ukuranMb < 0) {
            throw new IllegalArgumentException("Ukuran produk digital tidak boleh negatif.");
        }
        this.ukuranMb = ukuranMb;
    }

    /**
     * Menghitung harga akhir setelah dipotong diskon digital.
     *
     * @return harga akhir setelah diskon
     */
    @Override
    public double hitungHargaAkhir() {
        return hargaDasar - (hargaDasar * DISKON_DIGITAL_PERSEN);
    }

    /**
     * Mengembalikan deskripsi spesifik produk digital.
     *
     * @return string deskripsi beserta ukurannya
     */
    @Override
    public String deskripsi() {
        return "digital " + ukuranMb + " MB";
    }
}