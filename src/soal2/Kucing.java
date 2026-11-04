package soal2;

/**
 * Kelas turunan dari Hewan yang meng-override method suara.
 */
public class Kucing extends Hewan {

    /**
     * Constructor untuk membuat objek Kucing.
     *
     * @param nama nama kucing
     */
    public Kucing(String nama) {
        super(nama);
        System.out.println("Kucing dibuat");
    }

    /**
     * Menghasilkan suara khas kucing.
     */
    @Override
    public void suara() {
        System.out.println("meong");
    }

    /**
     * Mensimulasikan kucing memanjat.
     */
    public void panjat() {
        System.out.println(nama + " memanjat");
    }
}