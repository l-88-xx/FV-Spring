package rabaty;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie {

    private double procent;

    public void setProcent(double procent) {
        this.procent = procent;
    }

    @Override
    public double obliczCenePoRabacie(double cena) {

        return cena * (1 - procent);
    }
}
