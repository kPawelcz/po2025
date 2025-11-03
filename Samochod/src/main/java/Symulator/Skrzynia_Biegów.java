package Symulator;

public class Skrzynia_Biegów{
    private int aktualnyBieg;
    private int iloscBiegow = 6;
    private double aktualnePrzelozenie;


    void zwiekszBieg(){
        if(aktualnyBieg < iloscBiegow){
            aktualnyBieg += 1;
        }
        else{
            aktualnyBieg = iloscBiegow;
        }
    }

    void zmniejszBieg(){
        if(aktualnyBieg>0){
            aktualnyBieg -= 1;
        }
        if(aktualnyBieg == 0){
            System.out.println("Jesteś na luzie");
        }
    }

    void przelozenieAbieg(){

    }

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public double getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }
}
