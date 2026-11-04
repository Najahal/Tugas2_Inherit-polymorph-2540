package soal1;

/**
 * Merepresentasikan Laptop Gaming yang merupakan turunan khusus dari Laptop.
 * Memiliki tambahan kartu grafis khusus dan bonus garansi otomatis.
 */
public class LaptopGaming extends Laptop {
    public static final int GARANSI_TAMBAHAN_BULAN = 6;
    private String kartuGrafis;

    /**
     * Constructor untuk membuat objek LaptopGaming.
     * Otomatis menambahkan garansi tambahan 6 bulan ke dalam sistem.
     * 
     * @param merek           merek laptop gaming
     * @param harga           harga laptop gaming
     * @param garansiBulan    lama garansi dasar dalam bulan (akan ditambah
     *                        otomatis)
     * @param ramGb           kapasitas RAM dalam GB
     * @param ukuranLayarInci ukuran layar dalam satuan inci
     * @param kartuGrafis     jenis kartu grafis (GPU) yang digunakan
     */
    public LaptopGaming(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci,
            String kartuGrafis) {
        super(merek, harga, garansiBulan + GARANSI_TAMBAHAN_BULAN, ramGb, ukuranLayarInci);
        this.kartuGrafis = kartuGrafis;
    }

    /**
     * Mengembalikan informasi singkat laptop gaming beserta kartu grafisnya.
     *
     * @return teks informasi detail laptop gaming
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | GPU " + kartuGrafis;
    }
}