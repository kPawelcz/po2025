import java.util.Random;

public class Porownywanie_Lotto {
    public static void main(String[] args) {

        int[] podane_licbzy = new int[6];

        for (int i = 0; i < podane_licbzy.length; i++) {
            podane_licbzy[i] = Integer.parseInt(args[i]);
        }

        Random liczba = new Random();

        int[] liczby = new int[6];
        liczby[5] = 0;
        boolean zmienna = true;

        while (zmienna) {
            int probka = liczba.nextInt(1, 49);

            for (int i = 0; i < liczby.length; i++) {
                if (liczby[i] == probka) {
                    break;
                } else if (!(liczby[i] == probka)) {
                    liczby[i] = probka;
                    probka = liczba.nextInt(1, 49);
                    if (!(liczby[5] == 0)) {
                        zmienna = false;

                    }
                }
            }
        }

        for (int licz : liczby) {
            System.out.print(licz + " ");
        }

        System.out.println();

        for (int licz : podane_licbzy) {
            System.out.print(licz + " ");
        }
        System.out.println();

        int licznik = 0;
        for(int i = 0; i < liczby.length; i++) {
            for(int j = 0; j < podane_licbzy.length; j++) {
                if (liczby[i] == podane_licbzy[j]) {

                    licznik++;
                }
            }
        }
        System.out.println("Wylosowałeś " + licznik + " takich samych liczb");
    }
}
