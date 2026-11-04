package soal1;

/**
 * Merepresentasikan perangkat Laptop yang merupakan turunan dari Perangkat.
 * Menyimpan spesifikasi tambahan berupa kapasitas RAM dan ukuran layar.
 */
public class Laptop extends Perangkat {
    private int ramGb;
    private double ukuranLayarInci;

    /**
     * Constructor untuk membuat objek Laptop.
     * 
     * @param merek           merek laptop
     * @param harga           harga laptop
     * @param garansiBulan    lama garansi dalam bulan
     * @param ramGb           kapasitas RAM dalam GB
     * @param ukuranLayarInci ukuran layar dalam satuan inci
     */
    public Laptop(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci) {
        super(merek, harga, garansiBulan);
        this.ramGb = ramGb;
        this.ukuranLayarInci = ukuranLayarInci;
    }

    /**
     * Menghitung harga promo setelah mendapatkan diskon tertentu.
     *
     * @param diskonPersen persentase diskon yang diberikan
     * @return nominal harga setelah dipotong diskon
     */
    public double hitungHargaPromo(double diskonPersen) {
        return harga - (harga * (diskonPersen / 100.0));
    }

    /**
     * Mengembalikan informasi singkat laptop beserta spesifikasinya.
     *
     * @return teks informasi detail laptop
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | RAM " + ramGb + " GB | layar " + ukuranLayarInci + " inci";
    }
}