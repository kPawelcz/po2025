package Symulator;

public class Komponent {

    private String nazwa;
    private int cena;
    private double waga;
    private String producent;
    private String model;

    public Komponent(String producent,String model,int cena, int waga, String nazwa){
        this.nazwa = nazwa;
        this.producent = producent;
        this.model = model;
        this.cena = cena;
        this.waga = waga;
    }




    public String getNazwa() {
        return nazwa;
    }

    public int getCena() {
        return cena;
    }

    public double getWaga() {
        return waga;
    }

    public String getProducent() {
        return producent;
    }


    public String getModel() {
        return model;
    }

}
