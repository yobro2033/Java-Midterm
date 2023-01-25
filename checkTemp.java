import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class checkTemp {

    public static String checkPoolName(String poolName) {
        String poolInfo;
        if (poolName.equals("High Dive") | poolName.equals("Springboard") | poolName.equals("Race Pool")) {
            poolInfo = "is in the Olympic building. What was the water temperature?";
        } else if (poolName.equals("Family Pool") | poolName.equals("Jacuzzi 1") | poolName.equals("Jacuzzi 2")
                | poolName.equals("Toddler Pool")) {
            poolInfo = "is in the Main building. What was the water temperature?";
        } else {
            poolInfo = "unknown.";
        }
        return poolInfo;
    }

    public static int getLowestTemp(int currentLowestTemp, int currentTemp) {
        int returnTemp = 0;
        if (currentTemp < currentLowestTemp) {
            returnTemp = currentTemp;
        } else {
            returnTemp = currentLowestTemp;
        }
        return returnTemp;
    }

    public static void print(String args) {
        System.out.println(args);
    }

    public static String testValidateString() {
        String poolName;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                poolName = sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                print("Invalid input. Please reenter: ");
                sc.nextLine();
            }
        }
        return poolName;
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
        final int lastTime = 11;
        String poolName;
        String poolInfo;
        int currentLowestTemp = 60;
        int currentTemp;

        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= lastTime; i++) {
            String timeText = i + " PM:";
            print(timeText);
            print("Which pool did you check?");
            poolName = testValidateString();
            poolInfo = checkPoolName(poolName);
            if (poolInfo.equals("unknown.")) {
                String infoText = "That pool is " + poolInfo;
                print(infoText);
            } else {
                String infoText = "The " + poolName + " " + poolInfo;
                print(infoText);
                currentTemp = validateInt();
                currentLowestTemp = getLowestTemp(currentLowestTemp, currentTemp);
            }
        }
        sc.close();
        String argsString = "The lowest water temperature today was " + currentLowestTemp + " degrees.";
        print(argsString);
    }
}