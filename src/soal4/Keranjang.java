package soal4;

import java.util.ArrayList;
import java.util.List;

/**
 * Merepresentasikan keranjang belanja yang menampung berbagai macam produk.
 * Kelas ini mendemonstrasikan relasi komposisi dan polimorfisme.
 */
public class Keranjang {
    private List<Produk> daftarProduk;

    /**
     * Constructor untuk inisialisasi keranjang belanja kosong.
     */
    public Keranjang() {
        this.daftarProduk = new ArrayList<>();
    }

    /**
     * Menambahkan produk ke dalam keranjang dengan pengecekan kode unik.
     *
     * @param produkBaru objek produk yang akan ditambahkan
     * @throws IllegalStateException jika produk dengan kode yang sama sudah ada
     */
    public void tambah(Produk produkBaru) {
        for (Produk p : daftarProduk) {
            if (p.getKode().equals(produkBaru.getKode())) {
                throw new IllegalStateException(
                        "Produk dengan kode " + produkBaru.getKode() + " sudah ada di keranjang.");
            }
        }
        daftarProduk.add(produkBaru);
    }

    /**
     * Menghitung total harga seluruh produk di keranjang (Dynamic Method Dispatch).
     *
     * @return nilai total harga
     */
    public double hitungTotal() {
        double total = 0;
        for (Produk p : daftarProduk) {
            total += p.hitungHargaAkhir(); // Polimorfisme murni, tanpa instanceof
        }
        return total;
    }

    /**
     * Mencetak struk belanja ke layar sesuai format yang diminta.
     */
    public void cetakStruk() {
        for (Produk p : daftarProduk) {
            System.out.printf("%s | %s | %s | Rp%.0f\n",
                    p.getKode(), p.getNama(), p.deskripsi(), p.hitungHargaAkhir());
        }
        System.out.printf("TOTAL: Rp%.0f\n", hitungTotal());
    }

    /**
     * Menghitung dan mencetak jumlah masing-masing jenis produk secara spesifik.
     * Menerapkan urutan downcasting yang aman (Subclass terdalam dicek lebih dulu).
     */
    public void hitungPerJenis() {
        int fisik = 0, digital = 0, langganan = 0, bundel = 0;

        for (Produk p : daftarProduk) {
            // Langganan harus dicek sebelum ProdukDigital karena Langganan is-a
            // ProdukDigital
            if (p instanceof Langganan) {
                langganan++;
            } else if (p instanceof ProdukDigital) {
                digital++;
            } else if (p instanceof ProdukFisik) {
                fisik++;
            } else if (p instanceof ProdukBundel) {
                bundel++;
            }
        }

        System.out.println("Fisik: " + fisik + ", Digital: " + digital +
                ", Langganan: " + langganan +
                (bundel > 0 ? ", Bundel: " + bundel : ""));
    }
}