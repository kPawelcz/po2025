package Symulator;

import static java.lang.Math.sqrt;

public class Pozycja {
    private double x = 0;
    private double y = 0;

    public Pozycja(double startX, double startY){
        this.x = startX;
        this.y = startY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void przemiesc(double deltaX, double deltaY){
        this.x += deltaX;
        this.y += deltaY;

    }

    @Override
    public String toString() {
        return "Poz: [" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + "]";
    }
}
