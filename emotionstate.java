import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class emotionstate {

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

    public static int addMood(int totalMood) {
        totalMood = totalMood + 1;
        return totalMood;
    }

    public static void print(String args) {
        System.out.println(args);
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
                sc.nextLine();
            }
        }
        return todayEmotion;
    }

    public static void main(String[] args) {
        final int loopTime = 100;
        String todayEmotion;
        String adviceForEmotion;
        int totalSad = 0;
        int totalNumb = 0;
        int totalHappy = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= loopTime; i++) {
            print("Are you happy, sad or numb today?");
            todayEmotion = testValidateString();
            adviceForEmotion = emotionAdvice(todayEmotion);
            print(adviceForEmotion);
            if (todayEmotion.equals("sad")) {
                totalSad = totalSad + 1;
            } else if (todayEmotion.equals("numb")) {
                totalNumb = totalNumb + 1;
            } else if (todayEmotion.equals("happy")) {
                totalHappy = totalHappy + 1;
            }
            String finalLine = "Times so far you have been happy (" + totalHappy + "), sad (" + totalSad + "), numb ("
                    + totalNumb + ")";
            print(finalLine);
        }
        sc.close();
    }
}