package Symulator;

public class Samochod extends Thread{

    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;
    private Sprzeglo sprzeglo;
    private Pozycja pozycja;

    private String nrRejestracyjny;
    private String model;
    private double predkosc;
    private Pozycja cel;


    public Samochod(String nrRejestracyjny, String model, int waga){
        this.nrRejestracyjny = nrRejestracyjny;
        this.model = model;
        this.predkosc = 0.0;

        if (waga < 1000) {
            // Małe auto (np. Fiat 126p)
            // Słabszy silnik (4500 obrotów), skrzynia 4-biegowa
            this.silnik = new Silnik("FSM", "R2", 1000, 100, "Mały Silnik", 4500);
            this.skrzynia = new SkrzyniaBiegow("FSM", "Manual", 500, 30, "Skrzynia 4B", 4);

        } else if (waga < 1600) {
            // Średnie auto (np. Polonez)
            // Średni silnik (6000 obrotów), skrzynia 5-biegowa
            this.silnik = new Silnik("FSO", "R4", 3000, 150, "Silnik 1.6", 6000);
            this.skrzynia = new SkrzyniaBiegow("FSO", "Manual", 1000, 50, "Skrzynia 5B", 5);

        } else {
            // Ciężkie/Sportowe auto
            // Mocny silnik (7500 obrotów), skrzynia 6-biegowa
            this.silnik = new Silnik("V8", "Turbo", 10000, 300, "Monster V8", 7500);
            this.skrzynia = new SkrzyniaBiegow("ZF", "Sport", 3000, 80, "Skrzynia 6B", 6);
        }
        this.sprzeglo = new Sprzeglo("Valeo", "Standard", 500, 10, "Sprzęgło");
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

    public void jedzDo(Pozycja nowaPozycja){
        cel = nowaPozycja;
    }

    @Override
    public void run() {
        // Zgodnie z PDF: deltat (krok czasowy) = 0.1 sekundy
        double deltat = 0.1;

        while (true) {
            try {
                // Obliczamy prędkość
                if (silnik.getObroty() > 0) {
                    int bieg = skrzynia.getAktualnyBieg();
                    this.predkosc = silnik.getObroty() * bieg * 0.005;
                } else {
                    this.predkosc = 0.0;
                }

                // Sprawdzamy, czy mamy wyznaczony cel
                if (cel != null) {

                    double deltaX = cel.getX() - pozycja.getX();
                    double deltaY = cel.getY() - pozycja.getY();
                    double odleglosc = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

                    if (odleglosc > 1) {

                        double ruchX = this.predkosc * deltat * deltaX / odleglosc;
                        double ruchY = this.predkosc * deltat * deltaY / odleglosc;


                        pozycja.przemiesc(ruchX, ruchY);
                    } else {

                        cel = null;
                    }
                }

                Thread.sleep(100);

            } catch (InterruptedException e) {
                System.out.println("Wątek przerwany");
                break;
            }
        }
    }
}
