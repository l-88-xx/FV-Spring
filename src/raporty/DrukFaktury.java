package raporty;

import dokumenty.Faktura;
import dokumenty.Pozycja;

/**
 * Klasa bazowa abstrakcyjna.
 * Szkielet procesu drukowania faktury.
 * Wzorzec TEMPLATE METHOD.
 */

public abstract class DrukFaktury {

    protected void drukujNaglowek(Faktura faktura) {
    }

    protected abstract void drukujPozycje(Pozycja pozycja);

    protected void drukujStopke(Faktura faktura) {
    }

    public void drukujFakture(Faktura faktura) {

        drukujNaglowek(faktura);

        for (Pozycja p : faktura.getPozycje()) {
            drukujPozycje(p);
        }
        drukujStopke(faktura);
    }
}
