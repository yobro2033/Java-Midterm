import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Main {

    // a method to validate the integer input
    public static int validateInt() {
        int returnTemp;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                returnTemp = sc.nextInt();
                // It will make sure that the integer input is also greater than 0
                if (returnTemp > 0) {
                    break;
                } else {
                    // Otherwise it will ask the user to re enter the value
                    print("The number input must be greater than 0, please reenter: ");
                    sc.nextInt();
                }
            } catch (InputMismatchException e) {
                // If there is any error in input such as enter string or different values, it
                // will then show error and ask to reenter
                print("Invalid input. Please reenter: ");
                sc.next();
            }
        }
        return returnTemp;
    }

    // a method to calculate the ratio between right and number of turn
    public static double calRatio(int currentTurn, int totalRight) {
        double averageNumb = (double) totalRight / (double) currentTurn;
        return averageNumb; // return value in double
    }

    // a method to get random value inside an array and return the value
    public static String getRandom(String[] sportsArray) {
        int randNumb = new Random().nextInt(sportsArray.length); // using Random library to randomly selected value
                                                                 // within an array declared
        return sportsArray[randNumb]; // return value that selected
    }

    // a method to add number of right or wrong to the total
    public static int counter(int totalCount) {
        totalCount = totalCount + 1;
        return totalCount; // return value after incremented the total by 1
    }

    // a method to print out a string
    public static void print(String args) {
        System.out.println(args);
    }

    // a method to validate the String input
    public static String validateStr() {
        String returnTemp = "N/A"; // the value initialised as none but at the end of program it will return input
                                   // from users entered
        Scanner sc = new Scanner(System.in); // scanner for getting input
        boolean valid = false;
        returnTemp = sc.nextLine();
        do {
            // It will attempt to check whether the input matched one of the 3 sports shown,
            // if not it will ask to re-enter
            if (returnTemp.equals("hockey") || returnTemp.equals("netball") || returnTemp.equals("football")) {
                valid = true;
                break;
            } else {
                print("Please enter correct sports listed. Please reenter: ");
                returnTemp = sc.nextLine(); // retry due to sports not listed
            }
        } while (!valid);
        return returnTemp;
    }

    public static void midterm(String[] args) {
        String[] sportsList = { "football", "netball", "hockey" }; // initialised the sports array that included 3
                                                                   // sports in the game
        // intialised variable will be used through this method
        String randomSports;
        String guessVal;
        String txtOut;
        int totalRight = 0;
        int totalWrong = 0;
        double ratioWin;

        Scanner sc = new Scanner(System.in); // scanner for getting input
        print("Number of turns? (>0)"); // ask for number of turns user wanted to play
        int numberOfTurns = validateInt(); // taking number of turns

        // perform a for loop with the number of times accordingly to the user input
        for (int i = 0; i < numberOfTurns; i++) {
            int currentTurn = i + 1; // variable to show the current turn because the loop will start at 0 but turn
                                     // start at 1
            randomSports = getRandom(sportsList);
            print("Am I thinking of football, netball or hockey? [Enter the word]");
            guessVal = validateStr(); // attempting to ask user for the input sports
            // checking whether the input from users matched the sports that randomly
            // selected by program
            if (guessVal.equals(randomSports)) {
                print("Right!"); // if it is true then it will print Right! and incremented the totalRight by 1
                totalRight = counter(totalRight);
            } else {
                txtOut = "Wrong, I was thinking of " + randomSports; // if it is wrong then it will print Wrong! and
                                                                     // displayed the sports that it was selected
                print(txtOut);
                totalWrong = counter(totalWrong); // the value of totalWrong will also incremented by 1
            }
            ratioWin = calRatio(currentTurn, totalRight); // it will then calculate the ratio value for each turn
            txtOut = "Out of " + currentTurn + " turns, you were right " + totalRight + " times, so a ratio of "
                    + ratioWin;
            print(txtOut); // and display how many times win against how many rounds already played as well
                           // as the ratio in double
        }
        sc.close(); // close scanner
        txtOut = "You were right " + totalRight + " times and wrong " + totalWrong + " times!";
        // print out the total right and wrong and end the game
        print(txtOut);
    }
}