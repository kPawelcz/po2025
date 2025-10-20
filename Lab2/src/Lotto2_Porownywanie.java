import java.util.ArrayList;
import java.util.Random;

public class Lotto2_Porownywanie {
    public static void main(String[] args) {
        ArrayList<Integer> liczby = new ArrayList<Integer>();
        ArrayList<Integer> podane_liczby = new ArrayList<Integer>();
        Random liczba = new Random();


        for (int i = 0; podane_liczby.size() < 6; i++) {
            podane_liczby.add(i,Integer.parseInt(args[i]));
        }

        for(int i=0; liczby.size()<6 ; i++){
            int probka = liczba.nextInt(1,49);
            if(liczby.contains(probka)){
                continue;
            }
            else{
                liczby.add(probka);
            }
        }
        System.out.println("Wylosowane liczby Liczby: ");
        System.out.println(liczby);
        System.out.println("Podane Liczby: ");
        System.out.println(podane_liczby);

        liczby.retainAll(podane_liczby);

        System.out.println("Pokrywające się liczby");

        System.out.println(liczby);
        System.out.println("Ilość pokrywających się liczb: " + liczby.size());

    }
}
