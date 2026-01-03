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

    @Override
    public void run() {
        while (true) { // Pętla nieskończona - symulacja działa cały czas
            try {
                // 1. Sprawdzamy czy silnik działa
                if (silnik.getObroty() > 0) {

                    // 2. Pobieramy aktualny bieg
                    int bieg = skrzynia.getAktualnyBieg();

                    // 3. Prosty wzór fizyczny: V = Obroty * Bieg * Stała
                    // (Na luzie bieg = 0, więc prędkość = 0 - logiczne)
                    this.predkosc = silnik.getObroty() * bieg * 0.005;

                    // 4. Aktualizujemy pozycję na mapie (Lab 10 - jazda do celu)
                    // Zakładamy, że jedziemy "na skos" (zwiększamy X i Y)
                    // Szybciej jedziesz -> szybciej się przemieszczasz
                    pozycja.przemiesc(this.predkosc * 0.01, this.predkosc * 0.01);

                } else {
                    this.predkosc = 0.0;
                }

                // 5. Czekamy 100ms (żeby nie zajechać procesora)
                Thread.sleep(100);

            } catch (InterruptedException e) {
                // Jeśli ktoś przerwie wątek, kończymy działanie
                System.out.println("Symulacja samochodu przerwana.");
                break;
            }
        }
    }
}
