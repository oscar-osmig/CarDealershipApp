package com.pluralsight.dealership;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static boolean run = true;

    public static void board(){
        System.out.print(
               """
               \s
                1. Find vehicles with a price range \
               \s
                2. Find vehicles by make && model\
               \s
                3. Find vehicles by year range \
               \s
                4. Find vehicles by color\
               \s
                5. Find vehicles by mileage range\
               \s
                6. Find vehicles by type (car, truck, SUV, van)\
               \s
                7. List All vehicles\
               \s
                8. Add a vehicle\
               \s
                9. Remove a vehicle\
               \s
                99. Quit
               \s
               """);
    }

    public static void runApp() throws IOException {
        do {

            board();

            System.out.print("\nYour choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> UserInterface.findPriceRange(); // done
                case "2" -> UserInterface.findMakeModel(); // done
                case "3" -> UserInterface.findYearRange(); // done
                case "4" -> UserInterface.findColor(); // done
                case "5" -> UserInterface.findMileageRange(); // done
                case "6" -> UserInterface.findType(); // done
                case "7" -> UserInterface.listAll(); // done
                case "8" -> UserInterface.addVehicle(); // done
                case "9" -> UserInterface.removeVehicle(); // done
                case "99" -> UserInterface.quit(); // done
                default -> {
                    System.out.println("\nPlease choose and available option . . . ");
                    runApp();
                }
            }
        }while (run == UserInterface.quit());
    }

    public static void main(String[] args) throws IOException {

        runApp();
    }


}