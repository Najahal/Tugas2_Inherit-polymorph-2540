package soal2;

/**
 * Merepresentasikan bangun datar lingkaran dengan atribut jari-jari.
 */
public class Lingkaran {
    protected double jariJari;

    /**
     * Constructor Lingkaran.
     *
     * @param jariJari nilai jari-jari lingkaran
     */
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    /**
     * Menghitung luas lingkaran.
     *
     * @return nilai luas lingkaran
     */
    public double luas() {
        return Math.PI * jariJari * jariJari;
    }

    /**
     * Menghitung keliling lingkaran.
     *
     * @return nilai keliling lingkaran
     */
    public double keliling() {
        return 2 * Math.PI * jariJari;
    }
}