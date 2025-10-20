import java.util.ArrayList;
import java.util.Random;

public class Lotto2_Trafienie {
    public static void main(String[] args) {
        double start = System.currentTimeMillis();
        ArrayList<Integer> liczby = new ArrayList<Integer>();
        ArrayList<Integer> pokrywajace_liczby = new ArrayList<>();
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
        System.out.println("Wylosowane liczby Liczby: ");
        System.out.println(liczby);

        ArrayList<Integer> podane_liczby = liczby;
        boolean zmienna = true;
        int licznik = 0;
        while (zmienna){

            podane_liczby = liczby;
            for(int i=0; pokrywajace_liczby.size()<6 ; i++) {
                int probka2 = liczba.nextInt(1, 49);
                if (pokrywajace_liczby.contains(probka2)) {
                    continue;
                } else {
                    pokrywajace_liczby.add(probka2);
                }
            }
            pokrywajace_liczby.retainAll(podane_liczby);
            if(pokrywajace_liczby.size() == 6){
                    licznik ++;
                    System.out.println("Brawo trafiles po: " + licznik + " probach");
                    zmienna = false;
            }
            else{
                licznik++;
                }
            }

        double end = System.currentTimeMillis();
        double czas = end - start;
        System.out.println("Czas wykonywania operacji: " + czas);





    }
}
