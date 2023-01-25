import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class bottlessong {

    public static String emotionAdvice(String todayEmotion) {
        String adviceForEmotion = "None";
        if (todayEmotion.equals("happy")) {
            adviceForEmotion = "Say something nice to a random person on a train today.";
        } else if (todayEmotion.equals("numb")) {
            adviceForEmotion = "Feel the way your foot feels on the ground with every step today.";
        } else if (todayEmotion.equals("sad")) {
            adviceForEmotion = "Stop, close your eyes and feel the sun on your face today.";
        } else {
            adviceForEmotion = "I’m sorry I do not know that mood.";
        }
        return adviceForEmotion;
    }

    public static int minusVal(int totalBottlesLeft, int stepReduceTwice) {
        if (totalBottlesLeft == stepReduceTwice) {
            totalBottlesLeft = totalBottlesLeft - 2;
        } else {
            totalBottlesLeft = totalBottlesLeft - 1;
        }
        return totalBottlesLeft;
    }

    public static void print(String args) {
        System.out.println(args);
    }

    public static void printLoop(int number) {
        for (int i = 0; i < 2; i++) {
            String textString = number + " blue bottles sitting on the wall.";
            System.out.println(textString);
        }
    }

    public static String testValidateString() {
        String todayEmotion;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                todayEmotion = sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                print("Invalid input. Please reenter: ");
                sc.next();
            }
        }
        return todayEmotion;
    }

    public static int validateInt() {
        int returnTemp;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                returnTemp = sc.nextInt();
                if (returnTemp <= 60) {
                    break;
                } else {
                    print("The temperature of the pool must less than or equal to 60. Please reenter: ");
                    sc.nextInt();
                }
            } catch (InputMismatchException e) {
                print("Invalid input. Please reenter: ");
                sc.next();
            }
        }
        return returnTemp;
    }

    public static void main(String[] args) {
        int totalBottlesLeft1 = 0;
        Scanner sc = new Scanner(System.in);
        print("How many bottles should I start with?");
        int totalBottlesLeft = validateIntTest();
        int loopCount = totalBottlesLeft;
        print("At what step should 2 bottles go?");
        int stepReduceTwice = validateIntTest();
        while (stepReduceTwice < 2) {
            print("The input you're trying unable to process please try higher value!");
            print("At what step should 2 bottles go?");
            stepReduceTwice = validateInt();
            if (stepReduceTwice < 2) {
                sc.nextInt();
            } else {
                break;
            }
        }
        String txtString = "N/A";

        for (int i = 1; i < loopCount; i++) {
            if (totalBottlesLeft == stepReduceTwice) {
                printLoop(totalBottlesLeft);
                print("and if 2 blue bottles should accidentally fall.");
                totalBottlesLeft1 = minusVal(totalBottlesLeft, stepReduceTwice);
                txtString = "There are " + totalBottlesLeft1 + " blue bottles sitting on the wall.";
                print(txtString);
                totalBottlesLeft = totalBottlesLeft1;
            } else {
                printLoop(totalBottlesLeft);
                print("and if 1 blue bottles should accidentally fall.");
                totalBottlesLeft1 = minusVal(totalBottlesLeft, stepReduceTwice);
                txtString = "There are " + totalBottlesLeft1 + " blue bottles sitting on the wall.";
                print(txtString);
                totalBottlesLeft = totalBottlesLeft1;
            }
        }
        sc.close();
        print("The END.");
    }
}