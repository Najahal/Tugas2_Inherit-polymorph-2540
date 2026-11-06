package soal4;

/**
 * Merepresentasikan produk layanan berbasis langganan bulanan.
 * Kelas ini mendemonstrasikan hierarki pewarisan multi-level.
 */
public class Langganan extends ProdukDigital {
    private static final double DISKON_LANGGANAN_PERSEN = 0.20;
    private static final int BATAS_BULAN_DISKON = 12;
    private int durasiBulan;

    /**
     * Constructor untuk membuat layanan Langganan.
     *
     * @param kode        kode unik produk
     * @param nama        nama produk
     * @param hargaDasar  harga dasar per bulan
     * @param ukuranMb    ukuran akses/data dalam MB
     * @param durasiBulan lama waktu berlangganan dalam bulan
     * @throws IllegalArgumentException jika durasi bulan kurang dari atau sama
     *                                  dengan 0
     */
    public Langganan(String kode, String nama, double hargaDasar, double ukuranMb, int durasiBulan) {
        super(kode, nama, hargaDasar, ukuranMb);
        if (durasiBulan <= 0) {
            throw new IllegalArgumentException("Durasi langganan harus lebih dari 0 bulan.");
        }
        this.durasiBulan = durasiBulan;
    }

    /**
     * Menghitung harga akhir murni berdasarkan durasi langganan.
     * Menonaktifkan diskon digital dan menerapkan diskon durasi jika memenuhi
     * syarat.
     *
     * @return total harga setelah dikalkulasi dengan durasi dan diskon khusus
     */
    @Override
    public double hitungHargaAkhir() {
        double totalHarga = hargaDasar * durasiBulan;
        if (durasiBulan >= BATAS_BULAN_DISKON) {
            totalHarga = totalHarga - (totalHarga * DISKON_LANGGANAN_PERSEN);
        }
        return totalHarga;
    }

    /**
     * Mengembalikan deskripsi spesifik produk langganan.
     *
     * @return string deskripsi beserta durasinya
     */
    @Override
    public String deskripsi() {
        return "langganan " + durasiBulan + " bulan";
    }
}