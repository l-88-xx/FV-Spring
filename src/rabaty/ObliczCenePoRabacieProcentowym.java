package rabaty;

import main.Konfiguracja;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie {

    @Override
    public double obliczCenePoRabacie(double cena) {
        Konfiguracja k = Konfiguracja.getInstance();
        //double procent = 10.0;
        double procent = k.getProcentRabatu();
        return cena * (1 - procent);
    }
}
