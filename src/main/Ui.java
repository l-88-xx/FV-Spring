package main;

import dokumenty.Faktura;
import kategorie.KategoriaProsta;
import kategorie.KategoriaZlozona;
import magazyn.Towar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import raporty.DrukFaktury;
import raporty.WydrukFaktury;

/**
 * Klasa przedstawia wzorce projektowe:
 * - TEMPLATE METHOD (DrukFaktury)
 * - STRATEGIA (rabaty)
 * - ADAPTER (LosowyRabat z JAR)
 * - FASADA (WydrukFaktury)
 * - COMPOSITE (drzewo kategorii)
 */

public class Ui {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "beans.xml");

        //Tworzymy towary (Spring)
        Towar t1 = context.getBean("towar1", Towar.class);
        Towar t2 = context.getBean("towar2", Towar.class);
        Towar t3 = context.getBean("towar3", Towar.class);

        System.out.println("Utworzono towary:");
        System.out.println("- " + t1.getNazwa() + " | cena: " + t1.getCena());
        System.out.println("- " + t2.getNazwa() + " | cena: " + t2.getCena());
        System.out.println("- " + t3.getNazwa() + " | cena: " + t3.getCena());

        System.out.println("Aktualna strategia rabatu ustawiona w Spring XML");

        //I przykladowa FV
        Faktura f = context.getBean("faktura", Faktura.class);

        // rabat naliczony przy dodawaniu pozycji
        f.dodajPozycje(t1, 3);
        f.dodajPozycje(t2, 5);
        f.dodajPozycje(t3, 6);

        /**
         * FASADA
         */
        System.out.println("\nFASADA - WydrukFaktury");
        WydrukFaktury.wypiszFakture(f);

        /**
         * TEMPLATE METHOD
         */
        System.out.println("\nTEMPLATE METHOD - Wydruk FV wybraną drukarką z konfiguracji: ");
        DrukFaktury drukarka = Konfiguracja.pobierzDrukarke();
        drukarka.drukujFakture(f);


        System.out.println("Zmiana ceny towaru buty, po wystawieniu FV");
        t1.setCena(250);

        System.out.println("Nowa cena: " + t1.getCena());
        System.out.println("Cena na FV pozostaje bez zmian");

        WydrukFaktury.wypiszFakture(f);

/*        System.out.println("Zewnętrzny rabat");
        LosowyRabat lr = new LosowyRabat();
        System.out.println("Losowy rabat (0–0.3): " + lr.losujRabat());*/

        /**
         * Composite – drzewo kategorii
         */

        KategoriaZlozona root = new kategorie.KategoriaZlozona("Sklep");
        KategoriaZlozona odziez = new KategoriaZlozona("Odzież");
        KategoriaZlozona obuwie = new KategoriaZlozona("Obuwie");

        KategoriaProsta letnia = new kategorie.KategoriaProsta("Odzież letnia");
        KategoriaProsta dodatki = new KategoriaProsta("Dodatki");

        letnia.dodajTowar(t1);
        t1.setKategoria(letnia);
        letnia.dodajTowar(t3);
        dodatki.dodajTowar(t2);

        odziez.dodaj(letnia);
        odziez.dodaj(dodatki);

        root.dodaj(odziez);
        root.dodaj(obuwie);

        System.out.println("\nDrzewo kategorii:");
        root.wypisz("");
    }
}
