package Symulator;

public class Samochód {

    private boolean stanWłączenia;
    public String nrRejestracji;
    private String model;
    public int predkość_max;

    public Samochód(String model, String nrRejestracji, int predkość_max ){
        this.model = model;
        this.nrRejestracji = nrRejestracji;
        this.predkość_max = predkość_max;


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

    private double przelozenie;
    void przelozenie(){
        skrzynia.przelozenieAbieg();
        przelozenie = skrzynia.getAktualnePrzelozenie();
        System.out.println("Wartość przełożenie to: " + przelozenie);
    }



}
