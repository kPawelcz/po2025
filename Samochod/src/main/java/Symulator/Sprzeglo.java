package Symulator;

public class Sprzeglo extends Komponent{
    private boolean stanSprzegla;


    public Sprzeglo(String producent, String model, int cena, int waga, String nazwa){
        super(producent, model, cena, waga, nazwa);
        this.stanSprzegla = false;
    }
    public void wcisnij(){
        stanSprzegla = true;
    }

    public void zwolnij(){
        stanSprzegla = false;
    }

    public boolean isStanSprzegla() {
        return stanSprzegla;
    }
}
