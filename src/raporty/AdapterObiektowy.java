package raporty;

import main.Konfiguracja;
import rabatlosowy.LosowyRabat;
import rabaty.ObliczCenePoRabacie;

/**
 * Adapter obiektowy, który dostosowuje LosowyRabat do strategii rabatowej.
 * Rabat procentowy w zakresie 0–30%.
 */

public class AdapterObiektowy implements ObliczCenePoRabacie {

    @Override
    public double obliczCenePoRabacie(double cena) {

        LosowyRabat lr = new LosowyRabat();
        Konfiguracja k = Konfiguracja.getInstance();
        double procent = lr.losujRabat();
        return cena - cena * procent;
    }
}
