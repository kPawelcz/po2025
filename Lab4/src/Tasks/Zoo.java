package Tasks;

import java.util.Random;
import Animals.Animal;
import Animals.Dog;
import Animals.Parrot;
import Animals.Snake;


public class Zoo {
    Animal[] animals = new Animal[100];

    public static void main() {
        Zoo zoo = new Zoo();

        Random rand = new Random();

        int liczba = 0;
        int nogi = 0;
        for (int i = 0; i < 100; i++) {
            liczba = rand.nextInt(1, 4);
            if (liczba == 1) {
                Dog dog = new Dog();
                zoo.animals[i] = dog;
                nogi = nogi + dog.legs;
            } else if (liczba == 2) {
                Parrot parrot = new Parrot();
                zoo.animals[i] = parrot;
                nogi = nogi + parrot.legs;
            } else {
                Snake snake = new Snake();
                zoo.animals[i] = snake;
                nogi = nogi + snake.legs;
            }

            System.out.println(zoo.animals[i].getDescription());
        }
        System.out.println("Ilość nóg zwierząt: " + nogi);

    }
}
