package Symulator;

public class Skrzynia_Biegów extends Komponent{

    private int aktualnyBieg;
    private int iloscBiegow;

    public void setIloscBiegow(int iloscBiegow) {
        this.iloscBiegow = iloscBiegow;
    }


    Sprzęgło sprzeglo = new Sprzęgło();
    boolean stan_sprzegla = sprzeglo.isStanSprzegla();


    void zwiekszBieg(){
        if(aktualnyBieg < iloscBiegow){
            if(stan_sprzegla == true) {
                aktualnyBieg += 1;
                stan_sprzegla = false;
            }
        }
        else{
            aktualnyBieg = iloscBiegow;
        }
    }

    void zmniejszBieg(){
        if(aktualnyBieg>0){
            if(stan_sprzegla == true) {
                aktualnyBieg -= 1;
                stan_sprzegla = false;
            }
        }
        if(aktualnyBieg == 0){
            System.out.println("Jesteś na luzie");
        }
    }

    public int getAktualnyBieg() {
        return aktualnyBieg;
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

