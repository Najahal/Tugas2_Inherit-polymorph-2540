package soal2;

/**
 * Kelas induk untuk mendemonstrasikan risiko pemanggilan method di dalam
 * constructor.
 */
public class A {

    /**
     * Constructor kelas A yang memanggil method init().
     */
    public A() {
        System.out.println("A dibuat");
        init();
    }

    /**
     * Inisialisasi awal kelas A.
     */
    public void init() {
        System.out.println("init A");
    }
}