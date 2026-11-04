package soal2;

/**
 * Kelas induk untuk mendemonstrasikan polimorfisme dan pemanggilan method
 * berantai.
 */
public class Hewan {
    protected String nama;

    /**
     * Constructor untuk membuat objek Hewan.
     *
     * @param nama nama hewan
     */
    public Hewan(String nama) {
        this.nama = nama;
        System.out.println("Hewan dibuat: " + nama);
    }

    /**
     * Menghasilkan suara hewan secara umum.
     */
    public void suara() {
        System.out.println("...");
    }

    /**
     * Mensimulasikan hewan sedang makan dan otomatis memanggil method suara.
     */
    public void makan() {
        System.out.println(nama + " makan");
        suara();
    }
}