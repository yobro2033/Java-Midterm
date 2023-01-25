// Quoc Viet Phan
// 220364926
// Excersie 8
// Sun 9 Oct

import java.util.Scanner;
import java.util.InputMismatchException;

// Create and define new record
class SkiiingRelay {
    int pointLimit;
    int skier1Class;
    int skier2Class;
    int skier3Class;
}

public class exe8 {

    // Create a new record from defined record above
    public static SkiiingRelay createRecord(int pointLimit, int skier1Class, int skier2Class, int skier3Class) {
        SkiiingRelay d = new SkiiingRelay();
        d.pointLimit = pointLimit;
        d.skier1Class = skier1Class;
        d.skier2Class = skier2Class;
        d.skier3Class = skier3Class;
        return (d);
    }

    // Getter methods for Skiing Relay
    // Return the list of attributes from SkiingRelay record
    // Return Name
    public static int getPointLimit(SkiiingRelay d) {
        return d.pointLimit;
    }

    // Return skier1Class
    public static int getSkier1Class(SkiiingRelay d) {
        return d.skier1Class;
    }

    // Return skier2Class
    public static int getSkier2Class(SkiiingRelay d) {
        return d.skier2Class;
    }

    // Return skier3Class
    public static int getSkier3Class(SkiiingRelay d) {
        return d.skier3Class;
    }

    // Update value the record if needed
    public static SkiiingRelay updateLevel(SkiiingRelay d, int pointLimit, int skier1Class, int skier2Class,
            int skier3Class) {
        d.pointLimit = pointLimit;
        d.skier1Class = skier1Class;
        d.skier2Class = skier2Class;
        d.skier3Class = skier3Class;
        return (d);
    }

    //////// ---------- METHODS FOR RECORD FINISHED --------///////////

    // Calculating total value from several integers
    public static int calculateTotal(int skier1Class, int skier2Class, int skier3Class) {
        int total = 0;
        //// Taking 3 integer as arguments and add the sum of all 3 together
        total = skier1Class + skier2Class + skier3Class;
        return total;
    }

    public static int validateInt() {
        int returnTemp;
        int finalTemp;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                returnTemp = sc.nextInt();
                if (returnTemp >= 0) {
                    finalTemp = returnTemp;
                    break;
                } else {
                    System.out.println("The number must be not negative. Please reenter: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please reenter: ");
                sc.next();
            }
        }
        return finalTemp;
    }

    // Print string
    public static void print(String statement) {
        System.out.println(statement);
    }

    // It will take pointLimit and totalRelay as arguments and compared the 2 value
    // to return corresponding value
    public static boolean verifyEligibility(int totalRelay, int pointLimit) {
        // It'll use if..else.. statement to check the condition whether it met or not.
        if (pointLimit < totalRelay) {
            return false;
        } else {
            return true;
        }
    }

    // Print question with iteration about disability class
    public static void printQuestion(int i) {
        System.out.println("What is the disability class of skier " + (i + 1) + "?");
    }

    // Taking input from users and return values in an array
    public static int[] takingInput() {
        // Asking for point limit of relay
        Scanner sc = new Scanner(System.in);
        print("What is the point limit for the relay?");
        int pointLimit = validateInt();
        printQuestion(1);
        int skier1Class = validateInt();
        printQuestion(2);
        int skier2Class = validateInt();
        printQuestion(3);
        int skier3Class = validateInt();
        sc.close();
        int[] Object = new int[] { pointLimit, skier1Class, skier2Class, skier3Class };
        return Object;
    }

    // Main program
    public static void main(String[] args) {

        int[] Object = takingInput();

        SkiiingRelay d = createRecord(Object[0], Object[1], Object[2], Object[3]);

        int totalRelay = calculateTotal(getSkier1Class(d), getSkier2Class(d), getSkier3Class(d));
        boolean isLegal = verifyEligibility(totalRelay, Object[0]);
        if (isLegal) {
            String parameter = ("The total is " + totalRelay + ". As this is a " + Object[0]
                    + " point race, that team is legal.");
            print(parameter);
        } else {
            String parameter = ("The total is " + totalRelay + ". As this is a " + Object[0]
                    + " point race, that team is not legal.");
            print(parameter);
        }
    }
}

// Program ends //