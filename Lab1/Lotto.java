import java.util.Random;

public class Lotto {
    public static void main(String[] args) {

        Random liczba = new Random();

        int[] liczby = new int[6];
        liczby[5] = 0;
        boolean zmienna = true;

        while (zmienna){
            int probka = liczba.nextInt(1,49);

            for(int i = 0; i < liczby.length; i++){
                if (liczby[i] == probka){
                    break;
                }
                else if (!(liczby[i] == probka)){
                    liczby[i] = probka;
                    probka = liczba.nextInt(1,49);
                    if (!(liczby[5] == 0)){
                        zmienna = false;

                    }
                }
            }
        }
        for(int licz : liczby) {
            System.out.print(licz + " ");
        }
        }
    }
