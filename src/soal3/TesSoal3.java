package soal3;

/**
 * Kelas uji untuk Soal 3,
 * dilengkapi dengan penanganan eksepsi dan penamaan yang deskriptif.
 */
public class TesSoal3 {

    /**
     * Method utama untuk menguji fungsionalitas Titik dan Garis.
     * 
     * @param args argumen baris perintah
     */
    public static void main(String[] args) {
        try {
            // Menggunakan penamaan deskriptif
            Garis garisPertama = new Garis(0, 0, 3, 4);
            System.out.println(garisPertama + " panjang=" + garisPertama.getPanjang());

            Titik titikReferensi = new Titik(1, 1);
            Garis garisKedua = new Garis(titikReferensi, new Titik(5, 5));
            titikReferensi.setX(100);

            System.out.println(garisKedua);

        } catch (Exception e) {
            // Membuat penanganan exception
            System.err.println("Terjadi kesalahan sistem saat runtime: " + e.getMessage());
        }
    }
}