package soal4;

import java.util.ArrayList;
import java.util.List;

/**
 * Merepresentasikan paket produk gabungan (bundel) yang mendapatkan diskon
 * ekstra.
 * Ini adalah tantangan opsional untuk nilai tambah.
 */
public class ProdukBundel extends Produk {
    private static final double DISKON_BUNDEL_PERSEN = 0.15;
    private List<Produk> isiBundel;

    /**
     * Constructor untuk membuat paket bundel kosong.
     *
     * @param kode kode unik bundel
     * @param nama nama paket bundel
     */
    public ProdukBundel(String kode, String nama) {
        super(kode, nama, 0); // hargaDasar bundel diakumulasi dari isi
        this.isiBundel = new ArrayList<>();
    }

    /**
     * Menambahkan produk ke dalam bundel.
     *
     * @param p produk yang ingin ditambahkan
     */
    public void tambahKeBundel(Produk p) {
        if (p != null) {
            isiBundel.add(p);
        }
    }

    /**
     * Menghitung harga total bundel berdasarkan harga akhir tiap item lalu
     * didiskon.
     *
     * @return harga total bundel setelah diskon bundel
     */
    @Override
    public double hitungHargaAkhir() {
        double totalHargaItem = 0;
        for (Produk p : isiBundel) {
            totalHargaItem += p.hitungHargaAkhir();
        }
        return totalHargaItem - (totalHargaItem * DISKON_BUNDEL_PERSEN);
    }

    /**
     * Mengembalikan deskripsi bundel berdasarkan jumlah item.
     *
     * @return string deskripsi bundel
     */
    @Override
    public String deskripsi() {
        return "bundel " + isiBundel.size() + " item";
    }
}