package Symulator;

public class Sprzęgło extends Komponent{
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


    @Override
    public String getNazwa() {
        return super.getNazwa();
    }

    @Override
    public double getWaga() {
        return super.getWaga();
    }

    @Override
    public int getCena() {
        return super.getCena();
    }


}
