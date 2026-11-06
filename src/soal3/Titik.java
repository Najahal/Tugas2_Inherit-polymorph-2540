package soal3;

/**
 * Merepresentasikan koordinat dua dimensi (x, y).
 */
public class Titik {
    private double x;
    private double y;

    /**
     * Constructor default untuk membuat titik di pusat koordinat (0.0, 0.0).
     */
    public Titik() {
        this(0.0, 0.0); // Memanfaatkan constructor lain (overloading)
    }

    /**
     * Constructor untuk membuat titik pada koordinat tertentu.
     *
     * @param x posisi pada sumbu X
     * @param y posisi pada sumbu Y
     */
    public Titik(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Menghitung jarak lurus dari titik ini ke titik lain.
     *
     * @param titikLain objek Titik tujuan
     * @return jarak antara kedua titik
     * @throws IllegalArgumentException jika parameter titikLain bernilai null
     */
    public double jarakKe(Titik titikLain) {
        if (titikLain == null) {
            throw new IllegalArgumentException("Titik tujuan tidak boleh null.");
        }
        // Menggunakan Math.hypot untuk perhitungan jarak yang akurat dan aman dari
        // overflow
        return Math.hypot(this.x - titikLain.getX(), this.y - titikLain.getY());
    }

    /**
     * Mengembalikan representasi teks dari Titik.
     *
     * @return koordinat dalam format (x, y)
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}