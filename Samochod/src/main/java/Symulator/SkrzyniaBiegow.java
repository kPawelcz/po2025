package Symulator;

public class SkrzyniaBiegow extends Komponent{

    private int aktualnyBieg;
    private int iloscBiegow;
    private double aktualnePrzelozenie;

    public SkrzyniaBiegow(String producent, String model, int cena, int waga, String nazwa, int iloscBiegow){
        super(producent, model, cena, waga, nazwa);
        this.iloscBiegow = iloscBiegow;
        this.aktualnyBieg = 0;
        this.aktualnePrzelozenie = 0.0;
    }

    public void zwiekszBieg(boolean wcisnieteSprzeglo){
        if(wcisnieteSprzeglo) {
            if (aktualnyBieg < iloscBiegow) {
                aktualnyBieg += 1;
                obliczPrzelozenie();
            } else {
                aktualnyBieg = iloscBiegow;
            }
        }else{
            System.out.println("Wciścnij sprzęgło!");
            }
        }

    public void zmniejszBieg(boolean wciscnieteSprzeglo) {
        if (wciscnieteSprzeglo) {
            if (aktualnyBieg > 0) {
                aktualnyBieg -= 1;
                obliczPrzelozenie();
            }
             else if (aktualnyBieg == 0) {
            System.out.println("Jesteś na luzie");
        }
        }else{
            System.out.println("Wciśnij sprzęgło!");
            }
        }

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public double getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }

    private void obliczPrzelozenie() {
        if (aktualnyBieg == 0) {
            aktualnePrzelozenie = 0.0;
        } else {
            aktualnePrzelozenie = 1.0 + (iloscBiegow - aktualnyBieg) * 0.5;
        }
    }


}

