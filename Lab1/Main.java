public class Main{
    public static void main(String[] args) {

        System.out.print("Hello, World!\n");

        int wysokosc = Integer.parseInt(args[0]);
        int licznik=0;
        String string="*";
        for(int i=1; i <= wysokosc; i++){
            licznik++;
            System.out.println(string.repeat(licznik));
        }

    }
}
