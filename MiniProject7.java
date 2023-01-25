// Quoc Viet Phan
// 220364926
// Mini-coursework
// Sun 9 Oct
// Jurassic Park game

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.*;

// The program will start to ask users to put the number of dinosaurs wished to be played in the game
// It'll then ask the users to input the name following the previous input of number of dinosaurs
// Everytime the users put the name, the program will automatically generate the random value from 1-5 for anger level and hunger level
// After that it'll randomly select 1 of the dinosaurs from the list and calculate the danger level
// Danger level classified as 4 level (0-4, 5-6, 7-9 and 10 which is highest)
// As the level reached highest, the game will be ended
// Otherwise, the users will have an option to play with the dinosaurs includes feed etc...
// The anger level can increase or decrease following the option chose

// Create and define new record
class Dinosaur {
    int position;
    String currentDinosaur; // The Students full name
    int currentAnger; // Their unique ID number
    int currentHunger; // their coursework mark /50
    int dangerLvl; // their exam mark /50
    String favouriteFood;
    String favouritePlay;
    String favouriteExercise;
}

public class MiniProject7 {

    public static boolean verifySession() {
        boolean oldSession;
        Scanner sc = new Scanner(System.in);
        System.out.println("Have you play before (Y/N)? ");
        String answer = sc.nextLine(); // Collecting input
        if (answer.equals("Y")) {
            oldSession = true;
        } else {
            oldSession = false;
        }
        return oldSession;
    }

    // To create a student BOTH a name and position from OG array must be presented
    // The list of any other attributes rather than position and name of the
    // dinasaur will be set to either N/A for String or 0 for Int
    public static Dinosaur createDinosaur(int position, String currentDinosaur, int currentAnger, int currentHunger,
            int dangerLvl, String favouriteFood, String favouritePlay, String favouriteExercise) {
        Dinosaur d = new Dinosaur();
        d.position = position;
        d.currentDinosaur = currentDinosaur;
        d.currentAnger = currentAnger;
        d.currentHunger = currentHunger;
        d.dangerLvl = dangerLvl;
        d.favouriteFood = favouriteFood;
        d.favouritePlay = favouritePlay;
        d.favouriteExercise = favouriteExercise;
        return (d);
    }

    // Method attempting to create new file text
    public static int[] readFileIntArray(int numb, String[] listDatabase) {
        String arr = listDatabase[4];
        String[] items = arr.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        int[] dataListReturn = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            try {
                dataListReturn[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                System.out.println("ERROR");
            }
            ;
        }
        return dataListReturn;
    }

    public static String[] readFileStringArray(int numb, String[] listDatabase) {
        String arr = listDatabase[2];
        String[] items = arr.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "").split(",");

        String[] dataListReturn = new String[items.length];

        for (int i = 0; i < items.length; i++) {
            try {
                dataListReturn[i] = items[i];
            } catch (NumberFormatException nfe) {
                System.out.println("ERROR");
            }
            ;
        }
        return dataListReturn;
    }

    public static int readFileInt(int numb, String[] listDatabase) {
        int dataReturn = Integer.parseInt(listDatabase[numb]);
        return dataReturn;
    }

    public static void writeFile(int roundLeft, String[] dinosaursList, int[] angryLvlList, int[] hungryLvlList,
            Dinosaur[] dinosaursRecordArray, int numberOfDinosaurs) throws IOException {

        PrintWriter outputStream = new PrintWriter(new FileWriter("dinosaurs.txt"));
        int[] positionArray = new int[2];
        String[] currentDinosaurArray = new String[2];
        int[] currentAngerArray = new int[2];
        int[] currentHungerArray = new int[2];
        int[] dangerLvlArray = new int[2];
        String[] favouriteFoodArray = new String[2];
        String[] favouritePlayArray = new String[2];
        String[] favouriteExerciseArray = new String[2];
        for (int i = 0; i < 2; i++) {
            Dinosaur currentDinosaur = dinosaursRecordArray[i];
            positionArray[i] = getPosition(currentDinosaur);
            currentDinosaurArray[i] = getName(currentDinosaur);
            currentAngerArray[i] = getAngerLvl(currentDinosaur);
            currentHungerArray[i] = getHungerLvl(currentDinosaur);
            dangerLvlArray[i] = getDangerLvl(currentDinosaur);
            favouriteFoodArray[i] = getFavFood(currentDinosaur);
            favouritePlayArray[i] = getFavPlay(currentDinosaur);
            favouriteExerciseArray[i] = getFavExercise(currentDinosaur);
        }
        outputStream.println(String.valueOf(roundLeft));
        outputStream.println(String.valueOf(numberOfDinosaurs));
        outputStream.println(Arrays.toString(dinosaursList));
        outputStream.println(Arrays.toString(angryLvlList));
        outputStream.println(Arrays.toString(hungryLvlList));
        outputStream.println(Arrays.toString(positionArray));
        outputStream.println(Arrays.toString(currentDinosaurArray));
        outputStream.println(Arrays.toString(currentAngerArray));
        outputStream.println(Arrays.toString(currentHungerArray));
        outputStream.println(Arrays.toString(dangerLvlArray));
        outputStream.println(Arrays.toString(favouriteFoodArray));
        outputStream.println(Arrays.toString(favouritePlayArray));
        outputStream.println(Arrays.toString(favouriteExerciseArray));
        outputStream.close();
        System.out.println("Wrote to a File successfully");
    }

    public static String[] retrieveFile() {
        String[] listDatabase = new String[12];
        // for-each loop for calculating heat index of May - October
        // create Scanner inFile1
        BufferedReader inputStream = new BufferedReader(new FileReader("dinosaurs.txt"));

        try {
            int i = 0;
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                listDatabase[i] = line;
                i++;
            }
        } catch (Exception e) {
            print("File cannot be read!");
        }
        return listDatabase;
    }

    // Method attempting to create new file text
    public static Dinosaur[] readFileRecord(String[] listDatabase) {
        Dinosaur[] dinosaursRecordArray = new Dinosaur[2];
        try {
            int[] positionArray = readFileIntArray(5, listDatabase);
            String[] currentDinosaurArray = readFileStringArray(6, listDatabase);
            int[] currentAngerArray = readFileIntArray(7, listDatabase);
            int[] currentHungerArray = readFileIntArray(8, listDatabase);
            int[] dangerLvlArray = readFileIntArray(9, listDatabase);
            String[] favouriteFoodArray = readFileStringArray(10, listDatabase);
            String[] favouritePlayArray = readFileStringArray(11, listDatabase);
            String[] favouriteExerciseArray = readFileStringArray(12, listDatabase);
            int count = 1;
            for (int i = 0; i < 2; i++) {
                int position = (int) positionArray[i];
                String currentDinosaur = (String) currentDinosaurArray[i];
                int currentAnger = (int) currentAngerArray[i];
                int currentHunger = (int) currentHungerArray[i];
                int dangerLvl = (int) dangerLvlArray[i];
                String favouriteFood = (String) favouriteFoodArray[i];
                String favouritePlay = (String) favouritePlayArray[i];
                String favouriteExercise = (String) favouriteExerciseArray[i];
                Dinosaur d = createDinosaur(position, currentDinosaur, currentAnger, currentHunger, dangerLvl,
                        favouriteFood, favouritePlay, favouriteExercise); // Create new records

                dinosaursRecordArray[count - 1] = d;
                count = count + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dinosaursRecordArray;
    }

    // Getter methods for Dinosaur
    // Return the list of attributes from dinosaur record
    // Return Name
    public static String getName(Dinosaur d) {
        return d.currentDinosaur;
    }

    // Return FavFood
    public static String getFavFood(Dinosaur d) {
        return d.favouriteFood;
    }

    // Return FavPlay
    public static String getFavPlay(Dinosaur d) {
        return d.favouritePlay;
    }

    // Return FavExcerise
    public static String getFavExercise(Dinosaur d) {
        return d.favouriteExercise;
    }

    // Return position of dinosaurs from original array
    public static int getPosition(Dinosaur d) {
        return d.position;
    }

    // Return hunger level
    public static int getHungerLvl(Dinosaur d) {
        return d.currentHunger;
    }

    // Return anger level
    public static int getAngerLvl(Dinosaur d) {
        return d.currentAnger;
    }

    // This is the danger level
    public static int getDangerLvl(Dinosaur d) {
        return d.dangerLvl;
    }

    // Set the level of Anger/ Hunger/ Danger whenever neccessarily
    // returning the updated record
    public static Dinosaur updateLevel(Dinosaur d, int currentAnger, int currentHunger, int dangerLvl) {
        d.currentAnger = currentAnger;
        d.currentHunger = currentHunger;
        d.dangerLvl = dangerLvl;
        return (d);
    }

    //////// ---------- METHODS FOR RECORD FINISHED --------///////////

    // Method generate the level of anger and hunger
    public static int getExpressionLvl() {
        int max = 4; // Maxium level (Ensure the danger level not 10 at the start)
        int min = 2; // Minium level
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    public static int getRoundsNumber() {
        int max = 6; // Maxium level (Ensure the danger level not 10 at the start)
        int min = 4; // Minium level
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }

    // Method of getting random adjective for display
    public static String getRandom(String[] args) {
        int rnd = new Random().nextInt(args.length); // Random get the position in the array
        return args[rnd]; // Get the corresponding adjectives from the position
    }

    // Method of getting the position from a list by randomly selected
    public static int getPositionRandom(String[] dinosaursList) {
        int rnd = new Random().nextInt(dinosaursList.length); // Random selecting the position in the array
        return rnd;
    }

    // Method of adding new elements into the array (dinosaurs name)
    public static String[] addNewDinosaur(String[] dinosaursList, String dinosaurName) {
        String[] returnArray = new String[dinosaursList.length + 1]; // Create a dummy array

        for (int i = 0; i < dinosaursList.length; i++) {
            returnArray[i] = dinosaursList[i];
        }

        returnArray[returnArray.length - 1] = dinosaurName; // Add the new element to dummy array
        return returnArray;
    }

    // Method adding new elements into the array (Hunger/ Anger)
    public static int[] addExpressionList(int[] args) {
        int expressionLvl = 0;
        expressionLvl = getExpressionLvl(); // Generate an value for hunger/ anger
        int[] returnArray = new int[args.length + 1]; // Create dummy array

        for (int i = 0; i < args.length; i++) {
            returnArray[i] = args[i];
        }

        returnArray[returnArray.length - 1] = expressionLvl; // Add new value to dummy array
        return returnArray;
    }

    // Method of calculating the dangerous level from anger and hunger level
    public static int calculateDangerousLvl(int currentAnger, int currentHunger) {
        int dangerLvl = 0;
        dangerLvl = currentAnger + currentHunger; // Add both hunger and anger level
        return dangerLvl;
    }

    // Main program
    public static void main(String[] args) {

        String dinosaurName;

        Scanner sc = new Scanner(System.in);

        System.out.println("What's your name? ");
        String username = sc.nextLine(); // Collecting input
        System.out.println("Welcome to Jurassic Park Game, " + username);
        int numberOfDinosaurs = 0;
        boolean checkPreviousSession = verifySession();
        if (checkPreviousSession == true) {
            String[] listDatabase = retrieveFile();
            numberOfDinosaurs = readFileInt(1, listDatabase);
        } else {
            System.out.println("Please select from number of dinosaurs you wished to take care (5-10): ");
            numberOfDinosaurs = sc.nextInt();
        }

        // Create an array
        String[] dinosaursList = new String[numberOfDinosaurs];
        int[] angryLvlList = new int[numberOfDinosaurs];
        int[] hungryLvlList = new int[numberOfDinosaurs];

        int roundNumber = getRoundsNumber();
        if (checkPreviousSession == true) {
            String[] listDatabase = retrieveFile();
            roundNumber = readFileInt(0, listDatabase);
            hungryLvlList = readFileIntArray(0, listDatabase);
            angryLvlList = readFileIntArray(0, listDatabase);
            dinosaursList = readFileStringArray(0, listDatabase);
        } else {

            // Looping to ask for users the dinosaurs name and generate anger/hunger level
            int count = 0;
            for (int i = 0; i < numberOfDinosaurs; i++) {
                String[] describeAdj = { "small", "carnivorous", "old", "giant", "huge", "largest", "armored", "horned",
                        "herbivorous", "bipedal", "feathered", "biggest", "oldest", "primitive", "parochial",
                        "gigantic",
                        "ornithischian", "predatory", "ceratopsian", "enormous", "plated", "cretaceous", "stuffed",
                        "armoured", "saurischian", "legged", "headed", "famous", "friendly", "longest", "ostrich",
                        "mighty",
                        "crested", "necked", "intelligent", "lumbering" };
                count = count + 1;
                System.out.println("Please enter your number " + count + " dinosaur: ");
                dinosaurName = sc.next();
                angryLvlList[i] = getExpressionLvl();
                hungryLvlList[i] = getExpressionLvl();
                dinosaursList[i] = dinosaurName;
                System.out.println(dinosaurName + " are " + getRandom(describeAdj));
            }
        }

        //////// FIRST FILE NEED TO BE CREATED WILL BE THE LIST OF ALL DINOSAURS CREATED
        //////// It will include main object Dinosaurs, it will loop to each container
        //////// include name, hungry level and angry level.
        //////// SECOND FILE WILL BE THE 2 DINOSAURS CURRENTLY PLAYING
        //////// It will include the number of rounds left, name, anger level, hunger
        //////// level, danger level, favourite food, favourite excersie and position

        for (int currentRound = 0; currentRound < roundNumber; currentRound++) {
            int i = 0;
            int roundLeft = roundNumber - currentRound;
            Dinosaur[] dinosaursRecordArray = new Dinosaur[2]; // Create a new array for Dinosaurs with Dinosaur type

            // While loop to play the game
            // Declare variables
            final int maxExpressionLvl = 5;
            final int minExpressionLvl = 0;
            int dangerLvl;
            int option;
            String currentDinosaur = "None";
            int position = 0;
            int currentAnger = 0;
            int currentHunger = 0;
            int activitiesOption;
            String favouriteFood;
            String favouritePlay;
            String favouriteExercise;

            // Declare and initialised the array of values such as food/ activities that
            // will later be used randomly assigned to each dinosaur
            String[] foodList = { "Meat", "Insects", "Vegetable", "Bird", "Fish", "tree", "Fruit" };
            String[] playList = { "Play game", "Play ball", "Play with water", "Play with others", "Listen to Music",
                    "Watch movie" };
            String[] exerciseList = { "Run", "Walk", "Jump", "Swim" };

            // Loop to choose 2 dinosaurs each round
            if (checkPreviousSession == false) {
                int count = 0;
                count = count + 1;
                if (count == 1) {
                    position = getPositionRandom(dinosaursList); // Randomly getting the position of a random dinosour
                                                                 // in
                    // the array
                    currentDinosaur = dinosaursList[position]; // Get the current Dinosour name
                    currentAnger = angryLvlList[position]; // Get the current Anger level
                    currentHunger = hungryLvlList[position]; // Get the current Hunger level
                    System.out.println(count + ". The dinosaur is: " + currentDinosaur + ". It current anger level is "
                            + currentAnger + " and hunger is " + currentHunger);
                    dangerLvl = calculateDangerousLvl(currentAnger, currentHunger); // Recalculate dangerous level
                    favouriteFood = getRandom(foodList);
                    favouritePlay = getRandom(playList);
                    favouriteExercise = getRandom(exerciseList);
                    Dinosaur d = createDinosaur(position, currentDinosaur, currentAnger, currentHunger, dangerLvl,
                            favouriteFood, favouritePlay, favouriteExercise); // Create new records

                    dinosaursRecordArray[count - 1] = d;
                    count = count + 1;
                }
                if (count == 2) {
                    if (position == (dinosaursList.length - 1)) {
                        position = 0;
                    } else {
                        position = position + 1;
                    }
                    currentDinosaur = dinosaursList[position]; // Get the current Dinosour name
                    currentAnger = angryLvlList[position]; // Get the current Anger level
                    currentHunger = hungryLvlList[position]; // Get the current Hunger level
                    System.out.println(count + ". The dinosaur is: " + currentDinosaur + ". It current anger level is "
                            + currentAnger + " and hunger is " + currentHunger);
                    dangerLvl = calculateDangerousLvl(currentAnger, currentHunger); // Recalculate dangerous level
                    favouriteFood = getRandom(foodList);
                    favouritePlay = getRandom(playList);
                    favouriteExercise = getRandom(exerciseList);
                    Dinosaur d = createDinosaur(position, currentDinosaur, currentAnger, currentHunger, dangerLvl,
                            favouriteFood, favouritePlay, favouriteExercise); // Create new records

                    dinosaursRecordArray[count - 1] = d;
                }
            } else {
                String[] listDatabase = retrieveFile();
                dinosaursRecordArray = readFileRecord(listDatabase);
                for (int looprec = 0; looprec < 2; looprec++) {
                    currentDinosaur = getName(dinosaursRecordArray[looprec]);
                    currentAnger = getAngerLvl(dinosaursRecordArray[looprec]);
                    currentHunger = getHungerLvl(dinosaursRecordArray[looprec]);
                    System.out.println(
                            looprec + 1 + ". The dinosaur is: " + currentDinosaur + ". It current anger level is "
                                    + currentAnger + " and hunger is " + currentHunger);
                    dangerLvl = calculateDangerousLvl(currentAnger, currentHunger);
                    favouriteFood = getFavFood(dinosaursRecordArray[looprec]);
                    favouritePlay = getFavPlay(dinosaursRecordArray[looprec]);
                    favouriteExercise = getFavExercise(dinosaursRecordArray[looprec]);
                }
            }

            ///// ENSURE NOT DUP FOR GET RANDOM POS
            // Sub Round 8 turns
            for (int subRound = 0; subRound < 8; subRound++) {
                System.out.println("Please type number of the dinosaur you want to take care: "); // Only 1 dinosaur
                                                                                                  // will
                                                                                                  // be
                                                                                                  // displayed at a
                                                                                                  // time,
                                                                                                  // it'll ask to choose
                                                                                                  // one
                                                                                                  // of them
                int dinosaurOption = sc.nextInt();

                Dinosaur d;
                if (dinosaurOption == 1) {
                    d = dinosaursRecordArray[0];
                } else {
                    d = dinosaursRecordArray[1];
                }

                // Get attributes from the record of the dinosaur selected
                currentDinosaur = getName(d); // d.currentDinosaur
                favouriteFood = getFavFood(d); // d.favouriteFood
                favouritePlay = getFavPlay(d); // d.favouritePlay
                favouriteExercise = getFavExercise(d); // d.favouriteExercise
                position = getPosition(d); // d.position
                currentHunger = getHungerLvl(d); // d.currentHunger
                dangerLvl = getDangerLvl(d); // d.dangerLvl
                currentAnger = getAngerLvl(d); // d.currentAnger

                // Checking for the danger level and prompted the users for different scenarios
                // depends on the level
                if (dangerLvl <= 3) {
                    System.out.println("Your dinosaur is calm! What do you want to do?"); // First level (CALM)
                    System.out.println("1. Feed, 2. Play, 3. Exercise, 4. Nothing");
                    option = sc.nextInt();
                    // List of options to play game
                    if (option == 1) {
                        for (i = 0; i < foodList.length; i++) {
                            System.out.println(i + ". " + foodList[i]);
                        }
                        System.out.println("Please select an option: ");
                        activitiesOption = sc.nextInt();
                        // It will check whether the food selected by user is fav or not, fav will
                        // reduce the hunger by twice
                        if (foodList[activitiesOption] == favouriteFood) {
                            if (currentHunger > 1) {
                                currentHunger = currentHunger - 2;
                            } else if (currentHunger > minExpressionLvl) {
                                currentHunger = currentHunger - 1; // Ensure the value is not negative
                            }
                            if (currentAnger > minExpressionLvl) {
                                currentHunger = currentHunger - 1; // ^^
                            }
                        } else {
                            if (currentHunger > minExpressionLvl) {
                                currentHunger = currentHunger - 1;
                            }
                        }
                    } else if (option == 2) {
                        for (i = 0; i < playList.length; i++) {
                            System.out.println(i + ". " + playList[i]);
                        }
                        System.out.println("Please select an option: ");
                        activitiesOption = sc.nextInt();
                        // Checking whether the activities is fav which if fav the anger will reduce
                        // twice
                        if (playList[activitiesOption] == favouritePlay) {
                            if (currentAnger > 1) {
                                currentAnger = currentAnger - 2; // Perform simple checking to ensure the value is not
                                                                 // negative
                            } else if (currentAnger > minExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                        } else {
                            if (currentAnger > minExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                        }
                    } else if (option == 3) {
                        for (i = 0; i < exerciseList.length; i++) {
                            System.out.println(i + ". " + exerciseList[i]);
                        }
                        System.out.println("Please select an option: ");
                        activitiesOption = sc.nextInt();
                        // Checking favExercise
                        if (exerciseList[activitiesOption] == favouriteExercise) {
                            if (currentAnger > 1) {
                                currentAnger = currentAnger - 2;
                            } else if (currentAnger > minExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                            if (currentHunger < maxExpressionLvl) {
                                currentHunger = currentHunger + 1;
                            }
                        } else {
                            if (currentAnger > maxExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                            if (currentHunger < maxExpressionLvl) {
                                currentHunger = currentHunger + 1;
                            }
                        }
                    } else {
                        if (currentHunger < maxExpressionLvl) {
                            currentHunger = currentHunger + 1;
                        }
                        if (currentAnger < maxExpressionLvl) {
                            currentAnger = currentAnger + 1;
                        }
                    }
                } else if (dangerLvl <= 6 && dangerLvl >= 4) {
                    System.out.println("Your dinosaur is miffed! What you want to do?"); // Second level (MIFFLED)
                    System.out.println("-----*--*--*-----");
                    System.out.println("1. Feed, 2. Play, 3. Exercise, 4. Nothing");
                    option = sc.nextInt();
                    // List of options to play game
                    if (option == 1) {
                        for (i = 0; i < foodList.length; i++) {
                            System.out.println(i + ". " + foodList[i]);
                        }
                        System.out.println("Please select an option: ");
                        activitiesOption = sc.nextInt();
                        // It will check whether the food selected by user is fav or not, fav will
                        // reduce the hunger by twice
                        if (foodList[activitiesOption] == favouriteFood) {
                            if (currentHunger > 1) {
                                currentHunger = currentHunger - 2;
                            } else if (currentHunger > minExpressionLvl) {
                                currentHunger = currentHunger - 1; // Ensure the value is not negative
                            }
                            if (currentAnger > minExpressionLvl) {
                                currentHunger = currentHunger - 1; // ^^
                            }
                        } else {
                            if (currentHunger > minExpressionLvl) {
                                currentHunger = currentHunger - 1;
                            }
                        }
                    } else if (option == 2) {
                        for (i = 0; i < playList.length; i++) {
                            System.out.println(i + ". " + playList[i]);
                        }
                        System.out.println("Please select an option: ");
                        activitiesOption = sc.nextInt();
                        // Checking whether the activities is fav which if fav the anger will reduce
                        // twice
                        if (playList[activitiesOption] == favouritePlay) {
                            if (currentAnger > 1) {
                                currentAnger = currentAnger - 2; // Perform simple checking to ensure the value is not
                                                                 // negative
                            } else if (currentAnger > minExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                        } else {
                            if (currentAnger > minExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                        }
                    } else if (option == 3) {
                        for (i = 0; i < exerciseList.length; i++) {
                            System.out.println(i + ". " + exerciseList[i]);
                        }
                        System.out.println("Please select an option: ");
                        activitiesOption = sc.nextInt();
                        // Checking favExercise
                        if (exerciseList[activitiesOption] == favouriteExercise) {
                            if (currentAnger > 1) {
                                currentAnger = currentAnger - 2;
                            } else if (currentAnger > minExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                            if (currentHunger < maxExpressionLvl) {
                                currentHunger = currentHunger + 1;
                            }
                        } else {
                            if (currentAnger > minExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                            if (currentHunger < maxExpressionLvl) {
                                currentHunger = currentHunger + 1;
                            }
                        }
                    } else {
                        if (currentHunger < maxExpressionLvl) {
                            currentHunger = currentHunger + 1;
                        }
                        if (currentAnger < maxExpressionLvl) {
                            currentAnger = currentAnger + 1;
                        }
                    }
                } else if (dangerLvl <= 9 && dangerLvl >= 7) {
                    System.out.print("Your dinosaur is dangerous! Try make it happier!!!"); // Third level (Dangerous)
                    System.out.println("1. Feed, 2. Play, 3. Exercise, 4. Nothing");
                    option = sc.nextInt();
                    // List of options to play game
                    if (option == 1) {
                        for (i = 0; i < foodList.length; i++) {
                            System.out.println(i + ". " + foodList[i]);
                        }
                        System.out.println("Please select an option: ");
                        activitiesOption = sc.nextInt();
                        // It will check whether the food selected by user is fav or not, fav will
                        // reduce the hunger by twice
                        if (foodList[activitiesOption] == favouriteFood) {
                            if (currentHunger > 1) {
                                currentHunger = currentHunger - 2;
                            } else if (currentHunger > minExpressionLvl) {
                                currentHunger = currentHunger - 1; // Ensure the value is not negative
                            }
                            if (currentAnger > minExpressionLvl) {
                                currentHunger = currentHunger - 1; // ^^
                            }
                        } else {
                            if (currentHunger > minExpressionLvl) {
                                currentHunger = currentHunger - 1;
                            }
                        }
                    } else if (option == 2) {
                        for (i = 0; i < playList.length; i++) {
                            System.out.println(i + ". " + playList[i]);
                        }
                        System.out.println("Please select an option: ");
                        activitiesOption = sc.nextInt();
                        // Checking whether the activities is fav which if fav the anger will reduce
                        // twice
                        if (playList[activitiesOption] == favouritePlay) {
                            if (currentAnger > 1) {
                                currentAnger = currentAnger - 2; // Perform simple checking to ensure the value is not
                                                                 // negative
                            } else if (currentAnger > 0) {
                                currentAnger = currentAnger - 1;
                            }
                        } else {
                            if (currentAnger > 0) {
                                currentAnger = currentAnger - 1;
                            }
                        }
                    } else if (option == 3) {
                        for (i = 0; i < exerciseList.length; i++) {
                            System.out.println(i + ". " + exerciseList[i]);
                        }
                        System.out.println("Please select an option: ");
                        activitiesOption = sc.nextInt();
                        // Checking favExercise
                        if (exerciseList[activitiesOption] == favouriteExercise) {
                            if (currentAnger > 1) {
                                currentAnger = currentAnger - 2;
                            } else if (currentAnger > minExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                            if (currentHunger < maxExpressionLvl) {
                                currentHunger = currentHunger + 1;
                            }
                        } else {
                            if (currentAnger > minExpressionLvl) {
                                currentAnger = currentAnger - 1;
                            }
                            if (currentHunger < maxExpressionLvl) {
                                currentHunger = currentHunger + 1;
                            }
                        }
                    } else {
                        if (currentHunger < maxExpressionLvl) {
                            currentHunger = currentHunger + 1;
                        }
                        if (currentAnger < maxExpressionLvl) {
                            currentAnger = currentAnger + 1;
                        }
                    }
                }
                angryLvlList[position] = currentAnger; // Rechecking the current Anger level
                hungryLvlList[position] = currentHunger; // Rechecking the current Hunger level
                // Loop to access an array checking for the dinosaur and display the new danger
                // level value
                dangerLvl = calculateDangerousLvl(currentAnger, currentHunger);
                d = updateLevel(d, currentAnger, currentHunger, dangerLvl);
                System.out.println("Your dinosaur " + currentDinosaur + " has current danger level is " + dangerLvl);
                if (dangerLvl == 10) {
                    System.out.println("Your dinosaur is a KILLER! RUNNNNNNNN!!!"); // Final level (KILLER) Game ended
                    System.out.println(username + ", you lose the game.");
                    sc.close();
                    System.exit(0);
                }
                System.out.println("Do you want to stop and save session (Y/N)?");
                sc.nextLine();
                String answer = sc.nextLine(); // Collecting input
                if (answer.equals("Y")) {
                    try {
                        writeFile(roundLeft, dinosaursList, angryLvlList, hungryLvlList, dinosaursRecordArray,
                                numberOfDinosaurs);
                        sc.close();
                        System.exit(0);
                    } catch (IOException e) {
                        System.exit(0);
                    }
                } else {
                    System.out.println("Continue!");
                }
            }
        }
        sc.close();
        System.out.println(username + ", YOU WON THE GAME!");
    }
}

// Program ends //