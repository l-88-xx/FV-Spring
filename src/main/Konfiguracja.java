package main;

import rabaty.ObliczCenePoRabacie;
import raporty.AdapterKlasowy;
import raporty.DrukFVProsta;
import raporty.DrukFVZlozona;
import raporty.DrukFaktury;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Klasa odpowiada za dostarczanie strategii rabatowych oraz drukarek faktur.
 * Wzorzec SINGLETON.
 */

public class Konfiguracja {

    private static final Konfiguracja instance = new Konfiguracja();

    private Konfiguracja() {
    }

    public static Konfiguracja getInstance() {

        return instance;
    }

    public double getKwotaRabatu() {
        return 9;
    }

    public double getProcentRabatu() {
        return 0.25;
    }

    public ObliczCenePoRabacie getBiezacyRabat() {
        //return new ObliczCenePoRabacieKwotowym();
        //return new ObliczCenePoRabacieProcentowym();
        //return new AdapterObiektowy();
        return new AdapterKlasowy();
    }

    public static DrukFaktury pobierzDrukarke() {
        Properties props = new Properties();
        try {
            InputStream stream = Konfiguracja.class.getResourceAsStream("/config.properties");
            if (stream == null) {
                throw new RuntimeException("Brak pliku config.properties!");
            }
            props.load(stream);
        } catch (IOException e) {
            throw new RuntimeException("Brak pliku konfiguracyjnego!");
        }
        String typ = props.getProperty("druk");
        return switch (typ) {
            case "prosty" -> new DrukFVProsta();
            case "zlozony" -> new DrukFVZlozona();
            default -> throw new IllegalArgumentException("Nieznany typ drukarki: " + typ);
        };
    }
}
