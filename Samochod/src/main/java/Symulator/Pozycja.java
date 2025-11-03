package Symulator;

import static java.lang.Math.sqrt;

public class Pozycja {
    public double x = 0;
    public double y = 0;
    private String kordynaty;
    double odleglosc;

    void aktualizujPozycje(double deltaX, double deltaY){
        x = x + deltaX;
        y = y + deltaY;
    }

    void aktualizujPozycjeX(double deltaX){
        x = x + deltaX;
    }

    void aktualizujPozycjeY(double deltaY){
        y = y + deltaY;
    }

    String getPozycja(){
        kordynaty = "Samochód znajduje się na współrzędnych X: " + x + " Y: " + y;
        return kordynaty;
    }

    void ileDoDomu(){
        odleglosc = sqrt(x*x + y*y);
        System.out.println("Twoja odległość od domu wynosi: " + odleglosc);
    }

}
