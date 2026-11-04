package soal1;

/**
 * Merepresentasikan perangkat elektronik secara umum.
 * Kelas ini bertindak sebagai superclass bagi Laptop dan Ponsel,
 * menyimpan data dasar dan melakukan validasi awal.
 */
public class Perangkat {
    public static final double TARIF_PAJAK = 0.10; // Konstanta pajak 10%

    private String merek;
    protected double harga;
    private int garansiBulan;

    /**
     * Constructor untuk membuat objek Perangkat baru.
     *
     * @param merek        merek perangkat (tidak boleh kosong)
     * @param harga        harga perangkat (tidak boleh negatif)
     * @param garansiBulan lama garansi dalam bulan
     * @throws IllegalArgumentException jika merek kosong atau harga negatif
     */
    public Perangkat(String merek, double harga, int garansiBulan) {
        if (merek == null || merek.trim().isEmpty()) {
            throw new IllegalArgumentException("Merek tidak boleh kosong.");
        }
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif.");
        }
        this.merek = merek;
        this.harga = harga;
        this.garansiBulan = garansiBulan;
    }

    /**
     * Mengambil merek dari perangkat.
     * 
     * @return string merek perangkat
     */
    public String getMerek() {
        return merek;
    }

    /**
     * Mengambil lama garansi perangkat.
     * 
     * @return jumlah bulan garansi
     */
    public int getGaransiBulan() {
        return garansiBulan;
    }

    /**
     * Menghitung pajak perangkat sebesar tarif pajak yang berlaku.
     *
     * @return besarnya potongan pajak
     */
    public double hitungPajak() {
        return harga * TARIF_PAJAK;
    }

    /**
     * Mengembalikan informasi singkat mengenai perangkat.
     *
     * @return teks informasi merek dan garansi
     */
    public String infoSingkat() {
        return merek + " | garansi " + garansiBulan + " bulan";
    }
}