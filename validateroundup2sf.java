import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class validateroundup2sf {

    public static String checkTravelAgent(String travelAgent) {
        String hotelInfo;
        if (travelAgent.equals("CheapTravel")) {
            hotelInfo = "TouristLodge";
        } else if (travelAgent.equals("NewHorizons")) {
            hotelInfo = "Raffles";
        } else if (travelAgent.equals("RouteFinders")) {
            hotelInfo = "AirHTL";
        } else {
            hotelInfo = "None";
        }
        return hotelInfo;
    }

    // Function round up 2 sigf
    // Function round up 2 sigf
    // Function round up 2 sigf
    // Function round up 2 sigf
    // Function round up 2 sigf
    // Function round up 2 sigf
    public static double calculatePercentage(int totalCustomer, int args) {
        double totalCus = (double) totalCustomer;
        double percentage = (double) Math.round((args / totalCus) * 10000.0) / 100.0;
        return percentage;
    }

    public static int countCustomer(int args) {
        int totalCustomer = args + 1;
        return totalCustomer;
    }

    public static void print(String args) {
        System.out.println(args);
    }

    public static void testValidate() {
        int travelAgent;
        while (true) {
            try {
                travelAgent = sc.nextInt();
                if (travelAgent<3) {
                    break;
                } else {
                    print("You input invalid value, ensure it's greater than etc")
                }
            } catch (InputMismatchException e) {
                print("Invalid input. Please reenter: ");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        final int totalCustomer = 3;
        int totalCheapCus = 0;
        int totalNewCus = 0;
        int totalRouteCus = 0;
        String travelAgent;
        String hotelInfo;

        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= totalCustomer; i++) {
            print(i + ". Hello: what is your travel company?");
            while (true) {
                try {
                    travelAgent = sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    print("Invalid input. Please reenter: ");
                    sc.nextLine();
                }
            }
            // Validate input example
            // Validate input example
            // Validate input example
            // Validate input example
            // Validate input example
            // Validate input example
            while (true) {
                hotelInfo = checkTravelAgent(travelAgent);
                if (hotelInfo.equals("None")) {
                    print(hotelInfo);
                    print("Invalid input. Please reenter: ");
                    while (true) {
                        try {
                            travelAgent = sc.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            print("Invalid input. Please reenter: ");
                            travelAgent = sc.nextLine();
                        }
                    }
                } else {
                    break;
                }
            }

            print("You must go to the " + hotelInfo + " hotel.");
            if (hotelInfo.equals("TouristLodge")) {
                totalCheapCus = countCustomer(totalCheapCus);
            } else if (hotelInfo.equals("Raffles")) {
                totalNewCus = countCustomer(totalNewCus);
            } else {
                totalRouteCus = countCustomer(totalRouteCus);
            }
        }
        sc.close();
        print("Passengers with NewHorizons: " + calculatePercentage(totalCustomer, totalNewCus) + "%");
        print("Passengers with CheapTravel: " + calculatePercentage(totalCustomer, totalCheapCus) + "%");
        print("Passengers with RouteFinders: " + calculatePercentage(totalCustomer, totalRouteCus) + "%");
    }
}