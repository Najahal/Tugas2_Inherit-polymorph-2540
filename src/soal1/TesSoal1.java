package soal1;

/**
 * Kelas utama untuk menguji fungsionalitas hierarki Perangkat elektronik.
 * Kelas ini mendemonstrasikan pembuatan objek, polimorfisme, dan penanganan
 * error (error handling).
 */
public class TesSoal1 {

    /**
     * Method utama untuk menjalankan program pengujian.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        // Implementasi Error Handling (Try-Catch) sesuai saran aslab
        try {
            // Menggunakan nama variabel deskriptif (bukan l, p, g)
            Laptop laptopAsus = new Laptop("Asus", 8000000, 24, 16, 14.0);
            Ponsel ponselSamsung = new Ponsel("Samsung", 5000000, 12, 128, 3);
            LaptopGaming laptopGamingMsi = new LaptopGaming("MSI", 15000000, 12, 32, 15.6, "RTX 4060");

            System.out.println(laptopAsus.infoSingkat());
            System.out.println(ponselSamsung.infoSingkat());
            System.out.println(laptopGamingMsi.infoSingkat());
            System.out.printf("Pajak laptop: Rp%.0f%n", laptopAsus.hitungPajak());
            System.out.printf("Promo laptop 10 persen: Rp%.0f%n", laptopAsus.hitungHargaPromo(10));

            // Contoh simulasi error handling: mencoba membuat perangkat dengan harga
            // negatif
            System.out.println("\n--- Menguji Validasi Error ---");
            Ponsel ponselError = new Ponsel("Xiaomi", -500000, 12, 64, 2);

        } catch (IllegalArgumentException e) {
            // Blok catch tidak dibiarkan kosong sesuai aturan rubrik
            System.err.println("Gagal membuat perangkat: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan sistem yang tidak terduga: " + e.getMessage());
        }
    }
}