package magazyn;

import kategorie.Kategoria;

/**
 * Klasa odpowiada za towar dostępny w magazynie.
 * Przechowuje jego nazwę oraz cenę jednostkową.
 */

public class Towar {
    private double cena;
    private String nazwa;
    private Kategoria kategoria;

    public Towar(double cena, String nazwa) {
        this.cena = cena;
        this.nazwa = nazwa;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
