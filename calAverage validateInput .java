import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class Main {
    public static int[] validateInt(int totalSum) {
        int returnTemp;
        int[] arrayReturn = new int[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Next number to store: ");
        while (true) {
            try {
                returnTemp = sc.nextInt();
                if (returnTemp >= 0) {
                    totalSum = totalSum + returnTemp;
                    break;
                } else {
                    System.out.println("The temperature of the pool must less than or equal to 60. Please reenter: ");
                    sc.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please reenter: ");
                sc.next();
            }
        }
        arrayReturn[0] = returnTemp;
        arrayReturn[1] = totalSum;
        return arrayReturn;
    }

    public static int calAverage(int HOW_MANY, int totalSum) {
        int averageNumb = Math.round(totalSum / HOW_MANY);
        return averageNumb;
    }

    public static void main(String[] args) {
        final int HOW_MANY = 3;
        int[] wombat = new int[HOW_MANY];
        int[] arrayReturn = new int[2];
        int totalSum = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < HOW_MANY; i++) {
            // sc.hasNextInt();
            arrayReturn = validateInt(totalSum);
            wombat[i] = arrayReturn[0];
            totalSum = arrayReturn[1];
        }
        sc.close();

        System.out.println("Printing all the values input...");

        for (int i = 0; i < HOW_MANY; i++) {
            System.out.println(wombat[i]);
        }

        int averageNumb = calAverage(HOW_MANY, totalSum);

        System.out.println("Average score is: " + averageNumb);
    }
}