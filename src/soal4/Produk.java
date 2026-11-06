package soal4;

/**
 * Kelas induk yang merepresentasikan entitas produk dasar di toko digital.
 */
public class Produk {
    protected String kode;
    protected String nama;
    protected double hargaDasar;

    /**
     * Constructor untuk membuat objek Produk dasar.
     *
     * @param kode       kode unik produk
     * @param nama       nama produk
     * @param hargaDasar harga dasar produk sebelum pajak/diskon
     * @throws IllegalArgumentException jika nama kosong atau harga dasar negatif
     */
    public Produk(String kode, String nama, double hargaDasar) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        if (hargaDasar < 0) {
            throw new IllegalArgumentException("Harga dasar tidak boleh negatif.");
        }
        this.kode = kode;
        this.nama = nama;
        this.hargaDasar = hargaDasar;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    /**
     * Menghitung harga akhir produk.
     *
     * @return nilai harga dasar (dapat di-override oleh subclass)
     */
    public double hitungHargaAkhir() {
        return hargaDasar;
    }

    /**
     * Memberikan deskripsi singkat mengenai produk.
     *
     * @return string deskripsi produk
     */
    public String deskripsi() {
        return "produk umum";
    }
}