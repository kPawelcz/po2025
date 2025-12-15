package Symulator;

public class Silnik extends Komponent{

    private int maxobroty;
    private int obroty;

    public Silnik(String nazwa, int cena, int Waga, int maxobroty ){
        super(nazwa,cena,Waga);
        this.maxobroty = maxobroty;
    };

    public int getObroty() {
        return obroty;
    }

    void zwiekszObroty(int zwiekszenie){
        if(obroty < maxobroty){
            if(obroty + zwiekszenie < maxobroty){
                obroty += zwiekszenie;
            }
            else{
                obroty = maxobroty;
            }
        }
        else{
            System.out.println("Obroty są już na maksymalnym poziomie! --- " + maxobroty);
        }

    }

    void zmniejszObroty(int zmniejszenie){
        if(obroty > 0){
            if(obroty - zmniejszenie > 0){
                obroty += zmniejszenie;
            }
            else{
                obroty = 0;
            }
        }
        else{
            System.out.println("Obroty są już na minimalnym poziomie! --- " + 0);
        }

    }

    void uruchom(){
        obroty = 1000;
    }

    void zatrzymaj(){
        obroty = 0;
    }


    @Override
    public String getNazwa() {
        return super.getNazwa();
    }

    @Override
    public int getCena() {
        return super.getCena();
    }

    @Override
    public double getWaga() {
        return super.getWaga();
    }


}

