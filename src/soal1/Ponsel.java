package soal1;

/**
 * Merepresentasikan perangkat Ponsel yang merupakan turunan dari Perangkat.
 * Menyimpan spesifikasi tambahan berupa kapasitas penyimpanan dan jumlah
 * kamera.
 */
public class Ponsel extends Perangkat {
    private int kapasitasGb;
    private int jumlahKamera;

    /**
     * Constructor untuk membuat objek Ponsel.
     * 
     * @param merek        merek ponsel
     * @param harga        harga ponsel
     * @param garansiBulan lama garansi dalam bulan
     * @param kapasitasGb  kapasitas memori internal dalam GB
     * @param jumlahKamera total lensa kamera yang dimiliki ponsel
     */
    public Ponsel(String merek, double harga, int garansiBulan, int kapasitasGb, int jumlahKamera) {
        super(merek, harga, garansiBulan);
        this.kapasitasGb = kapasitasGb;
        this.jumlahKamera = jumlahKamera;
    }

    /**
     * Mengembalikan informasi singkat ponsel beserta spesifikasinya.
     *
     * @return teks informasi detail ponsel
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | " + kapasitasGb + " GB | " + jumlahKamera + " kamera";
    }
}