package kategorie;

import magazyn.Towar;

import java.util.ArrayList;
import java.util.List;

/**
 * COMPOSITE - Liść
 * Klasa przechowuje listę towarów należących do danej kategorii.
 */

public class KategoriaProsta implements Kategoria {

    private String nazwa;
    private List<Towar> towary = new ArrayList<>();

    public KategoriaProsta(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodajTowar(Towar towar) {
        towary.add(towar);
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }

    @Override
    public void wypisz(String wciecie) {
        System.out.println(wciecie + "Kategoria: " + nazwa);

        for (Towar towar : towary) {
            System.out.println(wciecie + " - " + towar.getNazwa() + " (" + towar.getCena() + ")");
        }
    }
}
