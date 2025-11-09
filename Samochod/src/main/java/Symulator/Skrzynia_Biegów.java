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
        if(aktualnyBieg < 3){
            aktualnePrzelozenie = 0.5;
            System.out.println("Aktualne przełożenie jest niskie");
        }
        else if(aktualnyBieg > 4){
            aktualnePrzelozenie = 8;
            System.out.println("Aktualne przełożenie jest wysokie");
        }
        else{
            aktualnePrzelozenie = 1;
            System.out.println("Aktualne przełożenie jest średnie");
        }
    }

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public double getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }
}
