package soal4;

/**
 * Merepresentasikan produk berwujud fisik yang memerlukan ongkos kirim.
 */
public class ProdukFisik extends Produk {
    private static final double TARIF_ONGKIR_PER_KG = 10000.0;
    private double beratKg;

    /**
     * Constructor untuk membuat objek ProdukFisik.
     *
     * @param kode       kode unik produk
     * @param nama       nama produk
     * @param hargaDasar harga dasar produk
     * @param beratKg    berat produk dalam kilogram
     * @throws IllegalArgumentException jika berat negatif
     */
    public ProdukFisik(String kode, String nama, double hargaDasar, double beratKg) {
        super(kode, nama, hargaDasar);
        if (beratKg < 0) {
            throw new IllegalArgumentException("Berat produk fisik tidak boleh negatif.");
        }
        this.beratKg = beratKg;
    }

    /**
     * Menghitung harga akhir ditambah ongkos kirim berdasarkan berat.
     *
     * @return harga akhir setelah ditambah ongkos kirim
     */
    @Override
    public double hitungHargaAkhir() {
        return hargaDasar + (beratKg * TARIF_ONGKIR_PER_KG);
    }

    /**
     * Mengembalikan deskripsi spesifik produk fisik.
     *
     * @return string deskripsi beserta beratnya
     */
    @Override
    public String deskripsi() {
        return "fisik " + beratKg + " kg";
    }
}