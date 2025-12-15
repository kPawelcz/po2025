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
    }


    Silnik silnik = new Silnik();
    Skrzynia_Biegów skrzynia = new Skrzynia_Biegów();
    Sprzęgło sprzeglo = new Sprzęgło();

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

    public String getModel(){
        return model;
    }

    public void wcisnijSprzeglo(){sprzeglo.wcisnij();}


    public void zwolnijSprzeglo(){sprzeglo.zwolnij();}

    public void zwieksz_obroty(){silnik.zwiekszObroty(100);}
    public void zmniejsz_obroty(){silnik.zmniejszObroty(100);}

    public int getWaga(){
        return waga;
    }
    public int dajBieg() { return skrzynia.getAktualnyBieg(); }

}
