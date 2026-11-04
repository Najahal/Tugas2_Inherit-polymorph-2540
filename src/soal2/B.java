package soal2;

/**
 * Kelas turunan dari A yang membuktikan efek overriding pada saat objek
 * dikonstruksi.
 */
public class B extends A {
    private int nilai = 5;

    /**
     * Constructor kelas B.
     */
    public B() {
        super();
        System.out.println("B dibuat, nilai=" + nilai);
    }

    /**
     * Meng-override method init dari kelas A.
     */
    @Override
    public void init() {
        System.out.println("init B, nilai=" + nilai);
    }
}