package Symulator;

public class Silnik extends Komponent{

    private int maxobroty;
    private int obroty;
    private boolean uruchomiony;

    public Silnik(String producent, String model, int cena, int waga, String nazwa, int maxobroty ){
        super(producent, model, cena, waga, nazwa);
        this.maxobroty = maxobroty;
        this.uruchomiony = false;
    };

    public int getObroty() {
        return obroty;
    }

    public void zwiekszObroty(int zwiekszenie){
        if(uruchomiony) {
            if (obroty < maxobroty) {
                if (obroty + zwiekszenie < maxobroty) {
                    obroty += zwiekszenie;
                } else {
                    obroty = maxobroty;
                }
            } else {
                System.out.println("Obroty są już na maksymalnym poziomie! --- " + maxobroty);
            }
        }
    }

    public void zmniejszObroty(int zmniejszenie){
         if(uruchomiony){
             if (obroty > 0) {
                 if (obroty - zmniejszenie > 0) {
                     obroty -= zmniejszenie;
                 } else {
                     obroty = 0;
                 }
             } else {
                 System.out.println("Obroty są już na minimalnym poziomie! --- " + 0);
             }
         }
    }

    public void uruchom(){
        uruchomiony = true;
        obroty = 1000;
    }

    public void zatrzymaj(){
        uruchomiony = false;
        obroty = 0;
    }


}

