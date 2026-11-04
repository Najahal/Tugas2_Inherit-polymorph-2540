package soal2;

/**
 * Merepresentasikan titik koordinat sebagai turunan dari Lingkaran dengan
 * jari-jari nol.
 */
public class Titik extends Lingkaran {

    /**
     * Constructor Titik yang otomatis mengeset jari-jari menjadi 0.
     */
    public Titik() {
        super(0.0);
    }

    /**
     * Mengembalikan luas titik (selalu 0).
     *
     * @return luas bernilai 0.0
     */
    @Override
    public double luas() {
        return 0.0;
    }

    /**
     * Mengembalikan keliling titik (selalu 0).
     *
     * @return keliling bernilai 0.0
     */
    @Override
    public double keliling() {
        return 0.0;
    }
}