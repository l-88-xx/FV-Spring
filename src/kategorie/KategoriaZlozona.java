package kategorie;

import java.util.ArrayList;
import java.util.List;

/**
 * COMPOSITE - Węzeł
 * Klasa może zawierać liście (KategoriaProsta) oraz inne węzły.
 */

public class KategoriaZlozona implements Kategoria {

    private String nazwa;
    private List<Kategoria> podkategorie = new ArrayList<>();

    public KategoriaZlozona(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodaj(Kategoria k) {
        podkategorie.add(k);
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }

    @Override
    public void wypisz(String wciecie) {
        System.out.println(wciecie + "Podkategoria: " + nazwa);
        for (Kategoria k : podkategorie) {
            k.wypisz(wciecie + "  ");
        }
    }
}

