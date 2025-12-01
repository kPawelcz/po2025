package Symulator;

public class Samochód {

    private boolean stanWłączenia;
    public String nrRejestracji;
    private String model;
    public int predkość_max;
    public int waga;

    public Samochód(String model, String nrRejestracji, int predkość_max, int waga ){
        this.model = model;
        this.nrRejestracji = nrRejestracji;
        this.predkość_max = predkość_max;
        this.waga = waga;


        wlacz();
        zwiekszBieg();
        zwiekszBieg();
        zwiekszBieg();
        zmniejszBieg();
        zwiekszBieg();
        przelozenie();
        wylacz();
    }


    Silnik silnik = new Silnik();
    Skrzynia_Biegów skrzynia = new Skrzynia_Biegów();


    public void wlacz(){
        silnik.uruchom();
    }

    public void wylacz(){
        silnik.zatrzymaj();
    }

    public void zwiekszBieg(){
        skrzynia.zwiekszBieg();
    }

    public void zmniejszBieg(){
        skrzynia.zmniejszBieg();
    }

    private double przelozenie;

    public void przelozenie(){
        skrzynia.przelozenieAbieg();
        przelozenie = skrzynia.getAktualnePrzelozenie();
        System.out.println("Wartość przełożenie to: " + przelozenie);
    }

    public String getModel(){
        return model;
    }

    public int getPredkość_max(){
        return predkość_max;
    }

    public String getNrRejestracji(){
        return nrRejestracji;
    }
    public int getWaga(){
        return waga;
    }
    public int dajBieg() { return skrzynia.getAktualnyBieg(); }

}
