package dokumenty;

import magazyn.Towar;

/**
 * Klasa odpowiada za pojedynczą pozycję na fakturze.
 */

public class Pozycja {
    private Towar towar;
    private double cena;
    private double ilosc;
    private double wartosc;
    private String nazwa;
    private int lp;

    public Pozycja(Towar towar, double ilosc, int lp) {
        this.towar = towar;
        this.ilosc = ilosc;
        this.cena = towar.getCena();
        this.nazwa = towar.getNazwa();
        this.lp = lp;
        this.przeliczWartosc();
    }

    public void setTowar(Towar towar) {
        this.towar = towar;
        this.cena = towar.getCena();
        this.nazwa = towar.getNazwa();
        this.przeliczWartosc();
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
        this.przeliczWartosc();
    }

    public double getCena() {
        return this.cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
        this.przeliczWartosc();
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getWartosc() {
        return wartosc;
    }

    public int getLp() {
        return lp;
    }

    // Jak zmienimy coś w pozycji trzeba wywolać
    private void przeliczWartosc() {
        this.wartosc = this.ilosc * this.cena;
    }
}
