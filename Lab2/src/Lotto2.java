import java.util.ArrayList;
import java.util.Random;

public class Lotto2{
    public static void main(String[] args) {
        ArrayList<Integer> liczby = new ArrayList<Integer>();
        Random liczba = new Random();

        for(int i=0; liczby.size()<6 ; i++){
            int probka = liczba.nextInt(1,49);
            if(liczby.contains(probka)){
                continue;
            }
            else{
                liczby.add(probka);
            }
        }
        for(int i = 0; i<6; i++) {
            System.out.print(liczby.get(i) + " ");
        }
        System.out.println();
    }
}