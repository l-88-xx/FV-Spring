package raporty;

import dokumenty.Faktura;
import dokumenty.Pozycja;

/**
 * Klasa odpowiada za drukowanie faktury złożonej.
 * Dodaje numerację pozycji, VAT oraz kwoty brutto.
 */

public class DrukFVZlozona extends DrukFaktury {

    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("=== FAKTURA VAT ===");
        System.out.println("Sprzedawca: " + faktura.getNazwaFirmy());
        System.out.println("Data wystawienia: " + faktura.getDataSprzedazy());
        System.out.println("====================================");
        System.out.println("LP | NAZWA | ILOŚĆ | CENA | WARTOŚĆ");
    }

    @Override
    protected void drukujPozycje(Pozycja p) {
        System.out.println(p.getLp() + " | " + p.getNazwa() + " | "
                + p.getIlosc() + " | " + p.getCena() + " | " + p.getWartosc());
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("====================================");
        System.out.println("NETTO: " + faktura.getSuma());
        System.out.println("VAT 23%: " + faktura.getSuma() * 0.23);
        System.out.println("BRUTTO: " + faktura.getSuma() * 1.23);
    }
}
