import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        int ilosc_liczb = Integer.parseInt(args[0]);
        Random liczba = new Random();

        for(int i = 0; i < ilosc_liczb; i++) {

            System.out.println(liczba.nextInt(1,49));

        }
    }
}