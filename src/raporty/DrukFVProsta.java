package raporty;

import dokumenty.Faktura;
import dokumenty.Pozycja;

/**
 * Klasa odpowiada za drukowanie faktury prostej.
 * Zawiera nagłówek, listę pozycji oraz sumę.
 */

public class DrukFVProsta extends DrukFaktury {

    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("FIRMA: " + faktura.getNazwaFirmy());
        System.out.println("DATA: " + faktura.getDataSprzedazy());
        System.out.println("---------------------------");
    }

    @Override
    protected void drukujPozycje(Pozycja p) {
        System.out.println(
                p.getNazwa() + " | ilość: " + p.getIlosc() +
                        " | cena: " + p.getCena() +
                        " | wartość: " + p.getWartosc()
        );
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("---------------------------");
        System.out.println("SUMA: " + faktura.getSuma());
    }
}

