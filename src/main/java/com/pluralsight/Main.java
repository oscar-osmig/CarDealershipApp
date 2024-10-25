package com.pluralsight;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void board(){
        System.out.println("\n1. Find vehicles with a price range " +
                "\n2. Find vehicles by make / model" +
                "\n3. Find vehicles by year range " +
                "\n4. Find vehicles by color" +
                "\n5. Find vehicles by mileage range" +
                "\n6. Find vehicles by type (car, truck, SUV, van)" +
                "\n7. List All vehicles" +
                "\n8. Add a vehicle" +
                "\n9. Remove a vehicle" +
                "\n99. Quit");
    }
    public static void main(String[] args) {

        board();
        System.out.print("Your choice: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> findPriceRange();
            case "2" -> findMakeModel();
            case "3" -> findYearRange();
            case "4" -> findColor();
            case "5" -> findMiileageRange();
            case "6" -> findType();
            case "7" -> listAll();
            case "8" -> addVehicle();
            case "9" -> removeVehicle();
            case "99" -> quit();
            
        }
    }

    private static void removeVehicle() {
    }

    private static void addVehicle() {
    }

    private static void listAll() {
    }

    private static void findType() {
    }

    private static void findMiileageRange() {
    }

    private static void findColor() {
    }

    private static void findYearRange() {
    }

    private static void quit() {
    }

    private static void findPriceRange() {
    }

    private static void findMakeModel() {
    }
}