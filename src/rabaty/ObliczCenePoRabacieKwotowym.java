package rabaty;

public class ObliczCenePoRabacieKwotowym implements ObliczCenePoRabacie {

    private double kwota;

    public void setKwota(double kwota) {
        this.kwota = kwota;
    }

    @Override
    public double obliczCenePoRabacie(double cena) {

        // nie ma ujemnego rabatu
        return Math.max(0, cena - kwota);
    }
}
