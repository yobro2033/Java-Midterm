import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class Main {

    public static String getAnimalInfo(String animalName) {
        String animalInfo = "None";
        if (animalName.equals("orangutan")) {
            animalInfo = "There are 105000 orangutans in the wild. They are critically endangered.";
        } else if (animalName.equals("pygmy elephant")) {
            animalInfo = "There are 1500 pygmy elephants in the wild. They are endangered.";
        } else if (animalName.equals("rhino")) {
            animalInfo = "There are 3500 rhinos in the wild. They are vulnerable.";
        } else {
            animalInfo = "I don’t know anything about that animal.";
        }
        return animalInfo;
    }

    public static int viewCounter(int totalView) {
        totalView = totalView + 1;
        return totalView;
    }

    public static void print(String args) {
        System.out.println(args);
    }

    public static String testValidateString() {
        String animalName;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                animalName = sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                print("Invalid input. Please reenter: ");
                sc.nextLine();
            }
        }
        return animalName;
    }

    public static void main(String[] args) {
        int holidayStays = 6;
        String animalName;
        String animalInfo;
        int totalView = 0;

        Scanner sc = new Scanner(System.in);
        print("What was the most exciting animal you saw each day of the holiday?");
        print("(I know about orangutan, rhino and pygmy elephant)");

        for (int i = 1; i <= holidayStays; i++) {
            String txtString = "Day " + i + ":";
            print(txtString);
            animalName = testValidateString();
            animalInfo = getAnimalInfo(animalName);
            print(animalInfo);
            if (animalName.equals("orangutan")) {
                totalView = viewCounter(totalView);
            }
        }
        sc.close();
        print("\n");
        String txtString = "You saw orangutans on " + totalView + " separate days.";
        print(txtString);
    }
}