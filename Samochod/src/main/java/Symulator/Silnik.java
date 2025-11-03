package Symulator;

public class Silnik{
    private final int maxobroty = 10000;
    private int obroty;

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
}
