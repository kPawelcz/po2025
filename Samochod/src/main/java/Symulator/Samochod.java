package Symulator;

public class Samochod extends Thread{

    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Sprzeglo sprzeglo;
    private Pozycja pozycja;

    private String nrRejestracyjny;
    private String model;
    private double predkosc;

    public Samochod(String nrRejestracyjny, String model, int waga){
        this.nrRejestracyjny = nrRejestracyjny;
        this.model = model;
        this.predkosc = 0.0;

        this.silnik = new Silnik("Producent", "V8", 5000, waga/2, "Silnik", 6000);
        this.skrzynia = new SkrzyniaBiegow("Producent", "Manual", 1000, 50, "Skrzynia", 5);
        this.sprzeglo = new Sprzeglo("Producent", "Standard", 500, 10, "Sprzęgło");
        this.pozycja = new Pozycja(0, 0);
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }

    public Pozycja getPozycja() {
        return pozycja;
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public String getModel() {
        return model;
    }

    public double getPredkosc() {
        return predkosc;
    }

    @Override
    public String toString() {
        return model + " (" + nrRejestracyjny + ")";
    }
}
