package Symulator;

public class Samochód {

    private boolean stanWłączenia;
    public String nrRejestracji;
    private String model;
    public int predkość_max;

    public Samochód(){
        wlacz();
        zwiekszBieg();
        zwiekszBieg();

    }


    Silnik silnik = new Silnik();
    Skrzynia_Biegów skrzynia = new Skrzynia_Biegów();


    void wlacz(){
        silnik.uruchom();
    }

    void wylacz(){
        silnik.zatrzymaj();
    }

    void zwiekszBieg(){
        skrzynia.zwiekszBieg();
    }

    void zmniejszBieg(){
        skrzynia.zmniejszBieg();
    }



}
