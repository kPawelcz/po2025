package Symulator;

public class Sprzęgło {
    private boolean stanSprzegla = false;

    void wcisnij(){
        stanSprzegla = true;
    }

    void zwolnij(){
        stanSprzegla = false;
    }

    public boolean isStanSprzegla() {
        return stanSprzegla;
    }
}
