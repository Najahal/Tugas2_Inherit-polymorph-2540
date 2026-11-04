package soal2;

/**
 * Kelas utama untuk menjalankan seluruh pengujian Bagian A, B, dan C pada Soal
 * 2.
 * Menampilkan polimorfisme, downcasting yang aman, dan penanganan eksepsi.
 */
public class TesSoal2 {

    /**
     * Method utama untuk mengeksekusi pengujian.
     *
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        try {
            System.out.println("=== BAGIAN A ===");
            Hewan hewanTom = new Kucing("Tom");
            hewanTom.makan();
            hewanTom.suara();

            Kucing kucingTom = (Kucing) hewanTom;
            kucingTom.panjat();

            Hewan hewanGenerik = new Hewan("Generik");

            // Penanganan error (mencegah ClassCastException) dengan instanceof
            if (hewanGenerik instanceof Kucing) {
                Kucing kucingGenerik = (Kucing) hewanGenerik;
                kucingGenerik.panjat();
            } else {
                System.out.println("Peringatan: hewanGenerik bukan instansiasi dari Kucing, downcasting dibatalkan.");
            }

            System.out.println("\n=== BAGIAN B ===");
            new B();

            System.out.println("\n=== BAGIAN C ===");
            Lingkaran lingkaranNormal = new Lingkaran(5);
            Titik titikPusat = new Titik();
            Lingkaran lingkaranDariTitik = new Titik();

            System.out.println(lingkaranNormal.luas());
            System.out.println(titikPusat.luas());
            System.out.println(lingkaranDariTitik.luas());

        } catch (Exception e) {
            // Blok catch tidak dibiarkan kosong
            System.err.println("Terjadi kesalahan sistem saat runtime: " + e.getMessage());
        }
    }
}