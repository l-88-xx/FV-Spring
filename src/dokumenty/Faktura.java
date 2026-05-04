package dokumenty;

import magazyn.Towar;
import main.Konfiguracja;
import rabaty.ObliczCenePoRabacie;

import java.util.*;

/**
 * Klasa odpowiada za fakturę sprzedaży.
 * Faktura składa się z:
 * - listy pozycji,
 * - daty sprzedaży
 * - danych kontrahenta.
 * Przy dodawania pozycji stosowany jest wzorzec STRATEGIA – cena towaru
 * jest modyfikowana zgodnie z aktualnie wybraną metodą obliczania rabatu.
 * Źródło strategii rabatowej pobierane jest z klasy Konfiguracja (SINGLETON).
 */

public class Faktura {
    private Date dataSprzedazy;
    private String kontrahent;
    private ArrayList<Pozycja> pozycje;
    private double suma;

    private ObliczCenePoRabacie liczarkaRabatu;

    public Faktura(Date dataSprzedazy, String kontrahent) {
        this.dataSprzedazy = dataSprzedazy;
        this.kontrahent = kontrahent;
        pozycje = new ArrayList<>();
        suma = 0;
        //liczarkaRabatu = new ObliczCenePoRabacieProcentowym();
        //liczarkaRabatu = new ObliczCenePoRabacieKwotowym();

        Konfiguracja k = Konfiguracja.getInstance();
        liczarkaRabatu = k.getBiezacyRabat();
    }

    public void dodajPozycje(Towar towar, double ilosc) {

        if (ilosc <= 0) {
            throw new IllegalArgumentException("Ilość musi być większa niż 0");
        }

        int lp = pozycje.size() + 1;
        Pozycja p = new Pozycja(towar, ilosc, lp);

        // strategia (rabat na pozycji)
        double cenaPoRabacie = liczarkaRabatu.obliczCenePoRabacie(towar.getCena());

        p.setCena(cenaPoRabacie);

        pozycje.add(p);
        this.przeliczSume();
    }

    public double getSuma() {
        return suma;
    }

    public Date getDataSprzedazy() {
        return dataSprzedazy;
    }

    public String getKontrahent() {
        return this.kontrahent;
    }

    public Iterator<Pozycja> getIteratorPozycji() {
        return pozycje.iterator();
    }

    public List<Pozycja> getPozycje() {
        return Collections.unmodifiableList(pozycje);
    }

    public String getNazwaFirmy() {
        return "Firma Sp. z o.o.";
    }

    //Jak zmienimy coś na FV, trzeba wywolać
    private void przeliczSume() {
        Iterator<Pozycja> iteratorPozycji = pozycje.iterator();
        Pozycja pozycja;
        suma = 0;
        while (iteratorPozycji.hasNext()) {
            pozycja = iteratorPozycji.next();
            suma += pozycja.getWartosc();
        }
        //suma = liczarkaRabatu.obliczCenePoRabacie(suma);
    }
}
