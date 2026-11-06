package soal3;

/**
 * Merepresentasikan sebuah garis yang dibentuk oleh dua titik (awal dan akhir).
 * Kelas ini mendemonstrasikan relasi komposisi (has-a) dengan kelas Titik.
 */
public class Garis {
    private Titik awal;
    private Titik akhir;

    /**
     * Constructor utama untuk membuat garis dari dua objek Titik.
     * Menerapkan "defensive copy" agar referensi titik dari luar tidak membocorkan
     * (aliasing)
     * status internal garis saat diubah.
     *
     * @param awal  Titik pangkal garis
     * @param akhir Titik ujung garis
     * @throws IllegalArgumentException jika ada titik yang bernilai null
     */
    public Garis(Titik awal, Titik akhir) {
        if (awal == null || akhir == null) {
            throw new IllegalArgumentException("Titik awal dan akhir tidak boleh null.");
        }
        // Defensive copy: membuat instansiasi objek baru berdasarkan nilai koordinat
        this.awal = new Titik(awal.getX(), awal.getY());
        this.akhir = new Titik(akhir.getX(), akhir.getY());
    }

    /**
     * Constructor overloading untuk membuat garis langsung dari koordinat.
     *
     * @param x1 koordinat X awal
     * @param y1 koordinat Y awal
     * @param x2 koordinat X akhir
     * @param y2 koordinat Y akhir
     */
    public Garis(double x1, double y1, double x2, double y2) {
        // Wajib memanggil constructor pertama lewat this(...) sesuai instruksi
        this(new Titik(x1, y1), new Titik(x2, y2));
    }

    public Titik getAwal() {
        return awal;
    }

    public void setAwal(Titik awal) {
        this.awal = awal;
    }

    public Titik getAkhir() {
        return akhir;
    }

    public void setAkhir(Titik akhir) {
        this.akhir = akhir;
    }

    /**
     * Mengambil panjang garis dengan mendelegasikan perhitungan pada method
     * jarakKe() milik Titik.
     *
     * @return nilai panjang garis
     */
    public double getPanjang() {
        return awal.jarakKe(akhir);
    }

    /**
     * Mengembalikan representasi teks dari Garis dengan memanggil toString() milik
     * Titik.
     *
     * @return koordinat dalam format (x1, y1) - (x2, y2)
     */
    @Override
    public String toString() {
        return awal.toString() + " - " + akhir.toString();
    }
}