package Symulator;

public class Komponent {

    private String nazwa;
    private int cena;
    private double waga;
    private String producent;
    private String model;


    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setWaga(double waga) {
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

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
